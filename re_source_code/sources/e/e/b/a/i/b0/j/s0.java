package e.e.b.a.i.b0.j;

import javax.inject.Provider;

/* JADX INFO: compiled from: SQLiteEventStore_Factory.java */
/* JADX INFO: loaded from: classes2.dex */
public final class s0 implements e.e.b.a.i.x.a.b<r0> {
    private final Provider<e.e.b.a.i.c0.a> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Provider<e.e.b.a.i.c0.a> f20794b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Provider<k0> f20795c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Provider<t0> f20796d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Provider<String> f20797e;

    public s0(Provider<e.e.b.a.i.c0.a> provider, Provider<e.e.b.a.i.c0.a> provider2, Provider<k0> provider3, Provider<t0> provider4, Provider<String> provider5) {
        this.a = provider;
        this.f20794b = provider2;
        this.f20795c = provider3;
        this.f20796d = provider4;
        this.f20797e = provider5;
    }

    public static s0 a(Provider<e.e.b.a.i.c0.a> provider, Provider<e.e.b.a.i.c0.a> provider2, Provider<k0> provider3, Provider<t0> provider4, Provider<String> provider5) {
        return new s0(provider, provider2, provider3, provider4, provider5);
    }

    public static r0 c(e.e.b.a.i.c0.a aVar, e.e.b.a.i.c0.a aVar2, Object obj, Object obj2, Provider<String> provider) {
        return new r0(aVar, aVar2, (k0) obj, (t0) obj2, provider);
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public r0 get() {
        return c(this.a.get(), this.f20794b.get(), this.f20795c.get(), this.f20796d.get(), this.f20797e);
    }
}
