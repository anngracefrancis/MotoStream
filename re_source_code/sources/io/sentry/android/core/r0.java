package io.sentry.android.core;

import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: AppState.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class r0 {
    private static r0 a = new r0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Boolean f22256b = null;

    private r0() {
    }

    public static r0 a() {
        return a;
    }

    public Boolean b() {
        return this.f22256b;
    }

    synchronized void c(boolean z) {
        this.f22256b = Boolean.valueOf(z);
    }
}
