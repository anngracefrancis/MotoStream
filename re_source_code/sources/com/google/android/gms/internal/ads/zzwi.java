package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.InputStream;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzwi {
    public static Future<InputStream> a(Context context, zzvv zzvvVar) {
        return new zzwb(context).e(zzvvVar);
    }
}
