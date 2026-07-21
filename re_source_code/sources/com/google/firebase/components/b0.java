package com.google.firebase.components;

import java.lang.annotation.Annotation;

/* JADX INFO: compiled from: Qualified.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b0<T> {
    private final Class<? extends Annotation> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Class<T> f18869b;

    /* JADX INFO: compiled from: Qualified.java */
    private @interface a {
    }

    public b0(Class<? extends Annotation> cls, Class<T> cls2) {
        this.a = cls;
        this.f18869b = cls2;
    }

    public static <T> b0<T> a(Class<? extends Annotation> cls, Class<T> cls2) {
        return new b0<>(cls, cls2);
    }

    public static <T> b0<T> b(Class<T> cls) {
        return new b0<>(a.class, cls);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b0.class != obj.getClass()) {
            return false;
        }
        b0 b0Var = (b0) obj;
        if (this.f18869b.equals(b0Var.f18869b)) {
            return this.a.equals(b0Var.a);
        }
        return false;
    }

    public int hashCode() {
        return (this.f18869b.hashCode() * 31) + this.a.hashCode();
    }

    public String toString() {
        if (this.a == a.class) {
            return this.f18869b.getName();
        }
        return "@" + this.a.getName() + " " + this.f18869b.getName();
    }
}
