import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by zero on 2018/4/7.
 */
public class WordSortTest {

    public ArrayList<Word> Process(String filePath) throws IOException         //读取目标文件并将读取结果保存在动态数组中
    {
        WordCount wordCount = new WordCount(filePath);    //打开文件
        wordCount.Count();    //统计
        ArrayList<Word> wordArr;
        wordArr = wordCount.getWordArr();
        return wordArr;
    }

    @Test
    public void testNumSequence() throws Exception                        //对于排序结果中的单词大小的顺序进行测试
    {
        ArrayList<Word> wordArr = Process("test\\test-1.txt");
        boolean IsSequenced = true;
        for(int i = 0;i<wordArr.size()-1;i++)
        {
            if(wordArr.get(i).getNum()<wordArr.get(i+1).getNum())
            {
                IsSequenced = false;
            }
        }
        assertTrue(IsSequenced);
    }

    @Test
    public void testNumSort()  throws IOException                        //对于排序结果的单词类型的个数进行测试
    {
        ArrayList<Word> wordArr = Process("test\\test-1.txt");
        int num = 63;
        assertEquals(num, wordArr.size());
    }

    @Test
    public void testNumBorder() throws IOException                       //对于单词个数的边界情况进行测试，单词种类大于100的情况
    {
        ArrayList<Word> wordArr = Process("test\\test-2.txt");
        assertTrue(wordArr.size()<100);
    }

    @Test
    public void testNotNull() throws IOException                            //对于空文件进行测试，检测测试结果是否为空
    {
        ArrayList<Word> wordArr = Process("test\\test-3.txt");
        assertNotNull(wordArr);
    }

    @Test
    public void testNumP() throws IOException                            //测试单词的词频统计结果是否都大于0
    {
        ArrayList<Word> wordArr = Process("test\\test-4.txt");
        boolean isPositive = true;
        for(int i=0;i<wordArr.size();i++)
        {
            if(wordArr.get(i).getNum()<=0)
                isPositive = false;
        }
        assertTrue(isPositive);
    }

    @Test
    public void testMaxSequence() throws IOException                            //测试单词的排序结果最大值是否符合预期
    {
        ArrayList<Word> wordArr = Process("test\\test-1.txt");
        int max = 13;
        assertEquals(max,wordArr.get(0).getNum());
    }

    @Test
    public void testMinSequence() throws IOException                            //测试单词的排序结果最小值是否符合预期
    {
        ArrayList<Word> wordArr = Process("test\\test-5.txt");
        int num = wordArr.size()-1;
        int min = 1;
        assertEquals(min,wordArr.get(num).getNum());
    }

    @Test
    public void testSequence() throws IOException                            //测试单词的排序结果中词频为某个值的个数是否为期望值
    {
        ArrayList<Word> wordArr = Process("test\\test-20.txt");
        int SequenceNum = 0;
        for(int i=0;i<wordArr.size();i++)
        {
            if(wordArr.get(i).getNum()==2)
                SequenceNum++;
        }
        assertEquals(1,SequenceNum);
    }

    @Test
    public void testInitial() throws IOException                            //测试单词的排序结果中词频相同的单词是否按字母的降序排序
    {
        ArrayList<Word> wordArr = Process("test\\test-6.txt");
        boolean result = true;
        for(int i=0;i<wordArr.size()-1;i++)
        {
            if(wordArr.get(i).getNum()==wordArr.get(i+1).getNum()&&wordArr.get(i).getStrWord().charAt(0)<wordArr.get(i+1).getStrWord().charAt(0))
            {
                result = false;
            }
        }
        assertFalse(result);
    }

    @Test
    public void testCapital() throws IOException                            //测试单词的排序结果中单词是否都以小写形式给出
    {
        ArrayList<Word> wordArr = Process("test\\test-18.txt");
        boolean result = true;
        for(int i=0;i<wordArr.size();i++)
        {
            int length = wordArr.get(i).getStrWord().length();
            for(int j=0;j<length;j++)
            {
                if(wordArr.get(i).getStrWord().charAt(j)>'A'&&wordArr.get(i).getStrWord().charAt(j)<'Z')
                    result = false;
            }
        }
        assertTrue(result);
    }

