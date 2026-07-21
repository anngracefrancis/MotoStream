package cm.aptoide.pt;

import cm.aptoide.pt.downloadmanager.DownloadAppFileMapper;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesDownloadAppFileMapperFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvidesDownloadAppFileMapperFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvidesDownloadAppFileMapperFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvidesDownloadAppFileMapperFactory(applicationModule);
    }

    public static DownloadAppFileMapper providesDownloadAppFileMapper(ApplicationModule applicationModule) {
        return (DownloadAppFileMapper) f.b.b.c(applicationModule.providesDownloadAppFileMapper());
    }

    @Override // javax.inject.Provider
    public DownloadAppFileMapper get() {
        return providesDownloadAppFileMapper(this.module);
    }
}
