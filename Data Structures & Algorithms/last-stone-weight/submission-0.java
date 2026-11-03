class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->Integer.compare(b,a));
        for(int stone:stones){
            maxHeap.offer(stone);
        }
        while(maxHeap.size()>1){
            int y = maxHeap.poll();
            int x = maxHeap.poll();
            if(x!=y){
                maxHeap.offer(y-x);
            }
        }
        return maxHeap.isEmpty() ? 0:maxHeap.poll();
    }
}

/***


Keep all stones in a max heap
So, this way whenever I take 2 out
They'd be the 2 heavist ones
Then if they are not equal then I'd put a new stone in my heap

*/
