package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class
public final class zzj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzj> CREATOR = new zzk();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    Bundle f12065f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    Feature[] f12066g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    int f12067h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SafeParcelable.Field
    ConnectionTelemetryConfiguration f12068i;

    public zzj() {
    }

    @SafeParcelable.Constructor
    zzj(@SafeParcelable.Param(id = 1) Bundle bundle, @SafeParcelable.Param(id = 2) Feature[] featureArr, @SafeParcelable.Param(id = 3) int i2, @SafeParcelable.Param(id = 4) ConnectionTelemetryConfiguration connectionTelemetryConfiguration) {
        this.f12065f = bundle;
        this.f12066g = featureArr;
        this.f12067h = i2;
        this.f12068i = connectionTelemetryConfiguration;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.e(parcel, 1, this.f12065f, false);
        SafeParcelWriter.x(parcel, 2, this.f12066g, i2, false);
        SafeParcelWriter.l(parcel, 3, this.f12067h);
        SafeParcelWriter.s(parcel, 4, this.f12068i, i2, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
