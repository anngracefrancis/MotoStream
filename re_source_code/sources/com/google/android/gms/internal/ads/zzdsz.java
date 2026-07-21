package com.google.android.gms.internal.ads;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdsz extends zzdtc {
    private Logger a;

    public zzdsz(String str) {
        this.a = Logger.getLogger(str);
    }

    @Override // com.google.android.gms.internal.ads.zzdtc
    public final void a(String str) {
        this.a.logp(Level.FINE, "com.googlecode.mp4parser.util.JuliLogger", "logDebug", str);
    }
}
