package com.example.dbtest2.controller;

import com.example.dbtest2.service.DbtestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {

    @Autowired
    DbtestService dbtestService;

    @GetMapping("/test1")
    public void test1() {
        System.out.println("START1");
        dbtestService.test1("MSSQL_USER1");
    }

    @GetMapping("/test2")
    public void test2() {
        System.out.println("START2");
        dbtestService.test2("MYSQL_USER1");
    }
}
