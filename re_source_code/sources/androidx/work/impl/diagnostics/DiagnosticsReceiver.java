package androidx.work.impl.diagnostics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.impl.workers.DiagnosticsWorker;
import androidx.work.n;
import androidx.work.p;
import androidx.work.y;

/* JADX INFO: loaded from: classes.dex */
public class DiagnosticsReceiver extends BroadcastReceiver {
    private static final String a = n.f("DiagnosticsRcvr");

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        n.c().a(a, "Requesting diagnostics", new Throwable[0]);
        try {
            y.h(context).c(p.d(DiagnosticsWorker.class));
        } catch (IllegalStateException e2) {
            n.c().b(a, "WorkManager is not initialized", e2);
        }
    }
}
