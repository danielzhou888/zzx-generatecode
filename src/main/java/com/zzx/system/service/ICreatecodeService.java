package com.zzx.system.service;

import com.baomidou.mybatisplus.service.IService;
import com.zzx.entity.Articlelabel;
import com.zzx.system.base.PageData;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hhzh
 * @since 2018-01-23
 */
public interface ICreatecodeService extends IService<Articlelabel> {

    void createcode(PageData pds) throws Exception;

    List<PageData> createPageDataList(String tables);
}
