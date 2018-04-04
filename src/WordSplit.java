import java.util.ArrayList;
import java.util.StringTokenizer;

//单词分割
public class WordSplit
{
    private static String CutConnector(String originWord) //去掉字符串首尾的'-'
    {
        int length = originWord.length();   //字符串长度
        int begin = 0;  //字符串首部
        int end = length - 1;  //字符串末尾

        while(begin < length && originWord.charAt(begin) == '-')  //去掉首部的'-'
            begin++;
        while(end >= 0 && originWord.charAt(end) == '-')    //去掉末尾的'-'
            end--;

        if(begin > end)
            return "";
        else
            return originWord.substring(begin, end + 1);
    }

    public static void split(String line, ArrayList<String> wordST)   //将一行文本的单词分割出来
    {
        StringTokenizer words = new StringTokenizer(line,"~`!#%^&*_()[]+=:;\"\'|<>,./? \t0123456789{}\\");   //单词分割
        while(words.hasMoreTokens())
        {
            String strWord = CutConnector(words.nextToken());
            wordST.add(strWord);
        }
    }
}