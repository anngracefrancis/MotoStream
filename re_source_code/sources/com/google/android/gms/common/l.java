package com.google.android.gms.common;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
final class l extends m {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Callable f12084f;

    /* synthetic */ l(Callable callable, zzu zzuVar) {
        super();
        this.f12084f = callable;
    }

    @Override // com.google.android.gms.common.m
    final String a() {
        try {
            return (String) this.f12084f.call();
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }
}
