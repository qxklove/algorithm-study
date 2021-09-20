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
 * 时间复杂度O(n²)，空间复杂度O(1)
 * <p>
 *
 * @author qxk
 * @date 2021/09/19
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; ++i) {
            for (int j = 0; j < len - 1 - i; ++j) {
                if (arr[j] > arr[j + 1]) { // 相邻元素两两对比
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[20];
        int index = 0;
        Random random = new Random();
        do {
            a[index++] = random.nextInt(100);
        } while (index <= 19);
        
        StopWatch stopWatch = new StopWatch();
        System.out.println("排序前：" + Arrays.stream(a).boxed().collect(Collectors.toList()));
        stopWatch.start();
        bubbleSort(a);
        stopWatch.stop();
        System.out.println("排序后：" + Arrays.stream(a).boxed().collect(Collectors.toList()) + "，用时：" + stopWatch.getTotalTimeNanos());
    }
}
