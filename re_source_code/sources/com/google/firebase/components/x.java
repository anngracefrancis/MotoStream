package com.google.firebase.components;

/* JADX INFO: compiled from: Lazy.java */
/* JADX INFO: loaded from: classes2.dex */
public class x<T> implements com.google.firebase.s.b<T> {
    private static final Object a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile Object f18917b = a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile com.google.firebase.s.b<T> f18918c;

    public x(com.google.firebase.s.b<T> bVar) {
        this.f18918c = bVar;
    }

    @Override // com.google.firebase.s.b
    public T get() {
        T t = (T) this.f18917b;
        Object obj = a;
        if (t == obj) {
            synchronized (this) {
                t = (T) this.f18917b;
                if (t == obj) {
                    t = this.f18918c.get();
                    this.f18917b = t;
                    this.f18918c = null;
                }
            }
        }
        return t;
    }
}
