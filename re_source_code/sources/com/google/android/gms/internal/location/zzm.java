package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.location.zzj;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class
public final class zzm extends AbstractSafeParcelable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    private zzj f17115h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SafeParcelable.Field
    private List<ClientIdentity> f17116i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @SafeParcelable.Field
    private String f17117j;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @VisibleForTesting
    static final List<ClientIdentity> f17113f = Collections.emptyList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final zzj f17114g = new zzj();
    public static final Parcelable.Creator<zzm> CREATOR = new zzn();

    @SafeParcelable.Constructor
    zzm(@SafeParcelable.Param(id = 1) zzj zzjVar, @SafeParcelable.Param(id = 2) List<ClientIdentity> list, @SafeParcelable.Param(id = 3) String str) {
        this.f17115h = zzjVar;
        this.f17116i = list;
        this.f17117j = str;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzm)) {
            return false;
        }
        zzm zzmVar = (zzm) obj;
        return Objects.a(this.f17115h, zzmVar.f17115h) && Objects.a(this.f17116i, zzmVar.f17116i) && Objects.a(this.f17117j, zzmVar.f17117j);
    }

    public final int hashCode() {
        return this.f17115h.hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.s(parcel, 1, this.f17115h, i2, false);
        SafeParcelWriter.y(parcel, 2, this.f17116i, false);
        SafeParcelWriter.u(parcel, 3, this.f17117j, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
