package com.example.elmspringcloud.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity//将Course类映射到数据库中
@Table(name = "orderdetailet_inf")//重命名表名
@Data //生成setter/getter、equals、canEqual、hashCode、toString方法，如为final属性，则不会为该属性生成setter方法。
@Builder
@AllArgsConstructor //生成包含所有字段的构造函数
@NoArgsConstructor //无参构造函数
public class Orderdetailet extends AbstractDomainEntity {
    @Id//设置主键
    @Schema(description = "主键")
    @GeneratedValue(strategy= GenerationType.IDENTITY)//该字段自增
    @Column(nullable = false)//重命名字段名字,非空
    private int id;
    @ManyToOne(targetEntity = Orders.class)//设置对应的实体类的类型(默认Orders的主键作为外键）
    private Orders orders;
    @ManyToOne(targetEntity = Food.class)//设置对应的实体类的类型(默认Food的主键作为外键）
    private Food food;
    @Column(nullable = false)//非空
    private int quantity;
}
