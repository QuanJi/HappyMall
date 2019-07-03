package mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pojo.OrderExample;
import pojo.Order;
public interface OrderMapper {
    int countByExample(OrderExample example);

    int deleteByExample(OrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Order record);

    int insertSelective(Order record);

    int getMaxID();

    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
    List<Order> selectByExample(OrderExample example);
    /*订单和订单明细表的一对多查询*/
    List<Order> findUserAndOrderDetail();
    Order selectByPrimaryKey(Long id);

}