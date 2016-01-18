package com.miwa.time;

import com.miwa.model.Domain.Callback;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TimeManager {

    private long Speed;

    private long parameter;

    private List<Alarm> alarms;

    static TimeManager tm;

    public static TimeManager GetInstance() {
        if (tm == null){
            tm = new TimeManager();
        }

        return tm;
    }

    private TimeManager() {
        Speed = 2;
        parameter = 0;

        alarms = new ArrayList<Alarm>();
        setSpeed(Speed);
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

    public void setSpeed(long speed) {
        long nowMillis = calculatedSpeedTime().getMillis();
        long realMillis = new DateTime().getMillis();

        parameter = (realMillis * speed) - nowMillis;

        Speed = speed;
        refresh();

        System.out.println("set speed : " + getSpeed() + " to " + speed);
    }

    public DateTime calculatedSpeedTime(){
        DateTime virtualDate = new DateTime((new DateTime().getMillis() * getSpeed()) - parameter);

        return virtualDate;
    }

    public DateTime virtualToReal(DateTime time){
        DateTime dateTime = new DateTime(((time.getMillis() + parameter) / getSpeed()));

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
