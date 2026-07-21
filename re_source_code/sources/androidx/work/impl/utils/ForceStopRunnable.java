package androidx.work.impl.utils;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.ApplicationExitInfo;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteAccessPermException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteTableLockedException;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.n.p;
import androidx.work.impl.n.q;
import androidx.work.x;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class ForceStopRunnable implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f2554f = androidx.work.n.f("ForceStopRunnable");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final long f2555g = TimeUnit.DAYS.toMillis(3650);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Context f2556h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final androidx.work.impl.j f2557i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f2558j = 0;

    public static class BroadcastReceiver extends android.content.BroadcastReceiver {
        private static final String a = androidx.work.n.f("ForceStopRunnable$Rcvr");

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || !"ACTION_FORCE_STOP_RESCHEDULE".equals(intent.getAction())) {
                return;
            }
            androidx.work.n.c().g(a, "Rescheduling alarm that keeps track of force-stops.", new Throwable[0]);
            ForceStopRunnable.g(context);
        }
    }

    public ForceStopRunnable(Context context, androidx.work.impl.j jVar) {
        this.f2556h = context.getApplicationContext();
        this.f2557i = jVar;
    }

    static Intent c(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, (Class<?>) BroadcastReceiver.class));
        intent.setAction("ACTION_FORCE_STOP_RESCHEDULE");
        return intent;
    }

    private static PendingIntent d(Context context, int i2) {
        return PendingIntent.getBroadcast(context, -1, c(context), i2);
    }

    @SuppressLint({"ClassVerificationFailure"})
    static void g(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent pendingIntentD = d(context, androidx.core.os.a.c() ? 167772160 : 134217728);
        long jCurrentTimeMillis = System.currentTimeMillis() + f2555g;
        if (alarmManager != null) {
            if (Build.VERSION.SDK_INT >= 19) {
                alarmManager.setExact(0, jCurrentTimeMillis, pendingIntentD);
            } else {
                alarmManager.set(0, jCurrentTimeMillis, pendingIntentD);
            }
        }
    }

    public boolean a() {
        boolean zH = Build.VERSION.SDK_INT >= 23 ? androidx.work.impl.background.systemjob.b.h(this.f2556h, this.f2557i) : false;
        WorkDatabase workDatabaseT = this.f2557i.t();
        q qVarJ = workDatabaseT.j();
        androidx.work.impl.n.n nVarI = workDatabaseT.i();
        workDatabaseT.beginTransaction();
        try {
            List<p> listI = qVarJ.i();
            boolean z = (listI == null || listI.isEmpty()) ? false : true;
            if (z) {
                for (p pVar : listI) {
                    qVarJ.a(x.a.ENQUEUED, pVar.f2525c);
                    qVarJ.b(pVar.f2525c, -1L);
                }
            }
            nVarI.a();
            workDatabaseT.setTransactionSuccessful();
            workDatabaseT.endTransaction();
            return z || zH;
        } catch (Throwable th) {
            workDatabaseT.endTransaction();
            throw th;
        }
    }

    public void b() {
        boolean zA = a();
        if (h()) {
            androidx.work.n.c().a(f2554f, "Rescheduling Workers.", new Throwable[0]);
            this.f2557i.x();
            this.f2557i.q().c(false);
        } else if (e()) {
            androidx.work.n.c().a(f2554f, "Application was force-stopped, rescheduling.", new Throwable[0]);
            this.f2557i.x();
        } else if (zA) {
            androidx.work.n.c().a(f2554f, "Found unfinished work, scheduling it.", new Throwable[0]);
            androidx.work.impl.f.b(this.f2557i.n(), this.f2557i.t(), this.f2557i.s());
        }
    }

    @SuppressLint({"ClassVerificationFailure"})
    public boolean e() {
        try {
            PendingIntent pendingIntentD = d(this.f2556h, androidx.core.os.a.c() ? 570425344 : 536870912);
            if (Build.VERSION.SDK_INT >= 30) {
                if (pendingIntentD != null) {
                    pendingIntentD.cancel();
                }
                List<ApplicationExitInfo> historicalProcessExitReasons = ((ActivityManager) this.f2556h.getSystemService("activity")).getHistoricalProcessExitReasons(null, 0, 0);
                if (historicalProcessExitReasons != null && !historicalProcessExitReasons.isEmpty()) {
                    for (int i2 = 0; i2 < historicalProcessExitReasons.size(); i2++) {
                        if (historicalProcessExitReasons.get(i2).getReason() == 10) {
                            return true;
                        }
                    }
                }
            } else if (pendingIntentD == null) {
                g(this.f2556h);
                return true;
            }
            return false;
        } catch (IllegalArgumentException | SecurityException e2) {
            androidx.work.n.c().h(f2554f, "Ignoring exception", e2);
            return true;
        }
    }

    public boolean f() {
        androidx.work.b bVarN = this.f2557i.n();
        if (TextUtils.isEmpty(bVarN.c())) {
            androidx.work.n.c().a(f2554f, "The default process name was not specified.", new Throwable[0]);
            return true;
        }
        boolean zB = f.b(this.f2556h, bVarN);
        androidx.work.n.c().a(f2554f, String.format("Is default app process = %s", Boolean.valueOf(zB)), new Throwable[0]);
        return zB;
    }

    boolean h() {
        return this.f2557i.q().a();
    }

    public void i(long j2) {
        try {
            Thread.sleep(j2);
        } catch (InterruptedException unused) {
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        int i2;
        try {
            if (!f()) {
                this.f2557i.w();
                return;
            }
            while (true) {
                androidx.work.impl.i.e(this.f2556h);
                androidx.work.n.c().a(f2554f, "Performing cleanup operations.", new Throwable[0]);
                try {
                    b();
                    break;
                } catch (SQLiteAccessPermException | SQLiteCantOpenDatabaseException | SQLiteConstraintException | SQLiteDatabaseCorruptException | SQLiteDatabaseLockedException | SQLiteTableLockedException e2) {
                    i2 = this.f2558j + 1;
                    this.f2558j = i2;
                    if (i2 >= 3) {
                        androidx.work.n nVarC = androidx.work.n.c();
                        String str = f2554f;
                        nVarC.b(str, "The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e2);
                        IllegalStateException illegalStateException = new IllegalStateException("The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e2);
                        androidx.work.j jVarD = this.f2557i.n().d();
                        if (jVarD == null) {
                            throw illegalStateException;
                        }
                        androidx.work.n.c().a(str, "Routing exception to the specified exception handler", illegalStateException);
                        jVarD.a(illegalStateException);
                        break;
                    }
                    androidx.work.n.c().a(f2554f, String.format("Retrying after %s", Long.valueOf(((long) i2) * 300)), e2);
                    i(((long) this.f2558j) * 300);
                }
                androidx.work.n.c().a(f2554f, String.format("Retrying after %s", Long.valueOf(((long) i2) * 300)), e2);
                i(((long) this.f2558j) * 300);
            }
            this.f2557i.w();
        } catch (Throwable th) {
            this.f2557i.w();
            throw th;
        }
    }
}
