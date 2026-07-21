package cm.aptoide.pt.sync;

import rx.b;

/* JADX INFO: loaded from: classes.dex */
public abstract class Sync {
    private final boolean exact;
    private final String id;
    private final long interval;
    private final boolean periodic;
    private final long trigger;

    public Sync(String str, boolean z, boolean z2, long j2, long j3) {
        this.id = str;
        this.periodic = z;
        this.exact = z2;
        this.trigger = j2;
        this.interval = j3;
    }

    public abstract b execute();

    public String getId() {
        return this.id;
    }

    public long getInterval() {
        return this.interval;
    }

    public long getTrigger() {
        return this.trigger;
    }

    public boolean isExact() {
        return this.exact;
    }

    public boolean isPeriodic() {
        return this.periodic;
    }
}
