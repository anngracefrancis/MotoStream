package cm.aptoide.pt.view;

import cm.aptoide.pt.aab.DynamicSplitsManager;
import cm.aptoide.pt.ads.MoPubAdsManager;
import cm.aptoide.pt.app.DownloadStateParser;
import cm.aptoide.pt.app.mmpcampaigns.CampaignManager;
import cm.aptoide.pt.download.DownloadFactory;
import cm.aptoide.pt.download.SplitAnalyticsMapper;
import cm.aptoide.pt.editorial.EditorialAnalytics;
import cm.aptoide.pt.editorial.EditorialManager;
import cm.aptoide.pt.editorial.EditorialRepository;
import cm.aptoide.pt.install.InstallAnalytics;
import cm.aptoide.pt.install.InstallManager;
import cm.aptoide.pt.notification.NotificationAnalytics;
import cm.aptoide.pt.reactions.ReactionsManager;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class FragmentModule_ProvidesEditorialManagerFactory implements Provider {
    private final Provider<CampaignManager> campaignManagerProvider;
    private final Provider<DownloadFactory> downloadFactoryProvider;
    private final Provider<DownloadStateParser> downloadStateParserProvider;
    private final Provider<DynamicSplitsManager> dynamicSplitsManagerProvider;
    private final Provider<EditorialAnalytics> editorialAnalyticsProvider;
    private final Provider<EditorialRepository> editorialRepositoryProvider;
    private final Provider<InstallAnalytics> installAnalyticsProvider;
    private final Provider<InstallManager> installManagerProvider;
    private final Provider<MoPubAdsManager> moPubAdsManagerProvider;
    private final FragmentModule module;
    private final Provider<NotificationAnalytics> notificationAnalyticsProvider;
    private final Provider<ReactionsManager> reactionsManagerProvider;
    private final Provider<SplitAnalyticsMapper> splitAnalyticsMapperProvider;

    public FragmentModule_ProvidesEditorialManagerFactory(FragmentModule fragmentModule, Provider<EditorialRepository> provider, Provider<InstallManager> provider2, Provider<DownloadFactory> provider3, Provider<DownloadStateParser> provider4, Provider<NotificationAnalytics> provider5, Provider<InstallAnalytics> provider6, Provider<EditorialAnalytics> provider7, Provider<ReactionsManager> provider8, Provider<MoPubAdsManager> provider9, Provider<DynamicSplitsManager> provider10, Provider<SplitAnalyticsMapper> provider11, Provider<CampaignManager> provider12) {
        this.module = fragmentModule;
        this.editorialRepositoryProvider = provider;
        this.installManagerProvider = provider2;
        this.downloadFactoryProvider = provider3;
        this.downloadStateParserProvider = provider4;
        this.notificationAnalyticsProvider = provider5;
        this.installAnalyticsProvider = provider6;
        this.editorialAnalyticsProvider = provider7;
        this.reactionsManagerProvider = provider8;
        this.moPubAdsManagerProvider = provider9;
        this.dynamicSplitsManagerProvider = provider10;
        this.splitAnalyticsMapperProvider = provider11;
        this.campaignManagerProvider = provider12;
    }

    public static FragmentModule_ProvidesEditorialManagerFactory create(FragmentModule fragmentModule, Provider<EditorialRepository> provider, Provider<InstallManager> provider2, Provider<DownloadFactory> provider3, Provider<DownloadStateParser> provider4, Provider<NotificationAnalytics> provider5, Provider<InstallAnalytics> provider6, Provider<EditorialAnalytics> provider7, Provider<ReactionsManager> provider8, Provider<MoPubAdsManager> provider9, Provider<DynamicSplitsManager> provider10, Provider<SplitAnalyticsMapper> provider11, Provider<CampaignManager> provider12) {
        return new FragmentModule_ProvidesEditorialManagerFactory(fragmentModule, provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12);
    }

    public static EditorialManager providesEditorialManager(FragmentModule fragmentModule, EditorialRepository editorialRepository, InstallManager installManager, DownloadFactory downloadFactory, DownloadStateParser downloadStateParser, NotificationAnalytics notificationAnalytics, InstallAnalytics installAnalytics, EditorialAnalytics editorialAnalytics, ReactionsManager reactionsManager, MoPubAdsManager moPubAdsManager, DynamicSplitsManager dynamicSplitsManager, SplitAnalyticsMapper splitAnalyticsMapper, CampaignManager campaignManager) {
        return (EditorialManager) f.b.b.c(fragmentModule.providesEditorialManager(editorialRepository, installManager, downloadFactory, downloadStateParser, notificationAnalytics, installAnalytics, editorialAnalytics, reactionsManager, moPubAdsManager, dynamicSplitsManager, splitAnalyticsMapper, campaignManager));
    }

    @Override // javax.inject.Provider
    public EditorialManager get() {
        return providesEditorialManager(this.module, this.editorialRepositoryProvider.get(), this.installManagerProvider.get(), this.downloadFactoryProvider.get(), this.downloadStateParserProvider.get(), this.notificationAnalyticsProvider.get(), this.installAnalyticsProvider.get(), this.editorialAnalyticsProvider.get(), this.reactionsManagerProvider.get(), this.moPubAdsManagerProvider.get(), this.dynamicSplitsManagerProvider.get(), this.splitAnalyticsMapperProvider.get(), this.campaignManagerProvider.get());
    }
}
