package cm.aptoide.pt.view;

import cm.aptoide.pt.account.view.ImageInfoProvider;
import cm.aptoide.pt.account.view.ImageValidator;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class FragmentModule_ProvideImageValidatorFactory implements Provider {
    private final Provider<ImageInfoProvider> imageInfoProvider;
    private final FragmentModule module;

    public FragmentModule_ProvideImageValidatorFactory(FragmentModule fragmentModule, Provider<ImageInfoProvider> provider) {
        this.module = fragmentModule;
        this.imageInfoProvider = provider;
    }

    public static FragmentModule_ProvideImageValidatorFactory create(FragmentModule fragmentModule, Provider<ImageInfoProvider> provider) {
        return new FragmentModule_ProvideImageValidatorFactory(fragmentModule, provider);
    }

    public static ImageValidator provideImageValidator(FragmentModule fragmentModule, ImageInfoProvider imageInfoProvider) {
        return (ImageValidator) f.b.b.c(fragmentModule.provideImageValidator(imageInfoProvider));
    }

    @Override // javax.inject.Provider
    public ImageValidator get() {
        return provideImageValidator(this.module, this.imageInfoProvider.get());
    }
}
