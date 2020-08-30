package commonSort;

public class QuickSort {

    public static void main(String[] args) {
        for(String curr:args){
            System.out.println(curr);
        }
        int[] arr = new int[]{25,84,21,47,15,27,68,35,20};
        quickSort(arr, 0, arr.length - 1);
//        System.out.println(Arrays.toString(arr));
    }

    //找一个值，将数组分成小于当前和大于当前两部分，一直拆分。
    public static void quickSort(int[] arr, int start, int end) {

        if (start < end) {
            //把数组中的第0个数字做为标准数
//            swap(arr, start, (int) Math.random() * (end - start + 1)+start );
            int stard = arr[start];
            //记录需要排序的下标
            int low = start;
            int high = end;
            //循环找比标准数大的数和比标准数小的数
            while (low < high) {//相等跳出
                //右边的数字比标准数大
                while (low < high && stard <= arr[high]) {
                    high--;
                }
                //使用右边的数字替换左边的数
                arr[low] = arr[high];
                //如果左边的数字比标准数小
                while (low < high && arr[low] <= stard) {
                    low++;
                }
                arr[high] = arr[low];
            }
            //把标准数赋给低所在的位置的元素
            arr[low] = stard;
//            System.out.println(Arrays.toString(arr));
            //low已经被排序完了
            //处理所有的小的数字
            quickSort(arr, start, low - 1);
            //处理所有的大的数字
            quickSort(arr, low + 1, end);
        }
//        System.out.println(Arrays.toString(arr));
    }
}


