package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
class p3 extends BroadcastReceiver {

    @VisibleForTesting
    private static final String a = p3.class.getName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzkc f17899b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f17900c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f17901d;

    p3(zzkc zzkcVar) {
        Preconditions.k(zzkcVar);
        this.f17899b = zzkcVar;
    }

    public final void b() {
        this.f17899b.c0();
        this.f17899b.g().d();
        if (this.f17900c) {
            return;
        }
        this.f17899b.f().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        this.f17901d = this.f17899b.U().z();
        this.f17899b.h().P().b("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.f17901d));
        this.f17900c = true;
    }

    public final void c() {
        this.f17899b.c0();
        this.f17899b.g().d();
        this.f17899b.g().d();
        if (this.f17900c) {
            this.f17899b.h().P().a("Unregistering connectivity change receiver");
            this.f17900c = false;
            this.f17901d = false;
            try {
                this.f17899b.f().unregisterReceiver(this);
            } catch (IllegalArgumentException e2) {
                this.f17899b.h().H().b("Failed to unregister the network broadcast receiver", e2);
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.f17899b.c0();
        String action = intent.getAction();
        this.f17899b.h().P().b("NetworkBroadcastReceiver received action", action);
        if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            this.f17899b.h().K().b("NetworkBroadcastReceiver received unknown action", action);
            return;
        }
        boolean z = this.f17899b.U().z();
        if (this.f17901d != z) {
            this.f17901d = z;
            this.f17899b.g().z(new o3(this, z));
        }
    }
}
