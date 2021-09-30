package com.qxk.algorithm.sort;

import org.springframework.util.StopWatch;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * 堆排序
 *
 * <p>
 * 利用堆这种数据结构所设计的一种排序算法。堆积是一个近似完全二叉树的结构，并同时满足堆积的性质：即子结点的键值或索引总是小于（或者大于）它的父节点。
 *
 * 1.将初始待排序关键字序列(R1,R2….Rn)构建成大顶堆，此堆为初始的无序区；
 * 2.将堆顶元素R[1]与最后一个元素R[n]交换，此时得到新的无序区(R1,R2,……Rn-1)和新的有序区(Rn),且满足R[1,2…n-1]<=R[n]；
 * 3.由于交换后新的堆顶R[1]可能违反堆的性质，因此需要对当前无序区(R1,R2,……Rn-1)调整为新堆，然后再次将R[1]与无序区最后一个元素交换，得到新的无序区(R1,R2….Rn-2)和新的有序区(Rn-1,Rn)。
 * 4.不断重复此过程直到有序区的元素个数为n-1，则整个排序过程完成。
 *
 * 时间复杂度平均O(n*lgn)、最坏O(n*lgn)、最好O(n*lgn)，空间复杂度O(1)，不稳定
 * <p>
 *
 * @author qxk
 * @date 2021/09/29
 */
public class HeapSort {
    private static void heapify(int[] a, int length, int i) {
        int left = 2 * i + 1, right = 2 * i + 2;
        int largest = i;
        //大顶堆，左右子元素比父元素大就交换位置
        if (left < length && a[left] > a[largest]) {
            largest = left;
        }
        if (right < length && a[right] > a[largest]) {
            largest = right;
        }
        if (largest != i) {
            int temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;
            //交换后还要递归往下建堆
            heapify(a, length, largest);
        }
    }

    public static void heapSort(int[] a) {
        int length = a.length;
        if (length == 0) {
            return;
        }
        //初始化堆
        for (int i = length/2-1; i >= 0; i--) {
            heapify(a, length, i);
        }
        for (int i = length - 1; i >= 0; i--) {
            //交换堆顶和堆尾
            int temp = a[0];a[0]=a[i];a[i]=temp;
            //length减1，length位就是这次取出的堆顶元素
            heapify(a, i, 0);
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
        heapSort(a);
        stopWatch.stop();
        System.out.println("排序后：" + Arrays.stream(a).boxed().collect(Collectors.toList()));
        System.out.println("用时：" + stopWatch.getTotalTimeNanos());
    }
}
