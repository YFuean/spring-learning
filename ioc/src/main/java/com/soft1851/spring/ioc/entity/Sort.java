package com.soft1851.spring.ioc.entity;

/**
 * @ClassName Sort
 * @Description TODO
 * @Author yue_fan
 * @Date 2020/3/10
 **/
public class Sort {
    public void sort(){
        int[]  arrs = {52,23,34,34,65};
        System.out.print("数组为:");
        for (int a:arrs) {
            System.out.print(a+" ");
        }
        System.out.println();

        for (int i = 0; i < arrs.length-1 ; i++) {
            for (int j = 0; j < arrs.length - i - 1; j++) {
                if (arrs[j] > arrs[j + 1]) {
                    // 下面的三行代码用于交换两个元素
                    int temp = arrs[j];
                    arrs[j] = arrs[j + 1];
                    arrs[j + 1] = temp;
                }
            }
            // 循环遍历数组的元素
            System.out.print("第" + (i + 1) + "轮排序后：");
            for (int a:arrs) {
                System.out.print(a+" ");
            }
            System.out.println();
        }

    }
}
