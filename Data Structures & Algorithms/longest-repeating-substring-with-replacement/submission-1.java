class Solution {
    public int characterReplacement(String s, int k) {

        int n = s.length();
        int max=0;
        int[] freq = new int[26];
        int count=0;
        int maxLen=0;

         int end =0;
         int start=0;
          while(end < n ){

             freq[s.charAt(end)-'A']++;
              max=Math.max(max,freq[s.charAt(end)-'A']);
              int currLen=end-start+1;

              if(currLen - max > k){
                freq[s.charAt(start++)-'A']--;
              }
              
              maxLen=Math.max(maxLen,end-start+1);
              end++;
          }
        
        return maxLen;
    }
}
