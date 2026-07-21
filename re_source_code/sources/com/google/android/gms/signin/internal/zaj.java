package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class
public final class zaj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zaj> CREATOR = new zak();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.VersionField
    private final int f18289f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    private final ConnectionResult f18290g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    private final ResolveAccountResponse f18291h;

    @SafeParcelable.Constructor
    zaj(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) ConnectionResult connectionResult, @SafeParcelable.Param(id = 3) ResolveAccountResponse resolveAccountResponse) {
        this.f18289f = i2;
        this.f18290g = connectionResult;
        this.f18291h = resolveAccountResponse;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 1, this.f18289f);
        SafeParcelWriter.s(parcel, 2, this.f18290g, i2, false);
        SafeParcelWriter.s(parcel, 3, this.f18291h, i2, false);
        SafeParcelWriter.b(parcel, iA);
    }

    public final ConnectionResult y() {
        return this.f18290g;
    }

    public final ResolveAccountResponse z() {
        return this.f18291h;
    }

    public zaj(int i2) {
        this(new ConnectionResult(8, null), null);
    }

    private zaj(ConnectionResult connectionResult, ResolveAccountResponse resolveAccountResponse) {
        this(1, connectionResult, null);
    }
}
