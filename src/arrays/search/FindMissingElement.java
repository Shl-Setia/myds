package arrays.search;

public class FindMissingElement {

    public static void main(String[] args) {
      //findMissingInSortedArray();
      //findMisingElementInUnsortedArray();

      singleElementInaSortedArray();

    }

    //https://www.geeksforgeeks.org/find-the-missing-number-in-a-sorted-array/

    // binary search
    private static void findMissingInSortedArray(){
        int ar [] = {1, 2, 3, 4, 6, 7, 8};

        int size = ar.length;

        // use binary search and element before missing element will have a[i] - i = 1 &
        // element after the missing element will have a[i] - i = 2;
        // time complexity O(log n)

        int left = 0;
        int right = size - 1;
        int mid =0;

        while(right - left > 1){
            mid = (left + right)/2;
            if((ar[left] - left) != (ar[mid] - mid)){
               right = mid;
            }else if((ar[right] - right) != (ar[mid] - mid)){
                left = mid;
            }
        }

        System.out.println(ar[mid] - 1);
    }


    ////https://www.geeksforgeeks.org/find-the-missing-number/
    // option 1 : n*(n+1)/2
    // option 2 : XOR
    private static void findMisingElementInUnsortedArray(){

        int ar [] = {1, 2, 4, 6, 3, 7, 8};

        int allElementsXOR = ar[0];

        int XORTillN = 1;

        for(int i = 1; i < ar.length ; i++){
            allElementsXOR = allElementsXOR ^ ar[i];
        }

        for(int j = 2; j<= ar.length+1; j++){
            XORTillN = XORTillN ^ j;
        }

        System.out.println(allElementsXOR ^ XORTillN);
    }


    // https://leetcode.com/problems/single-element-in-a-sorted-array/
    private static void singleElementInaSortedArray(){
        int ar [] = {1,1,2,3,3,4,4,8,8};

        int ans = ar[0];
        for(int i = 1; i <ar.length; i++){ // this is O(n) solution
            ans = ans ^ ar[i];
        }

        System.out.println(ans);

        // try to find it in O(log n)
        singleElementInaSortedArrayINLOGN(ar, 0, ar.length-1);


    }

    // binary search
    private static void singleElementInaSortedArrayINLOGN(int ar [], int left, int right){
        if(left > right)
            return;
        if(left == right)
        {
            System.out.println("The required element is "+ar[left]);
            return;
        }

        int mid = left + (right- left)/2;

        if(mid%2 == 0){ // mid is even index
            if(ar[mid] == ar[mid+1]){
                // required element is after mid
                singleElementInaSortedArrayINLOGN(ar, mid+2, right);
            }else{
                singleElementInaSortedArrayINLOGN(ar, left, mid);
            }
        }else { // mid is  odd index
            if(ar[mid] == ar[mid-1]){
                // required element is after mid
                singleElementInaSortedArrayINLOGN(ar, mid+1, right);
            }else{
                singleElementInaSortedArrayINLOGN(ar, left, mid-1);
            }
        }
    }
}
