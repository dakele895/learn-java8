package io.github.biezhi.java8.lambda.order;

import cn.hutool.core.date.DateUtil;

import java.util.Date;

/**
 * @author dalele
 * @date 2020/6/9 11:21
 */
public class OriginDiscountOrderEntity {

    public static void main(String[] args) {
        Date nowTime = new Date();
        String startTimeStr = DateUtil.format(nowTime,"yyyy.MM.dd");
        System.out.println(startTimeStr);
    }
}
