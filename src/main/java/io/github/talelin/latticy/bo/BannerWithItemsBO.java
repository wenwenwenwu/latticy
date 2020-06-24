package io.github.talelin.latticy.bo;

import io.github.talelin.latticy.model.BannerDO;
import io.github.talelin.latticy.model.BannerItemDO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Getter
@Setter
public class BannerWithItemsBO {
    private Long id;
    private String name;
    private String title;
    private String description;
    private String img;
    List<BannerItemDO> items;

    public BannerWithItemsBO(BannerDO bannerDO, List<BannerItemDO>bannerItemDOS){
        BeanUtils.copyProperties(bannerDO,this);
        this.setItems(bannerItemDOS);
    }
}
