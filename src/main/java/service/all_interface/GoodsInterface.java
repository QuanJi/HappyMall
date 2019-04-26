package service.all_interface;

import mapper.GoodsMapper;
import org.springframework.stereotype.Service;
import pojo.Goods;
import pojo.GoodsExample;
import pojo.MyPageHelder;

import java.util.List;

/**
 * @Author: QuanJingyuan
 * @Date: 2019/4/5 0005 15:57
 * @Version 1.0
 */
public interface GoodsInterface {
     Goods getGoodsByID(long id)throws Exception;
     MyPageHelder getGoodsList(GoodsExample goodsExample, int page, int pageSize)throws Exception;
     void UpdateGoods(Goods goods)throws Exception;
     void InsertGoods(Goods goods)throws Exception;
     void DeleteGoods(long[] deleteID)throws Exception;
}
