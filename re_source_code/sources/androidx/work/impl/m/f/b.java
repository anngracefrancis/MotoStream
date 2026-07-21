package androidx.work.impl.m.f;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.work.n;

/* JADX INFO: compiled from: BatteryNotLowTracker.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends c<Boolean> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f2492i = n.f("BatteryNotLowTracker");

    public b(Context context, androidx.work.impl.utils.p.a aVar) {
        super(context, aVar);
    }

    @Override // androidx.work.impl.m.f.c
    public IntentFilter g() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.BATTERY_OKAY");
        intentFilter.addAction("android.intent.action.BATTERY_LOW");
        return intentFilter;
    }

    @Override // androidx.work.impl.m.f.c
    public void h(Context context, Intent intent) {
        if (intent.getAction() == null) {
            return;
        }
        n.c().a(f2492i, String.format("Received %s", intent.getAction()), new Throwable[0]);
        String action = intent.getAction();
        action.hashCode();
        if (action.equals("android.intent.action.BATTERY_OKAY")) {
            d(Boolean.TRUE);
        } else if (action.equals("android.intent.action.BATTERY_LOW")) {
            d(Boolean.FALSE);
        }
    }

    @Override // androidx.work.impl.m.f.d
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public Boolean b() {
        Intent intentRegisterReceiver = this.f2496c.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (intentRegisterReceiver != null) {
            return Boolean.valueOf(intentRegisterReceiver.getIntExtra("status", -1) == 1 || ((float) intentRegisterReceiver.getIntExtra("level", -1)) / ((float) intentRegisterReceiver.getIntExtra("scale", -1)) > 0.15f);
        }
        n.c().b(f2492i, "getInitialState - null intent received", new Throwable[0]);
        return null;
    }
}
