package com.packtpub.java7.concurrency.chapter2.recipe2;

/**
 * Created with IntelliJ IDEA.
 * User: guorui
 * Date: 2014/4/28
 * Time: 14:53
 */
public class Cinema {

    // 这两个变量存储两个电影院的空位
    private long vacanciesCinema1;
    private long vacanciesCinema2;

    private final Object controlCinema1;
    private final Object controlCinema2;

    //构造方法，初始化所有属性。
    public Cinema(){
        controlCinema1 = new Object();
        controlCinema2 = new Object();
        vacanciesCinema1 = 20;
        vacanciesCinema2 = 20;
    }

    /**
     * 实现第一个电影院的售票操作
     * @param number
     * @return
     */
    public boolean sellTickets1(int number){
        synchronized(controlCinema1){
            if (number < vacanciesCinema1){
                vacanciesCinema1 -= number;
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * 实现第二个电影院的售票操作
     * @param number
     * @return
     */
    public boolean sellTickets2(int number){
        synchronized(controlCinema2){
            if (number < vacanciesCinema2){
                vacanciesCinema2 -= number;
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * 实现第一个电影院的退票操作
     * @param number
     * @return
     */
    public boolean returnTickets1(int number){
        synchronized(controlCinema1){
            vacanciesCinema1 += number;
            return true;
        }
    }

    /**
     * 实现第二个电影院的退票操作
     * @param number
     * @return
     */
    public boolean returnTickets2(int number){
        synchronized(controlCinema2){
            vacanciesCinema2 += number;
            return true;
        }
    }

    /**
     * 返回第一个电影院空缺位置
     * @return
     */
    public long getVacanciesCinema1(){
        return vacanciesCinema1;
    }

    /**
     * 返回第二个电影院空缺位置
     * @return
     */
    public long getVacanciesCinema2(){
        return vacanciesCinema2;
    }

}
