package io.github.talelin.latticy.laver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.talelin.latticy.laver.model.BannerDO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TestMapper extends BaseMapper<BannerDO> {

    List<BannerDO> getAllBanners();

    Long insertBanner(BannerDO bannerDO);

    @Select("select * from banner")
    List<BannerDO> getAllBanners1();

}
