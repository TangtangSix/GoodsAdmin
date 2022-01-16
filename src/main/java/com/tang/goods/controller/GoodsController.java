package com.tang.goods.controller;

import com.tang.goods.entity.Goods;
import com.tang.goods.operation.GoodsOperation;
import com.tang.goods.service.GoodsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 *文件名: GoodsController
 *创建者: 醉意丶千层梦
 *创建时间:2021/12/13 13:16
 *描述: 这是一个示例
 */
@RestController
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    private static Logger logger = LogManager.getLogger(GoodsController.class);

    @RequestMapping(value = "/Merchandising/GoodsServlet",method = RequestMethod.POST)
    public Map<String,Object> searchClient(HttpServletRequest request) {
        Map<String, String[]> requestParameterMap = request.getParameterMap();
        String operation = requestParameterMap.get("operation")[0];
        Map<String, Object> json = new HashMap<>();
        if(operation.equals("getAllGoods")) {
            System.out.println("获取所有商品");
            List<Goods> results = null;
            try {
                String key=request.getParameter("key");
                results=GoodsOperation.searchGoodsBykey(key);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            json.put("results",results);
        }
        else if(operation.equals("getBrands")) {
            System.out.println("获取所有品牌");
            List<String> results = null;
            try {
                results=GoodsOperation.getBrands();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            json.put("results",results);
        }

        else if(operation.equals("getSorts")) {
            System.out.println("获取所有分类");
            List<String> results = null;
            try {
                results=GoodsOperation.getSorts();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            json.put("results",results);
        }

        else if(operation.equals("findGoodByNo")) {
            System.out.println("查找指定编号商品");
            Goods results=null;
            try {
                String no=request.getParameter("no");
                System.out.println(no);
                results=GoodsOperation.getGoodByNo(no);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            json.put("results",results);
        }

        else if(operation.equals("addSort")) {
            System.out.println("添加分类");
            boolean results=false;
            try {
                String no=request.getParameter("sort");
                System.out.println(no);
                results=GoodsOperation.addSort(no);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            json.put("results",results);
        }

        else if(operation.equals("addGood")) {
            System.out.println("添加商品");
            boolean results=false;
            try {
                Map<String,String[]> map = request.getParameterMap();
                Set<String> keys = map.keySet();
                Goods g=new Goods();
                for(String key : keys) {
                    String[] value = map.get(key);
                    if(key.equals("g[no]"))
                        g.no=value[0];
                    else if(key.equals("g[bname]"))
                        g.bname=value[0];
                    else if(key.equals("g[name]"))
                        g.name=value[0];
                    else if(key.equals("g[unit]"))
                        g.unit=value[0];
                    else if(key.equals("g[p1]"))
                        g.p1=Integer.parseInt(value[0]);
                    else if(key.equals("g[p2]"))
                        g.p2=Integer.parseInt(value[0]);
                    else if(key.equals("g[p3]"))
                        g.p3=Integer.parseInt(value[0]);
                    else if(key.equals("g[introduction]"))
                        g.introduction=value[0];
                    else if(key.equals("g[stock]"))
                        g.stock=Integer.parseInt(value[0]);
                    else if(key.equals("g[sort]"))
                        g.sort=value[0];
                    System.out.println(key + " = " + value[0]);
                }

                Goods tmp=GoodsOperation.getGoodByNo(g.no);
                if(tmp!=null)
                    results=false;
                else {
                    results=(GoodsOperation.addGood(g) && GoodsOperation.addSortAfterAddGood(g.no, g.sort));
                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            json.put("results",results);
        }

        else if(operation.equals("deleteGoods")) {
            System.out.println("删除指定编号商品");
            boolean results=false;
            try {
                String no=request.getParameter("no");
                System.out.println(no);
                results=GoodsOperation.deleteGoods(no);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            json.put("results",results);
        }

        else if(operation.equals("updateGoods")) {
            System.out.println("修改指定编号商品");
            boolean results=false;
            try {
                Map<String,String[]> map = request.getParameterMap();
                Set<String> keys = map.keySet();
                Goods g=new Goods();
                for(String key : keys) {
                    String[] value = map.get(key);
                    if(key.equals("g[no]"))
                        g.no=value[0];
                    else if(key.equals("g[bname]"))
                        g.bname=value[0];
                    else if(key.equals("g[name]"))
                        g.name=value[0];
                    else if(key.equals("g[unit]"))
                        g.unit=value[0];

                    else if(key.equals("g[p1]"))
                        g.p1=Integer.parseInt(value[0]);
                    else if(key.equals("g[p2]"))
                        g.p2=Integer.parseInt(value[0]);
                    else if(key.equals("g[p3]"))
                        g.p3=Integer.parseInt(value[0]);

                    else if(key.equals("g[introduction]"))
                        g.introduction=value[0];
                    else if(key.equals("g[stock]"))
                        g.stock=Integer.parseInt(value[0]);
                    System.out.println(key + " = " + value[0]);
                }
                results= GoodsOperation.updateGoods(g);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            json.put("results",results);
        }
        return json;
    }



}
