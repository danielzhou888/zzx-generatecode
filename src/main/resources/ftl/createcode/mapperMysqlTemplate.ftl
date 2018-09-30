<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.zzx.dao.${objectName}Mapper">
	
	<!--表名 -->
	<sql id="tableName">
		${tabletop}${objectNameLower}
	</sql>
	
	<!-- 字段 -->
	<sql id="Field">
	<#list fieldList as var>
		${var[0]},	
	</#list>
		${objectNameLower}id
	</sql>
	
	<!-- 字段值 -->
	<sql id="FieldValue">
	<#list fieldList as var>
		${r"#{"}${var[0]}${r"}"},	
	</#list>
		${r"#{"}${objectNameLower}id${r"}"}
	</sql>

	<sql id="listWhere">
	    <#list fieldList as var>
            <#if var[1] == 'Integer'>
        <if test="request.${var[0]} != null">
            and ${var[0]} = ${r"#{request."}${var[0]}${r"}"}
        </if>
            <#else>
        <if test="request.${var[0]} != null">
            and ${var[0]} like concat('%',${r"#{request."}${var[0]}${r"}"},'%')
        </if>
            </#if>
    	</#list>
    </sql>
	
	<!-- 新增-->
	<insert id="add" parameterType="map">
		insert into 
	<include refid="tableName"></include>
		(
	<include refid="Field"></include>
		) values (
	<include refid="FieldValue"></include>
		)
	</insert>
	
	<!-- 删除-->
	<delete id="delete" parameterType="map">
		delete from
		<include refid="tableName"></include>
		where 
			${objectNameLower}id = ${r"#{"}${objectNameLower}id${r"}"}
	</delete>
	
	<!-- 修改 -->
	<update id="update" parameterType="map">
		update
		<include refid="tableName"></include>
		set 
	<#list fieldList as var>
        ${var[0]} = ${r"#{"}${var[0]}${r"}"},
	</#list>
		where
		${objectNameLower}id = ${r"#{"}${objectNameLower}id${r"}"}
	</update>
	
	<!-- 通过ID获取数据 -->
	<select id="findById" parameterType="java.lang.Integer" resultType="com.zzx.entity.${objectName}">
		select 
		<include refid="Field"></include>
		from 
		<include refid="tableName"></include>
		where 
			${objectNameLower}id = ${r"#{"}${objectNameLower}id${r"}"}
	</select>
	
	<!-- 列表 -->
	<select id="list" parameterType="map" resultType="com.zzx.entity.${objectName}">
		select
		<include refid="Field"></include>
		from 
		<include refid="tableName"></include>
		<where>
            <include refid="listWhere"/>
        </where>
        <if test="request !=null and request.openSort=true and request.orderBy !=null and request.ordering !=null">
            order by ${r"${request.orderBy}"} ${r"${request.ordering}"}
        </if>
        <if test="request.current != null and request.size != null">
            LIMIT ${r"#{request.startNum}"},${r"#{request.size}"}
        </if>
	</select>

	<!-- 列表总数量 -->
    <select id="listcount" parameterType="map" resultType="com.zzx.entity.${objectName}">
        select COUNT(*)
        from
        <include refid="tableName"></include>
        <where>
            <include refid="listWhere"/>
        </where>
    </select>
	
	<!-- 列表(全部) -->
	<select id="listAll" parameterType="map" resultType="com.zzx.entity.${objectName}">
		select
		<include refid="Field"></include>
		from 
		<include refid="tableName"></include>
	</select>
	
	<!-- 批量删除 -->
	<delete id="deleteAll" parameterType="String">
		delete from
		<include refid="tableName"></include>
		where 
			${objectNameUpper}_ID in
		<foreach item="item" index="index" collection="array" open="(" separator="," close=")">
                 ${r"#{item}"}
		</foreach>
	</delete>
	
	<!-- zhouzhixiang(Daniel Zhou) -->
</mapper>