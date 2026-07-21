package cm.aptoide.pt.view;

import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cm.aptoide.pt.AptoideApplication;
import cm.aptoide.pt.DeepLinkIntentReceiver;
import cm.aptoide.pt.FirebaseConstants;
import cm.aptoide.pt.FirebaseNotificationAnalytics;
import cm.aptoide.pt.R;
import cm.aptoide.pt.bottomNavigation.BottomNavigationActivity;
import cm.aptoide.pt.install.InstallManager;
import cm.aptoide.pt.notification.NotificationInfo;
import cm.aptoide.pt.notification.SystemNotificationShower;
import cm.aptoide.pt.presenter.MainView;
import cm.aptoide.pt.presenter.Presenter;
import cm.aptoide.pt.themes.ThemeAnalytics;
import cm.aptoide.pt.util.MarketResourceFormatter;
import cm.aptoide.pt.utils.AptoideUtils;
import cm.aptoide.pt.utils.GenericDialogs;
import cm.aptoide.pt.utils.design.ShowMessage;
import com.google.android.material.snackbar.Snackbar;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes.dex */
public class MainActivity extends BottomNavigationActivity implements MainView, DeepLinkManager.DeepLinkView {
    private rx.s.b<String> authenticationSubject;
    private ProgressDialog autoUpdateDialog;

    @Inject
    DeepLinkManager deepLinkManager;

    @Inject
    FirebaseNotificationAnalytics firebaseNotificationAnalytics;
    private e.g.b.c<Void> installErrorsDismissEvent;
    private InstallManager installManager;

    @Inject
    MarketResourceFormatter marketResourceFormatter;
    private e.g.b.c<NotificationInfo> notificationPublishRelay;

    @Inject
    Presenter presenter;
    private ProgressDialog progressDialog;

    @Inject
    Resources resources;
    private View snackBarLayout;
    private Snackbar snackbar;

    @Inject
    ThemeAnalytics themeAnalytics;
    private View updatesBadge;
    private TextView updatesNumber;

    private void handleFirebaseDeeplink(Intent intent) {
        String stringExtra = intent.getStringExtra("dti.link");
        if (stringExtra == null || stringExtra.isEmpty()) {
            return;
        }
        Intent intent2 = new Intent(getApplicationContext(), (Class<?>) DeepLinkIntentReceiver.class);
        intent2.setData(Uri.parse(stringExtra));
        startActivity(intent2);
    }

    private void handleNewIntent(Intent intent) {
        if (isAuthenticationDeepLink(intent).booleanValue()) {
            this.authenticationSubject.onNext(intent.getStringExtra(DeepLinkIntentReceiver.DeepLinksKeys.AUTH_TOKEN));
            return;
        }
        if (isNotificationDeeplink(intent).booleanValue()) {
            Bundle extras = intent.getExtras();
            NotificationInfo notificationInfo = new NotificationInfo(intent.getAction(), extras.getInt(SystemNotificationShower.NOTIFICATION_NOTIFICATION_ID), extras.getString(SystemNotificationShower.NOTIFICATION_TRACK_URL), extras.getString(SystemNotificationShower.NOTIFICATION_TARGET_URL));
            ((NotificationManager) getSystemService("notification")).cancel(intent.getIntExtra(SystemNotificationShower.NOTIFICATION_NOTIFICATION_ID, -1));
            this.notificationPublishRelay.call(notificationInfo);
            return;
        }
        if (!isFirebaseNotification(intent)) {
            this.deepLinkManager.showDeepLink(intent);
        } else {
            sendFirebaseNotificationAnalytics(intent);
            handleFirebaseDeeplink(intent);
        }
    }

    private Boolean isAuthenticationDeepLink(Intent intent) {
        return Boolean.valueOf(intent.getBooleanExtra(DeepLinkIntentReceiver.DeepLinksTargets.APTOIDE_AUTH, false));
    }

    private boolean isFirebaseNotification(Intent intent) {
        return intent.getStringExtra(FirebaseConstants.FIREBASE_MESSAGE_ID) != null;
    }

