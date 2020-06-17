package io.github.talelin.latticy.controller.v1;

import io.github.talelin.latticy.laver.model.BannerBO;
import io.github.talelin.latticy.laver.service.WWTestSleeveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/test")
public class TestSleeveController {

    @Autowired
    WWTestSleeveService testSleeveService;

    @GetMapping("/test1")
    public List<BannerBO> test1(){
        return testSleeveService.getBanners();
    }

}
