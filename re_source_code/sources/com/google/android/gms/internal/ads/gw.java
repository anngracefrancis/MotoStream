package com.google.android.gms.internal.ads;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes2.dex */
final class gw {
    private static final gw a = new gw();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ConcurrentMap<Class<?>, lw<?>> f12662c = new ConcurrentHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final mw f12661b = new pv();

    private gw() {
    }

    public static gw b() {
        return a;
    }

    public final <T> lw<T> a(T t) {
        return c(t.getClass());
    }

    public final <T> lw<T> c(Class<T> cls) {
        zzdod.d(cls, "messageType");
        lw<T> lwVar = (lw) this.f12662c.get(cls);
        if (lwVar != null) {
            return lwVar;
        }
        lw<T> lwVarA = this.f12661b.a(cls);
        zzdod.d(cls, "messageType");
        zzdod.d(lwVarA, "schema");
        lw<T> lwVar2 = (lw) this.f12662c.putIfAbsent(cls, lwVarA);
        return lwVar2 != null ? lwVar2 : lwVarA;
    }
}
