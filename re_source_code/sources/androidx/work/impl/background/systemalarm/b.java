package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.n.p;
import androidx.work.n;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: CommandHandler.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements androidx.work.impl.b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f2353f = n.f("CommandHandler");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Context f2354g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Map<String, androidx.work.impl.b> f2355h = new HashMap();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Object f2356i = new Object();

    b(Context context) {
        this.f2354g = context;
    }

    static Intent a(Context context) {
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_CONSTRAINTS_CHANGED");
        return intent;
    }

    static Intent b(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_DELAY_MET");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    static Intent c(Context context, String str, boolean z) {
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_EXECUTION_COMPLETED");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        intent.putExtra("KEY_NEEDS_RESCHEDULE", z);
        return intent;
    }

    static Intent e(Context context) {
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_RESCHEDULE");
        return intent;
    }

    static Intent f(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_SCHEDULE_WORK");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    static Intent g(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_STOP_WORK");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    private void h(Intent intent, int i2, e eVar) {
        n.c().a(f2353f, String.format("Handling constraints changed %s", intent), new Throwable[0]);
        new c(this.f2354g, i2, eVar).a();
    }

    private void i(Intent intent, int i2, e eVar) {
        Bundle extras = intent.getExtras();
        synchronized (this.f2356i) {
            String string = extras.getString("KEY_WORKSPEC_ID");
            n nVarC = n.c();
            String str = f2353f;
            nVarC.a(str, String.format("Handing delay met for %s", string), new Throwable[0]);
            if (this.f2355h.containsKey(string)) {
                n.c().a(str, String.format("WorkSpec %s is already being handled for ACTION_DELAY_MET", string), new Throwable[0]);
            } else {
                d dVar = new d(this.f2354g, i2, string, eVar);
                this.f2355h.put(string, dVar);
                dVar.f();
            }
        }
    }

    private void j(Intent intent, int i2) {
        Bundle extras = intent.getExtras();
        String string = extras.getString("KEY_WORKSPEC_ID");
        boolean z = extras.getBoolean("KEY_NEEDS_RESCHEDULE");
        n.c().a(f2353f, String.format("Handling onExecutionCompleted %s, %s", intent, Integer.valueOf(i2)), new Throwable[0]);
        d(string, z);
    }

    private void k(Intent intent, int i2, e eVar) {
        n.c().a(f2353f, String.format("Handling reschedule %s, %s", intent, Integer.valueOf(i2)), new Throwable[0]);
        eVar.g().x();
    }

    private void l(Intent intent, int i2, e eVar) {
        String string = intent.getExtras().getString("KEY_WORKSPEC_ID");
        n nVarC = n.c();
        String str = f2353f;
        nVarC.a(str, String.format("Handling schedule work for %s", string), new Throwable[0]);
        WorkDatabase workDatabaseT = eVar.g().t();
        workDatabaseT.beginTransaction();
        try {
            p pVarM = workDatabaseT.j().m(string);
            if (pVarM == null) {
                n.c().h(str, "Skipping scheduling " + string + " because it's no longer in the DB", new Throwable[0]);
                return;
            }
            if (pVarM.f2526d.g()) {
                n.c().h(str, "Skipping scheduling " + string + "because it is finished.", new Throwable[0]);
                return;
            }
            long jA = pVarM.a();
            if (pVarM.b()) {
                n.c().a(str, String.format("Opportunistically setting an alarm for %s at %s", string, Long.valueOf(jA)), new Throwable[0]);
                a.c(this.f2354g, eVar.g(), string, jA);
                eVar.k(new e.b(eVar, a(this.f2354g), i2));
            } else {
                n.c().a(str, String.format("Setting up Alarms for %s at %s", string, Long.valueOf(jA)), new Throwable[0]);
                a.c(this.f2354g, eVar.g(), string, jA);
            }
            workDatabaseT.setTransactionSuccessful();
        } finally {
            workDatabaseT.endTransaction();
        }
    }

    private void m(Intent intent, e eVar) {
        String string = intent.getExtras().getString("KEY_WORKSPEC_ID");
        n.c().a(f2353f, String.format("Handing stopWork work for %s", string), new Throwable[0]);
        eVar.g().C(string);
        a.a(this.f2354g, eVar.g(), string);
        eVar.d(string, false);
    }

    private static boolean n(Bundle bundle, String... strArr) {
        if (bundle == null || bundle.isEmpty()) {
            return false;
        }
        for (String str : strArr) {
            if (bundle.get(str) == null) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.work.impl.b
    public void d(String str, boolean z) {
        synchronized (this.f2356i) {
            androidx.work.impl.b bVarRemove = this.f2355h.remove(str);
            if (bVarRemove != null) {
                bVarRemove.d(str, z);
            }
        }
    }

    boolean o() {
        boolean z;
        synchronized (this.f2356i) {
            z = !this.f2355h.isEmpty();
        }
        return z;
    }

    void p(Intent intent, int i2, e eVar) {
        String action = intent.getAction();
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action)) {
            h(intent, i2, eVar);
            return;
        }
        if ("ACTION_RESCHEDULE".equals(action)) {
            k(intent, i2, eVar);
            return;
        }
        if (!n(intent.getExtras(), "KEY_WORKSPEC_ID")) {
            n.c().b(f2353f, String.format("Invalid request for %s, requires %s.", action, "KEY_WORKSPEC_ID"), new Throwable[0]);
            return;
        }
        if ("ACTION_SCHEDULE_WORK".equals(action)) {
            l(intent, i2, eVar);
            return;
        }
        if ("ACTION_DELAY_MET".equals(action)) {
            i(intent, i2, eVar);
            return;
        }
        if ("ACTION_STOP_WORK".equals(action)) {
            m(intent, eVar);
        } else if ("ACTION_EXECUTION_COMPLETED".equals(action)) {
            j(intent, i2);
        } else {
            n.c().h(f2353f, String.format("Ignoring intent %s", intent), new Throwable[0]);
        }
    }
}
