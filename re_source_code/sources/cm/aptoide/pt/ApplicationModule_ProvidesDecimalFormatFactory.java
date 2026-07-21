package cm.aptoide.pt;

import java.text.DecimalFormat;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesDecimalFormatFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvidesDecimalFormatFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvidesDecimalFormatFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvidesDecimalFormatFactory(applicationModule);
    }

    public static DecimalFormat providesDecimalFormat(ApplicationModule applicationModule) {
        return (DecimalFormat) f.b.b.c(applicationModule.providesDecimalFormat());
    }

    @Override // javax.inject.Provider
    public DecimalFormat get() {
        return providesDecimalFormat(this.module);
    }
}
