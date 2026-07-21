package com.google.android.gms.internal.ads;

import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
final class y40 extends zzbbr<InputStream> {
    private final /* synthetic */ zzwb l;

    y40(zzwb zzwbVar) {
        this.l = zzwbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbbr, java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        this.l.a();
        return super.cancel(z);
    }
}
