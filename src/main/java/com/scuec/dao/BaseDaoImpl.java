package com.scuec.dao;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BaseDaoImpl implements BaseDao{


    //链接数据库参数
    static String driver="com.mysql.jdbc.Driver";
    static String url="jdbc:mysql://localhost:3306/register";
    static String user="root";
    static String password="123456";
    // 初始化参数
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    public BaseDaoImpl() {

    }

    public void CloseAll(ResultSet rs, PreparedStatement ps, Connection con ){
        try {
            if(rs!=null) rs.close();
            if(ps!=null) ps.close();
            if(con!=null) con.close();
            System.out.println("数据库关闭");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * 查询的通用方法
     * @param sql
     * @param paramsValue
     */
    public <T> List<T> query(String sql, Object[] paramsValue,Class<T> clazz){
        // 返回的集合
        List<T> list = new ArrayList<T>();
        // 对象
        T t = null;
        try {

            //注册驱动
            Class.forName(driver);

            //建立链接
            conn= DriverManager.getConnection(url, user, password);
            System.out.println("数据库启动成功");

            //创建sql语句的对象
            ps = conn.prepareStatement(sql);

            //获取占位符参数的个数， 并设置每个参数的值
            int count = ps.getParameterMetaData().getParameterCount();
            if (paramsValue != null && paramsValue.length > 0) {
                for (int i=0; i<paramsValue.length; i++) {
                    ps.setObject(i+1, paramsValue[i]);
                }
            }

            //执行查询
            rs = ps.executeQuery();
            System.out.println("数据库查询成功");

            //获取结果集元数据
            ResultSetMetaData rsmd = rs.getMetaData();

            //获取列的个数
            int columnCount = rsmd.getColumnCount();

            //遍历rs
            while (rs.next()) {
                // 要封装的对象
                t = clazz.getDeclaredConstructor().newInstance();

                // 遍历每一行的每一列, 封装数据
                for (int i=0; i<columnCount; i++) {
                    // 获取每一列的列名称
                    String columnName = rsmd.getColumnName(i + 1);
                    // 获取每一列的列名称, 对应的值
                    Object value = rs.getObject(columnName);
                    // 封装： 设置到t对象的属性中  【BeanUtils组件】
                    BeanUtils.copyProperty(t, columnName, value);
                }
                // 把封装完毕的对象，添加到list集合中
                list.add(t);
//                System.out.println(rs.getInt("id"));
//                System.out.println(rs.getString("username"));
//                System.out.println(rs.getString("password"));
//                System.out.println(rs.getString("Email"));
//                System.out.println(rs.getString("user_state"));
//                System.out.println(rs.getString("root_folder_id"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }finally {
            CloseAll(rs,ps,conn);
        }

        return list;
    }

    /**
     * 更新的通用方法
     * @param sql   更新的sql语句(update/insert/delete)
     * @param paramsValue  sql语句中占位符对应的值(如果没有占位符，传入null)
     */
    public void Update(String sql,Object[] paramsValue){
        try{
            //注册驱动
            Class.forName(driver);

            //建立链接
            conn= DriverManager.getConnection(url, user, password);
            System.out.println("数据库启动成功");

            //创建sql语句的对象
            ps = conn.prepareStatement(sql);

            // 参数元数据： 得到占位符参数的个数
            int count = ps.getParameterMetaData().getParameterCount();

            // 设置占位符参数的值
            if (paramsValue != null && paramsValue.length > 0) {
                // 循环给参数赋值
                for(int i=0;i<count;i++) {
                    ps.setObject(i+1, paramsValue[i]);
                }
            }
            ps.executeUpdate();
            System.out.println("数据库更新成功");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            CloseAll(rs,ps,conn);
        }


    }

    public void add(Object o) {

    }

    public void update(Object o) {

    }

    public void delete(Object o) {

    }

    public Object getByEamil(String email) {
        return null;
    }

    public List getList() {
        return null;
    }
}
