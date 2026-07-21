package cm.aptoide.pt;

import javax.inject.Provider;
import okhttp3.Interceptor;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvideRetrofitLogInterceptorFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvideRetrofitLogInterceptorFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvideRetrofitLogInterceptorFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvideRetrofitLogInterceptorFactory(applicationModule);
    }

    public static Interceptor provideRetrofitLogInterceptor(ApplicationModule applicationModule) {
        return (Interceptor) f.b.b.c(applicationModule.provideRetrofitLogInterceptor());
    }

    @Override // javax.inject.Provider
    public Interceptor get() {
        return provideRetrofitLogInterceptor(this.module);
    }
}
