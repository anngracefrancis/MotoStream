package f.b;

import javax.inject.Provider;

/* JADX INFO: compiled from: DoubleCheck.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a<T> implements Provider<T> {
    private static final Object a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile Provider<T> f21407b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile Object f21408c = a;

    private a(Provider<T> provider) {
        this.f21407b = provider;
    }

    public static <P extends Provider<T>, T> Provider<T> a(P p) {
        b.b(p);
        return p instanceof a ? p : new a(p);
    }

    private static Object b(Object obj, Object obj2) {
        if (!(obj != a) || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    @Override // javax.inject.Provider
    public T get() {
        T t = (T) this.f21408c;
        Object obj = a;
        if (t == obj) {
            synchronized (this) {
                t = (T) this.f21408c;
                if (t == obj) {
                    t = this.f21407b.get();
                    this.f21408c = b(this.f21408c, t);
                    this.f21407b = null;
                }
            }
        }
        return t;
    }
}
