package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzyf extends zzzt {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AppEventListener f16993f;

    public zzyf(AppEventListener appEventListener) {
        this.f16993f = appEventListener;
    }

    public final AppEventListener i7() {
        return this.f16993f;
    }

    @Override // com.google.android.gms.internal.ads.zzzs
    public final void onAppEvent(String str, String str2) {
        this.f16993f.onAppEvent(str, str2);
    }
}
