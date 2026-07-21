package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcur implements zzcuz<Bundle> {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f15646b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f15647c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f15648d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Long f15649e;

    public zzcur(String str, String str2, String str3, String str4, Long l) {
        this.a = str;
        this.f15646b = str2;
        this.f15647c = str3;
        this.f15648d = str4;
        this.f15649e = l;
    }

    @Override // com.google.android.gms.internal.ads.zzcuz
    public final /* synthetic */ void a(Bundle bundle) {
        Bundle bundle2 = bundle;
        zzcxz.e(bundle2, "gmp_app_id", this.a);
        zzcxz.e(bundle2, "fbs_aiid", this.f15646b);
        zzcxz.e(bundle2, "fbs_aeid", this.f15647c);
        zzcxz.e(bundle2, "apm_id_origin", this.f15648d);
        Long l = this.f15649e;
        if (l != null) {
            bundle2.putLong("sai_timeout", l.longValue());
        }
    }
}
