class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> map = new HashSet<>();
        Set<Integer> map2 = new HashSet<>();
        for(int i:nums2){
            map2.add(i);
        }
        for(int i:nums1){
            if(map2.contains(i)){
                map.add(i);
            }
        }
        int arr[] = new int[map.size()];
        int j=0;
        for(int i: map){
            arr[j++]=i;
        }
        return arr;
    }
}