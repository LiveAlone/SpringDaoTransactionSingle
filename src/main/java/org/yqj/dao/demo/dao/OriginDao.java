package org.yqj.dao.demo.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author yaoqijun on 2018-03-10.
 */
@Component
@Slf4j
public class OriginDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void queryPersonById(String id){
        Map<String, Object> queryResult = jdbcTemplate.queryForMap("select id, name, age, score FROM t_person WHERE id = " + id);
        log.info("query person :{} , result:{}", id, queryResult);
    }
}
