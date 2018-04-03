import java.io.*;

public class FileOutput
{
    private BufferedWriter output;  //输出缓冲区

    public FileOutput(String outputFilePath) throws IOException //类初始化时，打开存储的文件输出缓冲区
    {
        File outputFile = new File(outputFilePath); //存储文件
        this.output = new BufferedWriter(new FileWriter(outputFile));
    }

    public void Close() throws IOException //输出完成，关闭文件
    {
        output.flush(); //把缓存区内容写入磁盘文件中
        output.close(); //关闭文件
    }
}