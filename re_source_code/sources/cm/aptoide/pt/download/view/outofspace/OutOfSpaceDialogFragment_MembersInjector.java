package cm.aptoide.pt.download.view.outofspace;

import cm.aptoide.pt.themes.ThemeManager;
import cm.aptoide.pt.view.fragment.BaseDialogFragment_MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class OutOfSpaceDialogFragment_MembersInjector implements f.a<OutOfSpaceDialogFragment> {
    private final Provider<OutOfSpaceDialogPresenter> presenterProvider;
    private final Provider<ThemeManager> themeManagerProvider;

    public OutOfSpaceDialogFragment_MembersInjector(Provider<ThemeManager> provider, Provider<OutOfSpaceDialogPresenter> provider2) {
        this.themeManagerProvider = provider;
        this.presenterProvider = provider2;
    }

    public static f.a<OutOfSpaceDialogFragment> create(Provider<ThemeManager> provider, Provider<OutOfSpaceDialogPresenter> provider2) {
        return new OutOfSpaceDialogFragment_MembersInjector(provider, provider2);
    }

    public static void injectPresenter(OutOfSpaceDialogFragment outOfSpaceDialogFragment, OutOfSpaceDialogPresenter outOfSpaceDialogPresenter) {
        outOfSpaceDialogFragment.presenter = outOfSpaceDialogPresenter;
    }

    public void injectMembers(OutOfSpaceDialogFragment outOfSpaceDialogFragment) {
        BaseDialogFragment_MembersInjector.injectThemeManager(outOfSpaceDialogFragment, this.themeManagerProvider.get());
        injectPresenter(outOfSpaceDialogFragment, this.presenterProvider.get());
    }
}
