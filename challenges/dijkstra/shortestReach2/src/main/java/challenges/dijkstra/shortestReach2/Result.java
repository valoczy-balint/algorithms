package challenges.dijkstra.shortestReach2;

import java.util.*;

// https://www.hackerrank.com/challenges/dijkstrashortreach/problem?h_r=internal-search&isFullScreen=true
class Result {

    /*
     * Complete the 'shortestReach' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY edges
     *  3. INTEGER s
     */

    public List<Integer> shortestReach(int n, List<List<Integer>> edges, int s) {
        Map<Integer, Map<Integer,Integer>> graph = createGraph(edges);

        Set<Integer> visited = new HashSet<>();
        PriorityQueue<Pair> heap = new PriorityQueue<>();
        Map<Integer,Integer> shortestPaths = new HashMap<>();

        heap.add(new Pair(s, 0));
        shortestPaths.put(s, 0);

        while(!heap.isEmpty()) {
            Pair current = heap.remove();
            Integer currentNode = current.key;
            Integer currentWeight = current.value;

            if(visited.contains(currentNode)) {
                continue;
            }

            Map<Integer, Integer> neighbours = graph.get(currentNode);
            for(Integer neighbourNode : neighbours.keySet()) {
                Integer neighbourWeight = neighbours.get(neighbourNode);
                Pair neighbour = new Pair(neighbourNode, neighbourWeight);
                heap.add(neighbour);

                if(!shortestPaths.containsKey(neighbourNode) ||
                        shortestPaths.get(neighbourNode) > shortestPaths.get(currentNode) + neighbourWeight) {
                    shortestPaths.put(neighbourNode, shortestPaths.get(currentNode) + neighbourWeight);
                }
            }

            visited.add(currentNode);
        }

        List<Integer> result = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            if(i == s) {
                continue;
            }
            if(!shortestPaths.containsKey(i)) {
                result.add(-1);
            } else {
                result.add(shortestPaths.get(i));
            }
        }

        return result;
    }

    private void handleNeighbours() {

    }

    private Map<Integer, Map<Integer,Integer>> createGraph(List<List<Integer>> edges) {
        Map<Integer, Map<Integer,Integer>> result = new HashMap<>();

        for(List<Integer> edge : edges) {
            Integer node1 = edge.get(0);
            Integer node2 = edge.get(1);
            Integer weight = edge.get(2);

            if(result.containsKey(node1)) {
                Map<Integer,Integer> edgesFromNode1 = result.get(node1);
                if(!edgesFromNode1.containsKey(node2) || edgesFromNode1.get(node2) > weight) {
                    edgesFromNode1.put(node2, weight);
                }
            } else {
                Map<Integer,Integer> edgesFromNode1 = new HashMap<Integer,Integer>();
                edgesFromNode1.put(node2, weight);
                result.put(node1, edgesFromNode1);
            }

            if(result.containsKey(node2)) {
                Map<Integer,Integer> edgesFromNode2 = result.get(node2);
                if(!edgesFromNode2.containsKey(node1) || edgesFromNode2.get(node1) > weight) {
                    edgesFromNode2.put(node1, weight);
                }
            } else {
                Map<Integer,Integer> edgesFromNode2 = new HashMap<Integer,Integer>();
                edgesFromNode2.put(node1, weight);
                result.put(node2, edgesFromNode2);
            }
        }
        return result;
    }

    private class Pair implements Comparable<Pair> {
        public Integer key;
        public Integer value;

        public Pair(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public int compareTo(Pair other) {
            if(this.value > other.value) {
                return 1;
            } else if(this.value < other.value) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
