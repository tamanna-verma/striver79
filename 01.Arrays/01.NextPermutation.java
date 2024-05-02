class Solution {
    public void nextPermutation(int[] nums) 
    {
       int index =  -1;
       int n= nums.length;
       for(int i=n-2;i>=0;i--)
       {
        if(nums[i+1]>nums[i])
        {
        index = i;
        break;
        }
       }

       if(index!=-1)
       {
        
        for(int i=nums.length-1;i>=index+1;i--)
        {
         if(nums[i]>nums[index])
         {
        int rep = nums[i];
        int with = nums[index];
        nums[i] = with ;
        nums[index] = rep;
        reverse (nums , index+1 , nums.length - 1 );
        break;
          }
         }
       }

    else reverse(nums , 0 , nums.length -1 );
      
         
      }
      public static void reverse( int nums[] , int si , int ei){

        while(si <= ei ){
            int curr = nums[si];
            int with = nums[ei];
            nums[ei] = curr;
            nums[si] = with;
            si++;
            ei--;
        }
    }

    }
    
