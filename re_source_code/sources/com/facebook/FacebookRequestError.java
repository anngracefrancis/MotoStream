package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.p0;
import java.net.HttpURLConnection;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: FacebookRequestError.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FacebookRequestError implements Parcelable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f9607h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f9608i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f9609j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f9610k;
    private final String l;
    private final String m;
    private final JSONObject n;
    private final JSONObject o;
    private final Object p;
    private final HttpURLConnection q;
    private final String r;
    private FacebookException s;
    private final a t;
    private final String u;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c f9605f = new c(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final d f9606g = new d(200, 299);
    public static final Parcelable.Creator<FacebookRequestError> CREATOR = new b();

    /* JADX INFO: compiled from: FacebookRequestError.kt */
    public enum a {
        LOGIN_RECOVERABLE,
        OTHER,
        TRANSIENT;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static a[] valuesCustom() {
            a[] aVarArrValuesCustom = values();
            return (a[]) Arrays.copyOf(aVarArrValuesCustom, aVarArrValuesCustom.length);
        }
    }

    /* JADX INFO: compiled from: FacebookRequestError.kt */
    public static final class b implements Parcelable.Creator<FacebookRequestError> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public FacebookRequestError createFromParcel(Parcel parcel) {
            kotlin.jvm.internal.m.f(parcel, "parcel");
            return new FacebookRequestError(parcel, (kotlin.jvm.internal.g) null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public FacebookRequestError[] newArray(int i2) {
            return new FacebookRequestError[i2];
        }
    }

    /* JADX INFO: compiled from: FacebookRequestError.kt */
    public static final class c {
        private c() {
        }

        public /* synthetic */ c(kotlin.jvm.internal.g gVar) {
            this();
        }

        /* JADX WARN: Code duplicated, block: B:47:0x00d1 A[Catch: JSONException -> 0x012f, TryCatch #0 {JSONException -> 0x012f, blocks: (B:3:0x0012, B:5:0x0018, B:7:0x0024, B:9:0x0028, B:12:0x0036, B:47:0x00d1, B:33:0x0079, B:30:0x0070, B:27:0x0066, B:24:0x005e, B:21:0x0057, B:18:0x004d, B:15:0x0043, B:35:0x0085, B:38:0x0092, B:40:0x009b, B:44:0x00ac, B:49:0x00f2, B:51:0x00fc, B:53:0x010a, B:55:0x0113), top: B:59:0x0012 }] */
        public final FacebookRequestError a(JSONObject jSONObject, Object obj, HttpURLConnection httpURLConnection) {
            String strOptString;
            int iOptInt;
            String str;
            String strOptString2;
            String strOptString3;
            boolean z;
            String str2;
            kotlin.jvm.internal.m.f(jSONObject, "singleResult");
            try {
                if (jSONObject.has("code")) {
                    int i2 = jSONObject.getInt("code");
                    p0 p0Var = p0.a;
                    Object objM = p0.M(jSONObject, "body", "FACEBOOK_NON_JSON_RESULT");
                    if (objM != null && (objM instanceof JSONObject)) {
                        boolean zOptBoolean = false;
                        int iOptInt2 = -1;
                        if (((JSONObject) objM).has("error")) {
                            JSONObject jSONObject2 = (JSONObject) p0.M((JSONObject) objM, "error", null);
                            strOptString = jSONObject2 == null ? null : jSONObject2.optString("type", null);
                            String strOptString4 = jSONObject2 == null ? null : jSONObject2.optString("message", null);
                            int iOptInt3 = jSONObject2 == null ? -1 : jSONObject2.optInt("code", -1);
                            if (jSONObject2 != null) {
                                iOptInt2 = jSONObject2.optInt("error_subcode", -1);
                            }
                            strOptString2 = jSONObject2 == null ? null : jSONObject2.optString("error_user_msg", null);
                            strOptString3 = jSONObject2 == null ? null : jSONObject2.optString("error_user_title", null);
                            if (jSONObject2 != null) {
                                zOptBoolean = jSONObject2.optBoolean("is_transient", false);
                            }
                            str = strOptString4;
                            z = zOptBoolean;
                            iOptInt = iOptInt2;
                            zOptBoolean = true;
                            iOptInt2 = iOptInt3;
                        } else {
                            if (((JSONObject) objM).has("error_code") || ((JSONObject) objM).has("error_msg") || ((JSONObject) objM).has("error_reason")) {
                                strOptString = ((JSONObject) objM).optString("error_reason", null);
                                String strOptString5 = ((JSONObject) objM).optString("error_msg", null);
                                int iOptInt4 = ((JSONObject) objM).optInt("error_code", -1);
                                iOptInt = ((JSONObject) objM).optInt("error_subcode", -1);
                                iOptInt2 = iOptInt4;
                                str = strOptString5;
                                strOptString2 = null;
                                strOptString3 = null;
                                zOptBoolean = true;
                                z = false;
                            } else {
                                str2 = null;
                                str = null;
                                strOptString2 = null;
                                strOptString3 = null;
                                iOptInt = -1;
                                z = false;
                            }
                            if (zOptBoolean) {
                                return new FacebookRequestError(i2, iOptInt2, iOptInt, str2, str, strOptString3, strOptString2, (JSONObject) objM, jSONObject, obj, httpURLConnection, null, z, null);
                            }
                        }
                        str2 = strOptString;
                        if (zOptBoolean) {
                            return new FacebookRequestError(i2, iOptInt2, iOptInt, str2, str, strOptString3, strOptString2, (JSONObject) objM, jSONObject, obj, httpURLConnection, null, z, null);
                        }
                    }
                    if (!c().a(i2)) {
                        return new FacebookRequestError(i2, -1, -1, null, null, null, null, jSONObject.has("body") ? (JSONObject) p0.M(jSONObject, "body", "FACEBOOK_NON_JSON_RESULT") : null, jSONObject, obj, httpURLConnection, null, false, null);
                    }
                }
            } catch (JSONException unused) {
            }
            return null;
        }

        public final synchronized com.facebook.internal.x b() {
            com.facebook.internal.d0 d0Var = com.facebook.internal.d0.a;
            a0 a0Var = a0.a;
            com.facebook.internal.c0 c0VarC = com.facebook.internal.d0.c(a0.d());
            if (c0VarC == null) {
                return com.facebook.internal.x.a.b();
            }
            return c0VarC.c();
        }

        public final d c() {
            return FacebookRequestError.f9606g;
        }
    }

    /* JADX INFO: compiled from: FacebookRequestError.kt */
    public static final class d {
        private final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f9615b;

        public d(int i2, int i3) {
            this.a = i2;
            this.f9615b = i3;
        }

        public final boolean a(int i2) {
            return i2 <= this.f9615b && this.a <= i2;
        }
    }

    private FacebookRequestError(int i2, int i3, int i4, String str, String str2, String str3, String str4, JSONObject jSONObject, JSONObject jSONObject2, Object obj, HttpURLConnection httpURLConnection, FacebookException facebookException, boolean z) {
        boolean z2;
        this.f9607h = i2;
        this.f9608i = i3;
        this.f9609j = i4;
        this.f9610k = str;
        this.l = str3;
        this.m = str4;
        this.n = jSONObject;
        this.o = jSONObject2;
        this.p = obj;
        this.q = httpURLConnection;
        this.r = str2;
        if (facebookException != null) {
            this.s = facebookException;
            z2 = true;
        } else {
            this.s = new FacebookServiceException(this, c());
            z2 = false;
        }
        a aVarC = z2 ? a.OTHER : f9605f.b().c(i3, i4, z);
        this.t = aVarC;
        this.u = f9605f.b().d(aVarC);
    }

    public /* synthetic */ FacebookRequestError(int i2, int i3, int i4, String str, String str2, String str3, String str4, JSONObject jSONObject, JSONObject jSONObject2, Object obj, HttpURLConnection httpURLConnection, FacebookException facebookException, boolean z, kotlin.jvm.internal.g gVar) {
        this(i2, i3, i4, str, str2, str3, str4, jSONObject, jSONObject2, obj, httpURLConnection, facebookException, z);
    }

    public /* synthetic */ FacebookRequestError(Parcel parcel, kotlin.jvm.internal.g gVar) {
        this(parcel);
    }

    public final int b() {
        return this.f9608i;
    }

    public final String c() {
        String str = this.r;
        if (str != null) {
            return str;
        }
        FacebookException facebookException = this.s;
        if (facebookException == null) {
            return null;
        }
        return facebookException.getLocalizedMessage();
    }

    public final String d() {
        return this.f9610k;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final FacebookException e() {
        return this.s;
    }

    public final int f() {
        return this.f9607h;
    }

    public final int g() {
        return this.f9609j;
    }

    public String toString() {
        String str = "{HttpStatus: " + this.f9607h + ", errorCode: " + this.f9608i + ", subErrorCode: " + this.f9609j + ", errorType: " + this.f9610k + ", errorMessage: " + c() + "}";
        kotlin.jvm.internal.m.e(str, "StringBuilder(\"{HttpStatus: \")\n        .append(requestStatusCode)\n        .append(\", errorCode: \")\n        .append(errorCode)\n        .append(\", subErrorCode: \")\n        .append(subErrorCode)\n        .append(\", errorType: \")\n        .append(errorType)\n        .append(\", errorMessage: \")\n        .append(errorMessage)\n        .append(\"}\")\n        .toString()");
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        kotlin.jvm.internal.m.f(parcel, "out");
        parcel.writeInt(this.f9607h);
        parcel.writeInt(this.f9608i);
        parcel.writeInt(this.f9609j);
        parcel.writeString(this.f9610k);
        parcel.writeString(c());
        parcel.writeString(this.l);
        parcel.writeString(this.m);
    }

    public FacebookRequestError(HttpURLConnection httpURLConnection, Exception exc) {
        this(-1, -1, -1, null, null, null, null, null, null, null, httpURLConnection, exc instanceof FacebookException ? (FacebookException) exc : new FacebookException(exc), false);
    }

    public FacebookRequestError(int i2, String str, String str2) {
        this(-1, i2, -1, str, str2, null, null, null, null, null, null, null, false);
    }

    private FacebookRequestError(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), null, null, null, null, null, false);
    }
}
