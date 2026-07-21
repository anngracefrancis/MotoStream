package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcud implements zzcuz<Bundle> {
    private final Bundle a;

    public zzcud(Bundle bundle) {
        this.a = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzcuz
    public final /* synthetic */ void a(Bundle bundle) {
        Bundle bundle2 = bundle;
        Bundle bundle3 = this.a;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
    }
}
