package com.zzx.service.impl;

import com.zzx.system.base.PageData;
import com.zzx.common.PageResponse;
import com.zzx.common.ServiceResponse;
import com.zzx.enums.ResponseEnum;
import com.zzx.service.I${objectName}Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zzx.entity.${objectName};
import com.zzx.dao.${objectName}Mapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.Arrays;
import java.util.List;

/**
 * 说明： ${TITLE}接口
 * 创建人：scmd
 * 创建时间：${nowDate?string("yyyy-MM-dd")}
 * github：https://github.com/danielzhou888
 * csdn：https://blog.csdn.net/danielzhou888
 * 简书：https://www.jianshu.com/u/ce0d55ec26f7
 * email：1579655633@qq.com
 * wechat：a1579655633
 * @version
 */
@Service
public class ${objectName}ServiceImpl extends ServiceImpl<${objectName}Mapper, ${objectName}> implements I${objectName}Service {

	@Autowired
	private ${objectName}Mapper ${objectNameLower}Mapper;

	/**新增
	 * @param request
	 */
	public ServiceResponse insert(PageData request){
	    ServiceResponse response = new ServiceResponse();
        try{
            ${objectName} ${objectNameLower} = (${objectName}) PageData.convertEntity(request, ${objectName}.class);
            ${objectNameLower}Mapper.add(request);
            response.setCode(ResponseEnum.SUCCESS.getCode());
            response.setData(${objectNameLower});
            response.setMsg(ResponseEnum.SUCCESS.getMsg());
            response.setVersion((String)request.get("version"));
        }catch (Exception e){
            e.printStackTrace();
            response.setCode(ResponseEnum.VISIT_ERROR.getCode());
            response.setMsg(ResponseEnum.VISIT_ERROR.getMsg());
            response.setVersion((String)request.get("version"));
        }
        return response;
	}

	/**删除
	 * @param request
	 */
	public ServiceResponse delete(PageData request) {
		ServiceResponse response = new ServiceResponse();
        try{
            ${objectName} ${objectNameLower} = (${objectName}) PageData.convertEntity(request, ${objectName}.class);
            ${objectNameLower}Mapper.deleteById(${objectNameLower}.pkVal());
            response.setCode(ResponseEnum.SUCCESS.getCode());
            response.setMsg(ResponseEnum.SUCCESS.getMsg());
            response.setVersion((String)request.get("version"));
        }catch (Exception e){
            e.printStackTrace();
            response.setCode(ResponseEnum.VISIT_ERROR.getCode());
            response.setMsg(ResponseEnum.VISIT_ERROR.getMsg());
            response.setVersion((String)request.get("version"));
        }
        return response;
	}

	/**修改
	 * @param request
	 */
	public ServiceResponse update(PageData request) {
		ServiceResponse response = new ServiceResponse();
        try{
            ${objectName} ${objectNameLower} = (${objectName}) PageData.convertEntity(request, ${objectName}.class);
            ${objectNameLower}Mapper.updateById(${objectNameLower});
            response.setCode(ResponseEnum.SUCCESS.getCode());
            response.setData(${objectNameLower});
            response.setMsg(ResponseEnum.SUCCESS.getMsg());
            response.setVersion((String)request.get("version"));
        }catch (Exception e){
            e.printStackTrace();
            response.setCode(ResponseEnum.VISIT_ERROR.getCode());
            response.setMsg(ResponseEnum.VISIT_ERROR.getMsg());
            response.setVersion((String)request.get("version"));
        }
        return response;
	}

	/**列表
	 * @param request
	 */
	public PageResponse list(PageData request) {
		PageResponse response = new PageResponse();
        try{
            List<${objectName}> ${objectNameLower}List = ${objectNameLower}Mapper.list(request);
            Integer count = ${objectNameLower}Mapper.listcount(request);
            response.setTotal(count);
            response.setCurrent((Integer)request.get("current"));
            if (request.get("size") != null) {
                response.setSize((Integer)request.get("size"));
                response.setPages(count % (Integer)request.get("size") == 0 ? count / (Integer)request.get("size") : count / (Integer)request.get("size") + 1);
                if (response.getPages() == 0) {
                    response.setPages(1);
                }
            }
            response.setData(${objectNameLower}List);
            response.setCode(ResponseEnum.SUCCESS.getCode());
            response.setMsg(ResponseEnum.SUCCESS.getMsg());
            response.setVersion((String)request.get("version"));
        }catch (Exception e){
            e.printStackTrace();
            response.setCode(ResponseEnum.VISIT_ERROR.getCode());
            response.setMsg(ResponseEnum.VISIT_ERROR.getMsg());
            response.setVersion((String)request.get("version"));
        }
        return response;
	}

	/**列表(全部)
	 * @param request
	 * @throws Exception
	 */
	public List<${objectName}> listAll(PageData request) {
		return (List<${objectName}>)${objectNameLower}Mapper.list(request);
	}

	/**通过id获取数据
	 * @param request
	 * @throws Exception
	 */
	public ServiceResponse findById(PageData request) {
	    ServiceResponse response = new ServiceResponse();
        try{
            ${objectName} ${objectNameLower} = (${objectName}) PageData.convertEntity(request, ${objectName}.class);
            ${objectNameLower} = (${objectName})${objectNameLower}Mapper.findById((Integer) ${objectNameLower}.pkVal());
            response.setCode(ResponseEnum.SUCCESS.getCode());
            response.setMsg(ResponseEnum.SUCCESS.getMsg());
            response.setVersion((String)request.get("version"));
            response.setData(${objectNameLower});
        }catch (Exception e){
            e.printStackTrace();
            response.setCode(ResponseEnum.VISIT_ERROR.getCode());
            response.setMsg(ResponseEnum.VISIT_ERROR.getMsg());
            response.setVersion((String)request.get("version"));
        }
        return response;
	}

	/**批量删除
	 * @param request
	 * @throws Exception
	 */
	public ServiceResponse deleteAll(PageData request) {
        ServiceResponse response = new ServiceResponse();
        try{
            List<Integer> idlist = (List<Integer>) request.get("ids");
            ${objectNameLower}Mapper.deleteBatchIds(idlist);
            response.setCode(ResponseEnum.SUCCESS.getCode());
            response.setMsg(ResponseEnum.SUCCESS.getMsg());
            response.setVersion((String)request.get("version"));
        }catch (Exception e){
            e.printStackTrace();
            response.setCode(ResponseEnum.VISIT_ERROR.getCode());
            response.setMsg(ResponseEnum.VISIT_ERROR.getMsg());
            response.setVersion((String)request.get("version"));
        }
        return response;
	}

    /**通过id获取数据
     * @param id
     * @throws Exception
     */
    public ${objectName} findByIdEntity(Integer id) {
        return (${objectName})${objectNameLower}Mapper.findById(id);
    }
	
}

