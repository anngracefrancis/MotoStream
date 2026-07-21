package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class
public final class zzaf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaf> CREATOR = new zzag();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.VersionField
    private final int f17032f = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    private final String f17033g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    private final byte[] f17034h;

    @SafeParcelable.Constructor
    zzaf(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) byte[] bArr) {
        this.f17033g = (String) Preconditions.k(str);
        this.f17034h = (byte[]) Preconditions.k(bArr);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 1, this.f17032f);
        SafeParcelWriter.u(parcel, 2, this.f17033g, false);
        SafeParcelWriter.f(parcel, 3, this.f17034h, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
