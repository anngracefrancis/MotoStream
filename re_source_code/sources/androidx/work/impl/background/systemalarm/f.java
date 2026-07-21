package androidx.work.impl.background.systemalarm;

import android.content.Context;
import androidx.work.impl.n.p;
import androidx.work.n;

/* JADX INFO: compiled from: SystemAlarmScheduler.java */
/* JADX INFO: loaded from: classes.dex */
public class f implements androidx.work.impl.e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f2378f = n.f("SystemAlarmScheduler");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Context f2379g;

    public f(Context context) {
        this.f2379g = context.getApplicationContext();
    }

    private void b(p pVar) {
        n.c().a(f2378f, String.format("Scheduling work with workSpecId %s", pVar.f2525c), new Throwable[0]);
        this.f2379g.startService(b.f(this.f2379g, pVar.f2525c));
    }

    @Override // androidx.work.impl.e
    public void a(p... pVarArr) {
        for (p pVar : pVarArr) {
            b(pVar);
        }
    }

    @Override // androidx.work.impl.e
    public boolean c() {
        return true;
    }

    @Override // androidx.work.impl.e
    public void cancel(String str) {
        this.f2379g.startService(b.g(this.f2379g, str));
    }
}
