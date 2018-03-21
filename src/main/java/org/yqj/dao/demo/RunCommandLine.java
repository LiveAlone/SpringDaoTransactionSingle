package org.yqj.dao.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.yqj.dao.demo.manager.Db1Manager;

/**
 * Created by yaoqijun.
 * Date:2016-04-27
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
@Component
@Slf4j
public class RunCommandLine implements CommandLineRunner{

    @Autowired
    private Db1Manager db1Manager;

    public void run(String... args) {
//        db1Manager.updateDiffDbConditionWithCallback();
        try {
            db1Manager.insertData();
        }catch (Exception e){
            log.info("error content");
        }
        log.info(" command info run");
    }
}
