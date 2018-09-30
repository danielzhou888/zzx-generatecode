package com.zzx.service.${packageName}.${objectNameLower};

import java.util.List;
import com.zzx.system.base.PageData;
import com.zzx.common.PageResponse;
import com.zzx.common.ServiceResponse;
import com.zzx.entity.${objectName};
import javax.servlet.http.HttpServletRequest;

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
public interface I${objectName}Service{

	/**新增
	 * @param request
	 */
	ServiceResponse insert(PageData request);

	/**修改
     * @param request
     */
    ServiceResponse update(PageData request);

    /**删除
     * @param request
     */
    ServiceResponse delete(PageData request);

    /**列表
     * @param request
     */
    PageResponse list(PageData request);

	/**列表(全部)
     * @param request
	 */
	List<${objectName}> listAll(PageData request);
	
	/**通过主键id获取数据
	 * @param request
	 */
	ServiceResponse findById(PageData request);

	/**通过主键id获取实体类数据
     * @param id
     */
    ${objectName} findByIdEntity(Integer id);
	
	/**批量删除
	 * @param request
	 */
	ServiceResponse deleteAll(PageData request);
	
}

