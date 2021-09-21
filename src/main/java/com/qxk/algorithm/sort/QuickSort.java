package com.qxk.algorithm.sort;

import org.springframework.util.StopWatch;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * 快速排序
 *
 * <p>
 * 通过一趟排序将待排记录分隔成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小，则可分别对这两部分记录继续进行排序，以达到整个序列有序。
 *
 * 1.从数列中挑出一个元素，称为 “基准”（pivot）；
 * 2.重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
 * 3.递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
 *
 * 时间复杂度平均O(n*lgn)、最坏O(n²)、最好O(n*lgn)，空间复杂度O(n*lgn)，不稳定
 * <p>
 *
 * @author qxk
 * @date 2021/09/21
 */
public class QuickSort {
    public static void quickSort(int[] a, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int pivot = partition(a, begin, end);
        quickSort(a, begin, pivot - 1);
        quickSort(a, pivot + 1, end);
    }

    public static int partition(int[] a, int begin, int end) {
        //取第一个元素为标杆
        int pivot = begin;
        //最后一个小于a[pivot]的元素下标的后一位
        int counter = begin + 1;
        int tmp;
        for (int i = begin + 1; i <= end; i++) {
            if (a[i] < a[pivot]) {
                //如果比标杆元素小，则交换当前元素和最后一个小于标杆元素的元素的后一位
                tmp = a[i];a[i] = a[counter];a[counter] = tmp;
                counter++;
            }
        }
        //最后交换一下标杆元素和最后一个小于标杆元素的元素
        tmp = a[pivot];a[pivot] = a[counter - 1];a[counter - 1] = tmp;
        return counter - 1;
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
        quickSort(a, 0, a.length - 1);
        stopWatch.stop();
        System.out.println("排序后：" + Arrays.stream(a).boxed().collect(Collectors.toList()));
        System.out.println("用时：" + stopWatch.getTotalTimeNanos());
    }
}
