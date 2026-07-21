package cm.aptoide.pt;

import com.fasterxml.jackson.databind.ObjectMapper;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvideNonNullObjectMapperFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvideNonNullObjectMapperFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvideNonNullObjectMapperFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvideNonNullObjectMapperFactory(applicationModule);
    }

    public static ObjectMapper provideNonNullObjectMapper(ApplicationModule applicationModule) {
        return (ObjectMapper) f.b.b.c(applicationModule.provideNonNullObjectMapper());
    }

    @Override // javax.inject.Provider
    public ObjectMapper get() {
        return provideNonNullObjectMapper(this.module);
    }
}
