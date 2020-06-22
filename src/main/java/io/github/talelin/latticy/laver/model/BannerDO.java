package io.github.talelin.latticy.laver.model;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@TableName("banner")  //Mybatis plus需要。BannerDO如果添加了该注解，会以banner_do自动映射数据表。所以需要标注一下banner
public class BannerDO {
    private Long id;
    private String name;
    private String title;
    private String description;
    private String img;
    @JsonIgnore
    private Date createTime;
    @JsonIgnore
    private Date updateTime;
    @JsonIgnore
    @TableLogic
    private Date deleteTime;
}
