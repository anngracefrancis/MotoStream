package androidx.work.impl;

import android.content.Context;
import android.os.Build;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import androidx.work.impl.background.systemjob.SystemJobService;
import androidx.work.impl.n.p;
import androidx.work.impl.n.q;
import androidx.work.n;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: Schedulers.java */
/* JADX INFO: loaded from: classes.dex */
public class f {
    private static final String a = n.f("Schedulers");

    static e a(Context context, j jVar) {
        if (Build.VERSION.SDK_INT >= 23) {
            androidx.work.impl.background.systemjob.b bVar = new androidx.work.impl.background.systemjob.b(context, jVar);
            androidx.work.impl.utils.d.a(context, SystemJobService.class, true);
            n.c().a(a, "Created SystemJobScheduler and enabled SystemJobService", new Throwable[0]);
            return bVar;
        }
        e eVarC = c(context);
        if (eVarC != null) {
            return eVarC;
        }
        androidx.work.impl.background.systemalarm.f fVar = new androidx.work.impl.background.systemalarm.f(context);
        androidx.work.impl.utils.d.a(context, SystemAlarmService.class, true);
        n.c().a(a, "Created SystemAlarmScheduler", new Throwable[0]);
        return fVar;
    }

    public static void b(androidx.work.b bVar, WorkDatabase workDatabase, List<e> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        q qVarJ = workDatabase.j();
        workDatabase.beginTransaction();
        try {
            List<p> listE = qVarJ.e(bVar.h());
            List<p> listS = qVarJ.s(200);
            if (listE != null && listE.size() > 0) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                Iterator<p> it = listE.iterator();
                while (it.hasNext()) {
                    qVarJ.b(it.next().f2525c, jCurrentTimeMillis);
                }
            }
            workDatabase.setTransactionSuccessful();
            workDatabase.endTransaction();
            if (listE != null && listE.size() > 0) {
                p[] pVarArr = (p[]) listE.toArray(new p[listE.size()]);
                for (e eVar : list) {
                    if (eVar.c()) {
                        eVar.a(pVarArr);
                    }
                }
            }
            if (listS == null || listS.size() <= 0) {
                return;
            }
            p[] pVarArr2 = (p[]) listS.toArray(new p[listS.size()]);
            for (e eVar2 : list) {
                if (!eVar2.c()) {
                    eVar2.a(pVarArr2);
                }
            }
        } catch (Throwable th) {
            workDatabase.endTransaction();
            throw th;
        }
    }

    private static e c(Context context) {
        try {
            e eVar = (e) Class.forName("androidx.work.impl.background.gcm.GcmScheduler").getConstructor(Context.class).newInstance(context);
            n.c().a(a, String.format("Created %s", "androidx.work.impl.background.gcm.GcmScheduler"), new Throwable[0]);
            return eVar;
        } catch (Throwable th) {
            n.c().a(a, "Unable to create GCM Scheduler", th);
            return null;
        }
    }
}
