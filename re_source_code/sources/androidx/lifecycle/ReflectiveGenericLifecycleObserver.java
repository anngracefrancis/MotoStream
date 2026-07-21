package androidx.lifecycle;

/* JADX INFO: loaded from: classes.dex */
class ReflectiveGenericLifecycleObserver implements i {
    private final Object a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b.a f1741b;

    ReflectiveGenericLifecycleObserver(Object obj) {
        this.a = obj;
        this.f1741b = b.a.c(obj.getClass());
    }

    @Override // androidx.lifecycle.i
    public void a(k kVar, g.b bVar) {
        this.f1741b.a(kVar, bVar, this.a);
    }
}
