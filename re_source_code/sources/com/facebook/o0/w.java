package com.facebook.o0;

import android.content.Context;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: AppEventCollection.kt */
/* JADX INFO: loaded from: classes.dex */
public final class w {
    private final HashMap<t, i0> a = new HashMap<>();

    private final synchronized i0 e(t tVar) {
        i0 i0Var = this.a.get(tVar);
        if (i0Var == null) {
            com.facebook.a0 a0Var = com.facebook.a0.a;
            Context contextC = com.facebook.a0.c();
            com.facebook.internal.q qVarE = com.facebook.internal.q.a.e(contextC);
            if (qVarE != null) {
                i0Var = new i0(qVarE, a0.a.c(contextC));
            }
        }
        if (i0Var == null) {
            return null;
        }
        this.a.put(tVar, i0Var);
        return i0Var;
    }

    public final synchronized void a(t tVar, v vVar) {
        kotlin.jvm.internal.m.f(tVar, "accessTokenAppIdPair");
        kotlin.jvm.internal.m.f(vVar, "appEvent");
        i0 i0VarE = e(tVar);
        if (i0VarE != null) {
            i0VarE.a(vVar);
        }
    }

    public final synchronized void b(h0 h0Var) {
        if (h0Var == null) {
            return;
        }
        for (Map.Entry<t, List<v>> entry : h0Var.b()) {
            i0 i0VarE = e(entry.getKey());
            if (i0VarE != null) {
                Iterator<v> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    i0VarE.a(it.next());
                }
            }
        }
    }

    public final synchronized i0 c(t tVar) {
        kotlin.jvm.internal.m.f(tVar, "accessTokenAppIdPair");
        return this.a.get(tVar);
    }

    public final synchronized int d() {
        int iC;
        iC = 0;
        Iterator<i0> it = this.a.values().iterator();
        while (it.hasNext()) {
            iC += it.next().c();
        }
        return iC;
    }

    public final synchronized Set<t> f() {
        Set<t> setKeySet;
        setKeySet = this.a.keySet();
        kotlin.jvm.internal.m.e(setKeySet, "stateMap.keys");
        return setKeySet;
    }
}
