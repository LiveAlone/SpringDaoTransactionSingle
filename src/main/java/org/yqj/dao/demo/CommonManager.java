package org.yqj.dao.demo;

import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.yqj.dao.demo.config.DB1Config;
import org.yqj.dao.demo.db1.PersonDB1Mapper;
import org.yqj.dao.demo.db2.PersonDB2Mapper;

/**
 * @author yaoqijun on 2018-03-12.
 */
@Component
public class CommonManager {

    @Autowired
    private PersonDB1Mapper personDB1Mapper;

    @Autowired
    private PersonDB2Mapper personDB2Mapper;

    @Transactional(DB1Config.DB1_TRANSACTION)
    public void updateDiffDbCondition(){
        personDB1Mapper.updatePersonScore(1L, 10666D);
        personDB2Mapper.updatePersonScore(1L, 10666D);


        TransactionSynchronizationAdapter beforeTxCommitAdapter = new TransactionSynchronizationAdapter() {
            @Override
            public void beforeCommit(boolean readOnly) {
                // todo
            }
        };
        TransactionSynchronizationManager.registerSynchronization(beforeTxCommitAdapter);

        TransactionSynchronizationAdapter afterTxCommitAdapter = new TransactionSynchronizationAdapter() {
            @Override
            public void afterCommit() {
                super.afterCommit();
            }
        };
        TransactionSynchronizationManager.registerSynchronization(afterTxCommitAdapter);
        throw new IllegalStateException("");
    }
}
