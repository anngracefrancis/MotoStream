package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.net.Uri;

/* JADX INFO: loaded from: classes2.dex */
@zzard
@TargetApi(16)
public final class zzbgk extends zzbgl {
    public zzbgk(zzbdf zzbdfVar) {
        super(zzbdfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbgl
    protected final zzhn C(String str) {
        return new zzgl(this.f14430f, Uri.parse(str), null, 2);
    }

    @Override // com.google.android.gms.internal.ads.zzbgl
    protected final int D() {
        return 0;
    }
}
