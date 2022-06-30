package trie;

/**
 * @author zhengyumin
 * @description todo 写点注释
 * @date 2020-09-11 4:17 PM
 */
public class TrieNode {

    /**
     * R links to node children
     */
    private TrieNode[] links;

    private final int R = 26;

    /**
     * 是否尾部节点
     */
    private boolean isEnd = false;


    public TrieNode() {
        links = new TrieNode[R];
    }


    public boolean containsKey(char ch){
        return get(ch)!=null;
    }

    public TrieNode get(char ch){
        return links[ch-'a'];
    }


    public void put(char ch, TrieNode node) {
        links[ch -'a'] = node;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd() {
        isEnd = true;
    }
}
