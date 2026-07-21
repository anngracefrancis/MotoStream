package cm.aptoide.pt;

import cm.aptoide.pt.download.DownloadAnalytics;
import cm.aptoide.pt.download.Md5Comparator;
import cm.aptoide.pt.downloadmanager.FileDownloaderProvider;
import cm.aptoide.pt.install.InstallAnalytics;
import cm.aptoide.pt.networking.AuthenticationPersistence;
import javax.inject.Provider;
import okhttp3.Interceptor;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesFileDownloaderProviderFactory implements Provider {
    private final Provider<AuthenticationPersistence> authenticationPersistenceProvider;
    private final Provider<String> cachePathProvider;
    private final Provider<DownloadAnalytics> downloadAnalyticsProvider;
    private final Provider<InstallAnalytics> installAnalyticsProvider;
    private final Provider<Md5Comparator> md5ComparatorProvider;
    private final ApplicationModule module;
    private final Provider<Interceptor> userAgentInterceptorProvider;

    public ApplicationModule_ProvidesFileDownloaderProviderFactory(ApplicationModule applicationModule, Provider<String> provider, Provider<Interceptor> provider2, Provider<AuthenticationPersistence> provider3, Provider<DownloadAnalytics> provider4, Provider<InstallAnalytics> provider5, Provider<Md5Comparator> provider6) {
        this.module = applicationModule;
        this.cachePathProvider = provider;
        this.userAgentInterceptorProvider = provider2;
        this.authenticationPersistenceProvider = provider3;
        this.downloadAnalyticsProvider = provider4;
        this.installAnalyticsProvider = provider5;
        this.md5ComparatorProvider = provider6;
    }

    public static ApplicationModule_ProvidesFileDownloaderProviderFactory create(ApplicationModule applicationModule, Provider<String> provider, Provider<Interceptor> provider2, Provider<AuthenticationPersistence> provider3, Provider<DownloadAnalytics> provider4, Provider<InstallAnalytics> provider5, Provider<Md5Comparator> provider6) {
        return new ApplicationModule_ProvidesFileDownloaderProviderFactory(applicationModule, provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static FileDownloaderProvider providesFileDownloaderProvider(ApplicationModule applicationModule, String str, Interceptor interceptor, AuthenticationPersistence authenticationPersistence, DownloadAnalytics downloadAnalytics, InstallAnalytics installAnalytics, Md5Comparator md5Comparator) {
        return (FileDownloaderProvider) f.b.b.c(applicationModule.providesFileDownloaderProvider(str, interceptor, authenticationPersistence, downloadAnalytics, installAnalytics, md5Comparator));
    }

    @Override // javax.inject.Provider
    public FileDownloaderProvider get() {
        return providesFileDownloaderProvider(this.module, this.cachePathProvider.get(), this.userAgentInterceptorProvider.get(), this.authenticationPersistenceProvider.get(), this.downloadAnalyticsProvider.get(), this.installAnalyticsProvider.get(), this.md5ComparatorProvider.get());
    }
}
