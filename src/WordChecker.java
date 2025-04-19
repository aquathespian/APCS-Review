import java.util.ArrayList;

public class WordChecker
{
    /** Initialized in the constructor and contains no null elements */
    private ArrayList<String> wordList;

    /**
     * Returns true if each element of wordList (except the first) contains the previous
     * element as a substring and returns false otherwise, as described in part (a)
     * Precondition: wordList contains at least two elements.
     * Postcondition: wordList is unchanged.
     */
    public boolean isWordChain()
    {
        int hits = 0;
        for (int i=1; i<wordList.size(); i++) {
            if (wordList.get(i).contains(wordList.get(i-1))) hits++;
        }
        return (hits == wordList.size()-1);
    }

    /**
     * Returns an ArrayList<String> based on strings from wordList that start
     * with target, as described in part (b). Each element of the returned ArrayList has had
     * the initial occurrence of target removed.
     * Postconditions: wordList is unchanged
     *                 Items appear in the returned list in the same order as they appear in wordList.
     */
    public ArrayList<String> createList(String target)
    {
        ArrayList<String> output = new ArrayList<>();
        for (int i=0; i<wordList.size(); i++) {
            if (wordList.get(i).indexOf(target) == 0) output.add(wordList.get(i).substring(target.length()));
        }
        return output;
    }


    //main method for testing
    public static void main(String[] args) {
        new WordChecker();
    }
    public WordChecker() {
        ArrayList<String> list = new ArrayList<>();
        list.add("an"); list.add("band"); list.add("band"); list.add("abandon");  //you can swap out the words here to test the function.
        wordList = list;
        System.out.println(isWordChain());
        list.clear();
        list.add("catch"); list.add("bobcat"); list.add("catchacat"); list.add("cat"); list.add("at");
        wordList = list;
        System.out.println(createList("cat").toString());
    }

}
