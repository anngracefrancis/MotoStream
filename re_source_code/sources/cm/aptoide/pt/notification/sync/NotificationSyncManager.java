package cm.aptoide.pt.notification.sync;

import cm.aptoide.pt.notification.NotificationSyncScheduler;
import cm.aptoide.pt.sync.SyncScheduler;

/* JADX INFO: loaded from: classes.dex */
public class NotificationSyncManager implements NotificationSyncScheduler {
    private boolean enabled;
    private final NotificationSyncFactory notificationSyncFactory;
    private final SyncScheduler syncScheduler;

    public NotificationSyncManager(SyncScheduler syncScheduler, boolean z, NotificationSyncFactory notificationSyncFactory) {
        this.syncScheduler = syncScheduler;
        this.enabled = z;
        this.notificationSyncFactory = notificationSyncFactory;
    }

    @Override // cm.aptoide.pt.notification.NotificationSyncScheduler
    public void forceSync() {
        if (this.enabled) {
            this.syncScheduler.schedule(this.notificationSyncFactory.create(NotificationSyncFactory.CAMPAIGN_NOTIFICATION_SYNC_IMMEDIATE));
        }
    }

    @Override // cm.aptoide.pt.notification.NotificationSyncScheduler
    public void removeSchedules() {
        this.syncScheduler.cancel(NotificationSyncFactory.CAMPAIGN_NOTIFICATION_SYNC_PERIODIC);
    }

    @Override // cm.aptoide.pt.notification.NotificationSyncScheduler
    public void schedule() {
        if (this.enabled) {
            this.syncScheduler.schedule(this.notificationSyncFactory.create(NotificationSyncFactory.CAMPAIGN_NOTIFICATION_SYNC_PERIODIC));
        }
    }

    @Override // cm.aptoide.pt.notification.NotificationSyncScheduler
    public void setEnabled(boolean z) {
        this.enabled = z;
    }
}
