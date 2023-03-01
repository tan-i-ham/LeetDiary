// map
// 2: [[1,1], [3,1]]
// 3: [[4,1]]
// queue
// q = [2]
// q = [1,3]
// q = [4]
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        
        for(int[] time: times){
            int src = time[0];
            int dest = time[1];
            int t = time[2];
            
            adj.putIfAbsent(src, new ArrayList<>());
            adj.get(src).add(new int[]{dest, t});
        }
        for(int key: adj.keySet()){
            Collections.sort(adj.get(key), (a, b) -> Integer.compare(a[1], b[1])); // by time
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.add(k); // start node
        int[] signalReceivedAt = new int[n+1];
        Arrays.fill(signalReceivedAt, Integer.MAX_VALUE);

        signalReceivedAt[k] = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i< size; i++){
                int currNode = q.poll();
                
                if(!adj.containsKey(currNode)){
                    continue;
                }
                for(int[] next: adj.get(currNode)){
                    int d = next[0];
                    int t = next[1];
                    int arrivalTime = signalReceivedAt[currNode] + t;
                    if (signalReceivedAt[d] > arrivalTime) {
                        signalReceivedAt[d] = arrivalTime;
                        q.add(d);
                    }
                }
            }
        }
        int answer = Integer.MIN_VALUE;
        for (int node = 1; node <= n; node++) {
            answer = Math.max(answer, signalReceivedAt[node]);
        }
        
        // Integer.MAX_VALUE signifies atleat one node is unreachable
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}