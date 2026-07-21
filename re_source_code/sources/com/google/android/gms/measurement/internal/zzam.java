package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class
@SafeParcelable.Reserved
public final class zzam extends AbstractSafeParcelable implements Iterable<String> {
    public static final Parcelable.Creator<zzam> CREATOR = new zzao();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    private final Bundle f18066f;

    @SafeParcelable.Constructor
    zzam(@SafeParcelable.Param(id = 2) Bundle bundle) {
        this.f18066f = bundle;
    }

    final Object W(String str) {
        return this.f18066f.get(str);
    }

    public final Bundle Y() {
        return new Bundle(this.f18066f);
    }

    final Long e0(String str) {
        return Long.valueOf(this.f18066f.getLong(str));
    }

    final Double i0(String str) {
        return Double.valueOf(this.f18066f.getDouble(str));
    }

    @Override // java.lang.Iterable
    public final Iterator<String> iterator() {
        return new i(this);
    }

    final String p0(String str) {
        return this.f18066f.getString(str);
    }

    public final String toString() {
        return this.f18066f.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.e(parcel, 2, Y(), false);
        SafeParcelWriter.b(parcel, iA);
    }

    public final int y() {
        return this.f18066f.size();
    }
}
