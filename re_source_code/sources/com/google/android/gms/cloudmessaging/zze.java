package com.google.android.gms.cloudmessaging;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.internal.cloudmessaging.zzf;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zze {
    private static zze a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f11610b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ScheduledExecutorService f11611c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private c f11612d = new c(this);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f11613e = 1;

    private zze(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.f11611c = scheduledExecutorService;
        this.f11610b = context.getApplicationContext();
    }

    private final synchronized int a() {
        int i2;
        i2 = this.f11613e;
        this.f11613e = i2 + 1;
        return i2;
    }

    public static synchronized zze c(Context context) {
        if (a == null) {
            a = new zze(context, com.google.android.gms.internal.cloudmessaging.zza.a().a(1, new NamedThreadFactory("MessengerIpcClient"), zzf.f17059b));
        }
        return a;
    }

    private final synchronized <T> Task<T> e(m<T> mVar) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String strValueOf = String.valueOf(mVar);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 9);
            sb.append("Queueing ");
            sb.append(strValueOf);
            Log.d("MessengerIpcClient", sb.toString());
        }
        if (!this.f11612d.e(mVar)) {
            c cVar = new c(this);
            this.f11612d = cVar;
            cVar.e(mVar);
        }
        return mVar.f11600b.a();
    }

    public final Task<Void> d(int i2, Bundle bundle) {
        return e(new k(a(), 2, bundle));
    }

    public final Task<Bundle> f(int i2, Bundle bundle) {
        return e(new n(a(), 1, bundle));
    }
}
