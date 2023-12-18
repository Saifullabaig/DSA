class MyCalendar {
    List<int[]> booking;
    public MyCalendar() {
        booking = new ArrayList<int[]>();
    }
    
    public boolean book(int start, int end) {
        for(int[] schedule: booking){
            if(schedule[0] < end && start < schedule[1]){
                return false;
            }
        }
        booking.add(new int[]{start, end});
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
//https://leetcode.com/problems/my-calendar-i/