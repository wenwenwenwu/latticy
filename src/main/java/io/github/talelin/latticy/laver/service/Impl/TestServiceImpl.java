package io.github.talelin.latticy.laver.service.Impl;

import io.github.talelin.latticy.laver.mapper.TestMapper;
import io.github.talelin.latticy.laver.model.BannerDO;
import io.github.talelin.latticy.laver.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    public List<BannerDO> getBanners(){
        return this.testMapper.getAllBanners();
    }

    public Long insertBanner(){
        BannerDO bannerDO = new BannerDO();
        bannerDO.setTitle("NewBannerTitle");
        bannerDO.setName("NewBanner");
        testMapper.insertBanner(bannerDO);
        return bannerDO.getId();
    }

}
