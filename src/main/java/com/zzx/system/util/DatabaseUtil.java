package com.zzx.system.util;

import com.zzx.system.base.PageData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DatabaseUtil {
    private final static Logger LOGGER = LoggerFactory.getLogger(DatabaseUtil.class);

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://10.100.1.145:3306/zzx?useUnicode=true&characterEncoding=utf8&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "scmd2017";
    private static String database;
    private static String ip;

    private static final String SQL = "SELECT * FROM ";// 数据库操作

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            LOGGER.error("can not load jdbc driver", e);
        }
    }

    public DatabaseUtil(String ip, String database){
        this.database = database;
        this.ip = ip;
    }

    /**
     * 获取数据库连接
     *
     * @return
     */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            String url = "jdbc:mysql://"+ip+":3306/"+database+"?useUnicode=true&characterEncoding=utf8&useSSL=false";
            conn = DriverManager.getConnection(url, USERNAME, PASSWORD);
//            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            LOGGER.error("get connection failure", e);
        }
        return conn;
    }

    /**
     * 关闭数据库连接
     * @param conn
     */
    public static void closeConnection(Connection conn) {
        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                LOGGER.error("close connection failure", e);
            }
        }
    }

    /**
     * 获取数据库下的所有表名
     */
    public static List<String> getTableNames() {
        List<String> tableNames = new ArrayList<>();
        Connection conn = getConnection();
        ResultSet rs = null;
        try {
            //获取数据库的元数据
            DatabaseMetaData db = conn.getMetaData();
            //从元数据中获取到所有的表名
            rs = db.getTables(null, null, null, new String[] { "TABLE" });
            while(rs.next()) {
                tableNames.add(rs.getString(3));
            }
        } catch (SQLException e) {
            LOGGER.error("getTableNames failure", e);
        } finally {
            try {
                rs.close();
                closeConnection(conn);
            } catch (SQLException e) {
                LOGGER.error("close ResultSet failure", e);
            }
        }
        return tableNames;
    }

    /**
     * 获取数据库下的指定表名集合并将所有表名转小写
     */
    public static List<String> getTableNamesBySelf(String[] tables) {
        List<String> tableNames = Arrays.asList(tables);
        tableNames.forEach(str->{
            str.toLowerCase();
        });
        return tableNames;
    }

    /**
     * 获取表中所有字段名称
     * @param tableName 表名
     * @return
     */
    public static List<String> getColumnNames(String tableName) {
        List<String> columnNames = new ArrayList<>();
        //与数据库的连接
        Connection conn = getConnection();
        PreparedStatement pStemt = null;
        String tableSql = SQL + tableName;
        try {
            pStemt = conn.prepareStatement(tableSql);
            //结果集元数据
            ResultSetMetaData rsmd = pStemt.getMetaData();
            //表列数
            int size = rsmd.getColumnCount();
            for (int i = 0; i < size; i++) {
                columnNames.add(rsmd.getColumnName(i + 1));
            }
        } catch (SQLException e) {
            LOGGER.error("getColumnNames failure", e);
        } finally {
            if (pStemt != null) {
                try {
                    pStemt.close();
                    closeConnection(conn);
                } catch (SQLException e) {
                    LOGGER.error("getColumnNames close pstem and connection failure", e);
                }
            }
        }
        return columnNames;
    }

    /**
     * 获取表中所有字段类型
     * @param tableName
     * @return
     */
    public static List<String> getColumnTypes(String tableName) {
        List<String> columnTypes = new ArrayList<>();
        //与数据库的连接
        Connection conn = getConnection();
        PreparedStatement pStemt = null;
        String tableSql = SQL + tableName;
        try {
            pStemt = conn.prepareStatement(tableSql);
            //结果集元数据
            ResultSetMetaData rsmd = pStemt.getMetaData();
            //表列数
            int size = rsmd.getColumnCount();
            for (int i = 0; i < size; i++) {
                columnTypes.add(rsmd.getColumnTypeName(i + 1));
            }
        } catch (SQLException e) {
            LOGGER.error("getColumnTypes failure", e);
        } finally {
            if (pStemt != null) {
                try {
                    pStemt.close();
                    closeConnection(conn);
                } catch (SQLException e) {
                    LOGGER.error("getColumnTypes close pstem and connection failure", e);
                }
            }
        }
        return columnTypes;
    }

    /**
     * 获取表中所有字段类型的最大字符个数
     * @param tableName
     * @return
     */
    public static List<String> getColumnTypeLengths(String tableName) {
        List<String> columnTypeLengths = new ArrayList<>();
        //与数据库的连接
        Connection conn = getConnection();
        PreparedStatement pStemt = null;
        String tableSql = SQL + tableName;
        try {
            pStemt = conn.prepareStatement(tableSql);
            //结果集元数据
            ResultSetMetaData rsmd = pStemt.getMetaData();
            //表列数
            int size = rsmd.getColumnCount();
            for (int i = 0; i < size; i++) {
                columnTypeLengths.add(Integer.toString(rsmd.getColumnDisplaySize(i + 1)));
            }
        } catch (SQLException e) {
            LOGGER.error("getColumnTypes failure", e);
        } finally {
            if (pStemt != null) {
                try {
                    pStemt.close();
                    closeConnection(conn);
                } catch (SQLException e) {
                    LOGGER.error("getColumnTypes close pstem and connection failure", e);
                }
            }
        }
        return columnTypeLengths;
    }

    /**
     * 获取表中字段的所有注释
     * @param tableName
     * @return
     */
    public static List<String> getColumnComments(String tableName) {
        List<String> columnTypes = new ArrayList<>();
        //与数据库的连接
        Connection conn = getConnection();
        PreparedStatement pStemt = null;
        String tableSql = SQL + tableName;
        List<String> columnComments = new ArrayList<>();//列名注释集合
        ResultSet rs = null;
        try {
            pStemt = conn.prepareStatement(tableSql);
            rs = pStemt.executeQuery("show full columns from " + tableName);
            while (rs.next()) {
                columnComments.add(rs.getString("Comment"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                    closeConnection(conn);
                } catch (SQLException e) {
                    LOGGER.error("getColumnComments close ResultSet and connection failure", e);
                }
            }
        }
        return columnComments;
    }

    /**
     * 将表名去除前缀并转小写
     * @param tablename
     * @return
     */
    public static String convertTablenameLower(String tablename) {
        return tablename.replace("sc_", "").replace("_","");
    }

    /**
     * 将表名去除前缀并转首字母大写
     * @param tablename
     * @return
     */
    public static String convertTablenameUpper(String tablename) {
        String s = tablename.replace("sc_", "").replace("_","");
        return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
    }

    /**
     * 获取当前表所有属性集合
     * @param pd
     * @return
     */
    public static List<String[]> getFieldList(PageData pd) {
        List<String[]> fieldList = new ArrayList<String[]>();   	//属性集合			========参数4
        List<String> columnNames = getColumnNames(pd.getString("faobject"));
        columnNames = convertTablenamesList(columnNames);
        List<String> columnNamesFirstUppers = convertColumnNameToFirstUpper2(columnNames);
        List<String> columnTypes = getColumnTypes(pd.getString("faobject"));
        List<String> columnComments = getColumnComments(pd.getString("faobject"));
        List<String> columnTypeLengths = getColumnTypeLengths(pd.getString("faobject"));

        for(int i=0; i< columnNames.size(); i++){
			fieldList.add(new String[]{columnNames.get(i),convertColumnTypes(columnTypes.get(i)),columnComments.get(i),"是","无",columnTypeLengths.get(i),"0",columnNamesFirstUppers.get(i)});	//属性放到集合里面
		}
//
//        fieldList.add(new String[]{"MOBILE","String","手机号码","是","无","16","0"});
//        fieldList.add(new String[]{"NAME","String","姓名","是","无","16","0"});
//        fieldList.add(new String[]{"REMARK","String","备注","是","无","255","0"});

        return fieldList;

    }

    /**将集合中的所有字段首字母转大写
     * @param columnNames
     * @return
     */
    private static List<String> convertColumnNameToFirstUpper2(List<String> columnNames) {
        return columnNames.stream().map(str -> {
            StringBuilder sb = new StringBuilder();
            sb.append(str.substring(0,1).toUpperCase());
            sb.append(str.substring(1));
            return sb.toString();
        }).collect(Collectors.toList());
    }

    /**
     * 将所有数据库中的字段进行转化处理
     * @param columnNames
     * @return
     */
    private static List<String> convertTablenamesList(List<String> columnNames) {

        List<String> list = new ArrayList<>();
        columnNames.forEach(DatabaseUtil::convertColumnName);
        list = columnNames.stream().map(str -> {
            return convertColumnName(str);
        }).collect(Collectors.toList());
        return list;
    }

    private static String convertColumnName(String s) {
        StringBuilder sb = new StringBuilder();
        String[] split = s.split("_");
        sb.append(split[0]);
        for(int i = 1; i < split.length; i++){
            split[i] = convertColumnNameToFirstUpper(split[i]);
            sb.append(split[i]);
        }
        return sb.toString();
    }

    private static String convertColumnNameToFirstUpper(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(0,1).toUpperCase());
        sb.append(s.substring(1));
        return sb.toString();
    }


    /**
     * 将数据库中字段类型转成java中java.lang包下对应的类型
     * @param s
     * @return
     */
    private static String convertColumnTypes(String s) {
        if(s.contains(" ")){
            s = s.substring(0,s.indexOf(" "));
        }
        String[] stringStr = new String[]{"CHAR","VARCHAR","TEXT","BLOB"};
        String[] integerStr = new String[]{"INT"};
        String[] doubleStr = new String[]{"DOUBLE"};
        String[] floatStr = new String[]{"FLOAT"};
        String[] datetimeStr = new String[]{"DATETIME"};
        if(isContailStr(stringStr,s)){
            return "String";
        }else if (isContailStr(integerStr,s)){
            return "Integer";
        }else if (isContailStr(doubleStr,s)){
            return "Double";
        }else if (isContailStr(floatStr,s)){
            return "Float";
        }else if (isContailStr(datetimeStr,s)){
            return "Date";
        }
        return "";
    }

    public static String getIp() {
        return ip;
    }

    public static void setIp(String ip) {
        DatabaseUtil.ip = ip;
    }

    public static String getDatabase() {
        return database;
    }

    public static void setDatabase(String database) {
        DatabaseUtil.database = database;
    }

    /**
     * 判断数组中是否包含此元素
     * @param str
     * @param s
     * @return
     */
    private static boolean isContailStr(String[] str, String s) {
        return Arrays.asList(str).contains(s);
    }

    public static void main(String[] args) {
//        List<String> tableNames = getTableNames();
//        List<String> tableNames = getTableNamesBySelf(new String[]{"sc_message","sc_advert"});
//        System.out.println("tableNames:" + tableNames);
//        for (String tableName : tableNames) {
//            System.out.println("ColumnNames:" + getColumnNames(tableName));
//            System.out.println("ColumnTypes:" + getColumnTypes(tableName));
//            System.out.println("ColumnComments:" + getColumnComments(tableName));
//        }
        Connection connection = getConnection();
    }
}