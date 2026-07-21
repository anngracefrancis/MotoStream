package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class zzem extends zzfk {
    private static zzfl<String> n = new zzfl<>();
    private final Context o;

    public zzem(zzdy zzdyVar, String str, String str2, zzbp.zza.C0176zza c0176zza, int i2, int i3, Context context) {
        super(zzdyVar, str, str2, c0176zza, i2, 29);
        this.o = context;
    }

    @Override // com.google.android.gms.internal.ads.zzfk
    protected final void a() throws IllegalAccessException, InvocationTargetException {
        this.f16224j.u("E");
        AtomicReference<String> atomicReferenceA = n.a(this.o.getPackageName());
        if (atomicReferenceA.get() == null) {
            synchronized (atomicReferenceA) {
                if (atomicReferenceA.get() == null) {
                    atomicReferenceA.set((String) this.f16225k.invoke(null, this.o));
                }
            }
        }
        String str = atomicReferenceA.get();
        synchronized (this.f16224j) {
            this.f16224j.u(zzcg.a(str.getBytes(), true));
        }
    }
}
