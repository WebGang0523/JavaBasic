package com.xucg.balance;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 一致性hash算法
 */
public class ConsistentHash {
    private static SortedMap<Integer,String> virtualNodes = new TreeMap<>();
    private static final int VIRTUAL_NODES = 160;

    static {
        for (String ip : ServerIps.LIST) {
            for (int i=0;i<VIRTUAL_NODES;i++){
                int hash = CommonUtil.getHash(ip + "VN" + i);
                virtualNodes.put(hash,ip);
            }
        }
    }

    private static String getServer(String client) {
        int hash = CommonUtil.getHash(client);

        SortedMap<Integer,String> subMap = virtualNodes.tailMap(hash);

        Integer nodeIndex = subMap.firstKey();

        if (null == nodeIndex) {
            nodeIndex = virtualNodes.firstKey();
        }

        return subMap.get(nodeIndex);
    }

    public static void main(String[] args) {
        for (int i=0;i<10;i++) {
            System.out.println(getServer("client" + i));
        }
    }
}
