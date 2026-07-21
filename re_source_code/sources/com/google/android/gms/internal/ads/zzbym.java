package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzbym extends zzaef {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzbyt f14855f;

    public zzbym(zzbyt zzbytVar) {
        this.f14855f = zzbytVar;
    }

    private final float h7() {
        try {
            return this.f14855f.m().T();
        } catch (RemoteException e2) {
            zzbad.c("Remote exception getting video controller aspect ratio.", e2);
            return 0.0f;
        }
    }

    private final float i7() {
        zzadw zzadwVar = this.f14855f.h().get(0);
        if (zzadwVar.getWidth() != -1 && zzadwVar.getHeight() != -1) {
            return zzadwVar.getWidth() / zzadwVar.getHeight();
        }
        try {
            Drawable drawable = (Drawable) ObjectWrapper.k0(zzadwVar.t4());
            if (drawable == null || drawable.getIntrinsicWidth() == -1 || drawable.getIntrinsicHeight() == -1) {
                return 0.0f;
            }
            return drawable.getIntrinsicWidth() / drawable.getIntrinsicHeight();
        } catch (RemoteException e2) {
            zzbad.c("RemoteException getting Drawable for aspect ratio calculation.", e2);
            return 0.0f;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaee
    public final float T() {
        if (!((Boolean) zzyt.e().c(zzacu.e5)).booleanValue()) {
            return 0.0f;
        }
        if (this.f14855f.Y() != 0.0f) {
            return this.f14855f.Y();
        }
        return this.f14855f.m() != null ? h7() : i7();
    }
}
