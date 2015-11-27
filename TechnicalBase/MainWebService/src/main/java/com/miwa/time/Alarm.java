package com.miwa.time;

import com.cronutils.model.Cron;
import com.miwa.model.Callback;
import com.miwa.time.Message.SendMessage;
import com.miwa.time.ParserCron.ParseCron;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Alarm{

    //le temps de reveil voulu
    private Date Clock;
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

    public Date getClock() {
        return Clock;
    }

    public void setClock(Date clock) {
        Clock = clock;
        refresh();
    }

    public Callback getCallback() {
        return callback;
    }

    public void stopAlarm(){
        TimerClock.cancel();

        TimeManager.GetInstance().deleteAlarm(getCallback().getCallbackid());
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

        Clock = ParseCron.GetInstance()
                .nextExecution(TimeManager.GetInstance().calculatedSpeedTime(new Date()), parse);

        if (getClock() == null){
            stopAlarm();
        }

        Date time = TimeManager.GetInstance().calculatedSpeedTime(getClock());
        TimerClock.schedule(task, time);
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
