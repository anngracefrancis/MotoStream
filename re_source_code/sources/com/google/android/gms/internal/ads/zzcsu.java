package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcsu implements zzcuz<Bundle> {
    private final Bundle a;

    public zzcsu(Bundle bundle) {
        this.a = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzcuz
    public final /* synthetic */ void a(Bundle bundle) {
        bundle.putBundle("content_info", this.a);
    }
}
