/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ch01.groupsum;

/**
 *
 * @author prokopiukd
 */
public class GroupSum {

    public boolean groupSum(int start, int[] nums, int target) {
        if (start >= nums.length) {
            return target == 0;
        }
        return groupSum(start + 1, nums, target - nums[start]) || groupSum(start + 1, nums, target);
    }

    public boolean groupSum1(int step, int[] data, int target) {
        if (step >= data.length) {
            return target == 0;
        }
        return groupSum1(step + 1, data, target - data[step]) || groupSum1(step + 1, data, target);
    }

    public boolean groupSum3(int step, int[] data, int target) {
        if (step >= data.length) {
            return target == 0;
        }
        return groupSum3(step + 1, data, target - data[step]) || groupSum3(step + 1, data, target);
    }

    public static void main(String[] args) {
        GroupSum groupSum = new GroupSum();
        int[] data = new int[]{1, 2, 3, 8, 4};
        boolean res = groupSum.groupSum(0, data, 15);
        System.out.println("res=" + res);
        res = groupSum.groupSum1(0, data, 15);
        System.out.println("res=" + res);
        res = groupSum.groupSum3(0, data, 15);
        System.out.println("res=" + res);
    }

}
