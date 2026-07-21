package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzr<T> implements Comparable<zzr<T>> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzag.a f16633f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f16634g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f16635h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f16636i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Object f16637j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private zzz f16638k;
    private Integer l;
    private zzv m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private zzac r;
    private zzc s;
    private o30 t;

    public zzr(int i2, String str, zzz zzzVar) {
        Uri uri;
        String host;
        this.f16633f = zzag.a.a ? new zzag.a() : null;
        this.f16637j = new Object();
        this.n = true;
        int iHashCode = 0;
        this.o = false;
        this.p = false;
        this.q = false;
        this.s = null;
        this.f16634g = i2;
        this.f16635h = str;
        this.f16638k = zzzVar;
        this.r = new zzh();
        if (!TextUtils.isEmpty(str) && (uri = Uri.parse(str)) != null && (host = uri.getHost()) != null) {
            iHashCode = host.hashCode();
        }
        this.f16636i = iHashCode;
    }

    final void A(int i2) {
        zzv zzvVar = this.m;
        if (zzvVar != null) {
            zzvVar.b(this, i2);
        }
    }

    final void D(o30 o30Var) {
        synchronized (this.f16637j) {
            this.t = o30Var;
        }
    }

    final void E(zzy<?> zzyVar) {
        o30 o30Var;
        synchronized (this.f16637j) {
            o30Var = this.t;
        }
        if (o30Var != null) {
            o30Var.b(this, zzyVar);
        }
    }

    protected abstract void F(T t);

    /* JADX WARN: Multi-variable type inference failed */
    public final zzr<?> G(int i2) {
        this.l = Integer.valueOf(i2);
        return this;
    }

    public final void H(zzaf zzafVar) {
        zzz zzzVar;
        synchronized (this.f16637j) {
            zzzVar = this.f16638k;
        }
        if (zzzVar != null) {
            zzzVar.a(zzafVar);
        }
    }

    public final void I(String str) {
        if (zzag.a.a) {
            this.f16633f.a(str, Thread.currentThread().getId());
        }
    }

    final void J(String str) {
        zzv zzvVar = this.m;
        if (zzvVar != null) {
            zzvVar.d(this);
        }
        if (zzag.a.a) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new l30(this, str, id));
            } else {
                this.f16633f.a(str, id);
                this.f16633f.b(toString());
            }
        }
    }

    public final int K() {
        return this.f16636i;
    }

    public final String M() {
        String str = this.f16635h;
        int i2 = this.f16634g;
        if (i2 == 0 || i2 == -1) {
            return str;
        }
        String string = Integer.toString(i2);
        StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 1 + String.valueOf(str).length());
        sb.append(string);
        sb.append('-');
        sb.append(str);
        return sb.toString();
    }

    public final zzc N() {
        return this.s;
    }

    public byte[] O() throws zza {
        return null;
    }

    public final boolean P() {
        return this.n;
    }

    public final int Q() {
        return this.r.b();
    }

    public final zzac R() {
        return this.r;
    }

    public final void S() {
        synchronized (this.f16637j) {
            this.p = true;
        }
    }

    public final boolean T() {
        boolean z;
        synchronized (this.f16637j) {
            z = this.p;
        }
        return z;
    }

    final void U() {
        o30 o30Var;
        synchronized (this.f16637j) {
            o30Var = this.t;
        }
        if (o30Var != null) {
            o30Var.a(this);
        }
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(Object obj) {
        zzr zzrVar = (zzr) obj;
        zzu zzuVar = zzu.NORMAL;
        return zzuVar == zzuVar ? this.l.intValue() - zzrVar.l.intValue() : zzuVar.ordinal() - zzuVar.ordinal();
    }

    public Map<String, String> g() throws zza {
        return Collections.emptyMap();
    }

    public final int k() {
        return this.f16634g;
    }

    public final String q() {
        return this.f16635h;
    }

    public String toString() {
        String strValueOf = String.valueOf(Integer.toHexString(this.f16636i));
        String strConcat = strValueOf.length() != 0 ? "0x".concat(strValueOf) : new String("0x");
        u();
        String str = this.f16635h;
        String strValueOf2 = String.valueOf(zzu.NORMAL);
        String strValueOf3 = String.valueOf(this.l);
        StringBuilder sb = new StringBuilder("[ ] ".length() + 3 + String.valueOf(str).length() + String.valueOf(strConcat).length() + strValueOf2.length() + strValueOf3.length());
        sb.append("[ ] ");
        sb.append(str);
        sb.append(" ");
        sb.append(strConcat);
        sb.append(" ");
        sb.append(strValueOf2);
        sb.append(" ");
        sb.append(strValueOf3);
        return sb.toString();
    }

    public final boolean u() {
        synchronized (this.f16637j) {
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final zzr<?> v(zzc zzcVar) {
        this.s = zzcVar;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final zzr<?> x(zzv zzvVar) {
        this.m = zzvVar;
        return this;
    }

    protected abstract zzy<T> y(zzp zzpVar);
}
