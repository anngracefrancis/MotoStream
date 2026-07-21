package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@ShowFirstParty
@SafeParcelable.Class
public final class zal extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zal> CREATOR = new zao();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.VersionField
    private final int f12133f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    final String f12134g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    final ArrayList<zam> f12135h;

    @SafeParcelable.Constructor
    zal(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) ArrayList<zam> arrayList) {
        this.f12133f = i2;
        this.f12134g = str;
        this.f12135h = arrayList;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 1, this.f12133f);
        SafeParcelWriter.u(parcel, 2, this.f12134g, false);
        SafeParcelWriter.y(parcel, 3, this.f12135h, false);
        SafeParcelWriter.b(parcel, iA);
    }

    zal(String str, Map<String, FastJsonResponse.Field<?, ?>> map) {
        ArrayList<zam> arrayList;
        this.f12133f = 1;
        this.f12134g = str;
        if (map == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList<>();
            for (String str2 : map.keySet()) {
                arrayList.add(new zam(str2, map.get(str2)));
            }
        }
        this.f12135h = arrayList;
    }
}
