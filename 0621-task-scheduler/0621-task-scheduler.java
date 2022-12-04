// maxHeap: store pair (char , count), sort by count
// [(A,3) (B,3)]
// t=0, []
// t=1, [A], [(B,3), (A,2)]
// t=2, [A,B], [(B,2), (A,2)]
// 
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for(char task: tasks){
            count[task-'A']++;
        }
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i< 26; i++){
            if(count[i]>0){
                maxHeap.add(count[i]);
            }
        }
        int time = 0;
        while(!maxHeap.isEmpty() || !q.isEmpty()){
            time++;
            if(!maxHeap.isEmpty()){
                int currFreq = maxHeap.poll();       
                int nextPut = time + n;
                if(currFreq-1 > 0){
                    q.offer(new int[]{currFreq-1, nextPut});    
                }
            }
            if(!q.isEmpty() && q.peek()[1] == time){
                maxHeap.add(q.poll()[0]);
            }    
            
        }
        return time;
    }
}
// t   maxHeap     q       
// 0   [3,3]
// 0   [3]         [(2,3)]
// 1   []          [(2,3), (2,4)] 
//     [2]         [(2,4)] 
// 3   []          [(2,4), (1,5)] 
//     [2]         [(1,5)]
// 4   []          [(1,5), (1,6)]
//     [1]         [(1,6)]
