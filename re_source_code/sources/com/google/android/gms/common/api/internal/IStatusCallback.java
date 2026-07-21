package com.google.android.gms.common.api.internal;

import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes2.dex */
public interface IStatusCallback extends IInterface {

    public static abstract class Stub extends com.google.android.gms.internal.base.zab implements IStatusCallback {

        public static class zaa extends com.google.android.gms.internal.base.zaa implements IStatusCallback {
        }

        public Stub() {
            super("com.google.android.gms.common.api.internal.IStatusCallback");
        }

        @Override // com.google.android.gms.internal.base.zab
        protected boolean E3(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 != 1) {
                return false;
            }
            p2((Status) com.google.android.gms.internal.base.zac.b(parcel, Status.CREATOR));
            return true;
        }
    }

    void p2(Status status) throws RemoteException;
}
