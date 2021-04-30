package org.gastnet.clientmicro.util;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyCollecUtils {

    public static <E> Set<E> toSet(List<E> l) {
        return new HashSet<E>(l);
    }

    public static <E> List<E> toSet(Set<E> s) {
        return new ArrayList<E>(s);
    }
}