package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class
public final class Scope extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new zza();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.VersionField
    final int f11685f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    private final String f11686g;

    @SafeParcelable.Constructor
    Scope(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) String str) {
        Preconditions.h(str, "scopeUri must not be null or empty");
        this.f11685f = i2;
        this.f11686g = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Scope) {
            return this.f11686g.equals(((Scope) obj).f11686g);
        }
        return false;
    }

    public int hashCode() {
        return this.f11686g.hashCode();
    }

    public String toString() {
        return this.f11686g;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 1, this.f11685f);
        SafeParcelWriter.u(parcel, 2, y(), false);
        SafeParcelWriter.b(parcel, iA);
    }

    @KeepForSdk
    public String y() {
        return this.f11686g;
    }

    public Scope(String str) {
        this(1, str);
    }
}
