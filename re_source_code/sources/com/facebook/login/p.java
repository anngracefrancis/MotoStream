package com.facebook.login;

import java.util.Arrays;

/* JADX INFO: compiled from: CodeChallengeMethod.kt */
/* JADX INFO: loaded from: classes2.dex */
public enum p {
    S256("S256"),
    PLAIN("plain");

    p(String str) {
    }

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static p[] valuesCustom() {
        p[] pVarArrValuesCustom = values();
        return (p[]) Arrays.copyOf(pVarArrValuesCustom, pVarArrValuesCustom.length);
    }
}
