package androidx.work.impl.workers;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.j;
import androidx.work.impl.n.g;
import androidx.work.impl.n.h;
import androidx.work.impl.n.k;
import androidx.work.impl.n.p;
import androidx.work.impl.n.q;
import androidx.work.impl.n.t;
import androidx.work.n;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class DiagnosticsWorker extends Worker {
    private static final String a = n.f("DiagnosticsWrkr");

    public DiagnosticsWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    private static String a(p pVar, String str, Integer num, String str2) {
        return String.format("\n%s\t %s\t %s\t %s\t %s\t %s\t", pVar.f2525c, pVar.f2527e, num, pVar.f2526d.name(), str, str2);
    }

    private static String c(k kVar, t tVar, h hVar, List<p> list) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("\n Id \t Class Name\t %s\t State\t Unique Name\t Tags\t", Build.VERSION.SDK_INT >= 23 ? "Job Id" : "Alarm Id"));
        for (p pVar : list) {
            Integer numValueOf = null;
            g gVarC = hVar.c(pVar.f2525c);
            if (gVarC != null) {
                numValueOf = Integer.valueOf(gVarC.f2515b);
            }
            sb.append(a(pVar, TextUtils.join(",", kVar.b(pVar.f2525c)), numValueOf, TextUtils.join(",", tVar.b(pVar.f2525c))));
        }
        return sb.toString();
    }

    @Override // androidx.work.Worker
    public ListenableWorker.a doWork() {
        WorkDatabase workDatabaseT = j.p(getApplicationContext()).t();
        q qVarJ = workDatabaseT.j();
        k kVarH = workDatabaseT.h();
        t tVarK = workDatabaseT.k();
        h hVarG = workDatabaseT.g();
        List<p> listD = qVarJ.d(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(1L));
        List<p> listI = qVarJ.i();
        List<p> listS = qVarJ.s(200);
        if (listD != null && !listD.isEmpty()) {
            n nVarC = n.c();
            String str = a;
            nVarC.d(str, "Recently completed work:\n\n", new Throwable[0]);
            n.c().d(str, c(kVarH, tVarK, hVarG, listD), new Throwable[0]);
        }
        if (listI != null && !listI.isEmpty()) {
            n nVarC2 = n.c();
            String str2 = a;
            nVarC2.d(str2, "Running work:\n\n", new Throwable[0]);
            n.c().d(str2, c(kVarH, tVarK, hVarG, listI), new Throwable[0]);
        }
        if (listS != null && !listS.isEmpty()) {
            n nVarC3 = n.c();
            String str3 = a;
            nVarC3.d(str3, "Enqueued work:\n\n", new Throwable[0]);
            n.c().d(str3, c(kVarH, tVarK, hVarG, listS), new Throwable[0]);
        }
        return ListenableWorker.a.c();
    }
}
