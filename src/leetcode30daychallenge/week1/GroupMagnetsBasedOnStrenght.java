package leetcode30daychallenge.week1;

public class GroupMagnetsBasedOnStrenght {

    public static void main(String[] args) {
        int a[] = {1,2,3,4,5,6,7,8,9};
        int size = a.length;
        int b[];

        int max = 0;


        for(int i=0; i< a.length;i++) {


            for(int j=i+1; j< a.length; j++){
                b = new int[size];
                int k=0;
                b[k]= a[i];

               // while()
                if(Math.abs(a[i] - a[j] ) > 3) {
                    // same
                    b[k] = a[j];
                }
            }
        }
    }
}
