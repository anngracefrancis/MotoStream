package com.google.android.gms.common.internal;

import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.base.zac;

/* JADX INFO: loaded from: classes2.dex */
public interface IResolveAccountCallbacks extends IInterface {

    public static abstract class Stub extends com.google.android.gms.internal.base.zab implements IResolveAccountCallbacks {

        public static class Proxy extends com.google.android.gms.internal.base.zaa implements IResolveAccountCallbacks {
        }

        public Stub() {
            super("com.google.android.gms.common.internal.IResolveAccountCallbacks");
        }

        @Override // com.google.android.gms.internal.base.zab
        protected boolean E3(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 != 2) {
                return false;
            }
            d6((ResolveAccountResponse) zac.b(parcel, ResolveAccountResponse.CREATOR));
            parcel2.writeNoException();
            return true;
        }
    }

    void d6(ResolveAccountResponse resolveAccountResponse) throws RemoteException;
}
