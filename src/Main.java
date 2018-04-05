import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class Main
{
    private static String getFilePathInDialog() //通过窗口界面打开文件
    {
        //初始化文件选择框
        JFileChooser fDialog = new JFileChooser();
        fDialog.setDialogTitle("请选择输入文件");

        int returnVal = fDialog.showOpenDialog(null);   //弹出选择框
        if(JFileChooser.APPROVE_OPTION == returnVal)    //返回选择的文件路径名
            return fDialog.getSelectedFile().getPath();
        else
            return "";
    }

    private static void resultOutput(ArrayList<Word> wordArr) throws IOException    //输出统计结果
    {
        File outputFile = new File("result.txt"); //打开存储文件
        //PrintWriter output = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile),"UTF-8")));   //输出缓冲区
        BufferedWriter output = new BufferedWriter(new FileWriter(outputFile)); //输出缓冲区

        int rank = 0;   //单词次数排名
        for(Word word : wordArr)    //将统计结果写入缓冲区
        {
            output.write(word.getStrWord() + "\t" + word.getNum() + "\r\n");

            rank++;
            if(rank > 100)  //只输出前100个
                break;
        }

        output.flush(); //把缓存区内容写入磁盘文件中
        output.close(); //关闭文件
    }

    public static void main(String[] args) throws IOException
    {
        String filePath = "";    //从命令行读取的输入文件路径
        int errorType = -1;

        //读取命令行输入
        if(args == null || args.length != 1)
            errorType = 0;
        else if(args[0].equals("-x")) //使用窗口界面获得文件路径
        {
            filePath = getFilePathInDialog();
            if(filePath.length() == 0)
                errorType = 1;
        }
        else    //通过命令行获得文件路径
            filePath = args[0];

        if(errorType == 0)  //命令行输入格式错
            System.out.println("输入格式有误！");
        else if(errorType == 1) //窗口界面未打开文件
            System.out.println("未打开输入文件。");
        else
        {
            WordCount m_WordCount = new WordCount(filePath);    //打开文件
            m_WordCount.Count();    //统计

            resultOutput(m_WordCount.getWordArr()); //输出结果
        }
    }
}