package cm.aptoide.pt;

import cm.aptoide.pt.app.ReviewsRepository;
import cm.aptoide.pt.app.ReviewsService;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesReviewsRepositoryFactory implements Provider {
    private final ApplicationModule module;
    private final Provider<ReviewsService> reviewsServiceProvider;

    public ApplicationModule_ProvidesReviewsRepositoryFactory(ApplicationModule applicationModule, Provider<ReviewsService> provider) {
        this.module = applicationModule;
        this.reviewsServiceProvider = provider;
    }

    public static ApplicationModule_ProvidesReviewsRepositoryFactory create(ApplicationModule applicationModule, Provider<ReviewsService> provider) {
        return new ApplicationModule_ProvidesReviewsRepositoryFactory(applicationModule, provider);
    }

    public static ReviewsRepository providesReviewsRepository(ApplicationModule applicationModule, ReviewsService reviewsService) {
        return (ReviewsRepository) f.b.b.c(applicationModule.providesReviewsRepository(reviewsService));
    }

    @Override // javax.inject.Provider
    public ReviewsRepository get() {
        return providesReviewsRepository(this.module, this.reviewsServiceProvider.get());
    }
}
