class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1,p2)->Integer.compare(
            distanceFromOrigin(p2),distanceFromOrigin(p1)
        ));
        for(int[] point:points){
            pq.offer(point);
            if(pq.size()>k){
                pq.poll();
            }
        }
        int[][] res = new int[k][2];
        for(int i=0;i<k;i++){
            res[i]=pq.poll();
        }
        return res;
    }
    private int distanceFromOrigin(int[] point){
        return point[0]*point[0]+point[1]*point[1];
    }
}
