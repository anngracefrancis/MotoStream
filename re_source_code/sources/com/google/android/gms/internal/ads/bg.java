package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes2.dex */
final class bg implements zzadx {
    private final /* synthetic */ zzcab a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ ViewGroup f12351b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzbzl f12352c;

    bg(zzbzl zzbzlVar, zzcab zzcabVar, ViewGroup viewGroup) {
        this.f12352c = zzbzlVar;
        this.a = zzcabVar;
        this.f12351b = viewGroup;
    }

    @Override // com.google.android.gms.internal.ads.zzadx
    public final void a() {
        zzbzl zzbzlVar = this.f12352c;
        if (zzbzl.d(this.a, zzbzj.f14914f)) {
            this.a.onClick(this.f12351b);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadx
    public final void b(MotionEvent motionEvent) {
        this.a.onTouch(null, motionEvent);
    }
}
