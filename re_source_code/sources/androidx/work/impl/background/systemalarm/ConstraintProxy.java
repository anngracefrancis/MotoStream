package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.impl.n.p;
import androidx.work.n;
import androidx.work.o;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
abstract class ConstraintProxy extends BroadcastReceiver {
    private static final String a = n.f("ConstraintProxy");

    public static class BatteryChargingProxy extends ConstraintProxy {
        @Override // androidx.work.impl.background.systemalarm.ConstraintProxy, android.content.BroadcastReceiver
        public /* bridge */ /* synthetic */ void onReceive(Context context, Intent intent) {
            super.onReceive(context, intent);
        }
    }

    public static class BatteryNotLowProxy extends ConstraintProxy {
        @Override // androidx.work.impl.background.systemalarm.ConstraintProxy, android.content.BroadcastReceiver
        public /* bridge */ /* synthetic */ void onReceive(Context context, Intent intent) {
            super.onReceive(context, intent);
        }
    }

    public static class NetworkStateProxy extends ConstraintProxy {
        @Override // androidx.work.impl.background.systemalarm.ConstraintProxy, android.content.BroadcastReceiver
        public /* bridge */ /* synthetic */ void onReceive(Context context, Intent intent) {
            super.onReceive(context, intent);
        }
    }

    public static class StorageNotLowProxy extends ConstraintProxy {
        @Override // androidx.work.impl.background.systemalarm.ConstraintProxy, android.content.BroadcastReceiver
        public /* bridge */ /* synthetic */ void onReceive(Context context, Intent intent) {
            super.onReceive(context, intent);
        }
    }

    ConstraintProxy() {
    }

    static void a(Context context, List<p> list) {
        Iterator<p> it = list.iterator();
        boolean zF = false;
        boolean zG = false;
        boolean zI = false;
        boolean z = false;
        while (it.hasNext()) {
            androidx.work.c cVar = it.next().l;
            zF |= cVar.f();
            zG |= cVar.g();
            zI |= cVar.i();
            z |= cVar.b() != o.NOT_REQUIRED;
            if (zF && zG && zI && z) {
                break;
            }
        }
        context.sendBroadcast(ConstraintProxyUpdateReceiver.a(context, zF, zG, zI, z));
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        n.c().a(a, String.format("onReceive : %s", intent), new Throwable[0]);
        context.startService(b.a(context));
    }
}
