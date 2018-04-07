import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class WordIOTest   //测试
{
    private Method getFilePathInDialog = null;
    private Method resultOutPut = null;

    @Before
    public void setUp() throws NoSuchMethodException //设置私有方法可见
    {
        getFilePathInDialog = WordIO.class.getDeclaredMethod("getFilePathInDialog");
        getFilePathInDialog.setAccessible(true);

        resultOutPut = WordIO.class.getDeclaredMethod("resultOutput", ArrayList.class);
        resultOutPut.setAccessible(true);
    }

    @Test
    public void testMain1() throws IOException  //命令行输入文件名
    {
        String[] args = {"test\\whiteInput.txt"};

        //抓取控制台输出
        ByteArrayOutputStream baoStream = new ByteArrayOutputStream(1024);
        PrintStream cacheStream = new PrintStream(baoStream);
        PrintStream oldStream = System.out;
        System.setOut(cacheStream);
        WordIO.main(args);    //测试程序
        String message = baoStream.toString();
        System.setOut(oldStream);

        assertEquals("", message);
    }
    @Test
    public void testMain2() throws IOException  //窗口界面读取文件路径
    {
        String[] args = {"-x"};

        //抓取控制台输出
        ByteArrayOutputStream baoStream = new ByteArrayOutputStream(1024);
        PrintStream cacheStream = new PrintStream(baoStream);
        PrintStream oldStream = System.out;
        System.setOut(cacheStream);
        WordIO.main(args);    //测试程序
        String message = baoStream.toString();
        System.setOut(oldStream);

        assertEquals("", message);
    }
    @Test
    public void testMain3() throws IOException  //命令行不输入
    {
        String[] args = null;

        //抓取控制台输出
        ByteArrayOutputStream baoStream = new ByteArrayOutputStream(1024);
        PrintStream cacheStream = new PrintStream(baoStream);
        PrintStream oldStream = System.out;
        System.setOut(cacheStream);
        WordIO.main(args);    //测试程序
        String message = baoStream.toString();
        System.setOut(oldStream);

        assertEquals("输入格式有误！\r\n", message);
    }
    @Test
    public void testMain4() throws IOException  //命令行输入参数个数不为1
    {
        String[] args = {"test\\whiteInput.txt","-x"};

        //抓取控制台输出
        ByteArrayOutputStream baoStream = new ByteArrayOutputStream(1024);
        PrintStream cacheStream = new PrintStream(baoStream);
        PrintStream oldStream = System.out;
        System.setOut(cacheStream);
        WordIO.main(args);    //测试程序
        String message = baoStream.toString();
        System.setOut(oldStream);

        assertEquals("输入格式有误！\r\n", message);
    }
    @Test
    public void testMain5() throws IOException  //窗口界面不选择文件
    {
        String[] args = {"-x"};

        //抓取控制台输出
        ByteArrayOutputStream baoStream = new ByteArrayOutputStream(1024);
        PrintStream cacheStream = new PrintStream(baoStream);
        PrintStream oldStream = System.out;
        System.setOut(cacheStream);
        WordIO.main(args);    //测试程序
        String message = baoStream.toString();
        System.setOut(oldStream);

        assertEquals("未打开输入文件。\r\n", message);
    }
    @Test
    public void testMain6()  //文件读取异常抛出
    {
        String[] args = {"test\\whiteNone.txt"};
        String errorMessage = "";
        try
        {
            WordIO.main(args);
        }
        catch (IOException e)
        {
            errorMessage = e.getMessage();
        }

        assertEquals("test\\whiteNone.txt (系统找不到指定的文件。)", errorMessage);
    }
    @Test
    public void testGetFilePathInDialog7() throws InvocationTargetException, IllegalAccessException   //正常打开文件
    {
        String filePath = (String)getFilePathInDialog.invoke(new WordIO());
        String rootPath = System.getProperty("user.dir");   //项目根路径

        assertEquals(rootPath + "\\test\\whiteInput.txt", filePath);
    }
    @Test
    public void testGetFilePathInDialog8() throws InvocationTargetException, IllegalAccessException   //未打开文件
    {
        String filePath = (String)getFilePathInDialog.invoke(new WordIO());

        assertEquals("", filePath);
    }
    @Test
    public void testResultOutput9() throws Exception //输出结果
    {
        ArrayList<Word> inputString = new ArrayList<>();
        ArrayList<String> expectString = new ArrayList<>();
        ArrayList<String> outputString = new ArrayList<>();

        inputString.add(new Word("test"));
        resultOutPut.invoke(new WordIO(), inputString);

        BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream("result.txt"), "utf-8"));
        String line;
        while((line = input.readLine()) != null)
        {
            outputString.add(line);
        }
        expectString.add("test 1");

        assertEquals(expectString, outputString);
    }
    @Test
    public void testMain10() throws IOException  //无参数
    {
        String[] args = null;

        //抓取控制台输出
        ByteArrayOutputStream baoStream = new ByteArrayOutputStream(1024);
        PrintStream cacheStream = new PrintStream(baoStream);
        PrintStream oldStream = System.out;
        System.setOut(cacheStream);
        WordIO.main(args);    //测试程序
        String message = baoStream.toString();
        System.setOut(oldStream);

        assertEquals("输入格式有误！\r\n", message);
    }
    @Test
    public void testMain11() throws IOException  //>1个参数
    {
        String[] args = {"test\\blackInput.txt", "test\\blackInput2.txt"};

        //抓取控制台输出
        ByteArrayOutputStream baoStream = new ByteArrayOutputStream(1024);
        PrintStream cacheStream = new PrintStream(baoStream);
        PrintStream oldStream = System.out;
        System.setOut(cacheStream);
        WordIO.main(args);    //测试程序
        String message = baoStream.toString();
        System.setOut(oldStream);

        assertEquals("输入格式有误！\r\n", message);
    }
    @Test
    public void testMain12() throws IOException  //参数为空字符串
    {
        String[] args = {"  "};
        String errorMessage = "";
        try
        {
            WordIO.main(args);
        }
        catch (IOException e)
        {
            errorMessage = e.getMessage();
        }

        assertEquals("   (系统找不到指定的路径。)", errorMessage);
    }
    @Test
    public void testMain13() throws IOException  //参数为合法文件路径
    {
        String[] args = {"test\\blackInput.txt"};

        //抓取控制台输出
        ByteArrayOutputStream baoStream = new ByteArrayOutputStream(1024);
        PrintStream cacheStream = new PrintStream(baoStream);
        PrintStream oldStream = System.out;
        System.setOut(cacheStream);
        WordIO.main(args);    //测试程序
        String message = baoStream.toString();
        System.setOut(oldStream);

        assertEquals("", message);
    }
    @Test
    public void testMain14() throws IOException  //参数为不存在的文件路
    {
        String[] args = {"test\\blackNone.txt"};
        String errorMessage = "";
        try
        {
            WordIO.main(args);
        }
        catch (IOException e)
        {
            errorMessage = e.getMessage();
        }

        assertEquals("test\\blackNone.txt (系统找不到指定的文件。)", errorMessage);
    }
    @Test
    public void testMain15() throws IOException //参数为"-x"
    {
        String[] args = {"-x"};

        //抓取控制台输出
        ByteArrayOutputStream baoStream = new ByteArrayOutputStream(1024);
        PrintStream cacheStream = new PrintStream(baoStream);
        PrintStream oldStream = System.out;
        System.setOut(cacheStream);
        WordIO.main(args);    //测试程序
        String message = baoStream.toString();
        System.setOut(oldStream);

        assertEquals("", message);
    }
    @Test
    public void testMain16() throws IOException //参数为"-x"以外的参数
    {
        String[] args = {"-a"};
        String errorMessage = "";
        try
        {
            WordIO.main(args);
        }
        catch (IOException e)
        {
            errorMessage = e.getMessage();
        }

        assertEquals("-a (系统找不到指定的文件。)", errorMessage);
    }
    @Test
    public void testGetFilePathInDialog17() throws InvocationTargetException, IllegalAccessException   //打开文件
    {
        String filePath = (String)getFilePathInDialog.invoke(new WordIO());
        String rootPath = System.getProperty("user.dir");   //项目根路径

        assertEquals(rootPath + "\\test\\blackInput.txt", filePath);
    }
    @Test
    public void testGetFilePathInDialog18() throws InvocationTargetException, IllegalAccessException   //不打开文件
    {
        String filePath = (String)getFilePathInDialog.invoke(new WordIO());

        assertEquals("", filePath);
    }
    @Test
    public void testGetFilePathInDialog19()   //打开不存在的文件
    {
        String filePath = "";
        String errorMessage = "";
        try
        {
            filePath = (String)getFilePathInDialog.invoke(new WordIO());
        }
        catch(Exception e)
        {
            errorMessage = e.getMessage();
        }

        assertEquals("", errorMessage);
    }
    @Test
    public void testResultOutput20() throws Exception   //单行输出
    {
        ArrayList<Word> inputString = new ArrayList<>();
        ArrayList<String> expectString = new ArrayList<>();
        ArrayList<String> outputString = new ArrayList<>();

        inputString.add(new Word("test"));
        resultOutPut.invoke(new WordIO(), inputString);

        BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream("result.txt"), "utf-8"));
        String line;
        while((line = input.readLine()) != null)
        {
            outputString.add(line);
        }
        expectString.add("test 1");

        assertEquals(expectString, outputString);
    }
    @Test
    public void testResultOutput21() throws Exception   //多行输出
    {
        ArrayList<Word> inputString = new ArrayList<>();
        ArrayList<String> expectString = new ArrayList<>();
        ArrayList<String> outputString = new ArrayList<>();

        inputString.add(new Word("test1"));
        inputString.add(new Word("test2"));
        inputString.add(new Word("test3"));
        resultOutPut.invoke(new WordIO(), inputString);

        BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream("result.txt"), "utf-8"));
        String line;
        while((line = input.readLine()) != null)
        {
            outputString.add(line);
        }
        expectString.add("test1 1");
        expectString.add("test2 1");
        expectString.add("test3 1");

        assertEquals(expectString, outputString);
    }
    @Test
    public void testResultOutput22() throws Exception   //空输出
    {
        ArrayList<Word> inputString = new ArrayList<>();
        ArrayList<String> expectString = new ArrayList<>();
        ArrayList<String> outputString = new ArrayList<>();

        resultOutPut.invoke(new WordIO(), inputString);

        BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream("result.txt"), "utf-8"));
        String line;
        while((line = input.readLine()) != null)
        {
            outputString.add(line);
        }

        assertEquals(expectString, outputString);
    }
}

