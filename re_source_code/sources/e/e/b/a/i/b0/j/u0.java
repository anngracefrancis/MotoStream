package e.e.b.a.i.b0.j;

import android.content.Context;
import javax.inject.Provider;

/* JADX INFO: compiled from: SchemaManager_Factory.java */
/* JADX INFO: loaded from: classes2.dex */
public final class u0 implements e.e.b.a.i.x.a.b<t0> {
    private final Provider<Context> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Provider<String> f20806b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Provider<Integer> f20807c;

    public u0(Provider<Context> provider, Provider<String> provider2, Provider<Integer> provider3) {
        this.a = provider;
        this.f20806b = provider2;
        this.f20807c = provider3;
    }

    public static u0 a(Provider<Context> provider, Provider<String> provider2, Provider<Integer> provider3) {
        return new u0(provider, provider2, provider3);
    }

    public static t0 c(Context context, String str, int i2) {
        return new t0(context, str, i2);
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public t0 get() {
        return c(this.a.get(), this.f20806b.get(), this.f20807c.get().intValue());
    }
}
