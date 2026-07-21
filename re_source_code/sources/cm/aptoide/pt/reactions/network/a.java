package cm.aptoide.pt.reactions.network;

import retrofit2.Response;
import rx.m.e;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ ReactionsRemoteService f7242f;

    public /* synthetic */ a(ReactionsRemoteService reactionsRemoteService) {
        this.f7242f = reactionsRemoteService;
    }

    @Override // rx.m.e
    public final Object call(Object obj) {
        return this.f7242f.mapResponse((Response) obj);
    }
}
