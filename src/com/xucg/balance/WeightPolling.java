package com.xucg.balance;

/**
 * 加权轮询算法
 *
 * 这种算法有一个缺点：一台服务器的权重特别大的时候，他需要连续的处理请求，但是实际上我们想达到的效果是，对于100次请求，只要有有100*8/50=16次就够了，
 * 这16次不一定要连续的访问，比如假设我们有三台服务器servers=[A,B,C]，对应权重weights=[2,5,1]，总权重为7，
 * 那么上述这算法的结果是AAAAABC，那么如果能够是这么一个结果呢：AABACAA，把B和C平均插入到5个A中间，这样是比较均衡的。
 */
public class WeightPolling {
    private static Integer pos = 0;

    public static String getServer(){
        int totalWeight = 0;
        boolean sameWeight = true;
        Object[] weights = ServerIps.WEIGHT_LIST.values().toArray();
        for (int i=0;i<weights.length;i++) {
            Integer weight = (Integer) weights[i];
            totalWeight += weight;
            if (sameWeight && i > 0 && !weight.equals(weights[i-1])) {
                sameWeight = false;
            }
        }

        Integer sequenceNum = Sequence.getAndIncrement();
        Integer offset = sequenceNum % totalWeight;
        offset = offset == 0 ? totalWeight : offset;
        if (!sameWeight) {
            for (String ip: ServerIps.WEIGHT_LIST.keySet()) {
                Integer weight = ServerIps.WEIGHT_LIST.get(ip);
                if (offset <= weight) {
                    return ip;
                }

                offset -= weight;
            }
        }

        String ip = null;
        synchronized (pos) {
            if (pos >= ServerIps.LIST.size()) {
                pos = 0;
            }
            ip = ServerIps.LIST.get(pos);
            pos++;
        }

        return ip;
    }

    public static void main(String[] args) {
        for (int i = 0;i<10;i++) {
            System.out.println(getServer());
        }
    }
}
