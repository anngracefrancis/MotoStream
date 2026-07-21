package com.google.firebase.crashlytics.internal.n;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.google.firebase.crashlytics.internal.ProcessDetailsProvider;
import com.google.firebase.crashlytics.internal.p.f0;
import com.google.firebase.crashlytics.internal.t.i;
import com.google.firebase.crashlytics.internal.u.d;
import com.google.firebase.crashlytics.internal.u.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: CrashlyticsReportDataCapture.java */
/* JADX INFO: loaded from: classes2.dex */
public class a0 {
    private static final Map<String, Integer> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final String f19009b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f19010c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final i0 f19011d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final l f19012e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final d f19013f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final i f19014g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ProcessDetailsProvider f19015h = ProcessDetailsProvider.a;

    static {
        HashMap map = new HashMap();
        a = map;
        map.put("armeabi", 5);
        map.put("armeabi-v7a", 6);
        map.put("arm64-v8a", 9);
        map.put("x86", 0);
        map.put("x86_64", 1);
        f19009b = String.format(Locale.US, "Crashlytics Android SDK/%s", "18.6.1");
    }

    public a0(Context context, i0 i0Var, l lVar, d dVar, i iVar) {
        this.f19010c = context;
        this.f19011d = i0Var;
        this.f19012e = lVar;
        this.f19013f = dVar;
        this.f19014g = iVar;
    }

    private f0.e.d.a.c A(f0.a aVar) {
        return this.f19015h.a(aVar.e(), aVar.d(), aVar.c());
    }

    private f0.a a(f0.a aVar) {
        List<f0.a.AbstractC0210a> listUnmodifiableList;
        if (!this.f19014g.b().f19545b.f19553c || this.f19012e.f19057c.size() <= 0) {
            listUnmodifiableList = null;
        } else {
            ArrayList arrayList = new ArrayList();
            for (q qVar : this.f19012e.f19057c) {
                arrayList.add(f0.a.AbstractC0210a.a().d(qVar.c()).b(qVar.a()).c(qVar.b()).a());
            }
            listUnmodifiableList = Collections.unmodifiableList(arrayList);
        }
        return f0.a.a().c(aVar.c()).e(aVar.e()).g(aVar.g()).i(aVar.i()).d(aVar.d()).f(aVar.f()).h(aVar.h()).j(aVar.j()).b(listUnmodifiableList).a();
    }

    private f0.b b() {
        return f0.b().k("18.6.1").g(this.f19012e.a).h(this.f19011d.a().c()).f(this.f19011d.a().d()).d(this.f19012e.f19060f).e(this.f19012e.f19061g).j(4);
    }

    private static long f(long j2) {
        if (j2 > 0) {
            return j2;
        }
        return 0L;
    }

    private static int g() {
        Integer num;
        String str = Build.CPU_ABI;
        if (TextUtils.isEmpty(str) || (num = a.get(str.toLowerCase(Locale.US))) == null) {
            return 7;
        }
        return num.intValue();
    }

    private f0.e.d.a.b.AbstractC0214a h() {
        return f0.e.d.a.b.AbstractC0214a.a().b(0L).d(0L).c(this.f19012e.f19059e).e(this.f19012e.f19056b).a();
    }

    private List<f0.e.d.a.b.AbstractC0214a> i() {
        return Collections.singletonList(h());
    }

    private f0.e.d.a j(int i2, f0.a aVar) {
        return f0.e.d.a.a().c(Boolean.valueOf(aVar.c() != 100)).d(A(aVar)).h(i2).f(o(aVar)).a();
    }

    private f0.e.d.a k(int i2, e eVar, Thread thread, int i3, int i4, boolean z) {
        Boolean boolValueOf;
        f0.e.d.a.c cVarE = this.f19015h.e(this.f19010c);
        if (cVarE.b() > 0) {
            boolValueOf = Boolean.valueOf(cVarE.b() != 100);
        } else {
            boolValueOf = null;
        }
        return f0.e.d.a.a().c(boolValueOf).d(cVarE).b(this.f19015h.d(this.f19010c)).h(i2).f(p(eVar, thread, i3, i4, z)).a();
    }

    private f0.e.d.c l(int i2) {
        p pVarA = p.a(this.f19010c);
        Float fB = pVarA.b();
        Double dValueOf = fB != null ? Double.valueOf(fB.doubleValue()) : null;
        int iC = pVarA.c();
        boolean zN = t.n(this.f19010c);
        return f0.e.d.c.a().b(dValueOf).c(iC).f(zN).e(i2).g(f(t.b(this.f19010c) - t.a(this.f19010c))).d(t.c(Environment.getDataDirectory().getPath())).a();
    }

    private f0.e.d.a.b.c m(e eVar, int i2, int i3) {
        return n(eVar, i2, i3, 0);
    }

