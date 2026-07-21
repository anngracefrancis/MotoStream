package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzatf extends RemoteCreator<zzasz> {
    public zzatf() {
        super("com.google.android.gms.ads.reward.RewardedVideoAdCreatorImpl");
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    protected final /* synthetic */ zzasz a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdCreator");
        return iInterfaceQueryLocalInterface instanceof zzasz ? (zzasz) iInterfaceQueryLocalInterface : new zzata(iBinder);
    }

    public final zzasw c(Context context, zzamp zzampVar) {
        try {
            IBinder iBinderV5 = b(context).V5(ObjectWrapper.E0(context), zzampVar, 15000000);
            if (iBinderV5 == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinderV5.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
            return iInterfaceQueryLocalInterface instanceof zzasw ? (zzasw) iInterfaceQueryLocalInterface : new zzasy(iBinderV5);
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e2) {
            zzbad.d("Could not get remote RewardedVideoAd.", e2);
            return null;
        }
    }
}
