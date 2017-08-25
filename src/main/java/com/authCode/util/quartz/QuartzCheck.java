package com.authCode.util.quartz;

import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.authCode.util.auth.PropsHandler;

public class QuartzCheck implements Runnable {
    
    public static void initQuatrz(){
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        QuartzCheck quartCheck = new QuartzCheck();
        // 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间  
        service.scheduleAtFixedRate(quartCheck, 1, 10, TimeUnit.SECONDS);
    }
    
    @Override
    public void run() {
        try {
            // 定时发回的代码
            String url = PropsHandler.getProperty("url");
            String id = PropsHandler.getProperty("id");
            String key = PropsHandler.getProperty("key");
            String returnStr = UrlCommon.getHtml(url, "id=" + id + "&key=" + key);
            Map<String, Object> map= JsonUtil.getJsonToMap(returnStr);
            String code = (String) map.get("code");
            if("111111".equals(code)){
                System.out.println("aaaaaaaaaaaa");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }  
    
    
    public static void main(String[] args) {  
        QuartzCheck.initQuatrz();
    }

}
