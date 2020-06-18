package io.github.talelin.latticy.laver.controller.v1;

import io.github.talelin.latticy.laver.mapper.TestMapper;
import io.github.talelin.latticy.laver.model.BannerDO;
import io.github.talelin.latticy.laver.service.TestSleeveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/test")
public class TestSleeveController {

    @Autowired
    TestSleeveService testSleeveService;

    @Autowired
    TestMapper bannerMapper;

    @GetMapping("/test1")
    public List<BannerDO> test1(){
        return testSleeveService.getBanners();
    }

    @GetMapping("/test2")
    public Long test2(){
        return testSleeveService.insertBanner();
    }

    @GetMapping("/test3")
    public List<BannerDO> test3(){
        return testSleeveService.getBanners1();
    }

    @GetMapping("/test4")
    public List<BannerDO> test4(){
        bannerMapper.selectList(null);
        return testSleeveService.getBanners1();
    }

}
