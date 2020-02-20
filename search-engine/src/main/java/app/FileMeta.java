package app;

import org.omg.CORBA.PUBLIC_MEMBER;
import util.Pinyin;
import util.Util;

import java.io.File;
import java.util.Date;

public class FileMeta {
    private final Boolean isDirectory;
    private String name;//名称
    private String path;//路径
    private Long size;//大小
    private Date lastModified;//上次修改时间

    private String sizeText;
    private String lastModifiedText;
    private String pinyin;//拼音
    private  String pinyinFirst;//拼音首字母
    //通过文件设置
    public FileMeta(File file){
        this(file.getName(),file.getParent(),file.isDirectory(),file.length(),new Date(file.lastModified()));
    }



    public FileMeta(String  name, String path, Boolean isDirectory, long size, Date lastModified){
        this.name = name;
        this.path = path;
        this.isDirectory = isDirectory;
        this.size = size;
        this.lastModified = lastModified;
        if (Pinyin.containsChinese(name)){
            String[] pinyins = Pinyin.get(name);
            pinyin = pinyins[0];
            pinyinFirst = pinyins[1];
        }
        sizeText = Util.parseSize(size);
        lastModifiedText = Util.parseDate(lastModified);
    }

    public Boolean getDirectory() {
        return isDirectory;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getPinyinFirst() {
        return pinyinFirst;
    }

    public void setPinyinFirst(String pinyinFirst) {
        this.pinyinFirst = pinyinFirst;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public String getSizeText() {
        return sizeText;
    }

    public void setSizeText(String sizeText) {
        this.sizeText = sizeText;
    }

    public String getLastModifiedText() {
        return lastModifiedText;
    }

    public void setLastModifiedText(String lastModifiedText) {
        this.lastModifiedText = lastModifiedText;
    }

}
