package com.google.android.gms.common.server;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
@SafeParcelable.Class
public class FavaDiagnosticsEntity extends AbstractSafeParcelable implements ReflectedParcelable {

    @KeepForSdk
    public static final Parcelable.Creator<FavaDiagnosticsEntity> CREATOR = new zaa();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.VersionField
    private final int f12095f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    private final String f12096g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    private final int f12097h;

    @SafeParcelable.Constructor
    public FavaDiagnosticsEntity(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) int i3) {
        this.f12095f = i2;
        this.f12096g = str;
        this.f12097h = i3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 1, this.f12095f);
        SafeParcelWriter.u(parcel, 2, this.f12096g, false);
        SafeParcelWriter.l(parcel, 3, this.f12097h);
        SafeParcelWriter.b(parcel, iA);
    }
}
