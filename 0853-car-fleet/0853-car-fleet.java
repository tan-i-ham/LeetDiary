class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int N = position.length;
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(b[0], a[0])
        );// sort by position
        for(int i=0; i< N; i++){
            maxHeap.add(new int[]{position[i], speed[i]});
        }
        Stack<int[]> stack = new Stack();
        while(!maxHeap.isEmpty()){
            int[] curr = maxHeap.poll();
            if(stack.isEmpty()){
                stack.add(curr);
            }else{
                int[] prev = stack.peek();
                float t1 = (target - prev[0]) / (float)prev[1];
                // System.out.println(t1);
                float t2 = (target - curr[0]) / (float)curr[1];
                // System.out.println(t2);
                if(t1 >= t2){
                    // two cars become a fleet
                }else{
                    stack.add(curr);
                }
            }
        }
        return stack.size();
    }
}