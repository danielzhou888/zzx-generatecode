package com.zzx.controller.${packageName}.${objectNameLower};

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import com.alibaba.fastjson.JSONObject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.zzx.system.base.BaseController;
import com.zzx.util.AppUtil;
import com.zzx.util.ObjectExcelView;
import com.zzx.system.base.PageData;
//import com.zzx.service.${packageName}.${objectNameLower}.I${objectName}Service;
import com.zzx.service.I${objectName}Service;
/** 
 * 说明：${TITLE}
 * 创建人：zzx
 * 创建时间：${nowDate?string("yyyy-MM-dd")}
 * github：https://github.com/danielzhou888
 * csdn：https://blog.csdn.net/danielzhou888
 * 简书：https://www.jianshu.com/u/ce0d55ec26f7
 * email：1579655633@qq.com
 * wechat：a1579655633
 */
@RestController
@RequestMapping(value="/${objectNameLower}")
public class ${objectName}Controller extends BaseController {
	
	@Autowired
	private I${objectName}Service ${objectNameLower}Service;

    @ApiOperation(value = "${TITLE}-新增", notes = "${TITLE}-新增")
    @PostMapping("insert")
    public ServiceResponse insert(@RequestBody JSONObject jsonObject, HttpServletRequest req){
        ServiceResponse response = null;
        logBefore(logger, "新增${objectName}");
        PageData request = new PageData(jsonObject);
        if(((String)request.get("version")).equals(VersionNum.V1_0)){
            response = ${objectNameLower}Service.insert(request);
        }
        return response;
    }

    @ApiOperation(value = "${TITLE}-修改", notes = "${TITLE}-修改")
    @PostMapping("update")
    public ServiceResponse update(@RequestBody JSONObject jsonObject, HttpServletRequest req){
        ServiceResponse response = null;
        logBefore(logger, "修改${objectName}");
        PageData request = new PageData(jsonObject);
        if(((String)request.get("version")).equals(VersionNum.V1_0)){
            response = ${objectNameLower}Service.update(request);
        }
        return response;
    }

    @ApiOperation(value = "${TITLE}-详情", notes = "${TITLE}-详情")
    @PostMapping("detail")
    public ServiceResponse detail(@RequestBody JSONObject jsonObject, HttpServletRequest req){
        ServiceResponse response = null;
        logBefore(logger, "修改${objectName}");
        PageData request = new PageData(jsonObject);
        if(((String)request.get("version")).equals(VersionNum.V1_0)){
            response = ${objectNameLower}Service.findById(request);
        }
        return response;
    }

    @ApiOperation(value = "${TITLE}-删除", notes = "${TITLE}-删除")
    @PostMapping("delete")
    public ServiceResponse delete(@RequestBody JSONObject jsonObject, HttpServletRequest req){
        ServiceResponse response = null;
        logBefore(logger, "删除${objectName}");
        PageData request = new PageData(jsonObject);
        if(((String)request.get("version")).equals(VersionNum.V1_0)){
            response = ${objectNameLower}Service.delete(request);
        }
        return response;
    }

    @ApiOperation(value = "${TITLE}-列表", notes = "${TITLE}-列表")
    @PostMapping("list")
    public PageResponse list(@RequestBody JSONObject jsonObject, HttpServletRequest req){
        PageResponse response = null;
        logBefore(logger, "列表${objectName}");
        PageData request = new PageData(jsonObject);
        if(((String)request.get("version")).equals(VersionNum.V1_0)){
            response = ${objectNameLower}Service.list(request);
        }
        return response;
    }

    @ApiOperation(value = "${TITLE}-批量删除", notes = "${TITLE}-批量删除")
    @PostMapping("deleteAll")
    public ServiceResponse deleteAll(@RequestBody JSONObject jsonObject, HttpServletRequest req){
        ServiceResponse response = null;
        logBefore(logger, "列表${objectName}");
        PageData request = new PageData(jsonObject);
        if(((String)request.get("version")).equals(VersionNum.V1_0)){
            response = ${objectNameLower}Service.deleteAll(request);
        }
        return response;
    }
}

