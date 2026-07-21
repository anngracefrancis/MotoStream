package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class
public class ResolveAccountResponse extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ResolveAccountResponse> CREATOR = new zan();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.VersionField
    private final int f11998f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    private IBinder f11999g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    private ConnectionResult f12000h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SafeParcelable.Field
    private boolean f12001i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @SafeParcelable.Field
    private boolean f12002j;

    @SafeParcelable.Constructor
    ResolveAccountResponse(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) IBinder iBinder, @SafeParcelable.Param(id = 3) ConnectionResult connectionResult, @SafeParcelable.Param(id = 4) boolean z, @SafeParcelable.Param(id = 5) boolean z2) {
        this.f11998f = i2;
        this.f11999g = iBinder;
        this.f12000h = connectionResult;
        this.f12001i = z;
        this.f12002j = z2;
    }

    public boolean W() {
        return this.f12001i;
    }

    public boolean Y() {
        return this.f12002j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResolveAccountResponse)) {
            return false;
        }
        ResolveAccountResponse resolveAccountResponse = (ResolveAccountResponse) obj;
        return this.f12000h.equals(resolveAccountResponse.f12000h) && y().equals(resolveAccountResponse.y());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 1, this.f11998f);
        SafeParcelWriter.k(parcel, 2, this.f11999g, false);
        SafeParcelWriter.s(parcel, 3, z(), i2, false);
        SafeParcelWriter.c(parcel, 4, W());
        SafeParcelWriter.c(parcel, 5, Y());
        SafeParcelWriter.b(parcel, iA);
    }

    public IAccountAccessor y() {
        return IAccountAccessor.Stub.P(this.f11999g);
    }

    public ConnectionResult z() {
        return this.f12000h;
    }
}
