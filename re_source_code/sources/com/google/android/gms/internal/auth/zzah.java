package com.google.android.gms.internal.auth;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class
public final class zzah extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzah> CREATOR = new zzai();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.VersionField
    private final int f17035f = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    private final String f17036g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    private final PendingIntent f17037h;

    @SafeParcelable.Constructor
    zzah(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) PendingIntent pendingIntent) {
        this.f17036g = (String) Preconditions.k(str);
        this.f17037h = (PendingIntent) Preconditions.k(pendingIntent);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 1, this.f17035f);
        SafeParcelWriter.u(parcel, 2, this.f17036g, false);
        SafeParcelWriter.s(parcel, 3, this.f17037h, i2, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
