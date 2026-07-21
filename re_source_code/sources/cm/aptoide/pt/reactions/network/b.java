package cm.aptoide.pt.reactions.network;

import rx.m.e;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ ReactionsRemoteService f7243f;

    public /* synthetic */ b(ReactionsRemoteService reactionsRemoteService) {
        this.f7243f = reactionsRemoteService;
    }

    @Override // rx.m.e
    public final Object call(Object obj) {
        return this.f7243f.mapErrorResponse((Throwable) obj);
    }
}
