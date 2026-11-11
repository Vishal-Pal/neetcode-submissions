class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freqMap = new HashMap<>();
        Map<Character, Integer> cycleMap = new HashMap<>();
        for(char ch:tasks){
            freqMap.put(ch, freqMap.getOrDefault(ch,0)+1);
            cycleMap.put(ch, 0);
        }
        Queue<Character> pq = new PriorityQueue<>(
            (ch1, ch2) ->
            Integer.compare(freqMap.get(ch2), freqMap.get(ch1))
        );
        Queue<Character> cooldownQ = new ArrayDeque<>();
        for(char ch:freqMap.keySet()){
            pq.offer(ch);
        }
        int cycle = 0;
        char ch = 'A';
        while(!pq.isEmpty() || !cooldownQ.isEmpty()){
            cycle++;
            if(!cooldownQ.isEmpty() && (pq.isEmpty() || cycleMap.get(cooldownQ.peek())<=cycle)){
                pq.offer(cooldownQ.poll());
            }
            ch = pq.poll();
            int charCycle = cycleMap.get(ch);
            if(charCycle>cycle){
                cycle = charCycle;
            }
            int freq = freqMap.get(ch)-1;
            if(freq != 0){
                cycleMap.put(ch, cycle+n+1);
                freqMap.put(ch, freq);
                cooldownQ.offer(ch);
            }
        }
        return cycle;
    }
}


/***

n = 0
tasks.length

Most frequent element and process it first
Why?

Because we'd have to keep a gap between it the most


Input: tasks = ["A","A","A","B","C"], n = 3
B->C->A->Idle->Idle->Idle->A->Idle->Idle->Idle->A


A->

(A,1)
(A,2), (B,2) , (C,1)
n = 2
1+3=4
2>=4
No



I can check for a task
If I can process
I'd process it
If not


I can check every task in heap
For every task, I can check, whether it can be processed
At the end
If no task is processed
Then the CPU cycle shall be idle
Another map -> Cooldown map
After how many cycles can I use this element
But the problem  is I'd have to keep updating the map in this case

Last cycle number when this element was processed
And if the current cycle number>=last cycle number+n

A,1
4

A,A,A,B,B,C


(A,3)(B,2)(C,1)
(A,(3,0)), (B,(2,0)) , (C,(1,0))

2 scenarios - The current task is not processed
In that case, complete the task
Otherwise
There are 2 scenarios
If the frequency is equal, then I'd keep the task which can be completed first
on the top of my heap

(A,(3,0)), (B,(2,0)) , (C,(1,0))

currCycle = 1
can I complete A?
Yes, I can because it wasn't completed earlier
nextCycle for A = 1+n = 1+3 = 4
I'd reinsert in my heap only if the remaining frequency of A > 0
freq = 2
nextCycle = 4

B -> 2
Keep B at top or A?
Check nextCycle-> Keep the element with lower next cycle at top

I'd also check one thing

That if the next cycle of heap top is greater than my current cycle
Then I'd update my current cycle to that cycle number
Why?
This would help me skip the idle cycle

n=1, A is completed
(B,(2,0)),(C,(1,0),(A,(2,5)))
n=2, B is completed
2+3+1=5
((C,1,0),(A,2,5),(B,1,6))
n=3, C is completed
((A,2,5),(B,1,6))
n=4,  but A can be processed at 5, so update n = 5, process A
((B,1,6),(A,1,9))
n=6, B is completed
((A,1,9))
n = 7, but A can be completed at 9
So, we update n = 9, process A, and then add its next cycle but A is completed completely


(B,(2,0)),(C,(1,0),(A,(2,4)))

No of unique tasks is x
So, there are 2 scenarios

x<=n
x>n


*/