package com.tang.goods.controller;

import com.tang.goods.entity.Order;
import com.tang.goods.entity.OrderDetail;
import com.tang.goods.operation.OrderOperation;
import com.tang.goods.service.OrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 *文件名: OrderController
 *创建者: 醉意丶千层梦
 *创建时间:2021/12/13 13:17
 *描述: 这是一个示例
 */
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    private static Logger logger = LogManager.getLogger(ClientController.class);


    @RequestMapping(value = "/Merchandising/OrderServlet",method = RequestMethod.POST)
    public Map<String,Object> searchClient(HttpServletRequest request) {
        Map<String, String[]> requestParameterMap = request.getParameterMap();
        String operation = requestParameterMap.get("operation")[0];
        Map<String, Object> json = new HashMap<>();
        if(operation.equals("getAllOrders")) {
            System.out.println("获取所有订单");
            List<Order> results = null;
            try {
                results=OrderOperation.getOrders();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            json.put("results",results);
        }
        else if(operation.equals("getOrders")) {
            System.out.println("获取订单");
            List<Order> results = null;
            try {
                String key=request.getParameter("key");
                results=OrderOperation.searchOrderBykey(key);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            json.put("results",results);
        }
        else if(operation.equals("findOrderByNo")) {
            System.out.println("查找指定订单");
            Order results=null;
            try {
                String no=request.getParameter("no");
                System.out.println(no);
                results=OrderOperation.getOrderByNo(no);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            json.put("results",results);
        }
        else if(operation.equals("addOrder")) {
            System.out.println("添加订单");
            boolean results=false;
            try {
                Map<String,String[]> map = request.getParameterMap();
                Set<String> keys = map.keySet();
                Order o=new Order();
                for(String key : keys) {
                    String[] value = map.get(key);
                    if(key.equals("o[cNo]"))
                        o.cNo=value[0];
                    else if(key.equals("o[no]"))
                        o.no=value[0];
                    else if(key.equals("o[postcode]"))
                        o.postcode=value[0];
                    else if(key.equals("o[date]"))
                        o.date=value[0];
                    else if(key.equals("o[amount]")) {
                        o.amount=Float.parseFloat(value[0]);
                    }
                    System.out.println(key + " = " + value[0]);
                }
                results=OrderOperation.addOrder(o);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            json.put("results",results);
        }

        else if(operation.equals("deleteOrder")) {
            System.out.println("删除指定订单");
            boolean results=false;
            try {
                String no=request.getParameter("no");
                results=OrderOperation.deleteOrder(no);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            json.put("results",results);
        }

        else if(operation.equals("updateOrder")) {
            System.out.println("修改指定订单");
            boolean results=false;
            try {
                Map<String,String[]> map = request.getParameterMap();
                Set<String> keys = map.keySet();
                Order o=new Order();
                for(String key : keys) {
                    String[] value = map.get(key);
                    if(key.equals("o[cNo]"))
                        o.cNo=value[0];
                    else if(key.equals("o[no]"))
                        o.no=value[0];
                    else if(key.equals("o[postcode]"))
                        o.postcode=value[0];
                    else if(key.equals("o[date]"))
                        o.date=value[0];
                    else if(key.equals("o[amount]")) {
                        o.amount=Float.parseFloat(value[0]);
                    }
                    System.out.println(key + " = " + value[0]);
                }
                results=OrderOperation.updateOrder(o);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            json.put("results",results);
        }

        else if(operation.equals("getOrderDetailByNo")) {
            System.out.println("获取订单明细");
            List<OrderDetail> results = null;
            try {
                String no=request.getParameter("no");
                results= OrderOperation.getOrderDetailByoNo(no);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            json.put("results",results);
        }
        else if(operation.equals("addOrderDetail")) {
            System.out.println("添加订单明细");
            boolean results=false;
            try {
                Map<String,String[]> map = request.getParameterMap();
                Set<String> keys = map.keySet();
                OrderDetail o=new OrderDetail();
                for(String key : keys) {
                    String[] value = map.get(key);
                    if(key.equals("o[no]"))
                        o.no=value[0];
                    else if(key.equals("o[oNo]"))
                        o.oNo=value[0];
                    else if(key.equals("o[gNo]"))
                        o.gNo=value[0];
                    else if(key.equals("o[n]"))
                        o.n=Integer.parseInt(value[0]);
                    else if(key.equals("o[price]"))
                        o.price=Double.parseDouble(value[0]);
                    else if(key.equals("o[amount]")) {
                        o.amount=Double.parseDouble(value[0]);
                    }
                    System.out.println(key + " = " + value[0]);
                }
                results=OrderOperation.addOrderDetail(o);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            json.put("results",results);
        }

//		else if(operation.equals("deleteOrder")) {
//			System.out.println("删除指定订单");
//			boolean results=false;
//			try {
//				String no=request.getParameter("no");
//				results=OrderOperation.deleteOrder(no);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			json.put("results",results);
//		}

//		else if(operation.equals("updateOrder")) {
//			System.out.println("修改指定订单");
//			boolean results=false;
//			try {
//				 Map<String,String[]> map = request.getParameterMap();
//				 Set<String> keys = map.keySet();
//				 Order o=new Order();
//				 for(String key : keys) {
//					 String[] value = map.get(key);
//			           if(key.equals("c[cNo]"))
//			        	   o.cNo=value[0];
//			           else if(key.equals("c[no]"))
//			        	   o.no=value[0];
//			           else if(key.equals("c[postcode]"))
//			        	   o.postcode=value[0];
//			           else if(key.equals("c[date]"))
//			        	   o.date=value[0];
//			           else if(key.equals("c[amount]")) {
//			        	   o.amount=Float.parseFloat(value[0]);
//			           }
//			           System.out.println(key + " = " + value[0]);
//			      }
//				results=OrderOperation.updateOrder(o);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			json.put("results",results);
//		}

        else {

        }
        return json;
    }
}
