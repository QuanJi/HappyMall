package pojo;

import org.springframework.stereotype.Component;

@Component("goods")
public class Goods {
    private Long id;

    private String goodsName;

    private String goodsClassify;

    private Double goodsPrice;

    private String storeName;

    private String goodsImage;

    private String goodsDescribe;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public String getGoodsClassify() {
        return goodsClassify;
    }

    public void setGoodsClassify(String goodsClassify) {
        this.goodsClassify = goodsClassify == null ? null : goodsClassify.trim();
    }

    public Double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName == null ? null : storeName.trim();
    }

    public String getGoodsImage() {
        return goodsImage;
    }

    public void setGoodsImage(String goodsImage) {
        this.goodsImage = goodsImage == null ? null : goodsImage.trim();
    }

    public String getGoodsDescribe() {
        return goodsDescribe;
    }

    public void setGoodsDescribe(String goodsDescribe) {
        this.goodsDescribe = goodsDescribe == null ? null : goodsDescribe.trim();
    }

    @Override
    public String toString() {
        return "id=" + id +
                "#goodsName=" + goodsName +
                "#goodsClassify=" + goodsClassify +
                "#goodsPrice=" + goodsPrice +
                "#storeName=" + storeName +
                "#goodsImage=" + goodsImage +
                "#goodsDescribe=" + goodsDescribe;
    }
}