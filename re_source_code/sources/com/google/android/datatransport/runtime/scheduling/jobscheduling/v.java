package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import e.e.b.a.i.b0.j.i0;
import e.e.b.a.i.b0.j.j0;
import java.util.concurrent.Executor;
import javax.inject.Provider;

/* JADX INFO: compiled from: Uploader_Factory.java */
/* JADX INFO: loaded from: classes2.dex */
public final class v implements e.e.b.a.i.x.a.b<u> {
    private final Provider<Context> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Provider<com.google.android.datatransport.runtime.backends.e> f11363b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Provider<j0> f11364c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Provider<y> f11365d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Provider<Executor> f11366e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Provider<com.google.android.datatransport.runtime.synchronization.a> f11367f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Provider<e.e.b.a.i.c0.a> f11368g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Provider<e.e.b.a.i.c0.a> f11369h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Provider<i0> f11370i;

    public v(Provider<Context> provider, Provider<com.google.android.datatransport.runtime.backends.e> provider2, Provider<j0> provider3, Provider<y> provider4, Provider<Executor> provider5, Provider<com.google.android.datatransport.runtime.synchronization.a> provider6, Provider<e.e.b.a.i.c0.a> provider7, Provider<e.e.b.a.i.c0.a> provider8, Provider<i0> provider9) {
        this.a = provider;
        this.f11363b = provider2;
        this.f11364c = provider3;
        this.f11365d = provider4;
        this.f11366e = provider5;
        this.f11367f = provider6;
        this.f11368g = provider7;
        this.f11369h = provider8;
        this.f11370i = provider9;
    }

    public static v a(Provider<Context> provider, Provider<com.google.android.datatransport.runtime.backends.e> provider2, Provider<j0> provider3, Provider<y> provider4, Provider<Executor> provider5, Provider<com.google.android.datatransport.runtime.synchronization.a> provider6, Provider<e.e.b.a.i.c0.a> provider7, Provider<e.e.b.a.i.c0.a> provider8, Provider<i0> provider9) {
        return new v(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    public static u c(Context context, com.google.android.datatransport.runtime.backends.e eVar, j0 j0Var, y yVar, Executor executor, com.google.android.datatransport.runtime.synchronization.a aVar, e.e.b.a.i.c0.a aVar2, e.e.b.a.i.c0.a aVar3, i0 i0Var) {
        return new u(context, eVar, j0Var, yVar, executor, aVar, aVar2, aVar3, i0Var);
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public u get() {
        return c(this.a.get(), this.f11363b.get(), this.f11364c.get(), this.f11365d.get(), this.f11366e.get(), this.f11367f.get(), this.f11368g.get(), this.f11369h.get(), this.f11370i.get());
    }
}
