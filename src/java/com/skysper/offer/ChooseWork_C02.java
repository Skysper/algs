package com.skysper.offer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

/**
 * 给定hard表示难度，money表示对应收入
 * 求ability对应的工作选择
 * @author skysper
 * @date 2022-02-14 23:14
 */
public class ChooseWork_C02 {

    public static class Job {
        int money;
        int hard;

        public Job(int m, int h) {
            this.money = m;
            this.hard = h;
        }
    }

    public static class JobComparator implements Comparator<Job> {

        @Override
        public int compare(Job o1, Job o2) {
            int result = Integer.compare(o1.hard, o2.hard);
            if(result == 0) {
                return Integer.compare(o2.money, o1.money);
            }
            return result;
        }
    }


    public int[] getMoneys(Job[] jobs, int[] ability) {
        Arrays.sort(jobs, new JobComparator());
        //工作能力，报酬
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(jobs[0].hard, jobs[0].money);
        Job pre = jobs[0];
        for(int i = 1; i<jobs.length;i++) {
            if (jobs[i].hard != pre.hard && jobs[i].money > pre.money) {
                pre = jobs[i];
                map.put(pre.hard, pre.money);
            }
        }

        int[] result = new int[ability.length];

        for(int i =0; i < ability.length;i++) {
            Integer value = map.floorKey(ability[i]);
            if(value == null) {
                result[i] = 0;
            } else {
                result[i] = map.get(value);
            }
        }

        return result;
    }

}
