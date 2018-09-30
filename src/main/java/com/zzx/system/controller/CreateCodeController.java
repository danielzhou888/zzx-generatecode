package com.zzx.system.controller;

import com.zzx.common.ServiceResponse;
import com.zzx.common.YamlConfigUtils;
import com.zzx.enums.ResponseEnum;
import com.zzx.system.base.BaseController;
import com.zzx.system.base.PageData;
import com.zzx.system.service.ICreatecodeService;
import com.zzx.system.util.DatabaseUtil;
import com.zzx.util.DelAllFile;
import com.zzx.util.FileDownload;
import com.zzx.util.FileZip;
import com.zzx.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


/**
 * 类名称： 代码生成器
 * 创建人：zhouzhixiang
 * 修改时间：2018年8月17日
 * @version
 */
@RestController
@RequestMapping(value="/createCode")
public class CreateCodeController extends BaseController{

	String menuUrl = "createcode/list.do"; //菜单地址(权限用)
	@Autowired
	private ICreatecodeService createcodeService;

	/**生成代码
	 * @param response
	 * @throws Exception
	 */
	@GetMapping(value="/proCode")
	public void proCode(HttpServletResponse response,@RequestParam("tables") String tables, @RequestParam("database") String database) throws Exception{
		DatabaseUtil dbu = new DatabaseUtil((String) YamlConfigUtils.getYamlConfig("cas.yaml").get("database.ip"),database);
		logBefore(logger, "执行代码生成器");
//		DelAllFile.delFolder(PathUtil.getClasspath()+"admin/ftl"); //生成代码前,先清空之前生成的代码
		DelAllFile.delFolder(PathUtil.getCodeLocation()); //生成代码前,先清空之前生成的代码
		// 连接数据库并处理Map
		List<PageData> pdlist = createcodeService.createPageDataList(tables);

		for(PageData pds: pdlist){
			createcodeService.createcode(pds);
		}

		/*生成的全部代码压缩成zip文件*/
		/*if(FileZip.zip(PathUtil.getClasspath()+"admin/ftl/code", PathUtil.getClasspath()+"admin/ftl/code.zip")){
			*//*下载代码*//*
			FileDownload.fileDownload(response, PathUtil.getClasspath()+"admin/ftl/code.zip", "code.zip");
		}*/
		if(FileZip.zip(PathUtil.getCodeLocation()+"code", PathUtil.getCodeLocation()+"code.zip")){
			/*下载代码*/
			FileDownload.fileDownload(response, PathUtil.getCodeLocation()+"code.zip", "code.zip");
		}
	}

	/**保存到数据库
	 * @throws Exception
	 *//*
	public void save(PageData pd) throws Exception{
		pd.put("PACKAGENAME", pd.getString("packageName"));	//包名
		pd.put("OBJECTNAME", pd.getString("objectName"));	//类名
		pd.put("TABLENAME", pd.getString("tabletop")+",fh,"+pd.getString("objectName").toUpperCase());	//表名
		pd.put("FIELDLIST", pd.getString("FIELDLIST"));		//属性集合
		pd.put("CREATETIME", DateUtil.getTime());			//创建时间
		pd.put("TITLE", pd.getString("TITLE"));				//说明
		pd.put("CREATECODE_ID", this.get32UUID());			//主键
		createcodeService.save(pd);
	}*/

	/**获取数据库列表
	 * @return
	 * @throws Exception
     */
	@GetMapping(value="/databaselist")
	public ServiceResponse databaselist() throws Exception{
		logBefore(logger, "数据库列表");
		ServiceResponse res = new ServiceResponse();
		ObjectResult<List<String>> result = new ObjectResult();
		List<String> list = new ArrayList<>();
		list.add("zzx");
		list.add("yunnan");
		list.add("knbbusiness");
		result.setObject(list);
		res.setData(result);
		res.setCode(ResponseEnum.SUCCESS.getCode());
		res.setMsg(ResponseEnum.SUCCESS.getMsg());
		return res;
	}


}
