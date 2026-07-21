package com.google.android.gms.internal.measurement;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class y0<T> extends zzcy<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final y0<Object> f17292f = new y0<>();

    private y0() {
    }

    @Override // com.google.android.gms.internal.measurement.zzcy
    public final boolean b() {
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzcy
    public final T c() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    public final boolean equals(@NullableDecl Object obj) {
        return obj == this;
    }

    public final int hashCode() {
        return 2040732332;
    }

    public final String toString() {
        return "Optional.absent()";
    }
}
