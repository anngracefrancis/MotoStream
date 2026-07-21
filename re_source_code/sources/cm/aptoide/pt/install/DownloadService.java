package cm.aptoide.pt.install;

import android.R;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import cm.aptoide.pt.AppInBackgroundTracker;
import cm.aptoide.pt.AptoideApplication;
import cm.aptoide.pt.BaseService;
import cm.aptoide.pt.DeepLinkIntentReceiver;
import cm.aptoide.pt.downloadmanager.AptoideDownloadManager;
import cm.aptoide.pt.logger.Logger;
import cm.aptoide.pt.notification.NotificationProvider;
import java.util.Locale;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes.dex */
public class DownloadService extends BaseService implements DownloadsNotification {
    public static final String ACTION_INSTALL_FINISHED = "INSTALL_FINISHED";
    public static final String ACTION_STOP_INSTALL = "STOP_INSTALL";
    public static final String DOWNLOAD_APP_ACTION = "DOWNLOAD_APP";
    public static final String EXTRA_INSTALLATION_MD5 = "INSTALLATION_MD5";
    private static final int NOTIFICATION_ID = 8;
    public static final int PROGRESS_MAX_VALUE = 100;
    public static final String TAG = "InstallService";

    @Inject
    AppInBackgroundTracker appInBackgroundTracker;

    @Inject
    AptoideDownloadManager downloadManager;
    private DownloadsNotificationsPresenter downloadsNotificationsPresenter;
    private InstallManager installManager;

    @Inject
    NotificationProvider notificationProvider;
    private Notification progressNotification;
    private final int PAUSE_DOWNLOAD_REQUEST_CODE = 111;
    private final int OPEN_DOWNLOAD_MANAGER_REQUEST_CODE = 222;
    private final int OPEN_APPVIEW_REQUEST_CODE = 333;
    private final String CHANNEL_ID = "download_notification_channel";

