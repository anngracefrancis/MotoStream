package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzk;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzavf implements zzue {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Context f14182f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Object f14183g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f14184h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f14185i;

    public zzavf(Context context, String str) {
        this.f14182f = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.f14184h = str;
        this.f14185i = false;
        this.f14183g = new Object();
    }

    public final String j() {
        return this.f14184h;
    }

    public final void k(boolean z) {
        if (zzk.zzme().D(this.f14182f)) {
            synchronized (this.f14183g) {
                if (this.f14185i == z) {
                    return;
                }
                this.f14185i = z;
                if (TextUtils.isEmpty(this.f14184h)) {
                    return;
                }
                if (this.f14185i) {
                    zzk.zzme().r(this.f14182f, this.f14184h);
                } else {
                    zzk.zzme().s(this.f14182f, this.f14184h);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzue
    public final void r0(zzud zzudVar) {
        k(zzudVar.m);
    }
}
