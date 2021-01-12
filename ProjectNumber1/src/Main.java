public class Main {

    static int problemOne(String s){
        /*
        for problem one, i used a double for loop to check every letter
        in the loop with every vowel.
         */
        String vowelCollection = "aeiou";
    int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            String singleChar = s.substring(i, i + 1);
            for (int j = 0; j < vowelCollection.length(); j++) {
                String vowel = vowelCollection.substring(j, j + 1);
                if (singleChar.equals(vowel)){
                    answer++;
                }
            }

        }

        System.out.println("the number of vowels is: " + answer);
        return answer;
    }
    static int problemTwo(String s){
        /*
        for problem two, to find all the bobs i made bob a string and checked
        random index position and random index position + 3.
         */
        int bobCount = 0;
        String bob = "bob";
        int answer = 0;
        for (int i = 0; i < s.length() - 2; i++){
        String chunkOfThree = (s.substring(i, i + 3));
            if (chunkOfThree.equals(bob)){
                answer++;
            }
            }
        System.out.println("the number of bobs is: " + answer);
        return answer;
    }

    static String problemThree(String s){
        /*
        for problem three, i chose a method of finding the longest
        alphabetical string that breaks the string into
        all possible substrings then looks through them starting
        from the biggest until it finds one that's
        alphabetical.
         */
        for (int i = s.length(); i > 0; i--){
            for (int j = 0; j + i < s.length() + 1; j++){
                String butcheredString = s.substring(j, j + i);
                boolean isAlphabetic = true;
                for (int t = 0; t < butcheredString.length() - 1; t++){
                    String firstChar= butcheredString.substring(t, t + 1);
                    String secondChar= butcheredString.substring(t + 1, t + 2);
                    if (firstChar.compareTo(secondChar) > 0){
                        isAlphabetic = false;
                        break;
                    }
                }
                if (isAlphabetic){
                    System.out.println("the longest string is: " + butcheredString);
                    return butcheredString;
                }
            }
        }
        return s;
    }
    public static void main(String[] args) {
        Main.problemOne("eifjoiserncoianio");
        Main.problemTwo("kesbobbwddboswffeobdmbobbob");
        Main.problemThree("eifhudsiouhfaiuaaiefjande");
        /*
        Set s to a string and run your method using s as the parameter
        Run your method in a println statement to determine what the output was
        Once you think you have it working try running the tests.
        The tests will put your method through several different Strings to test
        all possible cases.  If you have 100% success then there is no bugs in your methods.
         */
        String s;
    }
}
