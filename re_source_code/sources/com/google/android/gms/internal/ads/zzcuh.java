package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcuh implements zzcva<zzcuz<Bundle>> {
    private final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f15634b;

    zzcuh(Context context, String str) {
        this.a = context;
        this.f15634b = str;
    }

    final /* synthetic */ void a(Bundle bundle) {
        bundle.putString("rewarded_sku_package", this.a.getPackageName());
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<zzcuz<Bundle>> b() {
        return zzbar.o(this.f15634b == null ? null : new zzcuz(this) { // from class: com.google.android.gms.internal.ads.so
            private final zzcuh a;

            {
                this.a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzcuz
            public final void a(Object obj) {
                this.a.a((Bundle) obj);
            }
        });
    }
}
