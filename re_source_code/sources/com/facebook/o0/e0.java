package com.facebook.o0;

import java.util.Arrays;

/* JADX INFO: compiled from: FlushResult.kt */
/* JADX INFO: loaded from: classes.dex */
public enum e0 {
    SUCCESS,
    SERVER_ERROR,
    NO_CONNECTIVITY,
    UNKNOWN_ERROR;

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static e0[] valuesCustom() {
        e0[] e0VarArrValuesCustom = values();
        return (e0[]) Arrays.copyOf(e0VarArrValuesCustom, e0VarArrValuesCustom.length);
    }
}
