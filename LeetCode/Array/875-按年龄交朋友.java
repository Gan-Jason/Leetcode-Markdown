//这题利用了数组的特性，数组下标和元素有时候可以互换，本来下标是没有意义，但是这题可以作为年龄，元素作为该年龄的人数，这样只需要遍历120长度的数组即可，大大减小遍历长度
//解题的关键是判断两人的年龄是否符合条件，因此年龄是关键
//把原数组的年龄统计一下，然后双循环遍历两个年龄的排列，符合条件则交友邀请为numA*numB
//注意一点是，当A、B为同一个年龄时，交友邀请为numA*(numA-1)，因为A不能给自己发邀请

class Solution {
    public int numFriendRequests(int[] ages) {
        int[] ageNum=new int[121];
        int sum=0;
        for(int i=0;i<ages.length;i++){
            ageNum[ages[i]]+=1;
        }
        for(int i=15;i<121;i++){
            if(ageNum[i]>0){
                for(int j=14;j<121;j++){
                    if(ageNum[j]>0){
                        if(!(j<=0.5*i+7||j>i||j>100&&i<100)){
                            sum+=ageNum[i]*ageNum[j];
                            if(i==j)sum-=ageNum[i];
                        }
                        
                    }
            }
            }

        }
        return sum;
    }
}
