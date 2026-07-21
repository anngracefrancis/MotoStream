package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.WeakHashMap;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzasg {
    private WeakHashMap<Context, t3> a = new WeakHashMap<>();

    public final Future<zzase> b(Context context) {
        return zzaxg.a(new s3(this, context));
    }
}
