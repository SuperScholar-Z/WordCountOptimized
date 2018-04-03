import java.util.Comparator;

//按单词出现次数给Word的ArrayList容器排序
public class SortByNum implements Comparator
{
    @Override
    public int compare(Object o1, Object o2)
    {
        Word word1 = (Word)o1;
        Word word2 = (Word)o2;

        if(word1.getNum() < word2.getNum())
            return 1;
        else if(word1.getNum() == word2.getNum())
            return 0;
        else
            return -1;
    }
}