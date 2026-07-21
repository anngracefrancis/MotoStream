package com.google.firebase.crashlytics.internal.n;

import android.app.ApplicationExitInfo;
import android.content.Context;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.h;
import com.google.firebase.crashlytics.internal.o.f;
import com.google.firebase.crashlytics.internal.o.l;
import com.google.firebase.crashlytics.internal.p.f0;
import com.google.firebase.crashlytics.internal.r.e;
import com.google.firebase.crashlytics.internal.s.d;
import com.google.firebase.crashlytics.internal.t.i;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: SessionReportingCoordinator.java */
/* JADX INFO: loaded from: classes2.dex */
public class o0 {
    private final a0 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f19067b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d f19068c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final f f19069d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final l f19070e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final i0 f19071f;

    o0(a0 a0Var, e eVar, d dVar, f fVar, l lVar, i0 i0Var) {
        this.a = a0Var;
        this.f19067b = eVar;
        this.f19068c = dVar;
        this.f19069d = fVar;
        this.f19070e = lVar;
        this.f19071f = i0Var;
    }

    private f0.e.d a(f0.e.d dVar, f fVar, l lVar) {
        f0.e.d.b bVarH = dVar.h();
        String strC = fVar.c();
        if (strC != null) {
            bVarH.d(f0.e.d.AbstractC0225d.a().b(strC).a());
        } else {
            h.f().i("No log data to include with this event.");
        }
        List<f0.c> listK = k(lVar.d());
        List<f0.c> listK2 = k(lVar.e());
        if (!listK.isEmpty() || !listK2.isEmpty()) {
            bVarH.b(dVar.b().i().e(listK).g(listK2).a());
        }
        return bVarH.a();
    }

    private f0.e.d b(f0.e.d dVar) {
        return c(a(dVar, this.f19069d, this.f19070e), this.f19070e);
    }

    private f0.e.d c(f0.e.d dVar, l lVar) {
        List<f0.e.d.AbstractC0226e> listF = lVar.f();
        if (listF.isEmpty()) {
            return dVar;
        }
        f0.e.d.b bVarH = dVar.h();
        bVarH.e(f0.e.d.f.a().b(listF).a());
        return bVarH.a();
    }

    private static f0.a d(ApplicationExitInfo applicationExitInfo) {
        String strE = null;
        try {
            InputStream traceInputStream = applicationExitInfo.getTraceInputStream();
            if (traceInputStream != null) {
                strE = e(traceInputStream);
            }
        } catch (IOException e2) {
            h.f().k("Could not get input trace in application exit info: " + applicationExitInfo.toString() + " Error: " + e2);
        }
        return f0.a.a().c(applicationExitInfo.getImportance()).e(applicationExitInfo.getProcessName()).g(applicationExitInfo.getReason()).i(applicationExitInfo.getTimestamp()).d(applicationExitInfo.getPid()).f(applicationExitInfo.getPss()).h(applicationExitInfo.getRss()).j(strE).a();
    }

