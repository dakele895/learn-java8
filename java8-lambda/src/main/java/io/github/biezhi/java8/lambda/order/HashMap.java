package io.github.biezhi.java8.lambda.order;

import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author dalele
 * @date 2020/6/17 21:58
 */
public class HashMap {


    public static void main(String[] args) {


        List<String> sss=new ArrayList<>();
        List<String> userNames = new ArrayList<String>() {{
            add("Hollis");
            add("hollis");
            add("HollisChuang");
            add("H");
        }};

        userNames.forEach(userName ->{
            sss.add(userName);
        });
        System.out.println(sss);









        java.util.HashMap<String, String> objectObjectHashMap = Maps.newHashMapWithExpectedSize(7);
        objectObjectHashMap.put("ssss","ssss");
        System.out.println(objectObjectHashMap.size());
        Map<String,String> map=new java.util.HashMap<>();
        for (int i=0;i<16;i++){
            map.put("ss"+i,"kk"+i);
        }
        int size = map.size();

        System.out.println(size);
    }

}
