package com.downey.backtrack;

import java.util.*;
/**
 * 47. 有重复数字的全排列
 * https://leetcode.cn/problems/permutations-ii/description/
 */
public class PermuteTwo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 1};
        List<List<Integer>> lists = solution.permuteUnique(nums);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
    static class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] used;

        public List<List<Integer>> permuteUnique(int[] nums) {
            // 关键是要去重，同一层选择时，如果之前用过了，就不能再用了（要先排序）
            Arrays.sort(nums);
            used = new boolean[nums.length];
//            for (boolean b : used) {
//                System.out.println(b);
//            }
            backtracking(nums);
            return ans;
        }

        public void backtracking(int[] nums) {
            if (nums.length == path.size()) {
                System.out.println("path");
                ans.add(new ArrayList<>(path));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }
                // 这层如果前面值一样且用过 used[i - 1] = false
                // 有可能是上面层在用 前面的值，所以光 nums[i]=nums[i-1]不能判断当前层是否在重复用元素
                // 比如第一层用1 第二层用第二个1
                // 和第一层用完第一个1，再用第二个1是不一样的（这个去重）
                if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) {
                    continue;
                }
                used[i] = true;
                path.add(nums[i]);
                System.out.println(i);
                backtracking(nums);
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }
}