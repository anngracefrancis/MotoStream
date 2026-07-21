package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.work.impl.j;
import androidx.work.n;

/* JADX INFO: loaded from: classes.dex */
public class RescheduleReceiver extends BroadcastReceiver {
    private static final String a = n.f("RescheduleReceiver");

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        n.c().a(a, String.format("Received intent %s", intent), new Throwable[0]);
        if (Build.VERSION.SDK_INT < 23) {
            context.startService(b.e(context));
            return;
        }
        try {
            j.p(context).y(goAsync());
        } catch (IllegalStateException e2) {
            n.c().b(a, "Cannot reschedule jobs. WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().", e2);
        }
    }
}
