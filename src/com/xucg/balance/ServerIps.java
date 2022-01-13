package com.xucg.balance;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ServerIps {

    // 定义一个服务器列表
    public static final List<String> LIST = Arrays.asList(
            "192.168.0.1",
            "192.168.0.2",
            "192.168.0.3",
            "192.168.0.4",
            "192.168.0.5",
            "192.168.0.6",
            "192.168.0.7",
            "192.168.0.8",
            "192.168.0.9",
            "192.168.0.10"
    );

    // 定义一个带权重的服务器列表
    public static final Map<String,Integer> WEIGHT_LIST = new LinkedHashMap<>();
    static {
        WEIGHT_LIST.put("192.168.0.1",2);
        WEIGHT_LIST.put("192.168.0.2",5);
        WEIGHT_LIST.put("192.168.0.3",1);
        WEIGHT_LIST.put("192.168.0.4",6);
        WEIGHT_LIST.put("192.168.0.5",5);
        WEIGHT_LIST.put("192.168.0.6",5);
        WEIGHT_LIST.put("192.168.0.7",4);
        WEIGHT_LIST.put("192.168.0.8",7);
        WEIGHT_LIST.put("192.168.0.9",2);
        WEIGHT_LIST.put("192.168.0.10",9);
    }

    // 定义一个带访问次数的服务器列表
    public static final Map<String,Integer> ACTIVITY_LIST = new LinkedHashMap<>();
    static {
        ACTIVITY_LIST.put("192.168.0.1",2);
        ACTIVITY_LIST.put("192.168.0.2",0);
        ACTIVITY_LIST.put("192.168.0.3",1);
        ACTIVITY_LIST.put("192.168.0.4",3);
        ACTIVITY_LIST.put("192.168.0.5",0);
        ACTIVITY_LIST.put("192.168.0.6",1);
        ACTIVITY_LIST.put("192.168.0.7",4);
        ACTIVITY_LIST.put("192.168.0.8",2);
        ACTIVITY_LIST.put("192.168.0.9",7);
        ACTIVITY_LIST.put("192.168.0.10",3);
    }
}
