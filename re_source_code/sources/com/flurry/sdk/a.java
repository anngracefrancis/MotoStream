package com.flurry.sdk;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.flurry.sdk.d.c;
import com.flurry.sdk.z6.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends l2 {
    public static AtomicBoolean o = new AtomicBoolean(false);
    private static a p = null;
    public List<e.d.a.e> q;

    /* JADX INFO: renamed from: com.flurry.sdk.a$a, reason: collision with other inner class name */
    public class C0156a extends f2 {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ long f10594h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ e.d.a.c f10595i;

        public C0156a(long j2, e.d.a.c cVar) {
            this.f10594h = j2;
            this.f10595i = cVar;
        }

        @Override // com.flurry.sdk.f2
        public final void a() {
            e7.a().l.s = this.f10594h;
            e7.a().l.A(this.f10595i);
        }
    }

    public class b extends f2 {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ Context f10597h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ List f10598i;

        public b(Context context, List list) {
            this.f10597h = context;
            this.f10598i = list;
        }

        @Override // com.flurry.sdk.f2
        public final void a() throws Exception {
            m2 m2VarA = m2.a();
            m2VarA.f10915d.a();
            m2VarA.f10913b.a.a();
            z6 z6Var = m2VarA.f10914c;
            File[] fileArrListFiles = new File(q2.c()).listFiles();
            if (fileArrListFiles != null) {
                for (int i2 = 0; i2 < fileArrListFiles.length; i2++) {
                    if (fileArrListFiles[i2].isFile()) {
                        d1.c(3, "StreamingFileUtil", "File " + fileArrListFiles[i2].getName());
                    } else if (fileArrListFiles[i2].isDirectory()) {
                        d1.c(3, "StreamingFileUtil", "Directory " + fileArrListFiles[i2].getName());
                    }
                }
            }
            System.out.println();
            d1.c(2, "VNodeFileProcessor", "Number of files already pending: in startWatching " + fileArrListFiles.length);
            z6Var.e(Arrays.asList(fileArrListFiles));
            z6Var.m(z6Var.new a(z6Var));
            h2.a();
            g1.a(this.f10597h);
            h2.c(this.f10598i);
            h2.b(this.f10597h);
        }
    }

    public class c extends f2 {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f10600h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f10601i;

        public c(String str, String str2) {
            this.f10600h = str;
            this.f10601i = str2;
        }

        @Override // com.flurry.sdk.f2
        public final void a() {
            o6.j(this.f10600h, this.f10601i);
        }
    }

    public class d extends f2 {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f10603h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ Context f10604i;

        public d(int i2, Context context) {
            this.f10603h = i2;
            this.f10604i = context;
        }

        @Override // com.flurry.sdk.f2
        public final void a() {
            if (this.f10603h != e.d.a.f.a) {
                o1.a().b(this.f10604i, null);
            }
            int i2 = this.f10603h;
            int i3 = e.d.a.f.f20705b;
            if ((i2 & i3) == i3) {
                n1 n1VarA = n1.a();
                n1VarA.f10935h = true;
                if (n1VarA.f10936i) {
                    n1VarA.f();
                }
            }
            int i4 = this.f10603h;
            int i5 = e.d.a.f.f20706c;
            if ((i4 & i5) == i5) {
                q1.a().f11016e = true;
            }
        }
    }

    public class e extends f2 {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f10606h;

        public e(boolean z) {
            this.f10606h = z;
        }

        @Override // com.flurry.sdk.f2
        public final void a() throws Exception {
            e7.a().q.x(this.f10606h);
        }
    }

    final class f extends f2 {
        f() {
        }

        @Override // com.flurry.sdk.f2
        public final void a() {
            p5.h();
            e7.a().l.C(f0.FOREGROUND, true);
        }
    }

    public class g extends f2 {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f10609h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ boolean f10610i;

        public g(boolean z, boolean z2) {
            this.f10609h = z;
            this.f10610i = z2;
        }

        @Override // com.flurry.sdk.f2
        public final void a() {
            int identifier;
            com.flurry.sdk.d dVar = e7.a().f10730i;
            String strB = k0.a().b();
            boolean z = this.f10609h;
            boolean z2 = this.f10610i;
            dVar.p = strB;
            dVar.q = z;
            dVar.r = z2;
            dVar.m(dVar.new c());
            String property = System.getProperty("os.arch");
            boolean zIsEmpty = TextUtils.isEmpty(property);
            String string = HttpUrl.FRAGMENT_ENCODE_SET;
            if (zIsEmpty) {
                property = HttpUrl.FRAGMENT_ENCODE_SET;
            }
            HashMap map = new HashMap();
            map.put("device.model", Build.MODEL);
            map.put("build.brand", Build.BRAND);
            map.put("build.id", Build.ID);
            map.put("version.release", Build.VERSION.RELEASE);
            map.put("build.device", Build.DEVICE);
            map.put("build.product", Build.PRODUCT);
            l0.a();
            Context contextA = b0.a();
            if (contextA != null && (identifier = contextA.getResources().getIdentifier("com.flurry.crash.map_id", "string", contextA.getPackageName())) != 0) {
                string = contextA.getResources().getString(identifier);
            }
            map.put("proguard.build.uuid", string);
            map.put("device.arch", property);
            m2.a().b(new n5(new o5(map)));
            d5.h();
            p5.h();
            Map<String, List<String>> mapA = new v0().a();
            if (mapA.size() > 0) {
                m2.a().b(new g6(new h6(mapA)));
            }
            f5.h(e7.a().f10725d.q);
        }
    }

    public class h extends f2 {
        public h() {
        }

        @Override // com.flurry.sdk.f2
        public final void a() {
            e7.a().l.D(f0.FOREGROUND, false);
        }
    }

    final class i extends f2 {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f10613h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ v3.a f10614i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ Map f10615j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ boolean f10616k;
        final /* synthetic */ boolean l;
        final /* synthetic */ long m;
        final /* synthetic */ long n;

        i(String str, v3.a aVar, Map map, boolean z, boolean z2, long j2, long j3) {
            this.f10613h = str;
            this.f10614i = aVar;
            this.f10615j = map;
            this.f10616k = z;
            this.l = z2;
            this.m = j2;
            this.n = j3;
        }

        @Override // com.flurry.sdk.f2
        public final void a() {
            u3.h(this.f10613h, this.f10614i, this.f10615j, this.f10616k, this.l, this.m, this.n);
        }
    }

    public class j extends f2 {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f10617h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ long f10618i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ String f10619j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ Throwable f10620k;
        final /* synthetic */ Map l;

        public j(String str, long j2, String str2, Throwable th, Map map) {
            this.f10617h = str;
            this.f10618i = j2;
            this.f10619j = str2;
            this.f10620k = th;
            this.l = map;
        }

        @Override // com.flurry.sdk.f2
        public final void a() {
            e7.a().f10728g.x(this.f10617h, this.f10618i, this.f10619j, this.f10620k.getClass().getName(), this.f10620k, o7.a(), this.l);
        }
    }

    public a() {
        super("FlurryAgentImpl", i2.a(i2.b.PUBLIC_API));
        this.q = new ArrayList();
    }

    public static a v() {
        if (p == null) {
            p = new a();
        }
        return p;
    }

    public static boolean x() {
        return o.get();
    }

    public final e.d.a.d s(String str, v3.a aVar, Map<String, String> map) {
        return !c2.g(16) ? e.d.a.d.kFlurryEventFailed : t(str, aVar, map, false, false);
    }

    public final e.d.a.d t(String str, v3.a aVar, Map<String, String> map, boolean z, boolean z2) {
        if (!o.get()) {
            d1.n("FlurryAgentImpl", "Invalid call to logEvent. Flurry is not initialized");
            return null;
        }
        if (c2.b(str).length() == 0) {
            return e.d.a.d.kFlurryEventFailed;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        HashMap map2 = new HashMap();
        if (map != null) {
            map2.putAll(map);
        }
        e.d.a.d dVar = map2.size() > 10 ? e.d.a.d.kFlurryEventParamsCountExceeded : e.d.a.d.kFlurryEventRecorded;
        m(new i(str, aVar, map2, z, z2, jCurrentTimeMillis, jElapsedRealtime));
        return dVar;
    }

    public final e.d.a.d u(String str, Map<String, String> map, boolean z, boolean z2) {
        return t(str, v3.a.CUSTOM, map, z, z2);
    }

    public final void w(Context context) {
        if (context instanceof Activity) {
            d1.e("FlurryAgentImpl", "Activity's session is controlled by Flurry SDK");
        } else if (o.get()) {
            m(new f());
        } else {
            d1.n("FlurryAgentImpl", "Invalid call to onStartSession. Flurry is not initialized");
        }
    }
}
