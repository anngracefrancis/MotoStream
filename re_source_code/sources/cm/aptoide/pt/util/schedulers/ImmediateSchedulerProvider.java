package cm.aptoide.pt.util.schedulers;

import rx.h;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public class ImmediateSchedulerProvider implements SchedulerProvider {
    @Override // cm.aptoide.pt.util.schedulers.SchedulerProvider
    public h computation() {
        return Schedulers.immediate();
    }

    @Override // cm.aptoide.pt.util.schedulers.SchedulerProvider
    public h io() {
        return Schedulers.immediate();
    }

    @Override // cm.aptoide.pt.util.schedulers.SchedulerProvider
    public h ui() {
        return Schedulers.immediate();
    }
}
