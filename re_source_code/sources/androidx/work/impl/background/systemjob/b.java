package androidx.work.impl.background.systemjob;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.PersistableBundle;
import android.text.TextUtils;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.e;
import androidx.work.impl.j;
import androidx.work.impl.n.g;
import androidx.work.impl.n.p;
import androidx.work.impl.n.q;
import androidx.work.impl.utils.c;
import androidx.work.n;
import androidx.work.r;
import androidx.work.x;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: SystemJobScheduler.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f2384f = n.f("SystemJobScheduler");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Context f2385g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final JobScheduler f2386h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final j f2387i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final a f2388j;

    public b(Context context, j jVar) {
        this(context, jVar, (JobScheduler) context.getSystemService("jobscheduler"), new a(context));
    }

    public static void b(Context context) {
        List<JobInfo> listF;
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler == null || (listF = f(context, jobScheduler)) == null || listF.isEmpty()) {
            return;
        }
        Iterator<JobInfo> it = listF.iterator();
        while (it.hasNext()) {
            d(jobScheduler, it.next().getId());
        }
    }

    private static void d(JobScheduler jobScheduler, int i2) {
        try {
            jobScheduler.cancel(i2);
        } catch (Throwable th) {
            n.c().b(f2384f, String.format(Locale.getDefault(), "Exception while trying to cancel job (%d)", Integer.valueOf(i2)), th);
        }
    }

    private static List<Integer> e(Context context, JobScheduler jobScheduler, String str) {
        List<JobInfo> listF = f(context, jobScheduler);
        if (listF == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(2);
        for (JobInfo jobInfo : listF) {
            if (str.equals(g(jobInfo))) {
                arrayList.add(Integer.valueOf(jobInfo.getId()));
            }
        }
        return arrayList;
    }

    private static List<JobInfo> f(Context context, JobScheduler jobScheduler) {
        List<JobInfo> allPendingJobs;
        try {
            allPendingJobs = jobScheduler.getAllPendingJobs();
        } catch (Throwable th) {
            n.c().b(f2384f, "getAllPendingJobs() is not reliable on this device.", th);
            allPendingJobs = null;
        }
        if (allPendingJobs == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(allPendingJobs.size());
        ComponentName componentName = new ComponentName(context, (Class<?>) SystemJobService.class);
        for (JobInfo jobInfo : allPendingJobs) {
            if (componentName.equals(jobInfo.getService())) {
                arrayList.add(jobInfo);
            }
        }
        return arrayList;
    }

    private static String g(JobInfo jobInfo) {
        PersistableBundle extras = jobInfo.getExtras();
        if (extras == null) {
            return null;
        }
        try {
            if (extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                return extras.getString("EXTRA_WORK_SPEC_ID");
            }
            return null;
        } catch (NullPointerException unused) {
            return null;
        }
    }

    public static boolean h(Context context, j jVar) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        List<JobInfo> listF = f(context, jobScheduler);
        List<String> listA = jVar.t().g().a();
        boolean z = false;
        HashSet hashSet = new HashSet(listF != null ? listF.size() : 0);
        if (listF != null && !listF.isEmpty()) {
            for (JobInfo jobInfo : listF) {
                String strG = g(jobInfo);
                if (TextUtils.isEmpty(strG)) {
                    d(jobScheduler, jobInfo.getId());
                } else {
                    hashSet.add(strG);
                }
            }
        }
        Iterator<String> it = listA.iterator();
        while (it.hasNext()) {
            if (!hashSet.contains(it.next())) {
                n.c().a(f2384f, "Reconciling jobs", new Throwable[0]);
                z = true;
                break;
            }
        }
        if (z) {
            WorkDatabase workDatabaseT = jVar.t();
            workDatabaseT.beginTransaction();
            try {
                q qVarJ = workDatabaseT.j();
                Iterator<String> it2 = listA.iterator();
                while (it2.hasNext()) {
                    qVarJ.b(it2.next(), -1L);
                }
                workDatabaseT.setTransactionSuccessful();
            } finally {
                workDatabaseT.endTransaction();
            }
        }
        return z;
    }

    @Override // androidx.work.impl.e
    public void a(p... pVarArr) {
        List<Integer> listE;
        WorkDatabase workDatabaseT = this.f2387i.t();
        c cVar = new c(workDatabaseT);
        for (p pVar : pVarArr) {
            workDatabaseT.beginTransaction();
            try {
                p pVarM = workDatabaseT.j().m(pVar.f2525c);
                if (pVarM == null) {
                    n.c().h(f2384f, "Skipping scheduling " + pVar.f2525c + " because it's no longer in the DB", new Throwable[0]);
                    workDatabaseT.setTransactionSuccessful();
                } else if (pVarM.f2526d != x.a.ENQUEUED) {
                    n.c().h(f2384f, "Skipping scheduling " + pVar.f2525c + " because it is no longer enqueued", new Throwable[0]);
                    workDatabaseT.setTransactionSuccessful();
                } else {
                    g gVarC = workDatabaseT.g().c(pVar.f2525c);
                    int iD = gVarC != null ? gVarC.f2515b : cVar.d(this.f2387i.n().i(), this.f2387i.n().g());
                    if (gVarC == null) {
                        this.f2387i.t().g().b(new g(pVar.f2525c, iD));
                    }
                    i(pVar, iD);
                    if (Build.VERSION.SDK_INT == 23 && (listE = e(this.f2385g, this.f2386h, pVar.f2525c)) != null) {
                        int iIndexOf = listE.indexOf(Integer.valueOf(iD));
                        if (iIndexOf >= 0) {
                            listE.remove(iIndexOf);
                        }
                        i(pVar, !listE.isEmpty() ? listE.get(0).intValue() : cVar.d(this.f2387i.n().i(), this.f2387i.n().g()));
                    }
                    workDatabaseT.setTransactionSuccessful();
                }
                workDatabaseT.endTransaction();
            } catch (Throwable th) {
                workDatabaseT.endTransaction();
                throw th;
            }
        }
    }

    @Override // androidx.work.impl.e
    public boolean c() {
        return true;
    }

    @Override // androidx.work.impl.e
    public void cancel(String str) {
        List<Integer> listE = e(this.f2385g, this.f2386h, str);
        if (listE == null || listE.isEmpty()) {
            return;
        }
        Iterator<Integer> it = listE.iterator();
        while (it.hasNext()) {
            d(this.f2386h, it.next().intValue());
        }
        this.f2387i.t().g().d(str);
    }

    public void i(p pVar, int i2) {
        JobInfo jobInfoA = this.f2388j.a(pVar, i2);
        n nVarC = n.c();
        String str = f2384f;
        nVarC.a(str, String.format("Scheduling work ID %s Job ID %s", pVar.f2525c, Integer.valueOf(i2)), new Throwable[0]);
        try {
            if (this.f2386h.schedule(jobInfoA) == 0) {
                n.c().h(str, String.format("Unable to schedule work ID %s", pVar.f2525c), new Throwable[0]);
                if (pVar.s && pVar.t == r.RUN_AS_NON_EXPEDITED_WORK_REQUEST) {
                    pVar.s = false;
                    n.c().a(str, String.format("Scheduling a non-expedited job (work ID %s)", pVar.f2525c), new Throwable[0]);
                    i(pVar, i2);
                }
            }
        } catch (IllegalStateException e2) {
            List<JobInfo> listF = f(this.f2385g, this.f2386h);
            String str2 = String.format(Locale.getDefault(), "JobScheduler 100 job limit exceeded.  We count %d WorkManager jobs in JobScheduler; we have %d tracked jobs in our DB; our Configuration limit is %d.", Integer.valueOf(listF != null ? listF.size() : 0), Integer.valueOf(this.f2387i.t().j().g().size()), Integer.valueOf(this.f2387i.n().h()));
            n.c().b(f2384f, str2, new Throwable[0]);
            throw new IllegalStateException(str2, e2);
        } catch (Throwable th) {
            n.c().b(f2384f, String.format("Unable to schedule %s", pVar), th);
        }
    }

    public b(Context context, j jVar, JobScheduler jobScheduler, a aVar) {
        this.f2385g = context;
        this.f2387i = jVar;
        this.f2386h = jobScheduler;
        this.f2388j = aVar;
    }
}
