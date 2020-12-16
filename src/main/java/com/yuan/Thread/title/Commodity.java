package com.yuan.Thread.title;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * 创建一个商品类, 商品有编号, 价格, 生产日期属性,商品的编号不能重复.
 * 创建一个仓库类, 用户储存商品, 仓库类中使用Map集合, 将商品的编号当作是key,
 * 仓库有存储和取出的方法,创建两个工人和两个消费者, 工人生产商品, 消费者消费商品,
 * 永不停止如果消费者消费时没有商品了, 就打印一句话:"快点生产呀", 然后休息1秒钟
 * */
@Data
@AllArgsConstructor
public class Commodity {
    private Integer id;
    private Integer price;
    private Date date;
}
