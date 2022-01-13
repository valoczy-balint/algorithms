package challenges.topologicalOrder.alienDictionary;

import java.util.*;

public class AlienDictionary {
    // Key: character, values: characters after the key in the alphabet
    private Map<Character, Set<Character>> graph;

    public List<Character> getLetterOrder(List<String> words) {

        return findOrder(buildGraph(words));
    }

    // Ugly for testing
    public List<Character> findOrder(Map<Character, Set<Character>> inputGraph) {
        this.graph = inputGraph;
        Set<Character> visited = new HashSet<>();
        Set<Character> onPath = new HashSet<>();
        List<Character> result = new ArrayList<>();

        graph.forEach((key, value) -> dfs(key, visited, onPath, result));
        Collections.reverse(result);
        return result;
    }

    private void dfs(
            Character character,
            Set<Character> visited,
            Set<Character> onPath,
            List<Character> result
    ) {
        if (onPath.contains(character)) {
            throw new RuntimeException("Circle detected");
        }
        if (visited.contains(character)) {
            return;
        }
        onPath.add(character);
        visited.add(character);

        Set<Character> neighbours = graph.get(character);
        if (neighbours != null) {
            neighbours.forEach(neighbour -> dfs(neighbour, visited, onPath, result)
            );
        }
        result.add(character);
        onPath.remove(character);
    }

    public Map<Character, Set<Character>> buildGraph(List<String> words) {
        Map<Character, Set<Character>> graph = new HashMap<>();

        for (int i = 0; i < words.size() - 1; i++) {
            String word1 = words.get(i);
            String word2 = words.get(i + 1);

            if (word1.length() > word2.length()
                    && word1.startsWith(word2)) {
                throw new RuntimeException("Invalid input");
            }

            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                char char1 = word1.charAt(j);
                char char2 = word2.charAt(j);

                if (char1 != char2) {
                    addNode(graph, char1, char2);
                }
            }
        }

        return graph;
    }

    private void addNode(Map<Character, Set<Character>> graph, char char1, char char2) {
        if (!graph.containsKey(char1)) {
            Set<Character> neighbours = new HashSet<>();
            neighbours.add(char2);
            graph.put(char1, neighbours);
        } else {
            graph.get(char1).add(char2);
        }
    }
}
