package com.zzx.service.${packageName}.${objectNameLower};

import java.util.List;
import com.zzx.system.base.PageData;
import com.zzx.common.PageResponse;
import com.zzx.common.ServiceResponse;
import com.zzx.entity.${objectName};
import javax.servlet.http.HttpServletRequest;
import org.apache.ibatis.annotations.Param;

/** 
 * 说明： Mapper 接口
 * 创建人：scmd
 * 创建时间：${nowDate?string("yyyy-MM-dd")}
 * github：https://github.com/danielzhou888
 * csdn：https://blog.csdn.net/danielzhou888
 * 简书：https://www.jianshu.com/u/ce0d55ec26f7
 * email：1579655633@qq.com
 * wechat：a1579655633
 * @version
 */
public interface ${objectName}Mapper extends BaseMapper<${objectName}> {

	/**新增
	 * @param request
	 */
	public ${objectName} add(@Param("request") PageData request);

	/**修改
     * @param request
     */
    public ${objectName} update(@Param("request") PageData request);

    /**删除
     * @param request
     */
    public void delete(@Param("request") PageData request);

    /**列表
     * @param request
     */
    public List<${objectName}> list(@Param("request") PageData request);

	/**列表(全部)
     * @param request
	 */
	public List<${objectName}> listAll(@Param("request") PageData request);
	
	/**通过主键id获取数据
	 * @param ${objectNameLower}id
	 */
	public ${objectName} findById(@Param("${objectNameLower}id") Integer ${objectNameLower}id);
	
	/**批量删除
	 * @param ids
	 */
	public void deleteAll(@Param("ids") Integer[] ids);

    /**列表总数
     * @param request
     */
	public Integer listcount(@Param("request") PageData request);
}

