package test;
import CS3213.RequiredWords;
import org.junit.Test;

import static org.junit.Assert.*;

public class RequiredWordsTest {

    @Test
    public void testIsWordIgnored() throws Exception {
        RequiredWords requiredWords = RequiredWords.getRequiredWords();

        assertFalse(requiredWords.isWordIgnored("the"));

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
        requiredWords.removeRequiredWord("the");
        requiredWords.removeRequiredWord("");
        assertFalse(requiredWords.isWordRequired("the"));
        assertTrue(requiredWords.isWordRequired("of"));
        assertFalse(requiredWords.isWordRequired(""));
        assertTrue(requiredWords.isWordRequired("after"));
        assertFalse(requiredWords.isWordRequired("before"));
    }
}
