package task;

import app.FileMeta;
import com.sun.java_cup.internal.runtime.Scanner;
import util.DBUtil;
import util.Pinyin;
import util.Util;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FileSave implements ScanCallback {


    public void callback(File dir){
        File[] children = dir.listFiles();
        List<FileMeta> locals = new ArrayList<>();
        if (children != null){
            for (File child : children){
                locals.add(new FileMeta(child));
            }
        }
        //TODO
    }

    private List<FileMeta> query(File dir){
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<FileMeta> metas = new ArrayList<>();
        try{
            connection = DBUtil.getConnection();
            String sql = "select name,path,is_directory,size,last_modified"+
                    " from file_meta where path=?";
            ps = connection.prepareStatement(sql);
            ps.setString(1,dir.getPath());
            rs = ps.executeQuery();
            while (rs.next()){
                String name = rs.getString("name");
                String path = rs.getString("path");
                Boolean isDirectory = rs.getBoolean("is_directory");
                Long size = rs.getLong("size");
                Timestamp lastModified = rs.getTimestamp("last_modified");
                FileMeta
                meta = new FileMeta(name,path,isDirectory,size,new java.util.Date(lastModified.getTime()));
                System.out.printf("查询文件信息： name = %s, path = %s,is_directory = %s,size = %s,last_modified = %s\n",name,path,String.valueOf(isDirectory),String.valueOf(size),Util.parseDate(new java.util.Date(lastModified.getTime())));
                metas.add(meta);
            }
            return metas;

        }catch (Exception e){
            e.printStackTrace();
            throw  new RuntimeException("查询出错",e);
        }finally {
            DBUtil.close(connection,ps,rs);
        }
    }

    private void save(File file){
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "insert into file_meta" +
                    "(name, path, is_directory, size, last_modified, pinyin, pinyin_first)"+
                    " values(?, ?, ?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1,file.getName());
            statement.setString(2,file.getParent());
            statement.setBoolean(3,file.isDirectory());
            statement.setLong(4,file.length());
            statement.setTimestamp(5,new Timestamp(file.lastModified()));
            String pinyin = null;
            String pinyin_first = null;

            if (Pinyin.containsChinese(file.getName())){
                String[] pinyins = Pinyin.get(file.getName());
                pinyin = pinyins[0];
                pinyin_first = pinyins[1];
            }
            statement.setString(6,pinyin);
            statement.setString(7,pinyin_first);

            System.out.println("执行文件保存操作:"+ sql);

            statement.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException("文件保存失败",e);
        }finally {
            DBUtil.close(connection,statement);
        }
    }

    public static void main(String[] args) {
        DBInit.init();
        File file= new File("C:\\Users\\LENOVO\\Desktop\\java_tools");
        FileSave fileSave = new FileSave();
        fileSave.save(file);
        fileSave.query(file.getParentFile());
    }

}
