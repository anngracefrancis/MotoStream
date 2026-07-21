package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
@SafeParcelable.Class
@SafeParcelable.Reserved
public class GetServiceRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GetServiceRequest> CREATOR = new zzm();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final Scope[] f11970f = new Scope[0];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final Feature[] f11971g = new Feature[0];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.VersionField
    final int f11972h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SafeParcelable.Field
    final int f11973i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @SafeParcelable.Field
    int f11974j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @SafeParcelable.Field
    String f11975k;

    @SafeParcelable.Field
    IBinder l;

    @SafeParcelable.Field
    Scope[] m;

    @SafeParcelable.Field
    Bundle n;

    @SafeParcelable.Field
    Account o;

    @SafeParcelable.Field
    Feature[] p;

    @SafeParcelable.Field
    Feature[] q;

    @SafeParcelable.Field
    boolean r;

    @SafeParcelable.Field
    int s;

    @SafeParcelable.Field
    boolean t;

    @SafeParcelable.Field
    private String u;

    @SafeParcelable.Constructor
    GetServiceRequest(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) int i3, @SafeParcelable.Param(id = 3) int i4, @SafeParcelable.Param(id = 4) String str, @SafeParcelable.Param(id = 5) IBinder iBinder, @SafeParcelable.Param(id = 6) Scope[] scopeArr, @SafeParcelable.Param(id = 7) Bundle bundle, @SafeParcelable.Param(id = 8) Account account, @SafeParcelable.Param(id = 10) Feature[] featureArr, @SafeParcelable.Param(id = 11) Feature[] featureArr2, @SafeParcelable.Param(id = 12) boolean z, @SafeParcelable.Param(id = 13) int i5, @SafeParcelable.Param(id = 14) boolean z2, @SafeParcelable.Param(id = 15) String str2) {
        scopeArr = scopeArr == null ? f11970f : scopeArr;
        bundle = bundle == null ? new Bundle() : bundle;
        featureArr = featureArr == null ? f11971g : featureArr;
        featureArr2 = featureArr2 == null ? f11971g : featureArr2;
        this.f11972h = i2;
        this.f11973i = i3;
        this.f11974j = i4;
        if ("com.google.android.gms".equals(str)) {
            this.f11975k = "com.google.android.gms";
        } else {
            this.f11975k = str;
        }
        if (i2 < 2) {
            this.o = iBinder != null ? AccountAccessor.k0(IAccountAccessor.Stub.P(iBinder)) : null;
        } else {
            this.l = iBinder;
            this.o = account;
        }
        this.m = scopeArr;
        this.n = bundle;
        this.p = featureArr;
        this.q = featureArr2;
        this.r = z;
        this.s = i5;
        this.t = z2;
        this.u = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        zzm.a(this, parcel, i2);
    }

    public final String y() {
        return this.u;
    }
}
