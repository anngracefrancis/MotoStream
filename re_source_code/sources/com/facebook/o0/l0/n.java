package com.facebook.o0.l0;

import java.util.Arrays;

/* JADX INFO: compiled from: AppEventsConversionsAPITransformer.kt */
/* JADX INFO: loaded from: classes.dex */
public enum n {
    EVENT("event"),
    ACTION_SOURCE("action_source"),
    APP("app"),
    MOBILE_APP_INSTALL("MobileAppInstall"),
    INSTALL_EVENT_TIME("install_timestamp");

    private final String l;

    n(String str) {
        this.l = str;
    }

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static n[] valuesCustom() {
        n[] nVarArrValuesCustom = values();
        return (n[]) Arrays.copyOf(nVarArrValuesCustom, nVarArrValuesCustom.length);
    }

    public final String k() {
        return this.l;
    }
}
