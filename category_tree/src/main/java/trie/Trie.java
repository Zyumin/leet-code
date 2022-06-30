package trie;

/**
 * @author zhengyumin
 * @description todo 写点注释
 * @date 2020-09-11 4:21 PM
 */
public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    //insert
    public void insert(String input) {

        TrieNode node = root;

        for (char ch : input.toCharArray()) {
            if (!node.containsKey(ch)) {
                node.put(ch, new TrieNode());
            }
            //移动到下一节点
            node=node.get(ch);
        }
        node.setEnd();
    }

    //prefixsearch
    public TrieNode startsWith(String input) {
        TrieNode node = root;
        for (char ch : input.toCharArray()) {
            if (!node.containsKey(ch)) {
                return null;
            }
            //移动到下一节点
            node=node.get(ch);
        }
        return node;
    }

    //search
    public boolean search(String input) {
        TrieNode node = startsWith(input);
        return node != null && node.isEnd();

    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));   // 返回 true
        System.out.println(trie.search("app"));     // 返回 false
        System.out.println(trie.startsWith("app")!=null); // 返回 true
        trie.insert("app");
        System.out.println(trie.search("app"));     // 返回 true

    }


}
