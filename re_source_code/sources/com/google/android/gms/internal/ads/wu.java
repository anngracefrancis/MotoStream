package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class wu extends vu<Object> {
    wu() {
    }

    @Override // com.google.android.gms.internal.ads.vu
    final int a(Map.Entry<?, ?> entry) {
        entry.getKey();
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.ads.vu
    final Object b(zzdno zzdnoVar, zzdpk zzdpkVar, int i2) {
        return zzdnoVar.a(zzdpkVar, i2);
    }

    @Override // com.google.android.gms.internal.ads.vu
    final <UT, UB> UB c(kw kwVar, Object obj, zzdno zzdnoVar, yu<Object> yuVar, UB ub, cx<UT, UB> cxVar) throws IOException {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.ads.vu
    final void d(zzdmr zzdmrVar, Object obj, zzdno zzdnoVar, yu<Object> yuVar) throws IOException {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.ads.vu
    final void e(kw kwVar, Object obj, zzdno zzdnoVar, yu<Object> yuVar) throws IOException {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.ads.vu
    final void f(ux uxVar, Map.Entry<?, ?> entry) throws IOException {
        entry.getKey();
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.ads.vu
    final void g(Object obj) {
        i(obj).l();
    }

    @Override // com.google.android.gms.internal.ads.vu
    final boolean h(zzdpk zzdpkVar) {
        return zzdpkVar instanceof zzdob.zzc;
    }

    @Override // com.google.android.gms.internal.ads.vu
    final yu<Object> i(Object obj) {
        return ((zzdob.zzc) obj).zzhhj;
    }

    @Override // com.google.android.gms.internal.ads.vu
    final yu<Object> j(Object obj) {
        zzdob.zzc zzcVar = (zzdob.zzc) obj;
        if (zzcVar.zzhhj.c()) {
            zzcVar.zzhhj = (yu) zzcVar.zzhhj.clone();
        }
        return zzcVar.zzhhj;
    }
}
