package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: loaded from: classes2.dex */
@zzard
final class u4 {
    private long a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f13385b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzawj f13386c;

    public u4(zzawj zzawjVar) {
        this.f13386c = zzawjVar;
    }

    public final Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putLong("topen", this.a);
        bundle.putLong("tclose", this.f13385b);
        return bundle;
    }

    public final long b() {
        return this.f13385b;
    }

    public final void c() {
        this.f13385b = this.f13386c.a.b();
    }

    public final void d() {
        this.a = this.f13386c.a.b();
    }
}
