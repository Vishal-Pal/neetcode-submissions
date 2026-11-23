class Solution {
    public List<List<String>> partition(String s) {
        return partition(s, 0, s.length()-1);
    }

    private List<List<String>> partition(String s, int start, int end){
        List<List<String>> res = new ArrayList<>();
        if(start>end){
            return res;
        }
        if(start == end){
            List<String> curr = new LinkedList<>();
            curr.add(String.valueOf(s.charAt(end)));
            res.add(curr);
            return res;
        }
        for(int ind=start;ind<end;ind++){
            if(!isPalindrome(s,start,ind)){
                continue;                
            }
            List<List<String>> subpartition = partition(s,ind+1,end);
            String substr = s.substring(start,ind+1);
            for(List<String> sub:subpartition){
                List<String> curr = new LinkedList<>(sub);
                curr.addFirst(substr);
                res.add(curr);
            }
        }
        if(isPalindrome(s,start,end)){
            List<String> curr = new LinkedList<>();
            curr.add(s.substring(start,end+1));
            res.add(curr);
        }
        return res;
    }

    private boolean isPalindrome(String s, int start, int end){
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}

/***
Input: s = "aab"

Output: [["a","a","b"],["aa","b"]]


"aab"

["a","b"]

"",
"a",->"ab"->"a","b"
"aa",
"aab"

[start,partition)+[partition,end]


palindrome partition


start = 0
partition = 0
end = len-1

[start,partition] , (partition,end]

[0,0],(0,2]

isPalindrome(start,partition) - Yes
Then I'll process - I'd find the palindrome partition of the substring from [partition+1,end] and add this substring to that
Otherwise I'd move ahead


s="aabcb"


s="abcb"

-> "a","b","c","b"
-> "a","bcb"

*/