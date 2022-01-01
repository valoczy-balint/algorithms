package challenges.bfs.shortestReach;

import java.util.*;

// https://www.hackerrank.com/challenges/ctci-bfs-shortest-reach/problem
public class ShortestReach {

    public List<String> shortestReach(List<Input> inputs) {
        List<String> resultList = new ArrayList<>();
        for(Input input : inputs) {
            Map<Integer, Integer> result = new HashMap<>();

            if(input.edges.containsKey(input.s)) {

                Queue<Map.Entry<Integer, Integer>> queue = new LinkedList<>();
                queue.add(new AbstractMap.SimpleEntry<>(input.s, 0));

                while(!queue.isEmpty()) {
                    Map.Entry<Integer, Integer> entry = queue.remove();
                    Integer currentNode = entry.getKey();
                    Integer currentDistance = entry.getValue();

                    if(result.containsKey(currentNode)) {
                        continue;
                    }

                    queue.addAll(
                            input.edges.get(currentNode)
                                    .stream()
                                    .filter(neighbourNode ->
                                            !result.containsKey(neighbourNode)
                                    )
                                    .map(neighbourNode ->
                                            new AbstractMap.SimpleEntry<>
                                                    (neighbourNode, currentDistance + 6)
                                    ).toList()
                    );

                    result.put(currentNode, currentDistance);
                }
            }


            StringBuilder sb = new StringBuilder();
            for(int i = 1; i <= input.n; i++) {
                if(i == input.s) {
                    continue;
                } else if(!result.containsKey(i)) {
                    sb.append(-1);
                } else {
                    sb.append(result.get(i));
                }
                sb.append(" ");
            }

            System.out.println(sb);
            resultList.add(sb.toString());
        }
        return resultList;
    }
}

