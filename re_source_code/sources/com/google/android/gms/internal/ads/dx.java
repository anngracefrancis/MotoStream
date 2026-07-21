package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
final class dx extends cx<zzdqu, zzdqu> {
    dx() {
    }

    private static void t(Object obj, zzdqu zzdquVar) {
        ((zzdob) obj).zzhhd = zzdquVar;
    }

    @Override // com.google.android.gms.internal.ads.cx
    final /* synthetic */ void a(zzdqu zzdquVar, int i2, long j2) {
        zzdquVar.k(i2 << 3, Long.valueOf(j2));
    }

    @Override // com.google.android.gms.internal.ads.cx
    final /* synthetic */ void b(zzdqu zzdquVar, int i2, zzdmr zzdmrVar) {
        zzdquVar.k((i2 << 3) | 2, zzdmrVar);
    }

    @Override // com.google.android.gms.internal.ads.cx
    final /* synthetic */ void c(zzdqu zzdquVar, int i2, zzdqu zzdquVar2) {
        zzdquVar.k((i2 << 3) | 3, zzdquVar2);
    }

    @Override // com.google.android.gms.internal.ads.cx
    final /* synthetic */ void d(zzdqu zzdquVar, ux uxVar) throws IOException {
        zzdquVar.h(uxVar);
    }

    @Override // com.google.android.gms.internal.ads.cx
    final boolean e(kw kwVar) {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.cx
    final void g(Object obj) {
        ((zzdob) obj).zzhhd.d();
    }

    @Override // com.google.android.gms.internal.ads.cx
    final /* synthetic */ zzdqu h(zzdqu zzdquVar) {
        zzdqu zzdquVar2 = zzdquVar;
        zzdquVar2.d();
        return zzdquVar2;
    }

    @Override // com.google.android.gms.internal.ads.cx
    final /* synthetic */ int i(zzdqu zzdquVar) {
        return zzdquVar.e();
    }

    @Override // com.google.android.gms.internal.ads.cx
    final /* synthetic */ zzdqu j(Object obj) {
        return ((zzdob) obj).zzhhd;
    }

    @Override // com.google.android.gms.internal.ads.cx
    final /* synthetic */ zzdqu k(Object obj) {
        zzdqu zzdquVar = ((zzdob) obj).zzhhd;
        if (zzdquVar != zzdqu.f()) {
            return zzdquVar;
        }
        zzdqu zzdquVarI = zzdqu.i();
        t(obj, zzdquVarI);
        return zzdquVarI;
    }

    @Override // com.google.android.gms.internal.ads.cx
    final /* synthetic */ int l(zzdqu zzdquVar) {
        return zzdquVar.j();
    }

    @Override // com.google.android.gms.internal.ads.cx
    final /* synthetic */ zzdqu m() {
        return zzdqu.i();
    }

    @Override // com.google.android.gms.internal.ads.cx
    final /* synthetic */ void n(zzdqu zzdquVar, int i2, long j2) {
        zzdquVar.k((i2 << 3) | 1, Long.valueOf(j2));
    }

    @Override // com.google.android.gms.internal.ads.cx
    final /* synthetic */ void o(zzdqu zzdquVar, int i2, int i3) {
        zzdquVar.k((i2 << 3) | 5, Integer.valueOf(i3));
    }

    @Override // com.google.android.gms.internal.ads.cx
    final /* synthetic */ void p(zzdqu zzdquVar, ux uxVar) throws IOException {
        zzdquVar.b(uxVar);
    }

    @Override // com.google.android.gms.internal.ads.cx
    final /* synthetic */ void q(Object obj, zzdqu zzdquVar) {
        t(obj, zzdquVar);
    }

    @Override // com.google.android.gms.internal.ads.cx
    final /* synthetic */ void r(Object obj, zzdqu zzdquVar) {
        t(obj, zzdquVar);
    }

    @Override // com.google.android.gms.internal.ads.cx
    final /* synthetic */ zzdqu s(zzdqu zzdquVar, zzdqu zzdquVar2) {
        zzdqu zzdquVar3 = zzdquVar;
        zzdqu zzdquVar4 = zzdquVar2;
        return zzdquVar4.equals(zzdqu.f()) ? zzdquVar3 : zzdqu.a(zzdquVar3, zzdquVar4);
    }
}
