package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
@zzard
@SafeParcelable.Class
@SafeParcelable.Reserved
public final class zzvs extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzvs> CREATOR = new zzvt();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    private ParcelFileDescriptor f16862f;

    public zzvs() {
        this(null);
    }

    private final synchronized ParcelFileDescriptor W() {
        return this.f16862f;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.s(parcel, 2, W(), i2, false);
        SafeParcelWriter.b(parcel, iA);
    }

    public final synchronized boolean y() {
        return this.f16862f != null;
    }

    public final synchronized InputStream z() {
        if (this.f16862f == null) {
            return null;
        }
        ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(this.f16862f);
        this.f16862f = null;
        return autoCloseInputStream;
    }

    @SafeParcelable.Constructor
    public zzvs(@SafeParcelable.Param(id = 2) ParcelFileDescriptor parcelFileDescriptor) {
        this.f16862f = parcelFileDescriptor;
    }
}
