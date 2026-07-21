package com.google.android.gms.internal.p000authapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class
@SafeParcelable.Reserved
public final class zzs extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzs> CREATOR = new zzt();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    private final Credential f17023f;

    @SafeParcelable.Constructor
    public zzs(@SafeParcelable.Param(id = 1) Credential credential) {
        this.f17023f = credential;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.s(parcel, 1, this.f17023f, i2, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
