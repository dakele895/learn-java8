package io.github.biezhi.java8.lambda.order;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author dalele
 * @date 2020/6/9 20:42
 */
public class OriginDateUtils {


    /**
     * 为有效期
     *
     * @param discountTimeType 折扣时间类型 0.时间区间 1.当日起 2.次日起
     * @param detailedTime 详细时间内容
     * @return YYYY.MM.DD  时间字符串
     */
    public static String forPeriodOfValidity(int discountTimeType,String detailedTime){
        Date nowTime = new Date();
        String startTimeStr = DateUtil.format(nowTime,"yyyy.MM.dd");
        if (discountTimeType==0){
            //时间区间
            String[] timeArray = detailedTime.split("-");
            return startTimeStr+"-"+timeArray[1];
        }
        else if (discountTimeType==1){
            //即日起
            DateTime dateTime = DateUtil.date(nowTime);
            long endTime=dateTime.getTime()+new Long(detailedTime)*60*60*24*1000;
            Date date = new Date(endTime);
            String endTimeStr= DateUtil.format(date,"yyyy.MM.dd");
            return startTimeStr+"-"+endTimeStr;

        }
        else if (discountTimeType==2){
            //次日起
            DateTime dateTime = DateUtil.date(nowTime);
            long startTime=dateTime.getTime()+60*60*24*1000;
            String startTimeStr2= DateUtil.format(new Date(startTime), "yyyy.MM.dd");
            long endTime=startTime+new Long(detailedTime)*60*60*24*1000;
            Date date = new Date(endTime);
            String endTimeStr= DateUtil.format(date,"yyyy.MM.dd");
            return startTimeStr2+"-"+endTimeStr;
        }

      return null;

    }


    public static void main(String[] args) {
        String timeStr="2020.07.01-2020.07.10";
        List<String> list = dateOfTimeInterval(timeStr);
        System.out.println(list.toString());


    }


    /**
     * 小于10天倒计时工具类
     *
     * @param expirationDate 截止日期
     * @return {@link String}
     */
    public static String aFewDaysLeft(String expirationDate){
        String nowTimeStr = DateUtil.format(new Date(), "yyyy.MM.dd");
        DateTime nowDateTime = DateUtil.parse(nowTimeStr);
        //结束时间获取
        String[] timeArray = expirationDate.split("-");
        DateTime endDateTime = DateUtil.parse(timeArray[1]);
        long timeDifference = endDateTime.getTime() - nowDateTime.getTime();

        if (timeDifference<=10*60*60*1000*24){

            long numberOfDays = timeDifference / (60 * 60 * 1000 * 24);

            return  "仅剩"+numberOfDays+"天";
        }

        return null;
    }


    /**
     * 时间格式化后的区间
     * @param timeStr  必须为YYYY.MM.DD-YYY.MM.DD
     * @return List<String> 返回的结果，例如下：
     * [2020.07.01, 2020.07.02, 2020.07.03, 2020.07.04, 2020.07.05, 2020.07.06, 2020.07.07, 2020.07.08, 2020.07.09, 2020.07.10]
     */
    private static List<String> dateOfTimeInterval(String timeStr){
        List<String> dateStrList=new LinkedList<>();
        String[] split = timeStr.split("-");
        //开始时间戳
        DateTime parseStart = DateUtil.parse(split[0]);
        //结束时间戳
        DateTime parseEnd = DateUtil.parse(split[1]);
        long between = DateUtil.between(parseStart.toJdkDate(), parseEnd.toJdkDate(), DateUnit.DAY);

        for (int i=0;i<between+1;i++){
            DateTime dateTime = DateUtil.offsetDay(parseStart.toJdkDate(), i);
           dateStrList.add(DateUtil.format(dateTime.toJdkDate(), "yyyy.MM.dd"));

        }

        return  dateStrList;
    }


}
