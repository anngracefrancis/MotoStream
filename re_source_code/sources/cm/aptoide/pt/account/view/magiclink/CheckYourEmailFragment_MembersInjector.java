package cm.aptoide.pt.account.view.magiclink;

import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class CheckYourEmailFragment_MembersInjector implements f.a<CheckYourEmailFragment> {
    private final Provider<CheckYourEmailPresenter> presenterProvider;

    public CheckYourEmailFragment_MembersInjector(Provider<CheckYourEmailPresenter> provider) {
        this.presenterProvider = provider;
    }

    public static f.a<CheckYourEmailFragment> create(Provider<CheckYourEmailPresenter> provider) {
        return new CheckYourEmailFragment_MembersInjector(provider);
    }

    public static void injectPresenter(CheckYourEmailFragment checkYourEmailFragment, CheckYourEmailPresenter checkYourEmailPresenter) {
        checkYourEmailFragment.presenter = checkYourEmailPresenter;
    }

    public void injectMembers(CheckYourEmailFragment checkYourEmailFragment) {
        injectPresenter(checkYourEmailFragment, this.presenterProvider.get());
    }
}
