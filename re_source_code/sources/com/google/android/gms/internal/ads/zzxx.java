package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzxx extends RemoteCreator<zzzn> {
    @VisibleForTesting
    public zzxx() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    protected final /* synthetic */ zzzn a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
        return iInterfaceQueryLocalInterface instanceof zzzn ? (zzzn) iInterfaceQueryLocalInterface : new zzzo(iBinder);
    }

    public final zzzk c(Context context, zzyd zzydVar, String str, zzamp zzampVar, int i2) {
        try {
            IBinder iBinderO5 = b(context).o5(ObjectWrapper.E0(context), zzydVar, str, zzampVar, 15000000, i2);
            if (iBinderO5 == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinderO5.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            return iInterfaceQueryLocalInterface instanceof zzzk ? (zzzk) iInterfaceQueryLocalInterface : new zzzm(iBinderO5);
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e2) {
            zzbad.b("Could not create remote AdManager.", e2);
            return null;
        }
    }
}
