package recursion;

public class HeadRecursion {
    public static void main(String[] args) {
        print(5);
    }

    static void print(int n){
        if(n==0) return; // boundary condition

        print(n-1);           // recursive call is not the last statement of method

        System.out.println(n);   // action


    }
}
