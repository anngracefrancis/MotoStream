package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class
public final class zah extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zah> CREATOR = new zai();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.VersionField
    private final int f18287f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    private final ResolveAccountRequest f18288g;

    @SafeParcelable.Constructor
    zah(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) ResolveAccountRequest resolveAccountRequest) {
        this.f18287f = i2;
        this.f18288g = resolveAccountRequest;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 1, this.f18287f);
        SafeParcelWriter.s(parcel, 2, this.f18288g, i2, false);
        SafeParcelWriter.b(parcel, iA);
    }

    public zah(ResolveAccountRequest resolveAccountRequest) {
        this(1, resolveAccountRequest);
    }
}
