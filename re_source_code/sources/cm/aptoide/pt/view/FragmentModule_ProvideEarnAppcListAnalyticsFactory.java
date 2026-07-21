package cm.aptoide.pt.view;

import cm.aptoide.pt.download.DownloadAnalytics;
import cm.aptoide.pt.home.more.appcoins.EarnAppcListAnalytics;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class FragmentModule_ProvideEarnAppcListAnalyticsFactory implements Provider {
    private final Provider<DownloadAnalytics> downloadAnalyticsProvider;
    private final FragmentModule module;

    public FragmentModule_ProvideEarnAppcListAnalyticsFactory(FragmentModule fragmentModule, Provider<DownloadAnalytics> provider) {
        this.module = fragmentModule;
        this.downloadAnalyticsProvider = provider;
    }

    public static FragmentModule_ProvideEarnAppcListAnalyticsFactory create(FragmentModule fragmentModule, Provider<DownloadAnalytics> provider) {
        return new FragmentModule_ProvideEarnAppcListAnalyticsFactory(fragmentModule, provider);
    }

    public static EarnAppcListAnalytics provideEarnAppcListAnalytics(FragmentModule fragmentModule, DownloadAnalytics downloadAnalytics) {
        return (EarnAppcListAnalytics) f.b.b.c(fragmentModule.provideEarnAppcListAnalytics(downloadAnalytics));
    }

    @Override // javax.inject.Provider
    public EarnAppcListAnalytics get() {
        return provideEarnAppcListAnalytics(this.module, this.downloadAnalyticsProvider.get());
    }
}
