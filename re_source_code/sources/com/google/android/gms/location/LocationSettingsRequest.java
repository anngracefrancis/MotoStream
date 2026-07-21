package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class
@SafeParcelable.Reserved
public final class LocationSettingsRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<LocationSettingsRequest> CREATOR = new zzag();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    private final List<LocationRequest> f17647f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    private final boolean f17648g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    private final boolean f17649h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SafeParcelable.Field
    private zzae f17650i;

    public static final class Builder {
        private final ArrayList<LocationRequest> a = new ArrayList<>();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f17651b = false;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f17652c = false;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private zzae f17653d = null;
    }

    @SafeParcelable.Constructor
    LocationSettingsRequest(@SafeParcelable.Param(id = 1) List<LocationRequest> list, @SafeParcelable.Param(id = 2) boolean z, @SafeParcelable.Param(id = 3) boolean z2, @SafeParcelable.Param(id = 5) zzae zzaeVar) {
        this.f17647f = list;
        this.f17648g = z;
        this.f17649h = z2;
        this.f17650i = zzaeVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.y(parcel, 1, Collections.unmodifiableList(this.f17647f), false);
        SafeParcelWriter.c(parcel, 2, this.f17648g);
        SafeParcelWriter.c(parcel, 3, this.f17649h);
        SafeParcelWriter.s(parcel, 5, this.f17650i, i2, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
