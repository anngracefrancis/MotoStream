package cm.aptoide.pt;

import cm.aptoide.pt.themes.ThemeManager;
import cm.aptoide.pt.view.wizard.WizardFragmentProvider;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class FlavourFragmentModule_ProvidesWizardFragmentProviderFactory implements Provider {
    private final FlavourFragmentModule module;
    private final Provider<ThemeManager> themeManagerProvider;

    public FlavourFragmentModule_ProvidesWizardFragmentProviderFactory(FlavourFragmentModule flavourFragmentModule, Provider<ThemeManager> provider) {
        this.module = flavourFragmentModule;
        this.themeManagerProvider = provider;
    }

    public static FlavourFragmentModule_ProvidesWizardFragmentProviderFactory create(FlavourFragmentModule flavourFragmentModule, Provider<ThemeManager> provider) {
        return new FlavourFragmentModule_ProvidesWizardFragmentProviderFactory(flavourFragmentModule, provider);
    }

    public static WizardFragmentProvider providesWizardFragmentProvider(FlavourFragmentModule flavourFragmentModule, ThemeManager themeManager) {
        return (WizardFragmentProvider) f.b.b.c(flavourFragmentModule.providesWizardFragmentProvider(themeManager));
    }

    @Override // javax.inject.Provider
    public WizardFragmentProvider get() {
        return providesWizardFragmentProvider(this.module, this.themeManagerProvider.get());
    }
}
