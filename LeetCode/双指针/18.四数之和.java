class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) { // 如果前一个数已经使用过，则跳过当前重复的数
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {// 如果前一个数已经使用过，则跳过当前重复的数
                    continue;
                }
                double remain = (double) target - (double) nums[i] - (double) nums[j]; // 注意溢出
                int p = j + 1, q = nums.length - 1;
                while (p < q) {
                    if ((double) nums[p] + (double) nums[q] < remain) {
                        p++;
                    } else if ((double) nums[p] + (double) nums[q] > remain) {
                        q--;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[p], nums[q]));
                        p++;
                        q--;
                        while (p < q && nums[p] == nums[p - 1]) { // 同上，需要跳过已使用过的数字，
                            p++;
                        }
                        while (p < q && nums[q] == nums[q + 1]) {// 同上，需要跳过已使用过的数字，
                            q--;
                        }
                    }
                }
            }
        }
        return res;
    }
}