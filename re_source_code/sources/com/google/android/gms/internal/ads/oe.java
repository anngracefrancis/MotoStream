package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
final class oe implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final WeakReference<zzbtb> f13098f;

    private oe(zzbtb zzbtbVar) {
        this.f13098f = new WeakReference<>(zzbtbVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbtb zzbtbVar = this.f13098f.get();
        if (zzbtbVar != null) {
            zzbtbVar.g0();
        }
    }
}
