
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        // Create adjacency list
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Calculate indegree
        int[] indegree = new int[numCourses];

        for (int[] p : prerequisites) {

            int course = p[0];
            int prereq = p[1];

            adj.get(prereq).add(course);

            indegree[course]++;
        }

        // Add courses with indegree 0
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        // Store course ordering
        int[] order = new int[numCourses];
        int index = 0;

        // BFS
        while (!q.isEmpty()) {

            int curr = q.poll();

            order[index] = curr;
            index++;

            for (int neighbor : adj.get(curr)) {

                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        // Check for cycle
        if (index != numCourses) {
            return new int[0];
        }

        return order;
    }
}
