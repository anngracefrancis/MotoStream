package com.google.android.gms.internal.safetynet;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.safetynet.zzd;

/* JADX INFO: loaded from: classes2.dex */
final class c extends zze {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzk.a f17587f;

    c(zzk.a aVar) {
        this.f17587f = aVar;
    }

    @Override // com.google.android.gms.internal.safetynet.zze, com.google.android.gms.internal.safetynet.zzg
    public final void s5(Status status, zzd zzdVar) {
        this.f17587f.k(new zzk.b(status, zzdVar));
    }
}
