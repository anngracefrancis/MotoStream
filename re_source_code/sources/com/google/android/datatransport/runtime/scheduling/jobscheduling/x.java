package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import e.e.b.a.i.b0.j.j0;
import java.util.concurrent.Executor;
import javax.inject.Provider;

/* JADX INFO: compiled from: WorkInitializer_Factory.java */
/* JADX INFO: loaded from: classes2.dex */
public final class x implements e.e.b.a.i.x.a.b<w> {
    private final Provider<Executor> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Provider<j0> f11374b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Provider<y> f11375c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Provider<com.google.android.datatransport.runtime.synchronization.a> f11376d;

    public x(Provider<Executor> provider, Provider<j0> provider2, Provider<y> provider3, Provider<com.google.android.datatransport.runtime.synchronization.a> provider4) {
        this.a = provider;
        this.f11374b = provider2;
        this.f11375c = provider3;
        this.f11376d = provider4;
    }

    public static x a(Provider<Executor> provider, Provider<j0> provider2, Provider<y> provider3, Provider<com.google.android.datatransport.runtime.synchronization.a> provider4) {
        return new x(provider, provider2, provider3, provider4);
    }

    public static w c(Executor executor, j0 j0Var, y yVar, com.google.android.datatransport.runtime.synchronization.a aVar) {
        return new w(executor, j0Var, yVar, aVar);
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public w get() {
        return c(this.a.get(), this.f11374b.get(), this.f11375c.get(), this.f11376d.get());
    }
}
