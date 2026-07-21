package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.facebook.internal.q0;
import kotlin.text.Charsets;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: AuthenticationTokenHeader.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AuthenticationTokenHeader implements Parcelable {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f9578g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f9579h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f9580i;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f9577f = new b(null);
    public static final Parcelable.Creator<AuthenticationTokenHeader> CREATOR = new a();

    /* JADX INFO: compiled from: AuthenticationTokenHeader.kt */
    public static final class a implements Parcelable.Creator<AuthenticationTokenHeader> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AuthenticationTokenHeader createFromParcel(Parcel parcel) {
            kotlin.jvm.internal.m.f(parcel, "source");
            return new AuthenticationTokenHeader(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public AuthenticationTokenHeader[] newArray(int i2) {
            return new AuthenticationTokenHeader[i2];
        }
    }

    /* JADX INFO: compiled from: AuthenticationTokenHeader.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public AuthenticationTokenHeader(String str) throws JSONException {
        kotlin.jvm.internal.m.f(str, "encodedHeaderString");
        if (!b(str)) {
            throw new IllegalArgumentException("Invalid Header".toString());
        }
        byte[] bArrDecode = Base64.decode(str, 0);
        kotlin.jvm.internal.m.e(bArrDecode, "decodedBytes");
        JSONObject jSONObject = new JSONObject(new String(bArrDecode, Charsets.f25054b));
        String string = jSONObject.getString("alg");
        kotlin.jvm.internal.m.e(string, "jsonObj.getString(\"alg\")");
        this.f9578g = string;
        String string2 = jSONObject.getString("typ");
        kotlin.jvm.internal.m.e(string2, "jsonObj.getString(\"typ\")");
        this.f9579h = string2;
        String string3 = jSONObject.getString("kid");
        kotlin.jvm.internal.m.e(string3, "jsonObj.getString(\"kid\")");
        this.f9580i = string3;
    }

    private final boolean b(String str) {
        q0 q0Var = q0.a;
        q0.g(str, "encodedHeaderString");
        byte[] bArrDecode = Base64.decode(str, 0);
        kotlin.jvm.internal.m.e(bArrDecode, "decodedBytes");
        try {
            JSONObject jSONObject = new JSONObject(new String(bArrDecode, Charsets.f25054b));
            String strOptString = jSONObject.optString("alg");
            kotlin.jvm.internal.m.e(strOptString, "alg");
            boolean z = (strOptString.length() > 0) && kotlin.jvm.internal.m.a(strOptString, "RS256");
            String strOptString2 = jSONObject.optString("kid");
            kotlin.jvm.internal.m.e(strOptString2, "jsonObj.optString(\"kid\")");
            boolean z2 = strOptString2.length() > 0;
            String strOptString3 = jSONObject.optString("typ");
            kotlin.jvm.internal.m.e(strOptString3, "jsonObj.optString(\"typ\")");
            return z && z2 && (strOptString3.length() > 0);
        } catch (JSONException unused) {
            return false;
        }
    }

    public final String a() {
        return this.f9580i;
    }

    public final JSONObject c() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("alg", this.f9578g);
        jSONObject.put("typ", this.f9579h);
        jSONObject.put("kid", this.f9580i);
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
        if (!(obj instanceof AuthenticationTokenHeader)) {
            return false;
        }
        AuthenticationTokenHeader authenticationTokenHeader = (AuthenticationTokenHeader) obj;
        return kotlin.jvm.internal.m.a(this.f9578g, authenticationTokenHeader.f9578g) && kotlin.jvm.internal.m.a(this.f9579h, authenticationTokenHeader.f9579h) && kotlin.jvm.internal.m.a(this.f9580i, authenticationTokenHeader.f9580i);
    }

    public int hashCode() {
        return ((((527 + this.f9578g.hashCode()) * 31) + this.f9579h.hashCode()) * 31) + this.f9580i.hashCode();
    }

    public String toString() {
        String string = c().toString();
        kotlin.jvm.internal.m.e(string, "headerJsonObject.toString()");
        return string;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        kotlin.jvm.internal.m.f(parcel, "dest");
        parcel.writeString(this.f9578g);
        parcel.writeString(this.f9579h);
        parcel.writeString(this.f9580i);
    }

    public AuthenticationTokenHeader(Parcel parcel) {
        kotlin.jvm.internal.m.f(parcel, "parcel");
        String string = parcel.readString();
        q0 q0Var = q0.a;
        this.f9578g = q0.k(string, "alg");
        this.f9579h = q0.k(parcel.readString(), "typ");
        this.f9580i = q0.k(parcel.readString(), "kid");
    }
}
