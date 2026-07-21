package com.facebook.login;

import java.util.Arrays;

/* JADX INFO: compiled from: DefaultAudience.kt */
/* JADX INFO: loaded from: classes2.dex */
public enum r {
    NONE(null),
    ONLY_ME("only_me"),
    FRIENDS("friends"),
    EVERYONE("everyone");


    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f10029k;

    r(String str) {
        this.f10029k = str;
    }

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static r[] valuesCustom() {
        r[] rVarArrValuesCustom = values();
        return (r[]) Arrays.copyOf(rVarArrValuesCustom, rVarArrValuesCustom.length);
    }

    public final String k() {
        return this.f10029k;
    }
}
