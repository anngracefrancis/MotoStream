package com.airbnb.lottie;

import java.util.Arrays;

/* JADX INFO: compiled from: LottieResult.java */
/* JADX INFO: loaded from: classes.dex */
public final class k<V> {
    private final V a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Throwable f8542b;

    public k(V v) {
        this.a = v;
        this.f8542b = null;
    }

    public Throwable a() {
        return this.f8542b;
    }

    public V b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        if (b() != null && b().equals(kVar.b())) {
            return true;
        }
        if (a() == null || kVar.a() == null) {
            return false;
        }
        return a().toString().equals(a().toString());
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{b(), a()});
    }

    public k(Throwable th) {
        this.f8542b = th;
        this.a = null;
    }
}
