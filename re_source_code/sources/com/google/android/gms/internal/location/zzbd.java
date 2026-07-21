package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class
@SafeParcelable.Reserved
public final class zzbd extends AbstractSafeParcelable {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    private LocationRequest f17094g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    private List<ClientIdentity> f17095h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SafeParcelable.Field
    private String f17096i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @SafeParcelable.Field
    private boolean f17097j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @SafeParcelable.Field
    private boolean f17098k;

    @SafeParcelable.Field
    private boolean l;

    @SafeParcelable.Field
    private String m;
    private boolean n = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final List<ClientIdentity> f17093f = Collections.emptyList();
    public static final Parcelable.Creator<zzbd> CREATOR = new zzbe();

    @SafeParcelable.Constructor
    zzbd(@SafeParcelable.Param(id = 1) LocationRequest locationRequest, @SafeParcelable.Param(id = 5) List<ClientIdentity> list, @SafeParcelable.Param(id = 6) String str, @SafeParcelable.Param(id = 7) boolean z, @SafeParcelable.Param(id = 8) boolean z2, @SafeParcelable.Param(id = 9) boolean z3, @SafeParcelable.Param(id = 10) String str2) {
        this.f17094g = locationRequest;
        this.f17095h = list;
        this.f17096i = str;
        this.f17097j = z;
        this.f17098k = z2;
        this.l = z3;
        this.m = str2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzbd)) {
            return false;
        }
        zzbd zzbdVar = (zzbd) obj;
        return Objects.a(this.f17094g, zzbdVar.f17094g) && Objects.a(this.f17095h, zzbdVar.f17095h) && Objects.a(this.f17096i, zzbdVar.f17096i) && this.f17097j == zzbdVar.f17097j && this.f17098k == zzbdVar.f17098k && this.l == zzbdVar.l && Objects.a(this.m, zzbdVar.m);
    }

    public final int hashCode() {
        return this.f17094g.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f17094g);
        if (this.f17096i != null) {
            sb.append(" tag=");
            sb.append(this.f17096i);
        }
        if (this.m != null) {
            sb.append(" moduleId=");
            sb.append(this.m);
        }
        sb.append(" hideAppOps=");
        sb.append(this.f17097j);
        sb.append(" clients=");
        sb.append(this.f17095h);
        sb.append(" forceCoarseLocation=");
        sb.append(this.f17098k);
        if (this.l) {
            sb.append(" exemptFromBackgroundThrottle");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.s(parcel, 1, this.f17094g, i2, false);
        SafeParcelWriter.y(parcel, 5, this.f17095h, false);
        SafeParcelWriter.u(parcel, 6, this.f17096i, false);
        SafeParcelWriter.c(parcel, 7, this.f17097j);
        SafeParcelWriter.c(parcel, 8, this.f17098k);
        SafeParcelWriter.c(parcel, 9, this.l);
        SafeParcelWriter.u(parcel, 10, this.m, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
