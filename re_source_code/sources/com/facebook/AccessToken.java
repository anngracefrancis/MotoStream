package com.facebook;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import cm.aptoide.pt.DeepLinkIntentReceiver;
import cm.aptoide.pt.account.AndroidAccountManagerPersistence;
import cm.aptoide.pt.timeline.view.follow.TimeLineFollowFragment;
import com.facebook.internal.p0;
import com.facebook.internal.q0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: AccessToken.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AccessToken implements Parcelable {
    public static final Parcelable.Creator<AccessToken> CREATOR;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c f9559f = new c(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Date f9560g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Date f9561h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Date f9562i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final w f9563j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Date f9564k;
    private final Set<String> l;
    private final Set<String> m;
    private final Set<String> n;
    private final String o;
    private final w p;
    private final Date q;
    private final String r;
    private final String s;
    private final Date t;
    private final String u;

    /* JADX INFO: compiled from: AccessToken.kt */
    public interface a {
        void a(FacebookException facebookException);

        void b(AccessToken accessToken);
    }

    /* JADX INFO: compiled from: AccessToken.kt */
    public static final class b implements Parcelable.Creator<AccessToken> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AccessToken createFromParcel(Parcel parcel) {
            kotlin.jvm.internal.m.f(parcel, "source");
            return new AccessToken(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public AccessToken[] newArray(int i2) {
            return new AccessToken[i2];
        }
    }

    /* JADX INFO: compiled from: AccessToken.kt */
    public static final class c {
        private c() {
        }

        public /* synthetic */ c(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final AccessToken a(AccessToken accessToken) {
            kotlin.jvm.internal.m.f(accessToken, "current");
            return new AccessToken(accessToken.l(), accessToken.c(), accessToken.m(), accessToken.j(), accessToken.e(), accessToken.f(), accessToken.k(), new Date(), new Date(), accessToken.d(), null, 1024, null);
        }

        public final AccessToken b(JSONObject jSONObject) throws JSONException {
            kotlin.jvm.internal.m.f(jSONObject, "jsonObject");
            if (jSONObject.getInt("version") > 1) {
                throw new FacebookException("Unknown AccessToken serialization format.");
            }
            String string = jSONObject.getString("token");
            Date date = new Date(jSONObject.getLong("expires_at"));
            JSONArray jSONArray = jSONObject.getJSONArray("permissions");
            JSONArray jSONArray2 = jSONObject.getJSONArray("declined_permissions");
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("expired_permissions");
            Date date2 = new Date(jSONObject.getLong("last_refresh"));
            String string2 = jSONObject.getString("source");
            kotlin.jvm.internal.m.e(string2, "jsonObject.getString(SOURCE_KEY)");
            w wVarValueOf = w.valueOf(string2);
            String string3 = jSONObject.getString("application_id");
            String string4 = jSONObject.getString(TimeLineFollowFragment.BundleKeys.USER_ID);
            Date date3 = new Date(jSONObject.optLong("data_access_expiration_time", 0L));
            String strOptString = jSONObject.optString("graph_domain", null);
            kotlin.jvm.internal.m.e(string, "token");
            kotlin.jvm.internal.m.e(string3, "applicationId");
            kotlin.jvm.internal.m.e(string4, AndroidAccountManagerPersistence.ACCOUNT_ID);
            p0 p0Var = p0.a;
            kotlin.jvm.internal.m.e(jSONArray, "permissionsArray");
            List<String> listE0 = p0.e0(jSONArray);
            kotlin.jvm.internal.m.e(jSONArray2, "declinedPermissionsArray");
            return new AccessToken(string, string3, string4, listE0, p0.e0(jSONArray2), jSONArrayOptJSONArray == null ? new ArrayList() : p0.e0(jSONArrayOptJSONArray), wVarValueOf, date, date2, date3, strOptString);
        }

        public final AccessToken c(Bundle bundle) {
            String string;
            kotlin.jvm.internal.m.f(bundle, "bundle");
            List<String> listF = f(bundle, "com.facebook.TokenCachingStrategy.Permissions");
            List<String> listF2 = f(bundle, "com.facebook.TokenCachingStrategy.DeclinedPermissions");
            List<String> listF3 = f(bundle, "com.facebook.TokenCachingStrategy.ExpiredPermissions");
            f0.a aVar = f0.a;
            String strA = aVar.a(bundle);
            p0 p0Var = p0.a;
            if (p0.a0(strA)) {
                a0 a0Var = a0.a;
                strA = a0.d();
            }
            String str = strA;
            String strF = aVar.f(bundle);
            if (strF == null) {
                return null;
            }
            JSONObject jSONObjectD = p0.d(strF);
            if (jSONObjectD == null) {
                string = null;
            } else {
                try {
                    string = jSONObjectD.getString(DeepLinkIntentReceiver.DeepLinksKeys.ID);
                } catch (JSONException unused) {
                    return null;
                }
            }
            if (str == null || string == null) {
                return null;
            }
            return new AccessToken(strF, str, string, listF, listF2, listF3, aVar.e(bundle), aVar.c(bundle), aVar.d(bundle), null, null, 1024, null);
        }

        public final void d() {
            AccessToken accessTokenE = v.a.e().e();
            if (accessTokenE != null) {
                h(a(accessTokenE));
            }
        }

        public final AccessToken e() {
            return v.a.e().e();
        }

        public final List<String> f(Bundle bundle, String str) {
            kotlin.jvm.internal.m.f(bundle, "bundle");
            ArrayList<String> stringArrayList = bundle.getStringArrayList(str);
            if (stringArrayList == null) {
                return kotlin.collections.u.j();
            }
            List<String> listUnmodifiableList = Collections.unmodifiableList(new ArrayList(stringArrayList));
            kotlin.jvm.internal.m.e(listUnmodifiableList, "{\n            Collections.unmodifiableList(ArrayList(originalPermissions))\n          }");
            return listUnmodifiableList;
        }

        public final boolean g() {
            AccessToken accessTokenE = v.a.e().e();
            return (accessTokenE == null || accessTokenE.n()) ? false : true;
        }

        public final void h(AccessToken accessToken) {
            v.a.e().r(accessToken);
        }
    }

    /* JADX INFO: compiled from: AccessToken.kt */
    public /* synthetic */ class d {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[w.valuesCustom().length];
            iArr[w.FACEBOOK_APPLICATION_WEB.ordinal()] = 1;
            iArr[w.CHROME_CUSTOM_TAB.ordinal()] = 2;
            iArr[w.WEB_VIEW.ordinal()] = 3;
            a = iArr;
        }
    }

    static {
        Date date = new Date(Long.MAX_VALUE);
        f9560g = date;
        f9561h = date;
        f9562i = new Date();
        f9563j = w.FACEBOOK_APPLICATION_WEB;
        CREATOR = new b();
    }

    public /* synthetic */ AccessToken(String str, String str2, String str3, Collection collection, Collection collection2, Collection collection3, w wVar, Date date, Date date2, Date date3, String str4, int i2, kotlin.jvm.internal.g gVar) {
        this(str, str2, str3, collection, collection2, collection3, wVar, date, date2, date3, (i2 & 1024) != 0 ? "facebook" : str4);
    }

    private final void a(StringBuilder sb) {
        sb.append(" permissions:");
        sb.append("[");
        sb.append(TextUtils.join(", ", this.l));
        sb.append("]");
    }

    private final w b(w wVar, String str) {
        if (str == null || !str.equals("instagram")) {
            return wVar;
        }
        int i2 = d.a[wVar.ordinal()];
        if (i2 == 1) {
            return w.INSTAGRAM_APPLICATION_WEB;
        }
        if (i2 != 2) {
            return i2 != 3 ? wVar : w.INSTAGRAM_WEB_VIEW;
        }
        return w.INSTAGRAM_CUSTOM_CHROME_TAB;
    }

    private final String p() {
        a0 a0Var = a0.a;
        return a0.y(g0.INCLUDE_ACCESS_TOKENS) ? this.o : "ACCESS_TOKEN_REMOVED";
    }

    public final String c() {
        return this.r;
    }

    public final Date d() {
        return this.t;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final Set<String> e() {
        return this.m;
    }

    public boolean equals(Object obj) {
        boolean zA;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AccessToken)) {
            return false;
        }
        AccessToken accessToken = (AccessToken) obj;
        if (kotlin.jvm.internal.m.a(this.f9564k, accessToken.f9564k) && kotlin.jvm.internal.m.a(this.l, accessToken.l) && kotlin.jvm.internal.m.a(this.m, accessToken.m) && kotlin.jvm.internal.m.a(this.n, accessToken.n) && kotlin.jvm.internal.m.a(this.o, accessToken.o) && this.p == accessToken.p && kotlin.jvm.internal.m.a(this.q, accessToken.q) && kotlin.jvm.internal.m.a(this.r, accessToken.r) && kotlin.jvm.internal.m.a(this.s, accessToken.s) && kotlin.jvm.internal.m.a(this.t, accessToken.t)) {
            String str = this.u;
            String str2 = accessToken.u;
            if (str == null) {
                zA = str2 == null;
            } else {
                zA = kotlin.jvm.internal.m.a(str, str2);
            }
            if (zA) {
                return true;
            }
        }
        return false;
    }

    public final Set<String> f() {
        return this.n;
    }

    public final Date g() {
        return this.f9564k;
    }

    public final String h() {
        return this.u;
    }

    public int hashCode() {
        int iHashCode = (((((((((((((((((((527 + this.f9564k.hashCode()) * 31) + this.l.hashCode()) * 31) + this.m.hashCode()) * 31) + this.n.hashCode()) * 31) + this.o.hashCode()) * 31) + this.p.hashCode()) * 31) + this.q.hashCode()) * 31) + this.r.hashCode()) * 31) + this.s.hashCode()) * 31) + this.t.hashCode()) * 31;
        String str = this.u;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final Date i() {
        return this.q;
    }

    public final Set<String> j() {
        return this.l;
    }

    public final w k() {
        return this.p;
    }

    public final String l() {
        return this.o;
    }

    public final String m() {
        return this.s;
    }

    public final boolean n() {
        return new Date().after(this.f9564k);
    }

    public final JSONObject o() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("version", 1);
        jSONObject.put("token", this.o);
        jSONObject.put("expires_at", this.f9564k.getTime());
        jSONObject.put("permissions", new JSONArray((Collection) this.l));
        jSONObject.put("declined_permissions", new JSONArray((Collection) this.m));
        jSONObject.put("expired_permissions", new JSONArray((Collection) this.n));
        jSONObject.put("last_refresh", this.q.getTime());
        jSONObject.put("source", this.p.name());
        jSONObject.put("application_id", this.r);
        jSONObject.put(TimeLineFollowFragment.BundleKeys.USER_ID, this.s);
        jSONObject.put("data_access_expiration_time", this.t.getTime());
        String str = this.u;
        if (str != null) {
            jSONObject.put("graph_domain", str);
        }
        return jSONObject;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{AccessToken");
        sb.append(" token:");
        sb.append(p());
        a(sb);
        sb.append("}");
        String string = sb.toString();
        kotlin.jvm.internal.m.e(string, "builder.toString()");
        return string;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        kotlin.jvm.internal.m.f(parcel, "dest");
        parcel.writeLong(this.f9564k.getTime());
        parcel.writeStringList(new ArrayList(this.l));
        parcel.writeStringList(new ArrayList(this.m));
        parcel.writeStringList(new ArrayList(this.n));
        parcel.writeString(this.o);
        parcel.writeString(this.p.name());
        parcel.writeLong(this.q.getTime());
        parcel.writeString(this.r);
        parcel.writeString(this.s);
        parcel.writeLong(this.t.getTime());
        parcel.writeString(this.u);
    }

    public AccessToken(String str, String str2, String str3, Collection<String> collection, Collection<String> collection2, Collection<String> collection3, w wVar, Date date, Date date2, Date date3, String str4) {
        kotlin.jvm.internal.m.f(str, "accessToken");
        kotlin.jvm.internal.m.f(str2, "applicationId");
        kotlin.jvm.internal.m.f(str3, AndroidAccountManagerPersistence.ACCOUNT_ID);
        q0 q0Var = q0.a;
        q0.g(str, "accessToken");
        q0.g(str2, "applicationId");
        q0.g(str3, AndroidAccountManagerPersistence.ACCOUNT_ID);
        this.f9564k = date == null ? f9561h : date;
        Set<String> setUnmodifiableSet = Collections.unmodifiableSet(collection != null ? new HashSet(collection) : new HashSet());
        kotlin.jvm.internal.m.e(setUnmodifiableSet, "unmodifiableSet(if (permissions != null) HashSet(permissions) else HashSet())");
        this.l = setUnmodifiableSet;
        Set<String> setUnmodifiableSet2 = Collections.unmodifiableSet(collection2 != null ? new HashSet(collection2) : new HashSet());
        kotlin.jvm.internal.m.e(setUnmodifiableSet2, "unmodifiableSet(\n            if (declinedPermissions != null) HashSet(declinedPermissions) else HashSet())");
        this.m = setUnmodifiableSet2;
        Set<String> setUnmodifiableSet3 = Collections.unmodifiableSet(collection3 != null ? new HashSet(collection3) : new HashSet());
        kotlin.jvm.internal.m.e(setUnmodifiableSet3, "unmodifiableSet(\n            if (expiredPermissions != null) HashSet(expiredPermissions) else HashSet())");
        this.n = setUnmodifiableSet3;
        this.o = str;
        this.p = b(wVar == null ? f9563j : wVar, str4);
        this.q = date2 == null ? f9562i : date2;
        this.r = str2;
        this.s = str3;
        this.t = (date3 == null || date3.getTime() == 0) ? f9561h : date3;
        this.u = str4 == null ? "facebook" : str4;
    }

    public AccessToken(Parcel parcel) {
        w wVarValueOf;
        kotlin.jvm.internal.m.f(parcel, "parcel");
        this.f9564k = new Date(parcel.readLong());
        ArrayList arrayList = new ArrayList();
        parcel.readStringList(arrayList);
        Set<String> setUnmodifiableSet = Collections.unmodifiableSet(new HashSet(arrayList));
        kotlin.jvm.internal.m.e(setUnmodifiableSet, "unmodifiableSet(HashSet(permissionsList))");
        this.l = setUnmodifiableSet;
        arrayList.clear();
        parcel.readStringList(arrayList);
        Set<String> setUnmodifiableSet2 = Collections.unmodifiableSet(new HashSet(arrayList));
        kotlin.jvm.internal.m.e(setUnmodifiableSet2, "unmodifiableSet(HashSet(permissionsList))");
        this.m = setUnmodifiableSet2;
        arrayList.clear();
        parcel.readStringList(arrayList);
        Set<String> setUnmodifiableSet3 = Collections.unmodifiableSet(new HashSet(arrayList));
        kotlin.jvm.internal.m.e(setUnmodifiableSet3, "unmodifiableSet(HashSet(permissionsList))");
        this.n = setUnmodifiableSet3;
        String string = parcel.readString();
        q0 q0Var = q0.a;
        this.o = q0.k(string, "token");
        String string2 = parcel.readString();
        if (string2 != null) {
            wVarValueOf = w.valueOf(string2);
        } else {
            wVarValueOf = f9563j;
        }
        this.p = wVarValueOf;
        this.q = new Date(parcel.readLong());
        this.r = q0.k(parcel.readString(), "applicationId");
        this.s = q0.k(parcel.readString(), AndroidAccountManagerPersistence.ACCOUNT_ID);
        this.t = new Date(parcel.readLong());
        this.u = parcel.readString();
    }
}
