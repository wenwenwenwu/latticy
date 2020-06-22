package io.github.talelin.latticy.laver.service;

import io.github.talelin.latticy.laver.model.BannerDO;

import java.util.List;

public interface TestService {

    public List<BannerDO> getBanners();

    public Long insertBanner();

}
