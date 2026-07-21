package cm.aptoide.pt.view.feedback;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import androidx.core.content.FileProvider;
import cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import cm.aptoide.pt.AptoideApplication;
import cm.aptoide.pt.R;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.database.room.RoomInstalled;
import cm.aptoide.pt.install.AptoideInstalledAppsRepository;
import cm.aptoide.pt.utils.AptoideUtils;
import cm.aptoide.pt.utils.design.ShowMessage;
import cm.aptoide.pt.view.NotBottomNavigationView;
import cm.aptoide.pt.view.fragment.BaseToolbarFragment;
import java.io.File;
import java.util.ArrayList;
import javax.inject.Inject;
import okhttp3.HttpUrl;
import rx.k;

/* JADX INFO: loaded from: classes.dex */
public class SendFeedbackFragment extends BaseToolbarFragment implements NotBottomNavigationView {
    private static final String CARD_ID = "card_id";
    public static final String LOGS_FILE_NAME = "logs.txt";
    public static final String SCREENSHOT_PATH = "SCREENSHOT_PATH";
    private final String KEY_SCREENSHOT_PATH = "screenShotPath";

    @Inject
    AptoideInstalledAppsRepository aptoideInstalledAppsRepository;
    private NavigationTracker aptoideNavigationTracker;
    private String cardId;
    private CrashReport crashReport;
    private CheckBox logsAndScreenshotsCb;
    private EditText messageBodyEdit;
    private String screenShotPath;
    private Button sendFeedbackBtn;
    private EditText subgectEdit;
    private k unManagedSubscription;

