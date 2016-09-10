package CS3213;

import java.util.HashSet;

public class RequiredWords {
	 private HashSet<String> _requiredWords;
	    private static RequiredWords _instatnce;
	    private RequiredWords() {
	        this._requiredWords = new HashSet<String>();
	    }

	    public static RequiredWords getRequiredWords() {
	        if (_instatnce == null) {
	            _instatnce = new RequiredWords();
	        }

	        return _instatnce;
	    }

	    public void addRequiredWord(String word) {
	        assert(word != null);
	        this._requiredWords.add(word);
	    }

	    public void removeRequiredWord(String word) {
	        assert(word != null);
	        this._requiredWords.remove(word);
	    }

	    public boolean isWordRequired(String word) {
	        assert(word != null);
	        return this._requiredWords.contains(word);
	    }
}
