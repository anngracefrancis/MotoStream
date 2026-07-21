package com.google.android.gms.common.internal;

import android.util.Log;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzc {
    private Object a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f12056b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ BaseGmsClient f12057c;

    public zzc(BaseGmsClient baseGmsClient, Object obj) {
        this.f12057c = baseGmsClient;
        this.a = obj;
    }

    protected abstract void a(Object obj);

    protected abstract void b();

    public final void c() {
        Object obj;
        synchronized (this) {
            obj = this.a;
            if (this.f12056b) {
                Log.w("GmsClient", "Callback proxy " + toString() + " being reused. This is not safe.");
            }
        }
        if (obj != null) {
            try {
                a(obj);
            } catch (RuntimeException e2) {
                throw e2;
            }
        }
        synchronized (this) {
            this.f12056b = true;
        }
        e();
    }

    public final void d() {
        synchronized (this) {
            this.a = null;
        }
    }

    public final void e() {
        d();
        synchronized (this.f12057c.zzt) {
            this.f12057c.zzt.remove(this);
        }
    }
}
