package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.util.Base64;
import e.e.b.a.i.b0.j.j0;

/* JADX INFO: compiled from: AlarmManagerScheduler.java */
/* JADX INFO: loaded from: classes2.dex */
public class p implements y {
    private final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final j0 f11339b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AlarmManager f11340c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final t f11341d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final e.e.b.a.i.c0.a f11342e;

    public p(Context context, j0 j0Var, e.e.b.a.i.c0.a aVar, t tVar) {
        this(context, j0Var, (AlarmManager) context.getSystemService("alarm"), aVar, tVar);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.y
    public void a(e.e.b.a.i.q qVar, int i2) {
        b(qVar, i2, false);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.y
    public void b(e.e.b.a.i.q qVar, int i2, boolean z) {
        Uri.Builder builder = new Uri.Builder();
        builder.appendQueryParameter("backendName", qVar.b());
        builder.appendQueryParameter("priority", String.valueOf(e.e.b.a.i.d0.a.a(qVar.d())));
        if (qVar.c() != null) {
            builder.appendQueryParameter("extras", Base64.encodeToString(qVar.c(), 0));
        }
        Intent intent = new Intent(this.a, (Class<?>) AlarmManagerSchedulerBroadcastReceiver.class);
        intent.setData(builder.build());
        intent.putExtra("attemptNumber", i2);
        if (!z && c(intent)) {
            e.e.b.a.i.z.a.b("AlarmManagerScheduler", "Upload for context %s is already scheduled. Returning...", qVar);
            return;
        }
        long jW0 = this.f11339b.W0(qVar);
        long jG = this.f11341d.g(qVar.d(), jW0, i2);
        e.e.b.a.i.z.a.c("AlarmManagerScheduler", "Scheduling upload for context %s in %dms(Backend next call timestamp %d). Attempt %d", qVar, Long.valueOf(jG), Long.valueOf(jW0), Integer.valueOf(i2));
        this.f11340c.set(3, this.f11342e.a() + jG, PendingIntent.getBroadcast(this.a, 0, intent, Build.VERSION.SDK_INT >= 23 ? 67108864 : 0));
    }

    boolean c(Intent intent) {
        return PendingIntent.getBroadcast(this.a, 0, intent, Build.VERSION.SDK_INT >= 23 ? 603979776 : 536870912) != null;
    }

    p(Context context, j0 j0Var, AlarmManager alarmManager, e.e.b.a.i.c0.a aVar, t tVar) {
        this.a = context;
        this.f11339b = j0Var;
        this.f11340c = alarmManager;
        this.f11342e = aVar;
        this.f11341d = tVar;
    }
}
