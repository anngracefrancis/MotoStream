package cm.aptoide.pt.notification.sync;

import cm.aptoide.pt.notification.NotificationProvider;
import cm.aptoide.pt.notification.NotificationService;
import cm.aptoide.pt.sync.Sync;

/* JADX INFO: loaded from: classes.dex */
public class NotificationSyncFactory {
    public static final String CAMPAIGN_NOTIFICATION_SYNC_IMMEDIATE = "CAMPAIGN_IMMEDIATE";
    public static final String CAMPAIGN_NOTIFICATION_SYNC_PERIODIC = "CAMPAIGN";
    private final NotificationProvider notificationPersistence;
    private final NotificationService notificationService;

    public NotificationSyncFactory(NotificationService notificationService, NotificationProvider notificationProvider) {
        this.notificationService = notificationService;
        this.notificationPersistence = notificationProvider;
    }

    public Sync create(String str) {
        str.hashCode();
        if (str.equals(CAMPAIGN_NOTIFICATION_SYNC_PERIODIC)) {
            return new CampaignNotificationSync(str, this.notificationService, this.notificationPersistence, true, false, 43200000L, 0L);
        }
        if (str.equals(CAMPAIGN_NOTIFICATION_SYNC_IMMEDIATE)) {
            return new CampaignNotificationSync(str, this.notificationService, this.notificationPersistence, false, false, 0L, 0L);
        }
        throw new IllegalArgumentException("Invalid sync " + str);
    }
}
