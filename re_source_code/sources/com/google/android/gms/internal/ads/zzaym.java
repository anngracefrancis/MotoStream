package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
@zzard
@SafeParcelable.Class
public final class zzaym extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaym> CREATOR = new zzayo();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f14279f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f14280g;

    @SafeParcelable.Constructor
    zzaym(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) int i2) {
        this.f14279f = str == null ? HttpUrl.FRAGMENT_ENCODE_SET : str;
        this.f14280g = i2;
    }

    public static zzaym y(Throwable th, int i2) {
        return new zzaym(th.getMessage(), i2);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, this.f14279f, false);
        SafeParcelWriter.l(parcel, 2, this.f14280g);
        SafeParcelWriter.b(parcel, iA);
    }
}
