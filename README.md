代码生成工具使用说明

zzx 代码生成工具


代码生成工具使用说明
前言
1． curl代码生成
2． 代码部署
3． 代码说明
3.1. Controller：
3.2. ServiceImpl：
3.3. Mapper.xml：
4． 前端接口文档
欢迎关注:

github：https://github.com/danielzhou888
csdn：https://blog.csdn.net/danielzhou888
简书：https://www.jianshu.com/u/ce0d55ec26f7
email：1579655633@qq.com
wechat：a1579655633
前言

  在公司开发一段时间发现公司很多业务代码都是可以通过工具直接生成的，故此决定使用FreeMarker定制模板生成单表curl代码，减少开发工作量。 
  欢迎大家批评指教。

1． curl代码生成

访问: 
  测试环境：http://10.100.1.145:8088/scmd-generatetools/ 
  线上环境：https://www.carecnn.com/scmd-generatetools/（暂不公开）

Alt text

输入表名（支持多表，表之间使用英文逗号进行隔开） 
  如：sc_user,sc_customer,sc_appointment 
点击下载： 生成code.zip

Alt text

目录结构：

Alt text

2． 代码部署

1. 复制controller 里面的目录到项目的

Alt text

2. 复制service 里面的目录到项目的

Alt text

3. 复制mybatis_mysql 里面的目录到项目的

Alt text

3． 代码说明

  整体思想：接口整体采用post请求，json作为请求参数；所有Controller继承基类并使用JSONObject对象接收请求json，经过PageData构造将JSONObject转成map，方便于xml文件进行数据获取；然后使用PageData对象的静态方法convertEntity(PageData request,Class T)将PageData对象转成对应的实体类，再对实体类进行curl操作；

Alt text

3.1. Controller：

新增：

Alt text

修改：

Alt text

详情：

Alt text

删除：

Alt text

列表：

Alt text

批量删除：

Alt text

3.2. ServiceImpl：

列表：

Alt text

3.3. Mapper.xml：

Alt text

Alt text

  列表查询条件，所有字符串都转成模糊查询，根据不同业务需求，程序员需要对其进行更改。

Alt text

插入insert模板：

Alt text

删除delete模板：

Alt text

修改update模板：根据需要加入useGeneratedKeys=true keyProperty=”id” 用来返回主键id值。

Alt text

列表查询分页，排序：

Alt text

4． 前端接口文档

  见同级目录接口文档。
