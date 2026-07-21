package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzaqf extends RemoteCreator<zzaqj> {
    public zzaqf() {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    protected final /* synthetic */ zzaqj a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
        return iInterfaceQueryLocalInterface instanceof zzaqj ? (zzaqj) iInterfaceQueryLocalInterface : new zzaqk(iBinder);
    }

    public final zzaqg c(Activity activity) {
        try {
            IBinder iBinderW5 = b(activity).w5(ObjectWrapper.E0(activity));
            if (iBinderW5 == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinderW5.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
            return iInterfaceQueryLocalInterface instanceof zzaqg ? (zzaqg) iInterfaceQueryLocalInterface : new zzaqi(iBinderW5);
        } catch (RemoteException e2) {
            zzbad.d("Could not create remote AdOverlay.", e2);
            return null;
        } catch (RemoteCreator.RemoteCreatorException e3) {
            zzbad.d("Could not create remote AdOverlay.", e3);
            return null;
        }
    }
}
