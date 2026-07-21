package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;

/* JADX INFO: loaded from: classes2.dex */
final class qv implements zzdu {
    private final /* synthetic */ Activity a;

    qv(st stVar, Activity activity) {
        this.a = activity;
    }

    @Override // com.google.android.gms.internal.ads.zzdu
    public final void a(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityResumed(this.a);
    }
}
