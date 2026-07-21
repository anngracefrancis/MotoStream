package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.ads.internal.zzk;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzaxa extends zzdbh {
    public zzaxa(Looper looper) {
        super(looper);
    }

    @Override // com.google.android.gms.internal.ads.zzdbh
    protected final void a(Message message) {
        try {
            super.a(message);
        } catch (Throwable th) {
            zzk.zzlg();
            zzaxi.n(zzk.zzlk().a(), th);
            throw th;
        }
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        try {
            super.handleMessage(message);
        } catch (Exception e2) {
            zzk.zzlk().e(e2, "AdMobHandler.handleMessage");
        }
    }
}
