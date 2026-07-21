package cm.aptoide.pt.notification.sync;

import cm.aptoide.pt.notification.AptoideNotification;
import cm.aptoide.pt.notification.NotificationProvider;
import cm.aptoide.pt.notification.NotificationService;
import cm.aptoide.pt.sync.Sync;
import java.util.List;
import rx.b;
import rx.m.e;

/* JADX INFO: loaded from: classes.dex */
public class CampaignNotificationSync extends Sync {
    private final NotificationService networkService;
    private final NotificationProvider provider;

    public CampaignNotificationSync(String str, NotificationService notificationService, NotificationProvider notificationProvider, boolean z, boolean z2, long j2, long j3) {
        super(str, z, z2, j3, j2);
        this.networkService = notificationService;
        this.provider = notificationProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$execute$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ b a(List list) {
        return this.provider.save((List<AptoideNotification>) list);
    }

    @Override // cm.aptoide.pt.sync.Sync
    public b execute() {
        return this.networkService.getCampaignNotifications().j(new e() { // from class: cm.aptoide.pt.notification.sync.a
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6784f.a((List) obj);
            }
        });
    }
}
