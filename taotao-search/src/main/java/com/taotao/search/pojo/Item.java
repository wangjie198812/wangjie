package com.taotao.search.pojo;

import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.beans.Field;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 商品表
 */
// 反序列化时，忽略json中未知的一些字段
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {
    @Field
    private Long id;

    @Field
    private String title;

    @Field
    private String sellPoint;

    @Field
    private Long price;

    @Field
    private String image;

   
    @Field
    private Integer status;

    @Field
    private Long created;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public Long getcreated() {
        return created;
    }

    public void setcreated(Long created) {
        this.created = created;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSellPoint() {
        return sellPoint;
    }

    public void setSellPoint(String sellPoint) {
        this.sellPoint = sellPoint;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

  

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    // 获取图片的方法
    public String[] getImages() {
        return StringUtils.split(getImage(), ",");
    }

    @Override
    public String toString() {
        return "Item [id=" + id + ", title=" + title + ", sellPoint=" + sellPoint + ", price=" + price
                + ", image=" + image + ",  status=" + status + ", created=" + created + "]";
    }
}
