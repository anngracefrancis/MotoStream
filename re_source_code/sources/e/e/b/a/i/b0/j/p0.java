package e.e.b.a.i.b0.j;

/* JADX INFO: compiled from: EventStoreModule_StoreConfigFactory.java */
/* JADX INFO: loaded from: classes2.dex */
public final class p0 implements e.e.b.a.i.x.a.b<k0> {

    /* JADX INFO: compiled from: EventStoreModule_StoreConfigFactory.java */
    private static final class a {
        private static final p0 a = new p0();
    }

    public static p0 a() {
        return a.a;
    }

    public static k0 c() {
        return (k0) e.e.b.a.i.x.a.d.c(l0.d(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public k0 get() {
        return c();
    }
}
