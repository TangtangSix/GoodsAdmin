package com.tang.goods.service;

import com.tang.goods.entity.Order;
import com.tang.goods.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 *文件名: OrderService
 *创建者: 醉意丶千层梦
 *创建时间:2021/12/13 13:19
 *描述: 这是一个示例
 */
@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;

    /**
     * 模糊查询订单编号
     *
     * @param key 关键字
     * @return 查询结果
     */
    public List<Order> searchOrder(String key){
        return orderMapper.searchOrder(key);
    }

    /**
     * 插入订单
     *
     * @param order 订单
     * @return 操作结果,成功 - 1, 失败 - 0
     */
    public int insertOrder(Order order){
        return orderMapper.insertOrder(order);
    }


    /**
     * 删除订单
     *
     * @param no 订单编号
     * @return 操作结果,成功 - 1, 失败 - 0
     */
    public int deleteOrder(String no){
        return orderMapper.deleteOrder(no);
    }


    /**
     * 更新订单
     *
     * @param order 订单
     * @return 操作结果,成功 - 1, 失败 - 0
     */
    public int updateOrder(Order order){
        return orderMapper.updateOrder(order);
    }
}
