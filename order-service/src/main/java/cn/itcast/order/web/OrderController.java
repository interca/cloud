package cn.itcast.order.web;

import cn.itcast.order.pojo.Order;
import cn.itcast.order.service.OrderService;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("order")
public class OrderController {

   @Autowired
   private OrderService orderService;

   @SentinelResource("hot")
    @GetMapping("{orderId}")
    public Order queryOrderByUserId(@PathVariable("orderId") Long orderId) {
        // 根据id查询订单并返回
        return orderService.queryOrderById(orderId);
    }

    @GetMapping("/query")
    public String query(){
        orderService.queryGoods();
        return "查询订单成功";
    }

    @GetMapping("/update")
    public String update(){
        orderService.queryGoods();
        return "更新订单成功";
    }
}
