package com.tang.goods.controller;

/*
 *文件名: BrandController
 *创建者: 醉意丶千层梦
 *创建时间:2021/12/31 16:11
 *描述: 这是一个示例
 */


import com.tang.goods.entity.Brand;
import com.tang.goods.operation.BrandOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
public class BrandController {
    @Autowired
    private static Logger logger = LogManager.getLogger(ClientController.class);

    @RequestMapping(value = "/Merchandising/BrandServlet",method = RequestMethod.POST)
    public Map<String,Object> searchClient(HttpServletRequest request) {
        Map<String, String[]> requestParameterMap = request.getParameterMap();
        String operation = requestParameterMap.get("operation")[0];
        Map<String, Object> json = new HashMap<>();
        if(operation.equals("getAllBrand")) {
            System.out.println("获取所有品牌");
            List<Brand> results = null;
            try {
                results=BrandOperation.getBrands();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            json.put("results",results);

        }
        else if(operation.equals("getBrands")) {
            System.out.println("获取品牌");
            List<Brand> results = null;
            try {
                String key=request.getParameter("key");
                results=BrandOperation.searchBrandBykey(key);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            json.put("results",results);
        }
        else if(operation.equals("findBrandByName")) {
            System.out.println("查找指定品牌");
            Brand results=null;
            try {
                String name=request.getParameter("name");
                System.out.println(name);
                results=BrandOperation.getBrandByName(name);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            json.put("results",results);
        }
        else if(operation.equals("addBrand")) {
            System.out.println("添加品牌");
            boolean results=false;
            try {
                Map<String,String[]> map = request.getParameterMap();
                Set<String> keys = map.keySet();
                Brand b=new Brand();
                for(String key : keys) {
                    String[] value = map.get(key);
                    if(key.equals("b[name]"))
                        b.name=value[0];
                    else if(key.equals("b[url]"))
                        b.url=value[0];
                    System.out.println(key + " = " + value[0]);
                }
                Brand tmp=BrandOperation.getBrandByName(b.name);
                if(tmp!=null)
                    results=false;
                else
                    results=BrandOperation.addBrand(b);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            json.put("results",results);
        }

        else if(operation.equals("deleteBrand")) {
            System.out.println("删除指定品牌");
            boolean results=false;
            try {
                String name=request.getParameter("name");
                System.out.println(name);
                results=BrandOperation.deleteBrand(name);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            json.put("results",results);
        }

        else if(operation.equals("updateBrand")) {
            System.out.println("修改指定品牌");
            boolean results=false;
            try {
                Map<String,String[]> map = request.getParameterMap();
                Set<String> keys = map.keySet();
                Brand b=new Brand();
                for(String key : keys) {
                    String[] value = map.get(key);
                    if(key.equals("b[name]"))
                        b.name=value[0];
                    else if(key.equals("b[url]"))
                        b.url=value[0];
                    System.out.println(key + " = " + value[0]);
                }
                results= BrandOperation.updateBrand(b);
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
