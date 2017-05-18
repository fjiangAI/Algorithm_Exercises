package extend;

import java.util.List;

public class Sort {
    public static void sort(List<Action> a, int left, int right) {
        if (left >= right)
            return;
        int center = (left + right) >> 1;
        //左边递归调用
        sort(a, left, center);
        //右边递归调用
        sort(a, center + 1, right);
        //把结果合并
        merge(a, left, center, right);
    }
    public static void merge(List<Action> data, int left, int center, int right) {
    	Action[] tmpArr = new Action[right+1];
        int mid = center + 1;
        int index = left; // index记录临时数组的索引
        int tmp = left;

        // 从两个数组中取出最小的放入中临时数组
        while (left <= center && mid <= right) {
            tmpArr[index++] = (data.get(left).endtime <= data.get(mid).endtime) ? data.get(left++): data.get(mid++);
        }
        // 剩余部分依次放入临时数组
        while (mid <= right) {
            tmpArr[index++] = data.get(mid++);
        }
        while (left <= center) {
            tmpArr[index++] = data.get(left++);
        }
        // 将临时数组中的内容复制回原数组
        for (int i = tmp; i <= right; i++) {
            data.set(i, tmpArr[i]);
        }
    }
}

