package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.zzf;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcoz implements zzf {
    private zzf a;

    public final synchronized void a(zzf zzfVar) {
        this.a = zzfVar;
    }

    @Override // com.google.android.gms.ads.internal.zzf
    public final synchronized void zzg(View view) {
        zzf zzfVar = this.a;
        if (zzfVar != null) {
            zzfVar.zzg(view);
        }
    }

    @Override // com.google.android.gms.ads.internal.zzf
    public final synchronized void zzky() {
        zzf zzfVar = this.a;
        if (zzfVar != null) {
            zzfVar.zzky();
        }
    }

    @Override // com.google.android.gms.ads.internal.zzf
    public final synchronized void zzkz() {
        zzf zzfVar = this.a;
        if (zzfVar != null) {
            zzfVar.zzkz();
        }
    }
}
