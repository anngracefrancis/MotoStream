package e.e.b.a.i.x.a;

import javax.inject.Provider;

/* JADX INFO: compiled from: DoubleCheck.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a<T> implements Provider<T> {
    private static final Object a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile Provider<T> f20855b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile Object f20856c = a;

    private a(Provider<T> provider) {
        this.f20855b = provider;
    }

    public static <P extends Provider<T>, T> Provider<T> a(P p) {
        d.b(p);
        return p instanceof a ? p : new a(p);
    }

    public static Object b(Object obj, Object obj2) {
        if (!(obj != a) || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    @Override // javax.inject.Provider
    public T get() {
        T t = (T) this.f20856c;
        Object obj = a;
        if (t == obj) {
            synchronized (this) {
                t = (T) this.f20856c;
                if (t == obj) {
                    t = this.f20855b.get();
                    this.f20856c = b(this.f20856c, t);
                    this.f20855b = null;
                }
            }
        }
        return t;
    }
}
