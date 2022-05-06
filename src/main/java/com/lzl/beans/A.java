package com.lzl.beans;

import org.springframework.context.annotation.Lazy;

public class A {
    private B b;

    @Lazy
    public A(B b) {
        this.b = b;
    }
}
