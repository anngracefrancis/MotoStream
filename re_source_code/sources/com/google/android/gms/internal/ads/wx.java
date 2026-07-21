package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* JADX INFO: loaded from: classes2.dex */
final class wx implements zzdu {
    private final /* synthetic */ Activity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ Bundle f13527b;

    wx(st stVar, Activity activity, Bundle bundle) {
        this.a = activity;
        this.f13527b = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzdu
    public final void a(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivitySaveInstanceState(this.a, this.f13527b);
    }
}
