package com.qxk.algorithm.sort;

import org.springframework.util.StopWatch;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * 归并排序
 *
 * <p>
 * 分治法，将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为2-路归并。
 *
 * 时间复杂度平均O(n*lgn)、最坏O(n*lgn)、最好O(n*lgn)，空间复杂度O(n)，稳定
 * <p>
 *
 * @author qxk
 * @date 2021/09/30
 */
public class MergeSort {
    public static void mergeSort(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left+right)>>1;
        mergeSort(a, left, mid);
        mergeSort(a, mid + 1, right);
        //合并两个有序数组
        merge(a,left,mid,right);
    }

    private static void merge(int[] a, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid+1, k = 0;
        while (i <= mid && j <= right) {
            temp[k++] = a[i] <= a[j] ? a[i++] : a[j++];
        }
        while (i <= mid) {
            temp[k++] = a[i++];
        }
        while (j <= right) {
            temp[k++] = a[j++];
        }
        System.arraycopy(temp, 0, a, left, temp.length);
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
        mergeSort(a, 0, a.length - 1);
        stopWatch.stop();
        System.out.println("排序后：" + Arrays.stream(a).boxed().collect(Collectors.toList()));
        System.out.println("用时：" + stopWatch.getTotalTimeNanos());
    }
}
