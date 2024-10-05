package com.downey.backtrack;

/**
 * 46. 无重复数字的全排列
 * https://leetcode.cn/problems/permutations/
 */
import java.util.*;
public class Permute {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.permute(nums);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
    static class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        HashSet<Integer> hs = new HashSet<>();


        public List<List<Integer>> permute(int[] nums) {
            backtracking(nums);
            return ans;
        }

        public void backtracking(int[] nums) {
            // 结束回溯
            if (nums.length == path.size()) {
                // 错误用法 path 是对象引用，每次添加的都是 path 对象，最后都是一个空集合
                // ans.add(path);
                // 应该创建副本
                ans.add(new ArrayList<>(path));
                return;
            }
            // 遍历
            for (int i = 0; i < nums.length; i++) {
                if (hs.contains(i)) {
                    continue;
                }
                hs.add(i);
                path.add(nums[i]);
                backtracking(nums);
                // path.remove(Integer.valueOf(nums[i]));
                path.remove(path.size() - 1);
                hs.remove(i);
            }
        }
    }
}

