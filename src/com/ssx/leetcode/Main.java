package com.ssx.leetcode;

import com.ssx.leetcode.answer.F241.Solution;
import com.ssx.lift.Lift;
import com.ssx.lift.WaitQueue;

import static java.lang.Math.abs;

public class Main {
    public static void main(String[] args){
//      未完成  F040, 047, 004, 006,140，127，031，767，034,321,659,188,989,068,303,304
        new Solution();

//        lift();
    }

    public static void lift(){
        WaitQueue.queue.offer(10);
        WaitQueue.queue.offer(12);
        WaitQueue.queue.offer(7);
        Lift th1 = new Lift();
        Lift th2 = new Lift();
        th1.setLiftName("电梯1");
        th2.setLiftName("电梯2");
        th1.setIsRun(true);
        th2.setIsRun(true);
        th1.setFloatNum(12);
        th2.setFloatNum(5);

        while(WaitQueue.queue.peek() != null){
            int aimFloat = (int) WaitQueue.queue.peek();
            if(abs(aimFloat - th1.getFloatNum()) < abs(aimFloat - th2.getFloatNum())){
                th1.run();
            }else{
                th2.run();
            }
        }
    }
}
