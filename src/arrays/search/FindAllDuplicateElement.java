package arrays.search;

public class FindAllDuplicateElement {

    //Find whether a duplicate element present in arrray of n size with range 0 to n-1
    public static void main(String[] args) {
        int s[] = {0, 4, 3, 2, 7, 8, 2, 3, 0};

        System.out.println(s.length);

       /* // This approach does not work for element 0.
        for(int i=0; i<s.length; i++){
            int valueAsIndex = Math.abs(s[i]);

            s[valueAsIndex] = -s[valueAsIndex];
        }*/
        int n = s.length;

        for(int i=0; i<s.length; i++){

            int value = s[i];
            int index =  value%n; // this is to prevent ArrayIndexOutOfBoundsException

            s[index] = s[index] + n;
        }

        System.out.println("repeating element is");
        for(int i=0; i<s.length; i++){

            if(s[i] >= n*2){
                System.out.println(i);
            }
        }
    }
}
