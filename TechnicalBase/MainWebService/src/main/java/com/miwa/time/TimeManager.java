package com.miwa.time;

import com.miwa.model.Callback;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    public void AddAlarmToApplication(Callback callback, String alarmCode){
        Alarm alarmClock = new Alarm(alarmCode, callback);

        Application a = FindApplication(callback.getService().getName());

        a.AddAlarm(alarmClock);
    }

    public Application FindApplication(String applicationCode) {
        for (Application a : allApplication){
            if (a.getCode() == applicationCode){
                return a;
            }
        }

        Application application = new Application(applicationCode);
        return application;
    }

    public void Refresh() {
        for(Application a : allApplication){
            a.Refresh();
        }
    }

    public long getSpeed() {
        return Speed;
    }

    public void setSpeed(long speed) {
        Speed = speed;
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
