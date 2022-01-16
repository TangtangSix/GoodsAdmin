package com.tang.goods.mapper;

import com.tang.goods.entity.Client;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/*
 *文件名: ClientMapper
 *创建者: 醉意丶千层梦
 *创建时间:2021/12/13 13:20
 *描述: 这是一个示例
 */
@Mapper
public interface ClientMapper {
    List<Client> searchClients(String key);
    Client findClient(Client client);
    Client getClient(String no);
    int insertClient(Client client);
    int deleteClient(String no);
    int updateClient(Client client);
}
