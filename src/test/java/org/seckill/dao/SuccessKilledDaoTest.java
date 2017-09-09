package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SuccessKilled;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class SuccessKilledDaoTest {

    @Resource
    private SuccessKilledDao successKilledDao;
//
//    @Test
//    public void insertSuccessKilled() throws Exception {
//        int inserCount = successKilledDao.insertSuccessKilled(1003L,13800138000L);
//        System.out.println(inserCount);
//    }

    @Test
    public void queryByidWithSeckill() throws Exception {
        long id = 1000L;
        long phone = 13800138000L;
        SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(id, phone);
        System.out.println(successKilled);
        System.out.println(successKilled.getSeckill());
    }

    @Test
    public void query() throws Exception {
        long id = 1000L;
        long phone = 13800138000L;

        SuccessKilled successKilled = successKilledDao.query(id,phone);
        System.out.println(successKilled);
    }

}