package cm.aptoide.pt.sync.alarm;

import cm.aptoide.pt.notification.LocalNotificationSyncPersistence;
import cm.aptoide.pt.notification.sync.LocalNotificationSync;
import cm.aptoide.pt.sync.Sync;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public class SyncStorage {
    private final LocalNotificationSyncPersistence persistence;
    private final Map<String, Sync> syncs;

    public SyncStorage(Map<String, Sync> map, LocalNotificationSyncPersistence localNotificationSyncPersistence) {
        this.syncs = map;
        this.persistence = localNotificationSyncPersistence;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$remove$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a(String str) {
        if (str.equals(LocalNotificationSync.APPC_CAMPAIGN_NOTIFICATION)) {
            this.persistence.remove(str);
        }
        this.syncs.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$save$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(Sync sync) {
        if (sync instanceof LocalNotificationSync) {
            this.persistence.save((LocalNotificationSync) sync);
        }
        this.syncs.put(sync.getId(), sync);
    }

    public Sync get(String str) {
        return (str.equals(LocalNotificationSync.APPC_CAMPAIGN_NOTIFICATION) || str.equals(LocalNotificationSync.NEW_FEATURE)) ? this.persistence.get(str).W0().b() : this.syncs.get(str);
    }

    public List<Sync> getAll() {
        return new ArrayList(this.syncs.values());
    }

    public void remove(final String str) {
        rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.sync.alarm.b
            @Override // rx.m.a
            public final void call() {
                this.f7777f.a(str);
            }
        }).K(Schedulers.io()).H();
    }

    public void save(final Sync sync) {
        rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.sync.alarm.a
            @Override // rx.m.a
            public final void call() {
                this.f7775f.b(sync);
            }
        }).K(Schedulers.io()).H();
    }
}