    @Test
    public void testRandom() throws IOException                            //随机选取排序结果中的数测试排序正确性
    {
        ArrayList<Word> wordArr = Process("test\\test-19.txt");
        boolean result = true;
        Random random = new Random();
        int i = random.nextInt(wordArr.size());
        int j = random.nextInt(wordArr.size());
        if(i>j&&wordArr.get(i).getNum()<wordArr.get(j).getNum()||i<j&&wordArr.get(i).getNum()>wordArr.get(j).getNum())
            result = false;
        assertTrue(result);
    }

    @Test
    public void testEx() throws IOException                            //测试排序的序列是否符合预期
    {
        ArrayList<Word> wordArr = Process("test\\test-7.txt");
        assertEquals(16,wordArr.get(2).getNum());
    }

    @Test
    public void testExpect() throws IOException                            //测试排序结果的词频数目是否符合预期
    {
        ArrayList<Word> wordArr = Process("test\\test-16.txt");
        assertEquals(3,wordArr.get(6).getNum());
    }

    @Test
    public void testRand() throws IOException                              //随机测试排序结果是否都为小写
    {
        ArrayList<Word> wordArr = Process("test\\test-17.txt");
        Random random = new Random();
        int i = random.nextInt(wordArr.size());
        boolean result = true;
        int length = wordArr.get(i).getStrWord().length();
        for(int j=0;j<length;j++)
        {
            if(wordArr.get(i).getStrWord().charAt(j)>'A'&&wordArr.get(i).getStrWord().charAt(j)<'Z')
                result = false;
        }
        assertTrue(result);
    }

    @Test
    public void testRandAccess() throws IOException                              //随机测试排序结果中词频是否都为正
    {
        ArrayList<Word> wordArr = Process("test\\test-8.txt");
        Random random = new Random();
        int i = random.nextInt(wordArr.size());
        assertTrue(wordArr.get(i).getNum()>0);
    }

    @Test
    public void testResu() throws IOException                                   //对单词排序进行等价类测试，测试单词相同，词频相同，但顺序不同的测试结果是否相等
    {
        ArrayList<Word> wordArr = Process("test\\test-8.txt");
        ArrayList<Word> wordArr2 = Process("test\\test-9.txt");
        boolean result = false;
        if(wordArr.equals(wordArr2))
            result = true;
        assertTrue(result);
    }

    @Test
    public void testEqual() throws IOException                                   //对单词排序进行等价类测试，测试添加特殊字符的等价类测试结果
    {
        ArrayList<Word> wordArr = Process("test\\test-10.txt");
        ArrayList<Word> wordArr2 = Process("test\\test-11.txt");
        boolean result = false;
        if(wordArr.equals(wordArr2))
            result = true;
        assertTrue(result);
    }

    @Test
    public void testNotEqual() throws IOException                                   //对单词排序进行等价类测试，测试处于两个不同等价类文件的排序结果是否不同
    {
        ArrayList<Word> wordArr = Process("test\\test-12.txt");
        ArrayList<Word> wordArr2 = Process("test\\test-13.txt");
        boolean result = false;
        if(wordArr.equals(wordArr2))
            result = true;
        assertFalse(result);
    }

    @Test
    public void testNotZero() throws IOException                                    //边界值测试，测试结果单词的个数是否大于0
    {
        ArrayList<Word> wordArr = Process("test\\test-14.txt");
        assertTrue(wordArr.size()>=0);
    }

    @Test
    public void testBorder() throws IOException                                    //边界值测试，测试每个词的词频是否都不为0
    {
        ArrayList<Word> wordArr = Process("test\\test-15.txt");
        boolean result = true;
        for(int i = 0;i<wordArr.size();i++)
        {
            if(wordArr.get(i).getNum()==0)
                result = false;
        }
        assertTrue(result);
    }
}