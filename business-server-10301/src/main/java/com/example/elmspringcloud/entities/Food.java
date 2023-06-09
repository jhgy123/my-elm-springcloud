package com.example.elmspringcloud.entities;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity//将Course类映射到数据库中
@Table(name = "food_inf")//重命名表名
@Data //生成setter/getter、equals、canEqual、hashCode、toString方法，如为final属性，则不会为该属性生成setter方法。
@Builder
@AllArgsConstructor //生成包含所有字段的构造函数
@NoArgsConstructor //无参构造函数
public class Food extends AbstractDomainEntity {
    @Id//设置主键
    @Schema(description = "主键")
    @GeneratedValue(strategy= GenerationType.IDENTITY)//该字段自增
    @Column(nullable = false)//重命名字段名字,非空
    private int id;

    @Column(length = 30,nullable = false)//重命名字段名字、设置字段的最大长度为30,非空
    private String foodName;

    @Column(length = 30)//重命名字段名字、设置字段的最大长度为30
    private String foodExplain;

    @Lob
    @Column(columnDefinition="TEXT")
    private String img; //头像，存储的是图片
    @Column(precision = 5,scale =2,nullable = false,columnDefinition="decimal(5,2) default 0.0")//重命名字段名字、设置字段数字宽度为5，小数位数为2，非空,默认值0.0
    private double foodPrice;
    @ManyToOne(targetEntity = Business.class)//设置对应的实体类的类型(默认Business的主键作为外键）
    private Business business;
    @Column(length = 400)//设置字段的最大长度为20,非空
    private String remarks;

    @Override
    public String toString() {
        return "Food{" +
                "foodId=" + id +
                ", foodName='" + foodName + '\'' +
                ", foodExplain='" + foodExplain + '\'' +
                ", foodPrice=" + foodPrice +
                ", business=" + business +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
