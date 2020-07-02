package io.github.talelin.latticy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.talelin.autoconfigure.exception.*;
import io.github.talelin.latticy.bo.BannerWithItemsBO;
import io.github.talelin.latticy.dto.BannerDTO;
import io.github.talelin.latticy.mapper.BannerItemMapper;
import io.github.talelin.latticy.mapper.BannerMapper;
import io.github.talelin.latticy.model.BannerDO;
import io.github.talelin.latticy.model.BannerItemDO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
//ServiceImp是Mybatis plus提供的泛型基类，提供了ServiceImpl常用的方法
//需要提供BannerService操作的BannerMapper接口,以及BannerMapper要操作的BannerDO类
public class BannerServiceImpl extends ServiceImpl<BannerMapper, BannerDO> {

    @Autowired
    BannerItemMapper bannerItemMapper;

    public void update(BannerDTO bannerDTO, Long id) {
        BannerDO bannerDO = this.getById(id);
        if (bannerDO == null) {
            throw new NotFoundException();

        }
        BeanUtils.copyProperties(bannerDTO, bannerDO);
        this.updateById(bannerDO);
    }

    @Transactional
    public void delete(Long id) {
        //bannerDO
        BannerDO bannerDO = this.getById(id);
        if (bannerDO == null) {
            throw new NotFoundException();
        }
        this.removeById(id);
        //bannerItemIds
        QueryWrapper<BannerItemDO> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(BannerItemDO::getBannerId, id);
        this.bannerItemMapper.delete(wrapper);
    }

    public BannerWithItemsBO getWithItems(Long id) {
        //banner
        BannerDO bannerDO = this.getById(id);
        if (bannerDO == null) {
            throw new NotFoundException();
        }
        //bannerItems
        QueryWrapper<BannerItemDO> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(BannerItemDO::getBannerId, id); //lambda表达式，直接操作模型
        //查询
        List<BannerItemDO> bannerItemDOS = bannerItemMapper.selectList(wrapper);
        return new BannerWithItemsBO(bannerDO, bannerItemDOS);
    }
}
