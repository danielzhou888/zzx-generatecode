package com.zzx.common;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/8/14.
 */
public class YamlConfigUtils {

    public static final Yaml yaml = new Yaml();
    public static Map<String,Object> getYamlConfig(String resource){
        Map<String,Object> map = new HashMap<>();
        try {
            InputStream url = YamlConfigUtils.class.getClassLoader().getResourceAsStream(resource);
            if (url != null) {
                //获取test.yaml文件中的配置数据，然后转换为obj，
//                Object obj =yaml.load(new FileInputStream(url.getFile()));
//                System.out.println(obj);
                //也可以将值转换为Map
//                System.out.println(url.getFile()+"*&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
                map = (Map<String, Object>) yaml.load(url);
                System.out.println(map);
                //通过map我们取值就可以了.
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    public static void main(String[] args) {
        Map<String, Object> yamlConfig = getYamlConfig("cas.yaml");
        System.out.println(yamlConfig.get("isTest"));

        URL url = YamlConfigUtils.class.getClassLoader().getResource("cas.yaml");
    }
}
