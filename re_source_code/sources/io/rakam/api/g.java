package io.rakam.api;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.text.TextUtils;
import android.util.Pair;
import cm.aptoide.pt.BuildConfig;
import cm.aptoide.pt.account.AccountAnalytics;
import cm.aptoide.pt.notification.sync.LocalNotificationSyncManager;
import cm.aptoide.pt.timeline.view.follow.TimeLineFollowFragment;
import java.io.IOException;
import java.net.ConnectException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: RakamClient.java */
/* JADX INFO: loaded from: classes.dex */
public class g {
    public static final MediaType a = MediaType.parse("application/json; charset=utf-8");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final io.rakam.api.h f21949b = io.rakam.api.h.d();
    private long A;
    private long B;
    private boolean C;
    private int D;
    private boolean E;
    private boolean F;
    private boolean G;
    private JSONObject H;
    private boolean I;
    private AtomicBoolean J;
    AtomicBoolean K;
    Throwable L;
    private String M;
    k N;
    k O;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected Context f21950c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected OkHttpClient f21951d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected io.rakam.api.b f21952e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected String f21953f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected String f21954g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected String f21955h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected String f21956i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f21957j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f21958k;
    protected boolean l;
    private boolean m;
    private boolean n;
    io.rakam.api.i o;
    protected String p;
    long q;
    long r;
    long s;
    long t;
    long u;
    private io.rakam.api.d v;
    private int w;
    private int x;
    private int y;
    private long z;

    /* JADX INFO: compiled from: RakamClient.java */
    /* JADX INFO: loaded from: classes2.dex */
    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ g f21959f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f21960g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f21961h;

