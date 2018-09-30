package com.zzx.entity.${objectNameLower};

import java.io.Serializable;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.List;

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
@TableName("sc_${objectNameLower}")
public class ${objectName} extends Model<${objectName}> {

    private static final long serialVersionUID = 1L;

    <#list fieldList as var>
            <#if var_index == 0>
    /**
     * ${objectName} ID 主键, 自增
     */
    @TableId(value="${objectNameLower}id", type= IdType.AUTO)
    private Integer ${objectNameLower}id;

            <#elseif var[1] == 'Integer'>
    /**
     * ${var[2]}
     */
    private Integer ${var[0]};
            <#elseif var[1] == 'Double'>
    /**
     * ${var[2]}
     */
    private Double ${var[0]};
            <#elseif var[1] == 'Date'>
    /**
     * ${var[2]}
     */
    private Date ${var[0]};
            <#elseif var[1] == 'Blob'>
    /**
     * ${var[2]}
     */
    private byte[] ${var[0]};
            <#elseif var[1] == 'JSON'>
    /**
     * ${var[2]}
     */
    private String ${var[0]};
            <#elseif var[1] == 'Float'>
    /**
     * ${var[2]}
     */
    private Float ${var[0]};
            <#else>
    /**
     * ${var[2]}
     */
    private String ${var[0]};
            </#if>
    </#list>

    // TODO 生成get/set方法和toString方法
    <#list fieldList as var>
            <#if var_index == 0>
    public void set${objectName}id(Integer ${objectNameLower}id){ this.${objectNameLower}id = ${objectNameLower}id; }

    public Integer get${objectName}id() { return ${objectNameLower}id; }

            <#elseif var[1] == 'Blob'>
    public void set${var[7]} (byte[] ${var[0]}){ this.${var[0]} = ${var[0]}; }

    public byte[] get${var[7]}() { return ${var[0]}; }

            <#else>
    public void set${var[7]} (${var[1]} ${var[0]}){ this.${var[0]} = ${var[0]}; }

    public ${var[1]} get${var[7]}() { return ${var[0]}; }
            </#if>
    </#list>

    @Override
    public Serializable pkVal() {
        return this.${objectNameLower}id;
    }

}
