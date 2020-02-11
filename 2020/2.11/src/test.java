public class test {
    public static void rotate(int[] nums, int k) {
        int[] temp = new int[nums.length*2];
        for(int i=0;i<temp.length;i++){
            temp[i] = nums[i%nums.length];
        }
        int index = nums.length-k%nums.length;
        int j = 0;
        for(int i=index;i<nums.length+index;i++){
            nums[j++] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] num = {1,2,3,4,5,6,7};
        rotate(num,3);
    }
}
