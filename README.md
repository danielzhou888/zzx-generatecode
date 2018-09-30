代码生成工具使用说明
====

@(zzx)[代码生成工具]


[TOC]

**欢迎关注:**

* github：https://github.com/danielzhou888
* csdn：https://blog.csdn.net/danielzhou888
* 简书：https://www.jianshu.com/u/ce0d55ec26f7
* email：1579655633@qq.com 
* wechat：a1579655633 
----

### 前言
&emsp;&emsp;在公司开发一段时间发现公司很多业务代码都是可以通过工具直接生成的，故此决定使用FreeMarker定制模板生成单表curl代码，减少开发工作量。  
&emsp;&emsp;欢迎大家批评指教。

### 1．	curl代码生成
**访问:**  
&emsp;&emsp;测试环境：http://10.100.1.145:8088/scmd-generatetools/  
&emsp;&emsp;线上环境：https://www.carecnn.com/scmd-generatetools/（暂不公开）  
![Alt text](https://github.com/danielzhou888/zzx-generatecode/blob/master/src/test/java/com/img/_[{[6ZW{609NMXRSTGD74@V.png)
<img src="https://github.com/danielzhou888/zzx-generatecode/blob/master/src/test/java/com/img/_[{[6ZW{609NMXRSTGD74@V.png" style="width:400px;height:200px;"/>

<img src="https://github.com/danielzhou888/zzx-generatecode/blob/master/src/test/java/com/img/_[{[6ZW{609NMXRSTGD74@V.png" width="150" height="150" alt="图片"/>

<div align=center><img style="max-width:80%;" src="https://github.com/danielzhou888/zzx-generatecode/blob/master/src/test/java/com/img/_[{[6ZW{609NMXRSTGD74@V.png"/></div>

 **输入表名**（支持多表，表之间使用英文逗号进行隔开）  
 &emsp;&emsp;如：sc_user,sc_customer,sc_appointment  
**点击下载：**    生成code.zip  
![Alt text](https://github.com/danielzhou888/zzx-generatecode/blob/master/src/test/java/com/img/9YVJ$ROQ9K2G}V8Y`_NHV.png)


**目录结构：**   
![image](https://github.com/danielzhou888/zzx-generatecode/blob/master/src/test/java/com/img/@SSHSAD$$VOKCAK9{}7LJA.png)



### 2．	代码部署
**1.	复制controller 里面的目录到项目的**  
![Alt text](https://github.com/danielzhou888/zzx-generatecode/blob/master/src/test/java/com/img/_0RC7Q36D8O@A9HCM@N9V1.png)
 
**2.	复制service 里面的目录到项目的**  
![Alt text](https://github.com/danielzhou888/zzx-generatecode/blob/master/src/test/java/com/img/HI_W7E4WW6[Y9KK2CB5.png)
 
**3.	复制mybatis_mysql 里面的目录到项目的**  
![Alt text](https://github.com/danielzhou888/zzx-generatecode/blob/master/src/test/java/com/img/VRYGURWPV`HY__FYXTW70.png)

 
### 3．	代码说明  
&emsp;&emsp;整体思想：接口整体采用post请求，json作为请求参数；所有Controller继承基类并使用JSONObject对象接收请求json，经过PageData构造将JSONObject转成map，方便于xml文件进行数据获取；然后使用PageData对象的静态方法convertEntity(PageData request,Class<T> T)将PageData对象转成对应的实体类，再对实体类进行curl操作；  
 ![Alt text](https://github.com/danielzhou888/zzx-generatecode/blob/master/src/test/java/com/img/4H~BR6C7BCJUUWUCANDZ4`Y.png)


#### 3.1.	Controller：
**新增：**  
 ![Alt text](https://github.com/danielzhou888/zzx-generatecode/blob/master/src/test/java/com/img/GX6L7XM{WTL~XM4_$$}MFTB.png)

**修改：**  
 
![Alt text](https://github.com/danielzhou888/zzx-generatecode/blob/master/src/test/java/com/img/5WAJSIKN37N3K{EKHIOD0.png)


**详情：**  
![Alt text](https://github.com/danielzhou888/zzx-generatecode/blob/master/src/test/java/com/img/TBSU[V`$5X]7OOOWR3B4]UV.png)

 
**删除：**  
![Alt text](https://github.com/danielzhou888/zzx-generatecode/blob/master/src/test/java/com/img/CI`}[RI1BGG22~QJOB5SL94.png)


 
**列表：**  
![Alt text](https://github.com/danielzhou888/zzx-generatecode/blob/master/src/test/java/com/img/JPC`7Z[@_PCX5}MI}@WB3A.png)

 
**批量删除：**  
![Alt text](https://github.com/danielzhou888/zzx-generatecode/blob/master/src/test/java/com/img/~HQ188V8O`NK6F$MN}6T.png)

 
#### 3.2.	ServiceImpl：  
**列表：**  
![Alt text](https://github.com/danielzhou888/zzx-generatecode/blob/master/src/test/java/com/img/JZY69_H[~RYOYVM]Q6KRB.png)

#### 3.3.	Mapper.xml：  
 
 ![Alt text](https://github.com/danielzhou888/zzx-generatecode/blob/master/src/test/java/com/img/`K[Y{@AUA5W@GDS2{`54Y.png)  
 ![Alt text](https://github.com/danielzhou888/zzx-generatecode/blob/master/src/test/java/com/img/5NAGGQ`30P30_U1VX2FO}E1.png)  


 &emsp;&emsp;列表查询条件，所有字符串都转成模糊查询，根据不同业务需求，程序员需要对其进行更改。  
![Alt text](https://github.com/danielzhou888/zzx-generatecode/blob/master/src/test/java/com/img/KFQ]8HSGYI6W1ET]MIK34.png)

 
**插入insert模板：**  
 ![Alt text](https://github.com/danielzhou888/zzx-generatecode/blob/master/src/test/java/com/img/G_]$05XIP{}A8NPYMT_49WT.png)



**删除delete模板：**  
![Alt text](https://github.com/danielzhou888/zzx-generatecode/blob/master/src/test/java/com/img/SY4]K31783L_`ISD6@42BS.png)  

 
**修改update模板：**根据需要加入useGeneratedKeys=true  keyProperty=”id” 用来返回主键id值。  
![Alt text](https://github.com/danielzhou888/zzx-generatecode/blob/master/src/test/java/com/img/QDQMHXE7KNKXAYTGM5RRYN.png)

 
**列表查询分页，排序：**  
![Alt text](https://github.com/danielzhou888/zzx-generatecode/blob/master/src/test/java/com/img/@ZNQK}5ROSC_$~2I[F.png)
### 4．	前端接口文档  

&emsp;&emsp;见同级目录接口文档。

