package io.github.talelin.latticy.service;

import io.github.talelin.latticy.model.BannerDO;

import java.util.List;

public interface TestService {

    public List<BannerDO> getBanners();

    public Long insertBanner();

}
