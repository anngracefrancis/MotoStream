package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: loaded from: classes2.dex */
public final class zzctc implements zzcuz<Bundle> {
    private final String a;

    public zzctc(String str) {
        this.a = str;
    }

    @Override // com.google.android.gms.internal.ads.zzcuz
    public final /* synthetic */ void a(Bundle bundle) {
        bundle.putString("gct", this.a);
    }
}
