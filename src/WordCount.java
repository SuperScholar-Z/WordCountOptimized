import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

//单词统计核心功能
public class WordCount
{
    private BufferedReader input;   //读取文件的输入数据缓冲池
    private BufferedWriter output;  //输出缓冲区
    private ArrayList<Word> wordArr = new ArrayList<>();    //记录文件中所有单词和出现次数

    public WordCount(String inputFilePath, String outputFilePath) throws IOException  //统计开始前先打开输入、输出文件
    {
        File inputFile = new File(inputFilePath);   //需要读取的文件
        this.input = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile)));

        File outputFile = new File(outputFilePath); //存储文件
        this.output = new BufferedWriter(new FileWriter(outputFile));
    }

    public void Count() throws IOException //统计单词数
    {
        String line;   //读取的一行文本
        while ((line = input.readLine()) != null)
        {
            StringTokenizer wordST = new StringTokenizer(line,"~`!#%^&*_()[]+=:;\"\'|<>,./? \t0123456789{}\\");   //单词分割
            while(wordST.hasMoreTokens())   //提取出分割的单词
            {
                Word m_word = new Word( CutConnector( wordST.nextToken().toLowerCase() ) );  //逐个单词读入(全部转化为小写，并去掉首尾的'-')
                int indexOfWord = wordArr.indexOf(m_word);    //单词在容器中的位置

                if(m_word.getStrWord().length() == 0)   //跳过空字符串
                    continue;
                if(indexOfWord == -1)   //单词第一次出现则放进容器
                    wordArr.add(m_word);
                else    //单词重复出现则计数器+1
                    wordArr.get(indexOfWord).incNum();
            }
        }
        SortWord.sort(wordArr); //排序

        ResultOutput(); //输出结果
    }

    private String CutConnector(String originWord) //去掉字符串首尾的'-'
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

    private void ResultOutput() throws IOException  //输出结果，关闭文件
    {
        for(Word word : wordArr)
            output.write(word.getStrWord() + "\t" + word.getNum() + "\r\n");

        output.flush(); //把缓存区内容写入磁盘文件中
        output.close(); //关闭文件
    }
}