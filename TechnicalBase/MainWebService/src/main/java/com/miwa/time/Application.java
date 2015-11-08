package com.miwa.time;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private String Code;
    private List<Alarm> AlarmClock;


    public Application(String code) {
        Code = code;
        AlarmClock = new ArrayList<Alarm>();
    }

    public void AddAlarm(Alarm a){
        AlarmClock.add(a);
    }

    public void Refresh(){
        for (Alarm a : AlarmClock){
            a.Refresh();
        }
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public List<Alarm> getAlarmClock() {
        return AlarmClock;
    }

    public void setAlarmClock(List<Alarm> alarmClock) {
        AlarmClock = alarmClock;
    }
}