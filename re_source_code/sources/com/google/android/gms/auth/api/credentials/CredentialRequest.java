package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class
public final class CredentialRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<CredentialRequest> CREATOR = new zzg();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    private final int f11463f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    private final boolean f11464g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    private final String[] f11465h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SafeParcelable.Field
    private final CredentialPickerConfig f11466i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @SafeParcelable.Field
    private final CredentialPickerConfig f11467j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @SafeParcelable.Field
    private final boolean f11468k;

    @SafeParcelable.Field
    private final String l;

    @SafeParcelable.Field
    private final String m;

    @SafeParcelable.Field
    private final boolean n;

    public static final class Builder {
        private boolean a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f11469b = false;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f11470c = null;
    }

    @SafeParcelable.Constructor
    CredentialRequest(@SafeParcelable.Param(id = 1000) int i2, @SafeParcelable.Param(id = 1) boolean z, @SafeParcelable.Param(id = 2) String[] strArr, @SafeParcelable.Param(id = 3) CredentialPickerConfig credentialPickerConfig, @SafeParcelable.Param(id = 4) CredentialPickerConfig credentialPickerConfig2, @SafeParcelable.Param(id = 5) boolean z2, @SafeParcelable.Param(id = 6) String str, @SafeParcelable.Param(id = 7) String str2, @SafeParcelable.Param(id = 8) boolean z3) {
        this.f11463f = i2;
        this.f11464g = z;
        this.f11465h = (String[]) Preconditions.k(strArr);
        this.f11466i = credentialPickerConfig == null ? new CredentialPickerConfig.Builder().a() : credentialPickerConfig;
        this.f11467j = credentialPickerConfig2 == null ? new CredentialPickerConfig.Builder().a() : credentialPickerConfig2;
        if (i2 < 3) {
            this.f11468k = true;
            this.l = null;
            this.m = null;
        } else {
            this.f11468k = z2;
            this.l = str;
            this.m = str2;
        }
        this.n = z3;
    }

    public final CredentialPickerConfig W() {
        return this.f11466i;
    }

    public final String Y() {
        return this.m;
    }

    public final String e0() {
        return this.l;
    }

    public final boolean i0() {
        return this.f11468k;
    }

    public final boolean p0() {
        return this.f11464g;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.c(parcel, 1, p0());
        SafeParcelWriter.v(parcel, 2, y(), false);
        SafeParcelWriter.s(parcel, 3, W(), i2, false);
        SafeParcelWriter.s(parcel, 4, z(), i2, false);
        SafeParcelWriter.c(parcel, 5, i0());
        SafeParcelWriter.u(parcel, 6, e0(), false);
        SafeParcelWriter.u(parcel, 7, Y(), false);
        SafeParcelWriter.l(parcel, 1000, this.f11463f);
        SafeParcelWriter.c(parcel, 8, this.n);
        SafeParcelWriter.b(parcel, iA);
    }

    public final String[] y() {
        return this.f11465h;
    }

    public final CredentialPickerConfig z() {
        return this.f11467j;
    }
}
