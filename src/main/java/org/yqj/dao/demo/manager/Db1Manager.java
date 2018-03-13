package org.yqj.dao.demo.manager;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.yqj.dao.demo.config.DB1Config;
import org.yqj.dao.demo.db1.PersonDB1Mapper;

/**
 * @author yaoqijun on 2018-03-12.
 */
@Component
@Slf4j
public class Db1Manager {

    @Autowired
    private PersonDB1Mapper personDB1Mapper;

    @Transactional(DB1Config.DB1_TRANSACTION)
    public void updateDiffDbCondition(){
        personDB1Mapper.updatePersonScore(1L, 7D);
    }

    @Transactional(DB1Config.DB1_TRANSACTION)
    public void updateDiffDbConditionWithCallback(){
        log.info("****************** start db ");
        personDB1Mapper.updatePersonScore(1L, 7D);
        log.info("******************* end db");
        TransactionSynchronizationAdapter transactionSynchronizationAdapter = new TransactionSynchronizationAdapter(){
            @Override
            public void beforeCommit(boolean readOnly) {
                log.info("************* before transaction commit ******************");
            }

            @Override
            public void beforeCompletion() {
                log.info("************* before completion transaction **************");
            }

            @Override
            public void afterCommit() {
                log.info("************** after commit *******************");
            }

            @Override
            public void afterCompletion(int status) {
                log.info("*********** after complete ******************");
            }
        };
        TransactionSynchronizationManager.registerSynchronization(transactionSynchronizationAdapter);
    }


}
