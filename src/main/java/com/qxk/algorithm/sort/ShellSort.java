package com.qxk.algorithm.sort;

import org.springframework.util.StopWatch;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * 希尔排序
 *
 * <p>
 * 简单插入排序的改进版，它与插入排序的不同之处在于，它会优先比较距离较远的元素。希尔排序又叫缩小增量排序。
 *
 * 1.选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
 * 2.按增量序列个数k，对序列进行k 趟排序；
 * 3.每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
 *
 * 时间复杂度平均O(n的1.3次方)、最坏O(n²)、最好O(n)，空间复杂度O(1)，不稳定
 * <p>
 *
 * @author qxk
 * @date 2021/09/21
 */
public class ShellSort {

    public static void shellSort(int[] a) {
        int len = a.length;
        int current, preIndex;
        //gap表示增量
        for (int gap = len / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < len; i++) {
                current = a[i];
                preIndex = i - gap;
                while (preIndex >= 0 && a[preIndex] > current) {
                    a[preIndex + gap] = a[preIndex];
                    preIndex -= gap;
                }
                a[preIndex + gap] = current;
            }
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
        shellSort(a);
        stopWatch.stop();
        System.out.println("排序后：" + Arrays.stream(a).boxed().collect(Collectors.toList()));
        System.out.println("用时：" + stopWatch.getTotalTimeNanos());
    }
}
