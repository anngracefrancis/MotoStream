package cm.aptoide.pt;

import cm.aptoide.pt.install.DownloadService;
import cm.aptoide.pt.install.InstalledIntentService;
import cm.aptoide.pt.notification.PullingContentService;
import cm.aptoide.pt.toolbox.ToolboxContentProvider;
import cm.aptoide.pt.view.ActivityComponent;
import cm.aptoide.pt.view.ActivityModule;
import javax.inject.Singleton;

/* JADX INFO: loaded from: classes.dex */
@Singleton
public interface ApplicationComponent {
    void inject(AptoideApplication aptoideApplication);

    void inject(AptoideFirebaseNotificationService aptoideFirebaseNotificationService);

    void inject(NotificationApplicationView notificationApplicationView);

    void inject(DownloadService downloadService);

    void inject(InstalledIntentService installedIntentService);

    void inject(PullingContentService pullingContentService);

    void inject(ToolboxContentProvider toolboxContentProvider);

    ActivityComponent plus(ActivityModule activityModule, FlavourActivityModule flavourActivityModule);
}
