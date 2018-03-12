package org.yqj.dao.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.yqj.dao.demo.db1.PersonDB1Mapper;
import org.yqj.dao.demo.db2.PersonDB2Mapper;

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
    private CommonManager commonManager;

    public void run(String... args) {
        commonManager.updateDiffDbCondition();
        log.info(" command info run");
    }

}
