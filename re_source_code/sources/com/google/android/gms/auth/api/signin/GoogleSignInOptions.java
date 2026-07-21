package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.auth.api.signin.internal.HashAccumulator;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class
public class GoogleSignInOptions extends AbstractSafeParcelable implements Api.ApiOptions.Optional, ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInOptions> CREATOR;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @VisibleForTesting
    public static final Scope f11504f = new Scope("profile");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @VisibleForTesting
    public static final Scope f11505g = new Scope("email");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @VisibleForTesting
    public static final Scope f11506h = new Scope("openid");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @VisibleForTesting
    public static final Scope f11507i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @VisibleForTesting
    public static final Scope f11508j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final GoogleSignInOptions f11509k;
    public static final GoogleSignInOptions l;
    private static Comparator<Scope> m;

    @SafeParcelable.VersionField
    private final int n;

    @SafeParcelable.Field
    private final ArrayList<Scope> o;

    @SafeParcelable.Field
    private Account p;

    @SafeParcelable.Field
    private boolean q;

    @SafeParcelable.Field
    private final boolean r;

    @SafeParcelable.Field
    private final boolean s;

    @SafeParcelable.Field
    private String t;

    @SafeParcelable.Field
    private String u;

    @SafeParcelable.Field
    private ArrayList<GoogleSignInOptionsExtensionParcelable> v;
    private Map<Integer, GoogleSignInOptionsExtensionParcelable> w;

    static {
        Scope scope = new Scope("https://www.googleapis.com/auth/games_lite");
        f11507i = scope;
        f11508j = new Scope("https://www.googleapis.com/auth/games");
        f11509k = new Builder().c().d().a();
        l = new Builder().e(scope, new Scope[0]).a();
        CREATOR = new zad();
        m = new b();
    }

    @SafeParcelable.Constructor
    GoogleSignInOptions(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) ArrayList<Scope> arrayList, @SafeParcelable.Param(id = 3) Account account, @SafeParcelable.Param(id = 4) boolean z, @SafeParcelable.Param(id = 5) boolean z2, @SafeParcelable.Param(id = 6) boolean z3, @SafeParcelable.Param(id = 7) String str, @SafeParcelable.Param(id = 8) String str2, @SafeParcelable.Param(id = 9) ArrayList<GoogleSignInOptionsExtensionParcelable> arrayList2) {
        this(i2, arrayList, account, z, z2, z3, str, str2, J0(arrayList2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<Integer, GoogleSignInOptionsExtensionParcelable> J0(List<GoogleSignInOptionsExtensionParcelable> list) {
        HashMap map = new HashMap();
        if (list == null) {
            return map;
        }
        for (GoogleSignInOptionsExtensionParcelable googleSignInOptionsExtensionParcelable : list) {
            map.put(Integer.valueOf(googleSignInOptionsExtensionParcelable.y()), googleSignInOptionsExtensionParcelable);
        }
        return map;
    }

    public static GoogleSignInOptions M0(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("scopes");
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            hashSet.add(new Scope(jSONArray.getString(i2)));
        }
        String strOptString = jSONObject.optString("accountName", null);
        return new GoogleSignInOptions(3, (ArrayList<Scope>) new ArrayList(hashSet), !TextUtils.isEmpty(strOptString) ? new Account(strOptString, "com.google") : null, jSONObject.getBoolean("idTokenRequested"), jSONObject.getBoolean("serverAuthRequested"), jSONObject.getBoolean("forceCodeForRefreshToken"), jSONObject.optString("serverClientId", null), jSONObject.optString("hostedDomain", null), new HashMap());
    }

    private final JSONObject r1() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.o, m);
            ArrayList<Scope> arrayList = this.o;
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Scope scope = arrayList.get(i2);
                i2++;
                jSONArray.put(scope.y());
            }
            jSONObject.put("scopes", jSONArray);
            Account account = this.p;
            if (account != null) {
                jSONObject.put("accountName", account.name);
            }
            jSONObject.put("idTokenRequested", this.q);
            jSONObject.put("forceCodeForRefreshToken", this.s);
            jSONObject.put("serverAuthRequested", this.r);
            if (!TextUtils.isEmpty(this.t)) {
                jSONObject.put("serverClientId", this.t);
            }
            if (!TextUtils.isEmpty(this.u)) {
                jSONObject.put("hostedDomain", this.u);
            }
            return jSONObject;
        } catch (JSONException e2) {
            throw new RuntimeException(e2);
        }
    }

    @KeepForSdk
    public String W() {
        return this.t;
    }

    @KeepForSdk
    public boolean Y() {
        return this.s;
    }

    @KeepForSdk
    public boolean e0() {
        return this.q;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0051 A[Catch: ClassCastException -> 0x0082, TryCatch #0 {ClassCastException -> 0x0082, blocks: (B:5:0x0004, B:7:0x000e, B:10:0x0017, B:12:0x0027, B:15:0x0034, B:17:0x0038, B:22:0x0049, B:24:0x0051, B:29:0x0068, B:31:0x0070, B:33:0x0078, B:27:0x005c, B:20:0x003f), top: B:39:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:26:0x005b  */
    /* JADX WARN: Code duplicated, block: B:27:0x005c A[Catch: ClassCastException -> 0x0082, TryCatch #0 {ClassCastException -> 0x0082, blocks: (B:5:0x0004, B:7:0x000e, B:10:0x0017, B:12:0x0027, B:15:0x0034, B:17:0x0038, B:22:0x0049, B:24:0x0051, B:29:0x0068, B:31:0x0070, B:33:0x0078, B:27:0x005c, B:20:0x003f), top: B:39:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x0068 A[Catch: ClassCastException -> 0x0082, TryCatch #0 {ClassCastException -> 0x0082, blocks: (B:5:0x0004, B:7:0x000e, B:10:0x0017, B:12:0x0027, B:15:0x0034, B:17:0x0038, B:22:0x0049, B:24:0x0051, B:29:0x0068, B:31:0x0070, B:33:0x0078, B:27:0x005c, B:20:0x003f), top: B:39:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x0070 A[Catch: ClassCastException -> 0x0082, TryCatch #0 {ClassCastException -> 0x0082, blocks: (B:5:0x0004, B:7:0x000e, B:10:0x0017, B:12:0x0027, B:15:0x0034, B:17:0x0038, B:22:0x0049, B:24:0x0051, B:29:0x0068, B:31:0x0070, B:33:0x0078, B:27:0x005c, B:20:0x003f), top: B:39:0x0004 }] */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            GoogleSignInOptions googleSignInOptions = (GoogleSignInOptions) obj;
            if (this.v.size() <= 0 && googleSignInOptions.v.size() <= 0 && this.o.size() == googleSignInOptions.z().size() && this.o.containsAll(googleSignInOptions.z())) {
                Account account = this.p;
                if (account == null) {
                    if (googleSignInOptions.getAccount() == null) {
                        if (TextUtils.isEmpty(this.t)) {
                            if (TextUtils.isEmpty(googleSignInOptions.W())) {
                                if (this.s != googleSignInOptions.Y() && this.q == googleSignInOptions.e0() && this.r == googleSignInOptions.i0()) {
                                    return true;
                                }
                            }
                        } else if (this.t.equals(googleSignInOptions.W())) {
                            if (this.s != googleSignInOptions.Y()) {
                            }
                        }
                    }
                } else if (account.equals(googleSignInOptions.getAccount())) {
                    if (TextUtils.isEmpty(this.t)) {
                        if (TextUtils.isEmpty(googleSignInOptions.W())) {
                            if (this.s != googleSignInOptions.Y()) {
                            }
                        }
                    } else if (this.t.equals(googleSignInOptions.W())) {
                        if (this.s != googleSignInOptions.Y()) {
                        }
                    }
                }
            }
        } catch (ClassCastException unused) {
        }
        return false;
    }

    @KeepForSdk
    public Account getAccount() {
        return this.p;
    }

    public int hashCode() {
        ArrayList arrayList = new ArrayList();
        ArrayList<Scope> arrayList2 = this.o;
        int size = arrayList2.size();
        int i2 = 0;
        while (i2 < size) {
            Scope scope = arrayList2.get(i2);
            i2++;
            arrayList.add(scope.y());
        }
        Collections.sort(arrayList);
        return new HashAccumulator().a(arrayList).a(this.p).a(this.t).c(this.s).c(this.q).c(this.r).b();
    }

    @KeepForSdk
    public boolean i0() {
        return this.r;
    }

    public final String t1() {
        return r1().toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 1, this.n);
        SafeParcelWriter.y(parcel, 2, z(), false);
        SafeParcelWriter.s(parcel, 3, getAccount(), i2, false);
        SafeParcelWriter.c(parcel, 4, e0());
        SafeParcelWriter.c(parcel, 5, i0());
        SafeParcelWriter.c(parcel, 6, Y());
        SafeParcelWriter.u(parcel, 7, W(), false);
        SafeParcelWriter.u(parcel, 8, this.u, false);
        SafeParcelWriter.y(parcel, 9, y(), false);
        SafeParcelWriter.b(parcel, iA);
    }

    @KeepForSdk
    public ArrayList<GoogleSignInOptionsExtensionParcelable> y() {
        return this.v;
    }

    @KeepForSdk
    public ArrayList<Scope> z() {
        return new ArrayList<>(this.o);
    }

    public static final class Builder {
        private Set<Scope> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f11510b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f11511c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f11512d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f11513e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Account f11514f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f11515g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private Map<Integer, GoogleSignInOptionsExtensionParcelable> f11516h;

        public Builder() {
            this.a = new HashSet();
            this.f11516h = new HashMap();
        }

        private final String h(String str) {
            Preconditions.g(str);
            String str2 = this.f11513e;
            Preconditions.b(str2 == null || str2.equals(str), "two different server client ids provided");
            return str;
        }

        public final GoogleSignInOptions a() {
            if (this.a.contains(GoogleSignInOptions.f11508j)) {
                Set<Scope> set = this.a;
                Scope scope = GoogleSignInOptions.f11507i;
                if (set.contains(scope)) {
                    this.a.remove(scope);
                }
            }
            if (this.f11512d && (this.f11514f == null || !this.a.isEmpty())) {
                c();
            }
            return new GoogleSignInOptions(3, new ArrayList(this.a), this.f11514f, this.f11512d, this.f11510b, this.f11511c, this.f11513e, this.f11515g, this.f11516h, null);
        }

        public final Builder b() {
            this.a.add(GoogleSignInOptions.f11505g);
            return this;
        }

        public final Builder c() {
            this.a.add(GoogleSignInOptions.f11506h);
            return this;
        }

        public final Builder d() {
            this.a.add(GoogleSignInOptions.f11504f);
            return this;
        }

        public final Builder e(Scope scope, Scope... scopeArr) {
            this.a.add(scope);
            this.a.addAll(Arrays.asList(scopeArr));
            return this;
        }

        public final Builder f(String str) {
            return g(str, false);
        }

        public final Builder g(String str, boolean z) {
            this.f11510b = true;
            this.f11513e = h(str);
            this.f11511c = z;
            return this;
        }

        public Builder(GoogleSignInOptions googleSignInOptions) {
            this.a = new HashSet();
            this.f11516h = new HashMap();
            Preconditions.k(googleSignInOptions);
            this.a = new HashSet(googleSignInOptions.o);
            this.f11510b = googleSignInOptions.r;
            this.f11511c = googleSignInOptions.s;
            this.f11512d = googleSignInOptions.q;
            this.f11513e = googleSignInOptions.t;
            this.f11514f = googleSignInOptions.p;
            this.f11515g = googleSignInOptions.u;
            this.f11516h = GoogleSignInOptions.J0(googleSignInOptions.v);
        }
    }

    private GoogleSignInOptions(int i2, ArrayList<Scope> arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, Map<Integer, GoogleSignInOptionsExtensionParcelable> map) {
        this.n = i2;
        this.o = arrayList;
        this.p = account;
        this.q = z;
        this.r = z2;
        this.s = z3;
        this.t = str;
        this.u = str2;
        this.v = new ArrayList<>(map.values());
        this.w = map;
    }

    /* synthetic */ GoogleSignInOptions(int i2, ArrayList arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, Map map, b bVar) {
        this(3, (ArrayList<Scope>) arrayList, account, z, z2, z3, str, str2, (Map<Integer, GoogleSignInOptionsExtensionParcelable>) map);
    }
}
