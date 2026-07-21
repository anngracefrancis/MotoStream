package cm.aptoide.pt.home.bundles;

import rx.Single;

/* JADX INFO: loaded from: classes.dex */
public interface BundleDataSource {
    boolean hasMore(Integer num, String str);

    Single<HomeBundlesModel> loadFreshBundleForEvent(String str, String str2);

    rx.e<HomeBundlesModel> loadFreshHomeBundles(String str);

    Single<HomeBundlesModel> loadNextBundleForEvent(String str, int i2, String str2, int i3);

    rx.e<HomeBundlesModel> loadNextHomeBundles(int i2, int i3, String str, boolean z);
}
