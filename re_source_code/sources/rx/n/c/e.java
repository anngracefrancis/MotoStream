package rx.n.c;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: GenericScheduledExecutorServiceFactory.java */
/* JADX INFO: loaded from: classes3.dex */
enum e {
    ;


    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final rx.n.e.i f26667f = new rx.n.e.i("RxScheduledExecutorPool-");

    public static ScheduledExecutorService g() {
        rx.m.d<? extends ScheduledExecutorService> dVarA = rx.q.c.a();
        return dVarA == null ? k() : dVarA.call();
    }

    static ScheduledExecutorService k() {
        return Executors.newScheduledThreadPool(1, q());
    }

    static ThreadFactory q() {
        return f26667f;
    }
}
