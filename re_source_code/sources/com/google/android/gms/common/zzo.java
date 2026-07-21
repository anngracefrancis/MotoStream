package com.google.android.gms.common;

import android.content.Context;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class
public final class zzo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzo> CREATOR = new zzp();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    private final String f12176f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    private final boolean f12177g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    private final boolean f12178h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SafeParcelable.Field
    private final Context f12179i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @SafeParcelable.Field
    private final boolean f12180j;

    @SafeParcelable.Constructor
    zzo(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) boolean z, @SafeParcelable.Param(id = 3) boolean z2, @SafeParcelable.Param(id = 4) IBinder iBinder, @SafeParcelable.Param(id = 5) boolean z3) {
        this.f12176f = str;
        this.f12177g = z;
        this.f12178h = z2;
        this.f12179i = (Context) ObjectWrapper.k0(IObjectWrapper.Stub.P(iBinder));
        this.f12180j = z3;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [android.os.IBinder, com.google.android.gms.dynamic.IObjectWrapper] */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, this.f12176f, false);
        SafeParcelWriter.c(parcel, 2, this.f12177g);
        SafeParcelWriter.c(parcel, 3, this.f12178h);
        SafeParcelWriter.k(parcel, 4, ObjectWrapper.E0(this.f12179i), false);
        SafeParcelWriter.c(parcel, 5, this.f12180j);
        SafeParcelWriter.b(parcel, iA);
    }
}
