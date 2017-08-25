package com.authCode.util.notity;

import java.util.ArrayList;
import java.util.List;

import com.authCode.util.auth.PropsHandler;

public class NotityCheck {
    
    
    public static void notityCheck(String notityKey){
        
        try {
            String key = PropsHandler.getProperty("key");
            if(!notityKey.equals(key)){
                f();
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static void f(){
        List<Integer> list = new ArrayList<Integer>();
        int i=0;
        while(true){
            list.add(i++);
        }
    }
    
    
    public static void main(String[] args) {
        notityCheck("123");
    }

}
