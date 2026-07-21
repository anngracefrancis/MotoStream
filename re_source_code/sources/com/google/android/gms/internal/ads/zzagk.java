package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.widget.FrameLayout;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzagk extends RemoteCreator<zzaep> {
    @VisibleForTesting
    public zzagk() {
        super("com.google.android.gms.ads.NativeAdViewDelegateCreatorImpl");
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    protected final /* synthetic */ zzaep a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
        return iInterfaceQueryLocalInterface instanceof zzaep ? (zzaep) iInterfaceQueryLocalInterface : new zzaeq(iBinder);
    }

    public final zzaem c(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        try {
            IBinder iBinderT3 = b(context).t3(ObjectWrapper.E0(context), ObjectWrapper.E0(frameLayout), ObjectWrapper.E0(frameLayout2), 15000000);
            if (iBinderT3 == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinderT3.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
            return iInterfaceQueryLocalInterface instanceof zzaem ? (zzaem) iInterfaceQueryLocalInterface : new zzaeo(iBinderT3);
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e2) {
            zzbad.d("Could not create remote NativeAdViewDelegate.", e2);
            return null;
        }
    }
}
