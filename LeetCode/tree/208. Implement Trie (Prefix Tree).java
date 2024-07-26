/*
*
*
*
* Implement a trie with insert, search, and startsWith methods.
*
*
*
*/



//构造字典树的结点，字典树也叫前缀树，一般用于字符串的存储和遍历，实际用处例如搜索引擎的搜索字符串猜测，字符串的自动补全等
//字典树的内部是用一个包含自身结点的数组实现的，字典树结点的下一个孩子结点，是存放在数组中的
//包含了几个基本的方法，和标记是否是结束结点的一个标记
class TrieNode {
    
    // R links to node children
    //内部是有序的，根据字母的ASCII作为索引来排序
    private TrieNode[] links;
    //26个字母
    private final int R = 26;
    //是否为叶子结点
    private boolean isEnd;

    public TrieNode() {
        links = new TrieNode[R];
    }
    
    public boolean containsKey(char ch) {
        return links[ch -'a'] != null;
    }
    public TrieNode get(char ch) {
        return links[ch -'a'];
    }
    public void put(char ch, TrieNode node) {
        links[ch -'a'] = node;
    }
    //标记为叶子节点
    public void setEnd() {
        isEnd = true;
    }
    public boolean isEnd() {
        return isEnd;
    }
}


//字典树的增、查方法的实现
class Trie {
    //根节点
    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node=root;
        //遍历要插入的字符串
        for(int i=0;i<word.length();i++){
            char cur=word.charAt(i);
            //如果当前的结点中不包含有字符串中相应的字符，则插入
            if(!node.containsKey(cur)){
                node.put(cur,new TrieNode());//new TrieNode()表示的是插入值为cur的下一节点为空，cur结点为新插入的叶子节点
            }
            //获取新的叶子结点
            node=node.get(cur);
        }
        //打上结束标记
        node.setEnd();
    }
    
    /** Returns if the word is in the trie. */
    //查找前缀为word的字符串，返回该前缀的结束结点，意思是前缀后面可能还有别的结点
    public TrieNode searchPrefix(String word) {
        TrieNode node=root;
        for(int i=0;i<word.length();i++){
            char cur=word.charAt(i);
            //符合前缀，则继续遍历
            if(node.containsKey(cur)){
                node=node.get(cur);
            }else{
                return null;
            }
        }
        return node;
        
        
    }
    //查找字符串是否存在于字典树中
    public boolean search(String word){
        //先以该字符串为前缀使用查找前缀方法
        TrieNode node=searchPrefix(word);
        //若返回的最后一个结点不为空且是结束结点，则存在该字符串
        return node!=null&&node.isEnd();
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    //是否存在以prefix为前缀的字符串，意思是前缀后面还有别的结点，和上述search方法区别
    public boolean startsWith(String prefix) {
        TrieNode node=searchPrefix(prefix);
        //返回的最后一个结点不为空
        return node!=null;
    }
}




/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
