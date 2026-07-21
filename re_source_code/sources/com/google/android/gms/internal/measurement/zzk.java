package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzk extends zzq {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AtomicReference<Bundle> f17485f = new AtomicReference<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f17486g;

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0003, code lost:
    
        r4 = r4.get("r");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static <T> T P(android.os.Bundle r4, java.lang.Class<T> r5) {
        /*
            r0 = 0
            if (r4 == 0) goto L38
            java.lang.String r1 = "r"
            java.lang.Object r4 = r4.get(r1)
            if (r4 == 0) goto L38
            java.lang.Object r4 = r5.cast(r4)     // Catch: java.lang.ClassCastException -> L10
            return r4
        L10:
            r0 = move-exception
            java.lang.String r5 = r5.getCanonicalName()
            java.lang.Class r4 = r4.getClass()
            java.lang.String r4 = r4.getCanonicalName()
            java.lang.String r1 = "Unexpected object type. Expected, Received"
            java.lang.String r2 = ": %s, %s"
            java.lang.String r1 = r1.concat(r2)
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r5
            r5 = 1
            r2[r5] = r4
            java.lang.String r4 = java.lang.String.format(r1, r2)
            java.lang.String r5 = "AM"
            android.util.Log.w(r5, r4, r0)
            throw r0
        L38:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzk.P(android.os.Bundle, java.lang.Class):java.lang.Object");
    }

    public final Bundle E0(long j2) {
        Bundle bundle;
        synchronized (this.f17485f) {
            if (!this.f17486g) {
                try {
                    this.f17485f.wait(j2);
                } catch (InterruptedException unused) {
                    return null;
                }
            }
            bundle = this.f17485f.get();
        }
        return bundle;
    }

    @Override // com.google.android.gms.internal.measurement.zzn
    public final void J(Bundle bundle) {
        synchronized (this.f17485f) {
            try {
                this.f17485f.set(bundle);
                this.f17486g = true;
                this.f17485f.notify();
            } catch (Throwable th) {
                this.f17485f.notify();
                throw th;
            }
        }
    }

    public final String k0(long j2) {
        return (String) P(E0(j2), String.class);
    }
}
