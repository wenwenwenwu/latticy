package io.github.talelin.latticy.laver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.talelin.latticy.laver.model.BannerDO;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
//继承了BaseMapper，内置了常用的数据库操作方法接口
public interface TestMapper extends BaseMapper<BannerDO>{

    List<BannerDO> getAllBanners();

    Long insertBanner(BannerDO bannerDO);


}
