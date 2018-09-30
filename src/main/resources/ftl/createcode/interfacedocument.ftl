通用-接口文档-JSON -${TITLE} :
/*
 * github：https://github.com/danielzhou888
 * csdn：https://blog.csdn.net/danielzhou888
 * 简书：https://www.jianshu.com/u/ce0d55ec26f7
 * email：1579655633@qq.com
 * wechat：a1579655633
 */
一、JSON
1.JSON:
    {
        "version":"v1.0",
        "code":0,
        "msg":"成功",
        "data":{
        <#list fieldList as var>
                <#if var_index == 0>
            "${objectNameLower}id":1,
                <#elseif var_has_next>
            "${var[0]}":null,
           <#else>
            "${var[0]}":null
           </#if>
        </#list>
        }
    }

2.字段对应注释：
    <#list fieldList as var>
                <#if var_index == 0>
    "${objectNameLower}id": "主键id",
                <#elseif var_has_next>
    "${var[0]}": "${var[2]}",
           <#else>
    "${var[0]}": "${var[2]}"
           </#if>
    </#list>

二、新增（insert）
    接口地址：/${objectNameLower}/insert
    传参json：
    {
        "version":"v1.0"
    }

    返回json：
    {
        "version":"v1.0",
        "code":0,
        "msg":"成功",
        "data":{
        <#list fieldList as var>
                <#if var_index == 0>
            "${objectNameLower}id":1,
                    <#elseif var_has_next>
            "${var[0]}":null,
               <#else>
            "${var[0]}":null
               </#if>
        </#list>
        }
    }

三、修改（update）
    接口地址：/${objectNameLower}/update
    传参json：
    {
        "version":"v1.0",
        "${objectNameLower}id":1
    }

    返回json：
    {
        "version":"v1.0",
        "code":0,
        "msg":"成功",
        "data":{
        <#list fieldList as var>
                <#if var_index == 0>
            "${objectNameLower}id":1,
                <#elseif var_has_next>
            "${var[0]}":null,
           <#else>
            "${var[0]}":null
           </#if>
        </#list>
        }
    }

四、删除（delete)
    接口地址：/${objectNameLower}/delete
    传参json：
    {
        "version":"v1.0",
        "${objectNameLower}id":1,
    }

    返回json：
    {
        "version":"v1.0",
        "code":0,
        "msg":"成功",
        "data":null
    }

五、批量删除（deleteAll)
    接口地址：/${objectNameLower}/deleteAll
    传参json：
    {
        "version":"v1.0",
        "ids":{1,2,3},
    }

    返回json：
    {
        "version":"v1.0",
        "code":0,
        "msg":"成功",
        "data":null
    }

六、列表（list)
    接口地址：/${objectNameLower}/list
    传参json：
    {
        "version":"v1.0",
        "size":20,
        "current":1,
        "orderBy":"updatetime",
        "ordering":"desc",
        "startNum":0,
    }

    返回json：
    {
    	"version": "v1.0",
    	"code": 0,
    	"msg": "成功",
    	"data": [{
    		"orderid": 1,
    		"orderno": null,
    		"traceno": null,
    		"userid": null,
    		"shopid": null,
    		"deliveryways": null,
    		"orderstatusno": null,
    		"qrcode": null,
    		"orderstatus": null,
    		"count": null,
    		"origintotalprice": null,
    		"discountprice": null,
    		"orderTotalPrice": null,
    		"logisticsFee": null,
    		"isUnpackingInspection": null,
    		"isCheck": null,
    		"checkid": null,
    		"addressid": null,
    		"orderLogisticsNo": null,
    		"outTradeNo": null,
    		"payChannel": null,
    		"ordertime": null,
    		"paytime": null,
    		"deliverytime": null,
    		"remark": null,
    		"state": null,
    		"creatername": null,
    		"createtime": null,
    		"updatername": null,
    		"updatetime": null
    	}, {
    		"orderid": 1,
    		"orderno": null,
    		"traceno": null,
    		"userid": null,
    		"shopid": null,
    		"deliveryways": null,
    		"orderstatusno": null,
    		"qrcode": null,
    		"orderstatus": null,
    		"count": null,
    		"origintotalprice": null,
    		"discountprice": null,
    		"orderTotalPrice": null,
    		"logisticsFee": null,
    		"isUnpackingInspection": null,
    		"isCheck": null,
    		"checkid": null,
    		"addressid": null,
    		"orderLogisticsNo": null,
    		"outTradeNo": null,
    		"payChannel": null,
    		"ordertime": null,
    		"paytime": null,
    		"deliverytime": null,
    		"remark": null,
    		"state": null,
    		"creatername": null,
    		"createtime": null,
    		"updatername": null,
    		"updatetime": null
    	}]
    }
