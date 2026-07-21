package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzazp {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f14304d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Context f14305e;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f14303c = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<BroadcastReceiver, IntentFilter> f14302b = new WeakHashMap();
    private final BroadcastReceiver a = new e6(this);

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void e(Context context, Intent intent) {
        for (Map.Entry<BroadcastReceiver, IntentFilter> entry : this.f14302b.entrySet()) {
            if (entry.getValue().hasAction(intent.getAction())) {
                entry.getKey().onReceive(context, intent);
            }
        }
    }

    public final synchronized void a(Context context) {
        if (this.f14303c) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        this.f14305e = applicationContext;
        if (applicationContext == null) {
            this.f14305e = context;
        }
        zzacu.a(this.f14305e);
        this.f14304d = ((Boolean) zzyt.e().c(zzacu.Q2)).booleanValue();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        this.f14305e.registerReceiver(this.a, intentFilter);
        this.f14303c = true;
    }

    public final synchronized void b(Context context, BroadcastReceiver broadcastReceiver) {
        if (this.f14304d) {
            this.f14302b.remove(broadcastReceiver);
        } else {
            context.unregisterReceiver(broadcastReceiver);
        }
    }

    public final synchronized void c(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (this.f14304d) {
            this.f14302b.put(broadcastReceiver, intentFilter);
        } else {
            context.registerReceiver(broadcastReceiver, intentFilter);
        }
    }
}
