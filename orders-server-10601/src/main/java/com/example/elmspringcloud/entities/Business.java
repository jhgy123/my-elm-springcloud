package com.example.elmspringcloud.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity//将Course类映射到数据库中
@Table(name = "business_inf")//重命名表名
@Data //生成setter/getter、equals、canEqual、hashCode、toString方法，如为final属性，则不会为该属性生成setter方法。
@Builder
@AllArgsConstructor //生成包含所有字段的构造函数
@NoArgsConstructor //无参构造函数
public class Business extends AbstractDomainEntity {

    @Id//设置主键
    @GeneratedValue(strategy=GenerationType.IDENTITY)//该字段自增
    @Column(nullable = false)//重命名字段名字,非空
    @Schema(description = "主键")
    private int id;
    @Column(length = 20,nullable = false)//设置字段的最大长度为20,非空
    private String password;
    @Column(length = 40,nullable = false)//设置字段的最大长度为40,非空
    private String name;
    @Column(length = 50)//设置字段的最大长度为50
    private String address;
    @Column(length = 40)//设置字段的最大长度为40
    private String explain;
    @Lob
    @Column(columnDefinition="TEXT")
    private String img; //头像，存储的是图片
    private int orderTypeId;
    @Column(precision = 5,scale =2,columnDefinition="decimal(5,2) default 0.0")//设置字段数字宽度为5，小数位数为2，设置字段默认值为0.0
    private double starPrice;
    @Column(precision = 5,scale =2,columnDefinition="decimal(5,2) default 0.0")//设置字段数字宽度为5，小数位数为2,设置字段默认值为0.0
    private double deliveryPrice;
    @Column(length = 400)//设置字段的最大长度为20,非空
    private String remarks;

    @Override
    public String toString() {
        return "Business{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", explain='" + explain + '\'' +
                ", orderTypeId=" + orderTypeId +
                ", starPrice=" + starPrice +
                ", deliveryPrice=" + deliveryPrice +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
