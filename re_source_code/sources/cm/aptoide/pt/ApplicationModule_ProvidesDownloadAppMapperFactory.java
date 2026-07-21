package cm.aptoide.pt;

import cm.aptoide.pt.downloadmanager.DownloadAppFileMapper;
import cm.aptoide.pt.downloadmanager.DownloadAppMapper;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesDownloadAppMapperFactory implements Provider {
    private final Provider<DownloadAppFileMapper> downloadAppFileMapperProvider;
    private final ApplicationModule module;

    public ApplicationModule_ProvidesDownloadAppMapperFactory(ApplicationModule applicationModule, Provider<DownloadAppFileMapper> provider) {
        this.module = applicationModule;
        this.downloadAppFileMapperProvider = provider;
    }

    public static ApplicationModule_ProvidesDownloadAppMapperFactory create(ApplicationModule applicationModule, Provider<DownloadAppFileMapper> provider) {
        return new ApplicationModule_ProvidesDownloadAppMapperFactory(applicationModule, provider);
    }

    public static DownloadAppMapper providesDownloadAppMapper(ApplicationModule applicationModule, DownloadAppFileMapper downloadAppFileMapper) {
        return (DownloadAppMapper) f.b.b.c(applicationModule.providesDownloadAppMapper(downloadAppFileMapper));
    }

    @Override // javax.inject.Provider
    public DownloadAppMapper get() {
        return providesDownloadAppMapper(this.module, this.downloadAppFileMapperProvider.get());
    }
}
