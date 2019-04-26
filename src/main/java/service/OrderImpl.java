package service;

import mapper.OrderDetailMapper;
import mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Order;
import pojo.OrderDetail;
import service.all_interface.OrderInterface;

import java.util.List;

/**
 * @Author: QuanJingyuan
 * @Date: 2019/4/20 0020 20:23
 * @Version 1.0
 */
@Service
public class OrderImpl implements OrderInterface {
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    OrderDetailMapper orderDetailMapper;
    @Override
    public List<Order> findUserAndOrderDetail() throws Exception {
        List<Order> order=orderMapper.findUserAndOrderDetail();
        return order ;
    }

    @Override
    public void InsertOrder(Order order) throws Exception {
        orderMapper.insertSelective(order);
        int MaxID=orderMapper.getMaxID();
        for(OrderDetail detail:order.getList()){
            detail.setOrderId(Integer.valueOf(MaxID).longValue());
            orderDetailMapper.insertSelective(detail);
        }

    }
}
