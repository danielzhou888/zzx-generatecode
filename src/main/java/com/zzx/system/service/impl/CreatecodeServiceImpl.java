package com.zzx.system.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zzx.dao.ArticlelabelMapper;
import com.zzx.entity.Articlelabel;
import com.zzx.system.base.PageData;
import com.zzx.system.service.ICreatecodeService;
import com.zzx.system.util.DatabaseUtil;
import com.zzx.util.Freemarker;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hhzh
 * @since 2018-01-23
 */
@Service
public class CreatecodeServiceImpl extends ServiceImpl<ArticlelabelMapper, Articlelabel> implements ICreatecodeService {

    @Override
    public void createcode(PageData pd) throws Exception {
		/* ============================================================================================= */
        String faobject = pd.getString("faobject");  				//主表名				========参数0-1 主附结构用
        String FHTYPE = "0";  					//模块类型			========参数0-2 类型，单表、树形结构、主表明细表
//        String FHTYPE = pd.getString("FHTYPE");  					//模块类型			========参数0-2 类型，单表、树形结构、主表明细表
        String TITLE = pd.getString("TITLE");  						//说明				========参数0
        String packageName = pd.getString("packageName");  			//包名				========参数1
        String objectName = pd.getString("objectName");	   			//类名				========参数2
        String tabletop = pd.getString("tabletop");	   				//表前缀				========参数3
        tabletop = null == tabletop?"":tabletop.toLowerCase();		//表前缀转大写
//        List<String[]> fieldList = new ArrayList<String[]>();   	//属性集合			========参数4

        List<String[]> fieldList = DatabaseUtil.getFieldList(pd);

        Map<String,Object> root = new HashMap<String,Object>();		//创建数据模型
        root.put("fieldList", fieldList);
        root.put("faobject", faobject.toUpperCase());				//主附结构用，主表名
        root.put("TITLE", TITLE);									//说明
        root.put("packageName", packageName);						//包名
        root.put("objectName", objectName);							//类名
        root.put("objectNameLower", objectName.toLowerCase());		//类名(全小写)
        root.put("objectNameUpper", objectName.toUpperCase());		//类名(全大写)
        root.put("tabletop", tabletop);								//表前缀
        root.put("nowDate", new Date());							//当前日期

//        DelAllFile.delFolder(PathUtil.getClasspath()+"admin/ftl"); //生成代码前,先清空之前生成的代码
		/* ============================================================================================= */
        String filePath = "code/";						//存放路径
        String ftlPath = "createcode";								//ftl路径
        if("tree".equals(FHTYPE)){
            ftlPath = "createTreeCode";
			/*生成实体类*/
            Freemarker.printFile("entityTemplate.ftl", root, "entity/"+packageName+"/"+objectName+".java", filePath, ftlPath);
			/*生成jsp_tree页面*/
            Freemarker.printFile("jsp_tree_Template.ftl", root, "jsp/"+packageName+"/"+objectName.toLowerCase()+"/"+objectName.toLowerCase()+"_tree.jsp", filePath, ftlPath);
        }else if("fathertable".equals(FHTYPE)){
            ftlPath = "createFaCode";	//主表
        }else if("sontable".equals(FHTYPE)){
            ftlPath = "createSoCode";	//明细表
        }
		/*生成controller*/
        Freemarker.printFile("controllerTemplate.ftl", root, "controller/"+packageName+"/"+objectName+"Controller.java", filePath, ftlPath);
//		Freemarker.printFile("controllerTemplate.ftl", root, "controller/"+packageName+"/"+objectName.toLowerCase()+"/"+objectName+"Controller.java", filePath, ftlPath);
		/*生成serviceImpl*/
        Freemarker.printFile("serviceimplTemplate.ftl", root, "service/impl/"+objectName+"ServiceImpl.java", filePath, ftlPath);
//		Freemarker.printFile("serviceTemplate.ftl", root, "service/"+packageName+"/"+objectName.toLowerCase()+"/impl/"+objectName+"Service.java", filePath, ftlPath);
		/*生成service*/
        Freemarker.printFile("serviceTemplate.ftl", root, "service/I"+objectName+"Service.java", filePath, ftlPath);
//		Freemarker.printFile("serviceTemplate.ftl", root, "service/"+packageName+"/"+objectName.toLowerCase()+"/I"+objectName+"Service.java", filePath, ftlPath);
		/*生成mapper dao*/
        Freemarker.printFile("mapperDaoTemplate.ftl", root, "dao/"+objectName+"Mapper.java", filePath, ftlPath);
		/*生成mybatis xml*/
        Freemarker.printFile("mapperMysqlTemplate.ftl", root, "mybatis_mysql/"+objectName+"Mapper.xml", filePath, ftlPath);
//        Freemarker.printFile("mapperOracleTemplate.ftl", root, "mybatis_oracle/"+objectName+"Mapper.xml", filePath, ftlPath);
//        Freemarker.printFile("mapperSqlserverTemplate.ftl", root, "mybatis_sqlserver/"+objectName+"Mapper.xml", filePath, ftlPath);
		/*生成SQL脚本*/
        Freemarker.printFile("mysql_SQL_Template.ftl", root, "mysql数据库脚本/"+tabletop+objectName.toUpperCase()+".sql", filePath, ftlPath);
//        Freemarker.printFile("oracle_SQL_Template.ftl", root, "oracle数据库脚本/"+tabletop+objectName.toUpperCase()+".sql", filePath, ftlPath);
//        Freemarker.printFile("sqlserver_SQL_Template.ftl", root, "sqlserver数据库脚本/"+tabletop+objectName.toUpperCase()+".sql", filePath, ftlPath);
		/*生成Entity*/
        Freemarker.printFile("EntityTemplate.ftl", root, "entity/"+objectName+".java", filePath, ftlPath);
		/*生成jsp页面*/
//		Freemarker.printFile("jsp_list_Template.ftl", root, "jsp/"+packageName+"/"+objectName.toLowerCase()+"/"+objectName.toLowerCase()+"_list.jsp", filePath, ftlPath);
//		Freemarker.printFile("jsp_edit_Template.ftl", root, "jsp/"+packageName+"/"+objectName.toLowerCase()+"/"+objectName.toLowerCase()+"_edit.jsp", filePath, ftlPath);
		/*生成说明文档*/
        Freemarker.printFile("generatecode_github_readme.ftl", root, "代码生成工具使用说明.doc", filePath, ftlPath);
        /*接口文档*/
        Freemarker.printFile("interfacedocument.ftl", root, objectName+"接口文档.txt", filePath, ftlPath);
        //this.print("oracle_SQL_Template.ftl", root);  控制台打印
    }

    @Override
    public List<PageData> createPageDataList(String tables) {
        List<PageData> pageDataList = new ArrayList<>();
        List<String> tableNames = DatabaseUtil.getTableNamesBySelf(tables.split(","));
        for(String tablename:tableNames){
            String tablenamelower = DatabaseUtil.convertTablenameLower(tablename);
            String tablenameUpper = DatabaseUtil.convertTablenameUpper(tablename);
            PageData pd = new PageData();
            pd.put("faobject",tablename);             //主表名				========参数0-1 主附结构用
            pd.put("FHTYPE","1");                     //模块类型			========参数0-2 类型，单表、树形结构、主表明细表
            pd.put("TITLE",tablenamelower);           //说明				========参数0
            pd.put("packageName",tablenamelower);     //包名				========参数1
            pd.put("objectName",tablenameUpper);      //类名				========参数2
            pd.put("tabletop","sc_");                 //表前缀				========参数3
            pageDataList.add(pd);
        }
        return pageDataList;
    }
}
