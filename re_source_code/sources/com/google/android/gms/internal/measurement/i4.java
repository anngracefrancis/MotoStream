package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class i4 extends h4<zzhy, zzhy> {
    i4() {
    }

    private static void t(Object obj, zzhy zzhyVar) {
        ((zzfd) obj).zzb = zzhyVar;
    }

    @Override // com.google.android.gms.internal.measurement.h4
    final /* synthetic */ zzhy a() {
        return zzhy.g();
    }

    @Override // com.google.android.gms.internal.measurement.h4
    final /* synthetic */ zzhy b(zzhy zzhyVar) {
        zzhy zzhyVar2 = zzhyVar;
        zzhyVar2.i();
        return zzhyVar2;
    }

    @Override // com.google.android.gms.internal.measurement.h4
    final /* synthetic */ void c(zzhy zzhyVar, int i2, int i3) {
        zzhyVar.c((i2 << 3) | 5, Integer.valueOf(i3));
    }

    @Override // com.google.android.gms.internal.measurement.h4
    final /* synthetic */ void d(zzhy zzhyVar, int i2, long j2) {
        zzhyVar.c(i2 << 3, Long.valueOf(j2));
    }

    @Override // com.google.android.gms.internal.measurement.h4
    final /* synthetic */ void e(zzhy zzhyVar, int i2, zzdu zzduVar) {
        zzhyVar.c((i2 << 3) | 2, zzduVar);
    }

    @Override // com.google.android.gms.internal.measurement.h4
    final /* synthetic */ void f(zzhy zzhyVar, int i2, zzhy zzhyVar2) {
        zzhyVar.c((i2 << 3) | 3, zzhyVar2);
    }

    @Override // com.google.android.gms.internal.measurement.h4
    final /* synthetic */ void g(zzhy zzhyVar, y4 y4Var) throws IOException {
        zzhyVar.h(y4Var);
    }

    @Override // com.google.android.gms.internal.measurement.h4
    final /* bridge */ /* synthetic */ void h(Object obj, zzhy zzhyVar) {
        t(obj, zzhyVar);
    }

    @Override // com.google.android.gms.internal.measurement.h4
    final boolean i(q3 q3Var) {
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.h4
    final /* synthetic */ zzhy k(Object obj) {
        return ((zzfd) obj).zzb;
    }

    @Override // com.google.android.gms.internal.measurement.h4
    final /* synthetic */ void l(zzhy zzhyVar, int i2, long j2) {
        zzhyVar.c((i2 << 3) | 1, Long.valueOf(j2));
    }

    @Override // com.google.android.gms.internal.measurement.h4
    final /* synthetic */ void m(zzhy zzhyVar, y4 y4Var) throws IOException {
        zzhyVar.e(y4Var);
    }

    @Override // com.google.android.gms.internal.measurement.h4
    final /* synthetic */ void n(Object obj, zzhy zzhyVar) {
        t(obj, zzhyVar);
    }

    @Override // com.google.android.gms.internal.measurement.h4
    final /* synthetic */ zzhy o(Object obj) {
        zzhy zzhyVar = ((zzfd) obj).zzb;
        if (zzhyVar != zzhy.a()) {
            return zzhyVar;
        }
        zzhy zzhyVarG = zzhy.g();
        t(obj, zzhyVarG);
        return zzhyVarG;
    }

    @Override // com.google.android.gms.internal.measurement.h4
    final /* synthetic */ zzhy p(zzhy zzhyVar, zzhy zzhyVar2) {
        zzhy zzhyVar3 = zzhyVar;
        zzhy zzhyVar4 = zzhyVar2;
        return zzhyVar4.equals(zzhy.a()) ? zzhyVar3 : zzhy.b(zzhyVar3, zzhyVar4);
    }

    @Override // com.google.android.gms.internal.measurement.h4
    final void q(Object obj) {
        ((zzfd) obj).zzb.i();
    }

    @Override // com.google.android.gms.internal.measurement.h4
    final /* synthetic */ int r(zzhy zzhyVar) {
        return zzhyVar.j();
    }

    @Override // com.google.android.gms.internal.measurement.h4
    final /* synthetic */ int s(zzhy zzhyVar) {
        return zzhyVar.k();
    }
}
