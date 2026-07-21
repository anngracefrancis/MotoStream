package com.squareup.moshi;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: Json.java */
/* JADX INFO: loaded from: classes.dex */
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface e {
    boolean ignore() default false;

    String name() default "\u0000";
}
