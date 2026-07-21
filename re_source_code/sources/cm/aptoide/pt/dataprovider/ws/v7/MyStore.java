package cm.aptoide.pt.dataprovider.ws.v7;

import cm.aptoide.pt.dataprovider.model.v7.TimelineStats;
import cm.aptoide.pt.dataprovider.model.v7.store.GetHomeMeta;

/* JADX INFO: loaded from: classes.dex */
public class MyStore {
    private final GetHomeMeta getHomeMeta;
    private final TimelineStats timelineStats;

    public MyStore(TimelineStats timelineStats, GetHomeMeta getHomeMeta) {
        this.timelineStats = timelineStats;
        this.getHomeMeta = getHomeMeta;
    }

    public GetHomeMeta getGetHomeMeta() {
        return this.getHomeMeta;
    }

    public TimelineStats getTimelineStats() {
        return this.timelineStats;
    }

    public boolean isCreateStore() {
        return this.getHomeMeta == null;
    }
}
