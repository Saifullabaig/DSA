class SeatManager {
    private PriorityQueue<Integer> seatRegis = null;
    public SeatManager(int n) {
        seatRegis = new PriorityQueue<>();
        for(int seat = 1;seat<=n;seat++){
            seatRegis.offer(seat);
        }
    }
    
    public int reserve() {
        return seatRegis.poll();
    }
    
    public void unreserve(int seatNumber) {
        seatRegis.offer(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */
 //https://leetcode.com/problems/seat-reservation-manager/