package cm.aptoide.pt.notification;

/* JADX INFO: loaded from: classes.dex */
public interface NotificationSyncScheduler {
    void forceSync();

    void removeSchedules();

    void schedule();

    void setEnabled(boolean z);
}
