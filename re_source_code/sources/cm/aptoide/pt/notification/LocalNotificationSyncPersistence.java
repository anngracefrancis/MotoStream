package cm.aptoide.pt.notification;

import cm.aptoide.pt.notification.sync.LocalNotificationSync;
import cm.aptoide.pt.sync.Sync;

/* JADX INFO: loaded from: classes.dex */
public interface LocalNotificationSyncPersistence {
    rx.e<Sync> get(String str);

    void remove(String str);

    void save(LocalNotificationSync localNotificationSync);
}
