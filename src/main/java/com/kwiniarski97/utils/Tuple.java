package com.kwiniarski97.utils;

import lombok.Getter;
import lombok.Setter;

public class Tuple<X, Y> {
    @Getter
    @Setter
    private final X x;
    @Getter
    @Setter
    private final Y y;

    public Tuple(X x, Y y) {
        this.x = x;
        this.y = y;
    }
}
