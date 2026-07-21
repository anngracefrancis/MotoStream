package com.facebook.internal;

import java.util.Arrays;

/* JADX INFO: compiled from: FacebookGamingAction.kt */
/* JADX INFO: loaded from: classes2.dex */
public enum e0 {
    ContextChoose("context_choose"),
    JoinTournament("join_tournament");


    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f9769i;

    e0(String str) {
        this.f9769i = str;
    }

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static e0[] valuesCustom() {
        e0[] e0VarArrValuesCustom = values();
        return (e0[]) Arrays.copyOf(e0VarArrValuesCustom, e0VarArrValuesCustom.length);
    }

    public final String k() {
        return this.f9769i;
    }
}
