package com.facebook.o0;

import java.util.Arrays;

/* JADX INFO: compiled from: FlushReason.kt */
/* JADX INFO: loaded from: classes.dex */
public enum d0 {
    EXPLICIT,
    TIMER,
    SESSION_CHANGE,
    PERSISTED_EVENTS,
    EVENT_THRESHOLD,
    EAGER_FLUSHING_EVENT;

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static d0[] valuesCustom() {
        d0[] d0VarArrValuesCustom = values();
        return (d0[]) Arrays.copyOf(d0VarArrValuesCustom, d0VarArrValuesCustom.length);
    }
}
