package io.github.talelin.latticy.laver.service;

import io.github.talelin.latticy.laver.mapper.BannerMapper;
import io.github.talelin.latticy.laver.model.BannerBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WWTestSleeveService {

    @Autowired
    private BannerMapper bannerMapper;

    public List<BannerBO> getBanners(){
        return this.bannerMapper.getAllMappers();
    }
}
