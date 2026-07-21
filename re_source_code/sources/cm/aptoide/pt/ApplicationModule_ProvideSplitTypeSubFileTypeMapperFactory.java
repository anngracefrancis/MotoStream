package cm.aptoide.pt;

import cm.aptoide.pt.download.SplitTypeSubFileTypeMapper;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvideSplitTypeSubFileTypeMapperFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvideSplitTypeSubFileTypeMapperFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvideSplitTypeSubFileTypeMapperFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvideSplitTypeSubFileTypeMapperFactory(applicationModule);
    }

    public static SplitTypeSubFileTypeMapper provideSplitTypeSubFileTypeMapper(ApplicationModule applicationModule) {
        return (SplitTypeSubFileTypeMapper) f.b.b.c(applicationModule.provideSplitTypeSubFileTypeMapper());
    }

    @Override // javax.inject.Provider
    public SplitTypeSubFileTypeMapper get() {
        return provideSplitTypeSubFileTypeMapper(this.module);
    }
}
