package com.accolite.app;

import com.sun.media.sound.InvalidFormatException;
import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.Span;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


/**
 * Open NLP Sample Test App made by Vardhan.
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {

        /**
         * Input to be provided for the various functions
         */
        String paragraph="Hi. How are you? This is Vardhan.";

        String sentenceToBeTokenized="Hi. How are you? This is Vardhan.";


        /**
         *Calling the functions by passing the input as arguments
         */
        sentenceDetect(paragraph);
        tokenize(sentenceToBeTokenized);

    }


    /**
     * Functionality: Sentence detector is for detecting sentence boundaries.
     * Input: A sentence.
     * Output: sentence detector returns an array of strings.
     */
    public static String[] sentenceDetect(String paragraph) throws InvalidFormatException,
            IOException {

        InputStream is = new FileInputStream("en-sent.bin");
        SentenceModel model = new SentenceModel(is);
        SentenceDetectorME sdetector = new SentenceDetectorME(model);

        String sentences[] = sdetector.sentDetect(paragraph);

        System.out.println(sentences[0]);
        System.out.println(sentences[1]);


        String arr[]=new String[]{
                sentences[0],
                sentences[1]
        };
        is.close();

        return arr;
    }


    /**
     * Functionality: Sentence is divided into tokens.
     * Input: A sentence.
     * Output: An array of tokens.
    */
    public static String[] tokenize(String sentence) throws InvalidFormatException, IOException {
        InputStream is = new FileInputStream("en-token.bin");

        TokenizerModel model = new TokenizerModel(is);

        Tokenizer tokenizer = new TokenizerME(model);

        String tokens[] = tokenizer.tokenize(sentence);

        for (String a : tokens)
            System.out.println(a);

        is.close();

        return tokens;
    }
}
