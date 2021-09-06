package graph;

import org.junit.Assert;
import org.junit.Test;

//https://medium.com/algorithm-and-datastructure/similar-string-groups-cb1eaaf0e5b3#:~:text=Two%20strings%20X%20and%20Y%20are%20similar%20if%20we%20can,%22%20%2C%20or%20%22arts%22%20.

// https://leetcode.com/problems/similar-string-groups/solution/

public class GroupSimilarStrings {
    GroupSimilarStrings similarStringGroups;

    class UnionFind {
        int groups;
        int n;
        int[] parents;

        UnionFind(int n) {
            this.n=n;
            this.groups = n;
            this.parents = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
        }

        public int find(int x) {
            while (parents[x] != x) {
                parents[x] = parents[parents[x]];
                x = parents[x];
            }
            return x;
        }

        public void union(int x, int y) {
            int xRoot = find(x);
            int yRoot = find(y);
            if (xRoot != yRoot) {
                parents[xRoot] = yRoot;
                groups--;
            }
        }
    }


    @Test
    public void firstTest() {
        similarStringGroups = new GroupSimilarStrings();
        String[] input = new String[]{"tars","rats","arts","star"};
        //                             "abcd", "cbad", "bcad", "dabc"
        Assert.assertEquals(2, similarStringGroups.numSimilarGroups(input));
    }

    public int numSimilarGroups(String[] A) {
        final int n = A.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (uf.find(i) == uf.find(j)) continue;
                String str1 = A[i];
                String str2 = A[j];
                System.out.println(str1+"-"+str2);
                if (isSimilar(str1, str2)) uf.union(i, j);
            }
        }
        return uf.groups;
    }

    private boolean isSimilar(String a, String b) {
        int count=0;
        for (int i = 0; i <a.length() ; i++) {
            if(a.charAt(i)!=b.charAt(i) && ++count>2) return false;
        }
        System.out.println("similar");
        return true;
    }
}
