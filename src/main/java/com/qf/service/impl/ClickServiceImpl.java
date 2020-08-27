package com.qf.service.impl;

import com.qf.dao.ClickMapper;
import com.qf.entity.Click;
import com.qf.service.IClickService;
import com.qf.util.LockUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClickServiceImpl implements IClickService {

    @Autowired
    private ClickMapper clickMapper;

    @Autowired
    private LockUtil lockUtil;

    @Override
    public void click(){
        boolean flag = lockUtil.lock("myLock", 5);
        if(flag){
            Click click = clickMapper.selectById(1);
            click.setCount(click.getCount()+1);
            clickMapper.updateById(click);
            lockUtil.unlock("myLock");
        }else{
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.click();
        }
    }
}
