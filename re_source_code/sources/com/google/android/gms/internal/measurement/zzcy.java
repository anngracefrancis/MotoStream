package com.google.android.gms.internal.measurement;

import java.io.Serializable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzcy<T> implements Serializable {
    zzcy() {
    }

    public static <T> zzcy<T> a(T t) {
        return new z0(zzcx.a(t));
    }

    public static <T> zzcy<T> d() {
        return y0.f17292f;
    }

    public abstract boolean b();

    public abstract T c();
}
