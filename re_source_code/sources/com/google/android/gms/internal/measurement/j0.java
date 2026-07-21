package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class j0 extends ContentObserver {
    j0(Handler handler) {
        super(null);
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        zzbw.f17327e.set(true);
    }
}
