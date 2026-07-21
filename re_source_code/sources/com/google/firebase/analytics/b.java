package com.google.firebase.analytics;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzx;
import com.google.android.gms.measurement.internal.zzha;
import com.google.android.gms.measurement.internal.zzhx;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-api@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class b implements zzhx {
    private final /* synthetic */ zzx a;

    b(zzx zzxVar) {
        this.a = zzxVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzhx
    public final void J(Bundle bundle) {
        this.a.k(bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzhx
    public final void Y(String str) {
        this.a.I(str);
    }

    @Override // com.google.android.gms.measurement.internal.zzhx
    public final String a() {
        return this.a.Q();
    }

    @Override // com.google.android.gms.measurement.internal.zzhx
    public final String b() {
        return this.a.T();
    }

    @Override // com.google.android.gms.measurement.internal.zzhx
    public final String c() {
        return this.a.M();
    }

    @Override // com.google.android.gms.measurement.internal.zzhx
    public final String d() {
        return this.a.G();
    }

    @Override // com.google.android.gms.measurement.internal.zzhx
    public final long e() {
        return this.a.P();
    }

    @Override // com.google.android.gms.measurement.internal.zzhx
    public final void g0(boolean z) {
        this.a.D(z);
    }

    @Override // com.google.android.gms.measurement.internal.zzhx
    public final List<Bundle> i(String str, String str2) {
        return this.a.A(str, str2);
    }

    @Override // com.google.android.gms.measurement.internal.zzhx
    public final int j(String str) {
        return this.a.L(str);
    }

    @Override // com.google.android.gms.measurement.internal.zzhx
    public final Map<String, Object> k(String str, String str2, boolean z) {
        return this.a.h(str, str2, z);
    }

    @Override // com.google.android.gms.measurement.internal.zzhx
    public final void l(String str, String str2, Bundle bundle) {
        this.a.C(str, str2, bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzhx
    public final void m(String str, String str2, Bundle bundle) {
        this.a.s(str, str2, bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzhx
    public final void n(zzha zzhaVar) {
        this.a.o(zzhaVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzhx
    public final void o(String str, String str2, Object obj) {
        this.a.u(str, str2, obj);
    }

    @Override // com.google.android.gms.measurement.internal.zzhx
    public final void u(String str) {
        this.a.B(str);
    }
}
