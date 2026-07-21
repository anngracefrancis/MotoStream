package cm.aptoide.pt.home.bundles;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements rx.m.e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ BundlesRepository f5889f;

    public /* synthetic */ d(BundlesRepository bundlesRepository) {
        this.f5889f = bundlesRepository;
    }

    @Override // rx.m.e
    public final Object call(Object obj) {
        return this.f5889f.cloneList((HomeBundlesModel) obj);
    }
}
