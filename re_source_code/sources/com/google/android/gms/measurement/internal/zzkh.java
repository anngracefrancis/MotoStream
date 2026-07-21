package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
@VisibleForTesting
public final class zzkh {
    final Context a;

    @VisibleForTesting
    public zzkh(Context context) {
        Preconditions.k(context);
        Context applicationContext = context.getApplicationContext();
        Preconditions.k(applicationContext);
        this.a = applicationContext;
    }
}
