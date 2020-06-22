package io.github.talelin.latticy.laver.controller.cms;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.github.talelin.latticy.common.mybatis.Page;
import io.github.talelin.latticy.laver.dto.BannerDTO;
import io.github.talelin.latticy.laver.model.BannerDO;
import io.github.talelin.latticy.laver.service.BannerService;
import io.github.talelin.latticy.vo.DeletedVO;
import io.github.talelin.latticy.vo.PageResponseVO;
import io.github.talelin.latticy.vo.UpdatedVO;
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
    private BannerService bannerService;

    //    Query
    @GetMapping("/page")
//    参见数据接收
//    参见数据校验
//    参见查询分页数据
    public PageResponseVO<BannerDO> getBanners(@RequestParam(required = false, defaultValue = "0")
                                               @Min(value = 0, message = "{page.number.min}") Integer page,
                                               @RequestParam(required = false, defaultValue = "10")
                                               @Min(value = 1, message = "{page.count.min}")
                                               @Max(value = 30, message = "{page.count.max}") Integer count) {
        Page<BannerDO> pager = new Page<>(page, count);
        IPage<BannerDO> paging = bannerService.getBaseMapper().selectPage(pager, null);
        return new PageResponseVO<>(paging.getTotal(), paging.getRecords(), paging.getCurrent(), paging.getSize());
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
