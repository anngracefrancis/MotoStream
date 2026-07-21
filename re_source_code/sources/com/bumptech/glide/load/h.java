package com.bumptech.glide.load;

import java.security.MessageDigest;

/* JADX INFO: compiled from: Option.java */
/* JADX INFO: loaded from: classes.dex */
public final class h<T> {
    private static final b<Object> a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final T f9255b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b<T> f9256c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f9257d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile byte[] f9258e;

    /* JADX INFO: compiled from: Option.java */
    class a implements b<Object> {
        a() {
        }

        @Override // com.bumptech.glide.load.h.b
        public void a(byte[] bArr, Object obj, MessageDigest messageDigest) {
        }
    }

    /* JADX INFO: compiled from: Option.java */
    public interface b<T> {
        void a(byte[] bArr, T t, MessageDigest messageDigest);
    }

    private h(String str, T t, b<T> bVar) {
        this.f9257d = com.bumptech.glide.r.j.b(str);
        this.f9255b = t;
        this.f9256c = (b) com.bumptech.glide.r.j.d(bVar);
    }

    public static <T> h<T> a(String str, T t, b<T> bVar) {
        return new h<>(str, t, bVar);
    }

    private static <T> b<T> b() {
        return (b<T>) a;
    }

    private byte[] d() {
        if (this.f9258e == null) {
            this.f9258e = this.f9257d.getBytes(f.a);
        }
        return this.f9258e;
    }

    public static <T> h<T> e(String str) {
        return new h<>(str, null, b());
    }

    public static <T> h<T> f(String str, T t) {
        return new h<>(str, t, b());
    }

    public T c() {
        return this.f9255b;
    }

    public boolean equals(Object obj) {
        if (obj instanceof h) {
            return this.f9257d.equals(((h) obj).f9257d);
        }
        return false;
    }

    public void g(T t, MessageDigest messageDigest) {
        this.f9256c.a(d(), t, messageDigest);
    }

    public int hashCode() {
        return this.f9257d.hashCode();
    }

    public String toString() {
        return "Option{key='" + this.f9257d + "'}";
    }
}
