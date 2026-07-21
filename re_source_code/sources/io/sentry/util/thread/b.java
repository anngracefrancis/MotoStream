package io.sentry.util.thread;

import io.sentry.protocol.w;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: IMainThreadChecker.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public interface b {
    boolean a(long j2);

    boolean b(w wVar);

    boolean c(Thread thread);

    boolean d();
}
