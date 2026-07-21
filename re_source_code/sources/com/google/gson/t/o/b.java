package com.google.gson.t.o;

import com.google.gson.t.e;
import java.lang.reflect.AccessibleObject;

/* JADX INFO: compiled from: ReflectionAccessor.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class b {
    private static final b a;

    static {
        a = e.c() < 9 ? new a() : new c();
    }

    public static b a() {
        return a;
    }

    public abstract void b(AccessibleObject accessibleObject);
}
