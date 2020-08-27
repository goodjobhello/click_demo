package com.qf.controller;

import com.qf.service.IClickService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Controller
public class ClickController {

    @Autowired
    private IClickService clickService;

    private ExecutorService executorService = Executors.newFixedThreadPool(100);

    @RequestMapping("click")
    @ResponseBody
    public String click(){
        for (int i = 0; i < 10; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    clickService.click();
                }
            });
        }
        return null;
    }
}
