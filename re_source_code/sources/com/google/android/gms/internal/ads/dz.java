package com.google.android.gms.internal.ads;

import android.media.MediaCodec;

/* JADX INFO: loaded from: classes2.dex */
final class dz implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ MediaCodec.CryptoException f12488f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzgr f12489g;

    dz(zzgr zzgrVar, MediaCodec.CryptoException cryptoException) {
        this.f12489g = zzgrVar;
        this.f12488f = cryptoException;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f12489g.f16260j.a(this.f12488f);
    }
}
