import heap.MinHeap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Integer> shortestPaths = createShortestPaths(n);
        shortestPaths.put(k, 0);

        List<Integer> visited = new ArrayList<>();
        MinHeap<PossibleRoute> possibleRoutes = new MinHeap<>();
        possibleRoutes.insert(new PossibleRoute(0, k));

        while (visited.size() < n && !possibleRoutes.isEmpty()) {
            PossibleRoute currentOption = possibleRoutes.delete();
            int currentNode = currentOption.node;
            int currentDistance = currentOption.distance;

            if (!visited.contains(currentNode)) {
                int[][] relatedEdges = findRelatedEdges(times, currentNode);

                for (int[] relatedEdge : relatedEdges) {
                    int destinationNode = relatedEdge[1];
                    int edgeWeight = relatedEdge[2];

                    if (shortestPaths.get(destinationNode) == null) {
                        shortestPaths.put(destinationNode, currentDistance + edgeWeight);
                    } else if (currentDistance + edgeWeight < shortestPaths.get(destinationNode)) {
                        shortestPaths.put(destinationNode, currentDistance + edgeWeight);
                    }

                    PossibleRoute possibleRoute = new PossibleRoute(currentDistance + shortestPaths.get(destinationNode), destinationNode);
                    possibleRoutes.insert(possibleRoute);
                }

                visited.add(currentNode);
            }
        }

        return findSolution(n, shortestPaths);
    }

    private Map<Integer, Integer> createShortestPaths(int n) {
        Map<Integer, Integer> shortestPaths = new HashMap<>();
        for (int i = 1; i < n; i++) {
            shortestPaths.put(i, null);
        }
        return shortestPaths;
    }

    private int[][] findRelatedEdges(int[][] edges, int node) {
        List<int[]> result = new ArrayList<>();

        for (int[] edge : edges) {
            if (edge[0] == node) {
                result.add(edge);
            }
        }

        int[][] resultArray = new int[result.size()][3];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }

    private int findSolution(int n, Map<Integer, Integer> shortestPaths) {
        if (shortestPaths.containsValue(null)) {
            return -1;
        } else {
            int max = -1;
            for (int i = 1; i <= n; i++) {
                if (shortestPaths.get(i) > max) {
                    max = shortestPaths.get(i);
                }
            }
            return max;
        }
    }
}
