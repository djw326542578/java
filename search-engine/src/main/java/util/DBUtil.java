package util;

import org.sqlite.SQLiteConfig;
import org.sqlite.SQLiteDataSource;
import task.DBInit;

import javax.sql.DataSource;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {

    private static volatile DataSource DATA_SOURCE;

    //提供获取数据库连接池的方法，使用单例模式
    private  static DataSource getDataSource(){
        if (DATA_SOURCE == null){
            synchronized (DBUtil.class){
                if (DATA_SOURCE == null){
                    SQLiteConfig config = new SQLiteConfig();
                    config.setDateStringFormat(Util.DATE_PATTERN);
                    DATA_SOURCE = new SQLiteDataSource(config);
                    ((SQLiteDataSource)DATA_SOURCE).setUrl(getUrl());
                }
            }
        }
        return DATA_SOURCE;
    }


    private  static String getUrl(){
        try {
            URL classesURL = DBInit.class.getClassLoader().getResource("./");
            String dir = new File(classesURL.getPath()).getParent();
            // System.out.println(classesURL.getPath());
            String url = "jdbc:sqlite://"+ dir +File.separator +"Test.db";
            url = URLDecoder.decode(url,"UTF-8");
            System.out.println("文件路径"+url);
            return  url;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new  RuntimeException("查找失败",e);
        }
    }
    //提供获取连接的方法,从数据库连接到DataSource
    public static Connection getConnection() throws SQLException {
    return getDataSource().getConnection();
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(getConnection());
    }

    public static void close(Connection connection,Statement statement){
        close(connection,statement,null);//2.6
    }

    public static void close(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (connection != null)
                connection.close();
            if (statement != null)
                statement.close();
            if (resultSet != null)
                resultSet.close();
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException("释放错误",e);
        }
    }
}
