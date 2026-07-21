package cm.aptoide.pt.comments.view;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import cm.aptoide.analytics.AnalyticsManager;
import cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import cm.aptoide.pt.AptoideApplication;
import cm.aptoide.pt.R;
import cm.aptoide.pt.UserFeedbackAnalytics;
import cm.aptoide.pt.comments.CommentDialogCallbackContract;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.dataprovider.WebService;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.model.v7.BaseV7Response;
import cm.aptoide.pt.dataprovider.util.CommentType;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v7.BaseBody;
import cm.aptoide.pt.dataprovider.ws.v7.PostCommentForReview;
import cm.aptoide.pt.dataprovider.ws.v7.store.PostCommentForStore;
import cm.aptoide.pt.logger.Logger;
import cm.aptoide.pt.store.StoreAnalytics;
import cm.aptoide.pt.utils.AptoideUtils;
import cm.aptoide.pt.utils.design.ShowMessage;
import cm.aptoide.pt.view.fragment.BaseDialogFragment;
import com.google.android.material.textfield.TextInputLayout;
import javax.inject.Inject;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes.dex */
public class CommentDialogFragment extends BaseDialogFragment {
    private static final String APP_OR_STORE_NAME = "app_or_store_name";
    private static final String COMMENT_TYPE = "comment_type";
    private static final String PREVIOUS_COMMENT_ID = "previous_comment_id";
    private static final String RESOURCE_ID_AS_LONG = "resource_id_as_long";
    private static final String RESOURCE_ID_AS_STRING = "resource_id_as_string";
    private AnalyticsManager analyticsManager;
    private String appOrStoreName;
    private BodyInterceptor<BaseBody> baseBodyBodyInterceptor;
    private Button commentButton;
    private CommentDialogCallbackContract commentDialogCallbackContract;
    private CommentType commentType;
    private Converter.Factory converterFactory;
    private OkHttpClient httpClient;
    private long idAsLong;
    private String idAsString;
    private NavigationTracker navigationTracker;
    private String onEmptyTextError;
    private Long previousCommentId;
    private SharedPreferences sharedPreferences;
    private StoreAnalytics storeAnalytics;
    private TextInputLayout textInputLayout;
    private TokenInvalidator tokenInvalidator;

    @Inject
    UserFeedbackAnalytics userFeedbackAnalytics;

