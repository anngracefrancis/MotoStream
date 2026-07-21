package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class
public final class zzkj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzkj> CREATOR = new zzki();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    private final int f18223f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f18224g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    public final long f18225h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SafeParcelable.Field
    public final Long f18226i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @SafeParcelable.Field
    private final Float f18227j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f18228k;

    @SafeParcelable.Field
    public final String l;

    @SafeParcelable.Field
    public final Double m;

    zzkj(m7 m7Var) {
        this(m7Var.f17873c, m7Var.f17874d, m7Var.f17875e, m7Var.f17872b);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 1, this.f18223f);
        SafeParcelWriter.u(parcel, 2, this.f18224g, false);
        SafeParcelWriter.p(parcel, 3, this.f18225h);
        SafeParcelWriter.q(parcel, 4, this.f18226i, false);
        SafeParcelWriter.j(parcel, 5, null, false);
        SafeParcelWriter.u(parcel, 6, this.f18228k, false);
        SafeParcelWriter.u(parcel, 7, this.l, false);
        SafeParcelWriter.h(parcel, 8, this.m, false);
        SafeParcelWriter.b(parcel, iA);
    }

    public final Object y() {
        Long l = this.f18226i;
        if (l != null) {
            return l;
        }
        Double d2 = this.m;
        if (d2 != null) {
            return d2;
        }
        String str = this.f18228k;
        if (str != null) {
            return str;
        }
        return null;
    }

    zzkj(String str, long j2, Object obj, String str2) {
        Preconditions.g(str);
        this.f18223f = 2;
        this.f18224g = str;
        this.f18225h = j2;
        this.l = str2;
        if (obj == null) {
            this.f18226i = null;
            this.f18227j = null;
            this.m = null;
            this.f18228k = null;
            return;
        }
        if (obj instanceof Long) {
            this.f18226i = (Long) obj;
            this.f18227j = null;
            this.m = null;
            this.f18228k = null;
            return;
        }
        if (obj instanceof String) {
            this.f18226i = null;
            this.f18227j = null;
            this.m = null;
            this.f18228k = (String) obj;
            return;
        }
        if (!(obj instanceof Double)) {
            throw new IllegalArgumentException("User attribute given of un-supported type");
        }
        this.f18226i = null;
        this.f18227j = null;
        this.m = (Double) obj;
        this.f18228k = null;
    }

    zzkj(String str, long j2, String str2) {
        Preconditions.g(str);
        this.f18223f = 2;
        this.f18224g = str;
        this.f18225h = 0L;
        this.f18226i = null;
        this.f18227j = null;
        this.m = null;
        this.f18228k = null;
        this.l = null;
    }

    @SafeParcelable.Constructor
    zzkj(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) long j2, @SafeParcelable.Param(id = 4) Long l, @SafeParcelable.Param(id = 5) Float f2, @SafeParcelable.Param(id = 6) String str2, @SafeParcelable.Param(id = 7) String str3, @SafeParcelable.Param(id = 8) Double d2) {
        this.f18223f = i2;
        this.f18224g = str;
        this.f18225h = j2;
        this.f18226i = l;
        this.f18227j = null;
        if (i2 == 1) {
            this.m = f2 != null ? Double.valueOf(f2.doubleValue()) : null;
        } else {
            this.m = d2;
        }
        this.f18228k = str2;
        this.l = str3;
    }
}
