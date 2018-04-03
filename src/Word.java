//将单个单词封装成类
public class Word
{
    private String strWord;   //单词字符串
    private int num = 1;    //单词出现次数

    public Word(String strWord)
    {
        this.strWord = strWord;
    }

    public String getStrWord()  //获取单词字符串
    {
        return strWord;
    }

    public int getNum() //获取单词出现次数
    {
        return num;
    }

    public void incNum()    //单词数量+1
    {
        this.num += 1;
    }

    @Override
    public boolean equals(Object obj)   //重写equals方法，用strWord的值来判断Word类相同
    {
        if (obj instanceof Word)
            return this.getStrWord().equals(((Word) obj).getStrWord());
        else
            return false;
    }
}