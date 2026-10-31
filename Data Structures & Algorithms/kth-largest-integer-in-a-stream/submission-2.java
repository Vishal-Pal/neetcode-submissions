class KthLargest {
    Queue<Integer> minHeap;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();
        for(int num:nums){
            minHeap.offer(num);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
    }
    
    public int add(int val) {
        minHeap.offer(val);
        if(minHeap.size()>k){
            minHeap.poll();
        }
        return minHeap.peek();
    }
}

/**

Maintain a min heap of size k
So, the lowest element will be actually the k-th largest element

Is that correct?
I need to validate it


k = 3
1->2->3
2->3->3
3->3->5

len-k

[1,2,3,3]

2->3->3
3->3->3
3->3->5
3->5->6
5->6->7


k<=nums.length


*/