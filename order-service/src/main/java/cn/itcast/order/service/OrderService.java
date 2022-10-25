package cn.itcast.order.service;

import cn.itcast.fegin.clients.UserClient;
import cn.itcast.fegin.pojo.User;
import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

   /* @Autowired
    private RestTemplate restTemplate;
    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        //2发送http请求查询用户
        //获取发送路径
        String url = "http://userservice/user/"+order.getUserId();
        //发送请求 实现远程调用
        User user = restTemplate.getForObject(url, User.class);
        //封装user到order
        order.setUser(user);
        // 4.返回
        return order;
    }/*

    */

    @Autowired
    private UserClient userClient;
    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        //2发送http请求查询用户
        //用feign远程调用
        //发送请求 实现远程调用
        User user = userClient.findById(order.getUserId());
        //封装user到order
        order.setUser(user);
        // 4.返回
        return order;
    }

}

