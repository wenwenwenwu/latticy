package io.github.talelin.latticy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.talelin.latticy.model.BannerDO;

import java.util.List;

//@Repository
//继承了BaseMapper，内置了常用的数据库操作方法接口
public interface TestMapper extends BaseMapper<BannerDO>{

    List<BannerDO> getAllBanners();

    Long insertBanner(BannerDO bannerDO);


}
