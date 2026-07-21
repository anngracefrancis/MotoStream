package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class w3 implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f18000f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzfu f18001g;

    public w3(zzfu zzfuVar, String str) {
        this.f18001g = zzfuVar;
        Preconditions.k(str);
        this.f18000f = str;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        this.f18001g.h().H().b(this.f18000f, th);
    }
}
