import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class WordCountTest {

	private ArrayList<Word> wordtest = new ArrayList<>();
	private ArrayList<Word> wordtrue = new ArrayList<>();
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCount1() throws IOException {

		WordCount m_WordCount = new WordCount("test/test1.txt");    //打开文件
		m_WordCount.Count();    //统计
		wordtest=m_WordCount.getWordArr();	
		assertEquals(wordtrue, wordtest);
	}

	@Test
	public void testCount2() throws IOException {

		WordCount m_WordCount = new WordCount("test/test2.txt");    //打开文件
		m_WordCount.Count();    //统计
		wordtest=m_WordCount.getWordArr();
		Word n_word1 = new Word("ab",1);
		wordtrue.add(n_word1);
		Word n_word2 = new Word("ac",1);
		wordtrue.add(n_word2);
		Word n_word3 = new Word("aa",1);
		wordtrue.add(n_word3);
		Word n_word4 = new Word("ad",1);
		wordtrue.add(n_word4);
		assertEquals(wordtrue, wordtest);
	}
	
	@Test
	public void testCount3() throws IOException {

		WordCount m_WordCount = new WordCount("test/test3.txt");    //打开文件
		m_WordCount.Count();    //统计
		wordtest=m_WordCount.getWordArr();
		Word n_word1 = new Word("ab",1);
		wordtrue.add(n_word1);
		Word n_word2 = new Word("ac",1);
		wordtrue.add(n_word2);
		Word n_word3 = new Word("aa",1);
		wordtrue.add(n_word3);
		Word n_word4 = new Word("ad",1);
		wordtrue.add(n_word4);
		assertEquals(wordtrue, wordtest);
		wordtrue.clear();
		wordtest.clear();
	}
	
	@Test
	public void testCount4() throws IOException {

		WordCount m_WordCount = new WordCount("test/test4.txt");    //打开文件
		m_WordCount.Count();    //统计
		wordtest=m_WordCount.getWordArr();
		Word n_word1 = new Word("ab",2);
		wordtrue.add(n_word1);
		Word n_word2 = new Word("ac",1);
		wordtrue.add(n_word2);
		Word n_word3 = new Word("aa",1);
		wordtrue.add(n_word3);
		Word n_word4 = new Word("ad",3);
		wordtrue.add(n_word4);
		assertEquals(wordtrue, wordtest);
		wordtrue.clear();
		wordtest.clear();
	}	
	
	@Test
	public void testCount5() throws IOException {

		WordCount m_WordCount = new WordCount("test/test5.txt");    //打开文件
		m_WordCount.Count();    //统计
		wordtest=m_WordCount.getWordArr();
		Word n_word1 = new Word("ab",1);
		wordtrue.add(n_word1);
		Word n_word2 = new Word("ac",1);
		wordtrue.add(n_word2);
		Word n_word3 = new Word("aa",1);
		wordtrue.add(n_word3);
		Word n_word4 = new Word("ad",1);
		wordtrue.add(n_word4);
		assertEquals(wordtrue, wordtest);
		wordtrue.clear();
		wordtest.clear();
	}	
	
	@Test
	public void testCount6() throws IOException {

		WordCount m_WordCount = new WordCount("test/test6.txt");    //打开文件
		m_WordCount.Count();    //统计
		wordtest=m_WordCount.getWordArr();
		Word n_word1 = new Word("ab",1);
		wordtrue.add(n_word1);
		Word n_word2 = new Word("ac",1);
		wordtrue.add(n_word2);
		Word n_word3 = new Word("aa",1);
		wordtrue.add(n_word3);
		Word n_word4 = new Word("ad",1);
		wordtrue.add(n_word4);
		assertEquals(wordtrue, wordtest);
		wordtrue.clear();
		wordtest.clear();
	}	
		
	@Test
	public void testCount7() throws IOException {

		WordCount m_WordCount = new WordCount("test/test7.txt");    //打开文件
		m_WordCount.Count();    //统计
		wordtest=m_WordCount.getWordArr();
		Word n_word1 = new Word("ab",1);
		wordtrue.add(n_word1);
		Word n_word2 = new Word("ac",1);
		wordtrue.add(n_word2);
		Word n_word3 = new Word("aa",3);
		wordtrue.add(n_word3);
		Word n_word4 = new Word("ad",1);
		wordtrue.add(n_word4);
		assertEquals(wordtrue, wordtest);
		wordtrue.clear();
		wordtest.clear();
	}	
		
	@Test
	public void testCount8() throws IOException {

		WordCount m_WordCount = new WordCount("test/test8.txt");    //打开文件
		m_WordCount.Count();    //统计
		wordtest=m_WordCount.getWordArr();
		Word n_word1 = new Word("ab",2);
		wordtrue.add(n_word1);
		Word n_word2 = new Word("ac",1);
		wordtrue.add(n_word2);
		Word n_word3 = new Word("aa",3);
		wordtrue.add(n_word3);
		Word n_word4 = new Word("ad",2);
		wordtrue.add(n_word4);
		assertEquals(wordtrue, wordtest);
		wordtrue.clear();
		wordtest.clear();
	}	
	
	@Test
	public void testCount9() throws IOException {

		WordCount m_WordCount = new WordCount("test/test9.txt");    //打开文件
		m_WordCount.Count();    //统计
		wordtest=m_WordCount.getWordArr();
		Word n_word1 = new Word("ab",2);
		wordtrue.add(n_word1);
		Word n_word2 = new Word("ac",1);
		wordtrue.add(n_word2);
		Word n_word3 = new Word("aa",3);
		wordtrue.add(n_word3);
		Word n_word4 = new Word("ad",2);
		wordtrue.add(n_word4);
		Word n_word5 = new Word("aa-ab",1);
		wordtrue.add(n_word5);
		assertEquals(wordtrue, wordtest);
		wordtrue.clear();
		wordtest.clear();
	}	
		
	@Test
	public void testCount10() throws IOException {

		WordCount m_WordCount = new WordCount("test/test10.txt");    //打开文件
		m_WordCount.Count();    //统计
		wordtest=m_WordCount.getWordArr();
		Word n_word1 = new Word("ab",2);
		wordtrue.add(n_word1);
		Word n_word2 = new Word("ac",1);
		wordtrue.add(n_word2);
		Word n_word3 = new Word("aa",3);
		wordtrue.add(n_word3);
		Word n_word4 = new Word("ad",2);
		wordtrue.add(n_word4);
		Word n_word5 = new Word("aa-ab",2);
		wordtrue.add(n_word5);
		assertEquals(wordtrue, wordtest);
		wordtrue.clear();
		wordtest.clear();
	}	
	
	@Test
	public void testCount11() throws IOException {

		WordCount m_WordCount = new WordCount("test/test11.txt");    //打开文件
		m_WordCount.Count();    //统计
		wordtest=m_WordCount.getWordArr();
		Word n_word1 = new Word("ab",3);
		wordtrue.add(n_word1);
		Word n_word2 = new Word("ac",1);
		wordtrue.add(n_word2);
		Word n_word3 = new Word("aa",4);
		wordtrue.add(n_word3);
		Word n_word4 = new Word("ad",2);
		wordtrue.add(n_word4);
		Word n_word5 = new Word("aa-ab",2);
		wordtrue.add(n_word5);
		assertEquals(wordtrue, wordtest);
		wordtrue.clear();
		wordtest.clear();
	}	
	
	@Test
	public void testCount12() throws IOException {

		WordCount m_WordCount = new WordCount("test/test12.txt");    //打开文件
		m_WordCount.Count();    //统计
		wordtest=m_WordCount.getWordArr();
		Word n_word1 = new Word("ab",1);
		wordtrue.add(n_word1);
		Word n_word2 = new Word("ac",1);
		wordtrue.add(n_word2);
		Word n_word3 = new Word("aa",1);
		wordtrue.add(n_word3);
		Word n_word4 = new Word("ad",1);
		wordtrue.add(n_word4);
		assertEquals(wordtrue, wordtest);
		wordtrue.clear();
		wordtest.clear();
	}	
	
	@Test
	public void testCount13() throws IOException {

		WordCount m_WordCount = new WordCount("test/test13.txt");    //打开文件
		m_WordCount.Count();    //统计
		wordtest=m_WordCount.getWordArr();
		Word n_word1 = new Word("ab",1);
		wordtrue.add(n_word1);
		Word n_word2 = new Word("ac",1);
		wordtrue.add(n_word2);
		Word n_word3 = new Word("aa",1);
		wordtrue.add(n_word3);
		Word n_word4 = new Word("ad",1);
		wordtrue.add(n_word4);
		assertEquals(wordtrue, wordtest);
		wordtrue.clear();
		wordtest.clear();
	}	
		
	@Test
	public void testCount14() throws IOException {

		WordCount m_WordCount = new WordCount("test/test14.txt");    //打开文件
		m_WordCount.Count();    //统计
		wordtest=m_WordCount.getWordArr();
		Word n_word1 = new Word("ab",1);
		wordtrue.add(n_word1);
		Word n_word2 = new Word("ac",1);
		wordtrue.add(n_word2);
		Word n_word3 = new Word("aa",1);
		wordtrue.add(n_word3);
		Word n_word4 = new Word("ad",1);
		wordtrue.add(n_word4);
		assertEquals(wordtrue, wordtest);
		wordtrue.clear();
		wordtest.clear();
	}	
			
	@Test
	public void testCount15() throws IOException {

		WordCount m_WordCount = new WordCount("test/test15.txt");    //打开文件
		m_WordCount.Count();    //统计
		wordtest=m_WordCount.getWordArr();
		Word n_word1 = new Word("ab",1);
		wordtrue.add(n_word1);
		Word n_word2 = new Word("ac",1);
		wordtrue.add(n_word2);
		Word n_word3 = new Word("aa",1);
		wordtrue.add(n_word3);
		Word n_word4 = new Word("ad",1);
		wordtrue.add(n_word4);
		assertEquals(wordtrue, wordtest);
		wordtrue.clear();
		wordtest.clear();
	}	
	
	@Test
	public void testCount16() throws IOException {

		WordCount m_WordCount = new WordCount("test/test16.txt");    //打开文件
		m_WordCount.Count();    //统计
		wordtest=m_WordCount.getWordArr();
		Word n_word1 = new Word("ab",3);
		wordtrue.add(n_word1);
		Word n_word2 = new Word("ac",1);
		wordtrue.add(n_word2);
		Word n_word3 = new Word("aa",4);
		wordtrue.add(n_word3);
		Word n_word4 = new Word("ad",2);
		wordtrue.add(n_word4);
		Word n_word5 = new Word("aa-ab",2);
		wordtrue.add(n_word5);
		assertEquals(wordtrue, wordtest);
		wordtrue.clear();
		wordtest.clear();
	}	
	
	@Test
	public void testCount17() throws IOException {

		WordCount m_WordCount = new WordCount("test/test17.txt");    //打开文件
		m_WordCount.Count();    //统计
		wordtest=m_WordCount.getWordArr();
		Word n_word1 = new Word("ab",3);
		wordtrue.add(n_word1);
		Word n_word2 = new Word("ac",1);
		wordtrue.add(n_word2);
		Word n_word3 = new Word("aa",4);
		wordtrue.add(n_word3);
		Word n_word4 = new Word("ad",2);
		wordtrue.add(n_word4);
		Word n_word5 = new Word("aa-ab",2);
		wordtrue.add(n_word5);
		assertEquals(wordtrue, wordtest);
		wordtrue.clear();
		wordtest.clear();
	}	
	
	@Test
	public void testCount18() throws IOException {

		WordCount m_WordCount = new WordCount("test/test18.txt");    //打开文件
		m_WordCount.Count();    //统计
		wordtest=m_WordCount.getWordArr();
		Word n_word1 = new Word("ab",3);
		wordtrue.add(n_word1);
		Word n_word2 = new Word("ac",1);
		wordtrue.add(n_word2);
		Word n_word3 = new Word("aa",4);
		wordtrue.add(n_word3);
		Word n_word4 = new Word("ad",2);
		wordtrue.add(n_word4);
		Word n_word5 = new Word("aa-ab",2);
		wordtrue.add(n_word5);
		assertEquals(wordtrue, wordtest);
		wordtrue.clear();
		wordtest.clear();
	}	
	
	@Test
	public void testCount19() throws IOException {

		WordCount m_WordCount = new WordCount("test/test19.txt");    //打开文件
		m_WordCount.Count();    //统计
		wordtest=m_WordCount.getWordArr();
		Word n_word1 = new Word("aa",2);
		wordtrue.add(n_word1);
		Word n_word2 = new Word("ab",2);
		wordtrue.add(n_word2);
		Word n_word3 = new Word("ac",2);
		wordtrue.add(n_word3);
		Word n_word4 = new Word("ad",2);
		wordtrue.add(n_word4);
		assertEquals(wordtrue, wordtest);
		wordtrue.clear();
		wordtest.clear();
	}	
	
	@Test
	public void testCount20() throws IOException {

		WordCount m_WordCount = new WordCount("test/test20.txt");    //打开文件
		m_WordCount.Count();    //统计
		wordtest=m_WordCount.getWordArr();
		Word n_word1 = new Word("aa",3);
		wordtrue.add(n_word1);
		Word n_word2 = new Word("ab",2);
		wordtrue.add(n_word2);
		Word n_word3 = new Word("ac",2);
		wordtrue.add(n_word3);
		Word n_word4 = new Word("ad",1);
		wordtrue.add(n_word4);
		Word n_word5 = new Word("aa-aa",1);
		wordtrue.add(n_word5);
		assertEquals(wordtrue, wordtest);
		wordtrue.clear();
		wordtest.clear();
	}		
}
