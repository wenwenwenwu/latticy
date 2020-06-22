package io.github.talelin.latticy.laver.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.talelin.autoconfigure.exception.*;
import io.github.talelin.latticy.laver.dto.BannerDTO;
import io.github.talelin.latticy.laver.mapper.BannerMapper;
import io.github.talelin.latticy.laver.model.BannerDO;
import io.github.talelin.latticy.vo.DeletedVO;
import io.github.talelin.latticy.vo.UpdatedVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
//ServiceImp是Mybatis plus提供的泛型基类，提供了ServiceImpl常用的方法
//需要提供BannerService操作的BannerMapper接口,以及BannerMapper要操作的BannerDO类
public class BannerService extends ServiceImpl<BannerMapper, BannerDO> {

    public void update(BannerDTO bannerDTO, Long id){
        BannerDO bannerDO = this.getById(id);
        if (bannerDO==null){
            throw new NotFoundException();

        }
        BeanUtils.copyProperties(bannerDTO,bannerDO);
        this.updateById(bannerDO);
    }

    public void delete(Long id){
        BannerDO bannerDO = this.getById(id);
        if (bannerDO==null){
            throw new NotFoundException(20000);
        }
        this.getBaseMapper().deleteById(id);
    }
}
