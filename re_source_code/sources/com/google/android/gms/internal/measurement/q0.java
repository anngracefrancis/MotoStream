package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class q0 extends ContentObserver {
    q0(o0 o0Var, Handler handler) {
        super(null);
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        zzcl.g();
    }
}
