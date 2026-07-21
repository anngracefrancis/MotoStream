package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzes extends zzfk {
    public zzes(zzdy zzdyVar, String str, String str2, zzbp.zza.C0176zza c0176zza, int i2, int i3) {
        super(zzdyVar, str, str2, c0176zza, i2, 24);
    }

    private final void c() {
        AdvertisingIdClient advertisingIdClientD = this.f16221g.D();
        if (advertisingIdClientD == null) {
            return;
        }
        try {
            AdvertisingIdClient.Info info = advertisingIdClientD.getInfo();
            String strE = zzef.e(info.getId());
            if (strE != null) {
                synchronized (this.f16224j) {
                    try {
                        this.f16224j.C(strE);
                        this.f16224j.X(info.isLimitAdTrackingEnabled());
                        this.f16224j.T(zzbp.zza.zzc.DEVICE_IDENTIFIER_ANDROID_AD_ID);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        } catch (IOException unused) {
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfk
    protected final void a() throws IllegalAccessException, InvocationTargetException {
        if (this.f16221g.v()) {
            c();
            return;
        }
        synchronized (this.f16224j) {
            this.f16224j.C((String) this.f16225k.invoke(null, this.f16221g.a()));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfk
    /* JADX INFO: renamed from: b */
    public final Void call() throws Exception {
        if (this.f16221g.b()) {
            return super.call();
        }
        if (!this.f16221g.v()) {
            return null;
        }
        c();
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzfk, java.util.concurrent.Callable
    public final /* synthetic */ Object call() throws Exception {
        return call();
    }
}
