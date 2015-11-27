package com.miwa.time;

import com.miwa.model.Callback;

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

    public Date calculatedSpeedTime(Date time){
        Date now = new Date();
        Date temp = new Date(time.getTime());

        long time1 = temp.getTime();
        long time2 = now.getTime();
        temp = new Date(((time1 - time2)
                / getSpeed()) + time2);

        return temp;
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
