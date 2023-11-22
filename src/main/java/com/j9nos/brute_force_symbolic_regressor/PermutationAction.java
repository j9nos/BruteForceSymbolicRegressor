package com.j9nos.brute_force_symbolic_regressor;

import java.util.ArrayList;


@FunctionalInterface
public interface PermutationAction<T> {
    void perform(ArrayList<T> elements);
}
