package cm.aptoide.pt;

import cm.aptoide.pt.app.ReviewsManager;
import cm.aptoide.pt.app.ReviewsRepository;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesReviewsManagerFactory implements Provider {
    private final ApplicationModule module;
    private final Provider<ReviewsRepository> reviewsRepositoryProvider;

    public ApplicationModule_ProvidesReviewsManagerFactory(ApplicationModule applicationModule, Provider<ReviewsRepository> provider) {
        this.module = applicationModule;
        this.reviewsRepositoryProvider = provider;
    }

    public static ApplicationModule_ProvidesReviewsManagerFactory create(ApplicationModule applicationModule, Provider<ReviewsRepository> provider) {
        return new ApplicationModule_ProvidesReviewsManagerFactory(applicationModule, provider);
    }

    public static ReviewsManager providesReviewsManager(ApplicationModule applicationModule, ReviewsRepository reviewsRepository) {
        return (ReviewsManager) f.b.b.c(applicationModule.providesReviewsManager(reviewsRepository));
    }

    @Override // javax.inject.Provider
    public ReviewsManager get() {
        return providesReviewsManager(this.module, this.reviewsRepositoryProvider.get());
    }
}
