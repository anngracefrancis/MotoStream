package com.facebook.o0.l0;

import java.util.Arrays;

/* JADX INFO: compiled from: AppEventsConversionsAPITransformer.kt */
/* JADX INFO: loaded from: classes.dex */
public enum k {
    USER_DATA("user_data"),
    APP_DATA("app_data"),
    CUSTOM_DATA("custom_data"),
    CUSTOM_EVENTS("custom_events");


    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f10222k;

    k(String str) {
        this.f10222k = str;
    }

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static k[] valuesCustom() {
        k[] kVarArrValuesCustom = values();
        return (k[]) Arrays.copyOf(kVarArrValuesCustom, kVarArrValuesCustom.length);
    }

    public final String k() {
        return this.f10222k;
    }
}
