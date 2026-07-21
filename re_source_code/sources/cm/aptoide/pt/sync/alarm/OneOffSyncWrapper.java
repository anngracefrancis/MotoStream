package cm.aptoide.pt.sync.alarm;

import cm.aptoide.pt.sync.Sync;

/* JADX INFO: loaded from: classes.dex */
public class OneOffSyncWrapper extends Sync {
    private final Sync sync;

    public OneOffSyncWrapper(Sync sync, long j2) {
        super(sync.getId(), sync.isPeriodic(), sync.isExact(), j2, 0L);
        this.sync = sync;
    }

    @Override // cm.aptoide.pt.sync.Sync
    public rx.b execute() {
        return this.sync.execute();
    }
}
