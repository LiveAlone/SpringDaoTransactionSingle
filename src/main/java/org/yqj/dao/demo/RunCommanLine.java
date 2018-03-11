package org.yqj.dao.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.yqj.dao.demo.dao.OriginDao;

/**
 * Created by yaoqijun.
 * Date:2016-04-27
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
@Component
@Slf4j
public class RunCommanLine implements CommandLineRunner{

    @Autowired
    private OriginDao originDao;

    public void run(String... args) throws Exception {
        log.info(" command info run");
        originDao.queryPersonById("1");
    }
}
