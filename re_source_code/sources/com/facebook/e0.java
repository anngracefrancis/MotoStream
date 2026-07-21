package com.facebook;

import java.util.Arrays;

/* JADX INFO: compiled from: HttpMethod.kt */
/* JADX INFO: loaded from: classes.dex */
public enum e0 {
    GET,
    POST,
    DELETE;

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static e0[] valuesCustom() {
        e0[] e0VarArrValuesCustom = values();
        return (e0[]) Arrays.copyOf(e0VarArrValuesCustom, e0VarArrValuesCustom.length);
    }
}
