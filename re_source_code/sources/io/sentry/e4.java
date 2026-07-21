package io.sentry;

import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: SentryCrashLastRunState.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class e4 {
    private static final e4 a = new e4();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f22388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Boolean f22389c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f22390d = new Object();

    private e4() {
    }

    public static e4 a() {
        return a;
    }

    public void b(boolean z) {
        synchronized (this.f22390d) {
            if (!this.f22388b) {
                this.f22389c = Boolean.valueOf(z);
                this.f22388b = true;
            }
        }
    }
}
