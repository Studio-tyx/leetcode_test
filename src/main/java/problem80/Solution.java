package problem80;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0, j = 1;
        boolean duplicated = false;
        boolean is_written = false;
        while(j < nums.length){
            if(nums[i] == nums[j]){
                if (duplicated){
                    j++;
                }
                else{
                    if (is_written){
                        is_written = false;
                        j++;
                    }
                    else {
                        i++;
                        nums[i] = nums[j];
                        duplicated = true;
                        is_written = true;
                    }
                }
            }
            else {
                i++;
                nums[i] = nums[j];
                duplicated = false;
                is_written = true;
            }
        }
//        System.out.println("res:");
//        for (int k = 0; k <= i; k++){
//            System.out.print(nums[k] + "\t");
//        }
//        System.out.println("");
        return i + 1;
    }
    public int removeDuplicates_official(int[] nums) {
        int n=nums.length;
        int idx = 0;
        int preNum = Integer.MIN_VALUE;
        int cnt=0;
        for(int i=0;i<n;i++){
            System.out.println(i+","+idx+","+preNum+","+cnt);

            cnt++;
            if(nums[i]!=preNum){
                nums[idx++] = nums[i];
                cnt = 1;
            }else{
                if(cnt<=2){
                    nums[idx++] = nums[i];
                }
            }
            preNum = nums[i];
        }
        return idx;
    }

    public int removeDuplicates_count(int[] nums){
        int write_idx = 0;
        int count = 0;
        if (nums.length <= 2){
            return nums.length;
        }
        if (nums[0] == nums[1]) {
            count = 1;
        }
        write_idx ++;
        for (int i = 0; i < nums.length - 1; i++){
            count ++;
            if (nums[i] == nums[i + 1]){
                if (count <= 2){
                    nums[write_idx] = nums[i + 1];
                    write_idx ++;
                }
            }
            else{
                nums[write_idx] = nums[i + 1];
                write_idx ++;
                count = 1;
            }
        }

//        System.out.println("res:");
//        for (int k = 0; k < write_idx; k++){
//            System.out.print(nums[k] + "\t");
//        }
//        System.out.println("");
        return write_idx;
    }
}

