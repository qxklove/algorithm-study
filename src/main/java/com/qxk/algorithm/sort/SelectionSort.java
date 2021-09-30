package com.qxk.algorithm.sort;

import org.springframework.util.StopWatch;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * 选择排序
 *
 * <p>
 * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
 *
 * 1.初始状态：无序区为R[1..n]，有序区为空；
 * 2.第i趟排序(i=1,2,3…n-1)开始时，当前有序区和无序区分别为R[1..i-1]和R(i..n）。该趟排序从当前无序区中-选出关键字最小的记录 R[k]，将它与无序区的第1个记录R交换，使R[1..i]和R[i+1..n)分别变为记录个数增加1个的新有序区和记录个数减少1个的新无序区；
 * 3.n-1趟结束，数组有序化了。
 *
 * 时间复杂度平均、最坏、最好都是O(n²)，空间复杂度O(1)，不稳定
 * <p>
 *
 * @author qxk
 * @date 2021/09/20
 */
public class SelectionSort {

    public static void selectionSort(int[] a) {
        int len = a.length;
        int minIndex, tmp;
        for (int i = 0; i < len; i++) {
            minIndex = i;
            for (int j = i + 1; j < len; j++) {
                //寻找最小的数，保存其下标
                if (a[minIndex] > a[j]) {
                    minIndex = j;
                }
            }
            tmp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = tmp;
        }
    }

    public static void main(String[] args) {
        int size = 50;
        int[] a = new int[size];
        int index = 0;
        Random random = new Random();
        do {
            a[index++] = random.nextInt(100);
        } while (index < size);

        StopWatch stopWatch = new StopWatch();
        System.out.println("排序前：" + Arrays.stream(a).boxed().collect(Collectors.toList()));
        stopWatch.start();
        selectionSort(a);
        stopWatch.stop();
        System.out.println("排序后：" + Arrays.stream(a).boxed().collect(Collectors.toList()));
        System.out.println("用时：" + stopWatch.getTotalTimeNanos());
    }
}
