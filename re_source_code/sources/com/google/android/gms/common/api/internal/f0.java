package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: loaded from: classes2.dex */
final class f0 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zace f11753f;

    f0(zace zaceVar) {
        this.f11753f = zaceVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f11753f.m.c(new ConnectionResult(4));
    }
}
