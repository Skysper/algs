package com.skysper.offer;

/**
 *  已知n是正数
 * 	返回大于等于，且最接近n的，2的某次方的值
 * @author skysper
 * @date 2022-02-14 23:07
 */
public class Near2Power_C01 {

    public int tableSizeFor(int number) {

        number--;

        number |= number >>> 1;
        number |= number >>> 2;
        number |= number >>> 4;
        number |= number >>> 8;
        number |= number >>> 16;

        return number < 0 ? 1 : number + 1;

    }
}
