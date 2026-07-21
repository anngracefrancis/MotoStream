package com.google.android.gms.auth.api.proxy;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes2.dex */
@KeepForSdkWithMembers
@SafeParcelable.Class
public class ProxyResponse extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ProxyResponse> CREATOR = new zzb();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.VersionField
    private final int f11489f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f11490g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    public final PendingIntent f11491h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f11492i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @SafeParcelable.Field
    private final Bundle f11493j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @SafeParcelable.Field
    public final byte[] f11494k;

    @SafeParcelable.Constructor
    ProxyResponse(@SafeParcelable.Param(id = 1000) int i2, @SafeParcelable.Param(id = 1) int i3, @SafeParcelable.Param(id = 2) PendingIntent pendingIntent, @SafeParcelable.Param(id = 3) int i4, @SafeParcelable.Param(id = 4) Bundle bundle, @SafeParcelable.Param(id = 5) byte[] bArr) {
        this.f11489f = i2;
        this.f11490g = i3;
        this.f11492i = i4;
        this.f11493j = bundle;
        this.f11494k = bArr;
        this.f11491h = pendingIntent;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 1, this.f11490g);
        SafeParcelWriter.s(parcel, 2, this.f11491h, i2, false);
        SafeParcelWriter.l(parcel, 3, this.f11492i);
        SafeParcelWriter.e(parcel, 4, this.f11493j, false);
        SafeParcelWriter.f(parcel, 5, this.f11494k, false);
        SafeParcelWriter.l(parcel, 1000, this.f11489f);
        SafeParcelWriter.b(parcel, iA);
    }
}