    private Notification buildNotification(String str, int i2, boolean z, androidx.core.app.i.a aVar, androidx.core.app.i.a aVar2, PendingIntent pendingIntent) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 26) {
            createNotificationChannel();
        }
        androidx.core.app.i.e eVar = i3 >= 26 ? new androidx.core.app.i.e(this, "download_notification_channel") : new androidx.core.app.i.e(this);
        androidx.core.app.i.e eVarL = eVar.y(R.drawable.stat_sys_download).l(String.format(Locale.ENGLISH, getResources().getString(cm.aptoide.pt.R.string.aptoide_downloading), getString(cm.aptoide.pt.R.string.app_name)));
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" - ");
        sb.append(getString(cm.aptoide.pt.R.string.download_progress));
        eVarL.k(sb).j(pendingIntent).w(100, i2, z).b(aVar).b(aVar2);
        return eVar.c();
    }

    private Intent createDeeplinkingIntent() {
        Intent intent = new Intent();
        intent.setClass(getApplicationContext(), AptoideApplication.getActivityProvider().getMainActivityFragmentClass());
        intent.setFlags(276824064);
        return intent;
    }

    private void createNotificationChannel() {
        ((NotificationManager) getSystemService("notification")).createNotificationChannel(new NotificationChannel("download_notification_channel", "Download notifications", 0));
    }

    private androidx.core.app.i.a getAction(int i2, String str, PendingIntent pendingIntent) {
        return new androidx.core.app.i.a(i2, str, pendingIntent);
    }

    private PendingIntent getAppViewOpeningPendingIntent(String str) {
        Intent intentCreateDeeplinkingIntent = createDeeplinkingIntent();
        Bundle bundle = new Bundle();
        bundle.putBoolean(DeepLinkIntentReceiver.DeepLinksTargets.APP_VIEW_FRAGMENT, true);
        bundle.putString("md5", str);
        intentCreateDeeplinkingIntent.putExtras(bundle);
        return PendingIntent.getActivity(this, 333, intentCreateDeeplinkingIntent, 167772160);
    }

    private NotificationChannel getChannel() {
        NotificationChannel notificationChannel = new NotificationChannel("download_notification_channel", "Download notifications", 4);
        notificationChannel.setDescription("Download");
        return notificationChannel;
    }

    private androidx.core.app.i.a getDownloadManagerAction(int i2) {
        return getAction(cm.aptoide.pt.R.drawable.ic_manager, getString(cm.aptoide.pt.R.string.open_apps_manager), getOpenDownloadManagerPendingIntent(i2));
    }

    private PendingIntent getOpenDownloadManagerPendingIntent(int i2) {
        Intent intentCreateDeeplinkingIntent = createDeeplinkingIntent();
        intentCreateDeeplinkingIntent.putExtra(DeepLinkIntentReceiver.DeepLinksTargets.FROM_DOWNLOAD_NOTIFICATION, true);
        return PendingIntent.getActivity(this, 222, intentCreateDeeplinkingIntent, 67108864);
    }

    private androidx.core.app.i.a getPauseAction(String str) {
        return getAction(cm.aptoide.pt.R.drawable.media_pause, getString(cm.aptoide.pt.R.string.pause_download), getPausePendingIntent(str));
    }

    private PendingIntent getPausePendingIntent(String str) {
        Intent intent = new Intent(this, (Class<?>) DownloadService.class);
        if (!TextUtils.isEmpty(str)) {
            Bundle bundle = new Bundle();
            bundle.putString(EXTRA_INSTALLATION_MD5, str);
            intent.putExtras(bundle);
        }
        intent.setAction(ACTION_STOP_INSTALL);
        return PendingIntent.getService(this, 111, intent, 167772160);
    }

    public static Intent newInstanceForDownloads(Context context) {
        Intent intent = new Intent(context, (Class<?>) DownloadService.class);
        intent.setAction(DOWNLOAD_APP_ACTION);
        return intent;
    }

    private void pauseDownload(String str) {
        this.progressNotification = null;
        this.downloadManager.pauseDownload(str).H();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        getApplicationComponent().inject(this);
        Logger.getInstance().d(TAG, "Install service is starting");
        this.installManager = ((AptoideApplication) getApplicationContext()).getInstallManager();
        DownloadsNotificationsPresenter downloadsNotificationsPresenter = new DownloadsNotificationsPresenter(this, this.installManager, this.appInBackgroundTracker, this.notificationProvider);
        this.downloadsNotificationsPresenter = downloadsNotificationsPresenter;
        downloadsNotificationsPresenter.present();
    }

    @Override // android.app.Service
    public void onDestroy() {
        Logger.getInstance().d(getClass().getName(), "InstallService.onDestroy");
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        if (intent == null || !ACTION_STOP_INSTALL.equals(intent.getAction())) {
            return 1;
        }
        String stringExtra = intent.getStringExtra(EXTRA_INSTALLATION_MD5);
        Logger.getInstance().d(TAG, "received intent pausing download: " + stringExtra);
        pauseDownload(stringExtra);
        return 1;
    }

    @Override // cm.aptoide.pt.install.DownloadsNotification
    public void removeProgressNotificationAndStop() {
        this.downloadsNotificationsPresenter.onDestroy();
        this.progressNotification = null;
        stopForeground(true);
        stopSelf();
    }

    @Override // cm.aptoide.pt.install.DownloadsNotification
    public void setupProgressNotification(String str, String str2, int i2, boolean z) {
        androidx.core.app.i.a downloadManagerAction = getDownloadManagerAction(str.hashCode());
        PendingIntent appViewOpeningPendingIntent = getAppViewOpeningPendingIntent(str);
        androidx.core.app.i.a pauseAction = getPauseAction(str);
        Notification notification = this.progressNotification;
        if (notification == null) {
            this.progressNotification = buildNotification(str2, i2, z, pauseAction, downloadManagerAction, appViewOpeningPendingIntent);
        } else {
            long j2 = notification.when;
            Notification notificationBuildNotification = buildNotification(str2, i2, z, pauseAction, downloadManagerAction, appViewOpeningPendingIntent);
            this.progressNotification = notificationBuildNotification;
            notificationBuildNotification.when = j2;
        }
        startForeground(8, this.progressNotification);
    }
}
