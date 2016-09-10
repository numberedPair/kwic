package test;
import CS3213.RequiredWords;
import CS3213.WordsToIgnore;

import org.junit.Test;

import static org.junit.Assert.*;

public class RequiredWordsTest {

    @Test
    public void testIsWordIgnored() throws Exception {
        RequiredWords requiredWords = RequiredWords.getRequiredWords();

        // Empty List
        assertFalse(requiredWords.isWordRequired("the"));

        // Standard Add and Check
        assertTrue(requiredWords.addRequiredWord("the"));
        assertTrue(requiredWords.addRequiredWord("of"));
        assertTrue(requiredWords.addRequiredWord(""));
        assertTrue(requiredWords.isWordRequired("the"));
        assertTrue(requiredWords.isWordRequired("of"));
        assertTrue(requiredWords.isWordRequired(""));
        assertFalse(requiredWords.isWordRequired("after"));
        assertFalse(requiredWords.isWordRequired("before"));

        assertTrue(requiredWords.addRequiredWord("of")); // add duplicated word
        assertTrue(requiredWords.addRequiredWord("after"));
        assertTrue(requiredWords.removeRequiredWord("the"));
        assertTrue(requiredWords.removeRequiredWord(""));
        assertFalse(requiredWords.isWordRequired("the"));
        assertTrue(requiredWords.isWordRequired("of"));
        assertFalse(requiredWords.isWordRequired(""));
        assertTrue(requiredWords.isWordRequired("after"));
        assertFalse(requiredWords.isWordRequired("before"));
        
        // Test with WordsToIgnore
        WordsToIgnore wordsToIgnore = WordsToIgnore.getWordsToIgnore();
        RequiredWords requiredWordsTwo = RequiredWords.getRequiredWords();
        
        wordsToIgnore.addWordToIgnore("the");
        wordsToIgnore.addWordToIgnore("of");
        assertFalse(requiredWordsTwo.addRequiredWord("the"));
        assertFalse(requiredWordsTwo.addRequiredWord("of"));
        assertTrue(requiredWordsTwo.addRequiredWord("something"));
        assertFalse(requiredWords.isWordRequired("the"));
        assertTrue(requiredWords.isWordRequired("something"));
    }
}
