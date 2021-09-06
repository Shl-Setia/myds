package recursion;

public class TailRecursion {
    public static void main(String[] args) {
        print(5);
    }

    static void print(int n){
        if(n==0) return; // boundary condition

        System.out.println(n);   // action

        print(n-1);           // last statement of method is recursive
    }
}
