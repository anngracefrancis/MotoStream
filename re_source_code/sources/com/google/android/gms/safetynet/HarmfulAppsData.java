package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class
@SafeParcelable.Reserved
public class HarmfulAppsData extends AbstractSafeParcelable {
    public static final Parcelable.Creator<HarmfulAppsData> CREATOR = new zzc();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f18250f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    public final byte[] f18251g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f18252h;

    @SafeParcelable.Constructor
    public HarmfulAppsData(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) byte[] bArr, @SafeParcelable.Param(id = 4) int i2) {
        this.f18250f = str;
        this.f18251g = bArr;
        this.f18252h = i2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 2, this.f18250f, false);
        SafeParcelWriter.f(parcel, 3, this.f18251g, false);
        SafeParcelWriter.l(parcel, 4, this.f18252h);
        SafeParcelWriter.b(parcel, iA);
    }
}
