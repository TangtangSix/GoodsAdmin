package com.tang.goods.mapper;

import com.tang.goods.entity.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/*
 *文件名: OrderMapper
 *创建者: 醉意丶千层梦
 *创建时间:2021/12/13 13:21
 *描述: 这是一个示例
 */
@Mapper
public interface OrderMapper {
    List<Order> searchOrder(String key);

    int insertOrder(Order order);

    int deleteOrder(String no);

    int updateOrder(Order order);
}
