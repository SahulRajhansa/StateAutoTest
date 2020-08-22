package com.company;

import static com.company.Main.checkAllSeats;
import static com.company.Main.remaingSeats;

public class Test {
    public String checkremaingSeats(){
        //seat length check
        //Test to check out of bound errors

        if(remaingSeats(new int[1000])==1000){
            return "remainingSeats Failed";
        }

        return "remainingSeats Passed";
    }
    public String testCheckAllSeats(){
        //Test to check out of bound errors
        if(checkAllSeats(new int[1000])){
            return "testCheckAllSeats Failed";
        }
        return "testCheckAllSeats Passed";
    }

    public String testAllocateRandom(){
        try{
            testAllocateRandom();
        }catch (Exception e){
            return "Test Failed";
        }
        return "Test Passed";
    }
}
