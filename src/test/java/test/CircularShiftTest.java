package test;

import org.junit.Test;

import static org.junit.Assert.*;
import CS3213.CircularShift;
import CS3213.RequiredWords;
import CS3213.WordsToIgnore;

import java.util.HashSet;

public class CircularShiftTest {

    @Test
    public void testGetCircularShifts() throws Exception {
        CircularShift circularShit = new CircularShift("tEst this Circular shIft");
        String[] shifts = circularShit.getCircularShifts();
        HashSet<String> testSet = new HashSet<String>();
        for (String str : shifts) {
            testSet.add(str);
        }
        
        assertTrue(testSet.size() == 4);
        assertTrue(testSet.contains("Test This Circular Shift"));
        assertTrue(testSet.contains("This Circular Shift Test"));
        assertTrue(testSet.contains("Circular Shift Test This"));
        assertTrue(testSet.contains("Shift Test This Circular"));
    }
    
    @Test
    public void testWithIgnoredWords() throws Exception {
        WordsToIgnore wordsToIgnore = WordsToIgnore.getWordsToIgnore();
        wordsToIgnore.addWordToIgnore("this");
        
        CircularShift circularShit = new CircularShift("tEst this Circular shIft");
        String[] shifts = circularShit.getCircularShifts();
        HashSet<String> testSet = new HashSet<String>();
        for (String str : shifts) {
            testSet.add(str);
        }
        assertTrue(testSet.size() == 3);
        assertTrue(testSet.contains("Test this Circular Shift"));
        assertFalse(testSet.contains("this Circular Shift Test"));
        assertTrue(testSet.contains("Circular Shift Test this"));
        assertTrue(testSet.contains("Shift Test this Circular"));
        
        wordsToIgnore.removeWordToIgnore("this");
    }
    
    @Test
    public void testWithIgnoredRequiredWords() throws Exception {
        WordsToIgnore wordsToIgnore = WordsToIgnore.getWordsToIgnore();
        wordsToIgnore.addWordToIgnore("this");
        RequiredWords requiredWords = RequiredWords.getRequiredWords();
        requiredWords.addRequiredWord("shift");
        
        CircularShift circularShit = new CircularShift("tEst this Circular shIft");
        String[] shifts = circularShit.getCircularShifts();
        HashSet<String> testSet = new HashSet<String>();
        for (String str : shifts) {
            testSet.add(str);
        }
        assertTrue(testSet.size() == 1);
        assertFalse(testSet.contains("Test this Circular Shift"));
        assertFalse(testSet.contains("this Circular Shift Test"));
        assertFalse(testSet.contains("Circular Shift Test this"));
        assertTrue(testSet.contains("Shift Test this Circular"));
        
        wordsToIgnore.removeWordToIgnore("this");
        requiredWords.removeRequiredWord("shift");
    }
}
