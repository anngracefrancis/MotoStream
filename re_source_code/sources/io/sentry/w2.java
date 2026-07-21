package io.sentry;

import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: MemoryCollectionData.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class w2 {
    final long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f22807b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f22808c;

    public w2(long j2, long j3, long j4) {
        this.a = j2;
        this.f22807b = j3;
        this.f22808c = j4;
    }

    public long a() {
        return this.a;
    }

    public long b() {
        return this.f22807b;
    }

    public long c() {
        return this.f22808c;
    }

    public w2(long j2, long j3) {
        this(j2, j3, -1L);
    }
}
