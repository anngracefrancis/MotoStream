package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class k0 extends ContentObserver {
    private final /* synthetic */ zzbx a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    k0(zzbx zzbxVar, Handler handler) {
        super(null);
        this.a = zzbxVar;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        this.a.c();
    }
}
