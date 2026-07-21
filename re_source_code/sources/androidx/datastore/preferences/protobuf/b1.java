package androidx.datastore.preferences.protobuf;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: Protobuf.java */
/* JADX INFO: loaded from: classes.dex */
final class b1 {
    private static final b1 a = new b1();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ConcurrentMap<Class<?>, f1<?>> f1268c = new ConcurrentHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g1 f1267b = new i0();

    private b1() {
    }

    public static b1 a() {
        return a;
    }

    public <T> void b(T t, e1 e1Var, p pVar) throws IOException {
        e(t).e(t, e1Var, pVar);
    }

    public f1<?> c(Class<?> cls, f1<?> f1Var) {
        a0.b(cls, "messageType");
        a0.b(f1Var, "schema");
        return this.f1268c.putIfAbsent(cls, f1Var);
    }

    public <T> f1<T> d(Class<T> cls) {
        a0.b(cls, "messageType");
        f1<T> f1Var = (f1) this.f1268c.get(cls);
        if (f1Var != null) {
            return f1Var;
        }
        f1<T> f1VarA = this.f1267b.a(cls);
        f1<T> f1Var2 = (f1<T>) c(cls, f1VarA);
        return f1Var2 != null ? f1Var2 : f1VarA;
    }

    public <T> f1<T> e(T t) {
        return d(t.getClass());
    }
}
