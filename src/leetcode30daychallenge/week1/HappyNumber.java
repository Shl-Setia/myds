package leetcode30daychallenge.week1;

import java.util.ArrayList;
import java.util.List;

public class HappyNumber {

    public static void main(String[] args) {
        System.out.println(isHappy(7));
    }

    public static boolean isHappy(int n) {

        int newNum;
        List<Integer> list = new ArrayList<>();
        while(n != 1){
            int m = n;
            newNum = 0;

            while(m != 0){
                int x = m%10;
                newNum = newNum + Math.multiplyExact(x, x);
                m = m/10;
            }
            n = newNum;
            if(list.contains(newNum)){
                break;
            }else {
                list.add(newNum);
            }
            System.out.println(newNum);
        }

        return n == 1;
    }
}
