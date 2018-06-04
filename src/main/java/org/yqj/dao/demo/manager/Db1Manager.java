package org.yqj.dao.demo.manager;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

/**
 * @author yaoqijun on 2018-03-12.
 */
@Component
@Slf4j
public class Db1Manager {

    private static final Logger logger = LoggerFactory.getLogger(Db1Manager.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DataSource dataSource;

    public void datasourceSourceExecute() throws Exception{
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        Boolean isSuccess = statement.execute("INSERT INTO t_person_single(name, age, score) VALUES ('yaoqijun', 6, 90.66);");
        logger.info("execute statment sql content is success: " + isSuccess);
        statement.close();
        connection.close();
    }

    @Transactional
    public void insertData(){
        jdbcTemplate.execute("INSERT INTO t_person_single(name, age, score) VALUES ('yaoqijun', 6, 90.66);");
        throw new IllegalStateException("illegal state");
    }

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
