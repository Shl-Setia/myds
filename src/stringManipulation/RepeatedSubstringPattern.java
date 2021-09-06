package stringManipulation;

public class RepeatedSubstringPattern {

    public static void main(String[] args) {

        // calculate the LPS, longest prefix which is also suffix, let it be len. check KMP.
        // string is repeated if n%(n-len) == 0;
        // number of times it is repeated is n/(n-len)


        // ex. str = 'abcdabcdabcd', n = 12
        // len = 8
        // is repeated = 12%(12-8) = 12%4 = 0 (0 == 0)
        // no. of times = 12/(12-8) = 12/4 = 3

       //  https://www.youtube.com/watch?v=GTJr8OvyEVQ
        // https://www.geeksforgeeks.org/kmp-algorithm-for-pattern-searching/
        // https://www.geeksforgeeks.org/find-given-string-can-represented-substring-iterating-substring-n-times/

    }
}
