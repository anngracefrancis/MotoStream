package com.google.android.gms.common.api.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/* JADX INFO: loaded from: classes2.dex */
public final class zabq extends BroadcastReceiver {
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zabr f11832b;

    public zabq(zabr zabrVar) {
        this.f11832b = zabrVar;
    }

    public final synchronized void a() {
        Context context = this.a;
        if (context != null) {
            context.unregisterReceiver(this);
        }
        this.a = null;
    }

    public final void b(Context context) {
        this.a = context;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        if ("com.google.android.gms".equals(data != null ? data.getSchemeSpecificPart() : null)) {
            this.f11832b.a();
            a();
        }
    }
}
