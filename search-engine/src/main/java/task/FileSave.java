package task;

import com.sun.java_cup.internal.runtime.Scanner;
import util.DBUtil;
import util.Pinyin;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class FileSave implements ScanCallback {


    public void callback(File dir){
        File[] children = dir.listFiles();
        if (children != null){
            for (File child : children){
                System.out.println(child.getPath());
                save(child);
            }
        }
    }
    private void save(File file){
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "insert into file_meta" +
                    "(name, path, size, last_modified, pinyin, pinyin_first)"+
                    " values(?,?,?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1,file.getName());
            statement.setString(2,file.getParent());
            statement.setLong(3,file.length());
            statement.setTimestamp(4,new Timestamp(file.lastModified()));
            String pinyin = null;
            String pinyin_first = null;

            if (Pinyin.containsChinese(file.getName())){
                String[] pinyins = Pinyin.get(file.getName());
                pinyin = pinyins[0];
                pinyin_first = pinyins[1];
            }
            statement.setString(5,pinyin);
            statement.setString(6,pinyin_first);

            System.out.println("执行文件保存操作:"+ sql);

            statement.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException("文件保存失败",e);
        }finally {

        }
    }

}
