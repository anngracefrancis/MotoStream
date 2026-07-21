package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: loaded from: classes2.dex */
public final class zzctk implements zzcuz<Bundle> {
    private final zzcxk a;

    public zzctk(zzcxk zzcxkVar) {
        this.a = zzcxkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcuz
    public final /* synthetic */ void a(Bundle bundle) {
        Bundle bundle2 = bundle;
        zzcxk zzcxkVar = this.a;
        if (zzcxkVar != null) {
            bundle2.putBoolean("render_in_browser", zzcxkVar.b());
            bundle2.putBoolean("disable_ml", this.a.c());
        }
    }
}