    public static String e(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int i2 = inputStream.read(bArr);
            if (i2 == -1) {
                return byteArrayOutputStream.toString(StandardCharsets.UTF_8.name());
            }
            byteArrayOutputStream.write(bArr, 0, i2);
        }
    }

    public static o0 f(Context context, i0 i0Var, com.google.firebase.crashlytics.internal.r.f fVar, l lVar, f fVar2, l lVar2, com.google.firebase.crashlytics.internal.u.d dVar, i iVar, n0 n0Var, v vVar) {
        return new o0(new a0(context, i0Var, lVar, dVar, iVar), new e(fVar, iVar, vVar), d.a(context, iVar, n0Var), fVar2, lVar2, i0Var);
    }

    private b0 g(b0 b0Var) {
        if (b0Var.b().g() != null) {
            return b0Var;
        }
        return b0.a(b0Var.b().r(this.f19071f.d()), b0Var.d(), b0Var.c());
    }

    private ApplicationExitInfo j(String str, List<ApplicationExitInfo> list) {
        long jM = this.f19067b.m(str);
        for (ApplicationExitInfo applicationExitInfo : list) {
            if (applicationExitInfo.getTimestamp() < jM) {
                return null;
            }
            if (applicationExitInfo.getReason() == 6) {
                return applicationExitInfo;
            }
        }
        return null;
    }

    private static List<f0.c> k(Map<String, String> map) {
        ArrayList arrayList = new ArrayList();
        arrayList.ensureCapacity(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(f0.c.a().b(entry.getKey()).c(entry.getValue()).a());
        }
        Collections.sort(arrayList, new Comparator() { // from class: com.google.firebase.crashlytics.h.n.f
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ((f0.c) obj).b().compareTo(((f0.c) obj2).b());
            }
        });
        return Collections.unmodifiableList(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q(Task<b0> task) {
        if (!task.n()) {
            h.f().l("Crashlytics report could not be enqueued to DataTransport", task.i());
            return false;
        }
        b0 b0VarJ = task.j();
        h.f().b("Crashlytics report successfully enqueued to DataTransport: " + b0VarJ.d());
        File fileC = b0VarJ.c();
        if (fileC.delete()) {
            h.f().b("Deleted report file: " + fileC.getPath());
            return true;
        }
        h.f().k("Crashlytics could not delete report file: " + fileC.getPath());
        return true;
    }

    private void r(Throwable th, Thread thread, String str, String str2, long j2, boolean z) {
        this.f19067b.w(b(this.a.d(th, thread, str2, j2, 4, 8, z)), str, str2.equals("crash"));
    }

    public void h(String str, List<l0> list, f0.a aVar) {
        h.f().b("SessionReportingCoordinator#finalizeSessionWithNativeEvent");
        ArrayList arrayList = new ArrayList();
        Iterator<l0> it = list.iterator();
        while (it.hasNext()) {
            f0.d.b bVarC = it.next().c();
            if (bVarC != null) {
                arrayList.add(bVarC);
            }
        }
        this.f19067b.h(str, f0.d.a().b(Collections.unmodifiableList(arrayList)).a(), aVar);
    }

    public void i(long j2, String str) {
        this.f19067b.g(str, j2);
    }

    public boolean l() {
        return this.f19067b.n();
    }

    public SortedSet<String> o() {
        return this.f19067b.l();
    }

    public void p(String str, long j2) {
        this.f19067b.x(this.a.e(str, j2));
    }

    public void s(Throwable th, Thread thread, String str, long j2) {
        h.f().i("Persisting fatal event for session " + str);
        r(th, thread, str, "crash", j2, true);
    }

    public void t(String str, List<ApplicationExitInfo> list, f fVar, l lVar) {
        ApplicationExitInfo applicationExitInfoJ = j(str, list);
        if (applicationExitInfoJ == null) {
            h.f().i("No relevant ApplicationExitInfo occurred during session: " + str);
            return;
        }
        f0.e.d dVarC = this.a.c(d(applicationExitInfoJ));
        h.f().b("Persisting anr for session " + str);
        this.f19067b.w(c(a(dVarC, fVar, lVar), lVar), str, true);
    }

    public void u() {
        this.f19067b.e();
    }

    public Task<Void> v(Executor executor) {
        return w(executor, null);
    }

    public Task<Void> w(Executor executor, String str) {
        List<b0> listU = this.f19067b.u();
        ArrayList arrayList = new ArrayList();
        for (b0 b0Var : listU) {
            if (str == null || str.equals(b0Var.d())) {
                arrayList.add(this.f19068c.b(g(b0Var), str != null).g(executor, new Continuation() { // from class: com.google.firebase.crashlytics.h.n.e
                    @Override // com.google.android.gms.tasks.Continuation
                    public final Object a(Task task) {
                        return Boolean.valueOf(this.a.q(task));
                    }
                }));
            }
        }
        return Tasks.f(arrayList);
    }
}
