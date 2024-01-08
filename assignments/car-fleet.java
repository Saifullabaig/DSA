class Solution {
    private static class Car{
        public int position;
        public double time;
        public Car(int position, double time){
            this.position = position;
            this.time = time;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        if(position.length < 2){
            return position.length;
        }
        Car[] cars = new Car[position.length];
        for(int i=0;i<position.length;++i){
            double time = (double) (target - position[i]) / (double)speed[i];
            cars[i] = new Car(position[i], time);
        }
        Arrays.sort(cars, new Comparator<Car>(){
            @Override
            public int compare(Car car1, Car car2){
                return car2.position - car1.position;
            }
        });
        
        int numFleets = 1;
        int firstCarInFleet = 0;
        for(int i=1;i<position.length;++i){
            if(cars[i].time > cars[firstCarInFleet].time){
                ++numFleets;
                firstCarInFleet = i;
            }
        }
        return numFleets;
    }
}
//https://leetcode.com/problems/car-fleet/description/