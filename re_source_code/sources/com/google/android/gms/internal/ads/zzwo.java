package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzwo {

    @VisibleForTesting
    zzfx a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @VisibleForTesting
    boolean f16880b;

    public zzwo(Context context, String str, String str2) {
        zzacu.a(context);
        try {
            this.a = (zzfx) zzbae.a(context, "com.google.android.gms.ads.clearcut.DynamiteClearcutLogger", g50.a);
            ObjectWrapper.E0(context);
            this.a.N3(ObjectWrapper.E0(context), str, null);
            this.f16880b = true;
        } catch (RemoteException | zzbag | NullPointerException unused) {
            zzbad.e("Cannot dynamite load clearcut");
        }
    }

    public final zzws a(byte[] bArr) {
        return new zzws(this, bArr);
    }

    public zzwo(Context context) {
        zzacu.a(context);
        if (((Boolean) zzyt.e().c(zzacu.S3)).booleanValue()) {
            try {
                this.a = (zzfx) zzbae.a(context, "com.google.android.gms.ads.clearcut.DynamiteClearcutLogger", h50.a);
                ObjectWrapper.E0(context);
                this.a.R0(ObjectWrapper.E0(context), "GMA_SDK");
                this.f16880b = true;
            } catch (RemoteException | zzbag | NullPointerException unused) {
                zzbad.e("Cannot dynamite load clearcut");
            }
        }
    }

    public zzwo() {
    }
}
