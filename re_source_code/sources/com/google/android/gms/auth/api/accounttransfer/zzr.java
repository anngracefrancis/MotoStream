package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import cm.aptoide.pt.database.room.RoomInstalled;
import cm.aptoide.pt.downloadmanager.Constants;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.internal.auth.zzaz;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class
public class zzr extends zzaz {
    public static final Parcelable.Creator<zzr> CREATOR = new zzs();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final HashMap<String, FastJsonResponse.Field<?, ?>> f11438f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Indicator
    private final Set<Integer> f11439g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.VersionField
    private final int f11440h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SafeParcelable.Field
    private zzt f11441i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @SafeParcelable.Field
    private String f11442j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @SafeParcelable.Field
    private String f11443k;

    @SafeParcelable.Field
    private String l;

    static {
        HashMap<String, FastJsonResponse.Field<?, ?>> map = new HashMap<>();
        f11438f = map;
        map.put("authenticatorInfo", FastJsonResponse.Field.z("authenticatorInfo", 2, zzt.class));
        map.put(RoomInstalled.SIGNATURE, FastJsonResponse.Field.e0(RoomInstalled.SIGNATURE, 3));
        map.put(Constants.PACKAGE, FastJsonResponse.Field.e0(Constants.PACKAGE, 4));
    }

    public zzr() {
        this.f11439g = new HashSet(3);
        this.f11440h = 1;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public /* synthetic */ Map a() {
        return f11438f;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected Object b(FastJsonResponse.Field field) {
        int iP0 = field.p0();
        if (iP0 == 1) {
            return Integer.valueOf(this.f11440h);
        }
        if (iP0 == 2) {
            return this.f11441i;
        }
        if (iP0 == 3) {
            return this.f11442j;
        }
        if (iP0 == 4) {
            return this.f11443k;
        }
        int iP1 = field.p0();
        StringBuilder sb = new StringBuilder(37);
        sb.append("Unknown SafeParcelable id=");
        sb.append(iP1);
        throw new IllegalStateException(sb.toString());
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected boolean d(FastJsonResponse.Field field) {
        return this.f11439g.contains(Integer.valueOf(field.p0()));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        Set<Integer> set = this.f11439g;
        if (set.contains(1)) {
            SafeParcelWriter.l(parcel, 1, this.f11440h);
        }
        if (set.contains(2)) {
            SafeParcelWriter.s(parcel, 2, this.f11441i, i2, true);
        }
        if (set.contains(3)) {
            SafeParcelWriter.u(parcel, 3, this.f11442j, true);
        }
        if (set.contains(4)) {
            SafeParcelWriter.u(parcel, 4, this.f11443k, true);
        }
        if (set.contains(5)) {
            SafeParcelWriter.u(parcel, 5, this.l, true);
        }
        SafeParcelWriter.b(parcel, iA);
    }

    @SafeParcelable.Constructor
    zzr(@SafeParcelable.Indicator Set<Integer> set, @SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) zzt zztVar, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) String str2, @SafeParcelable.Param(id = 5) String str3) {
        this.f11439g = set;
        this.f11440h = i2;
        this.f11441i = zztVar;
        this.f11442j = str;
        this.f11443k = str2;
        this.l = str3;
    }
}
