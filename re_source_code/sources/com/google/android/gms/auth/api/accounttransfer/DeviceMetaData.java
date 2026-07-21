package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class
public class DeviceMetaData extends AbstractSafeParcelable {
    public static final Parcelable.Creator<DeviceMetaData> CREATOR = new zzv();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.VersionField
    private final int f11422f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    private boolean f11423g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    private long f11424h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SafeParcelable.Field
    private final boolean f11425i;

    @SafeParcelable.Constructor
    DeviceMetaData(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) boolean z, @SafeParcelable.Param(id = 3) long j2, @SafeParcelable.Param(id = 4) boolean z2) {
        this.f11422f = i2;
        this.f11423g = z;
        this.f11424h = j2;
        this.f11425i = z2;
    }

    public boolean W() {
        return this.f11423g;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 1, this.f11422f);
        SafeParcelWriter.c(parcel, 2, W());
        SafeParcelWriter.p(parcel, 3, y());
        SafeParcelWriter.c(parcel, 4, z());
        SafeParcelWriter.b(parcel, iA);
    }

    public long y() {
        return this.f11424h;
    }

    public boolean z() {
        return this.f11425i;
    }
}
