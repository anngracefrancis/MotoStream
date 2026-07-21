package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;
import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@zzard
@SafeParcelable.Class
@SafeParcelable.Reserved
public final class zzauy extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzauy> CREATOR = new zzauz();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f14176f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f14177g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    public final boolean f14178h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SafeParcelable.Field
    public final boolean f14179i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @SafeParcelable.Field
    public final List<String> f14180j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @SafeParcelable.Field
    public final boolean f14181k;

    @SafeParcelable.Field
    public final boolean l;

    @SafeParcelable.Field
    public final List<String> m;

    @SafeParcelable.Constructor
    public zzauy(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) boolean z, @SafeParcelable.Param(id = 5) boolean z2, @SafeParcelable.Param(id = 6) List<String> list, @SafeParcelable.Param(id = 7) boolean z3, @SafeParcelable.Param(id = 8) boolean z4, @SafeParcelable.Param(id = 9) List<String> list2) {
        this.f14176f = str;
        this.f14177g = str2;
        this.f14178h = z;
        this.f14179i = z2;
        this.f14180j = list;
        this.f14181k = z3;
        this.l = z4;
        this.m = list2 == null ? new ArrayList<>() : list2;
    }

    public static zzauy y(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        return new zzauy(jSONObject.optString("click_string", HttpUrl.FRAGMENT_ENCODE_SET), jSONObject.optString("report_url", HttpUrl.FRAGMENT_ENCODE_SET), jSONObject.optBoolean("rendered_ad_enabled", false), jSONObject.optBoolean("non_malicious_reporting_enabled", false), zzazc.c(jSONObject.optJSONArray("allowed_headers"), null), jSONObject.optBoolean("protection_enabled", false), jSONObject.optBoolean("malicious_reporting_enabled", false), zzazc.c(jSONObject.optJSONArray("webview_permissions"), null));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 2, this.f14176f, false);
        SafeParcelWriter.u(parcel, 3, this.f14177g, false);
        SafeParcelWriter.c(parcel, 4, this.f14178h);
        SafeParcelWriter.c(parcel, 5, this.f14179i);
        SafeParcelWriter.w(parcel, 6, this.f14180j, false);
        SafeParcelWriter.c(parcel, 7, this.f14181k);
        SafeParcelWriter.c(parcel, 8, this.l);
        SafeParcelWriter.w(parcel, 9, this.m, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
