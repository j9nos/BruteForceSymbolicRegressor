package com.j9nos.brute_force_symbolic_regressor;

import java.util.ArrayList;

public final class Permutator {
    private Permutator() {
    }

    public static <T> void permutate(final int length, final T[] base, final ArrayList<T> current,
                                     final PermutationAction<T> action) {
        if (length == 0) {
            action.perform(current);
            return;
        }

        for (final T input : base) {
            final ArrayList<T> permutation = new ArrayList<>(current);
            permutation.add(input);
            permutate(length - 1, base, permutation, action);
        }
    }

}
