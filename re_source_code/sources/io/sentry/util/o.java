package io.sentry.util;

import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: LazyEvaluator.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class o<T> {
    private T a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a<T> f22762b;

    /* JADX INFO: compiled from: LazyEvaluator.java */
    public interface a<T> {
        T a();
    }

    public o(a<T> aVar) {
        this.f22762b = aVar;
    }

    public synchronized T a() {
        if (this.a == null) {
            this.a = this.f22762b.a();
        }
        return this.a;
    }
}
