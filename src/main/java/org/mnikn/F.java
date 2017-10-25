package org.mnikn;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @author zhengzhizhao
 *         Created at 2017/10/24
 */
public class F {

    /**
     * for reduce
     *
     * @param <T> value type
     * @param <R> return type
     */
    public interface ReduceProcessInterface<T, R> {

        /**
         * make t2 combine t1
         *
         * @param t1 the current accumulate value
         * @param t2 the next value
         * @return reduce value
         */
        R process(R t1, T t2);
    }

    /**
     * concat two list
     *
     * @param list1 list1
     * @param list2 list2
     * @param <T>   value type
     * @return a concat list
     */
    public static <T> List<T> concat(List<T> list1, List<T> list2) {
        List<T> result = new ArrayList<>();
        result.addAll(list1);
        result.addAll(list2);
        return result;
    }

    /**
     * concat a list with element
     *
     * @param list1 list1
     * @param item  item
     * @param <T>   value type
     * @return a contact list
     */
    public static <T> List<T> concat(List<T> list1, T item) {
        List<T> result = new ArrayList<>();
        result.addAll(list1);
        result.add(item);
        return result;
    }


    /**
     * reduce elements in list to one
     *
     * @param list        list
     * @param processFunc process function
     * @param init        the init value
     * @param <T>         value type
     * @param <R>         return type
     * @return reduce value
     */
    public static <T, R> R reduce(List<T> list, ReduceProcessInterface<T, R> processFunc, R init) {
        R result = init;
        for (T item : list) {
            result = processFunc.process(result, item);
        }
        return result;
    }

    /**
     * process every element
     *
     * @param list        list
     * @param processFunc process function
     * @param <T>         value type
     * @param <R>         return type
     * @return a processed list
     */
    public static <T, R> List<R> map(List<T> list, Function<T, R> processFunc) {
        List<R> result = new ArrayList<>();
        for (T item : list) {
            result.add(processFunc.apply(item));
        }
        return result;
    }

    /**
     * filter list
     *
     * @param list   list
     * @param filter filter function
     * @param <T>    value type
     * @return a filtered list
     */
    public static <T> List<T> filter(List<T> list, Function<T, Boolean> filter) {
        List<T> result = new ArrayList<>();
        for (T item : list) {
            if (filter.apply(item)) result.add(item);
        }
        return result;
    }

    /**
     * range of 0 and high,eg: range(0,4) -> [0,1,2,3]
     *
     * @param high high
     * @return a interval list
     */
    public static List<Integer> range(int high) {
        return range(0, high);
    }

    /**
     * range of low and high,eg: range(0,4) -> [0,1,2,3]
     *
     * @param low  low
     * @param high high
     * @return a interval list
     */
    public static List<Integer> range(int low, int high) {
        List<Integer> result = new ArrayList<>();
        for (int i = low; i < high; ++i) {
            result.add(i);
        }
        return result;
    }

    /**
     * take list partly
     *
     * @param list  list
     * @param count take count
     * @param <T>   value type
     * @return partly list
     */
    public static <T> List<T> take(List<T> list, int count) {
        if (count >= list.size()) return list;
        List<T> result = map(range(1, count + 1),
                (Integer index) -> list.get(index - 1));
        return result;
    }

    /**
     * take list partly
     *
     * @param list  list
     * @param start start index
     * @param count take count
     * @param <T>   value type
     * @return partly list
     */
    public static <T> List<T> take(List<T> list, int start, int count) {
        if (count >= list.size() - start) return list.subList(start, list.size());
        List<T> result = map(range(start, count + 1),
                (Integer index) -> list.get(index));
        return result;
    }
}
