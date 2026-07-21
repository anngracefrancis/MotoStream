package cm.aptoide.pt;

import cm.aptoide.pt.themes.ThemeManager;
import cm.aptoide.pt.view.FragmentScope;
import cm.aptoide.pt.view.wizard.WizardFragmentProvider;

/* JADX INFO: loaded from: classes.dex */
public class FlavourFragmentModule {
    @FragmentScope
    WizardFragmentProvider providesWizardFragmentProvider(ThemeManager themeManager) {
        return new WizardFragmentProvider(themeManager);
    }
}
