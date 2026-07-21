package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzm implements Parcelable.Creator {
    static void a(GetServiceRequest getServiceRequest, Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 1, getServiceRequest.f11972h);
        SafeParcelWriter.l(parcel, 2, getServiceRequest.f11973i);
        SafeParcelWriter.l(parcel, 3, getServiceRequest.f11974j);
        SafeParcelWriter.u(parcel, 4, getServiceRequest.f11975k, false);
        SafeParcelWriter.k(parcel, 5, getServiceRequest.l, false);
        SafeParcelWriter.x(parcel, 6, getServiceRequest.m, i2, false);
        SafeParcelWriter.e(parcel, 7, getServiceRequest.n, false);
        SafeParcelWriter.s(parcel, 8, getServiceRequest.o, i2, false);
        SafeParcelWriter.x(parcel, 10, getServiceRequest.p, i2, false);
        SafeParcelWriter.x(parcel, 11, getServiceRequest.q, i2, false);
        SafeParcelWriter.c(parcel, 12, getServiceRequest.r);
        SafeParcelWriter.l(parcel, 13, getServiceRequest.s);
        SafeParcelWriter.c(parcel, 14, getServiceRequest.t);
        SafeParcelWriter.u(parcel, 15, getServiceRequest.y(), false);
        SafeParcelWriter.b(parcel, iA);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iL = SafeParcelReader.L(parcel);
        Scope[] scopeArr = GetServiceRequest.f11970f;
        Bundle bundle = new Bundle();
        Feature[] featureArr = GetServiceRequest.f11971g;
        Feature[] featureArr2 = featureArr;
        String strP = null;
        IBinder iBinderD = null;
        Account account = null;
        String strP2 = null;
        int iE = 0;
        int iE2 = 0;
        int iE3 = 0;
        boolean zW = false;
        int iE4 = 0;
        boolean zW2 = false;
        while (parcel.dataPosition() < iL) {
            int iC = SafeParcelReader.C(parcel);
            switch (SafeParcelReader.v(iC)) {
                case 1:
                    iE = SafeParcelReader.E(parcel, iC);
                    break;
                case 2:
                    iE2 = SafeParcelReader.E(parcel, iC);
                    break;
                case 3:
                    iE3 = SafeParcelReader.E(parcel, iC);
                    break;
                case 4:
                    strP = SafeParcelReader.p(parcel, iC);
                    break;
                case 5:
                    iBinderD = SafeParcelReader.D(parcel, iC);
                    break;
                case 6:
                    scopeArr = (Scope[]) SafeParcelReader.s(parcel, iC, Scope.CREATOR);
                    break;
                case 7:
                    bundle = SafeParcelReader.f(parcel, iC);
                    break;
                case 8:
                    account = (Account) SafeParcelReader.o(parcel, iC, Account.CREATOR);
                    break;
                case 9:
                default:
                    SafeParcelReader.K(parcel, iC);
                    break;
                case 10:
                    featureArr = (Feature[]) SafeParcelReader.s(parcel, iC, Feature.CREATOR);
                    break;
                case 11:
                    featureArr2 = (Feature[]) SafeParcelReader.s(parcel, iC, Feature.CREATOR);
                    break;
                case 12:
                    zW = SafeParcelReader.w(parcel, iC);
                    break;
                case 13:
                    iE4 = SafeParcelReader.E(parcel, iC);
                    break;
                case 14:
                    zW2 = SafeParcelReader.w(parcel, iC);
                    break;
                case 15:
                    strP2 = SafeParcelReader.p(parcel, iC);
                    break;
            }
        }
        SafeParcelReader.u(parcel, iL);
        return new GetServiceRequest(iE, iE2, iE3, strP, iBinderD, scopeArr, bundle, account, featureArr, featureArr2, zW, iE4, zW2, strP2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i2) {
        return new GetServiceRequest[i2];
    }
}
