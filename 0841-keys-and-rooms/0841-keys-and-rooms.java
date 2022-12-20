// dfs
// create an array to prevent repeated visits
// backtrack(rooms, roomIdx)
// after visit all rooms that we can visit
// loop the array to check if we visit all the room
class Solution {
    Set<Integer> v;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        v = new HashSet<>();
        helper(rooms, 0);
        return v.size() == rooms.size();
    }
    
    public void helper(List<List<Integer>> rooms, int roomIdx){
        if(roomIdx >= rooms.size()){
            return;
        }
        if(v.contains(roomIdx)){
            return;
        }
        v.add(roomIdx);
        for(Integer room: rooms.get(roomIdx)){
            helper(rooms, room);
        }
        
    }
}

// TC: O(N+E)
// SC: O(N)