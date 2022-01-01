package challenges.contacts;

import java.util.ArrayList;
import java.util.List;

// https://www.hackerrank.com/challenges/contacts/problem
public class Contacts {

    public static List<Integer> contacts(List<List<String>> queries) {
        List<Integer> result = new ArrayList<>();
        Trie trie = new Trie();

        for (List<String> query : queries) {
            Operation operation = Operation.valueOf(query.get(0).toUpperCase());
            String value = query.get(1);

            if (operation == Operation.ADD) {
                trie.insert(value);
            } else if(operation == Operation.FIND) {
                result.add(trie.startsWith(value));
            }
        }
        return result;
    }

    private enum Operation {
        ADD, FIND;
    }
}
