package io.github.talelin.latticy.dto;

import io.github.talelin.autoconfigure.validator.Length;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.List;

@Setter
@Getter
public class SpuDTO {

    @NotBlank
    @Length(min = 1, max = 128)
    private String title;

//    @NotBlank
    @Length(min = 1, max = 255)
    private String subtitle;

//    @NotBlank
    @Length(min = 1, max = 255)
    private String img;

    @Length(min = 1, max = 255)
    private String forThemeImg;

    @Positive
    @NotNull
    private Integer categoryId;

    @Max(1)
    @Min(0)
    @NotNull
    private Integer online;

    @Positive
    private Long sketchSpecId;

    @Positive
    private Long defaultSkuId;

    @NotBlank
    @Length(min = 1, max = 20)
    private String price;

    @Length(min = 1, max = 20)
    private String discountPrice;

    @Length(min = 1, max = 255)
    private String description;

    @Length(min = 1, max = 255)
    private String tags;

    private List<Integer> specKeyIdList;

    private List<String> spuImgList;

    private List<String> spuDetailImgList;

}
