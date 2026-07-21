package com.google.android.gms.internal.measurement;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class c1<T> implements zzcz<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile zzcz<T> f17137f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile boolean f17138g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NullableDecl
    private T f17139h;

    c1(zzcz<T> zzczVar) {
        this.f17137f = (zzcz) zzcx.a(zzczVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzcz
    public final T a() {
        if (!this.f17138g) {
            synchronized (this) {
                if (!this.f17138g) {
                    T tA = this.f17137f.a();
                    this.f17139h = tA;
                    this.f17138g = true;
                    this.f17137f = null;
                    return tA;
                }
            }
        }
        return this.f17139h;
    }

    public final String toString() {
        Object string = this.f17137f;
        if (string == null) {
            String strValueOf = String.valueOf(this.f17139h);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 25);
            sb.append("<supplier that returned ");
            sb.append(strValueOf);
            sb.append(">");
            string = sb.toString();
        }
        String strValueOf2 = String.valueOf(string);
        StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 19);
        sb2.append("Suppliers.memoize(");
        sb2.append(strValueOf2);
        sb2.append(")");
        return sb2.toString();
    }
}
