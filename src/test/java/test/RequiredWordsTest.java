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
        requiredWords.addRequiredWord("the");
        requiredWords.addRequiredWord("of");
        requiredWords.addRequiredWord("");
        assertTrue(requiredWords.isWordRequired("the"));
        assertTrue(requiredWords.isWordRequired("of"));
        assertTrue(requiredWords.isWordRequired(""));
        assertFalse(requiredWords.isWordRequired("after"));
        assertFalse(requiredWords.isWordRequired("before"));

        requiredWords.addRequiredWord("of"); // add duplicated word
        requiredWords.addRequiredWord("after");
        assertTrue(requiredWords.removeRequiredWord("the"));
        assertTrue(requiredWords.removeRequiredWord(""));
        assertFalse(requiredWords.isWordRequired("the"));
        assertTrue(requiredWords.isWordRequired("of"));
        assertFalse(requiredWords.isWordRequired(""));
        assertTrue(requiredWords.isWordRequired("after"));
        assertFalse(requiredWords.isWordRequired("before"));
        
    }
}
