package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzer extends q4 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final AtomicReference<String[]> f18102c = new AtomicReference<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final AtomicReference<String[]> f18103d = new AtomicReference<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final AtomicReference<String[]> f18104e = new AtomicReference<>();

    zzer(zzfx zzfxVar) {
        super(zzfxVar);
    }

    private final boolean C() {
        G();
        return this.a.L() && this.a.h().C(3);
    }

    private final String w(zzam zzamVar) {
        if (zzamVar == null) {
            return null;
        }
        return !C() ? zzamVar.toString() : u(zzamVar.Y());
    }

    private static String z(String str, String[] strArr, String[] strArr2, AtomicReference<String[]> atomicReference) {
        String str2;
        Preconditions.k(strArr);
        Preconditions.k(strArr2);
        Preconditions.k(atomicReference);
        Preconditions.a(strArr.length == strArr2.length);
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if (zzkk.t0(str, strArr[i2])) {
                synchronized (atomicReference) {
                    String[] strArr3 = atomicReference.get();
                    if (strArr3 == null) {
                        strArr3 = new String[strArr2.length];
                        atomicReference.set(strArr3);
                    }
                    if (strArr3[i2] == null) {
                        strArr3[i2] = strArr2[i2] + "(" + strArr[i2] + ")";
                    }
                    str2 = strArr3[i2];
                }
                return str2;
            }
        }
        return str;
    }

    protected final String A(String str) {
        if (str == null) {
            return null;
        }
        return !C() ? str : z(str, zzgv.f18166b, zzgv.a, f18103d);
    }

    protected final String B(String str) {
        if (str == null) {
            return null;
        }
        if (!C()) {
            return str;
        }
        if (!str.startsWith("_exp_")) {
            return z(str, zzgy.f18168b, zzgy.a, f18104e);
        }
        return "experiment_id(" + str + ")";
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ zzw G() {
        return super.G();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ void a() {
        super.a();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ void b() {
        super.b();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ void d() {
        super.d();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ zzah e() {
        return super.e();
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ Context f() {
        return super.f();
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ zzfu g() {
        return super.g();
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ zzet h() {
        return super.h();
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ Clock j() {
        return super.j();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ zzer k() {
        return super.k();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ zzkk l() {
        return super.l();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ r3 m() {
        return super.m();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ zzx n() {
        return super.n();
    }

    @Override // com.google.android.gms.measurement.internal.q4
    protected final boolean s() {
        return false;
    }

    protected final String u(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        if (!C()) {
            return bundle.toString();
        }
        StringBuilder sb = new StringBuilder();
        for (String str : bundle.keySet()) {
            if (sb.length() != 0) {
                sb.append(", ");
            } else {
                sb.append("Bundle[{");
            }
            sb.append(A(str));
            sb.append("=");
            sb.append(bundle.get(str));
        }
        sb.append("}]");
        return sb.toString();
    }

    protected final String v(zzak zzakVar) {
        if (zzakVar == null) {
            return null;
        }
        if (!C()) {
            return zzakVar.toString();
        }
        return "Event{appId='" + zzakVar.a + "', name='" + y(zzakVar.f18061b) + "', params=" + w(zzakVar.f18065f) + "}";
    }

    protected final String x(zzan zzanVar) {
        if (zzanVar == null) {
            return null;
        }
        if (!C()) {
            return zzanVar.toString();
        }
        return "origin=" + zzanVar.f18069h + ",name=" + y(zzanVar.f18067f) + ",params=" + w(zzanVar.f18068g);
    }

    protected final String y(String str) {
        if (str == null) {
            return null;
        }
        return !C() ? str : z(str, zzgw.f18167b, zzgw.a, f18102c);
    }
}
