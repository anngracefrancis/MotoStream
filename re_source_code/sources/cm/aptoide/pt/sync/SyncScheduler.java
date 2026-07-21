package cm.aptoide.pt.sync;

/* JADX INFO: loaded from: classes.dex */
public interface SyncScheduler {
    void cancel(String str);

    void reschedule(Sync sync);

    void schedule(Sync sync);
}
