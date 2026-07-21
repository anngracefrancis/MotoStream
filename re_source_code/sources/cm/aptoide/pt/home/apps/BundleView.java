package cm.aptoide.pt.home.apps;

import cm.aptoide.pt.home.bundles.ads.AdHomeEvent;
import cm.aptoide.pt.home.bundles.base.AppHomeEvent;
import cm.aptoide.pt.home.bundles.base.HomeBundle;
import cm.aptoide.pt.home.bundles.base.HomeEvent;
import cm.aptoide.pt.presenter.View;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface BundleView extends View {
    rx.e<AdHomeEvent> adClicked();

    rx.e<AppHomeEvent> appClicked();

    rx.e<HomeEvent> bundleScrolled();

    void hideLoading();

    void hideRefresh();

    void hideShowMore();

    rx.e<HomeEvent> moreClicked();

    rx.e<Object> reachesBottom();

    rx.e<Void> refreshes();

    rx.e<Void> retryClicked();

    void showBundles(List<HomeBundle> list);

    void showGenericError();

    void showLoadMore();

    void showLoading();

    void showMoreHomeBundles(List<HomeBundle> list);

    void showNetworkError();

    void updateEditorialCards();

    rx.e<HomeEvent> visibleBundles();
}
