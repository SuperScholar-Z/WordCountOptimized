import java.io.*;
import java.util.*;

//单词统计核心功能
public class WordCount
{
    private BufferedReader input;   //读取文件的输入数据缓冲池
    private ArrayList<Word> wordArr = new ArrayList<>();    //记录文件中所有单词和出现次数

    public WordCount(String inputFilePath) throws IOException  //统计开始前先打开输入文件
    {
        File inputFile = new File(inputFilePath);   //需要读取的文件
        this.input = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile)));
    }

    public ArrayList<Word> getWordArr() //获取wordArr
    {
        return wordArr;
    }

    public void Count() throws IOException //统计单词数
    {
        String line;   //读取的一行文本
        HashMap<String, Word> wordMap = new HashMap<>();    //用HashMap容器暂存单词集
        while ((line = input.readLine()) != null)
        {
            //单词分割
            ArrayList<String> wordST = new ArrayList<>();
            WordSplit.split(line, wordST);    //单词分割
            if(wordST == null)
            {
                continue;
            }

            for(String m_strWord : wordST) //提取出分割的单词
            {
                Word m_word = wordMap.get(m_strWord);

                if (m_strWord.length() == 0)   //跳过空字符串
                {
                    continue;
                }
                if (m_word == null)   //单词第一次出现则放进容器
                {
                    wordMap.put(m_strWord, new Word(m_strWord));
                }
                else    //单词重复出现则计数器+1
                {
                    m_word.incNum();
                }
            }
        }

        for(Word m_strWord : wordMap.values())  //转换成顺序容器以便排序
        {
            wordArr.add(m_strWord);
        }
        WordSort.sort(wordArr); //排序
    }
}