package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes2.dex */
@ShowFirstParty
@SafeParcelable.Class
public final class zam extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zam> CREATOR = new zaj();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.VersionField
    private final int f12136f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    final String f12137g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    final FastJsonResponse.Field<?, ?> f12138h;

    @SafeParcelable.Constructor
    zam(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) FastJsonResponse.Field<?, ?> field) {
        this.f12136f = i2;
        this.f12137g = str;
        this.f12138h = field;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 1, this.f12136f);
        SafeParcelWriter.u(parcel, 2, this.f12137g, false);
        SafeParcelWriter.s(parcel, 3, this.f12138h, i2, false);
        SafeParcelWriter.b(parcel, iA);
    }

    zam(String str, FastJsonResponse.Field<?, ?> field) {
        this.f12136f = 1;
        this.f12137g = str;
        this.f12138h = field;
    }
}
