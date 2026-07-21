package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
final class s3 implements Callable<zzase> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ Context f13306f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzasg f13307g;

    s3(zzasg zzasgVar, Context context) {
        this.f13307g = zzasgVar;
        this.f13306f = context;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0042  */
    @Override // java.util.concurrent.Callable
    public final /* synthetic */ zzase call() throws Exception {
        zzase zzaseVarG;
        t3 t3Var = (t3) this.f13307g.a.get(this.f13306f);
        if (t3Var != null) {
            if (t3Var.a + ((Long) zzyt.e().c(zzacu.T1)).longValue() < zzk.zzln().a()) {
                zzaseVarG = new zzasf(this.f13306f).g();
            } else {
                zzaseVarG = new zzasf(this.f13306f, t3Var.f13342b).g();
            }
        } else {
            zzaseVarG = new zzasf(this.f13306f).g();
        }
        this.f13307g.a.put(this.f13306f, new t3(this.f13307g, zzaseVarG));
        return zzaseVarG;
    }
}