    private Uri getUriFromFile(File file) {
        return Build.VERSION.SDK_INT > 23 ? FileProvider.e(getContext(), "cm.aptoide.pt.provider", file) : Uri.fromFile(file);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$sendFeedback$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e(Intent intent, String str, RoomInstalled roomInstalled) {
        intent.putExtra("android.intent.extra.SUBJECT", "[Feedback]-" + (roomInstalled != null ? roomInstalled.getVersionName() : HttpUrl.FRAGMENT_ENCODE_SET) + ": " + this.subgectEdit.getText().toString());
        intent.putExtra("android.intent.extra.TEXT", this.messageBodyEdit.getText().toString());
        if (this.logsAndScreenshotsCb.isChecked()) {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            if (this.screenShotPath != null) {
                arrayList.add(getUriFromFile(new File(this.screenShotPath)));
            }
            String prettyScreenHistory = this.cardId;
            if (prettyScreenHistory == null) {
                prettyScreenHistory = this.aptoideNavigationTracker.getPrettyScreenHistory();
            }
            File logs = AptoideUtils.SystemU.readLogs(str, LOGS_FILE_NAME, prettyScreenHistory);
            if (logs != null) {
                arrayList.add(getUriFromFile(logs));
            }
            intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
        }
        try {
            getActivity().getSupportFragmentManager().m().p(this).i();
            startActivity(intent);
            getActivity().onBackPressed();
        } catch (ActivityNotFoundException unused) {
            ShowMessage.asSnack(getView(), R.string.feedback_no_email);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$sendFeedback$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(Throwable th) {
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setupViews$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g(Void r1) {
        sendFeedback();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setupViews$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h(Throwable th) {
        this.crashReport.log(th);
    }

    public static SendFeedbackFragment newInstance(String str) {
        SendFeedbackFragment sendFeedbackFragment = new SendFeedbackFragment();
        Bundle bundle = new Bundle();
        bundle.putString(SCREENSHOT_PATH, str);
        sendFeedbackFragment.setArguments(bundle);
        return sendFeedbackFragment;
    }

    private void sendFeedback() {
        if (!isContentValid()) {
            ShowMessage.asSnack(getView(), R.string.feedback_not_valid);
            return;
        }
        final Intent intent = new Intent("android.intent.action.SEND_MULTIPLE");
        intent.setType("message/rfc822");
        intent.putExtra("android.intent.extra.EMAIL", new String[]{((AptoideApplication) getContext().getApplicationContext()).getFeedbackEmail()});
        final String path = getContext().getApplicationContext().getCacheDir().getPath();
        this.unManagedSubscription = this.aptoideInstalledAppsRepository.getInstalled(getContext().getPackageName()).E().j0(rx.l.c.a.b()).H0(new rx.m.b() { // from class: cm.aptoide.pt.view.feedback.b
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f8050f.e(intent, path, (RoomInstalled) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.view.feedback.a
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f8049f.f((Throwable) obj);
            }
        });
    }

    @Override // cm.aptoide.pt.view.fragment.BaseToolbarFragment, cm.aptoide.pt.view.fragment.UiComponent
    public void bindViews(View view) {
        super.bindViews(view);
        this.subgectEdit = (EditText) view.findViewById(R.id.FeedBackSubject);
        this.messageBodyEdit = (EditText) view.findViewById(R.id.FeedBacktext);
        this.sendFeedbackBtn = (Button) view.findViewById(R.id.FeedBackSendButton);
        this.logsAndScreenshotsCb = (CheckBox) view.findViewById(R.id.FeedBackCheckBox);
    }

    @Override // cm.aptoide.pt.view.fragment.BaseToolbarFragment
    protected boolean displayHomeUpAsEnabled() {
        return true;
    }

    @Override // cm.aptoide.pt.view.fragment.UiComponent
    public int getContentViewId() {
        return R.layout.activity_feed_back;
    }

    @Override // cm.aptoide.pt.view.fragment.NavigationTrackFragment
    public ScreenTagHistory getHistoryTracker() {
        return ScreenTagHistory.Builder.build(getClass().getSimpleName());
    }

    public boolean isContentValid() {
        return !TextUtils.isEmpty(this.subgectEdit.getText().toString());
    }

    @Override // cm.aptoide.pt.view.fragment.FragmentView, cm.aptoide.pt.view.BaseFragment, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override // cm.aptoide.pt.view.fragment.UIComponentFragment, cm.aptoide.pt.view.fragment.NavigationTrackFragment, cm.aptoide.pt.view.fragment.FragmentView, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getFragmentComponent(bundle).inject(this);
        this.aptoideNavigationTracker = ((AptoideApplication) getContext().getApplicationContext()).getNavigationTracker();
        this.crashReport = CrashReport.getInstance();
        setHasOptionsMenu(true);
    }

    @Override // cm.aptoide.pt.view.fragment.BaseToolbarFragment, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        k kVar = this.unManagedSubscription;
        if (kVar != null) {
            kVar.unsubscribe();
        }
    }

    @Override // cm.aptoide.pt.view.fragment.FragmentView, androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        getActivity().onBackPressed();
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("screenShotPath", this.screenShotPath);
    }

    @Override // cm.aptoide.pt.view.fragment.UIComponentFragment, cm.aptoide.pt.view.fragment.NavigationTrackFragment, cm.aptoide.pt.view.BaseFragment, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (bundle != null) {
            this.screenShotPath = bundle.getString("screenShotPath");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
        this.screenShotPath = bundle.getString(SCREENSHOT_PATH);
        this.cardId = bundle.getString(CARD_ID);
    }

    @Override // cm.aptoide.pt.view.fragment.BaseToolbarFragment, cm.aptoide.pt.view.fragment.UIComponentFragment, cm.aptoide.pt.view.fragment.UiComponent
    public void setupViews() {
        super.setupViews();
        e.g.a.c.a.a(this.sendFeedbackBtn).H0(new rx.m.b() { // from class: cm.aptoide.pt.view.feedback.c
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f8053f.g((Void) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.view.feedback.d
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f8054f.h((Throwable) obj);
            }
        });
    }

    public static SendFeedbackFragment newInstance() {
        return new SendFeedbackFragment();
    }

    public static SendFeedbackFragment newInstance(String str, String str2) {
        SendFeedbackFragment sendFeedbackFragment = new SendFeedbackFragment();
        Bundle bundle = new Bundle();
        bundle.putString(SCREENSHOT_PATH, str);
        bundle.putString(CARD_ID, str2);
        sendFeedbackFragment.setArguments(bundle);
        return sendFeedbackFragment;
    }
}
