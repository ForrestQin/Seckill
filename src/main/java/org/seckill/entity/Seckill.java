package org.seckill.entity;

import java.util.Date;

public class Seckill {

    private long seckillid;

    private String name;

    private int number;

    private Date stratTime;

    private Date endTime;

    private Date createTime;

    public long getSeckillid() {
        return seckillid;
    }

    public void setSeckillid(long seckillid) {
        this.seckillid = seckillid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getStratTime() {
        return stratTime;
    }

    public void setStratTime(Date stratTime) {
        this.stratTime = stratTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Seckill{" +
                "seckillid=" + seckillid +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", stratTime=" + stratTime +
                ", endTime=" + endTime +
                ", createTime=" + createTime +
                '}';
    }
}
