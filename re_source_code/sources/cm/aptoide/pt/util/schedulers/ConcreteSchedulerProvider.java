package cm.aptoide.pt.util.schedulers;

import rx.h;
import rx.l.c.a;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public class ConcreteSchedulerProvider implements SchedulerProvider {
    private static ConcreteSchedulerProvider INSTANCE;

    private ConcreteSchedulerProvider() {
    }

    public static synchronized ConcreteSchedulerProvider getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ConcreteSchedulerProvider();
        }
        return INSTANCE;
    }

    @Override // cm.aptoide.pt.util.schedulers.SchedulerProvider
    public h computation() {
        return Schedulers.computation();
    }

    @Override // cm.aptoide.pt.util.schedulers.SchedulerProvider
    public h io() {
        return Schedulers.io();
    }

    @Override // cm.aptoide.pt.util.schedulers.SchedulerProvider
    public h ui() {
        return a.b();
    }
}
