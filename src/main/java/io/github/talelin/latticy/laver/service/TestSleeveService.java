package io.github.talelin.latticy.laver.service;

import io.github.talelin.latticy.laver.mapper.TestMapper;
import io.github.talelin.latticy.laver.model.BannerDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestSleeveService {

    @Autowired
    private TestMapper bannerMapper;

    public List<BannerDO> getBanners(){
        return this.bannerMapper.getAllBanners();
    }

    public Long insertBanner(){
        BannerDO bannerDO = new BannerDO();
        bannerDO.setTitle("NewBannerTitle");
        bannerDO.setName("NewBanner");
        bannerMapper.insertBanner(bannerDO);
        return bannerDO.getId();
    }

    public List<BannerDO> getBanners1(){
        return  this.bannerMapper.getAllBanners1();
    }
}
