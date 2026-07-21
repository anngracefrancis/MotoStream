package io.sentry.util.thread;

import io.sentry.protocol.w;

/* JADX INFO: compiled from: IMainThreadChecker.java */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a {
    public static boolean a(b _this) {
        return _this.c(Thread.currentThread());
    }

    public static boolean b(b _this, w wVar) {
        Long l = wVar.l();
        return l != null && _this.a(l.longValue());
    }

    public static boolean c(b _this, Thread thread) {
        return _this.a(thread.getId());
    }
}
