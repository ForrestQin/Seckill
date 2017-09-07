package org.seckill.dao;

import org.seckill.entity.SuccessKilled;

public interface SuccessKilledDao {

    /**
     * 插入购买明细，可过滤重复
     * @param seckilled
     * @param userPhone
     * @return 插入的结果集数量（行数）
     */
    int insertSuccessKilled(long seckilled,long userPhone);

    /**
     * 根据id查询SuccessKilled并携带秒杀产品对象实体
     * @param seckilledId
     * @return
     */
    SuccessKilled queryByidWithSeckill(long seckilledId);


}
