package arrays.slidingWindow;

// https://leetcode.com/problems/max-consecutive-ones-iii/
public class MaxConsecutiveOnesIII {

    public static void main(String[] args) {
        int A [] = {1,1,1,0,0,0,1,1,1,1,0};
        int K = 2;

        int currentMax = 0;
        int globalMax = 0;

        int countzero =0;

        for(int i=0; i< A.length; i++){

            if(A[i] == 1){
                currentMax++;
                //i++;
            }else if(A[i] == 0 ){
                if(countzero == K){
                    int start = i - currentMax;

                    int countOneUntilZeroFound =0;
                    while (A[start] != 0){
                        countOneUntilZeroFound++;
                        start++;
                    }
                    currentMax = currentMax - countOneUntilZeroFound;
                }else{
                    countzero++;
                    currentMax++;
                    //i++;
                }

            }

            if(globalMax < currentMax){
                globalMax = currentMax;
            }
            System.out.println(currentMax);
        }
        System.out.println("globalMax " + globalMax);

    }
}
