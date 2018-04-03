import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        String filePath = "";    //从命令行读取的输入文件路径

        //读取命令行输入
        if(args == null || args.length == 0)
            System.out.println("输入格式有误！");
        else
            filePath = args[0];

        WordCount m_WordCount = new WordCount(filePath, "result.txt");
        m_WordCount.Count();
    }
}