package com.google.android.gms.internal.measurement;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class l3 {
    private static final l3 a = new l3();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ConcurrentMap<Class<?>, p3<?>> f17213c = new ConcurrentHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final s3 f17212b = new v2();

    private l3() {
    }

    public static l3 a() {
        return a;
    }

    public final <T> p3<T> b(Class<T> cls) {
        zzff.f(cls, "messageType");
        p3<T> p3Var = (p3) this.f17213c.get(cls);
        if (p3Var != null) {
            return p3Var;
        }
        p3<T> p3VarA = this.f17212b.a(cls);
        zzff.f(cls, "messageType");
        zzff.f(p3VarA, "schema");
        p3<T> p3Var2 = (p3) this.f17213c.putIfAbsent(cls, p3VarA);
        return p3Var2 != null ? p3Var2 : p3VarA;
    }

    public final <T> p3<T> c(T t) {
        return b(t.getClass());
    }
}
