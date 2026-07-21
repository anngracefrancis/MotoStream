package cm.aptoide.pt.view.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.SharedPreferences;
import android.text.SpannableString;
import android.text.style.BulletSpan;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatRatingBar;
import cm.aptoide.accountmanager.AptoideAccountManager;
import cm.aptoide.pt.R;
import cm.aptoide.pt.UserFeedbackAnalytics;
import cm.aptoide.pt.account.AccountAnalytics;
import cm.aptoide.pt.account.view.AccountNavigator;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.dataprovider.interfaces.ErrorRequestListener;
import cm.aptoide.pt.dataprovider.interfaces.SuccessRequestListener;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.model.v7.BaseV7Response;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v7.BaseBody;
import cm.aptoide.pt.dataprovider.ws.v7.PostReviewRequest;
import cm.aptoide.pt.install.AptoideInstalledAppsRepository;
import cm.aptoide.pt.logger.Logger;
import cm.aptoide.pt.preferences.managed.ManagerPreferences;
import cm.aptoide.pt.themes.ThemeManager;
import cm.aptoide.pt.util.MarketResourceFormatter;
import cm.aptoide.pt.utils.AptoideUtils;
import cm.aptoide.pt.utils.GenericDialogs;
import cm.aptoide.pt.utils.design.ShowMessage;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Locale;
import okhttp3.OkHttpClient;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class DialogUtils {
    private static final String TAG = "DialogUtils";
    private final Locale LOCALE = Locale.getDefault();
    private final AptoideAccountManager accountManager;
    private final AccountNavigator accountNavigator;
    private final AptoideInstalledAppsRepository aptoideInstalledAppsRepository;
    private final BodyInterceptor<BaseBody> bodyInterceptor;
    private final Converter.Factory converterFactory;
    private final OkHttpClient httpClient;
    private final MarketResourceFormatter marketResourceFormatter;
    private final SharedPreferences sharedPreferences;
    private final ThemeManager themeManager;
    private final TokenInvalidator tokenInvalidator;
    private final UserFeedbackAnalytics userFeedbackAnalytics;

    public DialogUtils(AptoideAccountManager aptoideAccountManager, AccountNavigator accountNavigator, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, AptoideInstalledAppsRepository aptoideInstalledAppsRepository, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences, MarketResourceFormatter marketResourceFormatter, ThemeManager themeManager, UserFeedbackAnalytics userFeedbackAnalytics) {
        this.accountManager = aptoideAccountManager;
        this.accountNavigator = accountNavigator;
        this.bodyInterceptor = bodyInterceptor;
        this.httpClient = okHttpClient;
        this.converterFactory = factory;
        this.aptoideInstalledAppsRepository = aptoideInstalledAppsRepository;
        this.tokenInvalidator = tokenInvalidator;
        this.sharedPreferences = sharedPreferences;
        this.marketResourceFormatter = marketResourceFormatter;
        this.themeManager = themeManager;
        this.userFeedbackAnalytics = userFeedbackAnalytics;
    }

    private boolean isAppInstalled(String str) {
        return this.aptoideInstalledAppsRepository.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$showRateDialog$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a(View view) {
        this.accountNavigator.navigateToAccountView(AccountAnalytics.AccountOrigins.RATE_DIALOG);
    }

    static /* synthetic */ void lambda$showRateDialog$1(AlertDialog alertDialog) {
        if (alertDialog == null || !alertDialog.isShowing()) {
            return;
        }
        alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$showRateDialog$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(Activity activity, rx.m.a aVar, BaseV7Response baseV7Response) {
        if (!baseV7Response.isOk()) {
            ShowMessage.asSnack(activity, R.string.error_occured);
            return;
        }
        Logger.getInstance().d(TAG, "review added");
        ShowMessage.asSnack(activity, R.string.review_success);
        ManagerPreferences.setForceServerRefreshFlag(true, this.sharedPreferences);
        if (aVar != null) {
            aVar.call();
        }
    }

    static /* synthetic */ void lambda$showRateDialog$11(Activity activity, Throwable th) {
        CrashReport.getInstance().log(th);
        ShowMessage.asSnack(activity, R.string.error_occured);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$showRateDialog$12, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c(final Activity activity, TextInputLayout textInputLayout, AppCompatRatingBar appCompatRatingBar, AlertDialog alertDialog, final rx.m.a aVar, String str, String str2, View view) {
        AptoideUtils.SystemU.hideKeyboard(activity);
        String string = textInputLayout.getEditText().getText().toString();
        int iRound = Math.round(appCompatRatingBar.getRating());
        alertDialog.dismiss();
        SuccessRequestListener successRequestListener = new SuccessRequestListener() { // from class: cm.aptoide.pt.view.dialog.e
            @Override // cm.aptoide.pt.dataprovider.interfaces.SuccessRequestListener, rx.m.b
            public final void call(Object obj) {
                this.f8017f.b(activity, aVar, (BaseV7Response) obj);
            }
        };
        ErrorRequestListener errorRequestListener = new ErrorRequestListener() { // from class: cm.aptoide.pt.view.dialog.h
            @Override // cm.aptoide.pt.dataprovider.interfaces.ErrorRequestListener
            public final void onError(Throwable th) {
                DialogUtils.lambda$showRateDialog$11(activity, th);
            }
        };
        if (str != null) {
            PostReviewRequest.of(str, str2, string, Integer.valueOf(iRound), this.bodyInterceptor, this.httpClient, this.converterFactory, isAppInstalled(str2), this.tokenInvalidator, this.sharedPreferences).execute(successRequestListener, errorRequestListener);
        } else {
            PostReviewRequest.of(str2, string, Integer.valueOf(iRound), this.bodyInterceptor, this.httpClient, this.converterFactory, isAppInstalled(str2), this.tokenInvalidator, this.sharedPreferences).execute(successRequestListener, errorRequestListener);
        }
    }

    static /* synthetic */ void lambda$showRateDialog$2(rx.j jVar, View view) {
        jVar.onNext(GenericDialogs.EResponse.CANCEL);
        jVar.onCompleted();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$showRateDialog$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d(Activity activity, rx.j jVar, BaseV7Response baseV7Response) {
        if (!baseV7Response.isOk()) {
            ShowMessage.asSnack(activity, R.string.error_occured);
            jVar.onNext(GenericDialogs.EResponse.CANCEL);
            jVar.onCompleted();
        } else {
            Logger.getInstance().d(TAG, "review added");
            ShowMessage.asSnack(activity, R.string.review_success);
            ManagerPreferences.setForceServerRefreshFlag(true, this.sharedPreferences);
            jVar.onNext(GenericDialogs.EResponse.YES);
            jVar.onCompleted();
        }
    }

    static /* synthetic */ void lambda$showRateDialog$5(Activity activity, rx.j jVar, Throwable th) {
        CrashReport.getInstance().log(th);
        ShowMessage.asSnack(activity, R.string.error_occured);
        jVar.onNext(GenericDialogs.EResponse.CANCEL);
        jVar.onCompleted();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$showRateDialog$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e(final Activity activity, TextInputLayout textInputLayout, AppCompatRatingBar appCompatRatingBar, View view, AlertDialog alertDialog, final rx.j jVar, String str, String str2, View view2) {
        AptoideUtils.SystemU.hideKeyboard(activity);
        String string = textInputLayout.getEditText().getText().toString();
        int iRound = Math.round(appCompatRatingBar.getRating());
        if (iRound == 0) {
            ((TextView) view.findViewById(R.id.tap_to_rate)).setTextColor(activity.getResources().getColor(R.color.red));
            ShowMessage.asSnack(activity, "Please choose a rating");
            return;
        }
        alertDialog.dismiss();
        this.userFeedbackAnalytics.sendSubmitAppRateEvent(!string.isEmpty());
        SuccessRequestListener successRequestListener = new SuccessRequestListener() { // from class: cm.aptoide.pt.view.dialog.d
            @Override // cm.aptoide.pt.dataprovider.interfaces.SuccessRequestListener, rx.m.b
            public final void call(Object obj) {
                this.f8014f.d(activity, jVar, (BaseV7Response) obj);
            }
        };
        ErrorRequestListener errorRequestListener = new ErrorRequestListener() { // from class: cm.aptoide.pt.view.dialog.b
            @Override // cm.aptoide.pt.dataprovider.interfaces.ErrorRequestListener
            public final void onError(Throwable th) {
                DialogUtils.lambda$showRateDialog$5(activity, jVar, th);
            }
        };
        if (str != null) {
            PostReviewRequest.of(str, str2, string, Integer.valueOf(iRound), this.bodyInterceptor, this.httpClient, this.converterFactory, isAppInstalled(str2), this.tokenInvalidator, this.sharedPreferences).execute(successRequestListener, errorRequestListener);
        } else {
            PostReviewRequest.of(str2, string, Integer.valueOf(iRound), this.bodyInterceptor, this.httpClient, this.converterFactory, isAppInstalled(str2), this.tokenInvalidator, this.sharedPreferences).execute(successRequestListener, errorRequestListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$showRateDialog$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(final Activity activity, String str, final String str2, final String str3, final rx.j jVar) {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(activity, this.themeManager.getAttributeForTheme(R.attr.dialogsTheme).resourceId);
        if (!this.accountManager.isLoggedIn()) {
            ShowMessage.asSnack(activity, R.string.you_need_to_be_logged_in, R.string.login, new View.OnClickListener() { // from class: cm.aptoide.pt.view.dialog.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f8028f.a(view);
                }
            }, -1);
            jVar.onNext(GenericDialogs.EResponse.CANCEL);
            jVar.onCompleted();
            return;
        }
        final View viewInflate = LayoutInflater.from(contextThemeWrapper).inflate(R.layout.dialog_rate_app, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.title);
        final AppCompatRatingBar appCompatRatingBar = (AppCompatRatingBar) viewInflate.findViewById(R.id.rating_bar);
        final TextInputLayout textInputLayout = (TextInputLayout) viewInflate.findViewById(R.id.input_layout_review);
        Button button = (Button) viewInflate.findViewById(R.id.cancel_button);
        Button button2 = (Button) viewInflate.findViewById(R.id.rate_button);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.highlighted_reviews_explanation_1);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.highlighted_reviews_explanation_2);
        TextView textView4 = (TextView) viewInflate.findViewById(R.id.highlighted_reviews_explanation_3);
        TextView textView5 = (TextView) viewInflate.findViewById(R.id.highlighted_reviews_explanation_4);
        textView.setText(String.format(this.LOCALE, activity.getString(R.string.rate_app), str));
        final AlertDialog alertDialogCreate = new AlertDialog.Builder(contextThemeWrapper).setView(viewInflate).create();
        jVar.add(rx.t.e.a(new rx.m.a() { // from class: cm.aptoide.pt.view.dialog.n
            @Override // rx.m.a
            public final void call() {
                DialogUtils.lambda$showRateDialog$1(alertDialogCreate);
            }
        }));
        button.setOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.pt.view.dialog.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogUtils.lambda$showRateDialog$2(jVar, view);
            }
        });
        appCompatRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() { // from class: cm.aptoide.pt.view.dialog.k
            @Override // android.widget.RatingBar.OnRatingBarChangeListener
            public final void onRatingChanged(RatingBar ratingBar, float f2, boolean z) {
                ((TextView) viewInflate.findViewById(R.id.tap_to_rate)).setTextColor(activity.getResources().getColor(R.color.grey_fog_dark));
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.pt.view.dialog.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f8030f.e(activity, textInputLayout, appCompatRatingBar, viewInflate, alertDialogCreate, jVar, str2, str3, view);
            }
        });
        textView2.setText(activity.getResources().getString(R.string.reviewappview_highlighted_reviews_explanation_1));
        setBulletText(textView3, activity.getResources().getString(R.string.reviewappview_highlighted_reviews_explanation_2));
        setBulletText(textView4, activity.getResources().getString(R.string.reviewappview_highlighted_reviews_explanation_3));
        setBulletText(textView5, this.marketResourceFormatter.formatString(viewInflate.getContext(), R.string.reviewappview_highlighted_reviews_explanation_4, new String[0]));
        alertDialogCreate.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$showRateDialog$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g(View view) {
        this.accountNavigator.navigateToAccountView(AccountAnalytics.AccountOrigins.RATE_DIALOG);
    }

    public void setBulletText(TextView textView, String str) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new BulletSpan(16, this.themeManager.getAttributeForTheme(R.attr.colorPrimaryDark).data), 0, str.length(), 0);
        textView.setText(spannableString);
    }

    public rx.e<GenericDialogs.EResponse> showRateDialog(final Activity activity, final String str, final String str2, final String str3) {
        return rx.e.l(new rx.e.a() { // from class: cm.aptoide.pt.view.dialog.m
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f8036f.f(activity, str, str3, str2, (rx.j) obj);
            }
        });
    }

    public void showRateDialog(final Activity activity, String str, final String str2, final String str3, final rx.m.a aVar) {
        if (!this.accountManager.isLoggedIn()) {
            ShowMessage.asSnack(activity, R.string.you_need_to_be_logged_in, R.string.login, new View.OnClickListener() { // from class: cm.aptoide.pt.view.dialog.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f8013f.g(view);
                }
            }, -1);
            return;
        }
        View viewInflate = LayoutInflater.from(activity).inflate(R.layout.dialog_rate_app, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.title);
        final AppCompatRatingBar appCompatRatingBar = (AppCompatRatingBar) viewInflate.findViewById(R.id.rating_bar);
        final TextInputLayout textInputLayout = (TextInputLayout) viewInflate.findViewById(R.id.input_layout_review);
        Button button = (Button) viewInflate.findViewById(R.id.cancel_button);
        Button button2 = (Button) viewInflate.findViewById(R.id.rate_button);
        textView.setText(String.format(this.LOCALE, activity.getString(R.string.rate_app), str));
        final AlertDialog alertDialogCreate = new AlertDialog.Builder(activity).setView(viewInflate).create();
        button.setOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.pt.view.dialog.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                alertDialogCreate.dismiss();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.pt.view.dialog.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f8020f.c(activity, textInputLayout, appCompatRatingBar, alertDialogCreate, aVar, str3, str2, view);
            }
        });
        alertDialogCreate.show();
    }
}
