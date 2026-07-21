package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class
public class GoogleSignInOptionsExtensionParcelable extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GoogleSignInOptionsExtensionParcelable> CREATOR = new zaa();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.VersionField
    private final int f11523f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    private int f11524g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    private Bundle f11525h;

    @SafeParcelable.Constructor
    GoogleSignInOptionsExtensionParcelable(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) int i3, @SafeParcelable.Param(id = 3) Bundle bundle) {
        this.f11523f = i2;
        this.f11524g = i3;
        this.f11525h = bundle;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 1, this.f11523f);
        SafeParcelWriter.l(parcel, 2, y());
        SafeParcelWriter.e(parcel, 3, this.f11525h, false);
        SafeParcelWriter.b(parcel, iA);
    }

    @KeepForSdk
    public int y() {
        return this.f11524g;
    }
}
