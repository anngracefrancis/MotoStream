package com.google.android.gms.location;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class
@SafeParcelable.Reserved
public final class zzal extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzal> CREATOR = new zzam();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    private final List<String> f17673f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    private final PendingIntent f17674g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    private final String f17675h;

    @SafeParcelable.Constructor
    zzal(@SafeParcelable.Param(id = 1) List<String> list, @SafeParcelable.Param(id = 2) PendingIntent pendingIntent, @SafeParcelable.Param(id = 3) String str) {
        this.f17673f = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        this.f17674g = pendingIntent;
        this.f17675h = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.w(parcel, 1, this.f17673f, false);
        SafeParcelWriter.s(parcel, 2, this.f17674g, i2, false);
        SafeParcelWriter.u(parcel, 3, this.f17675h, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
