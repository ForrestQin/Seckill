package org.seckill.service;

import com.mysql.jdbc.log.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"" +
        "classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class SeckillServiceTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;

    @Test
    public void getSedKillList() throws Exception {
        List<Seckill> list = seckillService.getSedKillList();
        logger.info("List={}",list);
    }

    @Test
    public void getById() throws Exception {
        long id = 1000;
        Seckill seckill = seckillService.getById(id);
        logger.info("seckill={}");
    }

    //测试代码完整逻辑，注意可重复执行
    @Test
    public void testSeckillLogic() throws Exception {
        long id = 1000L;
        Exposer exposer = seckillService.exportSeckillUrl(id);
        if (exposer.isExposed()){
            logger.info("exposer={}",exposer);
            long phone = 13800132202L;
            String md5 = "5f3e14fdade71b56d08a876ead51935a";
            try {
                SeckillExecution execution = seckillService.excuteSeckill(id,phone,md5);
                logger.info("result={}",execution);
            } catch (RepeatKillException e) {
                logger.error(e.getMessage());
            } catch (SeckillCloseException e){
                logger.error(e.getMessage());
            }
        } else{
            //秒杀未开启
            logger.warn("exposer={}",exposer);
        }
        //exposer=Exposer{
        // exposed=true,
        // md5='5f3e14fdade71b56d08a876ead51935a',
        // seckillId=1000,
        // now=0, start=0, end=0}

    }


}