package io.github.talelin.latticy.model;

import lombok.Data;

import java.util.List;


@Data
public class SpuDetailDO extends SpuDO {

    private String categoryTitle;

    private String sketchSpecKeyName;

    private String defaultSkuTitle;

    private List<String> spuImgList;

    private List<String> spuDetailImgList;
}
