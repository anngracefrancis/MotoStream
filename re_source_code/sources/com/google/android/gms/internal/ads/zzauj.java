package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzauj {
    public static zzatt a(Context context, String str, zzamp zzampVar) {
        try {
            IBinder iBinderL6 = ((zzatz) zzbae.a(context, "com.google.android.gms.ads.rewarded.ChimeraRewardedAdCreatorImpl", w3.a)).L6(ObjectWrapper.E0(context), str, zzampVar, 15000000);
            if (iBinderL6 == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinderL6.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
            return iInterfaceQueryLocalInterface instanceof zzatt ? (zzatt) iInterfaceQueryLocalInterface : new zzatv(iBinderL6);
        } catch (RemoteException | zzbag e2) {
            zzbad.f("#007 Could not call remote method.", e2);
            return null;
        }
    }
}
