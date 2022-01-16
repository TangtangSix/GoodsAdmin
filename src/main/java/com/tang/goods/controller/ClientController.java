package com.tang.goods.controller;

/*
 *文件名: ClientController
 *创建者: 醉意丶千层梦
 *创建时间:2021/12/13 13:16
 *描述: 这是一个示例
 */

import com.tang.goods.entity.Client;
import com.tang.goods.entity.Results;
import com.tang.goods.operation.ClientOperation;
import com.tang.goods.service.ClientService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
public class ClientController {
    @Autowired
    private ClientService clientService;
    private static Logger logger = LogManager.getLogger(ClientController.class);


    @RequestMapping(value = "/Merchandising/ClientServlet",method = RequestMethod.POST)
    public Map<String,Object> searchClient(HttpServletRequest request){
        Map<String,String[]> requestParameterMap=request.getParameterMap();
        String operation=requestParameterMap.get("operation")[0];
        Map<String, Object> json =  new HashMap<>();
        if(operation.equals("getAllClient")) {
            System.out.println("获取所有客户");
            List<Client> results = null;
            try {
                results= ClientOperation.getClients();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            json.put("results",results);

        }

        else if(operation.equals("getClients")) {
            System.out.println("获取客户");
            List<Client> results = null;
            try {
                String key=request.getParameter("key");
                results=ClientOperation.searchClientBykey(key);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            json.put("results",results);
        }

        else if(operation.equals("findClientByNo")) {
            System.out.println("查找指定客户");
            Client results=null;
            try {
                String no=request.getParameter("no");
                System.out.println(no);
                results=ClientOperation.getClientByNo(no);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            json.put("results",results);
        }

        else if(operation.equals("addClient")) {
            System.out.println("添加客户");
            int results=0;
            try {
                Map<String,String[]> map = request.getParameterMap();
                Set<String> keys = map.keySet();
                Client c=new Client();
                for(String key : keys) {
                    String[] value = map.get(key);
                    if(key.equals("c[name]"))
                        c.name=value[0];
                    else if(key.equals("c[no]"))
                        c.no=value[0];
                    else if(key.equals("c[address]"))
                        c.address=value[0];
                    else if(key.equals("c[tNumber]"))
                        c.tNumber=value[0];
                    else if(key.equals("c[password]"))
                        c.password=value[0];
                    else if(key.equals("c[root]"))
                        c.root=value[0];
                    System.out.println(key + " = " + value[0]);
                }
                if(ClientOperation.getClientByNo(c.no)!=null || ClientOperation.getClientByNo(c.tNumber)!=null)
                    results=1;
                else {
                    if(ClientOperation.addClient(c))
                        results=2;
                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            json.put("results",results);
        }

        else if(operation.equals("deleteClient")) {
            System.out.println("删除指定客户");
            boolean results=false;
            try {
                String no=request.getParameter("no");
                System.out.println(no);
                results=ClientOperation.deleteClient(no);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            json.put("results",results);
        }

        else if(operation.equals("updateClient")) {
            System.out.println("修改指定客户");
            boolean results=false;
            try {
                Map<String,String[]> map = request.getParameterMap();
                Set<String> keys = map.keySet();
                Client c=new Client();
                for(String key : keys) {
                    String[] value = map.get(key);
                    if(key.equals("c[name]"))
                        c.name=value[0];
                    else if(key.equals("c[no]"))
                        c.no=value[0];
                    else if(key.equals("c[address]"))
                        c.address=value[0];
                    else if(key.equals("c[tNumber]"))
                        c.tNumber=value[0];
                    else if(key.equals("c[password]"))
                        c.password=value[0];
                    else if(key.equals("c[root]"))
                        c.root=value[0];
                    System.out.println(key + " = " + value[0]);
                }
                results=ClientOperation.updateClient(c);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            json.put("results",results);
        }

        else if(operation.equals("login")) {
            System.out.println("登录");
            Client results=null;
            try {
                String name=request.getParameter("name");
                String password=request.getParameter("password");
                System.out.println(name+password);
                results=ClientOperation.login(name,password);
                System.out.println(results);

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            json.put("results",results);
        }
        else {

        }
        return json;
    }


}
