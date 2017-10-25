package org.mnikn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhengzhizhao
 *         Created at 2017/10/24
 */
public class FTest {
    @Test
    public void concat() throws Exception {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        list1.add(1);
        list1.add(2);
        list1.add(3);
        list2.add(2);
        list2.add(3);

        List<Integer> list3 = F.concat(list1, list2);
        Assert.assertEquals(list3.size(), 5);
        Assert.assertEquals(list3.get(0).intValue(), 1);
        Assert.assertEquals(list3.get(1).intValue(), 2);
        Assert.assertEquals(list3.get(2).intValue(), 3);
        Assert.assertEquals(list3.get(3).intValue(), 2);
        Assert.assertEquals(list3.get(4).intValue(), 3);

        List<Integer> list4 = F.concat(list3, 5);
        Assert.assertEquals(list4.get(5).intValue(), 5);
    }

    @Test
    public void reduce() throws Exception {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);

        Integer r1 = F.reduce(list1, (Integer cur, Integer next) -> cur + next, 0);
        Assert.assertEquals(r1.intValue(), 15);

        Integer r2 = F.reduce(list1, (Integer cur, Integer next) -> cur * next, 1);
        Assert.assertEquals(r2.intValue(), 120);

    }

    @Test
    public void map() throws Exception {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        List<Integer> r1 = F.map(list, (Integer cur) -> cur * cur);
        Assert.assertEquals(r1.get(0).intValue(), 1);
        Assert.assertEquals(r1.get(1).intValue(), 4);
        Assert.assertEquals(r1.get(2).intValue(), 9);
        Assert.assertEquals(r1.get(3).intValue(), 16);
        Assert.assertEquals(r1.get(4).intValue(), 25);
    }

    @Test
    public void filter() throws Exception {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(5);
        list.add(5);

        List<Integer> r1 = F.filter(list, (Integer cur) -> cur != 2 && cur != 5);
        Assert.assertEquals(r1.size(), 1);
        Assert.assertEquals(r1.get(0).intValue(), 3);
    }

    @Test
    public void range() throws Exception {
        List<Integer> r1 = F.range(0, 4);
        Assert.assertEquals(r1.size(), 4);
        Assert.assertEquals(r1.get(0).intValue(), 0);
        Assert.assertEquals(r1.get(1).intValue(), 1);
        Assert.assertEquals(r1.get(2).intValue(), 2);
        Assert.assertEquals(r1.get(3).intValue(), 3);

        List<Integer> r2 = F.range(4);
        Assert.assertEquals(r2.size(), 4);
        Assert.assertEquals(r2.get(0).intValue(), 0);
        Assert.assertEquals(r2.get(1).intValue(), 1);
        Assert.assertEquals(r2.get(2).intValue(), 2);
        Assert.assertEquals(r2.get(3).intValue(), 3);
    }

    @Test
    public void take() throws Exception {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(5);

        List<Integer> r1 = F.take(list, 4);
        Assert.assertEquals(r1.size(), 4);
        Assert.assertEquals(r1.get(0).intValue(), 1);
        Assert.assertEquals(r1.get(3).intValue(), 3);

        List<Integer> r2 = F.take(list, 6);
        Assert.assertEquals(r2.size(), 5);

        List<Integer> r3 = F.take(list, 1, 3);
        Assert.assertEquals(r3.size(), 3);
        Assert.assertEquals(r3.get(0).intValue(), 1);
        Assert.assertEquals(r3.get(2).intValue(), 3);

        List<Integer> r4 = F.take(list, 3, 6);
        Assert.assertEquals(r4.size(), 2);
        Assert.assertEquals(r4.get(0).intValue(), 3);
    }

}