    /* JADX INFO: renamed from: cm.aptoide.pt.comments.view.CommentDialogFragment$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$dataprovider$util$CommentType;

        static {
            int[] iArr = new int[CommentType.values().length];
            $SwitchMap$cm$aptoide$pt$dataprovider$util$CommentType = iArr;
            try {
                iArr[CommentType.REVIEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$util$CommentType[CommentType.STORE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void disableError() {
        this.textInputLayout.setErrorEnabled(false);
    }

    private void enableError(String str) {
        this.textInputLayout.setError(str);
    }

    private String getText() {
        TextInputLayout textInputLayout = this.textInputLayout;
        if (textInputLayout != null) {
            return textInputLayout.getEditText().getEditableText().toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$onCreateView$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d(View view) {
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setupLogic$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e e(Void r1) {
        return rx.e.S(getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setupLogic$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Boolean f(String str) {
        if (TextUtils.isEmpty(str)) {
            enableError(this.onEmptyTextError);
            return Boolean.FALSE;
        }
        disableError();
        return Boolean.TRUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setupLogic$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g(Throwable th) {
        CrashReport.getInstance().log(th);
        ShowMessage.asSnack(this, R.string.error_occured);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setupLogic$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e h(String str) {
        return submitComment(str, this.idAsLong, this.previousCommentId).j0(rx.l.c.a.b()).w(new rx.m.b() { // from class: cm.aptoide.pt.comments.view.e
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f4794f.g((Throwable) obj);
            }
        }).s0().f(bindUntilEvent(com.trello.rxlifecycle.g.b.DESTROY_VIEW));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setupLogic$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i(BaseV7Response baseV7Response) {
        if (!baseV7Response.isOk()) {
            ShowMessage.asSnack(this, R.string.error_occured);
            return;
        }
        dismiss();
        CommentDialogCallbackContract commentDialogCallbackContract = this.commentDialogCallbackContract;
        if (commentDialogCallbackContract != null) {
            commentDialogCallbackContract.okSelected(baseV7Response, this.idAsLong, this.previousCommentId, this.idAsString);
        }
    }

    private void loadArguments() {
        Bundle arguments = getArguments();
        this.appOrStoreName = arguments.getString(APP_OR_STORE_NAME, HttpUrl.FRAGMENT_ENCODE_SET);
        this.commentType = CommentType.valueOf(arguments.getString(COMMENT_TYPE));
        this.idAsString = arguments.getString(RESOURCE_ID_AS_STRING);
        this.idAsLong = arguments.getLong(RESOURCE_ID_AS_LONG);
        if (arguments.containsKey(PREVIOUS_COMMENT_ID)) {
            this.previousCommentId = Long.valueOf(arguments.getLong(PREVIOUS_COMMENT_ID));
        }
    }

    public static CommentDialogFragment newInstanceReviewReply(long j2, String str) {
        Bundle bundle = new Bundle();
        bundle.putString(COMMENT_TYPE, CommentType.REVIEW.name());
        bundle.putLong(RESOURCE_ID_AS_LONG, j2);
        if (!TextUtils.isEmpty(str)) {
            bundle.putString(APP_OR_STORE_NAME, str);
        }
        CommentDialogFragment commentDialogFragment = new CommentDialogFragment();
        commentDialogFragment.setArguments(bundle);
        return commentDialogFragment;
    }

    public static CommentDialogFragment newInstanceStoreComment(long j2, String str) {
        Bundle bundle = new Bundle();
        bundle.putString(COMMENT_TYPE, CommentType.STORE.name());
        bundle.putLong(RESOURCE_ID_AS_LONG, j2);
        if (!TextUtils.isEmpty(str)) {
            bundle.putString(APP_OR_STORE_NAME, str);
        }
        CommentDialogFragment commentDialogFragment = new CommentDialogFragment();
        commentDialogFragment.setArguments(bundle);
        return commentDialogFragment;
    }

    public static CommentDialogFragment newInstanceStoreCommentReply(long j2, long j3, String str) {
        Bundle bundle = new Bundle();
        bundle.putString(COMMENT_TYPE, CommentType.STORE.name());
        bundle.putLong(RESOURCE_ID_AS_LONG, j2);
        bundle.putLong(PREVIOUS_COMMENT_ID, j3);
        if (!TextUtils.isEmpty(str)) {
            bundle.putString(APP_OR_STORE_NAME, str);
        }
        CommentDialogFragment commentDialogFragment = new CommentDialogFragment();
        commentDialogFragment.setArguments(bundle);
        return commentDialogFragment;
    }

    private void setupLogic() {
        this.textInputLayout.getEditText().addTextChangedListener(new TextWatcher() { // from class: cm.aptoide.pt.comments.view.CommentDialogFragment.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (charSequence.length() > 0) {
                    CommentDialogFragment.this.disableError();
                }
            }
        });
        e.g.a.c.a.a(this.commentButton).G(new rx.m.e() { // from class: cm.aptoide.pt.comments.view.g
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4805f.e((Void) obj);
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.comments.view.f
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4802f.f((String) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.comments.view.c
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4784f.h((String) obj);
            }
        }).H0(new rx.m.b() { // from class: cm.aptoide.pt.comments.view.b
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f4780f.i((BaseV7Response) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.comments.view.a
            @Override // rx.m.b
            public final void call(Object obj) {
                CrashReport.getInstance().log((Throwable) obj);
            }
        });
    }

    private rx.e<? extends BaseV7Response> submitComment(String str, long j2, Long l) {
        int i2 = AnonymousClass2.$SwitchMap$cm$aptoide$pt$dataprovider$util$CommentType[this.commentType.ordinal()];
        if (i2 == 1) {
            this.userFeedbackAnalytics.sendAppReviewReplyComment();
            return PostCommentForReview.of(j2, str, this.baseBodyBodyInterceptor, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences).observe(true, true);
        }
        if (i2 != 2) {
            Logger.getInstance().e(getTag(), "Unable to create reply due to missing comment type");
            return rx.e.B();
        }
        if (l == null) {
            this.userFeedbackAnalytics.sendStoreCommentEvent();
            this.storeAnalytics.sendStoreInteractEvent("Write a Comment", "Home", this.appOrStoreName);
            return PostCommentForStore.of(j2, str, this.baseBodyBodyInterceptor, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences).observe(true, true);
        }
        this.userFeedbackAnalytics.sendStoreCommentReplyEvent();
        this.storeAnalytics.sendStoreInteractEvent("Reply to Comment", "Home", this.appOrStoreName);
        return PostCommentForStore.of(j2, l.longValue(), str, this.baseBodyBodyInterceptor, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences).observe(true, true);
    }

    @Override // cm.aptoide.pt.view.fragment.BaseDialogFragment, com.trello.rxlifecycle.h.a.c, androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getFragmentComponent(bundle).inject(this);
        AptoideApplication aptoideApplication = (AptoideApplication) getContext().getApplicationContext();
        this.sharedPreferences = aptoideApplication.getDefaultSharedPreferences();
        this.tokenInvalidator = aptoideApplication.getTokenInvalidator();
        this.baseBodyBodyInterceptor = aptoideApplication.getAccountSettingsBodyInterceptorPoolV7();
        this.httpClient = aptoideApplication.getDefaultClient();
        this.converterFactory = WebService.getDefaultConverter();
        this.onEmptyTextError = AptoideUtils.StringU.getResString(R.string.ws_error_MARG_107, getContext().getResources());
        this.analyticsManager = aptoideApplication.getAnalyticsManager();
        this.navigationTracker = aptoideApplication.getNavigationTracker();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        loadArguments();
        View viewInflate = layoutInflater.inflate(R.layout.dialog_comment_on_review, viewGroup);
        TextView textView = (TextView) viewInflate.findViewById(R.id.title);
        textView.setVisibility(0);
        int i2 = AnonymousClass2.$SwitchMap$cm$aptoide$pt$dataprovider$util$CommentType[this.commentType.ordinal()];
        if (i2 == 1) {
            textView.setText(getString(R.string.dialog_title_comment));
        } else if (i2 == 2) {
            textView.setText(TextUtils.isEmpty(this.appOrStoreName) ? getString(R.string.comment_store_title) : getString(R.string.commentlist_title_comment_on_store, this.appOrStoreName));
        }
        ((Button) viewInflate.findViewById(R.id.cancel_button)).setOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.pt.comments.view.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f4791f.d(view);
            }
        });
        this.textInputLayout = (TextInputLayout) viewInflate.findViewById(R.id.input_layout_title);
        this.commentButton = (Button) viewInflate.findViewById(R.id.comment_button);
        setupLogic();
        this.storeAnalytics = new StoreAnalytics(this.analyticsManager, this.navigationTracker);
        return viewInflate;
    }

    public void setCommentDialogCallbackContract(CommentDialogCallbackContract commentDialogCallbackContract) {
        this.commentDialogCallbackContract = commentDialogCallbackContract;
    }
}
