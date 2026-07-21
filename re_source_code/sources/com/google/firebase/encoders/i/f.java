package com.google.firebase.encoders.i;

/* JADX INFO: compiled from: Protobuf.java */
/* JADX INFO: loaded from: classes.dex */
public @interface f {

    /* JADX INFO: compiled from: Protobuf.java */
    public enum a {
        DEFAULT,
        SIGNED,
        FIXED
    }

    a intEncoding() default a.DEFAULT;

    int tag();
}
