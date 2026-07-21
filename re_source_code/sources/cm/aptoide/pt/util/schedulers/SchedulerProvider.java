package cm.aptoide.pt.util.schedulers;

import rx.h;

/* JADX INFO: loaded from: classes.dex */
public interface SchedulerProvider {
    h computation();

    h io();

    h ui();
}
