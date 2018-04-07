import org.junit.Test;

import java.io.IOException;

public class StressTest //压力测试
{
    @Test
    public void stressTest() throws IOException
    {
        String[] args = {"test\\stressInput.txt"};

        WordIO.main(args);
    }
}