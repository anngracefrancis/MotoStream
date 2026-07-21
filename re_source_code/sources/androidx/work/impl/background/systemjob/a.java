package androidx.work.impl.background.systemjob;

import android.app.job.JobInfo;
import android.content.ComponentName;
import android.content.Context;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.work.c;
import androidx.work.d;
import androidx.work.impl.n.p;
import androidx.work.n;
import androidx.work.o;
import java.util.Iterator;

/* JADX INFO: compiled from: SystemJobInfoConverter.java */
/* JADX INFO: loaded from: classes.dex */
class a {
    private static final String a = n.f("SystemJobInfoConverter");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ComponentName f2383b;

    /* JADX INFO: renamed from: androidx.work.impl.background.systemjob.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SystemJobInfoConverter.java */
    static /* synthetic */ class C0049a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[o.values().length];
            a = iArr;
            try {
                iArr[o.NOT_REQUIRED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[o.CONNECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[o.UNMETERED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[o.NOT_ROAMING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[o.METERED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    a(Context context) {
        this.f2383b = new ComponentName(context.getApplicationContext(), (Class<?>) SystemJobService.class);
    }

    private static JobInfo.TriggerContentUri b(d.a aVar) {
        return new JobInfo.TriggerContentUri(aVar.a(), aVar.b() ? 1 : 0);
    }

    static int c(o oVar) {
        int i2 = C0049a.a[oVar.ordinal()];
        if (i2 == 1) {
            return 0;
        }
        if (i2 == 2) {
            return 1;
        }
        if (i2 == 3) {
            return 2;
        }
        if (i2 != 4) {
            if (i2 == 5 && Build.VERSION.SDK_INT >= 26) {
                return 4;
            }
        } else if (Build.VERSION.SDK_INT >= 24) {
            return 3;
        }
        n.c().a(a, String.format("API version too low. Cannot convert network type value %s", oVar), new Throwable[0]);
        return 1;
    }

    static void d(JobInfo.Builder builder, o oVar) {
        if (Build.VERSION.SDK_INT < 30 || oVar != o.TEMPORARILY_UNMETERED) {
            builder.setRequiredNetworkType(c(oVar));
        } else {
            builder.setRequiredNetwork(new NetworkRequest.Builder().addCapability(25).build());
        }
    }

    JobInfo a(p pVar, int i2) {
        c cVar = pVar.l;
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("EXTRA_WORK_SPEC_ID", pVar.f2525c);
        persistableBundle.putBoolean("EXTRA_IS_PERIODIC", pVar.d());
        JobInfo.Builder extras = new JobInfo.Builder(i2, this.f2383b).setRequiresCharging(cVar.g()).setRequiresDeviceIdle(cVar.h()).setExtras(persistableBundle);
        d(extras, cVar.b());
        if (!cVar.h()) {
            extras.setBackoffCriteria(pVar.o, pVar.n == androidx.work.a.LINEAR ? 0 : 1);
        }
        long jMax = Math.max(pVar.a() - System.currentTimeMillis(), 0L);
        int i3 = Build.VERSION.SDK_INT;
        if (i3 <= 28 || jMax > 0) {
            extras.setMinimumLatency(jMax);
        } else if (!pVar.s) {
            extras.setImportantWhileForeground(true);
        }
        if (i3 >= 24 && cVar.e()) {
            Iterator<d.a> it = cVar.a().b().iterator();
            while (it.hasNext()) {
                extras.addTriggerContentUri(b(it.next()));
            }
            extras.setTriggerContentUpdateDelay(cVar.c());
            extras.setTriggerContentMaxDelay(cVar.d());
        }
        extras.setPersisted(false);
        if (Build.VERSION.SDK_INT >= 26) {
            extras.setRequiresBatteryNotLow(cVar.f());
            extras.setRequiresStorageNotLow(cVar.i());
        }
        boolean z = pVar.m > 0;
        boolean z2 = jMax > 0;
        if (androidx.core.os.a.c() && pVar.s && !z && !z2) {
            extras.setExpedited(true);
        }
        return extras.build();
    }
}
