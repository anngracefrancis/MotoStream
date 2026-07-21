package cm.aptoide.pt.home;

import cm.aptoide.pt.reactions.network.ReactionsResponse;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ha implements rx.m.e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ ha f6081f = new ha();

    private /* synthetic */ ha() {
    }

    @Override // rx.m.e
    public final Object call(Object obj) {
        return Boolean.valueOf(((ReactionsResponse) obj).wasSuccess());
    }
}
