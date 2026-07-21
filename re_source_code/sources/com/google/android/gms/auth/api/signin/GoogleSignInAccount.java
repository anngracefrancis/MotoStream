package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import cm.aptoide.pt.DeepLinkIntentReceiver;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class
public class GoogleSignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new zab();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @VisibleForTesting
    private static Clock f11495f = DefaultClock.c();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.VersionField
    private final int f11496g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    private String f11497h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SafeParcelable.Field
    private String f11498i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @SafeParcelable.Field
    private String f11499j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @SafeParcelable.Field
    private String f11500k;

    @SafeParcelable.Field
    private Uri l;

    @SafeParcelable.Field
    private String m;

    @SafeParcelable.Field
    private long n;

    @SafeParcelable.Field
    private String o;

    @SafeParcelable.Field
    private List<Scope> p;

    @SafeParcelable.Field
    private String q;

    @SafeParcelable.Field
    private String r;
    private Set<Scope> s = new HashSet();

    @SafeParcelable.Constructor
    GoogleSignInAccount(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) String str3, @SafeParcelable.Param(id = 5) String str4, @SafeParcelable.Param(id = 6) Uri uri, @SafeParcelable.Param(id = 7) String str5, @SafeParcelable.Param(id = 8) long j2, @SafeParcelable.Param(id = 9) String str6, @SafeParcelable.Param(id = 10) List<Scope> list, @SafeParcelable.Param(id = 11) String str7, @SafeParcelable.Param(id = 12) String str8) {
        this.f11496g = i2;
        this.f11497h = str;
        this.f11498i = str2;
        this.f11499j = str3;
        this.f11500k = str4;
        this.l = uri;
        this.m = str5;
        this.n = j2;
        this.o = str6;
        this.p = list;
        this.q = str7;
        this.r = str8;
    }

    public static GoogleSignInAccount a1(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String strOptString = jSONObject.optString("photoUrl", null);
        Uri uri = !TextUtils.isEmpty(strOptString) ? Uri.parse(strOptString) : null;
        long j2 = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            hashSet.add(new Scope(jSONArray.getString(i2)));
        }
        GoogleSignInAccount googleSignInAccountQ1 = q1(jSONObject.optString(DeepLinkIntentReceiver.DeepLinksKeys.ID), jSONObject.optString("tokenId", null), jSONObject.optString("email", null), jSONObject.optString("displayName", null), jSONObject.optString("givenName", null), jSONObject.optString("familyName", null), uri, Long.valueOf(j2), jSONObject.getString("obfuscatedIdentifier"), hashSet);
        googleSignInAccountQ1.m = jSONObject.optString("serverAuthCode", null);
        return googleSignInAccountQ1;
    }

    private static GoogleSignInAccount q1(String str, String str2, String str3, String str4, String str5, String str6, Uri uri, Long l, String str7, Set<Scope> set) {
        return new GoogleSignInAccount(3, str, str2, str3, str4, uri, null, (l == null ? Long.valueOf(f11495f.a() / 1000) : l).longValue(), Preconditions.g(str7), new ArrayList((Collection) Preconditions.k(set)), str5, str6);
    }

    private final JSONObject t1() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (e0() != null) {
                jSONObject.put(DeepLinkIntentReceiver.DeepLinksKeys.ID, e0());
            }
            if (i0() != null) {
                jSONObject.put("tokenId", i0());
            }
            if (z() != null) {
                jSONObject.put("email", z());
            }
            if (y() != null) {
                jSONObject.put("displayName", y());
            }
            if (Y() != null) {
                jSONObject.put("givenName", Y());
            }
            if (W() != null) {
                jSONObject.put("familyName", W());
            }
            if (p0() != null) {
                jSONObject.put("photoUrl", p0().toString());
            }
            if (M0() != null) {
                jSONObject.put("serverAuthCode", M0());
            }
            jSONObject.put("expirationTime", this.n);
            jSONObject.put("obfuscatedIdentifier", this.o);
            JSONArray jSONArray = new JSONArray();
            List<Scope> list = this.p;
            Scope[] scopeArr = (Scope[]) list.toArray(new Scope[list.size()]);
            Arrays.sort(scopeArr, a.f11522f);
            for (Scope scope : scopeArr) {
                jSONArray.put(scope.y());
            }
            jSONObject.put("grantedScopes", jSONArray);
            return jSONObject;
        } catch (JSONException e2) {
            throw new RuntimeException(e2);
        }
    }

    @KeepForSdk
    public Set<Scope> J0() {
        HashSet hashSet = new HashSet(this.p);
        hashSet.addAll(this.s);
        return hashSet;
    }

    public String M0() {
        return this.m;
    }

    public String W() {
        return this.r;
    }

    public String Y() {
        return this.q;
    }

    public String e0() {
        return this.f11497h;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
        return googleSignInAccount.o.equals(this.o) && googleSignInAccount.J0().equals(J0());
    }

    public Account getAccount() {
        if (this.f11499j == null) {
            return null;
        }
        return new Account(this.f11499j, "com.google");
    }

    public int hashCode() {
        return ((this.o.hashCode() + 527) * 31) + J0().hashCode();
    }

    public String i0() {
        return this.f11498i;
    }

    public Uri p0() {
        return this.l;
    }

    public final String r1() {
        return this.o;
    }

    public final String s1() {
        JSONObject jSONObjectT1 = t1();
        jSONObjectT1.remove("serverAuthCode");
        return jSONObjectT1.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 1, this.f11496g);
        SafeParcelWriter.u(parcel, 2, e0(), false);
        SafeParcelWriter.u(parcel, 3, i0(), false);
        SafeParcelWriter.u(parcel, 4, z(), false);
        SafeParcelWriter.u(parcel, 5, y(), false);
        SafeParcelWriter.s(parcel, 6, p0(), i2, false);
        SafeParcelWriter.u(parcel, 7, M0(), false);
        SafeParcelWriter.p(parcel, 8, this.n);
        SafeParcelWriter.u(parcel, 9, this.o, false);
        SafeParcelWriter.y(parcel, 10, this.p, false);
        SafeParcelWriter.u(parcel, 11, Y(), false);
        SafeParcelWriter.u(parcel, 12, W(), false);
        SafeParcelWriter.b(parcel, iA);
    }

    public String y() {
        return this.f11500k;
    }

    public String z() {
        return this.f11499j;
    }
}
