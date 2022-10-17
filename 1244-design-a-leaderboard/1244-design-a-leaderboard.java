// create a map to record playser's score {id: score}
// top(): put the score in min heap
// reset the value of a player
class Leaderboard {
    Map<Integer, Integer> scoreById;
    public Leaderboard() {
        scoreById = new HashMap<>();
    }
    
    public void addScore(int playerId, int score) {
        int ogScore = scoreById.getOrDefault(playerId, 0);
        scoreById.put(playerId, ogScore + score);
    }
    
    public int top(int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); 
        
        for(Integer id: scoreById.keySet()){
            pq.offer(scoreById.get(id));
            if(pq.size()>K){
                pq.poll();
            }
        }
        int ans = 0;
        while(!pq.isEmpty()){
            ans += pq.poll();
        }
        return ans;
    }
    
    public void reset(int playerId) {
        scoreById.put(playerId, 0);
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */
// how many operations / function calls?
// what are the range of playerID and score? -> long or int
// Is the K gurantee smaller and equal thans the number of players?