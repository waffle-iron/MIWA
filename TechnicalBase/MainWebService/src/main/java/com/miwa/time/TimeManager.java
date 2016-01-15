package com.miwa.time;

import com.miwa.model.Callback;
import org.joda.time.DateTime;
import org.joda.time.Interval;

import java.time.Duration;
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

    public void setSpeed(long speed) {
        Speed = speed;
        refresh();
    }

//    static private DateTime previousUpdate = new DateTime();
//    static private DateTime virtualDate = new DateTime();

    public DateTime calculatedSpeedTime(){
//        Interval intervalCall = new Interval(previousUpdate, virtualDate);
//        org.joda.time.Duration durationCall = new org.joda.time.Duration(intervalCall.toDurationMillis() * getSpeed());
//
//        DateTime now = new DateTime();
//        Interval interval;
//        if (now.isAfter(virtualDate)){
//            interval = new Interval(virtualDate, now);
//        }
//        else{
//            interval = new Interval(now, virtualDate);
//        }
//
//        org.joda.time.Duration duration = new org.joda.time.Duration(interval.toDurationMillis() * getSpeed());
//
//        DateTime newDate = now.plus(duration);
//
//        virtualDate = now.plus(durationCall);
//        previousUpdate = now;
//        return newDate;

        DateTime virtualDate = new DateTime(new DateTime().getMillis() * getSpeed());

        return virtualDate;
    }

    public DateTime virtualToReal(DateTime time){
//        Interval interval;
//        if (time.isAfter(virtualDate)){
//            interval = new Interval(virtualDate, time);
//        }
//        else{
//            interval = new Interval(time, virtualDate);
//        }
//
//        org.joda.time.Duration duration = new org.joda.time.Duration(interval.toDurationMillis() / getSpeed());
//        DateTime dateTime = new DateTime().plus(duration);

        DateTime dateTime = new DateTime(time.getMillis() / getSpeed());

        return dateTime;
    }

    public Date getCurrentDate(){
        return calculatedSpeedTime().toDate();
    }

    public void deleteAlarm(int callBackID){
        for(Alarm a : alarms){
            if (a.getCallback().getCallbackid() == callBackID){
                a.stopAlarm();
                alarms.remove(a);
                break;
            }
        }
    }
}
