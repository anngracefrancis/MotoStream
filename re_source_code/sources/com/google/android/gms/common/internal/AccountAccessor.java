package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public class AccountAccessor extends IAccountAccessor.Stub {
    @KeepForSdk
    public static Account k0(IAccountAccessor iAccountAccessor) {
        Account accountB = null;
        if (iAccountAccessor != null) {
            long jClearCallingIdentity = Binder.clearCallingIdentity();
            try {
                try {
                    accountB = iAccountAccessor.b();
                } catch (RemoteException unused) {
                    Log.w("AccountAccessor", "Remote account accessor probably died");
                }
            } finally {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
            }
        }
        return accountB;
    }

    @Override // com.google.android.gms.common.internal.IAccountAccessor
    public final Account b() {
        throw null;
    }

    public final boolean equals(Object obj) {
        throw null;
    }
}
