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
            case "周一1，2节": map.put("weekday", 0); map.put("timeperiod", 0); break;
            case "周一3，4，5节": map.put("weekday", 0); map.put("timeperiod", 1); break;
            case "周一6，7，8节": map.put("weekday", 0); map.put("timeperiod", 2); break;
            case "周一9，10节": map.put("weekday", 0); map.put("timeperiod", 3); break;
            case "周一11，12，13节": map.put("weekday", 0); map.put("timeperiod", 4); break;
            case "周二1，2节": map.put("weekday", 1); map.put("timeperiod", 0); break;
            case "周二3，4，5节": map.put("weekday", 1); map.put("timeperiod", 1); break;
            case "周二6，7，8节": map.put("weekday", 1); map.put("timeperiod", 2); break;
            case "周二9，10节": map.put("weekday", 1); map.put("timeperiod", 3); break;
            case "周二11，12，13节": map.put("weekday", 1); map.put("timeperiod", 4); break;
            case "周三1，2节": map.put("weekday", 2); map.put("timeperiod", 0); break;
            case "周三3，4，5节": map.put("weekday", 2); map.put("timeperiod", 1); break;
            case "周三6，7，8节": map.put("weekday", 2); map.put("timeperiod", 2); break;
            case "周三9，10节": map.put("weekday", 2); map.put("timeperiod", 3); break;
            case "周三11，12，13节": map.put("weekday", 2); map.put("timeperiod", 4); break;
            case "周四1，2节": map.put("weekday", 3); map.put("timeperiod", 0); break;
            case "周四3，4，5节": map.put("weekday", 3); map.put("timeperiod", 1); break;
            case "周四6，7，8节": map.put("weekday", 3); map.put("timeperiod", 2); break;
            case "周四9，10节": map.put("weekday", 3); map.put("timeperiod", 3); break;
            case "周四11，12，13节": map.put("weekday", 3); map.put("timeperiod", 4); break;
            case "周五1，2节": map.put("weekday", 4); map.put("timeperiod", 0); break;
            case "周五3，4，5节": map.put("weekday", 4); map.put("timeperiod", 1); break;
            case "周五6，7，8节": map.put("weekday", 4); map.put("timeperiod", 2); break;
            case "周五9，10节": map.put("weekday", 4); map.put("timeperiod", 3); break;
            case "周五11，12，13节": map.put("weekday", 4); map.put("timeperiod", 4); break;
        }
        return map;
    }
}
