package util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Pinyin {

    private static final String CHINESE_PATTERN ="[\\u4E00-\\u9FA5]";
    public static final HanyuPinyinOutputFormat FORMAT = new HanyuPinyinOutputFormat();
    static {
        //拼音小写
        FORMAT.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        //不带音调
        FORMAT.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        //设置带V
        FORMAT.setVCharType(HanyuPinyinVCharType.WITH_V);
    }

    public static boolean containsChinese(String name){
        return name.matches(".*" + CHINESE_PATTERN + ".*");
    }
    public static String[] get(String name){
        String[] result = new String[2];
        StringBuilder all = new StringBuilder();
        StringBuilder first = new StringBuilder();

        for (char c:name.toCharArray()){

            try {
                String[] pinyins = PinyinHelper.toHanyuPinyinStringArray(c,FORMAT);
                if (pinyins == null|| pinyins.length == 0){
                    all.append(c);
                    first.append(c);
                }else {
                     all.append(pinyins[0]);
                     first.append(pinyins[0].charAt(0));
                }
            } catch (BadHanyuPinyinOutputFormatCombination badHanyuPinyinOutputFormatCombination) {
                all.append(c);
                first.append(c);
            }
        }
        result[0] = all.toString();
        result[1] = first.toString();
        return  result;
    }

    //多音字
    public static String[][] get(String name,boolean fullSpell){
        char[] chars = name.toCharArray();
        String[][] result = new String[chars.length][];
        for (int i = 0;i<chars.length;i++){
            try {
                String[] pinyins = PinyinHelper.toHanyuPinyinStringArray(chars[i],FORMAT);
                if (pinyins == null || pinyins.length == 0){
                    result[i] = new String[]{String.valueOf(chars[i])};
                }else {
                    result[i] = unique(pinyins,fullSpell);
                    }
            } catch (BadHanyuPinyinOutputFormatCombination badHanyuPinyinOutputFormatCombination) {
                result[i] = new String[]{String.valueOf(chars[i])};
            }
        }
        return result;
    }

    public static String[] compose(String[][] pinyin){
        if (pinyin == null ||pinyin.length == 0){
            return null;
        }else if (pinyin.length == 1){
            return pinyin[0];
        }else {
            for (int i = 1;i<pinyin.length;i++){
                pinyin[0] = compose(pinyin[0],pinyin[i]);
            }
            return pinyin[0];
        }
    }

    public static String[] unique(String[] array,boolean fullspell){
        Set<String> set = new HashSet<>();
        for (String s : array){
            if (fullspell){
                set.add(s);
            }else {
                set.add(String.valueOf(s.charAt(0)));
            }
        }
        return set.toArray(new String[set.size()]);
    }

    public static String[] compose(String[] pinyins1,String[] pinyins2){
        String[] result = new String[pinyins1.length * pinyins2.length];

        for (int i = 0;i<pinyins1.length;i++){
            for (int j = 0;j<pinyins2.length;j++){
                result[i*pinyins2.length+j] = pinyins1[i]+pinyins2[j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(get("大多数")));
    }


}
