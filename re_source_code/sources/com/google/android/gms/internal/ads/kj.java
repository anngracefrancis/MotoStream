package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
final class kj implements zzbtk {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Context f12884f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzavg f12885g;

    kj(Context context, zzavg zzavgVar) {
        this.f12884f = context;
        this.f12885g = zzavgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final void N(zzarx zzarxVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final void q(zzcxu zzcxuVar) {
        if (TextUtils.isEmpty(zzcxuVar.f15747b.f15744b.f15738d)) {
            return;
        }
        this.f12885g.w(this.f12884f, zzcxuVar.f15747b.f15744b.f15738d);
    }
}
