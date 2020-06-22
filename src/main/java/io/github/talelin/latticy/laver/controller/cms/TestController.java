package io.github.talelin.latticy.laver.controller.cms;

import io.github.talelin.latticy.laver.mapper.TestMapper;
import io.github.talelin.latticy.laver.model.BannerDO;
import io.github.talelin.latticy.laver.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/test")
public class TestController {

    @Autowired
    TestService testService;

    @GetMapping("/test1")
    public List<BannerDO> test1(){
        return testService.getBanners();
    }

    @GetMapping("/test2")
    public Long test2(){
        return testService.insertBanner();
    }

}
