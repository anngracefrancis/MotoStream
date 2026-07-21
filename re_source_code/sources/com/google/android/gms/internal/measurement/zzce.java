package com.google.android.gms.internal.measurement;

import android.os.Binder;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class zzce {
    public static <V> V a(zzcd<V> zzcdVar) {
        try {
            return zzcdVar.a();
        } catch (SecurityException unused) {
            long jClearCallingIdentity = Binder.clearCallingIdentity();
            try {
                return zzcdVar.a();
            } finally {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
            }
        }
    }
}
