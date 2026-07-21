package com.google.firebase.components;

import java.util.Set;

/* JADX INFO: compiled from: ComponentContainer.java */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class o {
    public static Object a(p _this, b0 b0Var) {
        com.google.firebase.s.b<T> bVarB = _this.b(b0Var);
        if (bVarB == null) {
            return null;
        }
        return bVarB.get();
    }

    public static Object b(p _this, Class cls) {
        return _this.f(b0.b(cls));
    }

    public static com.google.firebase.s.a c(p _this, Class cls) {
        return _this.h(b0.b(cls));
    }

    public static com.google.firebase.s.b d(p _this, Class cls) {
        return _this.b(b0.b(cls));
    }

    public static Set e(p _this, b0 b0Var) {
        return _this.e(b0Var).get();
    }

    public static Set f(p _this, Class cls) {
        return _this.d(b0.b(cls));
    }
}
