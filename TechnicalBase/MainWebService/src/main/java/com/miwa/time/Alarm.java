package com.miwa.time;

import com.cronutils.model.Cron;
import com.miwa.model.Domain.Callback;
import com.miwa.time.Message.SendMessage;
import com.miwa.time.ParserCron.ParseCron;
import org.joda.time.DateTime;

import java.util.Timer;
import java.util.TimerTask;

public class Alarm{

    //le temps de reveil voulu
    private DateTime Clock;
    private Timer TimerClock;
    private SendMessage message;
    private Callback callback;
    private Cron parse;

    public Alarm(Callback callback) throws Exception {
        parse = ParseCron.GetInstance().parse(callback.getCron());

        TimerClock = new Timer(false);
        message = new SendMessage();
        message.callback = callback;
        this.callback = callback;

        refresh();
    }

    public DateTime getClock() {
        return Clock;
    }

    public void setClock(DateTime clock) {
        Clock = clock;
        refresh();
    }

    public Callback getCallback() {
        return callback;
    }

    public void stopAlarm(){
        TimerClock.cancel();

        TimeManager.GetInstance().deleteAlarmStopped(getCallback().getCallbackid());
    }

    public void refresh() {
        TimerClock.cancel();
        TimerClock = new Timer(false);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                message.send();
                refresh();
            }
        };

        DateTime nowVirtual = TimeManager.GetInstance().calculatedSpeedTime();

        Clock = ParseCron.GetInstance()
                .nextExecution(nowVirtual, parse);

        if (getClock() == null){
            stopAlarm();
        }

        DateTime time = TimeManager.GetInstance().virtualToReal(getClock());
//        System.out.println("Nouvelle execution virtuelle : " + Clock + " |  virtual date : " + TimeManager.GetInstance().getCurrentDate()
//                + "   |   Nouvelle execution : " + time + "   |   Now : " + new DateTime());

        TimerClock.schedule(task, time.toDate());
    }

    public SendMessage getMessage() {
        return message;
    }

    public void setMessage(SendMessage message) {
        this.message = message;
    }

    public Timer getTimerClock() {
        return TimerClock;
    }

    public void setTimerClock(Timer timerClock) {
        TimerClock = timerClock;
    }
}
