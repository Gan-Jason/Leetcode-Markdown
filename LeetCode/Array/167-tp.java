//第一种暴力法，每两个元素的组合都判断一下
//第二种双指针法，对向而行，这里要利用有序的特性，每次都判断两个元素的和，如果小了则移动小指针，如果大了则移动大指针。


class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int x=0,y=1;
        for(int i=0;i<numbers.length;i++){
            x=i;
            y=i+1;
            while(y<numbers.length){
                if(numbers[y]==(target-numbers[i])){
                    int[] ans=new int[2];
                    ans[0]=x+1;
                    ans[1]=y+1;
                    return ans;
                }
                y++;
            }
        }
        int[] ans=new int[2];
        ans[0]=x+1;
        ans[1]=y+1;
        return ans;
    }
}



class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i=0,j=numbers.length-1;
        int[] ans=new int[2];
        while(i<j){
            if(numbers[i]+numbers[j]<target){   //双指针位置比target小，则移动小指针
                if(numbers[i]<numbers[j]){
                    i++;
                }else{
                    j--;
                }
                continue;
            }
            if(numbers[i]+numbers[j]>target){   //双指针位置比target大，则移动大指针
                if(numbers[i]>numbers[j]){
                    i++;
                }else{
                    j--;
                }
                continue;
            }
            ans[0]=i+1;
            ans[1]=j+1;
            break;
        }
        return ans;
    }
}
