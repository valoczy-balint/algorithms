package challenges.contacts;

public class Trie {
    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            if(!current.children.containsKey(c)) {
                current.children.put(c, new TrieNode());
            }
            current.wordCount++;
            current = current.children.get(c);
        }
        current.wordCount++;
        current.endOfWord = true;
    }

    public int startsWith(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            current = current.children.get(c);

            if(current == null) {
                return 0;
            }
        }
        return current.wordCount;
    }
}
