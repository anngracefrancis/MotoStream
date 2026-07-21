package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: renamed from: com.google.android.gms.internal.ads.do, reason: invalid class name */
/* JADX INFO: loaded from: classes2.dex */
final class Cdo implements zzcuz<Bundle> {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Bundle f12482b;

    private Cdo(String str, Bundle bundle) {
        this.a = str;
        this.f12482b = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzcuz
    public final /* synthetic */ void a(Bundle bundle) {
        Bundle bundle2 = bundle;
        bundle2.putString("consent_string", this.a);
        bundle2.putBundle("iab_consent_info", this.f12482b);
    }
}
