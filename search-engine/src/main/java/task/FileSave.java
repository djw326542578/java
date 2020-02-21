package task;

import app.FileMeta;
import com.sun.java_cup.internal.runtime.Scanner;
import util.DBUtil;
import util.Pinyin;
import util.Util;

import java.io.File;
import java.lang.reflect.AnnotatedArrayType;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
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

        List<FileMeta> metas = query(dir);

        for (FileMeta meta : metas){
            if (!locals.contains(meta)){
                delete(meta);
            }
        }

        for (FileMeta meta : locals){
            if (!metas.contains(meta)){
                save(meta);
            }
        }
    }

    public void delete(FileMeta meta){
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "delete from file_meta where" +
                    " (name=? and path=? and is_directory=?)";

            if (meta.getDirectory()){
                sql += " or path=?"+
                        " or path like ?";
            }
            ps = connection.prepareStatement(sql);
            ps.setString(1,meta.getName());
            ps.setString(2,meta.getPath());
            ps.setBoolean(3,meta.getDirectory());
            if (meta.getDirectory()){
                ps.setString(4,meta.getPath()+File.separator+meta.getName());
                ps.setString(5,meta.getPath()+File.separator+meta.getName()+File.separator);
            }
            System.out.printf("删除文件 dir = %s\n"+meta.getPath()+File.separator+meta.getName());
             ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
            throw  new RuntimeException("删除文件出错",e);

        }finally {
            DBUtil.close(connection,ps);
        }
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

    private void save(FileMeta meta){
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "insert into file_meta" +
                    "(name, path, is_directory, size, last_modified, pinyin, pinyin_first)"+
                    " values(?, ?, ?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1,meta.getName());
            statement.setString(2,meta.getPath());
            statement.setBoolean(3,meta.getDirectory());
            statement.setLong(4,meta.getSize());
            statement.setString(5,meta.getLastModifiedText());
            String pinyin = null;
            String pinyin_first = null;

            if (Pinyin.containsChinese(meta.getName())){
                String[] pinyins = Pinyin.get(meta.getName());
                pinyin = pinyins[0];
                pinyin_first = pinyins[1];
            }
            statement.setString(6,meta.getPinyin());
            statement.setString(7,meta.getPinyinFirst());

            System.out.println("执行文件保存操作:"+ sql);

            statement.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException("文件保存失败",e);
        }finally {
            DBUtil.close(connection,statement);
        }
    }

    public static void main(String[] args) {
//        File file= new File("C:\\Users\\LENOVO\\Desktop\\java_tools");
  //      FileSave fileSave = new FileSave();
  //      fileSave.save(file);
  //      fileSave.query(file.getParentFile());

        List<FileMeta> locals = new ArrayList<>();
        locals.add(new FileMeta("1","C:\\Users\\LENOVO\\Desktop\\java_tools",true,0,new Date()));
        locals.add(new FileMeta("11","C:\\Users\\LENOVO\\Desktop\\java_tools\\1",true,0,new Date()));
        locals.add(new FileMeta("2.txt","C:\\Users\\LENOVO\\Desktop\\java_tools\\1\\11",true,0,new Date()));

        List<FileMeta> metas = new ArrayList<>();
        metas.add(new FileMeta("1","C:\\Users\\LENOVO\\Desktop\\java_tools",true,0,new Date()));
        metas.add(new FileMeta("11","C:\\Users\\LENOVO\\Desktop\\java_tools\\1",true,0,new Date()));
        metas.add(new FileMeta("22.txt","C:\\Users\\LENOVO\\Desktop\\java_tools\\1\\11",true,0,new Date()));

        Boolean contains = locals.contains(new FileMeta(new File("")));

        for (FileMeta meta:locals){
            if (!metas.contains(meta)){
                System.out.println(meta);
            }
        }
    }

}
