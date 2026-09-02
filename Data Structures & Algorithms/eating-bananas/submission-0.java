class Solution { 
    public int minEatingSpeed(int[] piles, int h) { 
        int low = 1; 
        int high = 0; 
 
        for (int i = 0; i < piles.length; i++) { 
            if (piles[i] > high) { 
                high = piles[i]; 
            } 
        } 
 
        int ans = 0; 
 
        while (low <= high) { 
            int mid = low + (high - low) / 2; 
 
            int totalHours = func(piles, mid); 
 
            if (totalHours <= h) { 
                ans = mid; 
                high = mid - 1; 
            } else { 
                low = mid + 1; 
            } 
        } 
 
        return ans; 
    } 

    public int func(int[] piles, int k) {
        int totalHours = 0;

        for (int i = 0; i < piles.length; i++) {
            totalHours += (piles[i] + k - 1) / k;
        }

        return totalHours;
    }
}