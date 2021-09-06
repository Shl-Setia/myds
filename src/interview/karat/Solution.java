package interview.karat;

import java.io.*;
import java.util.*;

/*
Suppose we have an unsorted log file of accesses to web resources. Each log entry consists of an access time, the ID of the user making the access, and the resource ID.

The access time is represented as seconds since 00:00:00, and all times are assumed to be in the same day.

Example:
logs1 = [
    ["58523", "user_1", "resource_1"],
    ["62314", "user_2", "resource_2"],
    ["54001", "user_1", "resource_3"],
    ["200", "user_6", "resource_5"],
    ["215", "user_6", "resource_4"],
    ["54060", "user_2", "resource_3"],
    ["53760", "user_3", "resource_3"],
    ["58522", "user_22", "resource_1"],
    ["53651", "user_5", "resource_3"],
    ["2", "user_6", "resource_1"],
    ["100", "user_6", "resource_6"],
    ["400", "user_7", "resource_2"],
    ["100", "user_8", "resource_6"],
    ["54359", "user_1", "resource_3"],
]

Example 2:
logs2 = [
    ["300", "user_1", "resource_3"],
    ["599", "user_1", "resource_3"],
    ["900", "user_1", "resource_3"],
    ["1199", "user_1", "resource_3"],
    ["1200", "user_1", "resource_3"],
    ["1201", "user_1", "resource_3"],
    ["1202", "user_1", "resource_3"]
]




Write a function that takes the logs and returns the resource with the highest number of accesses in any 5 minute window, together with how many accesses it saw.

Expected Output:
most_requested_resource(logs1) # => ('resource_3', 3)
Reason: resource_3 is accessed at 53760, 54001, and 54060

most_requested_resource(logs2) # => ('resource_3', 4)
Reason: resource_3 is accessed at 1199, 1200, 1201, and 1202

Complexity analysis variables:

n: number of logs in the input



*/

public class Solution {
    public static void main(String[] argv) {
        String[][] logs1 = new String[][] {
                { "58523", "user_1", "resource_1" },
                { "62314", "user_2", "resource_2" },
                { "54001", "user_1", "resource_3" },
                { "200", "user_6", "resource_5" },
                { "215", "user_6", "resource_4" },
                { "54060", "user_2", "resource_3" },
                { "53760", "user_3", "resource_3" },
                { "58522", "user_22", "resource_1" },
                { "53651", "user_5", "resource_3" },
                { "2", "user_6", "resource_1" },
                { "100", "user_6", "resource_6" },
                { "400", "user_7", "resource_2" },
                { "100", "user_8", "resource_6" },
                {"54359", "user_1", "resource_3"},
                };

        String[][] logs2 = new String[][] {
                {"300", "user_1", "resource_3"},
                {"599", "user_1", "resource_3"},
                {"900", "user_1", "resource_3"},
                {"1199", "user_1", "resource_3"},
                {"1200", "user_1", "resource_3"},
                {"1201", "user_1", "resource_3"},
                {"1202", "user_1", "resource_3"}
        };

        findMax(logs1);
    }

    static void findMax(String[][] logs1){

        java.util.Arrays.sort(logs1, new java.util.Comparator<String[]>() {
            public int compare(String[] a, String[] b) {
                if(a[2].compareTo(b[2]) == 0) {
                    return a[0].compareTo(b[0]);
                }else {
                    return a[2].compareTo(b[2]);
                }

            }
        });

        System.out.println(Arrays.deepToString(logs1));
        //

        for(int i =0; i < logs1.length; i++) {

            String currentRes = logs1[i][2];

            if(currentRes.equals(logs1[i][2])){
                String [][] batch = new String[][];

            }


        }


    }

    static int find(String[][] logs1, ) {
        //int i =0;
        //int j = logs1.length-1;
        int globalMax = 0;
        String res;

        for(int i =0 i< logs1.length; i++){
            int current = 1;
            for(int j =i+1; j< logs1.length; j++) {
                if(logs1[j][0] - logs[i][0] <= 300){
                    current++;
                }
                globalMax = Math.max(current, globalMax) ;
            }

        }

        return globalMax;
    }


}

