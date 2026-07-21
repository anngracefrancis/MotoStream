package cm.aptoide.pt.themes;

import cm.aptoide.pt.feature.NewFeatureDialogPresenter;
import f.a;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class NewFeatureDialogFragment_MembersInjector implements a<NewFeatureDialogFragment> {
    private final Provider<NewFeatureDialogPresenter> presenterProvider;

    public NewFeatureDialogFragment_MembersInjector(Provider<NewFeatureDialogPresenter> provider) {
        this.presenterProvider = provider;
    }

    public static a<NewFeatureDialogFragment> create(Provider<NewFeatureDialogPresenter> provider) {
        return new NewFeatureDialogFragment_MembersInjector(provider);
    }

    public static void injectPresenter(NewFeatureDialogFragment newFeatureDialogFragment, NewFeatureDialogPresenter newFeatureDialogPresenter) {
        newFeatureDialogFragment.presenter = newFeatureDialogPresenter;
    }

    public void injectMembers(NewFeatureDialogFragment newFeatureDialogFragment) {
        injectPresenter(newFeatureDialogFragment, this.presenterProvider.get());
    }
}
