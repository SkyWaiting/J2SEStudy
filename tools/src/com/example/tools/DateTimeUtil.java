package com.example.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: guorui
 * Date: 13-7-11
 * Time: 上午9:07
 *
 */
public class DateTimeUtil {

    private static final SimpleDateFormat longDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static final SimpleDateFormat shortDateFormat = new SimpleDateFormat("yyyy-MM-dd");

   /**
    *
    * 根据一个日期，返回是星期几的字符串
    *
    */
    public static String getWeek(String strDate){
        Date date = null;

        try {
            date = shortDateFormat.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        return new SimpleDateFormat("EEEE").format(calendar.getTime());
    }

    public static String getShortToday(){
        Date today = new Date();
        return shortDateFormat.format(today);
    }

    public static String getLongToday(){
        Date today = new Date();
        return longDateFormat.format(today);
    }

    /**
    *
    *  取当天零分零点零秒
    */
    public static String getTodayStart(){
        Calendar calendar = Calendar.getInstance();
        //如果不做如下设定则会取系统当前时间
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND,0);
        Date date = new Date(calendar.getTimeInMillis());
        return longDateFormat.format(date);
    }

    /**
    *
    *  取当天23点59分59秒
    */
    public static String getTodayEnd(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,23);
        calendar.set(Calendar.MINUTE,59);
        calendar.set(Calendar.SECOND,59);
        Date date = new Date(calendar.getTimeInMillis());
        return longDateFormat.format(date);
    }

    /**
    *
    *
    * 取特定日期的0点0分0秒
    *
    * */
    public static String getDateStart(String strDate){
        if (null == strDate || "".equals(strDate.trim())){
            return "";
        }
        Date date = null;
        try {
            date = shortDateFormat.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return longDateFormat.format(date);
    }

    /**
    *
    * 取特定日期的23点59分59秒
    *
    * */
    public static String getDateEnd(String strDate){
        if (null == strDate || "".equals(strDate.trim())){
            return "";
        }
        Date date = null;
        try {
            date = shortDateFormat.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //这样取到23点59分59秒
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY,23);
        calendar.set(Calendar.MINUTE,59);
        calendar.set(Calendar.SECOND,59);
        calendar.set(Calendar.MILLISECOND,0);

        return longDateFormat.format(calendar.getTime());
    }


    /**
    *
    * 取当周周一
    */
    public static String getMondayOfThisWeek(){
        Calendar calendar = Calendar.getInstance();
        int day_of_week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (day_of_week == 0){
            day_of_week = 7;
        }
        calendar.add(Calendar.DATE,-day_of_week+1);

        return shortDateFormat.format(calendar.getTime());
    }

    /**
    * 去当周周日
    *
    */
    public static String getSundayOfThisWeek(){
        Calendar calendar = Calendar.getInstance();
        int day_of_week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (day_of_week == 0){
            day_of_week = 7;
        }
        calendar.add(Calendar.DATE,-day_of_week+1);
        //以上取的是周一
        calendar.add(Calendar.DATE,6);
        return shortDateFormat.format(calendar.getTime());
    }

    /**
    * 取上周周一
    *
    */
    public static String getMondayOfPreviousWeek(){
        Calendar calendar = Calendar.getInstance();
        int day_of_week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (day_of_week == 0){
            day_of_week = 7;
        }
        calendar.add(Calendar.DATE,-day_of_week + 1);
        calendar.add(Calendar.DATE,-7);
        return shortDateFormat.format(calendar.getTime());
    }

    /**
    * 取上周周末
    */
    public static String getSundayOfPreviousWeek(){
        Calendar calendar = Calendar.getInstance();
        int day_of_week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (day_of_week == 0){
            day_of_week = 7;
        }
        calendar.add(Calendar.DATE,-day_of_week + 1);
        calendar.add(Calendar.DATE,-1);
        return shortDateFormat.format(calendar.getTime());
    }

   /**
   * 取下周周一
   *
   */
    public static String getMondayOfNextWeek(){
        Calendar calendar = Calendar.getInstance();
        int day_of_week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (day_of_week == 0){
            day_of_week = 7;
        }
        calendar.add(Calendar.DATE,-day_of_week + 1);//当周周一
        calendar.add(Calendar.DATE,7);
        return shortDateFormat.format(calendar.getTime());
    }

    /**
    * 取下周周末
    */
    public static String getSundayOfNextWeek(){
        Calendar calendar = Calendar.getInstance();
        int day_of_week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (day_of_week == 0){
            day_of_week = 7;
        }
        calendar.add(Calendar.DATE,-day_of_week + 1);//当周周一
        calendar.add(Calendar.DATE,13);
        return shortDateFormat.format(calendar.getTime());
    }

    /**
     * 取当月一号
     * @return
     */
    public static String getFirstDayOfThisMonth(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DATE,1);
        return shortDateFormat.format(calendar.getTime());
    }

    /**
     * 取当月最后一天
     * @return
     */
    public static String getLastDayOfThisMonth(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DATE,1);//设为当月1号
        calendar.add(Calendar.MONTH,1);//加一个月，变为下月1号
        calendar.add(Calendar.DATE,-1);//减去一天，变为当月最后一天
        return shortDateFormat.format(calendar.getTime());
    }

    /**
     * 取上月1号
     */
    private static String getFirstDayOfPreviousMonth () {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DATE, 1);    // 设为当前月的1号
        calendar.add(Calendar.MONTH, -1);  // 减一个月，变为上月的1号
        return shortDateFormat.format(calendar.getTime());
    }

    /**
     * 取上月最后一天
     */
    private static String getLastDayOfPreviousMonth () {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DATE, 1);    // 设为当前月的1号
        calendar.add(Calendar.DATE, -1);   // 减去一天，变为上月最后一天
        return shortDateFormat.format(calendar.getTime());
    }


    /**
     * 取下月1号
     */
    private static String getFirstDayOfNextMonth () {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 1);    // 加一个月
        calendar.set(Calendar.DATE, 1);     // 把日期设置为当月第一天
        return shortDateFormat.format(calendar.getTime());
    }

    /**
     * 取下月最后一天
     */
    private static String getLastDayOfNextMonth () {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 1);// 加一个月
        calendar.set(Calendar.DATE, 1);// 把日期设置为当月第一天
        calendar.roll(Calendar.DATE, -1);// 日期回滚一天，也就是本月最后一天
        return shortDateFormat.format(calendar.getTime());
    }

    /**
     * 获得本年有多少天
     * @return
     */
    public static int getTotalDaysOfThisYear(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR,1);//把日期设为当年第一天
        calendar.roll(Calendar.DAY_OF_YEAR,-1);//把日期回滚一天
        int totalDays = calendar.get(Calendar.DAY_OF_YEAR);
        return totalDays;
    }

    /**
     * 获取某年某月的最后一天
     * @param year
     * @param month
     * @return
     */
    public static int getLastDayOfMonth(int year,int month){
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){
            return 31;
        }
        if (month == 4 || month == 6 || month == 9 || month == 11){
            return 30;
        }
        if (month == 2){
            if (isLeapYear(year)){
                return 29;
            }else {
                return 28;
            }
        }
        return 0;
    }

    /**
     * 是否闰年
     * @param year
     * @return
     */
    public static boolean isLeapYear(int year){
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    /**
     * 获得本年第一天的日期
     * @return
     */
    public static String getFirstDayOfThisYear(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH,1);
        calendar.set(Calendar.DAY_OF_YEAR,1);
        Date date = new Date(calendar.getTimeInMillis());
        return shortDateFormat.format(date);
    }

    /**
     * 获得本年最后一天的日期
     * @return
     */
    public static String getLastDayOfThisYear(){
        Date date = new Date();
        String years = new SimpleDateFormat("yyyy").format(date);
        return years + "-12-31";
    }

    /**
     * 获取上一年第一天的日期
     * @return
     */
    public static String getFirstDayOfPreviousYear(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR,-1);//若是取明年，改为正整数1即可
        calendar.set(Calendar.MONTH,1);
        calendar.set(Calendar.DAY_OF_YEAR,1);
        Date date = new Date(calendar.getTimeInMillis());
        return shortDateFormat.format(date);
    }

    /**
     * 两个时间之间的天数
     * @param date1
     * @param date2
     * @return
     */
    public static long getDays(String date1,String date2){
        if(date1 == null || "".equals(date1.trim())){
            return 0;
        }

        if(date2 == null || "".equals(date2.trim())){
            return 0;
        }

        //转换为标准时间
        Date date = null;
        Date mydate = null;
        try {
            date = shortDateFormat.parse(date1);
            mydate = shortDateFormat.parse(date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long day = 0;
        if (date.before(mydate)){
            day = (mydate.getTime() - date.getTime()) / (24 * 60 * 60 * 1000);
        }else {
            day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
        }
        return day;
    }

    public static void main(String[] args) {
//        System.out.println("根据一个日期，返回是星期几的字符串:" + getWeek ("2013-07-12"));
//        System.out.println("/*---当天(长日期格式和短日期格式)---*/");
//        System.out.println("当天(长日期格式):" + getLongToday ());
//        System.out.println("当天(短日期格式):" + getShortToday ());
//        System.out.println("取当周周一：" + getMondayOfThisWeek());
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR,1);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
        calendar.roll(Calendar.DAY_OF_YEAR, -1);
        System.out.println(shortDateFormat.format(calendar.getTime()));
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println(calendar.get(Calendar.MONTH));
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));

//        int day_of_week = calendar.get(Calendar.DAY_OF_WEEK);
//        System.out.println(day_of_week);
//        day_of_week = calendar.get(Calendar.HOUR_OF_DAY);
//        System.out.println(day_of_week);
//        day_of_week = calendar.get(Calendar.DAY_OF_MONTH);
//        System.out.println(day_of_week);
//        day_of_week = calendar.get(Calendar.DAY_OF_YEAR);
//        System.out.println(day_of_week);
//        day_of_week = calendar.get(Calendar.WEEK_OF_MONTH);
//        System.out.println(day_of_week);

    }


}
