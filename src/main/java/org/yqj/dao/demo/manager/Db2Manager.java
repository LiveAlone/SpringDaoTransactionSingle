package org.yqj.dao.demo.manager;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.yqj.dao.demo.config.DB1Config;
import org.yqj.dao.demo.config.DB2Config;
import org.yqj.dao.demo.db2.PersonDB2Mapper;

/**
 * @author yaoqijun on 2018-03-12.
 */
@Component
@Slf4j
public class Db2Manager {

    @Autowired
    private PersonDB2Mapper personDB2Mapper;

    @Transactional(DB1Config.DB1_TRANSACTION)
    public void updateDiffDbCondition(){
        personDB2Mapper.updatePersonScore(1L, 77D);
        throw new IllegalStateException("illegal state exception");
    }

}
