package androidx.work.impl.utils;

import android.os.Build;
import android.text.TextUtils;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.n.p;
import androidx.work.impl.n.q;
import androidx.work.impl.n.s;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import androidx.work.x;
import androidx.work.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: EnqueueRunnable.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f2567f = androidx.work.n.f("EnqueueRunnable");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final androidx.work.impl.g f2568g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final androidx.work.impl.c f2569h = new androidx.work.impl.c();

    public b(androidx.work.impl.g gVar) {
        this.f2568g = gVar;
    }

    private static boolean b(androidx.work.impl.g gVar) {
        boolean zC = c(gVar.g(), gVar.f(), (String[]) androidx.work.impl.g.l(gVar).toArray(new String[0]), gVar.d(), gVar.b());
        gVar.k();
        return zC;
    }

    /* JADX WARN: Code duplicated, block: B:111:0x0199  */
    /* JADX WARN: Code duplicated, block: B:113:0x019d  */
    /* JADX WARN: Code duplicated, block: B:118:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:121:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:123:0x01bc A[LOOP:4: B:122:0x01ba->B:123:0x01bc, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:127:0x01e1 A[LOOP:5: B:125:0x01db->B:127:0x01e1, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:129:0x01fa  */
    /* JADX WARN: Code duplicated, block: B:144:0x020a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:89:0x014e A[PHI: r1 r9 r12 r13 r14
      0x014e: PHI (r1v1 java.lang.String[]) = (r1v0 java.lang.String[]), (r1v0 java.lang.String[]), (r1v4 java.lang.String[]) binds: [B:32:0x006c, B:34:0x007a, B:88:0x014d] A[DONT_GENERATE, DONT_INLINE]
      0x014e: PHI (r9v2 boolean) = (r9v1 boolean), (r9v1 boolean), (r9v7 boolean) binds: [B:32:0x006c, B:34:0x007a, B:88:0x014d] A[DONT_GENERATE, DONT_INLINE]
      0x014e: PHI (r12v2 boolean) = (r12v1 boolean), (r12v1 boolean), (r12v4 boolean) binds: [B:32:0x006c, B:34:0x007a, B:88:0x014d] A[DONT_GENERATE, DONT_INLINE]
      0x014e: PHI (r13v2 boolean) = (r13v1 boolean), (r13v1 boolean), (r13v5 boolean) binds: [B:32:0x006c, B:34:0x007a, B:88:0x014d] A[DONT_GENERATE, DONT_INLINE]
      0x014e: PHI (r14v2 boolean) = (r14v1 boolean), (r14v1 boolean), (r14v5 boolean) binds: [B:32:0x006c, B:34:0x007a, B:88:0x014d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Instruction removed from duplicated block: B:121:0x01b8, please report this as an issue */
    private static boolean c(androidx.work.impl.j jVar, List<? extends z> list, String[] strArr, String str, androidx.work.g gVar) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        int i2;
        Iterator<String> it;
        int i3;
        boolean z5;
        androidx.work.impl.j jVar2 = jVar;
        String[] strArr2 = strArr;
        long jCurrentTimeMillis = System.currentTimeMillis();
        WorkDatabase workDatabaseT = jVar.t();
        boolean z6 = strArr2 != null && strArr2.length > 0;
        if (z6) {
            z = true;
            z2 = false;
            z3 = false;
            for (String str2 : strArr2) {
                p pVarM = workDatabaseT.j().m(str2);
                if (pVarM == null) {
                    androidx.work.n.c().b(f2567f, String.format("Prerequisite %s doesn't exist; not enqueuing", str2), new Throwable[0]);
                    return false;
                }
                x.a aVar = pVarM.f2526d;
                z &= aVar == x.a.SUCCEEDED;
                if (aVar == x.a.FAILED) {
                    z3 = true;
                } else if (aVar == x.a.CANCELLED) {
                    z2 = true;
                }
            }
        } else {
            z = true;
            z2 = false;
            z3 = false;
        }
        boolean z7 = !TextUtils.isEmpty(str);
        if (z7 && !z6) {
            List<p.b> listC = workDatabaseT.j().c(str);
            if (listC.isEmpty()) {
                z4 = false;
            } else if (gVar == androidx.work.g.APPEND || gVar == androidx.work.g.APPEND_OR_REPLACE) {
                androidx.work.impl.n.b bVarB = workDatabaseT.b();
                List arrayList = new ArrayList();
                for (p.b bVar : listC) {
                    if (!bVarB.d(bVar.a)) {
                        x.a aVar2 = bVar.f2534b;
                        boolean z8 = (aVar2 == x.a.SUCCEEDED) & z;
                        if (aVar2 == x.a.FAILED) {
                            z3 = true;
                        } else if (aVar2 == x.a.CANCELLED) {
                            z2 = true;
                        }
                        arrayList.add(bVar.a);
                        z = z8;
                    }
                    bVarB = bVarB;
                }
                if (gVar == androidx.work.g.APPEND_OR_REPLACE && (z2 || z3)) {
                    q qVarJ = workDatabaseT.j();
                    Iterator<p.b> it2 = qVarJ.c(str).iterator();
                    while (it2.hasNext()) {
                        qVarJ.delete(it2.next().a);
                    }
                    arrayList = Collections.emptyList();
                    z5 = false;
                    z2 = false;
                } else {
                    z5 = z3;
                }
                strArr2 = (String[]) arrayList.toArray(strArr2);
                z6 = strArr2.length > 0;
                z3 = z5;
                z4 = false;
            } else {
                if (gVar == androidx.work.g.KEEP) {
                    Iterator<p.b> it3 = listC.iterator();
                    while (it3.hasNext()) {
                        x.a aVar3 = it3.next().f2534b;
                        if (aVar3 == x.a.ENQUEUED || aVar3 == x.a.RUNNING) {
                            return false;
                        }
                    }
                }
                a.c(str, jVar2, false).run();
                q qVarJ2 = workDatabaseT.j();
                Iterator<p.b> it4 = listC.iterator();
                while (it4.hasNext()) {
                    qVarJ2.delete(it4.next().a);
                }
                z4 = true;
            }
        } else {
            z4 = false;
        }
        for (z zVar : list) {
            p pVarC = zVar.c();
            if (!z6 || z) {
                if (pVarC.d()) {
                    pVarC.p = 0L;
                } else {
                    pVarC.p = jCurrentTimeMillis;
                }
                i2 = Build.VERSION.SDK_INT;
                if (i2 < 23 && i2 <= 25) {
                    g(pVarC);
                } else if (i2 <= 22 && h(jVar2, "androidx.work.impl.background.gcm.GcmScheduler")) {
                    g(pVarC);
                }
                if (pVarC.f2526d == x.a.ENQUEUED) {
                    z4 = true;
                }
                workDatabaseT.j().f(pVarC);
                if (z6) {
                    for (String str3 : strArr2) {
                        workDatabaseT.b().a(new androidx.work.impl.n.a(zVar.a(), str3));
                    }
                }
                it = zVar.b().iterator();
                while (it.hasNext()) {
                    workDatabaseT.k().a(new s(it.next(), zVar.a()));
                }
                if (z7) {
                    workDatabaseT.h().a(new androidx.work.impl.n.j(str, zVar.a()));
                }
                jVar2 = jVar;
                jCurrentTimeMillis = jCurrentTimeMillis;
            } else if (z3) {
                pVarC.f2526d = x.a.FAILED;
            } else if (z2) {
                pVarC.f2526d = x.a.CANCELLED;
            } else {
                pVarC.f2526d = x.a.BLOCKED;
            }
            i2 = Build.VERSION.SDK_INT;
            if (i2 < 23) {
                if (i2 <= 22) {
                    g(pVarC);
                }
            } else if (i2 <= 22) {
                g(pVarC);
            }
            if (pVarC.f2526d == x.a.ENQUEUED) {
                z4 = true;
            }
            workDatabaseT.j().f(pVarC);
            if (z6) {
                while (i3 < r4) {
                    workDatabaseT.b().a(new androidx.work.impl.n.a(zVar.a(), str3));
                }
            }
            it = zVar.b().iterator();
            while (it.hasNext()) {
                workDatabaseT.k().a(new s(it.next(), zVar.a()));
            }
            if (z7) {
                workDatabaseT.h().a(new androidx.work.impl.n.j(str, zVar.a()));
            }
            jVar2 = jVar;
            jCurrentTimeMillis = jCurrentTimeMillis;
        }
        return z4;
    }

    private static boolean e(androidx.work.impl.g gVar) {
        List<androidx.work.impl.g> listE = gVar.e();
        boolean z = false;
        if (listE != null) {
            boolean zE = false;
            for (androidx.work.impl.g gVar2 : listE) {
                if (gVar2.j()) {
                    androidx.work.n.c().h(f2567f, String.format("Already enqueued work ids (%s).", TextUtils.join(", ", gVar2.c())), new Throwable[0]);
                } else {
                    zE |= e(gVar2);
                }
            }
            z = zE;
        }
        return b(gVar) | z;
    }

    private static void g(p pVar) {
        androidx.work.c cVar = pVar.l;
        String str = pVar.f2527e;
        if (str.equals(ConstraintTrackingWorker.class.getName())) {
            return;
        }
        if (cVar.f() || cVar.i()) {
            androidx.work.e.a aVar = new androidx.work.e.a();
            aVar.c(pVar.f2529g).f("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME", str);
            pVar.f2527e = ConstraintTrackingWorker.class.getName();
            pVar.f2529g = aVar.a();
        }
    }

    private static boolean h(androidx.work.impl.j jVar, String str) {
        try {
            Class<?> cls = Class.forName(str);
            Iterator<androidx.work.impl.e> it = jVar.s().iterator();
            while (it.hasNext()) {
                if (cls.isAssignableFrom(it.next().getClass())) {
                    return true;
                }
            }
        } catch (ClassNotFoundException unused) {
        }
        return false;
    }

    public boolean a() {
        WorkDatabase workDatabaseT = this.f2568g.g().t();
        workDatabaseT.beginTransaction();
        try {
            boolean zE = e(this.f2568g);
            workDatabaseT.setTransactionSuccessful();
            return zE;
        } finally {
            workDatabaseT.endTransaction();
        }
    }

    public androidx.work.q d() {
        return this.f2569h;
    }

    public void f() {
        androidx.work.impl.j jVarG = this.f2568g.g();
        androidx.work.impl.f.b(jVarG.n(), jVarG.t(), jVarG.s());
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.f2568g.h()) {
                throw new IllegalStateException(String.format("WorkContinuation has cycles (%s)", this.f2568g));
            }
            if (a()) {
                d.a(this.f2568g.g().m(), RescheduleReceiver.class, true);
                f();
            }
            this.f2569h.a(androidx.work.q.a);
        } catch (Throwable th) {
            this.f2569h.a(new androidx.work.q.b.a(th));
        }
    }
}
