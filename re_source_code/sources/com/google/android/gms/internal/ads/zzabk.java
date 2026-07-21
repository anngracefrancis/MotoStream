package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzabk extends RemoteCreator<zzaae> {
    public zzabk() {
        super("com.google.android.gms.ads.MobileAdsSettingManagerCreatorImpl");
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    protected final /* synthetic */ zzaae a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManagerCreator");
        return iInterfaceQueryLocalInterface instanceof zzaae ? (zzaae) iInterfaceQueryLocalInterface : new zzaaf(iBinder);
    }

    public final zzaab c(Context context) {
        try {
            IBinder iBinderC6 = b(context).C6(ObjectWrapper.E0(context), 15000000);
            if (iBinderC6 == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinderC6.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            return iInterfaceQueryLocalInterface instanceof zzaab ? (zzaab) iInterfaceQueryLocalInterface : new zzaad(iBinderC6);
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e2) {
            zzbad.d("Could not get remote MobileAdsSettingManager.", e2);
            return null;
        }
    }
}
