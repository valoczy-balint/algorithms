package challenges.unionFind.numberOfProvinces;

//https://leetcode.com/problems/number-of-provinces/
public class NumberOfProvinces {
    int[] parents;
    int[] ranks;

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int numberOfProvinces = n;

        setup(n);

        for(int row = 1; row < n; row++) {
            for(int col = 0; col < row; col++) {
                if(isConnected[row][col] == 1) {
                    int result = union(row, col);
                    numberOfProvinces -= result;
                }
            }
        }

        return numberOfProvinces;
    }


    private int find(int city) {
        int current = city;
        while(current != parents[current]) {
            current = parents[current];
            parents[current] = parents[parents[current]];
        }
        return current;
    }

    private int union(int city1, int city2) {
        int parent1 = find(city1);
        int parent2 = find(city2);

        if(parent1 == parent2) {
            return 0;
        }

        if(ranks[parent2] > ranks[parent1]) {
            parents[parent1] = parent2;
            ranks[parent2] += ranks[parent1];
        } else {
            parents[parent2] = parent1;
            ranks[parent1] += ranks[parent2];
        }

        return 1;
    }

    private void setup(int n) {
        parents = new int[n];
        ranks = new int[n];

        for(int i = 0; i < n; i++) {
            parents[i] = i;
            ranks[i] = 1;
        }
    }
}
