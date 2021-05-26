//一次遍历，这种题要注意一些边界条件，勿越界
//如果用双指针的话，涉及指针加减的情况都要注意边界，
//还有就是要注意指针的迭代，是否会重复移动指针等。

class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        // char[] arr=s.toCharArray();
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<s.length()-1;){
            int j=i+1;
            List<Integer> t=new ArrayList<>();
            while(j<s.length()&&s.charAt(i)==s.charAt(j)){    //注意别越界
                j++;
            }
            if(j-i>=3){
                ans.add(Arrays.asList(i,j-1));
                i=j;
            }else{
                i++;     //这里注意别和上面的i=j混在一起了，否则就移动多了
            }
            
        }
        return ans;
    }
}
