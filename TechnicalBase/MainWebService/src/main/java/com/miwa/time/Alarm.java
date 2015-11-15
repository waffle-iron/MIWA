package com.miwa.time;

import com.cronutils.model.Cron;
import com.miwa.model.Callback;
import com.miwa.time.Message.SendMessage;
import com.miwa.time.ParserCron.ParseCron;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Alarm{

    //le temps de reveil voulu
    private Date Clock;
    private Date CalculatedClock;

    private boolean RecurMonth;
    private boolean RecurDay;
    private boolean RecurHour;

    private String AlarmCode;
    private Timer TimerClock;
    private SendMessage message;
    private boolean isTerminated;

    private Callback callback;

    public Alarm(String code, Callback callback) {

        ParseCron parseCron = new ParseCron();
        Cron parse = parseCron.parse(callback.getMessage());

        Clock = parseCron.nextExecution(new Date(), parse);
        AlarmCode = code;

        TimerClock = new Timer(false);
        message = new SendMessage();
        message.message = AlarmCode;
        message.callback = callback;
        this.callback = callback;

        setCalculatedClock(Clock);
    }

    public void Refresh(){
        setCalculatedClock(getClock());
    }

    public Date getClock() {
        return Clock;
    }

    public void setClock(Date clock) {
        Clock = clock;
        setCalculatedClock(clock);
    }

    public Date getCalculatedClock() {
        return CalculatedClock;
    }

    public void setCalculatedClock(Date calculatedClock) {

        Long now = new Date().getTime();
        CalculatedClock = new Date((calculatedClock.getTime() - now)
                / TimeManager.GetInstance().getSpeed() + now);

        TimerClock.cancel();
        TimerClock = new Timer(false);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                message.send();

                if (isRecurDay() || isRecurMonth() || isRecurDay()) {

                    Calendar c = Calendar.getInstance();
                    c.setTime(getClock());
                    c.add(Calendar.DATE, 1);

                    if (isRecurMonth()) {
                        c.add(Calendar.YEAR, 1);
                    }

                    if (isRecurDay()) {
                        c.add(Calendar.MONTH, 1);
                    }

                    if (isRecurHour()) {
                        c.add(Calendar.DAY_OF_MONTH, 1);
                    }
                    setClock(c.getTime());
                }
                else {
                    setIsTerminated(true);
                }
            }
        };

        TimerClock.schedule(task, getCalculatedClock());
    }

    public boolean isTerminated() {
        return isTerminated;
    }

    public void setIsTerminated(boolean isTerminated) {
        this.isTerminated = isTerminated;
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

    public void setAlarmCode(String alarmCode) {
        AlarmCode = alarmCode;
    }

    public boolean isRecurMonth() {
        return RecurMonth;
    }

    public void setRecurMonth(boolean recurMonth) {
        RecurMonth = recurMonth;
    }

    public boolean isRecurDay() {
        return RecurDay;
    }

    public void setRecurDay(boolean recurDay) {
        RecurDay = recurDay;
    }

    public boolean isRecurHour() {
        return RecurHour;
    }

    public void setRecurHour(boolean recurHour) {
        RecurHour = recurHour;
    }

    public String getAlarmCode() {
        return AlarmCode;
    }
}
