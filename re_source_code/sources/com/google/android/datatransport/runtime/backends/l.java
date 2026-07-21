package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import javax.inject.Provider;

/* JADX INFO: compiled from: MetadataBackendRegistry_Factory.java */
/* JADX INFO: loaded from: classes2.dex */
public final class l implements e.e.b.a.i.x.a.b<k> {
    private final Provider<Context> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Provider<i> f11319b;

    public l(Provider<Context> provider, Provider<i> provider2) {
        this.a = provider;
        this.f11319b = provider2;
    }

    public static l a(Provider<Context> provider, Provider<i> provider2) {
        return new l(provider, provider2);
    }

    public static k c(Context context, Object obj) {
        return new k(context, (i) obj);
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public k get() {
        return c(this.a.get(), this.f11319b.get());
    }
}
