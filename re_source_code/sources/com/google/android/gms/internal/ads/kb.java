package com.google.android.gms.internal.ads;

import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
final class kb implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ View f12859f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzavb f12860g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ int f12861h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final /* synthetic */ zzbio f12862i;

    kb(zzbio zzbioVar, View view, zzavb zzavbVar, int i2) {
        this.f12862i = zzbioVar;
        this.f12859f = view;
        this.f12860g = zzavbVar;
        this.f12861h = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f12862i.v(this.f12859f, this.f12860g, this.f12861h - 1);
    }
}
