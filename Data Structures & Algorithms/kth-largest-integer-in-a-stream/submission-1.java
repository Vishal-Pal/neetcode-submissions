class KthLargest {
    Queue<Integer> pq;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();
        for(int num:nums){
            pq.offer(num);
            if(pq.size()>k){
                pq.poll();
            }
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        if(pq.size()>k){
            pq.poll();
        }
        return pq.peek();
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