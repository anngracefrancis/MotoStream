package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.common.zza;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzv extends zza implements IAccountAccessor {
    zzv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
    }

    @Override // com.google.android.gms.common.internal.IAccountAccessor
    public final Account b() throws RemoteException {
        Parcel parcelH = H(2, k0());
        Account account = (Account) com.google.android.gms.internal.common.zzc.a(parcelH, Account.CREATOR);
        parcelH.recycle();
        return account;
    }
}
