package org.yqj.dao.demo.manager;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * @author yaoqijun on 2018-03-12.
 */
@Component
@Slf4j
public class Db1Manager {

    @Transactional
    public void updateDiffDbConditionWithCallback(){
        log.info("****************** start db ");
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
