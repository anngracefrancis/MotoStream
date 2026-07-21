package cm.aptoide.pt.home.bundles;

import cm.aptoide.pt.home.bundles.base.HomeBundle;
import cm.aptoide.pt.home.bundles.misc.ErrorHomeBundle;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import rx.Single;

/* JADX INFO: loaded from: classes.dex */
public class BundlesRepository {
    private static final String HOME_BUNDLE_KEY = "Home_Bundle";
    private Map<String, List<HomeBundle>> cachedBundles;
    private int limit;
    private Map<String, Integer> offset;
    private final BundleDataSource remoteBundleDataSource;

    public BundlesRepository(BundleDataSource bundleDataSource, Map<String, List<HomeBundle>> map, Map<String, Integer> map2, int i2) {
        this.remoteBundleDataSource = bundleDataSource;
        this.cachedBundles = map;
        this.offset = map2;
        this.limit = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HomeBundlesModel cloneList(HomeBundlesModel homeBundlesModel) {
        return (homeBundlesModel.hasErrors() || homeBundlesModel.isLoading()) ? homeBundlesModel : new HomeBundlesModel(new ArrayList(homeBundlesModel.getList()), homeBundlesModel.isLoading(), homeBundlesModel.getOffset(), homeBundlesModel.isComplete());
    }

    private int getOffset(String str) {
        if (this.offset.containsKey(str)) {
            return this.offset.get(str).intValue();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadFreshBundles$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(String str, HomeBundlesModel homeBundlesModel) {
        updateCache(homeBundlesModel, true, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadFreshHomeBundles$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c(HomeBundlesModel homeBundlesModel) {
        updateCache(homeBundlesModel, true, HOME_BUNDLE_KEY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadNextBundles$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d(String str, HomeBundlesModel homeBundlesModel) {
        updateCache(homeBundlesModel, false, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadNextHomeBundles$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e(HomeBundlesModel homeBundlesModel) {
        updateCache(homeBundlesModel, false, HOME_BUNDLE_KEY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$remove$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b f(HomeBundle homeBundle) {
        this.cachedBundles.get(HOME_BUNDLE_KEY).remove(homeBundle);
        return rx.b.e();
    }

    private void updateCache(HomeBundlesModel homeBundlesModel, boolean z, String str) {
        if (homeBundlesModel.hasErrors() || homeBundlesModel.isLoading() || !homeBundlesModel.isComplete()) {
            return;
        }
        this.offset.put(str, Integer.valueOf(homeBundlesModel.getOffset()));
        if (z || !this.cachedBundles.containsKey(str)) {
            this.cachedBundles.put(str, new ArrayList(homeBundlesModel.getList()));
            return;
        }
        List<HomeBundle> list = this.cachedBundles.get(str);
        if (list.get(list.size() - 1) instanceof ErrorHomeBundle) {
            list.remove(list.size() - 1);
        }
        list.addAll(homeBundlesModel.getList());
        this.cachedBundles.put(str, list);
    }

    public boolean hasMore() {
        return this.remoteBundleDataSource.hasMore(Integer.valueOf(getOffset(HOME_BUNDLE_KEY)), HOME_BUNDLE_KEY);
    }

    public Single<HomeBundlesModel> loadBundles(String str, String str2) {
        return !this.cachedBundles.containsKey(str) ? loadNextBundles(str, str2) : Single.m(new HomeBundlesModel(this.cachedBundles.put(str, new ArrayList(this.cachedBundles.get(str))), false, getOffset(str), true));
    }

    public Single<HomeBundlesModel> loadFreshBundles(final String str, String str2) {
        return this.remoteBundleDataSource.loadFreshBundleForEvent(str2, str).g(new rx.m.b() { // from class: cm.aptoide.pt.home.bundles.f
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f5922f.b(str, (HomeBundlesModel) obj);
            }
        }).n(new d(this));
    }

    public rx.e<HomeBundlesModel> loadFreshHomeBundles() {
        return this.remoteBundleDataSource.loadFreshHomeBundles(HOME_BUNDLE_KEY).x(new rx.m.b() { // from class: cm.aptoide.pt.home.bundles.c
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f5888f.c((HomeBundlesModel) obj);
            }
        }).X(new d(this));
    }

    public rx.e<HomeBundlesModel> loadHomeBundles() {
        return !this.cachedBundles.containsKey(HOME_BUNDLE_KEY) ? loadNextHomeBundles(true) : rx.e.S(new HomeBundlesModel(this.cachedBundles.put(HOME_BUNDLE_KEY, new ArrayList(this.cachedBundles.get(HOME_BUNDLE_KEY))), false, getOffset(HOME_BUNDLE_KEY), true));
    }

    public Single<HomeBundlesModel> loadNextBundles(final String str, String str2) {
        return this.remoteBundleDataSource.loadNextBundleForEvent(str2, getOffset(str), str, this.limit).g(new rx.m.b() { // from class: cm.aptoide.pt.home.bundles.b
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f5886f.d(str, (HomeBundlesModel) obj);
            }
        }).n(new d(this));
    }

    public rx.e<HomeBundlesModel> loadNextHomeBundles(boolean z) {
        return this.remoteBundleDataSource.loadNextHomeBundles(getOffset(HOME_BUNDLE_KEY), this.limit, HOME_BUNDLE_KEY, z).x(new rx.m.b() { // from class: cm.aptoide.pt.home.bundles.a
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f5852f.e((HomeBundlesModel) obj);
            }
        }).X(new d(this));
    }

    public rx.b remove(final HomeBundle homeBundle) {
        return rx.b.i(new rx.m.d() { // from class: cm.aptoide.pt.home.bundles.e
            @Override // rx.m.d, java.util.concurrent.Callable
            public final Object call() {
                return this.f5890f.f(homeBundle);
            }
        });
    }

    public void setHomeLoadMoreError() {
        List<HomeBundle> list = this.cachedBundles.get(HOME_BUNDLE_KEY);
        if (list.isEmpty() || (list.get(list.size() - 1) instanceof ErrorHomeBundle)) {
            return;
        }
        list.add(new ErrorHomeBundle());
    }

    public boolean hasMore(String str) {
        return this.remoteBundleDataSource.hasMore(Integer.valueOf(getOffset(str)), str);
    }
}
