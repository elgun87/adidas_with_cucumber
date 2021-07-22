package com.adidas.utilities;

public class BrowserSleep {
    public static void wait(int time){
        try{
            Thread.sleep(time * 1000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
