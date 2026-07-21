package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes2.dex */
final class r<T> implements Callable<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzacj f13246f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzacr f13247g;

    r(zzacr zzacrVar, zzacj zzacjVar) {
        this.f13247g = zzacrVar;
        this.f13246f = zzacjVar;
    }

    @Override // java.util.concurrent.Callable
    public final T call() {
        return (T) this.f13246f.h(this.f13247g.f13796j);
    }
}
