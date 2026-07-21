package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* JADX INFO: loaded from: classes2.dex */
final class f40 implements zzun {
    private final /* synthetic */ Activity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ Bundle f12564b;

    f40(e40 e40Var, Activity activity, Bundle bundle) {
        this.a = activity;
        this.f12564b = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzun
    public final void a(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityCreated(this.a, this.f12564b);
    }
}
