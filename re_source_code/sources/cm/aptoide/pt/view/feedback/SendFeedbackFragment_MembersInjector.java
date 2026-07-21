package cm.aptoide.pt.view.feedback;

import cm.aptoide.pt.install.AptoideInstalledAppsRepository;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class SendFeedbackFragment_MembersInjector implements f.a<SendFeedbackFragment> {
    private final Provider<AptoideInstalledAppsRepository> aptoideInstalledAppsRepositoryProvider;

    public SendFeedbackFragment_MembersInjector(Provider<AptoideInstalledAppsRepository> provider) {
        this.aptoideInstalledAppsRepositoryProvider = provider;
    }

    public static f.a<SendFeedbackFragment> create(Provider<AptoideInstalledAppsRepository> provider) {
        return new SendFeedbackFragment_MembersInjector(provider);
    }

    public static void injectAptoideInstalledAppsRepository(SendFeedbackFragment sendFeedbackFragment, AptoideInstalledAppsRepository aptoideInstalledAppsRepository) {
        sendFeedbackFragment.aptoideInstalledAppsRepository = aptoideInstalledAppsRepository;
    }

    public void injectMembers(SendFeedbackFragment sendFeedbackFragment) {
        injectAptoideInstalledAppsRepository(sendFeedbackFragment, this.aptoideInstalledAppsRepositoryProvider.get());
    }
}
