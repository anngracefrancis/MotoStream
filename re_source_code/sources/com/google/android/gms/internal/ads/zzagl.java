package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzagl extends RemoteCreator<zzaeu> {
    @VisibleForTesting
    public zzagl() {
        super("com.google.android.gms.ads.NativeAdViewHolderDelegateCreatorImpl");
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    protected final /* synthetic */ zzaeu a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegateCreator");
        return iInterfaceQueryLocalInterface instanceof zzaeu ? (zzaeu) iInterfaceQueryLocalInterface : new zzaev(iBinder);
    }

    public final zzaer c(View view, HashMap<String, View> map, HashMap<String, View> map2) {
        try {
            IBinder iBinderY5 = b(view.getContext()).y5(ObjectWrapper.E0(view), ObjectWrapper.E0(map), ObjectWrapper.E0(map2));
            if (iBinderY5 == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinderY5.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegate");
            return iInterfaceQueryLocalInterface instanceof zzaer ? (zzaer) iInterfaceQueryLocalInterface : new zzaet(iBinderY5);
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e2) {
            zzbad.d("Could not create remote NativeAdViewHolderDelegate.", e2);
            return null;
        }
    }
}
