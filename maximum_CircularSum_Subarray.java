class Solution {
    public int maxSubarraySumCircular(int[] nums){
        int n = nums.length ;
        int maxSum  = Integer.MIN_VALUE ;
        int minSum  = Integer.MAX_VALUE ;
        int totalSum = 0, s1 = 0, s2 = 0 ;
        boolean flag  = false ;


        for(int i=0 ; i<n ; i++){
            totalSum  += nums[i] ;
            
            s1 += nums[i] ;
            if(s1 < 0) s1 = 0;    //  Kadane's Algo [Max sum] 

            if(s1 > 0){
                maxSum  = Math.max(maxSum , s1);    
                flag  = true;    //  Mark as visited  means all elements are not negative in array
            }

            s2 += nums[i] ;
            minSum  = Math.min(minSum , s2);           //  minimum sum of subarray
            if(s2 > 0) s2 = 0 ;

        } 

        int m =  Integer.MIN_VALUE; 
        if(flag ==  false){           //that means not any time s1 comes to be greater to be the 0.
         for(int i : nums)
           m =  Math.max(m ,i);          //  return the maximum of the negative numbers 
        return m ;
        }

        return Math.max(maxSum ,totalSum-minSum) ;  //  maximum sum gives .
    }
}
