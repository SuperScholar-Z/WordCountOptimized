import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//将排序功能封装起来
public class WordSort
{
    public static void sort(ArrayList<Word> wordArr)  //对单词按出现次数降序排序
    {
        Collections.sort(wordArr, new Comparator<Word>()
        {
            @Override
            public int compare(Word word1, Word word2)
            {
                if(word1.getNum() < word2.getNum())
                    return 1;
                else if(word1.getNum() == word2.getNum())
                    return word1.getStrWord().compareTo(word2.getStrWord());
                else
                    return -1;
            }
        }); //排序
    }
}