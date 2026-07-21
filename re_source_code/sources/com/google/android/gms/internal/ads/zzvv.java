package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
@zzard
@SafeParcelable.Class
@SafeParcelable.Reserved
public final class zzvv extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzvv> CREATOR = new zzvw();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f16863f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    private final long f16864g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    private final String f16865h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SafeParcelable.Field
    private final String f16866i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @SafeParcelable.Field
    private final String f16867j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @SafeParcelable.Field
    private final Bundle f16868k;

    @SafeParcelable.Field
    public final boolean l;

    @SafeParcelable.Field
    public long m;

    @SafeParcelable.Constructor
    zzvv(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) long j2, @SafeParcelable.Param(id = 4) String str2, @SafeParcelable.Param(id = 5) String str3, @SafeParcelable.Param(id = 6) String str4, @SafeParcelable.Param(id = 7) Bundle bundle, @SafeParcelable.Param(id = 8) boolean z, @SafeParcelable.Param(id = 9) long j3) {
        this.f16863f = str;
        this.f16864g = j2;
        this.f16865h = str2 == null ? HttpUrl.FRAGMENT_ENCODE_SET : str2;
        this.f16866i = str3 == null ? HttpUrl.FRAGMENT_ENCODE_SET : str3;
        this.f16867j = str4 == null ? HttpUrl.FRAGMENT_ENCODE_SET : str4;
        this.f16868k = bundle == null ? new Bundle() : bundle;
        this.l = z;
        this.m = j3;
    }

    public static zzvv y(String str) {
        return z(Uri.parse(str));
    }

    public static zzvv z(Uri uri) {
        try {
            if (!"gcache".equals(uri.getScheme())) {
                return null;
            }
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments.size() != 2) {
                int size = pathSegments.size();
                StringBuilder sb = new StringBuilder(62);
                sb.append("Expected 2 path parts for namespace and id, found :");
                sb.append(size);
                zzbad.i(sb.toString());
                return null;
            }
            String str = pathSegments.get(0);
            String str2 = pathSegments.get(1);
            String host = uri.getHost();
            String queryParameter = uri.getQueryParameter("url");
            boolean zEquals = "1".equals(uri.getQueryParameter("read_only"));
            String queryParameter2 = uri.getQueryParameter("expiration");
            long j2 = queryParameter2 == null ? 0L : Long.parseLong(queryParameter2);
            Bundle bundle = new Bundle();
            zzk.zzli();
            for (String str3 : uri.getQueryParameterNames()) {
                if (str3.startsWith("tag.")) {
                    bundle.putString(str3.substring(4), uri.getQueryParameter(str3));
                }
            }
            return new zzvv(queryParameter, j2, host, str, str2, bundle, zEquals, 0L);
        } catch (NullPointerException | NumberFormatException e2) {
            zzbad.d("Unable to parse Uri into cache offering.", e2);
            return null;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 2, this.f16863f, false);
        SafeParcelWriter.p(parcel, 3, this.f16864g);
        SafeParcelWriter.u(parcel, 4, this.f16865h, false);
        SafeParcelWriter.u(parcel, 5, this.f16866i, false);
        SafeParcelWriter.u(parcel, 6, this.f16867j, false);
        SafeParcelWriter.e(parcel, 7, this.f16868k, false);
        SafeParcelWriter.c(parcel, 8, this.l);
        SafeParcelWriter.p(parcel, 9, this.m);
        SafeParcelWriter.b(parcel, iA);
    }
}