        a(g gVar, boolean z, String str) {
            this.f21959f = gVar;
            this.f21960g = z;
            this.f21961h = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (j.d(this.f21959f.f21953f)) {
                return;
            }
            if (this.f21960g && g.this.F) {
                g.this.S("_session_end");
            }
            g gVar = this.f21959f;
            String str = this.f21961h;
            gVar.f21955h = str;
            g.this.f21952e.Y(TimeLineFollowFragment.BundleKeys.USER_ID, str);
            if (this.f21960g) {
                long jU = g.this.u();
                g.this.b0(jU);
                g.this.N(jU);
                if (g.this.F) {
                    g.this.S("_session_start");
                }
            }
        }
    }

    /* JADX INFO: compiled from: RakamClient.java */
    /* JADX INFO: loaded from: classes2.dex */
    class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ g f21963f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f21964g;

        b(g gVar, String str) {
            this.f21963f = gVar;
            this.f21964g = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (j.d(this.f21963f.f21953f)) {
                return;
            }
            g gVar = this.f21963f;
            String str = this.f21964g;
            gVar.f21956i = str;
            g.this.Q(str);
        }
    }

    /* JADX INFO: compiled from: RakamClient.java */
    /* JADX INFO: loaded from: classes2.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.J.set(false);
            g.this.l0();
        }
    }

    /* JADX INFO: compiled from: RakamClient.java */
    /* JADX INFO: loaded from: classes2.dex */
    class d implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f21967f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ long f21968g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ long f21969h;

        d(String str, long j2, long j3) {
            this.f21967f = str;
            this.f21968g = j2;
            this.f21969h = j3;
        }

        @Override // java.lang.Runnable
        public void run() {
            g gVar = g.this;
            gVar.I(gVar.f21951d, this.f21967f, this.f21968g, this.f21969h);
        }
    }

    /* JADX INFO: compiled from: RakamClient.java */
    /* JADX INFO: loaded from: classes2.dex */
    class e implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f21971f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ long f21972g;

        /* JADX INFO: compiled from: RakamClient.java */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                g gVar = g.this;
                gVar.m0(gVar.C);
            }
        }

        e(long j2, long j3) {
            this.f21971f = j2;
            this.f21972g = j3;
        }

        @Override // java.lang.Runnable
        public void run() {
            long j2 = this.f21971f;
            if (j2 >= 0) {
                g.this.f21952e.m0(j2);
            }
            long j3 = this.f21972g;
            if (j3 >= 0) {
                g.this.f21952e.q0(j3);
            }
            g.this.K.set(false);
            if (g.this.f21952e.J() > g.this.w) {
                g.this.N.a(new a());
                return;
            }
            g.this.C = false;
            g gVar = g.this;
            gVar.D = gVar.x;
        }
    }

    /* JADX INFO: compiled from: RakamClient.java */
    /* JADX INFO: loaded from: classes2.dex */
    class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.K.set(false);
            g.this.m0(true);
        }
    }

    /* JADX INFO: renamed from: io.rakam.api.g$g, reason: collision with other inner class name */
    /* JADX INFO: compiled from: RakamClient.java */
    /* JADX INFO: loaded from: classes2.dex */
    class C0306g implements Thread.UncaughtExceptionHandler {
        C0306g() {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            g.f21949b.c("RakamClient", "Unknown exception thrown from log thread.", th);
        }
    }

    /* JADX INFO: compiled from: RakamClient.java */
    /* JADX INFO: loaded from: classes2.dex */
    class h implements Thread.UncaughtExceptionHandler {
        h() {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            g.f21949b.c("RakamClient", "Unknown exception thrown from HTTP thread.", th);
        }
    }

    /* JADX INFO: compiled from: RakamClient.java */
    /* JADX INFO: loaded from: classes2.dex */
    class i implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Context f21978f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f21979g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f21980h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f21981i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ g f21982j;

        /* JADX INFO: compiled from: RakamClient.java */
        class a implements io.rakam.api.c {
            a() {
            }

            @Override // io.rakam.api.c
            public void a(SQLiteDatabase sQLiteDatabase) {
                i iVar = i.this;
                g.this.f21952e.Z(sQLiteDatabase, AccountAnalytics.STORE, "device_id", iVar.f21982j.f21956i);
                i iVar2 = i.this;
                g.this.f21952e.Z(sQLiteDatabase, AccountAnalytics.STORE, TimeLineFollowFragment.BundleKeys.USER_ID, iVar2.f21982j.f21955h);
                i iVar3 = i.this;
                g.this.f21952e.Z(sQLiteDatabase, "long_store", "opt_out", Long.valueOf(iVar3.f21982j.m ? 1L : 0L));
                i iVar4 = i.this;
                g.this.f21952e.Z(sQLiteDatabase, "long_store", "previous_session_id", Long.valueOf(iVar4.f21982j.q));
                i iVar5 = i.this;
                g.this.f21952e.Z(sQLiteDatabase, "long_store", "last_event_time", Long.valueOf(iVar5.f21982j.t));
            }
        }

        i(Context context, boolean z, String str, String str2, g gVar) {
            this.f21978f = context;
            this.f21979g = z;
            this.f21980h = str;
            this.f21981i = str2;
            this.f21982j = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            g gVar = g.this;
            if (gVar.l) {
                return;
            }
            try {
                if (gVar.f21954g.equals("$default_instance")) {
                    g.o0(this.f21978f);
                    g.q0(this.f21978f);
                }
                g.this.f21951d = new OkHttpClient();
                g.this.v = new io.rakam.api.d(this.f21978f);
                g gVar2 = g.this;
                gVar2.f21956i = gVar2.C();
                if (this.f21979g) {
                    io.rakam.api.e eVarE = io.rakam.api.e.e();
                    g gVar3 = g.this;
                    eVarE.c(gVar3.f21951d, this.f21980h, gVar3.f21956i);
                }
                g.this.v.s();
                String str = this.f21981i;
                if (str != null) {
                    this.f21982j.f21955h = str;
                    g.this.f21952e.Y(TimeLineFollowFragment.BundleKeys.USER_ID, str);
                } else {
                    this.f21982j.f21955h = g.this.f21952e.K(TimeLineFollowFragment.BundleKeys.USER_ID);
                }
                Long lB = g.this.f21952e.B("opt_out");
                g.this.m = lB != null && lB.longValue() == 1;
                g gVar4 = g.this;
                gVar4.u = gVar4.w("previous_session_id", -1L);
                g gVar5 = g.this;
                long j2 = gVar5.u;
                if (j2 >= 0) {
                    gVar5.q = j2;
                }
                gVar5.r = gVar5.w("last_event_id", -1L);
                g gVar6 = g.this;
                gVar6.s = gVar6.w("last_identify_id", -1L);
                g gVar7 = g.this;
                gVar7.t = gVar7.w("last_event_time", -1L);
                g.this.f21952e.x0(new a());
                g gVar8 = g.this;
                gVar8.l = true;
                String strK = gVar8.f21952e.K("super_properties");
                if (strK != null) {
                    try {
                        g.this.H = new JSONObject(strK);
                    } catch (JSONException unused) {
                        g.this.f21952e.Y("super_properties", null);
                    }
                }
            } catch (CursorWindowAllocationException e2) {
                g.f21949b.b("RakamClient", String.format("Failed to initialize Rakam SDK due to: %s", e2.getMessage()));
                io.rakam.api.e.e().g("Failed to initialize Rakam SDK", e2);
                this.f21982j.f21953f = null;
            }
        }
    }

    public g() {
        this(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String C() {
        Set<String> setV = v();
        String strK = this.f21952e.K("device_id");
        String strC = j.c(this.f21950c, this.f21954g, "device_id");
        if (!j.d(strK) && !setV.contains(strK)) {
            if (!strK.equals(strC)) {
                Q(strK);
            }
            return strK;
        }
        if (!j.d(strC) && !setV.contains(strC)) {
            Q(strC);
            return strC;
        }
        if (!this.f21957j && this.f21958k && !this.v.q()) {
            String strC2 = this.v.c();
            if (!j.d(strC2) && !setV.contains(strC2)) {
                Q(strC2);
                return strC2;
            }
        }
        String str = io.rakam.api.d.b() + "R";
        Q(str);
        return str;
    }

    private boolean D(long j2) {
        return j2 - this.t < (this.E ? this.A : this.B);
    }

    private static void K(SharedPreferences sharedPreferences, String str, boolean z, io.rakam.api.b bVar, String str2) {
        if (bVar.B(str2) != null) {
            return;
        }
        bVar.W(str2, Long.valueOf(sharedPreferences.getBoolean(str, z) ? 1L : 0L));
        sharedPreferences.edit().remove(str).apply();
    }

    private static void L(SharedPreferences sharedPreferences, String str, long j2, io.rakam.api.b bVar, String str2) {
        if (bVar.B(str2) != null) {
            return;
        }
        bVar.W(str2, Long.valueOf(sharedPreferences.getLong(str, j2)));
        sharedPreferences.edit().remove(str).apply();
    }

    private static void M(SharedPreferences sharedPreferences, String str, String str2, io.rakam.api.b bVar, String str3) {
        if (j.d(bVar.K(str3))) {
            String string = sharedPreferences.getString(str, str2);
            if (j.d(string)) {
                return;
            }
            bVar.Y(str3, string);
            sharedPreferences.edit().remove(str).apply();
        }
    }

    private void P(Runnable runnable) {
        Thread threadCurrentThread = Thread.currentThread();
        k kVar = this.N;
        if (threadCurrentThread != kVar) {
            kVar.a(runnable);
        } else {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(String str) {
        this.f21952e.Y("device_id", str);
        j.f(this.f21950c, this.f21954g, "device_id", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(String str) {
        if (s(String.format("sendSessionEvent('%s')", str)) && y()) {
            E(str, null, this.t, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0(long j2) {
        this.q = j2;
        a0(j2);
    }

    private void f0(long j2) {
        if (this.F) {
            S("_session_end");
        }
        b0(j2);
        N(j2);
        if (this.F) {
            S("_session_start");
        }
    }

    static String i0(String str) {
        return str.length() <= 1024 ? str : str.substring(0, 1024);
    }

    private void n0(long j2) {
        if (this.J.getAndSet(true)) {
            return;
        }
        this.N.b(new c(), j2);
    }

    static boolean o0(Context context) {
        return p0(context, null, null);
    }

    static boolean p0(Context context, String str, String str2) {
        if (str == null) {
            try {
                str = io.rakam.api.a.class.getPackage().getName();
            } catch (Exception unused) {
                str = "io.rakam.api";
            }
        }
        if (str2 == null) {
            str2 = "io.rakam.api";
        }
        try {
            if (str2.equals(str)) {
                return false;
            }
            String str3 = str + "." + context.getPackageName();
            SharedPreferences sharedPreferences = context.getSharedPreferences(str3, 0);
            if (sharedPreferences.getAll().size() == 0) {
                return false;
            }
            String str4 = str2 + "." + context.getPackageName();
            SharedPreferences.Editor editorEdit = context.getSharedPreferences(str4, 0).edit();
            if (sharedPreferences.contains(str + ".previousSessionId")) {
                editorEdit.putLong("io.rakam.api.previousSessionId", sharedPreferences.getLong(str + ".previousSessionId", -1L));
            }
            if (sharedPreferences.contains(str + ".deviceId")) {
                editorEdit.putString("io.rakam.api.deviceId", sharedPreferences.getString(str + ".deviceId", null));
            }
            if (sharedPreferences.contains(str + ".userId")) {
                editorEdit.putString("io.rakam.api.userId", sharedPreferences.getString(str + ".userId", null));
            }
            if (sharedPreferences.contains(str + ".optOut")) {
                editorEdit.putBoolean("io.rakam.api.optOut", sharedPreferences.getBoolean(str + ".optOut", false));
            }
            editorEdit.apply();
            sharedPreferences.edit().clear().apply();
            f21949b.e("RakamClient", "Upgraded shared preferences from " + str3 + " to " + str4);
            return true;
        } catch (Exception e2) {
            f21949b.c("RakamClient", "Error upgrading shared preferences", e2);
            io.rakam.api.e.e().g("Failed to upgrade shared prefs", e2);
            return false;
        }
    }

    static boolean q0(Context context) {
        return r0(context, null);
    }

    static boolean r0(Context context, String str) {
        if (str == null) {
            str = "io.rakam.api";
        }
        io.rakam.api.b bVarJ = io.rakam.api.b.j(context);
        String strK = bVarJ.K("device_id");
        Long lB = bVarJ.B("previous_session_id");
        Long lB2 = bVarJ.B("last_event_time");
        if (!j.d(strK) && lB != null && lB2 != null) {
            return true;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(str + "." + context.getPackageName(), 0);
        M(sharedPreferences, "io.rakam.api.deviceId", null, bVarJ, "device_id");
        L(sharedPreferences, "io.rakam.api.lastEventTime", -1L, bVarJ, "last_event_time");
        L(sharedPreferences, "io.rakam.api.lastEventId", -1L, bVarJ, "last_event_id");
        L(sharedPreferences, "io.rakam.api.lastIdentifyId", -1L, bVarJ, "last_identify_id");
        L(sharedPreferences, "io.rakam.api.previousSessionId", -1L, bVarJ, "previous_session_id");
        M(sharedPreferences, "io.rakam.api.userId", null, bVarJ, TimeLineFollowFragment.BundleKeys.USER_ID);
        K(sharedPreferences, "io.rakam.api.optOut", false, bVarJ, "opt_out");
        return true;
    }

    private JSONObject t() throws JSONException {
        return new JSONObject().put("api_key", this.f21953f).put("library", new JSONObject().put("name", "rakam-android").put("version", "2.7.14")).put("upload_time", u());
    }

    private Set<String> v() {
        HashSet hashSet = new HashSet();
        hashSet.add(HttpUrl.FRAGMENT_ENCODE_SET);
        hashSet.add("9774d56d682e549c");
        hashSet.add("unknown");
        hashSet.add("000000000000000");
        hashSet.add("00000000-0000-0000-0000-000000000000");
        hashSet.add("Android");
        hashSet.add("DEFACE");
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long w(String str, long j2) {
        Long lB = this.f21952e.B(str);
        return lB == null ? j2 : lB.longValue();
    }

    private boolean y() {
        return this.q >= 0;
    }

    public synchronized g A(Context context, URL url, String str, String str2) {
        return B(context, url, str, str2, null, true);
    }

    public synchronized g B(Context context, URL url, String str, String str2, String str3, boolean z) {
        try {
            if (context == null) {
                f21949b.b("RakamClient", "Argument context cannot be null in initialize()");
                return this;
            }
            T(url);
            if (TextUtils.isEmpty(str)) {
                f21949b.b("RakamClient", "Argument apiKey cannot be null or blank in initialize()");
                return this;
            }
            Context applicationContext = context.getApplicationContext();
            this.f21950c = applicationContext;
            this.f21953f = str;
            this.f21952e = io.rakam.api.b.k(applicationContext, this.f21954g);
            if (j.d(str3)) {
                str3 = "Android";
            }
            this.p = str3;
            P(new i(context, z, str, str2, this));
            return this;
        } catch (Throwable th) {
            throw th;
        }
    }

    protected long E(String str, JSONObject jSONObject, long j2, boolean z) {
        Location locationL;
        f21949b.a("RakamClient", "Logged event to Rakam: " + str);
        if (this.m) {
            return -1L;
        }
        if (!(this.F && (str.equals("_session_start") || str.equals("_session_end"))) && !z) {
            if (this.G) {
                N(j2);
            } else {
                g0(j2);
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("_id", UUID.randomUUID().toString());
            jSONObject2.put("_local_id", this.r);
            jSONObject2.put("_time", j2);
            jSONObject2.put("_user", O(this.f21955h));
            jSONObject2.put("_device_id", O(this.f21956i));
            jSONObject2.put("_session_id", z ? -1L : this.q);
            if (this.o.m()) {
                jSONObject2.put("_version_name", O(this.v.o()));
            }
            if (this.o.j()) {
                jSONObject2.put("_os_name", O(this.v.m()));
            }
            if (this.o.k()) {
                jSONObject2.put("_os_version", O(this.v.n()));
            }
            if (this.o.d()) {
                jSONObject2.put("_device_brand", O(this.v.d()));
            }
            if (this.o.e()) {
                jSONObject2.put("_device_manufacturer", O(this.v.j()));
            }
            if (this.o.f()) {
                jSONObject2.put("_device_model", O(this.v.k()));
            }
            if (this.o.b()) {
                jSONObject2.put("_carrier", O(this.v.f()));
            }
            if (this.o.c()) {
                jSONObject2.put("_country_code", O(this.v.g()));
            }
            if (this.o.h()) {
                jSONObject2.put("_language", O(this.v.i()));
            }
            if (this.o.l()) {
                jSONObject2.put("_platform", this.p);
            }
            jSONObject2.put("_library_name", "rakam-android");
            jSONObject2.put("_library_version", "2.7.14");
            jSONObject2.put("_ip", true);
            if (this.o.i() && (locationL = this.v.l()) != null) {
                jSONObject2.put("_latitude", locationL.getLatitude());
                jSONObject2.put("_longitude", locationL.getLongitude());
            }
            if (this.o.a() && this.v.c() != null) {
                jSONObject2.put("_android_adid", this.v.c());
            }
            jSONObject2.put("_limit_ad_tracking", this.v.q());
            jSONObject2.put("_gps_enabled", this.v.p());
            if (jSONObject != null) {
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    jSONObject2.put(next, jSONObject.get(next));
                }
            }
            JSONObject jSONObject3 = this.H;
            if (jSONObject3 != null) {
                Iterator<String> itKeys2 = jSONObject3.keys();
                while (itKeys2.hasNext()) {
                    String next2 = itKeys2.next();
                    if (jSONObject == null || !jSONObject.has(next2)) {
                        jSONObject2.put(next2, this.H.get(next2));
                    }
                }
            }
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("properties", k0(jSONObject2));
            jSONObject4.put("collection", O(str));
            return R(str, jSONObject4);
        } catch (JSONException e2) {
            f21949b.b("RakamClient", String.format("JSON Serialization of event type %s failed, skipping: %s", str, e2.toString()));
            io.rakam.api.e.e().g(String.format("Failed to JSON serialize event type %s", str), e2);
            return -1L;
        }
    }

    public void F(String str) {
        G(str, null);
    }

    public void G(String str, JSONObject jSONObject) {
        H(str, jSONObject, false);
    }

    public void H(String str, JSONObject jSONObject, boolean z) {
        if (s0(str)) {
            E(str, jSONObject, u(), z);
        }
    }

    protected void I(OkHttpClient okHttpClient, String str, long j2, long j3) {
        try {
            boolean z = true;
            try {
                Response responseExecute = okHttpClient.newCall(new Request.Builder().url(this.M + "/event/batch").post(RequestBody.create(a, str)).build()).execute();
                String strString = responseExecute.body().string();
                if (strString.equals("1")) {
                    try {
                        this.N.a(new e(j2, j3));
                    } catch (AssertionError e2) {
                        e = e2;
                        f21949b.c("RakamClient", "Exception:", e);
                        this.L = e;
                        io.rakam.api.e.e().g("Failed to post upload request", e);
                    } catch (ConnectException e3) {
                        e = e3;
                        this.L = e;
                        io.rakam.api.e.e().g("Failed to post upload request", e);
                    } catch (UnknownHostException e4) {
                        e = e4;
                        this.L = e;
                        io.rakam.api.e.e().g("Failed to post upload request", e);
                    } catch (IOException e5) {
                        e = e5;
                        f21949b.b("RakamClient", e.toString());
                        this.L = e;
                        io.rakam.api.e.e().g("Failed to post upload request", e);
                    } catch (Exception e6) {
                        e = e6;
                        f21949b.c("RakamClient", "Exception:", e);
                        this.L = e;
                        io.rakam.api.e.e().g("Failed to post upload request", e);
                    }
                } else {
                    if (responseExecute.code() == 403) {
                        f21949b.b("RakamClient", "Invalid API key, make sure your API key is correct in initialize()");
                    } else if (strString.equals("bad_checksum")) {
                        f21949b.g("RakamClient", "Bad checksum, post request was mangled in transit, will attempt to reupload later");
                    } else if (strString.equals("request_db_write_failed")) {
                        f21949b.g("RakamClient", "Couldn't write to request database on server, will attempt to reupload later");
                    } else if (responseExecute.code() == 413 || responseExecute.code() == 400) {
                        if (this.C && this.D == 1) {
                            if (j2 >= 0) {
                                this.f21952e.f0(j2);
                            }
                            if (j3 >= 0) {
                                this.f21952e.p0(j3);
                            }
                        }
                        this.C = true;
                        double dMin = Math.min((int) this.f21952e.m(), this.D);
                        Double.isNaN(dMin);
                        this.D = (int) Math.ceil(dMin / 2.0d);
                        f21949b.g("RakamClient", String.format("Request too large or invalid: %s, will decrease size and attempt to reupload", Integer.valueOf(responseExecute.code())));
                        this.N.a(new f());
                    } else if (responseExecute.code() == 500) {
                        f21949b.g("RakamClient", "A server error occurred, will attempt to reupload later");
                    } else {
                        f21949b.g("RakamClient", "Upload failed, " + strString + ", will attempt to reupload later");
                    }
                    z = false;
                }
            } catch (AssertionError e7) {
                e = e7;
                z = false;
            } catch (ConnectException e8) {
                e = e8;
                z = false;
            } catch (UnknownHostException e9) {
                e = e9;
                z = false;
            } catch (IOException e10) {
                e = e10;
                z = false;
            } catch (Exception e11) {
                e = e11;
                z = false;
            }
            if (z) {
                return;
            }
            this.K.set(false);
        } catch (IllegalArgumentException e12) {
            f21949b.b("RakamClient", e12.toString());
            this.K.set(false);
            io.rakam.api.e.e().g("Failed to build upload request", e12);
        }
    }

    protected Pair<Pair<Long, Long>, JSONArray> J(List<JSONObject> list, List<JSONObject> list2, long j2) throws JSONException {
        long j3;
        long j4;
        JSONArray jSONArray = new JSONArray();
        long j5 = -1;
        long j6 = -1;
        while (jSONArray.length() < j2) {
            boolean zIsEmpty = list.isEmpty();
            boolean zIsEmpty2 = list2.isEmpty();
            if (zIsEmpty && zIsEmpty2) {
                f21949b.g("RakamClient", String.format("mergeEventsAndIdentifys: number of events and identifys less than expected by %d", Long.valueOf(j2 - ((long) jSONArray.length()))));
                break;
            }
            if (zIsEmpty2) {
                JSONObject jSONObjectRemove = list.remove(0);
                j3 = jSONObjectRemove.getLong("event_id");
                jSONArray.put(jSONObjectRemove);
            } else {
                if (zIsEmpty) {
                    JSONObject jSONObjectRemove2 = list2.remove(0);
                    j4 = jSONObjectRemove2.getLong("event_id");
                    jSONArray.put(jSONObjectRemove2);
                } else if (!list.get(0).has("event_id") || list.get(0).getLong("event_id") < list2.get(0).getLong("event_id")) {
                    JSONObject jSONObjectRemove3 = list.remove(0);
                    j3 = jSONObjectRemove3.getLong("event_id");
                    jSONArray.put(jSONObjectRemove3);
                } else {
                    JSONObject jSONObjectRemove4 = list2.remove(0);
                    j4 = jSONObjectRemove4.getLong("event_id");
                    jSONArray.put(jSONObjectRemove4);
                }
                j6 = j4;
            }
            j5 = j3;
        }
        return new Pair<>(new Pair(Long.valueOf(j5), Long.valueOf(j6)), jSONArray);
    }

    void N(long j2) {
        if (y()) {
            X(j2);
        }
    }

    protected Object O(Object obj) {
        return obj == null ? JSONObject.NULL : obj;
    }

    protected long R(String str, JSONObject jSONObject) {
        String string = jSONObject.toString();
        if (j.d(string)) {
            f21949b.b("RakamClient", String.format("Detected empty event string for event type %s, skipping", str));
            return -1L;
        }
        if (str.equals("$identify")) {
            long jC = this.f21952e.c(string);
            this.s = jC;
            Y(jC);
        } else {
            long jA = this.f21952e.a(string);
            this.r = jA;
            W(jA);
        }
        int iMin = Math.min(Math.max(1, this.y / 10), 20);
        if (this.f21952e.m() > this.y) {
            io.rakam.api.b bVar = this.f21952e;
            bVar.m0(bVar.D(iMin));
        }
        if (this.f21952e.z() > this.y) {
            io.rakam.api.b bVar2 = this.f21952e;
            bVar2.q0(bVar2.I(iMin));
        }
        long J = this.f21952e.J();
        int i2 = this.w;
        if (J % ((long) i2) != 0 || J < i2) {
            n0(this.z);
        } else {
            l0();
        }
        return str.equals("$identify") ? this.s : this.r;
    }

    public void T(URL url) {
        if (url == null) {
            f21949b.b("RakamClient", "apiUrl can't be null");
            return;
        }
        String protocol = url.getProtocol();
        String host = url.getHost();
        int port = url.getPort();
        String str = protocol + "://" + host;
        if (url.getPath() != null && !url.getPath().equals("/") && !url.getPath().isEmpty()) {
            throw new IllegalStateException(String.format("Please set root address of the API address. A valid example is %s, %s is not valid.", str, url.toString()));
        }
        if (port > -1) {
            str = str + ":" + port;
        }
        this.M = str;
    }

    public g U(String str) {
        Set<String> setV = v();
        if (s("setDeviceId()") && !j.d(str) && !setV.contains(str)) {
            P(new b(this, str));
        }
        return this;
    }

    public g V(int i2) {
        this.z = i2;
        return this;
    }

    void W(long j2) {
        this.r = j2;
        this.f21952e.W("last_event_id", Long.valueOf(j2));
    }

    void X(long j2) {
        this.t = j2;
        this.f21952e.W("last_event_time", Long.valueOf(j2));
    }

    void Y(long j2) {
        this.s = j2;
        this.f21952e.W("last_identify_id", Long.valueOf(j2));
    }

    public g Z(int i2) {
        f21949b.f(i2);
        return this;
    }

    void a0(long j2) {
        this.u = j2;
        this.f21952e.W("previous_session_id", Long.valueOf(j2));
    }

    public g c0(JSONObject jSONObject) {
        this.H = jSONObject;
        this.f21952e.Y("super_properties", jSONObject.toString());
        return this;
    }

    public g d0(String str) {
        return e0(str, false);
    }

    public g e0(String str, boolean z) {
        if (!s("setUserId()")) {
            return this;
        }
        P(new a(this, z, str));
        return this;
    }

    public boolean g0(long j2) {
        if (y()) {
            if (D(j2)) {
                N(j2);
                return false;
            }
            f0(j2);
            return true;
        }
        if (!D(j2)) {
            f0(j2);
            return true;
        }
        long j3 = this.u;
        if (j3 == -1) {
            f0(j2);
            return true;
        }
        b0(j3);
        N(j2);
        return false;
    }

    public g h0(boolean z) {
        this.F = z;
        return this;
    }

    public JSONArray j0(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null) {
            return new JSONArray();
        }
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            Object obj = jSONArray.get(i2);
            if (obj.getClass().equals(String.class)) {
                jSONArray.put(i2, i0((String) obj));
            } else if (obj.getClass().equals(JSONObject.class)) {
                jSONArray.put(i2, k0((JSONObject) obj));
            } else if (obj.getClass().equals(JSONArray.class)) {
                jSONArray.put(i2, j0((JSONArray) obj));
            }
        }
        return jSONArray;
    }

    public JSONObject k0(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new JSONObject();
        }
        if (jSONObject.length() > 1000) {
            f21949b.g("RakamClient", "Warning: too many properties (more than 1000), ignoring");
            return new JSONObject();
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            try {
                Object obj = jSONObject.get(next);
                if (obj.getClass().equals(String.class)) {
                    jSONObject.put(next, i0((String) obj));
                } else if (obj.getClass().equals(JSONObject.class)) {
                    jSONObject.put(next, k0((JSONObject) obj));
                } else if (obj.getClass().equals(JSONArray.class)) {
                    jSONObject.put(next, j0((JSONArray) obj));
                }
            } catch (JSONException e2) {
                f21949b.b("RakamClient", e2.toString());
            }
        }
        return jSONObject;
    }

    protected void l0() {
        m0(false);
        io.rakam.api.e.e().d();
    }

    protected void m0(boolean z) {
        if (this.m || this.n || this.K.getAndSet(true)) {
            return;
        }
        long jMin = Math.min(z ? this.D : this.x, this.f21952e.J());
        if (jMin <= 0) {
            this.K.set(false);
            return;
        }
        try {
            try {
                Pair<Pair<Long, Long>, JSONArray> pairJ = J(this.f21952e.x(this.r, jMin), this.f21952e.A(this.s, jMin), jMin);
                if (((JSONArray) pairJ.second).length() == 0) {
                    this.K.set(false);
                    return;
                }
                try {
                    this.O.a(new d(new JSONObject().put("api", t()).put("events", pairJ.second).toString(), ((Long) ((Pair) pairJ.first).first).longValue(), ((Long) ((Pair) pairJ.first).second).longValue()));
                } catch (JSONException e2) {
                    this.K.set(false);
                    f21949b.b("RakamClient", e2.toString());
                }
            } catch (JSONException e3) {
                this.K.set(false);
                f21949b.b("RakamClient", e3.toString());
                io.rakam.api.e.e().g("Failed to update server", e3);
            }
        } catch (CursorWindowAllocationException e4) {
            this.K.set(false);
            f21949b.b("RakamClient", String.format("Caught Cursor window exception during event upload, deferring upload: %s", e4.getMessage()));
            io.rakam.api.e.e().g("Failed to update server", e4);
        }
    }

    protected synchronized boolean s(String str) {
        if (this.f21950c == null) {
            f21949b.b("RakamClient", "context cannot be null, set context with initialize() before calling " + str);
            return false;
        }
        if (!TextUtils.isEmpty(this.f21953f)) {
            return true;
        }
        f21949b.b("RakamClient", "apiKey cannot be null or empty, set apiKey with initialize() before calling " + str);
        return false;
    }

    protected boolean s0(String str) {
        if (!TextUtils.isEmpty(str)) {
            return s("logEvent()");
        }
        f21949b.b("RakamClient", "Argument eventType cannot be null or blank in logEvent()");
        return false;
    }

    protected long u() {
        return System.currentTimeMillis();
    }

    public JSONObject x() {
        return j.a(this.H);
    }

    public g z(Context context, URL url, String str) {
        return A(context, url, str, null);
    }

    public g(String str) {
        this.f21957j = false;
        this.f21958k = false;
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = new io.rakam.api.i();
        this.q = -1L;
        this.r = -1L;
        this.s = -1L;
        this.t = -1L;
        this.u = -1L;
        this.w = 30;
        this.x = 100;
        this.y = 1000;
        this.z = 30000L;
        this.A = LocalNotificationSyncManager.FIVE_MINUTES;
        this.B = BuildConfig.ANALYTICS_SESSION_INTERVAL_IN_MILLIS;
        this.C = false;
        this.D = 100;
        this.E = false;
        this.F = false;
        this.G = false;
        this.I = true;
        this.J = new AtomicBoolean(false);
        this.K = new AtomicBoolean(false);
        this.N = new k("logThread");
        this.O = new k("httpThread");
        this.f21954g = j.e(str);
        this.N.start();
        this.O.start();
        this.N.setUncaughtExceptionHandler(new C0306g());
        this.O.setUncaughtExceptionHandler(new h());
    }
}
