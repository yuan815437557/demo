package com.yuan.Thread.title;

import lombok.Data;
import lombok.SneakyThrows;

import java.util.Date;
import java.util.Map;
/**
 * 创建一个商品类, 商品有编号, 价格, 生产日期属性,商品的编号不能重复.
 * 创建一个仓库类, 用户储存商品, 仓库类中使用Map集合, 将商品的编号当作是key,
 * 仓库有存储和取出的方法,创建两个工人和两个消费者, 工人生产商品, 消费者消费商品,
 * 永不停止如果消费者消费时没有商品了, 就打印一句话:"快点生产呀", 然后休息1秒钟
 * */
@Data
public class Warehouse {
    private Map<Integer, Commodity> commodity;
    private static Integer total = 0;

    public void product(Integer id, Integer price, Date date){
        commodity.put(id, new Commodity(id, price, date));
    }

    public void consume(Integer id){
        commodity.remove(id);
    }

    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        Thread producer1 = new Thread("producer1"){
            Integer sum = 0;
            @Override
            public void run() {
                while (sum < 10) {
                    warehouse.product(total, total * 12, new Date());
                    total ++;
                    sum ++;
                }
                System.out.println(getName() + "生产了" + sum + "个");
            }
        };
        Thread producer2 = new Thread("producer2"){
            Integer sum = 0;
            @Override
            public void run() {
                while (sum < 10) {
                    warehouse.product(total, total * 12, new Date());
                    total ++;
                    sum ++;
                }
                System.out.println(getName() + "生产了" + sum + "个");
            }
        };
        Thread consumer1 = new Thread("consumer1"){
            @SneakyThrows
            @Override
            public void run() {
                while (true){
                    Integer sum = total;
                    if (warehouse.commodity.size() == 0){
                        System.out.println("快点生产啊");
                        Thread.sleep(1000);
                    }
                    warehouse.consume(sum);
                    System.out.println(getName() + "使用了一个商品");
                    sum --;
                }
            }
        };
        Thread consumer2 = new Thread("consumer2"){
            @SneakyThrows
            @Override
            public void run() {
                while (true){
                    Integer sum = total;
                    if (warehouse.commodity.size() == 0){
                        System.out.println("快点生产啊");
                        Thread.sleep(1000);
                    }
                    warehouse.consume(sum);
                    System.out.println(getName() + "使用了一个商品");
                    sum --;
                }
            }
        };
        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();
    }
}
