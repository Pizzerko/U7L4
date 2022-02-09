import java.util.*;
public class ArrayListAlgorithms {
    /**
     * Returns true if any of the elements in stringList contain
     * target as a substring; false otherwise.
     * <p>
     * Does NOT mutate (modify) elements of stringList.
     * PRECONDITION: stringList.size() > 0
     *
     * @param stringList original arraylist of Strings
     * @return true if target is found in any of the strings, false otherwise
     */
    public static boolean containsTarget(ArrayList<String> stringList, String target) { /* implement this method! */
        for (int i = 0; i < stringList.size(); i++) {
            if (stringList.get(i).indexOf(target) != -1) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns number of elements in intList that are less than the
     * average of all elements.
     * <p>
     * Does NOT mutate (modify) elements of intList.
     * PRECONDITION: intList.size() > 0
     *
     * @param intList original arraylist of Integers
     * @return the number of ints in intList that are less than the average
     */
    public static int belowAverage(ArrayList<Integer> intList) { /* implement this method! */
        double avg = 0;
        int count = 0;
        for (int num : intList) {
            avg += num;
        }
        avg /= intList.size();
        for (int i = 0; i < intList.size(); i++) {
            if (intList.get(i) < avg) {
                intList.remove(i);
                i--;
                count++;
            }
        }
        return count;
    }

    /**
     * Replaces all words in wordList that end in "s" with the all-uppercase
     * version of the word.  For example, "apples" should be replaced with "APPLES".
     * Assume all letters of all words in wordList are lowercase initially (no need
     * to worry about checking for case or converting first to lowercase)
     * <p>
     * DOES mutate (modify) elements of wordList.
     * PRECONDITION: wordList.size() > 0
     *
     * @param wordList original arraylist of words
     */
    public static void replaceWithCaps(ArrayList<String> wordList) { /* implement this method! */
        for (int i = 0; i < wordList.size(); i++) {
            int length = wordList.get(i).length();
            if (wordList.get(i).substring(length - 1, length).equals("s")) {
                wordList.set(i, wordList.get(i).toUpperCase());
            }
        }
    }

    /**
     * Returns the index at which the minimum value of all integers in
     * intList appears; if the minimum value appears more than once in
     * the arraylist, return the index of the first occurrence
     * <p>
     * Does NOT mutate (modify) elements in intList.
     * PRECONDITION: intList.size() > 0
     *
     * @param intList original arraylist of Integers
     * @return the index at which the minimum value occurs
     */
    public static int indexOfMinimum(ArrayList<Integer> intList) { /* implement this method! */
        int lowest = intList.get(0);
        int lowReturn = 0;
        for (int i = 1; i < intList.size(); i++) {
            if (intList.get(i) < lowest) {
                lowest = intList.get(i);
                lowReturn = i;
            }
        }
        return lowReturn;
    }

    /**
     * Returns true if two array lists of the same length contain the exact
     * same elements in the same order (i.e. the two arraylists are identical).
     * Returns false otherwise.
     * <p>
     * Does NOT mutate (modify) elements in either arraylist
     * PRECONDITION: numList1.size() == numList2.size()
     *
     * @param numList1 first arraylist of Integers
     * @param numList2 second arraylist of Integers, has the same size a first
     * @return true if both arraylists are identical, element for element
     */
    public static boolean areIdentical(ArrayList<Integer> numList1, ArrayList<Integer> numList2) { /* implement this method! */
        for (int i = 0; i < numList1.size(); i++) {
            if (numList1.get(i) - numList2.get(i) != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Removes all elements from numList that are ODD Integers.
     * <p>
     * DOES mutate (modify) elements in numList
     * PRECONDITION: numList1.size() > 0
     *
     * @param numList1 arraylist of Integers
     */
    public static void removeOdds(ArrayList<Integer> numList) { /* implement this method! */
        for (int i = 0; i < numList.size(); i++) {
            if (numList.get(i) % 2 != 0) {
                numList.remove(i);
                i--;
            }
        }
    }

    /**
     * Removes all elements from wordList that contain an a, e, i , and/or o.
     * All other words (i.e. those that have u and/or y as the vowel
     * such as "ugh" or "sly", or no vowels, like "psh"), add a duplicate of
     * that element to wordList at an adjacent index.
     * <p>
     * Assume all words have lowercase letters (i.e. no need to check for case)
     * <p>
     * DOES mutate (modify) elements in wordList
     * PRECONDITION: wordList.size() > 0
     *
     * @param wordList arraylist of Strings
     */
    public static void wackyVowels(ArrayList<String> wordList) { /* implement this method! */
        String l = "";
        boolean letters = false;
        for (int i = 0; i < wordList.size(); i++) {
            l = wordList.get(i);
            letters = false;
            for (int b = 0; b < l.length(); b++) {
                if (l.substring(b, b + 1).equals("a") || l.substring(b, b + 1).equals("e") || l.substring(b, b + 1).equals("i") || l.substring(b, b + 1).equals("o")) {
                    letters = true;
                }
            }
            if (letters) {
                wordList.remove(i);
                i--;
            }
        }
        for (int i = 0; i < wordList.size(); i++) {
            wordList.add(i, wordList.get(i));
            i++;
        }
    }

    /** Removes all duplicate values from an intList, leaving only the first
     *  occurrence in the arrayList; for example, this method will modify
     *  [1, 2, 5, 4, 2, 2, 1, 6, 4, 4, 8, 1, 7, 4, 2] --> [1, 2, 5, 4, 6, 8, 7]
     *
     *  DOES mutate (modify) elements in intList
     *  PRECONDITION: intList.size() > 0
     *
     *  @param intList  intList of Integers
     */
    public static void removeDuplicates(ArrayList<Integer> intList)
    { /* implement this method! */
        int length = 0;
        boolean num = false;
    for(int i = 1; i < intList.size(); i++) {
        num = false;
        length = i;
        for(int b = 0; b < length; b++) {
            if(intList.get(i) == intList.get(b)) {
                num = true;
            }
        }
        if(num) {
            intList.remove(i);
            i--;
        }
    }
    }

    /** Adds an uppercase version of each string directly AFTER the string
     *  in wordList; for example, if wordList is ["hello", "my", "best", "friend"]
     *  this this method modifies wordList to be:
     *  ["hello", "HELLO", "my", "MY", "best", "BEST", "friend", "FRIEND"]
     *
     *  Assume all words have lowercase letters originally
     *
     *  DOES mutate (modify) elements in wordList
     *  PRECONDITION: wordList.size() > 0
     *
     *  @param wordList  arraylist of Strings
     */
    public static void duplicateUpperAfter(ArrayList<String> wordList)
    { /* implement this method! */
    for(int i = 0; i < wordList.size(); i++) {
        wordList.add(i + 1, wordList.get(i).toUpperCase());
        i++;
    }
    }

    /** Appends an uppercase version of each string to the END of of wordList;
     *  the uppercase versions appear in the same order as the lowercase versions
     *  for example, if wordList is ["hello", "my", "best", "friend"]
     *  this this method modifies wordList to be:
     *  ["hello", "my", "best", "friend", "HELLO", "MY", "BEST", "FRIEND"]
     *
     *  Assume all words have lowercase letters originally
     *
     *  DOES mutate (modify) elements in wordList
     *  PRECONDITION: wordList.size() > 0
     *
     *  @param wordList  arraylist of Strings
     */
    public static void duplicateUpperEnd(ArrayList<String> wordList)
    { /* implement this method! */
    int length = wordList.size();
    for(int i = 0; i < length; i++) {
        wordList.add(length + i, wordList.get(i).toUpperCase());
    }
    }

    /** Returns an arraylist of Strings that represents the input sentence parsed
     *  into separate words (using a space: " " as the delimiter) and REVERSED
     *  For example, if sentence = "This is my sentence!"
     *  this method return [sentence!, my, is, This]
     *
     *  PRECONDITION: sentence does not end with a space
     *
     *  @param sentence  the input String that represents one or more words
    separated by spaces
     *  @return  new arraylist of Strings containing the words of sentence reversed
     */
    public static ArrayList<String> parseWordsAndReverse(String sentence)
    { /* implement this method! */
        ArrayList<String> wordList =  new ArrayList<String>();
        int index = 0;
        String add = "";
        String sent = sentence;
        while(sent.indexOf(" ") != -1) {
        index = sent.indexOf(" ");
        add = sent.substring(0, index);
        wordList.add(0, add);
        sent = sent.substring(index + 1);
    }
        wordList.add(0, sent);
        return wordList;
    }

    /** Removes all words from wordList that begin with "b" and inserts them at the
     *  front of wordList; all "b" words that are moved should appear in the same order
     *  in the modified arrayList as they did before being moved
     *
     *  For example, this method will take a wordList:
     *  ["apple", "banana", "cherry", "donut", "bagel", "danish", "berry", "baguette", "soda"]
     *  and modify it to
     *  ["banana", "bagel", "berry", "baguette", "apple", "cherry", "donut", "danish", "soda"]
     *
     *  DOES mutate (modify) elements in wordList
     *  PRECONDITIONS: wordList.size() > 0, all strings in wordList have at least one character
     *
     *  @param wordList  arraylist of words
     */
    public static void moveBWords(ArrayList<String> wordList)
    { /* implement this method! */
        String mem = "";
        for(int i = 0; i < wordList.size(); i++) {
            if(wordList.get(i).substring(0,1).equals("b")) {
                mem = wordList.get(i);
                wordList.remove(i);
                wordList.add(0, mem);
            }
        }
        for(int i = 0; i < wordList.size(); i++) {
            if(wordList.get(i).substring(0,1).equals("b")) {
                mem = wordList.get(i);
                wordList.remove(i);
                wordList.add(0, mem);
            }
        }
    }

    /** Returns Arraylist of Integers that contain all mode(s) of the int array numList.
     *  If elements in numList all appear exactly once, there is no mode, and this method
     *  should return an empty list
     *
     *  For example, if numList is: [1, 2, 3, 2, 4, 5, 5, 6],
     *  then numList contains two modes: 2, 5
     *  and this method returns an arraylist containing 2 and 5 (in any order)
     *  If numList is: [1, 2, 3, 2, 4, 5, 5, 6, 6, 7, 6],
     *  then numList contains one mode: 6
     *  and this method returns an arrayList containing 6
     *  If numList is: [1, 2, 3, 4, 5, 6], then numList contains no mode
     *  and this method returns an empty arrayList: []
     *  If numList is: [2, 2, 2, 3, 3, 3, 4, 4, 4],
     *  then numList contains three modes: 2, 3, 4
     *  and this method returns an arrayList containing 2, 3, and 4 (in any order)
     *
     *  Does NOT mutate (modify) elements in numList
     *  PRECONDITIONS: numList.length > 0
     *
     *  @param numList  numList of ints
     */
    public static ArrayList<Integer> modes(int[] numList)
    { /* implement this method! */
        int chosen = 0;
        int occurence = 0;
        int largest = 0;
        ArrayList<Integer> mode = new ArrayList<Integer>();
        mode.add(0, 0);
    for(int i = 0; i < numList.length; i++) {
        chosen = numList[i];
        occurence = 0;
        largest = 0;
        for(int b = 0; b < numList.length; b++) {
            if(chosen == numList[b]) {
                occurence++;
            }
        }
        if(largest < occurence) {
            largest = chosen;
            mode.set(0, chosen);
        }
        if(largest == occurence) {
            mode.add(0, chosen);
        }
    }
    return mode;
    }

}
