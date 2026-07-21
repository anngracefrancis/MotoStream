package cm.aptoide.pt;

import cm.aptoide.pt.download.DownloadSpeedIntervalMapper;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvideDownloadSpeedIntervalMapperFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvideDownloadSpeedIntervalMapperFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvideDownloadSpeedIntervalMapperFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvideDownloadSpeedIntervalMapperFactory(applicationModule);
    }

    public static DownloadSpeedIntervalMapper provideDownloadSpeedIntervalMapper(ApplicationModule applicationModule) {
        return (DownloadSpeedIntervalMapper) f.b.b.c(applicationModule.provideDownloadSpeedIntervalMapper());
    }

    @Override // javax.inject.Provider
    public DownloadSpeedIntervalMapper get() {
        return provideDownloadSpeedIntervalMapper(this.module);
    }
}
