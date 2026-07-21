package h.a.x;

/* JADX INFO: compiled from: Disposables.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d {
    public static c a() {
        return h.a.z.a.d.INSTANCE;
    }

    public static c b() {
        return d(h.a.z.b.a.f21452b);
    }

    public static c c(h.a.y.a aVar) {
        h.a.z.b.b.c(aVar, "run is null");
        return new a(aVar);
    }

    public static c d(Runnable runnable) {
        h.a.z.b.b.c(runnable, "run is null");
        return new f(runnable);
    }
}
