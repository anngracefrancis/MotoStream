package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class
public class SignInButtonConfig extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SignInButtonConfig> CREATOR = new zao();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.VersionField
    private final int f12010f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    private final int f12011g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    private final int f12012h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SafeParcelable.Field
    @Deprecated
    private final Scope[] f12013i;

    @SafeParcelable.Constructor
    SignInButtonConfig(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) int i3, @SafeParcelable.Param(id = 3) int i4, @SafeParcelable.Param(id = 4) Scope[] scopeArr) {
        this.f12010f = i2;
        this.f12011g = i3;
        this.f12012h = i4;
        this.f12013i = scopeArr;
    }

    @Deprecated
    public Scope[] W() {
        return this.f12013i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 1, this.f12010f);
        SafeParcelWriter.l(parcel, 2, y());
        SafeParcelWriter.l(parcel, 3, z());
        SafeParcelWriter.x(parcel, 4, W(), i2, false);
        SafeParcelWriter.b(parcel, iA);
    }

    public int y() {
        return this.f12011g;
    }

    public int z() {
        return this.f12012h;
    }

    public SignInButtonConfig(int i2, int i3, Scope[] scopeArr) {
        this(1, i2, i3, null);
    }
}
