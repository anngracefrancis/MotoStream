package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.facebook.internal.p0;
import com.facebook.internal.q0;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: AuthenticationTokenClaims.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AuthenticationTokenClaims implements Parcelable {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f9572g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f9573h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f9574i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f9575j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final long f9576k;
    private final long l;
    private final String m;
    private final String n;
    private final String o;
    private final String p;
    private final String q;
    private final String r;
    private final String s;
    private final Set<String> t;
    private final String u;
    private final Map<String, Integer> v;
    private final Map<String, String> w;
    private final Map<String, String> x;
    private final String y;
    private final String z;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f9571f = new b(null);
    public static final Parcelable.Creator<AuthenticationTokenClaims> CREATOR = new a();

    /* JADX INFO: compiled from: AuthenticationTokenClaims.kt */
    public static final class a implements Parcelable.Creator<AuthenticationTokenClaims> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AuthenticationTokenClaims createFromParcel(Parcel parcel) {
            kotlin.jvm.internal.m.f(parcel, "source");
            return new AuthenticationTokenClaims(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public AuthenticationTokenClaims[] newArray(int i2) {
            return new AuthenticationTokenClaims[i2];
        }
    }

    /* JADX INFO: compiled from: AuthenticationTokenClaims.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final String a(JSONObject jSONObject, String str) {
            kotlin.jvm.internal.m.f(jSONObject, "<this>");
            kotlin.jvm.internal.m.f(str, "name");
            if (jSONObject.has(str)) {
                return jSONObject.getString(str);
            }
            return null;
        }
    }

    public AuthenticationTokenClaims(String str, String str2) throws JSONException {
        Set<String> setUnmodifiableSet;
        Map<String, Integer> mapUnmodifiableMap;
        Map<String, String> mapUnmodifiableMap2;
        kotlin.jvm.internal.m.f(str, "encodedClaims");
        kotlin.jvm.internal.m.f(str2, "expectedNonce");
        q0 q0Var = q0.a;
        q0.g(str, "encodedClaims");
        byte[] bArrDecode = Base64.decode(str, 8);
        kotlin.jvm.internal.m.e(bArrDecode, "decodedBytes");
        JSONObject jSONObject = new JSONObject(new String(bArrDecode, Charsets.f25054b));
        if (!a(jSONObject, str2)) {
            throw new IllegalArgumentException("Invalid claims".toString());
        }
        String string = jSONObject.getString("jti");
        kotlin.jvm.internal.m.e(string, "jsonObj.getString(JSON_KEY_JIT)");
        this.f9572g = string;
        String string2 = jSONObject.getString("iss");
        kotlin.jvm.internal.m.e(string2, "jsonObj.getString(JSON_KEY_ISS)");
        this.f9573h = string2;
        String string3 = jSONObject.getString("aud");
        kotlin.jvm.internal.m.e(string3, "jsonObj.getString(JSON_KEY_AUD)");
        this.f9574i = string3;
        String string4 = jSONObject.getString("nonce");
        kotlin.jvm.internal.m.e(string4, "jsonObj.getString(JSON_KEY_NONCE)");
        this.f9575j = string4;
        this.f9576k = jSONObject.getLong("exp");
        this.l = jSONObject.getLong("iat");
        String string5 = jSONObject.getString("sub");
        kotlin.jvm.internal.m.e(string5, "jsonObj.getString(JSON_KEY_SUB)");
        this.m = string5;
        b bVar = f9571f;
        this.n = bVar.a(jSONObject, "name");
        this.o = bVar.a(jSONObject, "given_name");
        this.p = bVar.a(jSONObject, "middle_name");
        this.q = bVar.a(jSONObject, "family_name");
        this.r = bVar.a(jSONObject, "email");
        this.s = bVar.a(jSONObject, "picture");
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("user_friends");
        Map<String, String> mapUnmodifiableMap3 = null;
        if (jSONArrayOptJSONArray == null) {
            setUnmodifiableSet = null;
        } else {
            p0 p0Var = p0.a;
            setUnmodifiableSet = Collections.unmodifiableSet(p0.d0(jSONArrayOptJSONArray));
        }
        this.t = setUnmodifiableSet;
        this.u = bVar.a(jSONObject, "user_birthday");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("user_age_range");
        if (jSONObjectOptJSONObject == null) {
            mapUnmodifiableMap = null;
        } else {
            p0 p0Var2 = p0.a;
            mapUnmodifiableMap = Collections.unmodifiableMap(p0.l(jSONObjectOptJSONObject));
        }
        this.v = mapUnmodifiableMap;
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("user_hometown");
        if (jSONObjectOptJSONObject2 == null) {
            mapUnmodifiableMap2 = null;
        } else {
            p0 p0Var3 = p0.a;
            mapUnmodifiableMap2 = Collections.unmodifiableMap(p0.m(jSONObjectOptJSONObject2));
        }
        this.w = mapUnmodifiableMap2;
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("user_location");
        if (jSONObjectOptJSONObject3 != null) {
            p0 p0Var4 = p0.a;
            mapUnmodifiableMap3 = Collections.unmodifiableMap(p0.m(jSONObjectOptJSONObject3));
        }
        this.x = mapUnmodifiableMap3;
        this.y = bVar.a(jSONObject, "user_gender");
        this.z = bVar.a(jSONObject, "user_link");
    }

    private final boolean a(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return false;
        }
        String strOptString = jSONObject.optString("jti");
        kotlin.jvm.internal.m.e(strOptString, "jti");
        if (strOptString.length() == 0) {
            return false;
        }
        try {
            String strOptString2 = jSONObject.optString("iss");
            kotlin.jvm.internal.m.e(strOptString2, "iss");
            if (!(strOptString2.length() == 0) && (kotlin.jvm.internal.m.a(new URL(strOptString2).getHost(), "facebook.com") || kotlin.jvm.internal.m.a(new URL(strOptString2).getHost(), "www.facebook.com"))) {
                String strOptString3 = jSONObject.optString("aud");
                kotlin.jvm.internal.m.e(strOptString3, "aud");
                if (!(strOptString3.length() == 0)) {
                    a0 a0Var = a0.a;
                    if (kotlin.jvm.internal.m.a(strOptString3, a0.d())) {
                        long j2 = 1000;
                        if (new Date().after(new Date(jSONObject.optLong("exp") * j2))) {
                            return false;
                        }
                        if (new Date().after(new Date((jSONObject.optLong("iat") * j2) + 600000))) {
                            return false;
                        }
                        String strOptString4 = jSONObject.optString("sub");
                        kotlin.jvm.internal.m.e(strOptString4, "sub");
                        if (strOptString4.length() == 0) {
                            return false;
                        }
                        String strOptString5 = jSONObject.optString("nonce");
                        kotlin.jvm.internal.m.e(strOptString5, "nonce");
                        if (!(strOptString5.length() == 0) && kotlin.jvm.internal.m.a(strOptString5, str)) {
                            return true;
                        }
                    }
                }
            }
        } catch (MalformedURLException unused) {
        }
        return false;
    }

    public final JSONObject b() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("jti", this.f9572g);
        jSONObject.put("iss", this.f9573h);
        jSONObject.put("aud", this.f9574i);
        jSONObject.put("nonce", this.f9575j);
        jSONObject.put("exp", this.f9576k);
        jSONObject.put("iat", this.l);
        String str = this.m;
        if (str != null) {
            jSONObject.put("sub", str);
        }
        String str2 = this.n;
        if (str2 != null) {
            jSONObject.put("name", str2);
        }
        String str3 = this.o;
        if (str3 != null) {
            jSONObject.put("given_name", str3);
        }
        String str4 = this.p;
        if (str4 != null) {
            jSONObject.put("middle_name", str4);
        }
        String str5 = this.q;
        if (str5 != null) {
            jSONObject.put("family_name", str5);
        }
        String str6 = this.r;
        if (str6 != null) {
            jSONObject.put("email", str6);
        }
        String str7 = this.s;
        if (str7 != null) {
            jSONObject.put("picture", str7);
        }
        if (this.t != null) {
            jSONObject.put("user_friends", new JSONArray((Collection) this.t));
        }
        String str8 = this.u;
        if (str8 != null) {
            jSONObject.put("user_birthday", str8);
        }
        if (this.v != null) {
            jSONObject.put("user_age_range", new JSONObject(this.v));
        }
        if (this.w != null) {
            jSONObject.put("user_hometown", new JSONObject(this.w));
        }
        if (this.x != null) {
            jSONObject.put("user_location", new JSONObject(this.x));
        }
        String str9 = this.y;
        if (str9 != null) {
            jSONObject.put("user_gender", str9);
        }
        String str10 = this.z;
        if (str10 != null) {
            jSONObject.put("user_link", str10);
        }
        return jSONObject;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AuthenticationTokenClaims)) {
            return false;
        }
        AuthenticationTokenClaims authenticationTokenClaims = (AuthenticationTokenClaims) obj;
        return kotlin.jvm.internal.m.a(this.f9572g, authenticationTokenClaims.f9572g) && kotlin.jvm.internal.m.a(this.f9573h, authenticationTokenClaims.f9573h) && kotlin.jvm.internal.m.a(this.f9574i, authenticationTokenClaims.f9574i) && kotlin.jvm.internal.m.a(this.f9575j, authenticationTokenClaims.f9575j) && this.f9576k == authenticationTokenClaims.f9576k && this.l == authenticationTokenClaims.l && kotlin.jvm.internal.m.a(this.m, authenticationTokenClaims.m) && kotlin.jvm.internal.m.a(this.n, authenticationTokenClaims.n) && kotlin.jvm.internal.m.a(this.o, authenticationTokenClaims.o) && kotlin.jvm.internal.m.a(this.p, authenticationTokenClaims.p) && kotlin.jvm.internal.m.a(this.q, authenticationTokenClaims.q) && kotlin.jvm.internal.m.a(this.r, authenticationTokenClaims.r) && kotlin.jvm.internal.m.a(this.s, authenticationTokenClaims.s) && kotlin.jvm.internal.m.a(this.t, authenticationTokenClaims.t) && kotlin.jvm.internal.m.a(this.u, authenticationTokenClaims.u) && kotlin.jvm.internal.m.a(this.v, authenticationTokenClaims.v) && kotlin.jvm.internal.m.a(this.w, authenticationTokenClaims.w) && kotlin.jvm.internal.m.a(this.x, authenticationTokenClaims.x) && kotlin.jvm.internal.m.a(this.y, authenticationTokenClaims.y) && kotlin.jvm.internal.m.a(this.z, authenticationTokenClaims.z);
    }

    public int hashCode() {
        int iHashCode = (((((((((((((527 + this.f9572g.hashCode()) * 31) + this.f9573h.hashCode()) * 31) + this.f9574i.hashCode()) * 31) + this.f9575j.hashCode()) * 31) + cm.aptoide.pt.aab.a.a(this.f9576k)) * 31) + cm.aptoide.pt.aab.a.a(this.l)) * 31) + this.m.hashCode()) * 31;
        String str = this.n;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.o;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.p;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.q;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.r;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.s;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Set<String> set = this.t;
        int iHashCode8 = (iHashCode7 + (set == null ? 0 : set.hashCode())) * 31;
        String str7 = this.u;
        int iHashCode9 = (iHashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Map<String, Integer> map = this.v;
        int iHashCode10 = (iHashCode9 + (map == null ? 0 : map.hashCode())) * 31;
        Map<String, String> map2 = this.w;
        int iHashCode11 = (iHashCode10 + (map2 == null ? 0 : map2.hashCode())) * 31;
        Map<String, String> map3 = this.x;
        int iHashCode12 = (iHashCode11 + (map3 == null ? 0 : map3.hashCode())) * 31;
        String str8 = this.y;
        int iHashCode13 = (iHashCode12 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.z;
        return iHashCode13 + (str9 != null ? str9.hashCode() : 0);
    }

    public String toString() {
        String string = b().toString();
        kotlin.jvm.internal.m.e(string, "claimsJsonObject.toString()");
        return string;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        kotlin.jvm.internal.m.f(parcel, "dest");
        parcel.writeString(this.f9572g);
        parcel.writeString(this.f9573h);
        parcel.writeString(this.f9574i);
        parcel.writeString(this.f9575j);
        parcel.writeLong(this.f9576k);
        parcel.writeLong(this.l);
        parcel.writeString(this.m);
        parcel.writeString(this.n);
        parcel.writeString(this.o);
        parcel.writeString(this.p);
        parcel.writeString(this.q);
        parcel.writeString(this.r);
        parcel.writeString(this.s);
        if (this.t == null) {
            parcel.writeStringList(null);
        } else {
            parcel.writeStringList(new ArrayList(this.t));
        }
        parcel.writeString(this.u);
        parcel.writeMap(this.v);
        parcel.writeMap(this.w);
        parcel.writeMap(this.x);
        parcel.writeString(this.y);
        parcel.writeString(this.z);
    }

    public AuthenticationTokenClaims(Parcel parcel) {
        kotlin.jvm.internal.m.f(parcel, "parcel");
        String string = parcel.readString();
        q0 q0Var = q0.a;
        this.f9572g = q0.k(string, "jti");
        this.f9573h = q0.k(parcel.readString(), "iss");
        this.f9574i = q0.k(parcel.readString(), "aud");
        this.f9575j = q0.k(parcel.readString(), "nonce");
        this.f9576k = parcel.readLong();
        this.l = parcel.readLong();
        this.m = q0.k(parcel.readString(), "sub");
        this.n = parcel.readString();
        this.o = parcel.readString();
        this.p = parcel.readString();
        this.q = parcel.readString();
        this.r = parcel.readString();
        this.s = parcel.readString();
        ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
        this.t = arrayListCreateStringArrayList != null ? Collections.unmodifiableSet(new HashSet(arrayListCreateStringArrayList)) : null;
        this.u = parcel.readString();
        HashMap hashMap = parcel.readHashMap(IntCompanionObject.a.getClass().getClassLoader());
        hashMap = hashMap instanceof HashMap ? hashMap : null;
        this.v = hashMap != null ? Collections.unmodifiableMap(hashMap) : null;
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        HashMap hashMap2 = parcel.readHashMap(stringCompanionObject.getClass().getClassLoader());
        hashMap2 = hashMap2 instanceof HashMap ? hashMap2 : null;
        this.w = hashMap2 != null ? Collections.unmodifiableMap(hashMap2) : null;
        HashMap hashMap3 = parcel.readHashMap(stringCompanionObject.getClass().getClassLoader());
        hashMap3 = hashMap3 instanceof HashMap ? hashMap3 : null;
        this.x = hashMap3 != null ? Collections.unmodifiableMap(hashMap3) : null;
        this.y = parcel.readString();
        this.z = parcel.readString();
    }
}
