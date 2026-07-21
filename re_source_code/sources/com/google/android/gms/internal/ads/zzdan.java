package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.internal.ShowFirstParty;

/* JADX INFO: loaded from: classes2.dex */
@ShowFirstParty
public final class zzdan {
    private final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Looper f15838b;

    public zzdan(Context context, Looper looper) {
        this.a = context;
        this.f15838b = looper;
    }

    public final void a(String str) {
        new sq(this.a, this.f15838b, (zzdau) ((zzdob) zzdau.C().w(this.a.getPackageName()).v(zzdau.zzb.BLOCKED_IMPRESSION).u(zzdap.A().v(str).u(zzdap.zza.BLOCKED_REASON_BACKGROUND)).p0())).b();
    }
}
