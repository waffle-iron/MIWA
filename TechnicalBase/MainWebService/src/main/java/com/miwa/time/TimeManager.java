package com.miwa.time;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by BadaBoum on 23/10/2015.
 */
public class TimeManager {

    List<Application> allApplication;
    private long Speed;


    static TimeManager tm;

    public static TimeManager GetInstance() {
        if (tm == null){
            tm = new TimeManager();
        }

        return tm;
    }

    private TimeManager() {
        allApplication = new ArrayList<Application>();
        Speed = 1;
    }

    public void AddApplication(Application a) {
        allApplication.add(a);
    }

    public void AddAlarmToApplication(String applicationCode, Date d, String alarmCode){
        Alarm alarmClock = new Alarm(d, alarmCode);

        Application a = FindApplication(applicationCode);

        a.AddAlarm(alarmClock);
    }

    public Application FindApplication(String applicationCode) {
        for (Application a : allApplication){
            if (a.getCode() == applicationCode){
                return a;
            }
        }

        return null;
    }

    public void Refresh() {
        for(Application a : allApplication){
            a.Refresh();
        }
    }

    public long getSpeed() {
        return Speed;
    }

    public void SpeedReset(){
        Speed = 1;

        Refresh();
    }

    public void SpeedUp() {
        Speed += Constant.Unit;

        Refresh();
    }

    public void SpeedDown() {
        Speed -= Constant.Unit;

        Refresh();
    }

}
