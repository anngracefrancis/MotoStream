package io.sentry;

import java.time.Instant;

/* JADX INFO: compiled from: SentryInstantDate.java */
/* JADX INFO: loaded from: classes2.dex */
public final class o4 extends f4 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Instant f22527f;

    public o4() {
        this(Instant.now());
    }

    @Override // io.sentry.f4
    public long x() {
        return a1.m(this.f22527f.getEpochSecond()) + ((long) this.f22527f.getNano());
    }

    public o4(Instant instant) {
        this.f22527f = instant;
    }
}
