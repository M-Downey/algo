package com.downey.backtrack;

import java.util.*;

/**
 * 78. 子集
 * https://leetcode.cn/problems/subsets/description/
 */
public class Subsets {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3};
        List<List<Integer>> lists = solution.subsets(nums);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
    static class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        public List<List<Integer>> subsets(int[] nums) {
            backtracking(nums, 0);
            return ans;
        }

        public void backtracking(int[] nums, int startIndex) {
            ans.add(new ArrayList<>(path));

            for (int i = startIndex; i < nums.length; i++) {
                path.add(nums[i]);
                backtracking(nums, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }
}
