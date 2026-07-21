package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;

/* JADX INFO: loaded from: classes2.dex */
final class q40 implements ValueCallback<String> {
    private final /* synthetic */ p40 a;

    q40(p40 p40Var) {
        this.a = p40Var;
    }

    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(String str) {
        p40 p40Var = this.a;
        p40Var.f13149j.c(p40Var.f13146g, p40Var.f13147h, str, p40Var.f13148i);
    }
}
