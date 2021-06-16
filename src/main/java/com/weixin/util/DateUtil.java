package com.weixin.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * description: 日期 时间 工具类 <br>
 * version: 1.0 <br>
 * date: 2021/6/16 0016 11:29 <br>
 * author: lichaoge <br>
 */
public class DateUtil {

    /**
     * description: 获取两个日期之间的天数 <br>
     * version: 1.0 <br>
     * date: 2021/6/16 0016 11:31 <br>
     * author: lichaoge <br>
     *
     * @param smdate
     * @param bdate
     * @return int
     */
    private static int getBetweenDay(String smdate, Date bdate) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date =sdf.parse(smdate);
        bdate=sdf.parse(sdf.format(bdate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days=(time2-time1)/(1000*3600*24);

        return Integer.parseInt(String.valueOf(between_days));
    }

    /**
     * description: 获取时间差（毫秒） <br>
     * version: 1.0 <br>
     * date: 2021/6/16 0016 11:36 <br>
     * author: lichaoge <br>
     *
     * @param
     * @return int
     */
    public static int getLeadTime(Date start,Date end){
        long leadTime = end.getTime() - start.getTime();
        return Long.bitCount(leadTime);
    }
}
