package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes2.dex */
public final class zaa implements Parcelable.Creator<AuthAccountRequest> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AuthAccountRequest createFromParcel(Parcel parcel) {
        int iL = SafeParcelReader.L(parcel);
        IBinder iBinderD = null;
        Scope[] scopeArr = null;
        Integer numF = null;
        Integer numF2 = null;
        Account account = null;
        int iE = 0;
        while (parcel.dataPosition() < iL) {
            int iC = SafeParcelReader.C(parcel);
            switch (SafeParcelReader.v(iC)) {
                case 1:
                    iE = SafeParcelReader.E(parcel, iC);
                    break;
                case 2:
                    iBinderD = SafeParcelReader.D(parcel, iC);
                    break;
                case 3:
                    scopeArr = (Scope[]) SafeParcelReader.s(parcel, iC, Scope.CREATOR);
                    break;
                case 4:
                    numF = SafeParcelReader.F(parcel, iC);
                    break;
                case 5:
                    numF2 = SafeParcelReader.F(parcel, iC);
                    break;
                case 6:
                    account = (Account) SafeParcelReader.o(parcel, iC, Account.CREATOR);
                    break;
                default:
                    SafeParcelReader.K(parcel, iC);
                    break;
            }
        }
        SafeParcelReader.u(parcel, iL);
        return new AuthAccountRequest(iE, iBinderD, scopeArr, numF, numF2, account);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AuthAccountRequest[] newArray(int i2) {
        return new AuthAccountRequest[i2];
    }
}
