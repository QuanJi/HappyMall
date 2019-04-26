package service;

import mapper.OrderDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.OrderDetail;
import pojo.OrderDetailExample;

import java.util.List;

/**
 * @Author: QuanJingyuan
 * @Date: 2019/4/25 0025 11:18
 * @Version 1.0
 */
@Service
public class OrderDetailImpl {
    @Autowired
    OrderDetailMapper detailMapper;
    public List<OrderDetail> FindOrderDetail(Integer id){
        OrderDetailExample orderDetailExample=new OrderDetailExample();
        OrderDetailExample.Criteria criteria=orderDetailExample.createCriteria();
        criteria.andOrderIdEqualTo(id.longValue());
        List<OrderDetail> list=detailMapper.selectByExample(orderDetailExample);
        return list;
    }
}
