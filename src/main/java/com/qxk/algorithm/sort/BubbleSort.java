package com.qxk.algorithm.sort;

import org.springframework.util.StopWatch;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * 冒泡排序
 *
 * <p>
 * 1.比较相邻的元素。如果第一个比第二个大，就交换它们两个；
 * 2.对每一对相邻元素做同样的工作，从开始第一对到结尾最后一对，这样在最后的元素就是最大的元素；
 * 3.重复上述步骤直到排序完成。
 *
 * 时间复杂度平均O(n²)、最坏O(n²)、最好O(n)，空间复杂度O(1)，稳定
 * <p>
 *
 * @author qxk
 * @date 2021/09/19
 */
public class BubbleSort {

    public static void bubbleSort(int[] a) {
        int len = a.length;
        for (int i = 0; i < len - 1; ++i) {
            for (int j = 0; j < len - 1 - i; ++j) {
                //相邻元素两两对比
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int size = 20;
        int[] a = new int[size];
        int index = 0;
        Random random = new Random();
        do {
            a[index++] = random.nextInt(100);
        } while (index < size);
        
        StopWatch stopWatch = new StopWatch();
        System.out.println("排序前：" + Arrays.stream(a).boxed().collect(Collectors.toList()));
        stopWatch.start();
        bubbleSort(a);
        stopWatch.stop();
        System.out.println("排序后：" + Arrays.stream(a).boxed().collect(Collectors.toList()));
        System.out.println("用时：" + stopWatch.getTotalTimeNanos());
    }
}
