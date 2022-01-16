package com.tang.goods.service;

import com.tang.goods.entity.OrderDetail;
import com.tang.goods.mapper.OrderDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 *文件名: OrderDetailService
 *创建者: 醉意丶千层梦
 *创建时间:2021/12/13 13:19
 *描述: 这是一个示例
 */
@Service
public class OrderDetailService {
    @Autowired
    private OrderDetailMapper orderDetailMapper;

    /**
     * 查找指定订单的订单明细
     *
     * @param no 订单编号
     * @return 订单明细
     */
    public List<OrderDetail> searchOrderDetailByNo(String no){
        return orderDetailMapper.searchOrderDetailByNo(no);
    }

    public List<OrderDetail> searchOrderDetailByOrderNo(String OrderNo){
        return orderDetailMapper.searchOrderDetailByOrderNo(OrderNo);
    }
}
