package com.tridevmc.habitus.util;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.util.List;

public class ListUtil {
    public static <T> List<T> intersection(List<T> a, List<T> b) {
        List<T> intersection = Lists.newArrayList();

        List<T> shortest = a.size() <= b.size() ? a : b;
        List<T> longest = a.size() <= b.size() ? b : a;

        for(T item : shortest) {
            if(longest.contains(item)) intersection.add(item);
        }

        return ImmutableList.copyOf(intersection);
    }
}
