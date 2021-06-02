//1.第一做法暴力解
//2. 用栈，要找第一个序列的下一个更大的数，要注意一个条件，在第二个数组中都存在第一个数组的元素，因此可以直接先对第二个数组进行处理，找到每一个元素的下一个更大元素，然后作为一个剑值对存到map中
//最后遍历num1，从map中找答案即可
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // for(int i=0;i<nums1.length;i++){
        //     int t=nums1[i];
        //     int j=0;
        //     while(j<nums2.length&&nums2[j]!=t){
        //         j++;
        //     }
        //     while(j<nums2.length&&nums2[j]<=t){
        //         j++;
        //     }
        //     if(j==nums2.length){
        //         nums1[i]=-1;
        //     }else{
        //         nums1[i]=nums2[j];
        //     }
            
        // }
        Deque<Integer> stack=new ArrayDeque<>();
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums2.length;i++){
            while(!stack.isEmpty()&&stack.peek()<nums2[i]){
                map.put(stack.pop(),nums2[i]);
            }
            stack.push(nums2[i]);
        }
        for(int i=0;i<nums1.length;i++){
            nums1[i]=map.getOrDefault(nums1[i],-1);
        }
        return nums1;
    }
}
