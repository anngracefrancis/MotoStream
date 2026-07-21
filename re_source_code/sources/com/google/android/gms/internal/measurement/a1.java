package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class a1<T> implements zzcz<T>, Serializable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzcz<T> f17124f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile transient boolean f17125g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NullableDecl
    private transient T f17126h;

    a1(zzcz<T> zzczVar) {
        this.f17124f = (zzcz) zzcx.a(zzczVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzcz
    public final T a() {
        if (!this.f17125g) {
            synchronized (this) {
                if (!this.f17125g) {
                    T tA = this.f17124f.a();
                    this.f17126h = tA;
                    this.f17125g = true;
                    return tA;
                }
            }
        }
        return this.f17126h;
    }

    public final String toString() {
        Object string;
        if (this.f17125g) {
            String strValueOf = String.valueOf(this.f17126h);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 25);
            sb.append("<supplier that returned ");
            sb.append(strValueOf);
            sb.append(">");
            string = sb.toString();
        } else {
            string = this.f17124f;
        }
        String strValueOf2 = String.valueOf(string);
        StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 19);
        sb2.append("Suppliers.memoize(");
        sb2.append(strValueOf2);
        sb2.append(")");
        return sb2.toString();
    }
}
