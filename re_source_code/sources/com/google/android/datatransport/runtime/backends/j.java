package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import javax.inject.Provider;

/* JADX INFO: compiled from: CreationContextFactory_Factory.java */
/* JADX INFO: loaded from: classes2.dex */
public final class j implements e.e.b.a.i.x.a.b<i> {
    private final Provider<Context> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Provider<e.e.b.a.i.c0.a> f11314b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Provider<e.e.b.a.i.c0.a> f11315c;

    public j(Provider<Context> provider, Provider<e.e.b.a.i.c0.a> provider2, Provider<e.e.b.a.i.c0.a> provider3) {
        this.a = provider;
        this.f11314b = provider2;
        this.f11315c = provider3;
    }

    public static j a(Provider<Context> provider, Provider<e.e.b.a.i.c0.a> provider2, Provider<e.e.b.a.i.c0.a> provider3) {
        return new j(provider, provider2, provider3);
    }

    public static i c(Context context, e.e.b.a.i.c0.a aVar, e.e.b.a.i.c0.a aVar2) {
        return new i(context, aVar, aVar2);
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public i get() {
        return c(this.a.get(), this.f11314b.get(), this.f11315c.get());
    }
}
