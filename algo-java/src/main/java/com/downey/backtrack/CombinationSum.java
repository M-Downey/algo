package com.downey.backtrack;

import java.util.*;

/**
 * 39. 组合总和
 * https://leetcode.cn/problems/combination-sum/description/
 */
public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.combinationSum(candidates, target);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    static class Solution {
        int sum = 0;
        LinkedList<Integer> path = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);
            backtracking(candidates, 0, target);
            return ans;
        }

        public void backtracking(int[] candidates, int startIndex, int target) {
//            if (sum > target) {
//                return;
//            } else if (sum == target) {
//                ans.add(new ArrayList<>(path));
//                return;
//            }
            if (target == sum) {
                ans.add(new ArrayList<>(path));
                return;
            }

            for (int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i++) {
                path.add(candidates[i]);
                sum += candidates[i];
                backtracking(candidates, i, target);
                sum -= candidates[i];
                path.removeLast();
            }
        }
    }
}
