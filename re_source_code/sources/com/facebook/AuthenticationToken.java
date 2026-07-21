package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import cm.aptoide.pt.database.room.RoomInstalled;
import com.facebook.internal.q0;
import java.io.IOException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: AuthenticationToken.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AuthenticationToken implements Parcelable {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f9566g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f9567h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AuthenticationTokenHeader f9568i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final AuthenticationTokenClaims f9569j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f9570k;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f9565f = new b(null);
    public static final Parcelable.Creator<AuthenticationToken> CREATOR = new a();

    /* JADX INFO: compiled from: AuthenticationToken.kt */
    public static final class a implements Parcelable.Creator<AuthenticationToken> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AuthenticationToken createFromParcel(Parcel parcel) {
            kotlin.jvm.internal.m.f(parcel, "source");
            return new AuthenticationToken(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public AuthenticationToken[] newArray(int i2) {
            return new AuthenticationToken[i2];
        }
    }

    /* JADX INFO: compiled from: AuthenticationToken.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final void a(AuthenticationToken authenticationToken) {
            AuthenticationTokenManager.a.a().e(authenticationToken);
        }
    }

    public AuthenticationToken(String str, String str2) {
        kotlin.jvm.internal.m.f(str, "token");
        kotlin.jvm.internal.m.f(str2, "expectedNonce");
        q0 q0Var = q0.a;
        q0.g(str, "token");
        q0.g(str2, "expectedNonce");
        List listV0 = kotlin.text.v.v0(str, new String[]{"."}, false, 0, 6, null);
        if (!(listV0.size() == 3)) {
            throw new IllegalArgumentException("Invalid IdToken string".toString());
        }
        String str3 = (String) listV0.get(0);
        String str4 = (String) listV0.get(1);
        String str5 = (String) listV0.get(2);
        this.f9566g = str;
        this.f9567h = str2;
        AuthenticationTokenHeader authenticationTokenHeader = new AuthenticationTokenHeader(str3);
        this.f9568i = authenticationTokenHeader;
        this.f9569j = new AuthenticationTokenClaims(str4, str2);
        if (!a(str3, str4, str5, authenticationTokenHeader.a())) {
            throw new IllegalArgumentException("Invalid Signature".toString());
        }
        this.f9570k = str5;
    }

    private final boolean a(String str, String str2, String str3, String str4) {
        try {
            com.facebook.internal.v0.c cVar = com.facebook.internal.v0.c.a;
            String strB = com.facebook.internal.v0.c.b(str4);
            if (strB == null) {
                return false;
            }
            return com.facebook.internal.v0.c.e(com.facebook.internal.v0.c.a(strB), str + '.' + str2, str3);
        } catch (IOException | InvalidKeySpecException unused) {
            return false;
        }
    }

    public final JSONObject b() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("token_string", this.f9566g);
        jSONObject.put("expected_nonce", this.f9567h);
        jSONObject.put("header", this.f9568i.c());
        jSONObject.put("claims", this.f9569j.b());
        jSONObject.put(RoomInstalled.SIGNATURE, this.f9570k);
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
        if (!(obj instanceof AuthenticationToken)) {
            return false;
        }
        AuthenticationToken authenticationToken = (AuthenticationToken) obj;
        return kotlin.jvm.internal.m.a(this.f9566g, authenticationToken.f9566g) && kotlin.jvm.internal.m.a(this.f9567h, authenticationToken.f9567h) && kotlin.jvm.internal.m.a(this.f9568i, authenticationToken.f9568i) && kotlin.jvm.internal.m.a(this.f9569j, authenticationToken.f9569j) && kotlin.jvm.internal.m.a(this.f9570k, authenticationToken.f9570k);
    }

    public int hashCode() {
        return ((((((((527 + this.f9566g.hashCode()) * 31) + this.f9567h.hashCode()) * 31) + this.f9568i.hashCode()) * 31) + this.f9569j.hashCode()) * 31) + this.f9570k.hashCode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        kotlin.jvm.internal.m.f(parcel, "dest");
        parcel.writeString(this.f9566g);
        parcel.writeString(this.f9567h);
        parcel.writeParcelable(this.f9568i, i2);
        parcel.writeParcelable(this.f9569j, i2);
        parcel.writeString(this.f9570k);
    }

    public AuthenticationToken(Parcel parcel) {
        kotlin.jvm.internal.m.f(parcel, "parcel");
        String string = parcel.readString();
        q0 q0Var = q0.a;
        this.f9566g = q0.k(string, "token");
        this.f9567h = q0.k(parcel.readString(), "expectedNonce");
        Parcelable parcelable = parcel.readParcelable(AuthenticationTokenHeader.class.getClassLoader());
        if (parcelable != null) {
            this.f9568i = (AuthenticationTokenHeader) parcelable;
            Parcelable parcelable2 = parcel.readParcelable(AuthenticationTokenClaims.class.getClassLoader());
            if (parcelable2 != null) {
                this.f9569j = (AuthenticationTokenClaims) parcelable2;
                this.f9570k = q0.k(parcel.readString(), RoomInstalled.SIGNATURE);
                return;
            }
            throw new IllegalStateException("Required value was null.".toString());
        }
        throw new IllegalStateException("Required value was null.".toString());
    }
}
