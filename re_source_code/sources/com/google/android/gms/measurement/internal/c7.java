package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class c7 {
    private final Clock a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f17728b;

    public c7(Clock clock) {
        Preconditions.k(clock);
        this.a = clock;
    }

    public final void a() {
        this.f17728b = this.a.b();
    }

    public final boolean b(long j2) {
        return this.f17728b == 0 || this.a.b() - this.f17728b >= 3600000;
    }

    public final void c() {
        this.f17728b = 0L;
    }
}
