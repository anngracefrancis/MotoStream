package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzbim extends MutableContextWrapper {
    private Activity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f14469b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f14470c;

    public zzbim(Context context) {
        super(context);
        setBaseContext(context);
    }

    public final Context a() {
        return this.f14470c;
    }

    public final Activity b() {
        return this.a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        return this.f14470c.getSystemService(str);
    }

    @Override // android.content.MutableContextWrapper
    public final void setBaseContext(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f14469b = applicationContext;
        this.a = context instanceof Activity ? (Activity) context : null;
        this.f14470c = context;
        super.setBaseContext(applicationContext);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void startActivity(Intent intent) {
        Activity activity = this.a;
        if (activity != null) {
            activity.startActivity(intent);
        } else {
            intent.setFlags(268435456);
            this.f14469b.startActivity(intent);
        }
    }
}
