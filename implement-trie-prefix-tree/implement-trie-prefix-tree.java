class TrieNode {
  Map<Character, TrieNode> children;
  boolean isEnd;

  TrieNode(){
    this.children = new HashMap<>();
  }
}

class Trie {

  private final TrieNode root;

  public Trie() {
    this.root = new TrieNode();
  }

  public void insert(String word) {
    TrieNode node = root;

    for(int i = 0; i < word.length(); i++){
      char ch = word.charAt(i);
      if (node.children.get(ch) == null) {
        node.children.put(ch, new TrieNode());
      }
      node = node.children.get(ch);
    }
    node.isEnd = true;
  }

  public boolean search(String word) {
    TrieNode node = root;

    for(int i = 0; i < word.length(); i++){
      char ch = word.charAt(i);
      if(node.children.get(ch) == null){
        return false;
      }
      node = node.children.get(ch);
    }
    return node.isEnd;
  }

  public boolean startsWith(String word) {
    TrieNode node = root;

    for(int i = 0; i < word.length(); i++){
      char ch = word.charAt(i);
      if(node.children.get(ch) == null) {
        return false;
      }
      node = node.children.get(ch);
    }
    return true;
  }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */