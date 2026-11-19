
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

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

        // Add courses with indegree 0 to queue
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int completed = 0;

        // BFS
        while (!q.isEmpty()) {

            int curr = q.poll();

            completed++;

            for (int neighbor : adj.get(curr)) {

                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        // If all courses can be completed
        return completed == numCourses;
    }
}
