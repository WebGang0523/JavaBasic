//package com.xucg.utils;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.TreeMap;
//
//public class Demo {
//    public static void main(String[] args) {
//        String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBA MweUiDXgCMc71WsyKHnbaD3mBZPWzxWi5/TVwaxXHQAWsKJ5ahK+ihvsOXotkO9ExJApkcRvg/Aijj1RrZZQ5q2uRCaKVjcK2gkWHzOGwnz2q+uCjQapMjuQgW1la/x+1+1hEZ4HHPltL1gdVzmi uGmo4bAR2ErmN9sHe9bzjrpAgMBAAECgYBaQbIJKaFUZXADD1LsHHxiZ/kNLGvoY1B8DKR3pid +d8WqLfWqE/VHuhObpeoqS8nKEWI1HMhRCM9V3kc1TIVSct4xp859nKrj4PCL5EDOXGA22VMCx eFqFIzwMjANKtu5fgpncbAuAEy0U6cwdIbqC9P4JqKO6IHg8p6Hwy8dsQJBAOzYxV70tv1QNRU nTwQo5G3zAgy0AJnMKAdroogXUYNKKm9ZqZYTIH8F/AsdBEsrsK4CShl3B4riBYd/jKNybO0CQ QDcoAEdOMWROAEj15qQPrbQYRTpks0r4RnEwXrH75vLRfgi26H6touW/5AduMbkk2dmT/tsy3p QHWjgIHZwrAJtAkA8IPRKnRnvyXMQgcA/sBn+B9mXXANjCD+JUrwajMD28ddAGaVCImz3ko9gS ueSJe9e3dnuCRfzHFqHAcy0mhIpAkBkQV1gPw0gWXfDJtV42NbQSF1taqVLXEYOb/Fwa4S7UXd Zt76apFs4abe+mdnfwtAI4S2ambhiMYsX1gicWL3dAkEA0hKB5QO4560iXH68ukCPhQ6WBtqYS E5yo6PgBeD7aVTHF19uP3xc5oWpe45UpXdcMn+uewK19M15XH9LCMmN1A==";
//        String appSecret = "8e186b411af813e9e9C204c9c66a90fc";
//        JSONObject client = new JSONObject();
//        client.put("pkg", "com.xxx.nearme.gamecenter");
//        TreeMap<String, String> map = new TreeMap<>();
//        // map.put("oaid", "");
//        // map.put("ssoid", "491460943");
//        // map.put("imei", "");
//
//        String data = getEncryptData(appSecret, map);
//        long t = System.currentTimeMillis();
//        TreeMap<String, String> signContent = new TreeMap();
//
//        signContent.put("t", String.valueOf(t));
//        signContent.put("client", JSON.toJSONString(client, SerializerFeature.MapSortField));
//        signContent.put("data", data);
//        String sign = getSign(privateKey, signContent);
//
//        Map<String, Object> request = new HashMap<>();
//        request.put("t", t);
//        request.put("client", client);
//        request.put("data", data);
//        request.put("sign", sign);
//        System.out.println(request)
//    }
//}
