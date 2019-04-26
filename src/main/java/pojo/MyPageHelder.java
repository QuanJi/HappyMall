package pojo;

import java.util.List;

/**
 * @Author: QuanJingyuan
 * @Date: 2019/4/8 0008 17:29
 * @Version 1.0
 */
public class MyPageHelder {

    long total;
    List<Goods> goodsList;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }
}
