package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import androidx.work.impl.n.p;
import androidx.work.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: ConstraintsCommandHandler.java */
/* JADX INFO: loaded from: classes.dex */
class c {
    private static final String a = n.f("ConstraintsCmdHandler");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f2357b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f2358c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final e f2359d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final androidx.work.impl.m.d f2360e;

    c(Context context, int i2, e eVar) {
        this.f2357b = context;
        this.f2358c = i2;
        this.f2359d = eVar;
        this.f2360e = new androidx.work.impl.m.d(context, eVar.f(), null);
    }

    void a() {
        List<p> listG = this.f2359d.g().t().j().g();
        ConstraintProxy.a(this.f2357b, listG);
        this.f2360e.d(listG);
        ArrayList arrayList = new ArrayList(listG.size());
        long jCurrentTimeMillis = System.currentTimeMillis();
        for (p pVar : listG) {
            String str = pVar.f2525c;
            if (jCurrentTimeMillis >= pVar.a() && (!pVar.b() || this.f2360e.c(str))) {
                arrayList.add(pVar);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str2 = ((p) it.next()).f2525c;
            Intent intentB = b.b(this.f2357b, str2);
            n.c().a(a, String.format("Creating a delay_met command for workSpec with id (%s)", str2), new Throwable[0]);
            e eVar = this.f2359d;
            eVar.k(new e.b(eVar, intentB, this.f2358c));
        }
        this.f2360e.e();
    }
}
