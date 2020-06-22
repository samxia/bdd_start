package com.x.cart;


import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * copy from http://www.monkey1024.com/javase/596
 * for using BDD Cucumber
 * author:sam
 * date:2020-6-22
 */

/**
 * 购物车类
 *里面实现商品的添加、删除、总价，清空等功能
 */
public class ShopCart {

    //用来存放商品信息和数量
    Map<Product, Integer> productMap;

    BigDecimal totalPrice = BigDecimal.valueOf(0.0);

    public ShopCart(){
        productMap = new HashMap<>();
    }

    //向购物车中添加商品和数量
    public void add(Product product, int num){
        //判断map中是否包含当前商品，如果不包含则直接将商品和数量添加到map里面
        if(!productMap.containsKey(product)){
            productMap.put(product, num);
        }else{
            //如果程序走到这里，说明之前已经向购物车中添加过当前商品，需要将数量进行相加运算
            int before = productMap.get(product);//取得之前购物车中的商品数量
            int after = before + num;
            productMap.put(product, after);
        }

        //总价 = 商品单价 * 数量
        totalPrice = totalPrice.add(product.getPrice().multiply(BigDecimal.valueOf(num)));
    }

    //从购物车中删除商品和数量
    public void remove(Product product, int num){
        //获取购物车中的商品数量
        int before = productMap.get(product);
        if(num >= before){
            //将该商品从购物车中删除
            productMap.remove(product);
            totalPrice = totalPrice.subtract(product.getPrice().multiply(BigDecimal.valueOf(before)));
        }else{
            //剩余的商品数量
            int after = before - num;
            productMap.put(product, after);
            totalPrice = totalPrice.subtract(product.getPrice().multiply(BigDecimal.valueOf(num)));
        }


    }

    //清空购物车
    public void clear(){
        productMap.clear();
        totalPrice = BigDecimal.valueOf(0.0);
    }

    //打印详单
    public void print(){
        System.out.println("商品清单:");

        Set<Product> key = productMap.keySet();
        Iterator<Product> iter = key.iterator();

        while(iter.hasNext()){
            Product p = iter.next();
            Integer i = productMap.get(p);
            System.out.println(i + "个     " + p + "\t" + p.getPrice().multiply(BigDecimal.valueOf(i)));
        }

        System.out.println("\t\t\t\t\t总价：" + totalPrice);
    }
}