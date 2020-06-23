package io.github.talelin.latticy.service.impl;

import io.github.talelin.latticy.mapper.TestMapper;
import io.github.talelin.latticy.model.BannerDO;
import io.github.talelin.latticy.service.TestService;
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
