// [1,0],[1,2]
// 1: [0,2]
// create adjancent list and visited array
// 
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i< numCourses; i++){
            adjList.add(new ArrayList<>() );
        }
        for(int[] pre: prerequisites){
            int currCourse = pre[0];
            int preCourse = pre[1];
            adjList.get(currCourse).add(preCourse);
        }
        
        boolean[] visited = new boolean[numCourses]; 

        // dfs visit each course
        for(int i=0; i< numCourses; i++) {
            if (!dfs(i, adjList, visited)) return false; 
        }

        return true;
    }
    
    public boolean dfs(int classNum, List<List<Integer>> adjList, boolean[] v){
        if(v[classNum]){
            return false;
        }
        v[classNum] = true;
        for(int preClass: adjList.get(classNum)){
            if (!dfs(preClass, adjList, v)) return false;
        }
        v[classNum] = false;
        adjList.set(classNum, new ArrayList<>()); // empty means no more pre class to take
        
        return true;
    }
}