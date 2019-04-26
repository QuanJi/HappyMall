package service.all_interface;

import org.aspectj.weaver.ast.Or;
import pojo.Order;

import java.util.List;

/**
 * @Author: QuanJingyuan
 * @Date: 2019/4/20 0020 20:22
 * @Version 1.0
 */
public interface OrderInterface {
    List<Order> findUserAndOrderDetail()throws  Exception;
    void InsertOrder(Order order)throws Exception;
}
