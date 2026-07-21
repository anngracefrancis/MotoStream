package io.sentry.util;

import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: Pair.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class r<A, B> {
    private final A a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final B f22763b;

    public r(A a, B b2) {
        this.a = a;
        this.f22763b = b2;
    }

    public A a() {
        return this.a;
    }

    public B b() {
        return this.f22763b;
    }
}