    private Boolean isNotificationDeeplink(Intent intent) {
        return Boolean.valueOf(intent.getAction() != null && (intent.getAction().equals(SystemNotificationShower.NOTIFICATION_PRESSED_ACTION) || intent.getAction().equals(SystemNotificationShower.NOTIFICATION_DISMISSED_ACTION)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$showInstallationError$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g(View view) {
        this.installManager.retryTimedOutInstallations().a(this.installManager.cleanTimedOutInstalls()).H();
    }

    private void sendFirebaseNotificationAnalytics(Intent intent) {
        String stringExtra = intent.getStringExtra(FirebaseConstants.FIREBASE_MESSAGE_ID);
        Bundle bundleExtra = intent.getBundleExtra(FirebaseConstants.FIREBASE_ANALYTICS_DATA);
        if (stringExtra == null || bundleExtra == null) {
            return;
        }
        String string = bundleExtra.getString(FirebaseConstants.FIREBASE_MESSAGE_NAME);
        Long lValueOf = Long.valueOf(System.currentTimeMillis());
        this.firebaseNotificationAnalytics.sendFirebaseNotificationOpened(stringExtra, string, lValueOf.longValue(), bundleExtra.getString(FirebaseConstants.FIREBASE_MESSAGE_LABEL));
    }

    private void setupUpdatesNotification() {
        com.google.android.material.bottomnavigation.c cVar = (com.google.android.material.bottomnavigation.c) this.bottomNavigationView.getChildAt(0);
        com.google.android.material.bottomnavigation.a aVar = (com.google.android.material.bottomnavigation.a) cVar.getChildAt(4);
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.updates_badge, (ViewGroup) cVar, false);
        this.updatesBadge = viewInflate;
        this.updatesNumber = (TextView) viewInflate.findViewById(R.id.updates_badge);
        aVar.addView(this.updatesBadge);
        aVar.setVisibility(0);
    }

    @Override // cm.aptoide.pt.presenter.MainView
    public void dismissAutoUpdateDialog() {
        ProgressDialog progressDialog = this.autoUpdateDialog;
        if (progressDialog == null || !progressDialog.isShowing()) {
            return;
        }
        this.autoUpdateDialog.dismiss();
    }

    @Override // cm.aptoide.pt.presenter.MainView
    public void dismissInstallationError() {
        Snackbar snackbar = this.snackbar;
        if (snackbar != null) {
            snackbar.t();
        }
    }

    @Override // cm.aptoide.pt.presenter.MainView
    public rx.e<Void> getInstallErrorsDismiss() {
        return this.installErrorsDismissEvent;
    }

    @Override // cm.aptoide.pt.presenter.MainView
    public Intent getIntentAfterCreate() {
        return getIntent();
    }

    @Override // cm.aptoide.pt.presenter.MainView
    public void hideLoadingView() {
        this.progressDialog.hide();
    }

    @Override // cm.aptoide.pt.presenter.MainView
    public rx.e<String> onAuthenticationIntent() {
        return this.authenticationSubject;
    }

    @Override // cm.aptoide.pt.bottomNavigation.BottomNavigationActivity, cm.aptoide.pt.account.view.LoginBottomSheetActivity, cm.aptoide.pt.view.BackButtonActivity, cm.aptoide.pt.view.ThemedActivityView, cm.aptoide.pt.analytics.view.AnalyticsActivity, cm.aptoide.pt.permission.PermissionProviderActivity, cm.aptoide.pt.permission.PermissionServiceActivity, cm.aptoide.pt.navigator.ActivityResultNavigator, cm.aptoide.pt.view.BaseActivity, com.trello.rxlifecycle.h.a.a, androidx.appcompat.app.d, androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getActivityComponent().inject(this);
        this.installManager = ((AptoideApplication) getApplicationContext()).getInstallManager();
        this.snackBarLayout = findViewById(R.id.snackbar_layout);
        this.installErrorsDismissEvent = e.g.b.c.f1();
        this.authenticationSubject = rx.s.b.g1();
        this.notificationPublishRelay = ((AptoideApplication) getApplicationContext()).getNotificationsPublishRelay();
        this.themeAnalytics.setDarkThemeUserProperty(((ThemedActivityView) this).themeManager.getDarkThemeMode());
        this.progressDialog = GenericDialogs.createGenericPleaseWaitDialog(this, ((ThemedActivityView) this).themeManager.getAttributeForTheme(R.attr.dialogsTheme).resourceId);
        setupUpdatesNotification();
        Intent intent = getIntent();
        if (isNotificationDeeplink(intent).booleanValue()) {
            Bundle extras = intent.getExtras();
            NotificationInfo notificationInfo = new NotificationInfo(intent.getAction(), extras.getInt(SystemNotificationShower.NOTIFICATION_NOTIFICATION_ID), extras.getString(SystemNotificationShower.NOTIFICATION_TRACK_URL), extras.getString(SystemNotificationShower.NOTIFICATION_TARGET_URL));
            ((NotificationManager) getSystemService("notification")).cancel(intent.getIntExtra(SystemNotificationShower.NOTIFICATION_NOTIFICATION_ID, -1));
            this.notificationPublishRelay.call(notificationInfo);
        } else if (isFirebaseNotification(intent)) {
            sendFirebaseNotificationAnalytics(intent);
            handleFirebaseDeeplink(intent);
        }
        attachPresenter(this.presenter);
    }

    @Override // cm.aptoide.pt.bottomNavigation.BottomNavigationActivity, cm.aptoide.pt.view.BaseActivity, com.trello.rxlifecycle.h.a.a, androidx.appcompat.app.d, androidx.fragment.app.d, android.app.Activity
    protected void onDestroy() {
        this.autoUpdateDialog = null;
        this.installErrorsDismissEvent = null;
        this.installManager = null;
        this.updatesBadge = null;
        this.snackBarLayout = null;
        this.snackbar = null;
        this.progressDialog = null;
        this.authenticationSubject = null;
        super.onDestroy();
    }

    @Override // androidx.fragment.app.d, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        handleNewIntent(intent);
    }

