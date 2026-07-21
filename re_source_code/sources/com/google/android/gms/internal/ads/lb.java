package com.google.android.gms.internal.ads;

import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
final class lb implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzavb f12921f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzbio f12922g;

    lb(zzbio zzbioVar, zzavb zzavbVar) {
        this.f12922g = zzbioVar;
        this.f12921f = zzavbVar;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.f12922g.v(view, this.f12921f, 10);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }
}
