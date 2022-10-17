class LUPrefix {
    int[] videos;
    int currIdx;
    public LUPrefix(int n) {
        videos = new int[n+1];
        currIdx = 1;
    }
    
    public void upload(int video) {
        videos[video] = 1;
        while(currIdx<videos.length && videos[currIdx]!=0){
            currIdx++;
        }
    }
    
    public int longest() {
        return currIdx-1;
    }
}

/**
 * Your LUPrefix object will be instantiated and called as such:
 * LUPrefix obj = new LUPrefix(n);
 * obj.upload(video);
 * int param_2 = obj.longest();
 */