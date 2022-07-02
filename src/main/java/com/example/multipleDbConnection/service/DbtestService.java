package com.example.multipleDbConnection.service;

import com.example.multipleDbConnection.dto.TestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Service
@RequiredArgsConstructor
public class DbtestService {

    //@Qualifier(value = "mssql")
    @Resource(name="mssql")
    private final DataSource mssql;

    //@Qualifier(value = "mysql")
    @Resource(name="mysql")
    private final DataSource mysql;

    public void test1(String userId) {
        String query = "SELECT USER_NAME FROM MSSQL_TEST_TBL WHERE USER_ID = ? ";
        System.out.println("유저 아이디 =>" + userId);        JdbcTemplate template = new JdbcTemplate(mssql);
        int cnt = template.queryForObject("SELECT COUNT(*) CNT FROM MSSQL_TEST_TBL", Integer.class);
        template.queryForObject("SELECT COUNT(*) CNT FROM MSSQL_TEST_TBL", Integer.class);
        System.out.println("총 카운트 ==>" + cnt);
    }

    public void test2(String userId) {
        String query = "SELECT USER_ID AS USER_ID FROM MYSQL_TEST_TBL WHERE USER_ID = ?";
        System.out.println("유저 아이디 =>" + userId);
        JdbcTemplate template = new JdbcTemplate(mysql);
        TestDto testDto = template.queryForObject(query,
                (resultSet, rowNum) -> {
                    TestDto resDto = new TestDto();
                    resDto.setUserId(resultSet.getString("USER_ID"));
                    return resDto;
                }, userId);
        System.out.println("MYSQL USERID==>" + testDto.getCnt());
    }

}
