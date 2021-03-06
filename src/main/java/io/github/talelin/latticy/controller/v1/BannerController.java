package io.github.talelin.latticy.controller.v1;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.github.talelin.latticy.common.mybatis.Page;
import io.github.talelin.latticy.bo.BannerWithItemsBO;
import io.github.talelin.latticy.common.util.PageUtil;
import io.github.talelin.latticy.dto.BannerDTO;
import io.github.talelin.latticy.model.BannerDO;
import io.github.talelin.latticy.service.impl.BannerServiceImpl;
import io.github.talelin.latticy.vo.CreatedVO;
import io.github.talelin.latticy.vo.DeletedVO;
import io.github.talelin.latticy.vo.PageResponseVO;
import io.github.talelin.latticy.vo.UpdatedVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

@Validated
@RestController
@RequestMapping("v1/banner")
public class BannerController {

    @Autowired
    private BannerServiceImpl bannerService;

    @PostMapping
    public CreatedVO creat(@RequestBody @Validated BannerDTO bannerDTO){
        BannerDO bannerDO = new BannerDO();
        BeanUtils.copyProperties(bannerDTO,bannerDO);
        this.bannerService.save(bannerDO);
        return new CreatedVO();
    }

    //    Query
    @GetMapping("/page")
    public PageResponseVO<BannerDO> getBanners(@RequestParam(required = false, defaultValue = "0")
                                               @Min(value = 0, message = "{page.number.min}") Integer page,
                                               @RequestParam(required = false, defaultValue = "10")
                                               @Min(value = 1, message = "{page.count.min}")
                                               @Max(value = 30, message = "{page.count.max}") Integer count) {
        Page<BannerDO> pager = new Page<>(page, count); //

        IPage<BannerDO> paging = bannerService.page(pager);
        //简便方法
        return PageUtil.build(paging);
//        return new PageResponseVO<>(paging.getTotal(), paging.getRecords(), paging.getCurrent(), paging.getSize());
    }

    @GetMapping("/{id}")
    public BannerWithItemsBO getWithItems(@PathVariable @Positive Long id){
        return bannerService.getWithItems(id);
    }

    //    Update
    @PutMapping("/{id}")
    public UpdatedVO update(@RequestBody @Validated BannerDTO bannerDTO,
                            @PathVariable @Positive Long id) {
        BannerDTO dto = bannerDTO;
        bannerService.update(dto, id);
        return new UpdatedVO() ;
    }

    //    Delete
    @DeleteMapping("/{id}")
    public DeletedVO delete(@PathVariable @Positive Long id) {
        bannerService.delete(id);
        return new DeletedVO();
    }

}
