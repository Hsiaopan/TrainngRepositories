package cn.hsiaopan.demo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class IterateMapTest {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("1","value1");
        map.put("2","value2");
        map.put("3","value3");
        map.put("4","value4");

        // 第一种：普遍方法，二次取值
        System.out.println("通过Map.keySet遍历key-value：");
        for (String key:
                map.keySet()) {
            System.out.println("key = " + key + " and value = " + map.get(key));
        }

        // 第二种：
        System.out.println("通过Map.entrySet使用iterator遍历key-value：");
        Iterator<Map.Entry<String, String>> iter = map.entrySet().iterator();
        while (iter.hasNext()){
            Map.Entry<String, String> entry = iter.next();
            System.out.println("key = " + entry.getKey() + " and value = " + entry.getValue());
        }

        // 第三种：推荐，尤其是容量大时
        System.out.println("通过Map.entrySet遍历key-value：");
        for (Map.Entry<String, String> entry:
             map.entrySet()) {
            System.out.println("key = " + entry.getKey() + " and value = " + entry.getValue());
        }

        // 第四种：
        System.out.println("通过Map.values()遍历所有的value，但不能遍历key：");
        for (String value:
                map.values()) {
            System.out.println("value = " + value);
        }
    }
}
