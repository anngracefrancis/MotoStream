package com.facebook.o0.l0;

import java.util.Arrays;

/* JADX INFO: compiled from: AppEventsCAPIManager.kt */
/* JADX INFO: loaded from: classes.dex */
public enum o {
    URL("endpoint"),
    ENABLED("is_enabled"),
    DATASETID("dataset_id"),
    ACCESSKEY("access_key");


    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f10246k;

    o(String str) {
        this.f10246k = str;
    }

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static o[] valuesCustom() {
        o[] oVarArrValuesCustom = values();
        return (o[]) Arrays.copyOf(oVarArrValuesCustom, oVarArrValuesCustom.length);
    }

    public final String k() {
        return this.f10246k;
    }
}
