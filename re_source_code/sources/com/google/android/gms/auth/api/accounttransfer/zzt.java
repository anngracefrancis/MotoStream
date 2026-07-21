package com.google.android.gms.auth.api.accounttransfer;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.internal.auth.zzaz;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class
public class zzt extends zzaz {
    public static final Parcelable.Creator<zzt> CREATOR = new zzu();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final HashMap<String, FastJsonResponse.Field<?, ?>> f11444f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Indicator
    private final Set<Integer> f11445g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.VersionField
    private final int f11446h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SafeParcelable.Field
    private String f11447i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @SafeParcelable.Field
    private int f11448j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @SafeParcelable.Field
    private byte[] f11449k;

    @SafeParcelable.Field
    private PendingIntent l;

    @SafeParcelable.Field
    private DeviceMetaData m;

    static {
        HashMap<String, FastJsonResponse.Field<?, ?>> map = new HashMap<>();
        f11444f = map;
        map.put("accountType", FastJsonResponse.Field.e0("accountType", 2));
        map.put("status", FastJsonResponse.Field.Y("status", 3));
        map.put("transferBytes", FastJsonResponse.Field.y("transferBytes", 4));
    }

    @SafeParcelable.Constructor
    zzt(@SafeParcelable.Indicator Set<Integer> set, @SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) int i3, @SafeParcelable.Param(id = 4) byte[] bArr, @SafeParcelable.Param(id = 5) PendingIntent pendingIntent, @SafeParcelable.Param(id = 6) DeviceMetaData deviceMetaData) {
        this.f11445g = set;
        this.f11446h = i2;
        this.f11447i = str;
        this.f11448j = i3;
        this.f11449k = bArr;
        this.l = pendingIntent;
        this.m = deviceMetaData;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public /* synthetic */ Map a() {
        return f11444f;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected Object b(FastJsonResponse.Field field) {
        int iP0 = field.p0();
        if (iP0 == 1) {
            return Integer.valueOf(this.f11446h);
        }
        if (iP0 == 2) {
            return this.f11447i;
        }
        if (iP0 == 3) {
            return Integer.valueOf(this.f11448j);
        }
        if (iP0 == 4) {
            return this.f11449k;
        }
        int iP1 = field.p0();
        StringBuilder sb = new StringBuilder(37);
        sb.append("Unknown SafeParcelable id=");
        sb.append(iP1);
        throw new IllegalStateException(sb.toString());
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected boolean d(FastJsonResponse.Field field) {
        return this.f11445g.contains(Integer.valueOf(field.p0()));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        Set<Integer> set = this.f11445g;
        if (set.contains(1)) {
            SafeParcelWriter.l(parcel, 1, this.f11446h);
        }
        if (set.contains(2)) {
            SafeParcelWriter.u(parcel, 2, this.f11447i, true);
        }
        if (set.contains(3)) {
            SafeParcelWriter.l(parcel, 3, this.f11448j);
        }
        if (set.contains(4)) {
            SafeParcelWriter.f(parcel, 4, this.f11449k, true);
        }
        if (set.contains(5)) {
            SafeParcelWriter.s(parcel, 5, this.l, i2, true);
        }
        if (set.contains(6)) {
            SafeParcelWriter.s(parcel, 6, this.m, i2, true);
        }
        SafeParcelWriter.b(parcel, iA);
    }

    public zzt() {
        this.f11445g = new c.e.b(3);
        this.f11446h = 1;
    }
}
