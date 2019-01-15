package com.accolite.app;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;




import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

    /**
     * Test case for sentenceDetect method
     */
    public void testSentenceDetect() throws IOException {

        App app=new App();
        String paragraph="Hi. How are you? This is Vardhan.";
        String []sentences = new String[]{
                "Hi. How are you?",
                "This is Vardhan."
        };
        assertTrue(Arrays.equals(sentences,app.sentenceDetect(paragraph)));
    }

    /**
     * Test case for tokenize method
     */
    public void testTokenize() throws IOException {

        App app=new App();
        String paragraph="Hi. How are you? This is Vardhan.";
        String []tokens = new String[]{
               "Hi",
                ".",
                "How",
                "are",
                "you",
                "?",
                "This",
                "is",
                "Vardhan",
                "."
        };
        assertTrue(Arrays.equals(tokens,app.tokenize(paragraph)));
    }

   
}
