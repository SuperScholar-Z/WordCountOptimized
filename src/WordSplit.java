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

    public static void split1(String line, ArrayList<String> wordST)   //将一行文本的单词分割出来
    {
        StringTokenizer words = new StringTokenizer(line,"~`!#%^&*_()[]+=:;\"\'|<>,./? \t0123456789{}\\");   //单词分割
        while(words.hasMoreTokens())
        {
            String strWord = CutConnector(words.nextToken());
            wordST.add(strWord.toLowerCase());
        }
    }

    public static void split(String line, ArrayList<String> wordST)
    {
        char[] Line = line.toCharArray();
        String temp;
        int p = 0;
        while(p<line.length())
        {
            if((Line[p]>= 'a'&&Line[p]<='z')||(Line[p]>= 'A'&&Line[p]<='Z'))
            {
                int a = p;//记录字符串开始的索引
                while((Line[p]>= 'a'&&Line[p]<='z')||(Line[p]>= 'A'&&Line[p]<='Z')||Line[p] == '-')//截取单词的循环
                {
                    if(Line[p] == '-')
                    {
                        if(p+1==line.length())//如果'-'是最后一个字符，跳出循环
                            break;
                        if(!((Line[p+1]>= 'a'&&Line[p+1]<='z')||(Line[p+1]>= 'A'&&Line[p+1]<='Z')))//如果'-'后面不是字母，跳出循环
                            break;
                    }
                    p++;
                    if(p==line.length())
                        break;
                }
                temp = line.substring(a,p);//截取这个单词
                wordST.add(temp.toLowerCase());
            }
            else
                p++;
        }
    }
}