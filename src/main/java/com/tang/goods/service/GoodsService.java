package com.tang.goods.service;

import com.tang.goods.entity.Goods;
import com.tang.goods.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 *文件名: GoodsService
 *创建者: 醉意丶千层梦
 *创建时间:2021/12/13 13:19
 *描述: 这是一个示例
 */
@Service
public class GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    /**
     * 增加商品
     *
     * @param goods 商品
     * @return 操作结果,成功 - 1, 失败 - 0
     */
    public int insertGoods(Goods goods){
        return goodsMapper.insertGoods(goods);
    }


    /**
     * 删除商品
     *
     * @param no 商品编号
     * @return  操作结果,成功 - 1, 失败 - 0
     */
    public int deleteGoods(String no){
        return goodsMapper.deleteGoods(no);
    }

    /**
     * 修改商品
     *
     * @param goods  新的商品信息
     * @return  操作结果,成功 - 1, 失败 - 0
     */
    public int updateGoods(Goods goods){
        return goodsMapper.updateGoods(goods);
    }

    /**
     * 模糊查询商品名称和描述
     *
     * @param key 查询关键字
     * @return 查询结果
     */
    public List<Goods> searchGoods(String key){
        return goodsMapper.searchGoods(key);
    }
}
