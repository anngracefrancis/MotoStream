package cm.aptoide.pt;

import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class AptoideFirebaseNotificationService_MembersInjector implements f.a<AptoideFirebaseNotificationService> {
    private final Provider<FirebaseNotificationAnalytics> firebaseNotificationAnalyticsProvider;

    public AptoideFirebaseNotificationService_MembersInjector(Provider<FirebaseNotificationAnalytics> provider) {
        this.firebaseNotificationAnalyticsProvider = provider;
    }

    public static f.a<AptoideFirebaseNotificationService> create(Provider<FirebaseNotificationAnalytics> provider) {
        return new AptoideFirebaseNotificationService_MembersInjector(provider);
    }

    public static void injectFirebaseNotificationAnalytics(AptoideFirebaseNotificationService aptoideFirebaseNotificationService, FirebaseNotificationAnalytics firebaseNotificationAnalytics) {
        aptoideFirebaseNotificationService.firebaseNotificationAnalytics = firebaseNotificationAnalytics;
    }

    public void injectMembers(AptoideFirebaseNotificationService aptoideFirebaseNotificationService) {
        injectFirebaseNotificationAnalytics(aptoideFirebaseNotificationService, this.firebaseNotificationAnalyticsProvider.get());
    }
}
