package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcwz implements zzdti<ApplicationInfo> {
    private final zzcwx a;

    public zzcwz(zzcwx zzcwxVar) {
        this.a = zzcwxVar;
    }

    public static ApplicationInfo a(zzcwx zzcwxVar) {
        return (ApplicationInfo) zzdto.b(zzcwxVar.f(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return a(this.a);
    }
}
