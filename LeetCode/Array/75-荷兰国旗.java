//这题用双指针，左指针从左到右遍历，遇到0则与左边头部交换，遇到2则与右指针交换
//难点在于，左边头部交换出来的必为1，因为0或者2早已被交换掉，而右指针交换过来到左指针处的，有可能不为1，则需要左指针会退一步（必为1），继续遍历刚才交换过来的数，从而判断是否需要交换。


    public void sortColors(int[] nums) {
        int n;
        if((n=nums.length)<2){
            return;
        }
        int j=n-1,p=0;
        for(int i=0;i<=j;i++){
            if(nums[i]==0){
                nums[i]=nums[p];
                nums[p++]=0;
            }else if(nums[i]==2){
                nums[i]=nums[j];
                nums[j--]=2;
                if(nums[i]!=1){
                    i--;
                }
            }
        }
    }
}
