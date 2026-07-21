package io.sentry.android.core;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.util.DisplayMetrics;
import io.sentry.c4;
import io.sentry.f5;
import io.sentry.j1;
import io.sentry.l4;
import io.sentry.m4;
import io.sentry.n1;
import io.sentry.protocol.DebugImage;
import io.sentry.s4;
import io.sentry.z4;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: AnrV2EventProcessor.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class p0 implements io.sentry.t0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Context f22248f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final SentryAndroidOptions f22249g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final s0 f22250h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final m4 f22251i;

    public p0(Context context, SentryAndroidOptions sentryAndroidOptions, s0 s0Var) {
        this.f22248f = context;
        this.f22249g = sentryAndroidOptions;
        this.f22250h = s0Var;
        this.f22251i = new m4(new z4(sentryAndroidOptions));
    }

    private void A(c4 c4Var) {
        if (c4Var.J() == null) {
            c4Var.Y((String) io.sentry.cache.s.v(this.f22249g, "release.json", String.class));
        }
    }

    private void B(c4 c4Var) {
        if (c4Var.K() == null) {
            c4Var.Z((io.sentry.protocol.l) io.sentry.cache.t.q(this.f22249g, "request.json", io.sentry.protocol.l.class));
        }
    }

    private void C(c4 c4Var) {
        Map map = (Map) io.sentry.cache.t.q(this.f22249g, "tags.json", Map.class);
        if (map == null) {
            return;
        }
        if (c4Var.N() == null) {
            c4Var.d0(new HashMap(map));
            return;
        }
        for (Map.Entry entry : map.entrySet()) {
            if (!c4Var.N().containsKey(entry.getKey())) {
                c4Var.c0((String) entry.getKey(), (String) entry.getValue());
            }
        }
    }

    private void D(c4 c4Var) {
        if (c4Var.L() == null) {
            c4Var.a0((io.sentry.protocol.o) io.sentry.cache.s.v(this.f22249g, "sdk-version.json", io.sentry.protocol.o.class));
        }
    }

    private void E(c4 c4Var) {
        try {
            t0.a aVarP = t0.p(this.f22248f, this.f22249g.getLogger(), this.f22250h);
            if (aVarP != null) {
                for (Map.Entry<String, String> entry : aVarP.a().entrySet()) {
                    c4Var.c0(entry.getKey(), entry.getValue());
                }
            }
        } catch (Throwable th) {
            this.f22249g.getLogger().b(s4.ERROR, "Error getting side loaded info.", th);
        }
    }

    private void F(l4 l4Var) {
        m(l4Var);
        E(l4Var);
    }

    private void G(l4 l4Var) {
        f5 f5Var = (f5) io.sentry.cache.t.q(this.f22249g, "trace.json", f5.class);
        if (l4Var.C().e() != null || f5Var == null || f5Var.h() == null || f5Var.k() == null) {
            return;
        }
        l4Var.C().n(f5Var);
    }

    private void H(l4 l4Var) {
        String str = (String) io.sentry.cache.t.q(this.f22249g, "transaction.json", String.class);
        if (l4Var.t0() == null) {
            l4Var.E0(str);
        }
    }

    private void I(c4 c4Var) {
        if (c4Var.Q() == null) {
            c4Var.e0((io.sentry.protocol.a0) io.sentry.cache.t.q(this.f22249g, "user.json", io.sentry.protocol.a0.class));
        }
    }

    private void a(l4 l4Var, Object obj) {
        A(l4Var);
        t(l4Var);
        s(l4Var);
        q(l4Var);
        D(l4Var);
        n(l4Var, obj);
        y(l4Var);
    }

    private void c(l4 l4Var) {
        B(l4Var);
        I(l4Var);
        C(l4Var);
        o(l4Var);
        v(l4Var);
        p(l4Var);
        H(l4Var);
        w(l4Var);
        x(l4Var);
        G(l4Var);
    }

    private io.sentry.protocol.w d(List<io.sentry.protocol.w> list) {
        if (list == null) {
            return null;
        }
        for (io.sentry.protocol.w wVar : list) {
            String strM = wVar.m();
            if (strM != null && strM.equals("main")) {
                return wVar;
            }
        }
        return null;
    }

    private io.sentry.protocol.a0 f() {
        io.sentry.protocol.a0 a0Var = new io.sentry.protocol.a0();
        a0Var.n(h());
        return a0Var;
    }

    @SuppressLint({"NewApi"})
    private io.sentry.protocol.e g() {
        io.sentry.protocol.e eVar = new io.sentry.protocol.e();
        if (this.f22249g.isSendDefaultPii()) {
            eVar.g0(t0.d(this.f22248f, this.f22250h));
        }
        eVar.c0(Build.MANUFACTURER);
        eVar.Q(Build.BRAND);
        eVar.V(t0.f(this.f22249g.getLogger()));
        eVar.e0(Build.MODEL);
        eVar.f0(Build.ID);
        eVar.M(t0.c(this.f22250h));
        ActivityManager.MemoryInfo memoryInfoH = t0.h(this.f22248f, this.f22249g.getLogger());
        if (memoryInfoH != null) {
            eVar.d0(i(memoryInfoH));
        }
        eVar.p0(this.f22250h.f());
        DisplayMetrics displayMetricsE = t0.e(this.f22248f, this.f22249g.getLogger());
        if (displayMetricsE != null) {
            eVar.o0(Integer.valueOf(displayMetricsE.widthPixels));
            eVar.n0(Integer.valueOf(displayMetricsE.heightPixels));
            eVar.l0(Float.valueOf(displayMetricsE.density));
            eVar.m0(Integer.valueOf(displayMetricsE.densityDpi));
        }
        if (eVar.J() == null) {
            eVar.Y(h());
        }
        List<Integer> listC = io.sentry.android.core.internal.util.m.a().c();
        if (!listC.isEmpty()) {
            eVar.k0(Double.valueOf(((Integer) Collections.max(listC)).doubleValue()));
            eVar.j0(Integer.valueOf(listC.size()));
        }
        return eVar;
    }

    private String h() {
        try {
            return a1.a(this.f22248f);
        } catch (Throwable th) {
            this.f22249g.getLogger().b(s4.ERROR, "Error getting installationId.", th);
            return null;
        }
    }

    @SuppressLint({"NewApi"})
    private Long i(ActivityManager.MemoryInfo memoryInfo) {
        return this.f22250h.d() >= 16 ? Long.valueOf(memoryInfo.totalMem) : Long.valueOf(Runtime.getRuntime().totalMemory());
    }

    private io.sentry.protocol.k j() {
        io.sentry.protocol.k kVar = new io.sentry.protocol.k();
        kVar.j("Android");
        kVar.m(Build.VERSION.RELEASE);
        kVar.h(Build.DISPLAY);
        try {
            kVar.i(t0.g(this.f22249g.getLogger()));
        } catch (Throwable th) {
            this.f22249g.getLogger().b(s4.ERROR, "Error getting OperatingSystem.", th);
        }
        return kVar;
    }

    private boolean k(Object obj) {
        if (obj instanceof io.sentry.hints.b) {
            return "anr_background".equals(((io.sentry.hints.b) obj).f());
        }
        return false;
    }

    private void l(c4 c4Var) {
        String str;
        io.sentry.protocol.k kVarC = c4Var.C().c();
        c4Var.C().k(j());
        if (kVarC != null) {
            String strG = kVarC.g();
            if (strG == null || strG.isEmpty()) {
                str = "os_1";
            } else {
                str = "os_" + strG.trim().toLowerCase(Locale.ROOT);
            }
            c4Var.C().put(str, kVarC);
        }
    }

    private void m(c4 c4Var) {
        if (this.f22249g.isSendDefaultPii()) {
            if (c4Var.Q() == null) {
                io.sentry.protocol.a0 a0Var = new io.sentry.protocol.a0();
                a0Var.o("{{auto}}");
                c4Var.e0(a0Var);
            } else if (c4Var.Q().l() == null) {
                c4Var.Q().o("{{auto}}");
            }
        }
        io.sentry.protocol.a0 a0VarQ = c4Var.Q();
        if (a0VarQ == null) {
            c4Var.e0(f());
        } else if (a0VarQ.k() == null) {
            a0VarQ.n(h());
        }
    }

    private void n(c4 c4Var, Object obj) {
        io.sentry.protocol.a aVarA = c4Var.C().a();
        if (aVarA == null) {
            aVarA = new io.sentry.protocol.a();
        }
        aVarA.m(t0.b(this.f22248f, this.f22249g.getLogger()));
        aVarA.p(Boolean.valueOf(!k(obj)));
        PackageInfo packageInfoJ = t0.j(this.f22248f, this.f22249g.getLogger(), this.f22250h);
        if (packageInfoJ != null) {
            aVarA.l(packageInfoJ.packageName);
        }
        String strJ = c4Var.J() != null ? c4Var.J() : (String) io.sentry.cache.s.v(this.f22249g, "release.json", String.class);
        if (strJ != null) {
            try {
                String strSubstring = strJ.substring(strJ.indexOf(64) + 1, strJ.indexOf(43));
                String strSubstring2 = strJ.substring(strJ.indexOf(43) + 1);
                aVarA.o(strSubstring);
                aVarA.k(strSubstring2);
            } catch (Throwable unused) {
                this.f22249g.getLogger().c(s4.WARNING, "Failed to parse release from scope cache: %s", strJ);
            }
        }
        c4Var.C().f(aVarA);
    }

    private void o(c4 c4Var) {
        List list = (List) io.sentry.cache.t.r(this.f22249g, "breadcrumbs.json", List.class, new io.sentry.v0.a());
        if (list == null) {
            return;
        }
        if (c4Var.B() == null) {
            c4Var.R(new ArrayList(list));
        } else {
            c4Var.B().addAll(list);
        }
    }

    private void p(c4 c4Var) {
        io.sentry.protocol.c cVar = (io.sentry.protocol.c) io.sentry.cache.t.q(this.f22249g, "contexts.json", io.sentry.protocol.c.class);
        if (cVar == null) {
            return;
        }
        io.sentry.protocol.c cVarC = c4Var.C();
        for (Map.Entry<String, Object> entry : new io.sentry.protocol.c(cVar).entrySet()) {
            Object value = entry.getValue();
            if (!"trace".equals(entry.getKey()) || !(value instanceof f5)) {
                if (!cVarC.containsKey(entry.getKey())) {
                    cVarC.put(entry.getKey(), value);
                }
            }
        }
    }

    private void q(c4 c4Var) {
        io.sentry.protocol.d dVarD = c4Var.D();
        if (dVarD == null) {
            dVarD = new io.sentry.protocol.d();
        }
        if (dVarD.c() == null) {
            dVarD.d(new ArrayList());
        }
        List<DebugImage> listC = dVarD.c();
        if (listC != null) {
            String str = (String) io.sentry.cache.s.v(this.f22249g, "proguard-uuid.json", String.class);
            if (str != null) {
                DebugImage debugImage = new DebugImage();
                debugImage.setType(DebugImage.PROGUARD);
                debugImage.setUuid(str);
                listC.add(debugImage);
            }
            c4Var.S(dVarD);
        }
    }

    private void r(c4 c4Var) {
        if (c4Var.C().b() == null) {
            c4Var.C().i(g());
        }
    }

    private void s(c4 c4Var) {
        String str;
        if (c4Var.E() == null) {
            c4Var.T((String) io.sentry.cache.s.v(this.f22249g, "dist.json", String.class));
        }
        if (c4Var.E() != null || (str = (String) io.sentry.cache.s.v(this.f22249g, "release.json", String.class)) == null) {
            return;
        }
        try {
            c4Var.T(str.substring(str.indexOf(43) + 1));
        } catch (Throwable unused) {
            this.f22249g.getLogger().c(s4.WARNING, "Failed to parse release from scope cache: %s", str);
        }
    }

    private void t(c4 c4Var) {
        if (c4Var.F() == null) {
            String environment = (String) io.sentry.cache.s.v(this.f22249g, "environment.json", String.class);
            if (environment == null) {
                environment = this.f22249g.getEnvironment();
            }
            c4Var.U(environment);
        }
    }

    private void u(l4 l4Var, Object obj) {
        io.sentry.protocol.i iVar = new io.sentry.protocol.i();
        if (((io.sentry.hints.d) obj).a()) {
            iVar.j("AppExitInfo");
        } else {
            iVar.j("HistoricalAppExitInfo");
        }
        String str = "ANR";
        if (k(obj)) {
            str = "Background ANR";
        }
        ApplicationNotResponding applicationNotResponding = new ApplicationNotResponding(str, Thread.currentThread());
        io.sentry.protocol.w wVarD = d(l4Var.s0());
        if (wVarD == null) {
            wVarD = new io.sentry.protocol.w();
            wVarD.y(new io.sentry.protocol.v());
        }
        l4Var.x0(this.f22251i.e(wVarD, iVar, applicationNotResponding));
    }

    private void v(c4 c4Var) {
        Map map = (Map) io.sentry.cache.t.q(this.f22249g, "extras.json", Map.class);
        if (map == null) {
            return;
        }
        if (c4Var.H() == null) {
            c4Var.W(new HashMap(map));
            return;
        }
        for (Map.Entry entry : map.entrySet()) {
            if (!c4Var.H().containsKey(entry.getKey())) {
                c4Var.H().put((String) entry.getKey(), entry.getValue());
            }
        }
    }

    private void w(l4 l4Var) {
        List<String> list = (List) io.sentry.cache.t.q(this.f22249g, "fingerprint.json", List.class);
        if (l4Var.p0() == null) {
            l4Var.y0(list);
        }
    }

    private void x(l4 l4Var) {
        s4 s4Var = (s4) io.sentry.cache.t.q(this.f22249g, "level.json", s4.class);
        if (l4Var.q0() == null) {
            l4Var.z0(s4Var);
        }
    }

    private void y(c4 c4Var) {
        Map map = (Map) io.sentry.cache.s.v(this.f22249g, "tags.json", Map.class);
        if (map == null) {
            return;
        }
        if (c4Var.N() == null) {
            c4Var.d0(new HashMap(map));
            return;
        }
        for (Map.Entry entry : map.entrySet()) {
            if (!c4Var.N().containsKey(entry.getKey())) {
                c4Var.c0((String) entry.getKey(), (String) entry.getValue());
            }
        }
    }

    private void z(c4 c4Var) {
        if (c4Var.I() == null) {
            c4Var.X("java");
        }
    }

    @Override // io.sentry.k1
    public l4 b(l4 l4Var, n1 n1Var) {
        Object objC = io.sentry.util.m.c(n1Var);
        if (!(objC instanceof io.sentry.hints.d)) {
            this.f22249g.getLogger().c(s4.WARNING, "The event is not Backfillable, but has been passed to BackfillingEventProcessor, skipping.", new Object[0]);
            return l4Var;
        }
        u(l4Var, objC);
        z(l4Var);
        l(l4Var);
        r(l4Var);
        if (!((io.sentry.hints.d) objC).a()) {
            this.f22249g.getLogger().c(s4.DEBUG, "The event is Backfillable, but should not be enriched, skipping.", new Object[0]);
            return l4Var;
        }
        c(l4Var);
        a(l4Var, objC);
        F(l4Var);
        return l4Var;
    }

    @Override // io.sentry.k1
    public /* synthetic */ io.sentry.protocol.x e(io.sentry.protocol.x xVar, n1 n1Var) {
        return j1.a(this, xVar, n1Var);
    }
}
