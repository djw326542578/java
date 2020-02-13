package task;

/*

 */

import org.omg.CORBA.PUBLIC_MEMBER;
import util.DBUtil;

import java.awt.image.DataBuffer;
import java.io.*;
import java.lang.reflect.Array;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

public class DBInit {
    public static String[] readSQL() {
        try {
            InputStream is = DBInit.class.getClassLoader().getResourceAsStream("ini.sql");
            BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null){
                if (line.contains("--")){//去掉注释的代码
                    line = line.substring(0,line.indexOf("--"));
                }
                sb.append(line);
            }
            String[] sqls =   sb.toString().split(";");
            return sqls;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("读取时错误",e);
        }
    }

    public static void init(){
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DBUtil.getConnection();
            statement = connection.createStatement();
            String[] sqls = readSQL();
            for (String sql :sqls){
                //System.out.println("打印SQL语句"+sql);
                statement.executeUpdate(sql);
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("初始化数据库表失败",e);
        }finally {
            DBUtil.close(connection,statement);
        }
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(readSQL()));
        init();
    }
}

