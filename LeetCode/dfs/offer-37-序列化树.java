//序列化树为string，可以用前序加null的占位符，反序列化时也用前序，每次只需要消耗掉第一个字符串即可

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    StringBuilder sb;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        sb=new StringBuilder();
        preOrder(root);
        if(sb.length()>0){
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }
    private void preOrder(TreeNode root){
        if(root==null){
            sb.append("null,");
            return;
        }
        sb.append(root.val).append(",");
        preOrder(root.left);
        preOrder(root.right);
    }
    private int index;    //index用于记录数组中位置，是按顺序来消耗数组中字符串的
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()==0){
            return null;
        }
        String[] s=data.split(",");
        index=0;
        return build(s);
    }

    private TreeNode build(String[] s){
        if(s[index].equals("null")){
            //System.arraycopy(s,1,s,0,s.length-1);
            index++;  //每消耗一个就加1
            return null;  //遇到空节点就返回，并完成当前树分支的构造
        }
        TreeNode root=new TreeNode(Integer.parseInt(s[index++]));
        //System.arraycopy(s,1,s,0,s.length-1);
        root.left=build(s);
        root.right=build(s);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
