class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(n,0,0,"",res);
        return res;
    }
    private void backtrack(int n, int nOpen, int nClose, String curr, List<String> res){
        if(nOpen>n || nClose>n || nClose > nOpen){
            return;
        }
        if(nOpen == n && nClose == n){
            res.add(new String(curr));
            return;
        }
        backtrack(n, nOpen+1, nClose, curr+"(", res);
        backtrack(n, nOpen, nClose+1, curr+")", res);
    }
}



/***


""

0 open/ closed
n = 1
Use 1 pair of paranthesis

String length = 2*n
Then I can say that I have reached a solution
Provided all open brackets are closed properly

(()))(

noOfOpenBracketsUsed, noOfClosedBracketsUsed

When both = n

""
0,0 - 0,1 )
 |     
1,0 - 1,1 - 2,1 ()() ()((
 |     
2,0 - 2,1  (()  - (()) 
 |           |   
            (()(

3,0 - 3,1 - 3,2 - 3,3  ((()))
|      
4,0 -> Invalid case


make sure that noOfOpenBracketsUsed  >= noOfClosedBracketsUsed

noOfOpenBrackets < noOfClosedBracket => invalid case, so return


*/