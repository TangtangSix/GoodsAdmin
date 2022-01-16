package com.tang.goods.service;

import com.tang.goods.entity.Client;
import com.tang.goods.mapper.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 *文件名: ClientService
 *创建者: 醉意丶千层梦
 *创建时间:2021/12/13 13:18
 *描述: 这是一个示例
 */
@Service
public class ClientService {
    @Autowired
    ClientMapper clientMapper;


    /**
     * 模糊查询客户
     *
     * @param key 查询关键字
     * @return 查询结果
     */
    public List<Client> searchClients(String key){
        return clientMapper.searchClients(key);
    }


    /**
     * 查找是否存在指定客户
     *
     * @param client 客户信息
     * @return 存在返回客户信息, 不存在返回null
     */
    public Client findClient(Client client){
        return clientMapper.findClient(client);
    }

    public Client getClient(String no){
        return clientMapper.getClient(no);
    }

    /**
     * 插入客户信息
     *
     * @param client 客户信息
     * @return 操作结果,成功 - 1, 失败 - 0
     */
    public int insertClient(Client client){
        return clientMapper.insertClient(client);
    }

    /**
     * 删除指定编号客户
     *
     * @param no 编号
     * @return 操作结果,成功 - 1, 失败 - 0
     */
    public int deleteClient(String no){
        return clientMapper.deleteClient(no);
    }


    /**
     * 更新客户信息
     *
     * @param client 新的客户信息
     * @return 操作结果,成功 - 1, 失败 - 0
     */
    public int updateClient(Client client){
        return clientMapper.updateClient(client);
    }
}
