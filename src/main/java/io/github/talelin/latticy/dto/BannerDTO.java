package io.github.talelin.latticy.dto;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class BannerDTO {
    @Length(min = 2,max = 20) //name为空的话不会校验
    @NotBlank //因此还要添加非空注解
    private String name;

    @Length(min = 2,max = 30)
    private String title;

    @Length(min = 2,max = 256)
    private String description;

    @Length(min = 2,max = 256)
    private String img;
}