    private f0.e.d.a.b.c n(e eVar, int i2, int i3, int i4) {
        String str = eVar.f19577b;
        String str2 = eVar.a;
        StackTraceElement[] stackTraceElementArr = eVar.f19578c;
        int i5 = 0;
        if (stackTraceElementArr == null) {
            stackTraceElementArr = new StackTraceElement[0];
        }
        e eVar2 = eVar.f19579d;
        if (i4 >= i3) {
            e eVar3 = eVar2;
            while (eVar3 != null) {
                eVar3 = eVar3.f19579d;
                i5++;
            }
        }
        f0.e.d.a.b.c.AbstractC0217a abstractC0217aD = f0.e.d.a.b.c.a().f(str).e(str2).c(r(stackTraceElementArr, i2)).d(i5);
        if (eVar2 != null && i5 == 0) {
            abstractC0217aD.b(n(eVar2, i2, i3, i4 + 1));
        }
        return abstractC0217aD.a();
    }

    private f0.e.d.a.b o(f0.a aVar) {
        return f0.e.d.a.b.a().b(aVar).e(w()).c(i()).a();
    }

    private f0.e.d.a.b p(e eVar, Thread thread, int i2, int i3, boolean z) {
        return f0.e.d.a.b.a().f(z(eVar, thread, i2, z)).d(m(eVar, i2, i3)).e(w()).c(i()).a();
    }

    private f0.e.d.a.b.AbstractC0220e.AbstractC0222b q(StackTraceElement stackTraceElement, f0.e.d.a.b.AbstractC0220e.AbstractC0222b.AbstractC0223a abstractC0223a) {
        long lineNumber = 0;
        long jMax = stackTraceElement.isNativeMethod() ? Math.max(stackTraceElement.getLineNumber(), 0L) : 0L;
        String str = stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName();
        String fileName = stackTraceElement.getFileName();
        if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
            lineNumber = stackTraceElement.getLineNumber();
        }
        return abstractC0223a.e(jMax).f(str).b(fileName).d(lineNumber).a();
    }

    private List<f0.e.d.a.b.AbstractC0220e.AbstractC0222b> r(StackTraceElement[] stackTraceElementArr, int i2) {
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            arrayList.add(q(stackTraceElement, f0.e.d.a.b.AbstractC0220e.AbstractC0222b.a().c(i2)));
        }
        return Collections.unmodifiableList(arrayList);
    }

    private f0.e.a s() {
        return f0.e.a.a().e(this.f19011d.f()).g(this.f19012e.f19060f).d(this.f19012e.f19061g).f(this.f19011d.a().c()).b(this.f19012e.f19062h.d()).c(this.f19012e.f19062h.e()).a();
    }

    private f0.e t(String str, long j2) {
        return f0.e.a().m(j2).j(str).h(f19009b).b(s()).l(v()).e(u()).i(3).a();
    }

    private f0.e.c u() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        int iG = g();
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        long jB = t.b(this.f19010c);
        long blockCount = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        boolean zW = t.w();
        int iL = t.l();
        String str = Build.MANUFACTURER;
        return f0.e.c.a().b(iG).f(Build.MODEL).c(iAvailableProcessors).h(jB).d(blockCount).i(zW).j(iL).e(str).g(Build.PRODUCT).a();
    }

    private f0.e.AbstractC0227e v() {
        return f0.e.AbstractC0227e.a().d(3).e(Build.VERSION.RELEASE).b(Build.VERSION.CODENAME).c(t.x()).a();
    }

    private f0.e.d.a.b.AbstractC0218d w() {
        return f0.e.d.a.b.AbstractC0218d.a().d("0").c("0").b(0L).a();
    }

    private f0.e.d.a.b.AbstractC0220e x(Thread thread, StackTraceElement[] stackTraceElementArr) {
        return y(thread, stackTraceElementArr, 0);
    }

    private f0.e.d.a.b.AbstractC0220e y(Thread thread, StackTraceElement[] stackTraceElementArr, int i2) {
        return f0.e.d.a.b.AbstractC0220e.a().d(thread.getName()).c(i2).b(r(stackTraceElementArr, i2)).a();
    }

    private List<f0.e.d.a.b.AbstractC0220e> z(e eVar, Thread thread, int i2, boolean z) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(y(thread, eVar.f19578c, i2));
        if (z) {
            for (Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
                Thread key = entry.getKey();
                if (!key.equals(thread)) {
                    arrayList.add(x(key, this.f19013f.a(entry.getValue())));
                }
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public f0.e.d c(f0.a aVar) {
        int i2 = this.f19010c.getResources().getConfiguration().orientation;
        return f0.e.d.a().g("anr").f(aVar.i()).b(j(i2, a(aVar))).c(l(i2)).a();
    }

    public f0.e.d d(Throwable th, Thread thread, String str, long j2, int i2, int i3, boolean z) {
        int i4 = this.f19010c.getResources().getConfiguration().orientation;
        return f0.e.d.a().g(str).f(j2).b(k(i4, e.a(th, this.f19013f), thread, i2, i3, z)).c(l(i4)).a();
    }

    public f0 e(String str, long j2) {
        return b().l(t(str, j2)).a();
    }
}
