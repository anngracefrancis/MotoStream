package androidx.work.impl.m.f;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.work.n;

/* JADX INFO: compiled from: StorageNotLowTracker.java */
/* JADX INFO: loaded from: classes.dex */
public class f extends c<Boolean> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f2506i = n.f("StorageNotLowTracker");

    public f(Context context, androidx.work.impl.utils.p.a aVar) {
        super(context, aVar);
    }

    @Override // androidx.work.impl.m.f.c
    public IntentFilter g() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.DEVICE_STORAGE_OK");
        intentFilter.addAction("android.intent.action.DEVICE_STORAGE_LOW");
        return intentFilter;
    }

    @Override // androidx.work.impl.m.f.c
    public void h(Context context, Intent intent) {
        if (intent.getAction() == null) {
            return;
        }
        n.c().a(f2506i, String.format("Received %s", intent.getAction()), new Throwable[0]);
        String action = intent.getAction();
        action.hashCode();
        if (action.equals("android.intent.action.DEVICE_STORAGE_LOW")) {
            d(Boolean.FALSE);
        } else if (action.equals("android.intent.action.DEVICE_STORAGE_OK")) {
            d(Boolean.TRUE);
        }
    }

    @Override // androidx.work.impl.m.f.d
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public Boolean b() {
        Intent intentRegisterReceiver = this.f2496c.registerReceiver(null, g());
        if (intentRegisterReceiver == null || intentRegisterReceiver.getAction() == null) {
            return Boolean.TRUE;
        }
        String action = intentRegisterReceiver.getAction();
        action.hashCode();
        if (action.equals("android.intent.action.DEVICE_STORAGE_LOW")) {
            return Boolean.FALSE;
        }
        if (action.equals("android.intent.action.DEVICE_STORAGE_OK")) {
            return Boolean.TRUE;
        }
        return null;
    }
}
