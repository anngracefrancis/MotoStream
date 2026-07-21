package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcqq extends zzawb {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private zzbjm f15553f;

    public zzcqq(zzbjm zzbjmVar) {
        this.f15553f = zzbjmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzawa
    public final void m5(IObjectWrapper iObjectWrapper, zzawc zzawcVar, zzavy zzavyVar) {
        Context context = (Context) ObjectWrapper.k0(iObjectWrapper);
        String str = zzawcVar.f14197f;
        String str2 = zzawcVar.f14198g;
        zzcqp zzcqpVarC = this.f15553f.n().b(new zzbqy.zza().e(context).b(new zzcxx().t(str).w(new zzya().a()).n(zzawcVar.f14199h).d()).c()).c(new zzcqt(new zzcqt.zza().b(str2)));
        new zzbtv.zza().k();
        zzbar.f(zzcqpVarC.a().a(), new kn(this, zzavyVar), this.f15553f.e());
    }
}
