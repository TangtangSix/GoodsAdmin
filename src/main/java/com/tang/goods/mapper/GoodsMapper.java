package com.tang.goods.mapper;

import com.tang.goods.entity.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/*
 *文件名: GoodsMapper
 *创建者: 醉意丶千层梦
 *创建时间:2021/12/13 13:21
 *描述: 这是一个示例
 */
@Mapper
public interface GoodsMapper {
    int insertGoods(Goods goods);

    int deleteGoods(String no);

    int updateGoods(Goods goods);

    List<Goods> searchGoods(String key);
}
