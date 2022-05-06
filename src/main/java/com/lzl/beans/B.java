package com.lzl.beans;

import org.springframework.context.annotation.Lazy;

public class B {
    private A a;

    @Lazy
    public B(A a) {
        this.a = a;
    }
}
