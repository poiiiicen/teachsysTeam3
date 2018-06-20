package com.se.tss.CourseArrangeMgr.logic;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Configuration
public class TimeTransformLogic {

    public Map<String, Integer> transformTime(String time){
        Map<String, Integer> map = new HashMap<>(2);
        switch (time){
            case "周一1，2节": map.put("weekday", 0); map.put("timeperiod", 0);
        }
        return map;
    }
}