    @Override // cm.aptoide.pt.analytics.view.AnalyticsActivity, com.trello.rxlifecycle.h.a.a, androidx.fragment.app.d, android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
    }

    @Override // cm.aptoide.pt.analytics.view.AnalyticsActivity, com.trello.rxlifecycle.h.a.a, androidx.fragment.app.d, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // cm.aptoide.pt.analytics.view.AnalyticsActivity, com.trello.rxlifecycle.h.a.a, androidx.appcompat.app.d, androidx.fragment.app.d, android.app.Activity
    protected void onStart() {
        super.onStart();
    }

    @Override // cm.aptoide.pt.analytics.view.AnalyticsActivity, com.trello.rxlifecycle.h.a.a, androidx.appcompat.app.d, androidx.fragment.app.d, android.app.Activity
    protected void onStop() {
        super.onStop();
    }

    @Override // cm.aptoide.pt.presenter.MainView
    public void showGenericErrorMessage() {
        ShowMessage.asLongSnack(this, getString(R.string.all_message_general_error));
    }

    @Override // cm.aptoide.pt.presenter.MainView
    public void showInstallationError(int i2) {
        Snackbar snackbarP = Snackbar.a0(this.snackBarLayout, i2 == 1 ? getString(R.string.generalscreen_short_root_install_single_app_timeout_error_message) : getString(R.string.generalscreen_short_root_install_timeout_error_message, new Object[]{Integer.valueOf(i2)}), -2).b0(R.string.generalscreen_short_root_install_timeout_error_action, new View.OnClickListener() { // from class: cm.aptoide.pt.view.x0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f8312f.g(view);
            }
        }).p(new Snackbar.b() { // from class: cm.aptoide.pt.view.MainActivity.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.android.material.snackbar.Snackbar.b, com.google.android.material.snackbar.BaseTransientBottomBar.r
            public void onDismissed(Snackbar snackbar, int i3) {
                super.onDismissed(snackbar, i3);
                if (i3 == 0) {
                    MainActivity.this.installErrorsDismissEvent.call(null);
                }
            }
        });
        this.snackbar = snackbarP;
        snackbarP.P();
    }

    @Override // cm.aptoide.pt.presenter.MainView
    public void showInstallationSuccessMessage() {
        ShowMessage.asSnack(this.snackBarLayout, R.string.generalscreen_short_root_install_success_install);
    }

    @Override // cm.aptoide.pt.presenter.MainView
    public void showLoadingView() {
        this.progressDialog.show();
    }

    @Override // cm.aptoide.pt.view.DeepLinkManager.DeepLinkView
    public void showStoreAlreadyAdded() {
        ShowMessage.asLongSnack(this, getString(R.string.store_already_added));
    }

    @Override // cm.aptoide.pt.view.DeepLinkManager.DeepLinkView
    public void showStoreFollowed(String str) {
        ShowMessage.asLongSnack(this, AptoideUtils.StringU.getFormattedString(R.string.store_followed, getResources(), str));
    }

    @Override // cm.aptoide.pt.presenter.MainView
    public void showUnknownErrorMessage() {
        Snackbar.Z(findViewById(android.R.id.content), R.string.unknown_error, -1).P();
    }

    @Override // cm.aptoide.pt.presenter.MainView
    public void showUpdatesBadge(int i2) {
        if (i2 <= 0) {
            this.updatesNumber.setVisibility(0);
            this.updatesNumber.setBackground(getResources().getDrawable(R.drawable.updates_badge_circle_small));
            this.updatesNumber.setTextSize(6.0f);
        } else {
            this.updatesNumber.setVisibility(0);
            this.updatesNumber.setBackground(getResources().getDrawable(R.drawable.updates_badge_circle));
            this.updatesNumber.setTextSize(10.0f);
            this.updatesNumber.setText(String.valueOf(i2));
        }
    }
}
