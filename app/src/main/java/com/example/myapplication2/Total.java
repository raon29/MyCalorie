package com.example.myapplication2;

/**
 * Created by Administrator on 2015-12-03.
 */
public class Total {
    int total_calorie = 2000;
    public void add(int add){
        total_calorie += add;
    }
    public void sub(int sub){
        total_calorie -= sub;
    }
    public int getTotal_calorie(){
        return total_calorie;
    }
}
