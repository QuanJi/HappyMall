package service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Goods;
import pojo.GoodsExample;
import pojo.MyPageHelder;
import service.all_interface.GoodsInterface;

import java.util.List;

/**
 * @Author: QuanJingyuan
 * @Date: 2019/4/5 0005 15:58
 * @Version 1.0
 */
@Service("goodsInterfaceServiceImpl")
public class GoodsInterfaceServiceImpl implements GoodsInterface {
    @Autowired
    GoodsMapper goodsMapper;
    @Override
    public Goods getGoodsByID(long id) throws Exception {
        return goodsMapper.selectByPrimaryKey(id);
    }
    @Override
    public MyPageHelder getGoodsList(GoodsExample goodsExample,int page,int pageSize) throws Exception {
        MyPageHelder myPageHelder=new MyPageHelder();
        PageHelper.startPage(page,pageSize);
        List<Goods> list=goodsMapper.selectByExampleWithBLOBs(goodsExample);
        myPageHelder.setGoodsList(list);
        PageInfo<Goods> pageInfo=new PageInfo<>(list);
        myPageHelder.setTotal(pageInfo.getTotal());
        return myPageHelder;
    }

    @Override
    public void UpdateGoods(Goods goods) throws Exception {
        goodsMapper.updateByPrimaryKeyWithBLOBs(goods);
    }

    @Override
    public void InsertGoods(Goods goods) throws Exception {
        goodsMapper.insert(goods);
    }

    @Override
    public void DeleteGoods(long[] deleteID) throws Exception {
        for(long id:deleteID)
         goodsMapper.deleteByPrimaryKey(id);
    }

}
