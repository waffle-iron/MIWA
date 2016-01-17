package com.miwa.time;

import com.miwa.model.Domain.Callback;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TimeManager {

    private long Speed;

    private List<Alarm> alarms;

    static TimeManager tm;

    public static TimeManager GetInstance() {
        if (tm == null){
            tm = new TimeManager();
        }

        return tm;
    }

    private TimeManager() {
        Speed = 1;
        alarms = new ArrayList<Alarm>();
    }

    public void AddAlarmToApplication(Callback callback) throws Exception {
        Alarm alarmClock = new Alarm(callback);
        alarms.add(alarmClock);
    }

    public void refresh() {
        for(Alarm a : alarms){
            a.refresh();
        }
    }

    public long getSpeed() {
        return Speed;
    }

    static long test = 0;
    public void setSpeed(long speed) {
        long nowMillis = new DateTime().getMillis();
        long temp = nowMillis * speed - nowMillis;

        test = (temp - test) + test;

        Speed = speed;
        refresh();
    }

    public DateTime calculatedSpeedTime(){
        DateTime virtualDate = new DateTime((new DateTime().getMillis() * getSpeed()) - test);

        return virtualDate;
    }

    public DateTime virtualToReal(DateTime time){
        DateTime dateTime = new DateTime((time.getMillis() / getSpeed()) + test);

        return dateTime;
    }

    public Date getCurrentDate(){
        return calculatedSpeedTime().toDate();
    }

    public void deleteAlarmStopped(int callBackID){
        for(Alarm a : new ArrayList<Alarm>(alarms)){
            if (a.getCallback().getCallbackid() == callBackID){
                alarms.remove(a);
                break;
            }
        }
    }

    public void deleteAlarm(int callBackID){
        for(Alarm a : new ArrayList<Alarm>(alarms)){
            if (a.getCallback().getCallbackid() == callBackID){
                a.stopAlarm();
                break;
            }
        }
    }
}
