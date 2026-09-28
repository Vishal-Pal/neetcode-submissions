class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int len = position.length;
        int[][] posSpeed = new int[len][2];
        for(int i=0;i<len;i++){
            posSpeed[i][0]=position[i];
            posSpeed[i][1]=speed[i];
        }
        Arrays.sort(posSpeed, (a,b)->Integer.compare(b[0], a[0]));
        double prevTime = 0;
        int fleetSize = 0;
        for(int i=0;i<len;i++){
            int distance = target-posSpeed[i][0];
            int currSpeed = posSpeed[i][1];
            double time = (double)distance/currSpeed;
            if(time>prevTime){
                prevTime = time;
                fleetSize++;
            }
        }
        return fleetSize;
    }
}
