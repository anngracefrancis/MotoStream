package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;

/* JADX INFO: loaded from: classes2.dex */
public class AlarmManagerSchedulerBroadcastReceiver extends BroadcastReceiver {
    static /* synthetic */ void a() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String queryParameter = intent.getData().getQueryParameter("backendName");
        String queryParameter2 = intent.getData().getQueryParameter("extras");
        int iIntValue = Integer.valueOf(intent.getData().getQueryParameter("priority")).intValue();
        int i2 = intent.getExtras().getInt("attemptNumber");
        e.e.b.a.i.u.f(context);
        e.e.b.a.i.q.a aVarD = e.e.b.a.i.q.a().b(queryParameter).d(e.e.b.a.i.d0.a.b(iIntValue));
        if (queryParameter2 != null) {
            aVarD.c(Base64.decode(queryParameter2, 0));
        }
        e.e.b.a.i.u.c().e().v(aVarD.a(), i2, new Runnable() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.a
            @Override // java.lang.Runnable
            public final void run() {
                AlarmManagerSchedulerBroadcastReceiver.a();
            }
        });
    }
}
