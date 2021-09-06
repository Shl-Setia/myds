package stringManipulation;

import java.util.Arrays;
import java.util.Stack;

public class ReverseWordInSentence {
    public static void main(String[] args) {
        String s = "this is a facebook interview preps";

        String[] splits = s.split(" ");

        // option 1 is to stack.

       /* Stack<String> stack = new Stack<>();

        for(int i=0; i<splits.length; i++){
            stack.push(splits[i]);
        }

        for(int i=0; i<splits.length; i++){
            splits[i] = stack.pop();
        }

        System.out.println(Arrays.deepToString(splits));*/




        // option 2 - inplace replace

        // first replace words then each chars in the words.



        int i = 0;
        int j = splits.length -1;

        while(i<j){
            String temp = splits[i];
            splits[i] = splits[j];
            splits[j] = temp;
            i++;
            j--;
        }

        System.out.println(Arrays.deepToString(splits));



       /* for(String x: splits){
            int p = 0;
            int q = x.length() -1;

            while (p<q){
                char temp = x.charAt(p);

            }
        }*/


        /*char[] chars = s.toCharArray();
        int i =0,  j= s.length()-1;*/


        /*while(i<j){
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }

        System.out.println(chars);

        i =0;

        for(int x = 0; x<s.length(); x++){
            if(chars[x] == ' '){
                j = x-1;
                while(i<j){
                    char temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                    i++;
                    j--;
                }
                i = x+1;
                System.out.println(chars);
            }else if(x == s.length()-1){ // end
                j = x;
                while(i<j){
                    char temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                    i++;
                    j--;
                }
                System.out.println(chars);
            }
        }*/

    }
}
