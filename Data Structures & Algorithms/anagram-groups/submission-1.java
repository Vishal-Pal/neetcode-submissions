class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> freqToAnagramListMap = new HashMap<>();
        for(String str:strs){
            String freqStr = getFreqStr(str);
            List<String> anagramList = freqToAnagramListMap.getOrDefault(freqStr, new ArrayList<>());
            anagramList.add(str);
            freqToAnagramListMap.put(freqStr, anagramList);
        }
        return new ArrayList<>(freqToAnagramListMap.values());
    }

    public String getFreqStr(String s){
        int lenS = s.length();
        int[] freqS = new int[26];
        for(int i=0;i<lenS;i++){
            freqS[s.charAt(i)-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int freq:freqS){
            sb.append(freq);
            sb.append(";");
        }
        return sb.toString();
    }
}


/**

To compare whether 2 strings are anagrams
We could re-use the isValidAnagram approach
Which was to use a 26 length frequency array to store and compare the frequencies of all elements of the two strings

I can have a running list

I'll call this my current list

I will add the very first element to the list

Then I'll iterate further in the array strs, starting from index 1

I'll then compare the current element of strs with an element of the list
any element I can use to compare since, my current list will be such that
only anagrams will be present in that
but
There is a caveat
I am assuming that the anagrams will be adjacent to each other in strs
But there is no such constraint stated in the problem

So, instead of comparing the current string with the elements of the latest list
I can compare the current string with one element of each list
If no matching list is found, then I'd have to create a new list

["act","pots","tops","cat","stop","hat"]
         ^
res = [["act"]]

for each list in res:
 take out the first element, and check whether currStr is an anagram of that element
 If yes, for any element, then I'll add the element to that list and add that list to the result
 Otherwise at the end of the iteration, I'll create a new list and add this to the final result


T.C. - 
1+2+3+...n = O(n^2)
S.C. -
O(1)


Calculate the root - frequency array of every element
Maintain a map of the frequency array to the list of the elements

For each element => Calculate the frequency array
- If the map contains the frequency array, add this element to that list
- Otherwise, add a new entry to the map

- At the end, return the values of the map
*/