package cm.aptoide.pt.app.view;

import android.content.Intent;
import android.graphics.Rect;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Pair;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import cm.aptoide.aptoideviews.appcoins.BonusAppcView;
import cm.aptoide.aptoideviews.errors.ErrorView;
import cm.aptoide.pt.AptoideApplication;
import cm.aptoide.pt.R;
import cm.aptoide.pt.ads.AdsRepository;
import cm.aptoide.pt.ads.MinimalAdMapper;
import cm.aptoide.pt.app.AppModel;
import cm.aptoide.pt.app.AppReview;
import cm.aptoide.pt.app.DownloadModel;
import cm.aptoide.pt.app.ReviewsViewModel;
import cm.aptoide.pt.app.view.screenshots.ScreenShotClickEvent;
import cm.aptoide.pt.app.view.screenshots.ScreenshotsAdapter;
import cm.aptoide.pt.app.view.similar.SimilarAppClickEvent;
import cm.aptoide.pt.app.view.similar.SimilarAppsBundle;
import cm.aptoide.pt.app.view.similar.SimilarAppsBundleAdapter;
import cm.aptoide.pt.bonus.BonusAppcModel;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.database.RoomStoredMinimalAdPersistence;
import cm.aptoide.pt.dataprovider.WebService;
import cm.aptoide.pt.dataprovider.model.v7.Malware;
import cm.aptoide.pt.dataprovider.model.v7.store.Store;
import cm.aptoide.pt.dataprovider.ws.v7.store.StoreContext;
import cm.aptoide.pt.home.SnapToStartHelper;
import cm.aptoide.pt.install.view.remote.RemoteInstallDialog;
import cm.aptoide.pt.networking.image.ImageLoader;
import cm.aptoide.pt.permission.DialogPermissions;
import cm.aptoide.pt.promotions.Promotion;
import cm.aptoide.pt.promotions.WalletApp;
import cm.aptoide.pt.reviews.LanguageFilterHelper;
import cm.aptoide.pt.search.model.SearchAdResult;
import cm.aptoide.pt.themes.ThemeManager;
import cm.aptoide.pt.util.AppUtils;
import cm.aptoide.pt.util.ReferrerUtils;
import cm.aptoide.pt.utils.AptoideUtils;
import cm.aptoide.pt.utils.GenericDialogs;
import cm.aptoide.pt.utils.q.QManager;
import cm.aptoide.pt.view.app.AppDeveloper;
import cm.aptoide.pt.view.app.AppFlags;
import cm.aptoide.pt.view.app.AppMedia;
import cm.aptoide.pt.view.app.DetailedAppRequestResult;
import cm.aptoide.pt.view.app.FlagsVote;
import cm.aptoide.pt.view.dialog.DialogBadgeV7;
import cm.aptoide.pt.view.dialog.DialogUtils;
import cm.aptoide.pt.view.fragment.NavigationTrackFragment;
import cm.aptoide.pt.view.recycler.LinearLayoutManagerWithSmoothScroller;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.snackbar.Snackbar;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import javax.inject.Named;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import retrofit2.Converter;
import rx.exceptions.OnErrorNotImplementedException;

/* JADX INFO: loaded from: classes.dex */
public class AppViewFragment extends NavigationTrackFragment implements AppViewView {
    private static final int APPC_TRANSITION_MS = 1000;
    private static final String BADGE_DIALOG_TAG = "badgeDialog";
    private static final String KEY_SCROLL_Y = "y";
    private DownloadModel.Action action;
    private androidx.appcompat.app.a actionBar;
    private AdsRepository adsRepository;
    private rx.s.b<String> apkfyDialogConfirmSubject;
    private View apkfyElement;
    private ImageView appIcon;
    private TextView appName;
    private View appcInfoView;
    private View appcMigrationWarningMessage;
    private View appview;
    private ViewStub appviewInstall;
    private TextView avgReviewScore;
    private RatingBar avgReviewScoreBar;
    private BonusAppcView bonusAppcView;
    private boolean bumpedUp;
    private rx.s.b<Void> cancelClickSubject;
    private ImageView cancelDownload;
    private ImageView cancelWalletDownload;
    private View catappultCard;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private Converter.Factory converterFactory;
    private Button descriptionReadMore;
    private TextView descriptionText;

    @Inject
    DialogUtils dialogUtils;
    private View downloadControlsLayout;
    private LinearLayout downloadInfoLayout;
    private ProgressBar downloadProgressBar;
    private TextView downloadProgressValue;
    private ProgressBar downloadWalletProgressBar;
    private TextView downloadWalletProgressValue;
    private TextView downloadsTop;
    private TextView emptyReviewTextView;
    private View emptyReviewsLayout;
    private rx.k errorMessageSubscription;
    private ErrorView errorView;
    private View fakeAppLayout;
    private TextView fakeAppText;
    private View flagThisAppSection;
    private View flagsLayoutWrapper;
    private View goodAppLayoutWrapper;
    private OkHttpClient httpClient;
    private View iabInfo;
    private ImageView iconSizeInfo;
    private View infoEmail;
    private View infoPermissions;
    private View infoPrivacy;
    private View infoWebsite;
    private Button install;
    private rx.s.b<DownloadModel.Action> installClickSubject;
    private TextView installStateText;
    public boolean isEskills;
    private TextView latestVersion;
    private TextView latestVersionTitle;
    private rx.s.b<Void> loginSnackClick;

    @Inject
    @Named
    String marketName;
    private Menu menu;
    private TextView needsLicenceText;
    private View needsLicenseLayout;

    @Inject
    @Named
    DecimalFormat oneDecimalFormat;
    private TextView otherVersions;
    private View otherVersionsTopSeparator;
    private rx.s.b<Void> pauseClickSubject;
    private ImageView pauseDownload;
    private ImageView pauseWalletDownload;
    private View poaBudgetElement;
    private TextView poaBudgetMessage;
    private ImageView poaCoinsIcon;
    private TextView poaCountdownHours;
    private View poaCountdownMessage;
    private TextView poaCountdownMinutes;
    private TextView poaCountdownSeconds;
    private CountDownTimer poaCountdownTimer;
    private DecimalFormat poaFiatDecimalFormat;
    private View poaIabInfo;
    private ViewStub poaInstall;
    private TextView poaOfferValue;

    @Inject
    AppViewPresenter presenter;
    private rx.s.b<PromotionEvent> promotionAppClick;
    private View promotionView;
    private QManager qManager;
    private Button rateAppButton;
    private Button rateAppButtonLarge;
    private TextView ratingInfo;
    private View ratingLayout;
    private rx.s.b<ReadMoreClickEvent> readMoreClick;
    private rx.s.b<DownloadModel.Action> resumeClickSubject;
    private ImageView resumeDownload;
    private ImageView resumeWalletDownload;
    private TextView reviewUsers;
    private TopReviewsAdapter reviewsAdapter;
    private rx.s.b<Integer> reviewsAutoScroll;
    private View reviewsLayout;
    private RecyclerView reviewsView;
    private TextView rewardAppLatestVersion;

    @Inject
    RoomStoredMinimalAdPersistence roomStoredMinimalAdPersistence;
    private rx.s.b<ScreenShotClickEvent> screenShotClick;
    private RecyclerView screenshots;
    private ScreenshotsAdapter screenshotsAdapter;
    private NestedScrollView scrollView;
    private int scrollViewY;
    private Button showAllReviewsButton;
    private rx.s.b<SimilarAppClickEvent> similarAppClick;
    private rx.s.b<Boolean> similarAppsVisibilitySubject;
    private View similarBottomPlaceholder;
    private View similarDownloadPlaceholder;
    private SimilarAppsBundleAdapter similarListAdapter;
    private RecyclerView similarListRecyclerView;
    private TextView sizeInfo;
    private TextView storeDownloads;
    private Button storeFollow;
    private TextView storeFollowers;
    private ImageView storeIcon;
    private View storeLayout;
    private TextView storeName;

    @Inject
    ThemeManager themeManager;
    private Toolbar toolbar;
    private View topReviewsLayout;
    private ContentLoadingProgressBar topReviewsProgress;
    private ImageView trustedBadge;
    private View trustedLayout;
    private TextView trustedText;
    private View versionsLayout;
    private ProgressBar viewProgress;
    private View virusLayout;
    private TextView virusText;
    private View walletDownloadControlsLayout;
    private View walletPromotionButtonsLayout;
    private Button walletPromotionCancelButton;
    private Button walletPromotionClaimButton;
    private View walletPromotionClaimLayout;
    private Button walletPromotionDownloadButton;
    private View walletPromotionDownloadLayout;
    private ImageView walletPromotionIcon;
    private Button walletPromotionInstallDisableButton;
    private View walletPromotionInstallDisableLayout;
    private TextView walletPromotionMessage;
    private TextView walletPromotionTitle;
    private View workingWellLayout;
    private TextView workingWellText;

    /* JADX INFO: renamed from: cm.aptoide.pt.app.view.AppViewFragment$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action;
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$app$DownloadModel$DownloadState;
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Malware$Rank;
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$view$app$DetailedAppRequestResult$Error;
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$view$app$FlagsVote$VoteType;

        static {
            int[] iArr = new int[DownloadModel.Action.values().length];
            $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action = iArr;
            try {
                iArr[DownloadModel.Action.UPDATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action[DownloadModel.Action.INSTALL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action[DownloadModel.Action.OPEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action[DownloadModel.Action.DOWNGRADE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action[DownloadModel.Action.MIGRATE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[Malware.Rank.values().length];
            $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Malware$Rank = iArr2;
            try {
                iArr2[Malware.Rank.TRUSTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Malware$Rank[Malware.Rank.WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Malware$Rank[Malware.Rank.CRITICAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Malware$Rank[Malware.Rank.UNKNOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            int[] iArr3 = new int[DownloadModel.DownloadState.values().length];
            $SwitchMap$cm$aptoide$pt$app$DownloadModel$DownloadState = iArr3;
            try {
                iArr3[DownloadModel.DownloadState.ACTIVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$app$DownloadModel$DownloadState[DownloadModel.DownloadState.INDETERMINATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$app$DownloadModel$DownloadState[DownloadModel.DownloadState.PAUSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$app$DownloadModel$DownloadState[DownloadModel.DownloadState.COMPLETE.ordinal()] = 4;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$app$DownloadModel$DownloadState[DownloadModel.DownloadState.ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$app$DownloadModel$DownloadState[DownloadModel.DownloadState.INSTALLING.ordinal()] = 6;
            } catch (NoSuchFieldError unused15) {
            }
            int[] iArr4 = new int[FlagsVote.VoteType.values().length];
            $SwitchMap$cm$aptoide$pt$view$app$FlagsVote$VoteType = iArr4;
            try {
                iArr4[FlagsVote.VoteType.GOOD.ordinal()] = 1;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$view$app$FlagsVote$VoteType[FlagsVote.VoteType.LICENSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$view$app$FlagsVote$VoteType[FlagsVote.VoteType.FAKE.ordinal()] = 3;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$view$app$FlagsVote$VoteType[FlagsVote.VoteType.VIRUS.ordinal()] = 4;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$view$app$FlagsVote$VoteType[FlagsVote.VoteType.FREEZE.ordinal()] = 5;
            } catch (NoSuchFieldError unused20) {
            }
            int[] iArr5 = new int[DetailedAppRequestResult.Error.values().length];
            $SwitchMap$cm$aptoide$pt$view$app$DetailedAppRequestResult$Error = iArr5;
            try {
                iArr5[DetailedAppRequestResult.Error.NETWORK.ordinal()] = 1;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$view$app$DetailedAppRequestResult$Error[DetailedAppRequestResult.Error.GENERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused22) {
            }
        }
    }

    public enum BundleKeys {
        APP_ID,
        STORE_NAME,
        STORE_THEME,
        MINIMAL_AD,
        PACKAGE_NAME,
        SHOULD_INSTALL,
        MD5,
        UNAME,
        DOWNLOAD_CONVERSION_URL,
        APPC,
        EDITORS_CHOICE_POSITION,
        ORIGIN_TAG,
        OEM_ID
    }

    public enum OpenType {
        OPEN_ONLY,
        OPEN_AND_INSTALL,
        OPEN_WITH_INSTALL_POPUP,
        APK_FY_INSTALL_POPUP
    }

    private void applyCount(FlagsVote.VoteType voteType, int i2) {
        String string = Integer.toString(i2);
        int i3 = AnonymousClass2.$SwitchMap$cm$aptoide$pt$view$app$FlagsVote$VoteType[voteType.ordinal()];
        if (i3 == 1) {
            this.workingWellText.setText(NumberFormat.getIntegerInstance().format(Double.parseDouble(string)));
            return;
        }
        if (i3 == 2) {
            this.needsLicenceText.setText(NumberFormat.getIntegerInstance().format(Double.parseDouble(string)));
            return;
        }
        if (i3 == 3) {
            this.fakeAppText.setText(NumberFormat.getIntegerInstance().format(Double.parseDouble(string)));
            return;
        }
        if (i3 == 4) {
            this.virusText.setText(NumberFormat.getIntegerInstance().format(Double.parseDouble(string)));
        } else {
            if (i3 == 5) {
                return;
            }
            throw new IllegalArgumentException("Unable to find Type " + voteType.name());
        }
    }

    private rx.e<GenericDialogs.EResponse> createCustomDialogForApkfy(final String str, final double d2, final float f2, final String str2, final int i2) {
        return rx.e.l(new rx.e.a() { // from class: cm.aptoide.pt.app.view.i
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f4348f.f(str, f2, d2, i2, str2, (rx.j) obj);
            }
        });
    }

    private SpannableString formatAppCoinsRewardMessage(String str) {
        String string;
        SpannableString spannableString;
        if (str.equals("-1.0")) {
            string = getResources().getString(R.string.appc_message_appview_appcoins_reward, "AppCoins Credits");
            spannableString = new SpannableString(string);
        } else {
            string = getResources().getString(R.string.appc_message_appview_appcoins_reward_with_value, str, "AppCoins Credits");
            spannableString = new SpannableString(string);
            spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.default_orange_gradient_end)), string.indexOf(str), string.indexOf(str) + str.length(), 33);
        }
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.default_orange_gradient_end)), string.indexOf("AppCoins Credits"), string.indexOf("AppCoins Credits") + 16, 33);
        return spannableString;
    }

    private int getPromotionMessage(DownloadModel downloadModel) {
        return (downloadModel.getAction().equals(DownloadModel.Action.MIGRATE) || downloadModel.getAction().equals(DownloadModel.Action.UPDATE)) ? R.string.wallet_promotion_wallet_installed_update_message : R.string.wallet_promotion_wallet_notinstalled_message;
    }

    private void handleDownloadError(DownloadModel.DownloadState downloadState) {
        if (downloadState == DownloadModel.DownloadState.ERROR) {
            showGenericErrorDialog();
            return;
        }
        throw new IllegalStateException("Invalid Download State " + downloadState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$createCustomDialogForApkfy$47, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e(rx.j jVar, String str, androidx.appcompat.app.c cVar, View view) {
        jVar.onNext(GenericDialogs.EResponse.YES);
        this.apkfyDialogConfirmSubject.onNext(str);
        jVar.onCompleted();
        cVar.dismiss();
    }

    static /* synthetic */ void lambda$createCustomDialogForApkfy$48(rx.j jVar, View view) {
        jVar.onNext(GenericDialogs.EResponse.CANCEL);
        jVar.onCompleted();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$createCustomDialogForApkfy$49, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(final String str, float f2, double d2, int i2, String str2, final rx.j jVar) {
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.apkfy_new_dialog, (ViewGroup) null);
        final androidx.appcompat.app.c cVarA = new androidx.appcompat.app.c.a(getContext()).w(viewInflate).a();
        ((TextView) viewInflate.findViewById(R.id.app_name)).setText(str);
        ((TextView) viewInflate.findViewById(R.id.app_rating)).setText(this.oneDecimalFormat.format(f2));
        if (d2 > 0.0d) {
            ((TextView) viewInflate.findViewById(R.id.appc_value)).setText(new DecimalFormat("0.00").format(d2));
        } else {
            viewInflate.findViewById(R.id.appc_layout).setVisibility(8);
        }
        ((TextView) viewInflate.findViewById(R.id.app_downloads)).setText(String.format("%s %s", AptoideUtils.StringU.withSuffix(i2), getResources().getString(R.string.downloads)));
        ImageLoader.with(getContext()).load(str2, (ImageView) viewInflate.findViewById(R.id.app_icon));
        viewInflate.findViewById(R.id.positive_button).setOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.pt.app.view.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f4186f.e(jVar, str, cVarA, view);
            }
        });
        viewInflate.findViewById(R.id.negative_button).setOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.pt.app.view.x0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppViewFragment.lambda$createCustomDialogForApkfy$48(jVar, view);
            }
        });
        cVarA.getClass();
        jVar.add(rx.t.e.a(new rx.m.a() { // from class: cm.aptoide.pt.app.view.a
            @Override // rx.m.a
            public final void call() {
                cVarA.dismiss();
            }
        }));
        cVarA.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$displayNotLoggedInSnack$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g(View view) {
        this.loginSnackClick.onNext(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$extractReferrer$14, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h(SearchAdResult searchAdResult) {
        ReferrerUtils.extractReferrer(searchAdResult, 2, false, this.adsRepository, this.httpClient, this.converterFactory, this.qManager, getContext().getApplicationContext(), ((AptoideApplication) getContext().getApplicationContext()).getDefaultSharedPreferences(), new MinimalAdMapper(), this.roomStoredMinimalAdPersistence);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$installAppClick$41, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ DownloadModel.Action i(DownloadModel.Action action) {
        return this.action;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$onViewCreated$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j(View view) {
        this.installClickSubject.onNext(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$onViewCreated$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k(View view) {
        this.resumeClickSubject.onNext(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$onViewCreated$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void l(View view) {
        this.cancelClickSubject.onNext(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$onViewCreated$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void m(View view) {
        this.pauseClickSubject.onNext(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$onViewCreated$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n(ViewStub viewStub, View view) {
        this.install = (Button) view.findViewById(R.id.appview_install_button);
        this.downloadInfoLayout = (LinearLayout) view.findViewById(R.id.appview_transfer_info);
        this.downloadProgressBar = (ProgressBar) view.findViewById(R.id.appview_download_progress_bar);
        this.downloadProgressValue = (TextView) view.findViewById(R.id.appview_download_progress_number);
        this.cancelDownload = (ImageView) view.findViewById(R.id.appview_download_cancel_button);
        this.resumeDownload = (ImageView) view.findViewById(R.id.appview_download_resume_download);
        this.pauseDownload = (ImageView) view.findViewById(R.id.appview_download_pause_download);
        this.installStateText = (TextView) view.findViewById(R.id.appview_download_download_state);
        this.downloadControlsLayout = view.findViewById(R.id.install_controls_layout);
        this.install.setOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.pt.app.view.c0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f4232f.j(view2);
            }
        });
        this.resumeDownload.setOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.pt.app.view.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f4379f.k(view2);
            }
        });
        this.cancelDownload.setOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.pt.app.view.s0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f4557f.l(view2);
            }
        });
        this.pauseDownload.setOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.pt.app.view.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f4642f.m(view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$onViewCreated$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void o(View view, AppBarLayout appBarLayout, int i2) {
        float fAbs = Math.abs(i2) / appBarLayout.getTotalScrollRange();
        float f2 = 1.0f - (1.2f * fAbs);
        view.findViewById(R.id.app_icon).setAlpha(f2);
        view.findViewById(R.id.app_name).setAlpha(f2);
        this.bonusAppcView.setAlpha(f2);
        BonusAppcView bonusAppcView = this.bonusAppcView;
        bonusAppcView.setTranslationX((-(1.15f * fAbs)) * bonusAppcView.getMeasuredWidth());
        ((ToolbarArcBackground) view.findViewById(R.id.toolbar_background_arc)).setScale(fAbs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$recoverScrollViewState$15, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void p() {
        NestedScrollView nestedScrollView = this.scrollView;
        if (nestedScrollView != null) {
            nestedScrollView.scrollTo(0, this.scrollViewY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$resumeDownload$44, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ DownloadModel.Action q(DownloadModel.Action action) {
        return this.action;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$scrollVisibleSimilarApps$11, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Boolean r(e.g.a.c.f fVar) {
        return Boolean.valueOf(isSimilarAppsVisible());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setReadMoreClickListener$40, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void s(String str, AppMedia appMedia, Store store, boolean z, View view) {
        this.readMoreClick.onNext(new ReadMoreClickEvent(str, appMedia.getDescription(), store.getAppearance().getTheme(), z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setupActiveWalletPromotion$35, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void t(Promotion promotion, WalletApp walletApp, View view) {
        this.promotionAppClick.onNext(new PromotionEvent(promotion, walletApp, PromotionEvent.ClickType.PAUSE_DOWNLOAD));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setupActiveWalletPromotion$36, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void u(Promotion promotion, WalletApp walletApp, View view) {
        this.promotionAppClick.onNext(new PromotionEvent(promotion, walletApp, PromotionEvent.ClickType.PAUSE_DOWNLOAD));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setupActiveWalletPromotion$37, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void v(Promotion promotion, WalletApp walletApp, View view) {
        this.promotionAppClick.onNext(new PromotionEvent(promotion, walletApp, PromotionEvent.ClickType.CANCEL_DOWNLOAD));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setupActiveWalletPromotion$38, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w(Promotion promotion, WalletApp walletApp, View view) {
        this.promotionAppClick.onNext(new PromotionEvent(promotion, walletApp, PromotionEvent.ClickType.RESUME_DOWNLOAD));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setupActiveWalletPromotion$39, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void x(Promotion promotion, WalletApp walletApp, View view) {
        this.promotionAppClick.onNext(new PromotionEvent(promotion, walletApp, PromotionEvent.ClickType.PAUSE_DOWNLOAD));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setupClaimWalletPromotion$33, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void y(Promotion promotion, WalletApp walletApp, View view) {
        this.promotionAppClick.onNext(new PromotionEvent(promotion, walletApp, PromotionEvent.ClickType.CLAIM));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setupInactiveWalletPromotion$34, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void z(Promotion promotion, WalletApp walletApp, View view) {
        this.promotionAppClick.onNext(new PromotionEvent(promotion, walletApp, PromotionEvent.ClickType.INSTALL_APP));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$showAppcWalletPromotionView$20, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void A(Promotion promotion, WalletApp walletApp, View view) {
        this.promotionAppClick.onNext(new PromotionEvent(promotion, walletApp, PromotionEvent.ClickType.DISMISS));
    }

    static /* synthetic */ void lambda$showErrorDialog$45(GenericDialogs.EResponse eResponse) {
    }

    static /* synthetic */ void lambda$showErrorDialog$46(Throwable th) {
        new OnErrorNotImplementedException(th);
    }

    static /* synthetic */ Void lambda$showOpenAndInstallApkFyDialog$19(GenericDialogs.EResponse eResponse) {
        return null;
    }

    static /* synthetic */ Void lambda$showOpenAndInstallDialog$17(GenericDialogs.EResponse eResponse) {
        return null;
    }

    static /* synthetic */ void lambda$showShareOnTvDialog$12(GenericDialogs.EResponse eResponse) {
    }

    private void manageSimilarAppsVisibility(boolean z, boolean z2) {
        if (this.bumpedUp) {
            return;
        }
        if (z2) {
            this.bumpedUp = true;
        }
        if (!z) {
            hideSimilarApps();
            return;
        }
        this.similarListRecyclerView.setVisibility(0);
        LinearLayout linearLayout = (LinearLayout) this.similarListRecyclerView.getParent();
        if (!z2) {
            linearLayout.removeView(this.similarListRecyclerView);
            LinearLayout linearLayout2 = (LinearLayout) this.similarBottomPlaceholder.getParent();
            linearLayout2.addView(this.similarListRecyclerView, linearLayout2.indexOfChild(this.similarBottomPlaceholder));
            return;
        }
        linearLayout.removeView(this.similarListRecyclerView);
        LinearLayout linearLayout3 = (LinearLayout) this.similarDownloadPlaceholder.getParent();
        linearLayout3.addView(this.similarListRecyclerView, linearLayout3.indexOfChild(this.similarDownloadPlaceholder));
        this.similarAppsVisibilitySubject.onNext(Boolean.TRUE);
    }

    private void setAppFlags(boolean z, AppFlags appFlags) {
        if (z) {
            this.goodAppLayoutWrapper.setVisibility(0);
            this.flagsLayoutWrapper.setVisibility(8);
        } else {
            this.goodAppLayoutWrapper.setVisibility(8);
            this.flagsLayoutWrapper.setVisibility(0);
            setFlagValues(appFlags);
        }
    }

    private void setButtonText(DownloadModel downloadModel) {
        int i2 = AnonymousClass2.$SwitchMap$cm$aptoide$pt$app$DownloadModel$Action[downloadModel.getAction().ordinal()];
        if (i2 == 1) {
            this.install.setText(getResources().getString(R.string.appview_button_update));
            return;
        }
        if (i2 == 2) {
            this.install.setText(getResources().getString(R.string.appview_button_install));
            return;
        }
        if (i2 == 3) {
            this.install.setText(getResources().getString(R.string.appview_button_open));
        } else if (i2 == 4) {
            this.install.setText(getResources().getString(R.string.appview_button_downgrade));
        } else {
            if (i2 != 5) {
                return;
            }
            this.install.setText(getResources().getString(R.string.promo_update2appc_appview_update_button));
        }
    }

    private void setCountdownTimer(String str) {
        long time;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final DecimalFormat decimalFormat = new DecimalFormat("00");
        simpleDateFormat.setLenient(false);
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            time = simpleDateFormat.parse(str).getTime();
        } catch (ParseException e2) {
            e2.printStackTrace();
            time = 0;
        }
        long j2 = time - jCurrentTimeMillis;
        this.poaCountdownHours.setText(decimalFormat.format(0L));
        this.poaCountdownMinutes.setText(decimalFormat.format(0L));
        this.poaCountdownSeconds.setText(decimalFormat.format(0L));
        if (j2 >= 0) {
            this.poaCountdownTimer = new CountDownTimer(j2, 1000L) { // from class: cm.aptoide.pt.app.view.AppViewFragment.1
                @Override // android.os.CountDownTimer
                public void onFinish() {
                }

                @Override // android.os.CountDownTimer
                public void onTick(long j3) {
                    AppViewFragment.this.poaCountdownHours.setText(decimalFormat.format(j3 / 3600000));
                    AppViewFragment.this.poaCountdownMinutes.setText(decimalFormat.format((j3 % 3600000) / 60000));
                    AppViewFragment.this.poaCountdownSeconds.setText(decimalFormat.format(((j3 % 360000) % 60000) / 1000));
                }
            }.start();
        }
    }

    private void setDescription(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.descriptionText.setText(AptoideUtils.HtmlU.parse(str));
        } else {
            this.descriptionText.setText(R.string.description_not_available);
            this.descriptionReadMore.setVisibility(8);
        }
    }

    private void setDeveloperDetails(AppDeveloper appDeveloper) {
        if (TextUtils.isEmpty(appDeveloper.getWebsite())) {
            this.infoWebsite.setVisibility(8);
        } else {
            this.infoWebsite.setVisibility(0);
        }
        if (TextUtils.isEmpty(appDeveloper.getEmail())) {
            this.infoEmail.setVisibility(8);
        } else {
            this.infoEmail.setVisibility(0);
        }
        if (TextUtils.isEmpty(appDeveloper.getPrivacy())) {
            this.infoPrivacy.setVisibility(8);
        } else {
            this.infoPrivacy.setVisibility(0);
        }
    }

    private void setDownloadState(int i2, DownloadModel.DownloadState downloadState, long j2, boolean z) {
        String bytes = AptoideUtils.StringU.formatBytes(j2, false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1, 4.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1, 2.0f);
        int i3 = AnonymousClass2.$SwitchMap$cm$aptoide$pt$app$DownloadModel$DownloadState[downloadState.ordinal()];
        if (i3 == 1) {
            this.downloadProgressBar.setIndeterminate(false);
            this.downloadProgressBar.setProgress(i2);
            if (z) {
                this.downloadProgressValue.setText(i2 + "% of " + bytes);
            } else {
                this.downloadProgressValue.setText(i2 + "%");
            }
            this.downloadProgressValue.setVisibility(0);
            this.pauseDownload.setVisibility(0);
            this.cancelDownload.setVisibility(8);
            this.resumeDownload.setVisibility(8);
            this.downloadControlsLayout.setVisibility(0);
            this.downloadControlsLayout.setLayoutParams(layoutParams);
            this.installStateText.setText(getString(R.string.appview_short_downloading));
            return;
        }
        if (i3 == 2) {
            this.downloadProgressBar.setIndeterminate(true);
            this.pauseDownload.setVisibility(0);
            this.downloadProgressValue.setVisibility(8);
            this.cancelDownload.setVisibility(8);
            this.resumeDownload.setVisibility(8);
            this.downloadControlsLayout.setVisibility(0);
            this.downloadControlsLayout.setLayoutParams(layoutParams);
            this.installStateText.setText(getString(R.string.appview_short_downloading));
            return;
        }
        if (i3 != 3) {
            if (i3 == 4) {
                this.downloadProgressBar.setIndeterminate(true);
                this.pauseDownload.setVisibility(0);
                this.downloadProgressValue.setVisibility(8);
                this.cancelDownload.setVisibility(8);
                this.resumeDownload.setVisibility(8);
                this.downloadControlsLayout.setVisibility(0);
                this.downloadControlsLayout.setLayoutParams(layoutParams);
                this.installStateText.setText(getString(R.string.appview_short_downloading));
                return;
            }
            if (i3 != 6) {
                return;
            }
            this.downloadProgressBar.setIndeterminate(true);
            this.pauseDownload.setVisibility(8);
            this.downloadProgressValue.setVisibility(8);
            this.cancelDownload.setVisibility(8);
            this.resumeDownload.setVisibility(8);
            this.downloadControlsLayout.setVisibility(8);
            this.installStateText.setText(getString(R.string.appview_short_installing));
            return;
        }
        this.downloadProgressBar.setIndeterminate(false);
        this.downloadProgressBar.setProgress(i2);
        if (z) {
            this.downloadProgressValue.setText(i2 + "% of " + bytes);
        } else {
            this.downloadProgressValue.setText(i2 + "%");
        }
        this.downloadProgressValue.setVisibility(0);
        this.pauseDownload.setVisibility(8);
        this.cancelDownload.setVisibility(0);
        this.resumeDownload.setVisibility(0);
        this.downloadControlsLayout.setVisibility(0);
        this.downloadControlsLayout.setLayoutParams(layoutParams2);
        this.installStateText.setText(getString(R.string.appview_short_downloading));
    }

    private void setFlagValues(AppFlags appFlags) {
        if (appFlags != null) {
            try {
                if (appFlags.getVotes() == null || appFlags.getVotes().isEmpty()) {
                    return;
                }
                for (FlagsVote flagsVote : appFlags.getVotes()) {
                    applyCount(flagsVote.getVoteType(), flagsVote.getCount());
                }
            } catch (NullPointerException e2) {
                CrashReport.getInstance().log(e2);
            }
        }
    }

    private void setReadMoreClickListener(final String str, final AppMedia appMedia, final Store store, final boolean z) {
        this.descriptionReadMore.setOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.pt.app.view.a1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f4190f.s(str, appMedia, store, z, view);
            }
        });
    }

    private void setSimilarAppsAdapters() {
        SimilarAppsBundleAdapter similarAppsBundleAdapter = new SimilarAppsBundleAdapter(new ArrayList(), this.oneDecimalFormat, this.similarAppClick);
        this.similarListAdapter = similarAppsBundleAdapter;
        this.similarListRecyclerView.setAdapter(similarAppsBundleAdapter);
    }

    private void setTrustedBadge(Malware malware) {
        int i2;
        int i3;
        int i4 = AnonymousClass2.$SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Malware$Rank[(malware.getRank() == null ? Malware.Rank.UNKNOWN : malware.getRank()).ordinal()];
        if (i4 == 1) {
            i2 = R.drawable.ic_badges_trusted;
            i3 = R.string.appview_header_trusted_text;
        } else if (i4 == 2) {
            i2 = R.drawable.ic_badges_warning;
            i3 = R.string.warning;
        } else if (i4 != 3) {
            i2 = R.drawable.ic_badges_unknown;
            i3 = R.string.unknown;
        } else {
            i2 = R.drawable.ic_badges_critical;
            i3 = R.string.critical;
        }
        this.trustedBadge.setImageDrawable(androidx.core.content.a.f(getContext(), i2));
        this.trustedText.setText(i3);
    }

    private void setupActiveWalletPromotion(final Promotion promotion, final WalletApp walletApp, DownloadModel downloadModel) {
        setupWalletPromotionText(promotion, getPromotionMessage(downloadModel));
        this.walletPromotionDownloadLayout.setVisibility(0);
        this.walletPromotionButtonsLayout.setVisibility(8);
        this.walletPromotionIcon.setVisibility(0);
        DownloadModel.DownloadState downloadState = walletApp.getDownloadModel().getDownloadState();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1, 4.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1, 2.0f);
        int i2 = AnonymousClass2.$SwitchMap$cm$aptoide$pt$app$DownloadModel$DownloadState[downloadState.ordinal()];
        if (i2 == 1) {
            this.downloadWalletProgressBar.setIndeterminate(false);
            this.downloadWalletProgressBar.setProgress(walletApp.getDownloadModel().getProgress());
            this.downloadWalletProgressValue.setText(walletApp.getDownloadModel().getProgress() + "%");
            this.pauseWalletDownload.setVisibility(0);
            this.pauseWalletDownload.setOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.pt.app.view.z0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f4707f.t(promotion, walletApp, view);
                }
            });
            this.cancelWalletDownload.setVisibility(8);
            this.resumeWalletDownload.setVisibility(8);
            this.walletDownloadControlsLayout.setLayoutParams(layoutParams);
            return;
        }
        if (i2 == 2) {
            this.downloadWalletProgressBar.setIndeterminate(true);
            this.pauseWalletDownload.setVisibility(0);
            this.pauseWalletDownload.setOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.pt.app.view.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f4520f.u(promotion, walletApp, view);
                }
            });
            this.cancelWalletDownload.setVisibility(8);
            this.resumeWalletDownload.setVisibility(8);
            this.walletDownloadControlsLayout.setLayoutParams(layoutParams);
            return;
        }
        if (i2 != 3) {
            if (i2 != 4) {
                if (i2 != 5) {
                    return;
                }
                showErrorDialog(HttpUrl.FRAGMENT_ENCODE_SET, getContext().getString(R.string.error_occured));
                return;
            } else {
                this.downloadWalletProgressBar.setIndeterminate(true);
                this.pauseWalletDownload.setVisibility(0);
                this.pauseWalletDownload.setOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.pt.app.view.o0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f4481f.x(promotion, walletApp, view);
                    }
                });
                this.cancelWalletDownload.setVisibility(8);
                this.resumeWalletDownload.setVisibility(8);
                this.walletDownloadControlsLayout.setLayoutParams(layoutParams);
                return;
            }
        }
        this.downloadWalletProgressBar.setIndeterminate(false);
        this.downloadWalletProgressBar.setProgress(walletApp.getDownloadModel().getProgress());
        this.downloadWalletProgressValue.setText(walletApp.getDownloadModel().getProgress() + "%");
        this.pauseWalletDownload.setVisibility(8);
        this.cancelWalletDownload.setVisibility(0);
        this.cancelWalletDownload.setOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.pt.app.view.b0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f4211f.v(promotion, walletApp, view);
            }
        });
        this.resumeWalletDownload.setVisibility(0);
        this.resumeWalletDownload.setOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.pt.app.view.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f4704f.w(promotion, walletApp, view);
            }
        });
        this.walletDownloadControlsLayout.setLayoutParams(layoutParams2);
    }

    private void setupClaimWalletPromotion(final Promotion promotion, final WalletApp walletApp) {
        setupWalletPromotionText(promotion, R.string.wallet_promotion_wallet_claim_message);
        this.walletPromotionClaimButton.setText(String.format(getString(R.string.wallet_promotion_button_claim), Float.valueOf(promotion.getAppc())));
        this.walletPromotionDownloadLayout.setVisibility(8);
        this.walletPromotionInstallDisableLayout.setVisibility(8);
        this.walletPromotionButtonsLayout.setVisibility(8);
        this.walletPromotionClaimLayout.setVisibility(0);
        this.walletPromotionClaimButton.setOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.pt.app.view.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f4582f.y(promotion, walletApp, view);
            }
        });
        this.walletPromotionIcon.setVisibility(0);
    }

    private void setupInactiveWalletPromotion(final Promotion promotion, final WalletApp walletApp, DownloadModel downloadModel) {
        setupWalletPromotionText(promotion, getPromotionMessage(downloadModel));
        this.walletPromotionDownloadLayout.setVisibility(8);
        this.walletPromotionInstallDisableLayout.setVisibility(8);
        this.walletPromotionClaimLayout.setVisibility(8);
        this.walletPromotionButtonsLayout.setVisibility(0);
        this.walletPromotionIcon.setVisibility(0);
        this.walletPromotionDownloadButton.setOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.pt.app.view.d0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f4250f.z(promotion, walletApp, view);
            }
        });
    }

    private void setupInstallDependencyApp(Promotion promotion, DownloadModel downloadModel) {
        setupWalletPromotionText(promotion, (downloadModel.getAction() == DownloadModel.Action.MIGRATE || downloadModel.getAction() == DownloadModel.Action.UPDATE) ? R.string.wallet_promotion_wallet_installed_update_message : R.string.wallet_promotion_wallet_installed_message);
        this.walletPromotionInstallDisableButton.setText(String.format(getString(R.string.wallet_promotion_button_install_disabled), Float.valueOf(promotion.getAppc())));
        this.walletPromotionInstallDisableLayout.setVisibility(0);
        this.walletPromotionDownloadLayout.setVisibility(8);
        this.walletPromotionButtonsLayout.setVisibility(8);
        this.walletPromotionClaimLayout.setVisibility(8);
        this.walletPromotionIcon.setImageResource(R.drawable.ic_promotion_coins);
    }

    private void setupWalletPromotionText(Promotion promotion, int i2) {
        this.walletPromotionTitle.setText(String.format(getString(R.string.wallet_promotion_title), Float.valueOf(promotion.getAppc())));
        this.walletPromotionMessage.setText(String.format(getString(i2), Float.valueOf(promotion.getAppc())));
    }

    private void showAppViewLayout() {
        this.appview.setVisibility(0);
        this.viewProgress.setVisibility(8);
        this.errorView.setVisibility(8);
    }

    private void showAppcInfo(boolean z, boolean z2, double d2, double d3, String str, double d4, String str2) {
        if (z) {
            String str3 = str + this.poaFiatDecimalFormat.format(d3);
            this.appcInfoView.setVisibility(0);
            this.poaOfferValue.setText(String.format(getResources().getString(R.string.poa_app_view_card_body_2), Double.valueOf(d2), str3));
            if (!str2.equals(HttpUrl.FRAGMENT_ENCODE_SET)) {
                this.poaCountdownMessage.setVisibility(0);
                setCountdownTimer(str2);
            } else if (d4 != -1.0d) {
                this.poaBudgetElement.setVisibility(0);
                this.poaBudgetMessage.setText(String.format(getResources().getString(R.string.poa_APPCC_left_body), Integer.valueOf((int) (d4 / d2))));
            }
            if (z2) {
                this.poaIabInfo.setVisibility(0);
            }
        }
    }

    private void showErrorDialog(String str, String str2) {
        this.errorMessageSubscription = GenericDialogs.createGenericOkMessage(getContext(), str, str2, this.themeManager.getAttributeForTheme(R.attr.dialogsTheme).resourceId).I0(rx.l.c.a.b()).H0(new rx.m.b() { // from class: cm.aptoide.pt.app.view.x
            @Override // rx.m.b
            public final void call(Object obj) {
                AppViewFragment.lambda$showErrorDialog$45((GenericDialogs.EResponse) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.app.view.t0
            @Override // rx.m.b
            public final void call(Object obj) {
                AppViewFragment.lambda$showErrorDialog$46((Throwable) obj);
            }
        });
    }

    private void showHideOptionsMenu(boolean z) {
        for (int i2 = 0; i2 < this.menu.size(); i2++) {
            showHideOptionsMenu(this.menu.getItem(i2), z);
        }
    }

    private void showReviews(boolean z, int i2, float f2) {
        this.topReviewsProgress.setVisibility(8);
        this.reviewUsers.setText(AptoideUtils.StringU.withSuffix(i2));
        if (f2 == 0.0f) {
            this.avgReviewScore.setText(R.string.appcardview_title_no_stars);
        } else {
            this.avgReviewScore.setText(String.format(Locale.getDefault(), "%.1f", Float.valueOf(f2)));
        }
        this.avgReviewScoreBar.setRating(f2);
        if (z) {
            this.ratingLayout.setVisibility(0);
            this.emptyReviewsLayout.setVisibility(8);
            this.topReviewsLayout.setVisibility(0);
            this.rateAppButtonLarge.setVisibility(8);
            this.rateAppButton.setVisibility(0);
            return;
        }
        this.ratingLayout.setVisibility(0);
        this.emptyReviewsLayout.setVisibility(0);
        this.topReviewsLayout.setVisibility(8);
        this.rateAppButtonLarge.setVisibility(0);
        this.rateAppButton.setVisibility(8);
        if (i2 == 0) {
            this.emptyReviewTextView.setText(R.string.appview_rate_this_app);
        }
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public rx.e<String> apkfyDialogPositiveClick() {
        return this.apkfyDialogConfirmSubject;
    }

    @Override // cm.aptoide.pt.appview.InstallAppView
    public rx.e<Void> cancelDownload() {
        return this.cancelClickSubject;
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public rx.e<WalletApp> cancelPromotionDownload() {
        return this.promotionAppClick.D(new rx.m.e() { // from class: cm.aptoide.pt.app.view.y
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((PromotionEvent) obj).getClickType() == PromotionEvent.ClickType.CANCEL_DOWNLOAD);
            }
        }).X(new rx.m.e() { // from class: cm.aptoide.pt.app.view.l0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return ((PromotionEvent) obj).getWallet();
            }
        });
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public rx.e<Promotion> claimAppClick() {
        return this.promotionAppClick.D(new rx.m.e() { // from class: cm.aptoide.pt.app.view.n0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((PromotionEvent) obj).getClickType() == PromotionEvent.ClickType.CLAIM);
            }
        }).X(new rx.m.e() { // from class: cm.aptoide.pt.app.view.r0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return ((PromotionEvent) obj).getPromotion();
            }
        });
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public rx.e<Void> clickBonusAppcFlair() {
        return e.g.a.c.a.a(this.bonusAppcView);
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public rx.e<Void> clickCatappultCard() {
        return e.g.a.c.a.a(this.catappultCard);
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public rx.e<Void> clickDeveloperEmail() {
        return e.g.a.c.a.a(this.infoEmail);
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public rx.e<Void> clickDeveloperPermissions() {
        return e.g.a.c.a.a(this.infoPermissions);
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public rx.e<Void> clickDeveloperPrivacy() {
        return e.g.a.c.a.a(this.infoPrivacy);
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public rx.e<Void> clickDeveloperWebsite() {
        return e.g.a.c.a.a(this.infoWebsite);
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public rx.e<Void> clickErrorRetry() {
        return this.errorView.retryClick();
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public rx.e<FlagsVote.VoteType> clickFakeFlag() {
        return e.g.a.c.a.a(this.fakeAppLayout).G(new rx.m.e() { // from class: cm.aptoide.pt.app.view.h0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return rx.e.S(FlagsVote.VoteType.FAKE);
            }
        });
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public rx.e<Void> clickFollowStore() {
        return e.g.a.c.a.a(this.storeFollow);
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public rx.e<Void> clickGetAppcInfo() {
        return e.g.a.c.a.a(this.poaCoinsIcon);
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public rx.e<FlagsVote.VoteType> clickLicenseFlag() {
        return e.g.a.c.a.a(this.needsLicenseLayout).G(new rx.m.e() { // from class: cm.aptoide.pt.app.view.l
            @Override // rx.m.e
            public final Object call(Object obj) {
                return rx.e.S(FlagsVote.VoteType.LICENSE);
            }
        });
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public rx.e<Void> clickLoginSnack() {
        return this.loginSnackClick;
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public rx.e<Void> clickOtherVersions() {
        return e.g.a.c.a.a(this.otherVersions);
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public rx.e<Void> clickRateApp() {
        return e.g.a.c.a.a(this.rateAppButton);
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public rx.e<Void> clickRateAppLarge() {
        return e.g.a.c.a.a(this.rateAppButtonLarge);
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public rx.e<Void> clickRateAppLayout() {
        return e.g.a.c.a.a(this.ratingLayout);
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public rx.e<Void> clickReadAllReviews() {
        return e.g.a.c.a.a(this.showAllReviewsButton);
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public rx.e<Void> clickReviewsLayout() {
        return e.g.a.c.a.a(this.topReviewsLayout);
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public rx.e<SimilarAppClickEvent> clickSimilarApp() {
        return this.similarAppClick;
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public rx.e<Void> clickStoreLayout() {
        return e.g.a.c.a.a(this.storeLayout);
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public rx.e<MenuItem> clickToolbar() {
        return e.g.a.b.c.a.e.a(this.toolbar);
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public rx.e<Void> clickTrustedBadge() {
        return e.g.a.c.a.a(this.trustedLayout);
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public rx.e<FlagsVote.VoteType> clickVirusFlag() {
        return e.g.a.c.a.a(this.virusLayout).G(new rx.m.e() { // from class: cm.aptoide.pt.app.view.w0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return rx.e.S(FlagsVote.VoteType.VIRUS);
            }
        });
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public rx.e<FlagsVote.VoteType> clickWorkingFlag() {
        return e.g.a.c.a.a(this.workingWellLayout).G(new rx.m.e() { // from class: cm.aptoide.pt.app.view.v0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return rx.e.S(FlagsVote.VoteType.GOOD);
            }
        });
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public rx.e<ReadMoreClickEvent> clickedReadMore() {
        return this.readMoreClick;
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public void defaultShare(String str, String str2) {
        if (str2 != null) {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.SUBJECT", getActivity().getString(R.string.install) + " \"" + str + "\"");
            intent.putExtra("android.intent.extra.TEXT", str2);
            getActivity().startActivity(Intent.createChooser(intent, getActivity().getString(R.string.share)));
        }
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public void disableFlags() {
        this.workingWellLayout.setClickable(false);
        this.needsLicenseLayout.setClickable(false);
        this.fakeAppLayout.setClickable(false);
        this.virusLayout.setClickable(false);
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public rx.e<Promotion> dismissWalletPromotionClick() {
        return this.promotionAppClick.D(new rx.m.e() { // from class: cm.aptoide.pt.app.view.f0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((PromotionEvent) obj).getClickType() == PromotionEvent.ClickType.DISMISS);
            }
        }).X(new rx.m.e() { // from class: cm.aptoide.pt.app.view.c1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return ((PromotionEvent) obj).getPromotion();
            }
        });
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public void dismissWalletPromotionView() {
        this.promotionView.setVisibility(8);
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public void displayNotLoggedInSnack() {
        Snackbar.Z(getView(), R.string.you_need_to_be_logged_in, -1).b0(R.string.login, new View.OnClickListener() { // from class: cm.aptoide.pt.app.view.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f4501f.g(view);
            }
        }).P();
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public void displayStoreFollowedSnack(String str) {
        Toast.makeText(getContext(), String.format(getString(R.string.store_followed), str), 0).show();
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public void enableFlags() {
        this.workingWellLayout.setClickable(true);
        this.needsLicenseLayout.setClickable(true);
        this.fakeAppLayout.setClickable(true);
        this.virusLayout.setClickable(true);
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public void extractReferrer(final SearchAdResult searchAdResult) {
        AptoideUtils.ThreadU.runOnUiThread(new Runnable() { // from class: cm.aptoide.pt.app.view.n
            @Override // java.lang.Runnable
            public final void run() {
                this.f4458f.h(searchAdResult);
            }
        });
    }

    @Override // cm.aptoide.pt.view.fragment.NavigationTrackFragment
    public ScreenTagHistory getHistoryTracker() {
        return ScreenTagHistory.Builder.build("AppViewFragment", getArguments().getString(BundleKeys.ORIGIN_TAG.name(), HttpUrl.FRAGMENT_ENCODE_SET), StoreContext.meta.name());
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public String getLanguageFilter() {
        return new LanguageFilterHelper(getContext().getResources()).getCurrentLanguageFirst().getCountryCodes().get(0);
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public rx.e<ScreenShotClickEvent> getScreenshotClickEvent() {
        return this.screenShotClick;
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public void handleError(DetailedAppRequestResult.Error error) {
        this.viewProgress.setVisibility(8);
        int i2 = AnonymousClass2.$SwitchMap$cm$aptoide$pt$view$app$DetailedAppRequestResult$Error[error.ordinal()];
        if (i2 == 1) {
            this.errorView.setError(ErrorView.Error.NO_NETWORK);
            this.errorView.setVisibility(0);
        } else {
            if (i2 != 2) {
                return;
            }
            this.errorView.setError(ErrorView.Error.GENERIC);
            this.errorView.setVisibility(0);
        }
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public void hideReviews() {
        this.reviewsLayout.setVisibility(8);
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public void hideSimilarApps() {
        this.similarListRecyclerView.setVisibility(8);
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public rx.e<Void> iabInfoClick() {
        return rx.e.a0(e.g.a.c.a.a(this.poaIabInfo), e.g.a.c.a.a(this.iabInfo));
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public void incrementFlags(FlagsVote.VoteType voteType) {
        disableFlags();
        int i2 = AnonymousClass2.$SwitchMap$cm$aptoide$pt$view$app$FlagsVote$VoteType[voteType.ordinal()];
        if (i2 == 1) {
            this.workingWellText.setText(NumberFormat.getIntegerInstance().format(Double.parseDouble(String.valueOf(new BigDecimal(this.workingWellText.getText().toString()))) + 1.0d));
            this.workingWellLayout.setSelected(true);
            this.workingWellLayout.setPressed(false);
            return;
        }
        if (i2 == 2) {
            this.needsLicenceText.setText(NumberFormat.getIntegerInstance().format(Double.parseDouble(String.valueOf(new BigDecimal(this.needsLicenceText.getText().toString()))) + 1.0d));
            this.needsLicenceText.setSelected(true);
            this.needsLicenceText.setPressed(false);
        } else if (i2 == 3) {
            this.fakeAppText.setText(NumberFormat.getIntegerInstance().format(Double.parseDouble(String.valueOf(new BigDecimal(this.fakeAppText.getText().toString()))) + 1.0d));
            this.fakeAppLayout.setSelected(true);
            this.fakeAppLayout.setPressed(false);
        } else if (i2 == 4) {
            this.virusText.setText(NumberFormat.getIntegerInstance().format(Double.parseDouble(String.valueOf(new BigDecimal(this.virusText.getText().toString()))) + 1.0d));
            this.virusLayout.setSelected(true);
            this.virusLayout.setPressed(false);
        } else {
            throw new IllegalArgumentException("Unable to find Type " + voteType.name());
        }
    }

    @Override // cm.aptoide.pt.appview.InstallAppView
    public rx.e<DownloadModel.Action> installAppClick() {
        return this.installClickSubject.X(new rx.m.e() { // from class: cm.aptoide.pt.app.view.m0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4438f.i((DownloadModel.Action) obj);
            }
        });
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public rx.e<Pair<Promotion, WalletApp>> installWalletButtonClick() {
        return this.promotionAppClick.D(new rx.m.e() { // from class: cm.aptoide.pt.app.view.o
            @Override // rx.m.e
            public final Object call(Object obj) {
                PromotionEvent promotionEvent = (PromotionEvent) obj;
                return Boolean.valueOf(promotionEvent.getClickType() == PromotionEvent.ClickType.UPDATE || promotionEvent.getClickType() == PromotionEvent.ClickType.INSTALL_APP || promotionEvent.getClickType() == PromotionEvent.ClickType.DOWNLOAD || promotionEvent.getClickType() == PromotionEvent.ClickType.DOWNGRADE);
            }
        }).X(new rx.m.e() { // from class: cm.aptoide.pt.app.view.q0
            @Override // rx.m.e
            public final Object call(Object obj) {
                PromotionEvent promotionEvent = (PromotionEvent) obj;
                return Pair.create(promotionEvent.getPromotion(), promotionEvent.getWallet());
            }
        });
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public boolean isSimilarAppsVisible() {
        Rect rect = new Rect();
        this.scrollView.getHitRect(rect);
        return this.similarListRecyclerView.getLocalVisibleRect(rect);
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public void navigateToDeveloperEmail(AppModel appModel) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("mailto:" + appModel.getDeveloper().getEmail() + "?subject=Feedback&body="));
        getContext().startActivity(intent);
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public void navigateToDeveloperPermissions(AppModel appModel) {
        DialogPermissions.newInstance(appModel.getAppName(), appModel.getVersionName(), appModel.getIcon(), AptoideUtils.StringU.formatBytes(AppUtils.sumFileSizes(appModel.getFileSize(), appModel.getObb()), false), appModel.getUsedPermissions()).show(getActivity().getSupportFragmentManager(), HttpUrl.FRAGMENT_ENCODE_SET);
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public void navigateToDeveloperPrivacy(AppModel appModel) {
        getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(appModel.getDeveloper().getPrivacy())));
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public void navigateToDeveloperWebsite(AppModel appModel) {
        getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(appModel.getDeveloper().getWebsite())));
    }

    @Override // cm.aptoide.pt.view.fragment.NavigationTrackFragment, cm.aptoide.pt.view.fragment.FragmentView, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getFragmentComponent(bundle).inject(this);
        this.screenShotClick = rx.s.b.g1();
        this.readMoreClick = rx.s.b.g1();
        this.loginSnackClick = rx.s.b.g1();
        this.similarAppClick = rx.s.b.g1();
        this.reviewsAutoScroll = rx.s.b.g1();
        this.apkfyDialogConfirmSubject = rx.s.b.g1();
        this.similarAppsVisibilitySubject = rx.s.b.g1();
        this.installClickSubject = rx.s.b.g1();
        this.resumeClickSubject = rx.s.b.g1();
        this.cancelClickSubject = rx.s.b.g1();
        this.pauseClickSubject = rx.s.b.g1();
        this.promotionAppClick = rx.s.b.g1();
        this.poaFiatDecimalFormat = new DecimalFormat("0.00");
        AptoideApplication aptoideApplication = (AptoideApplication) getContext().getApplicationContext();
        this.qManager = aptoideApplication.getQManager();
        this.httpClient = aptoideApplication.getDefaultClient();
        this.converterFactory = WebService.getDefaultConverter();
        this.adsRepository = aptoideApplication.getAdsRepository();
        setHasOptionsMenu(true);
    }

    @Override // cm.aptoide.pt.view.fragment.FragmentView, androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        this.menu = menu;
        menuInflater.inflate(R.menu.fragment_appview, menu);
        showHideOptionsMenu(true);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View viewInflate = layoutInflater.inflate(R.layout.fragment_app_view, viewGroup, false);
        if (this.isEskills) {
            viewInflate.getContext().setTheme(R.style.AppBaseThemeDark);
        }
        return viewInflate;
    }

    @Override // cm.aptoide.pt.view.fragment.FragmentView, cm.aptoide.pt.view.BaseFragment, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        rx.k kVar = this.errorMessageSubscription;
        if (kVar != null && !kVar.isUnsubscribed()) {
            this.errorMessageSubscription.unsubscribe();
        }
        this.screenShotClick = null;
        this.readMoreClick = null;
        this.loginSnackClick = null;
        this.similarAppClick = null;
        this.reviewsAutoScroll = null;
        this.dialogUtils = null;
        this.presenter = null;
        this.similarAppsVisibilitySubject = null;
    }

    @Override // com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.scrollViewY = this.scrollView.getScrollY();
        this.appviewInstall = null;
        this.poaInstall = null;
        this.appcInfoView = null;
        this.poaIabInfo = null;
        this.poaOfferValue = null;
        this.iabInfo = null;
        this.errorView = null;
        this.appIcon = null;
        this.trustedBadge = null;
        this.appName = null;
        this.trustedLayout = null;
        this.trustedText = null;
        this.downloadsTop = null;
        this.sizeInfo = null;
        this.iconSizeInfo = null;
        this.ratingInfo = null;
        this.latestVersion = null;
        this.otherVersions = null;
        this.screenshots = null;
        this.descriptionText = null;
        this.reviewsAdapter = null;
        this.descriptionReadMore = null;
        this.topReviewsProgress = null;
        this.ratingLayout = null;
        this.emptyReviewsLayout = null;
        this.topReviewsLayout = null;
        this.rateAppButtonLarge = null;
        this.emptyReviewTextView = null;
        this.reviewUsers = null;
        this.avgReviewScore = null;
        this.avgReviewScoreBar = null;
        this.reviewsView = null;
        this.rateAppButton = null;
        this.showAllReviewsButton = null;
        this.goodAppLayoutWrapper = null;
        this.flagsLayoutWrapper = null;
        this.workingWellLayout = null;
        this.needsLicenseLayout = null;
        this.fakeAppLayout = null;
        this.virusLayout = null;
        this.workingWellText = null;
        this.needsLicenceText = null;
        this.fakeAppText = null;
        this.virusText = null;
        this.storeLayout = null;
        this.storeIcon = null;
        this.storeName = null;
        this.storeFollowers = null;
        this.storeDownloads = null;
        this.storeFollow = null;
        this.infoWebsite = null;
        this.infoEmail = null;
        this.infoPrivacy = null;
        this.infoPermissions = null;
        this.viewProgress = null;
        this.appview = null;
        this.screenshotsAdapter = null;
        this.catappultCard = null;
        this.menu = null;
        this.toolbar = null;
        this.actionBar = null;
        this.scrollView = null;
        this.collapsingToolbarLayout = null;
        CountDownTimer countDownTimer = this.poaCountdownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.poaCountdownTimer = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        LayoutInflater layoutInflaterOnGetLayoutInflater = super.onGetLayoutInflater(bundle);
        return this.isEskills ? layoutInflaterOnGetLayoutInflater.cloneInContext(new ContextThemeWrapper(getContext(), R.style.AppBaseThemeDark)) : layoutInflaterOnGetLayoutInflater;
    }

    @Override // cm.aptoide.pt.view.fragment.NavigationTrackFragment, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        NestedScrollView nestedScrollView = this.scrollView;
        if (nestedScrollView != null) {
            bundle.putInt(KEY_SCROLL_Y, nestedScrollView.getScrollY());
        }
    }

    @Override // cm.aptoide.pt.view.fragment.NavigationTrackFragment, cm.aptoide.pt.view.BaseFragment, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onViewCreated(final View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ViewStub.OnInflateListener onInflateListener = new ViewStub.OnInflateListener() { // from class: cm.aptoide.pt.app.view.u0
            @Override // android.view.ViewStub.OnInflateListener
            public final void onInflate(ViewStub viewStub, View view2) {
                this.a.n(viewStub, view2);
            }
        };
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.appview_install_element);
        this.appviewInstall = viewStub;
        viewStub.setLayoutResource(R.layout.install_app_view);
        this.appviewInstall.setOnInflateListener(onInflateListener);
        ViewStub viewStub2 = (ViewStub) view.findViewById(R.id.poa_install_element);
        this.poaInstall = viewStub2;
        viewStub2.setLayoutResource(R.layout.install_app_view);
        this.poaInstall.setOnInflateListener(onInflateListener);
        this.scrollView = (NestedScrollView) view.findViewById(R.id.scroll_view_app);
        this.errorView = (ErrorView) view.findViewById(R.id.error_view);
        this.reviewsLayout = view.findViewById(R.id.reviews_layout);
        this.appIcon = (ImageView) view.findViewById(R.id.app_icon);
        this.trustedBadge = (ImageView) view.findViewById(R.id.trusted_badge);
        this.appName = (TextView) view.findViewById(R.id.app_name);
        this.trustedLayout = view.findViewById(R.id.trusted_layout);
        this.trustedText = (TextView) view.findViewById(R.id.trusted_text);
        this.downloadsTop = (TextView) view.findViewById(R.id.header_downloads);
        this.sizeInfo = (TextView) view.findViewById(R.id.header_size);
        this.iconSizeInfo = (ImageView) view.findViewById(R.id.header_size_icon);
        this.ratingInfo = (TextView) view.findViewById(R.id.header_rating);
        this.appcMigrationWarningMessage = view.findViewById(R.id.migration_warning);
        this.otherVersionsTopSeparator = view.findViewById(R.id.other_versions_top_separator);
        this.appcInfoView = view.findViewById(R.id.poa_appc_layout);
        this.poaCoinsIcon = (ImageView) view.findViewById(R.id.coins_icon);
        this.poaIabInfo = view.findViewById(R.id.inapp_purchases);
        this.poaOfferValue = (TextView) view.findViewById(R.id.offer_value);
        this.poaBudgetElement = view.findViewById(R.id.budget_element);
        this.poaBudgetMessage = (TextView) view.findViewById(R.id.budget_left_message);
        this.poaCountdownMessage = view.findViewById(R.id.countdown_element);
        this.poaCountdownHours = (TextView) view.findViewById(R.id.hours);
        this.poaCountdownMinutes = (TextView) view.findViewById(R.id.minutes);
        this.poaCountdownSeconds = (TextView) view.findViewById(R.id.seconds);
        this.iabInfo = view.findViewById(R.id.iap_appc_label);
        this.versionsLayout = view.findViewById(R.id.versions_layout);
        this.latestVersionTitle = (TextView) view.findViewById(R.id.latest_version_title);
        this.latestVersion = (TextView) this.versionsLayout.findViewById(R.id.latest_version);
        this.rewardAppLatestVersion = (TextView) view.findViewById(R.id.appview_reward_app_versions_element);
        this.otherVersions = (TextView) view.findViewById(R.id.other_versions);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.screenshots_list);
        this.screenshots = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), 0, false));
        this.screenshots.setNestedScrollingEnabled(false);
        this.descriptionText = (TextView) view.findViewById(R.id.description_text);
        this.descriptionReadMore = (Button) view.findViewById(R.id.description_see_more);
        this.topReviewsProgress = (ContentLoadingProgressBar) view.findViewById(R.id.top_comments_progress);
        this.ratingLayout = view.findViewById(R.id.rating_layout);
        this.emptyReviewsLayout = view.findViewById(R.id.empty_reviews_layout);
        this.topReviewsLayout = view.findViewById(R.id.comments_layout);
        this.rateAppButtonLarge = (Button) view.findViewById(R.id.rate_this_button2);
        this.emptyReviewTextView = (TextView) view.findViewById(R.id.empty_review_text);
        this.reviewUsers = (TextView) view.findViewById(R.id.users_voted);
        this.avgReviewScore = (TextView) view.findViewById(R.id.rating_value);
        this.avgReviewScoreBar = (RatingBar) view.findViewById(R.id.rating_bar);
        this.reviewsView = (RecyclerView) view.findViewById(R.id.top_comments_list);
        this.rateAppButton = (Button) view.findViewById(R.id.rate_this_button);
        this.showAllReviewsButton = (Button) view.findViewById(R.id.read_all_button);
        this.apkfyElement = view.findViewById(R.id.apkfy_element);
        this.flagThisAppSection = view.findViewById(R.id.flag_this_app_section);
        this.goodAppLayoutWrapper = view.findViewById(R.id.good_app_layout);
        this.flagsLayoutWrapper = view.findViewById(R.id.rating_flags_layout);
        this.workingWellLayout = view.findViewById(R.id.working_well_layout);
        this.needsLicenseLayout = view.findViewById(R.id.needs_licence_layout);
        this.fakeAppLayout = view.findViewById(R.id.fake_app_layout);
        this.virusLayout = view.findViewById(R.id.virus_layout);
        this.workingWellText = (TextView) view.findViewById(R.id.working_well_count);
        this.needsLicenceText = (TextView) view.findViewById(R.id.needs_licence_count);
        this.fakeAppText = (TextView) view.findViewById(R.id.fake_app_count);
        this.virusText = (TextView) view.findViewById(R.id.virus_count);
        this.storeLayout = view.findViewById(R.id.store_uploaded_layout);
        this.storeIcon = (ImageView) view.findViewById(R.id.store_icon);
        this.storeName = (TextView) view.findViewById(R.id.store_name);
        this.storeFollowers = (TextView) view.findViewById(R.id.user_count);
        this.storeDownloads = (TextView) view.findViewById(R.id.download_count);
        this.storeFollow = (Button) view.findViewById(R.id.follow_button);
        this.similarListRecyclerView = (RecyclerView) view.findViewById(R.id.similar_list);
        this.similarDownloadPlaceholder = view.findViewById(R.id.similar_download_placeholder);
        this.similarBottomPlaceholder = view.findViewById(R.id.similar_bottom_placeholder);
        this.infoWebsite = view.findViewById(R.id.website_label);
        this.infoEmail = view.findViewById(R.id.email_label);
        this.infoPrivacy = view.findViewById(R.id.privacy_policy_label);
        this.infoPermissions = view.findViewById(R.id.permissions_label);
        this.catappultCard = view.findViewById(R.id.catappult_card);
        this.viewProgress = (ProgressBar) view.findViewById(R.id.appview_progress);
        this.appview = view.findViewById(R.id.appview_full);
        this.toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        this.bonusAppcView = (BonusAppcView) view.findViewById(R.id.bonus_appc_view);
        View viewFindViewById = view.findViewById(R.id.wallet_install_promotion);
        this.promotionView = viewFindViewById;
        this.walletPromotionTitle = (TextView) viewFindViewById.findViewById(R.id.wallet_title);
        this.walletPromotionMessage = (TextView) this.promotionView.findViewById(R.id.wallet_message);
        this.walletPromotionButtonsLayout = this.promotionView.findViewById(R.id.buttons_layout);
        this.walletPromotionCancelButton = (Button) this.promotionView.findViewById(R.id.cancel_button);
        this.walletPromotionDownloadButton = (Button) this.promotionView.findViewById(R.id.download_button);
        View viewFindViewById2 = view.findViewById(R.id.wallet_download_info);
        this.walletPromotionDownloadLayout = viewFindViewById2;
        this.downloadWalletProgressBar = (ProgressBar) viewFindViewById2.findViewById(R.id.wallet_download_progress_bar);
        this.downloadWalletProgressValue = (TextView) this.walletPromotionDownloadLayout.findViewById(R.id.wallet_download_progress_number);
        this.cancelWalletDownload = (ImageView) this.walletPromotionDownloadLayout.findViewById(R.id.wallet_download_cancel_button);
        this.pauseWalletDownload = (ImageView) this.walletPromotionDownloadLayout.findViewById(R.id.wallet_download_pause_download);
        this.resumeWalletDownload = (ImageView) this.walletPromotionDownloadLayout.findViewById(R.id.wallet_download_resume_download);
        this.walletPromotionClaimLayout = view.findViewById(R.id.wallet_claim_appc_layout);
        this.walletPromotionIcon = (ImageView) view.findViewById(R.id.wallet_icon);
        this.walletPromotionClaimButton = (Button) view.findViewById(R.id.wallet_claim_appc_button);
        this.walletDownloadControlsLayout = view.findViewById(R.id.wallet_install_controls_layout);
        this.walletPromotionInstallDisableLayout = view.findViewById(R.id.wallet_install_disabled_layout);
        this.walletPromotionInstallDisableButton = (Button) view.findViewById(R.id.wallet_install_disabled_button);
        ScreenshotsAdapter screenshotsAdapter = new ScreenshotsAdapter(new ArrayList(), new ArrayList(), this.screenShotClick);
        this.screenshotsAdapter = screenshotsAdapter;
        this.screenshots.setAdapter(screenshotsAdapter);
        LinearLayoutManagerWithSmoothScroller linearLayoutManagerWithSmoothScroller = new LinearLayoutManagerWithSmoothScroller(getContext(), 0, false);
        this.similarListRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        this.similarListRecyclerView.setNestedScrollingEnabled(false);
        setSimilarAppsAdapters();
        this.reviewsView.setLayoutManager(linearLayoutManagerWithSmoothScroller);
        this.reviewsView.setNestedScrollingEnabled(false);
        SnapToStartHelper snapToStartHelper = new SnapToStartHelper();
        SnapToStartHelper snapToStartHelper2 = new SnapToStartHelper();
        snapToStartHelper.attachToRecyclerView(this.reviewsView);
        snapToStartHelper2.attachToRecyclerView(this.screenshots);
        setupToolbar();
        ((AppBarLayout) view.findViewById(R.id.app_bar_layout)).b(new AppBarLayout.e() { // from class: cm.aptoide.pt.app.view.g0
            @Override // com.google.android.material.appbar.AppBarLayout.c
            public final void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
                this.a.o(view, appBarLayout, i2);
            }
        });
        if (bundle != null) {
            this.scrollViewY = bundle.getInt(KEY_SCROLL_Y, 0);
        }
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) view.findViewById(R.id.collapsing_toolbar_layout);
        this.collapsingToolbarLayout = collapsingToolbarLayout;
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));
        attachPresenter(this.presenter);
    }

    @Override // cm.aptoide.pt.appview.InstallAppView
    public void openApp(String str) {
        AptoideUtils.SystemU.openApp(str, getContext().getPackageManager(), getContext());
    }

    @Override // cm.aptoide.pt.appview.InstallAppView
    public rx.e<Void> pauseDownload() {
        return this.pauseClickSubject;
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public rx.e<WalletApp> pausePromotionDownload() {
        return this.promotionAppClick.D(new rx.m.e() { // from class: cm.aptoide.pt.app.view.u
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((PromotionEvent) obj).getClickType() == PromotionEvent.ClickType.PAUSE_DOWNLOAD);
            }
        }).X(new rx.m.e() { // from class: cm.aptoide.pt.app.view.b1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return ((PromotionEvent) obj).getWallet();
            }
        });
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public void populateReviews(ReviewsViewModel reviewsViewModel, AppModel appModel) {
        List<AppReview> reviewsList = reviewsViewModel.getReviewsList();
        if (reviewsList == null || reviewsList.isEmpty()) {
            showReviews(false, appModel.getRating().getTotal(), appModel.getRating().getAverage());
            this.reviewsAdapter = new TopReviewsAdapter();
        } else {
            showReviews(true, appModel.getRating().getTotal(), appModel.getRating().getAverage());
            this.reviewsAdapter = new TopReviewsAdapter((AppReview[]) reviewsList.toArray(new AppReview[reviewsList.size()]));
        }
        this.reviewsView.setAdapter(this.reviewsAdapter);
        this.reviewsAutoScroll.onNext(Integer.valueOf(this.reviewsAdapter.getItemCount()));
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public void populateSimilar(List<SimilarAppsBundle> list) {
        this.similarListAdapter.add(list);
        manageSimilarAppsVisibility(true, false);
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public void recoverScrollViewState() {
        this.scrollView.post(new Runnable() { // from class: cm.aptoide.pt.app.view.y0
            @Override // java.lang.Runnable
            public final void run() {
                this.f4681f.p();
            }
        });
    }

    @Override // cm.aptoide.pt.appview.InstallAppView
    public rx.e<DownloadModel.Action> resumeDownload() {
        return this.resumeClickSubject.X(new rx.m.e() { // from class: cm.aptoide.pt.app.view.m
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4437f.q((DownloadModel.Action) obj);
            }
        });
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public rx.e<WalletApp> resumePromotionDownload() {
        return this.promotionAppClick.D(new rx.m.e() { // from class: cm.aptoide.pt.app.view.j0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((PromotionEvent) obj).getClickType() == PromotionEvent.ClickType.RESUME_DOWNLOAD);
            }
        }).X(new rx.m.e() { // from class: cm.aptoide.pt.app.view.e0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return ((PromotionEvent) obj).getWallet();
            }
        });
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public void scrollReviews(Integer num) {
        RecyclerView recyclerView = this.reviewsView;
        if (recyclerView != null) {
            recyclerView.smoothScrollToPosition(num.intValue());
        }
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public rx.e<Integer> scrollReviewsResponse() {
        return this.reviewsAutoScroll;
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public rx.e<e.g.a.c.f> scrollVisibleSimilarApps() {
        return e.g.a.b.b.a.b.a(this.scrollView).D(new rx.m.e() { // from class: cm.aptoide.pt.app.view.s
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4556f.r((e.g.a.c.f) obj);
            }
        });
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public void setFollowButton(boolean z) {
        if (z) {
            return;
        }
        this.storeFollow.setText(R.string.followed);
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public void setInstallButton(AppCoinsViewModel appCoinsViewModel) {
        if (!appCoinsViewModel.hasAdvertising()) {
            this.appviewInstall.inflate();
        } else {
            this.poaInstall.inflate();
            this.otherVersionsTopSeparator.setVisibility(4);
        }
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public void setupAppcAppView(boolean z, BonusAppcModel bonusAppcModel) {
        getContext().getTheme().resolveAttribute(R.attr.appview_toolbar_bg_appc, new TypedValue(), true);
        if (z && bonusAppcModel.getHasBonusAppc()) {
            this.bonusAppcView.setPercentage(bonusAppcModel.getBonusPercentage());
            this.bonusAppcView.setVisibility(0);
        }
        this.install.setBackgroundDrawable(getContext().getResources().getDrawable(R.color.default_orange_gradient_end));
        this.downloadProgressBar.setProgressDrawable(androidx.core.content.a.f(getContext(), R.drawable.appc_progress));
        this.flagThisAppSection.setVisibility(8);
    }

    public void setupToolbar() {
        this.toolbar.setTitle(HttpUrl.FRAGMENT_ENCODE_SET);
        androidx.appcompat.app.d dVar = (androidx.appcompat.app.d) getActivity();
        dVar.setSupportActionBar(this.toolbar);
        androidx.appcompat.app.a supportActionBar = dVar.getSupportActionBar();
        this.actionBar = supportActionBar;
        if (supportActionBar != null) {
            supportActionBar.r(true);
            this.actionBar.v(this.toolbar.getTitle());
        }
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public void showApkfyElement(String str) {
        this.apkfyElement.setVisibility(0);
        ((TextView) this.apkfyElement.findViewById(R.id.apkfy_message_1)).setText(String.format(getString(R.string.appview_message_apkfy_1), str));
        ((TextView) this.apkfyElement.findViewById(R.id.apkfy_title)).setText(getResources().getString(R.string.appview_title_apkfy));
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public void showAppView(AppModel appModel) {
        this.collapsingToolbarLayout.setTitle(appModel.getAppName());
        this.appName.setText(appModel.getAppName());
        ImageLoader.with(getContext()).load(appModel.getIcon(), this.appIcon);
        this.downloadsTop.setText(String.format("%s", AptoideUtils.StringU.withSuffix(appModel.getPackageDownloads())));
        if (appModel.hasSplits()) {
            this.sizeInfo.setVisibility(8);
            this.iconSizeInfo.setVisibility(8);
        } else {
            this.sizeInfo.setText(AptoideUtils.StringU.formatBytes(appModel.getSize(), false));
        }
        if (appModel.getRating().getAverage() == 0.0f) {
            this.ratingInfo.setText(R.string.appcardview_title_no_stars);
        } else {
            this.ratingInfo.setText(this.oneDecimalFormat.format(appModel.getRating().getAverage()));
        }
        if (getArguments().getFloat(BundleKeys.APPC.name(), -1.0f) != -1.0f) {
            this.versionsLayout.setVisibility(8);
            this.rewardAppLatestVersion.setVisibility(0);
            String versionName = appModel.getVersionName();
            String str = String.format(getResources().getString(R.string.appview_latest_version_with_value), versionName);
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.grey_medium)), str.indexOf(versionName), str.indexOf(versionName) + versionName.length(), 33);
            this.rewardAppLatestVersion.setText(spannableString);
        } else {
            this.latestVersion.setText(appModel.getVersionName());
            if (appModel.isBeta()) {
                this.latestVersion.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_beta, 0, 0, 0);
                this.latestVersion.setCompoundDrawablePadding(8);
            }
            if (!appModel.isLatestTrustedVersion()) {
                this.latestVersionTitle.setText(getString(R.string.appview_version_text));
                this.otherVersions.setText(getString(R.string.newer_version_available));
            }
        }
        this.storeName.setText(appModel.getStore().getName());
        ImageLoader.with(getContext()).loadWithShadowCircleTransform(appModel.getStore().getAvatar(), this.storeIcon);
        this.storeDownloads.setText(String.format("%s", AptoideUtils.StringU.withSuffix(appModel.getStore().getStats().getDownloads())));
        this.storeFollowers.setText(String.format("%s", AptoideUtils.StringU.withSuffix(appModel.getStore().getStats().getSubscribers())));
        if (appModel.isStoreFollowed()) {
            this.storeFollow.setText(R.string.followed);
        } else {
            this.storeFollow.setText(R.string.follow);
        }
        if ((appModel.getMedia().getScreenshots() == null || appModel.getMedia().getScreenshots().isEmpty()) && (appModel.getMedia().getVideos() == null || appModel.getMedia().getVideos().isEmpty())) {
            this.screenshots.setVisibility(8);
        } else {
            this.screenshotsAdapter.updateScreenshots(appModel.getMedia().getScreenshots());
            this.screenshotsAdapter.updateVideos(appModel.getMedia().getVideos());
        }
        if (appModel.hasBilling()) {
            this.iabInfo.setVisibility(0);
        }
        setTrustedBadge(appModel.getMalware());
        setDescription(appModel.getMedia().getDescription());
        setAppFlags(appModel.isGoodApp(), appModel.getAppFlags());
        setReadMoreClickListener(appModel.getAppName(), appModel.getMedia(), appModel.getStore(), appModel.isAppCoinApp());
        setDeveloperDetails(appModel.getDeveloper());
        showAppViewLayout();
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public void showAppcWalletPromotionView(final Promotion promotion, final WalletApp walletApp, Promotion.ClaimAction claimAction, DownloadModel downloadModel) {
        this.walletPromotionCancelButton.setOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.pt.app.view.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f4325f.A(promotion, walletApp, view);
            }
        });
        if (walletApp.isInstalled()) {
            if (downloadModel.getAction().equals(DownloadModel.Action.OPEN)) {
                setupClaimWalletPromotion(promotion, walletApp);
            } else {
                setupInstallDependencyApp(promotion, downloadModel);
            }
        } else if (walletApp.getDownloadModel().isDownloading()) {
            setupActiveWalletPromotion(promotion, walletApp, downloadModel);
        } else {
            setupInactiveWalletPromotion(promotion, walletApp, downloadModel);
        }
        this.promotionView.setVisibility(0);
    }

    @Override // cm.aptoide.pt.appview.InstallAppView
    public rx.e<Boolean> showDowngradeMessage() {
        return GenericDialogs.createGenericContinueCancelMessage(getContext(), null, getContext().getResources().getString(R.string.downgrade_warning_dialog), this.themeManager.getAttributeForTheme(R.attr.dialogsTheme).resourceId).X(new rx.m.e() { // from class: cm.aptoide.pt.app.view.i0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((GenericDialogs.EResponse) obj).equals(GenericDialogs.EResponse.YES));
            }
        });
    }

    @Override // cm.aptoide.pt.appview.InstallAppView
    public void showDowngradingMessage() {
        Snackbar.Z(getView(), R.string.downgrading_msg, -1).P();
    }

    @Override // cm.aptoide.pt.appview.InstallAppView
    public void showDownloadAppModel(DownloadModel downloadModel, AppCoinsViewModel appCoinsViewModel, boolean z) {
        DownloadModel.Action action = downloadModel.getAction();
        this.action = action;
        DownloadModel.Action action2 = DownloadModel.Action.MIGRATE;
        if (!action.equals(action2)) {
            showAppcInfo(appCoinsViewModel.getAdvertisingModel().getHasAdvertising(), appCoinsViewModel.hasBilling(), appCoinsViewModel.getAdvertisingModel().getAppcReward(), appCoinsViewModel.getAdvertisingModel().getFiatReward(), appCoinsViewModel.getAdvertisingModel().getFiatCurrency(), appCoinsViewModel.getAdvertisingModel().getAppcBudget(), appCoinsViewModel.getAdvertisingModel().getEndDate());
        }
        if (downloadModel.isDownloadingOrInstalling()) {
            this.downloadInfoLayout.setVisibility(0);
            this.install.setVisibility(8);
            setDownloadState(downloadModel.getProgress(), downloadModel.getDownloadState(), downloadModel.getAppSize(), z);
        } else {
            if (this.action.equals(action2)) {
                this.appcInfoView.setVisibility(8);
                this.appcMigrationWarningMessage.setVisibility(0);
            }
            this.downloadInfoLayout.setVisibility(8);
            this.install.setVisibility(0);
            setButtonText(downloadModel);
        }
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public void showDownloadError(DownloadModel downloadModel) {
        if (downloadModel.hasError()) {
            handleDownloadError(downloadModel.getDownloadState());
        }
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public void showDownloadingSimilarApps(boolean z) {
        manageSimilarAppsVisibility(z, true);
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public void showFlagVoteSubmittedMessage() {
        Toast.makeText(getContext(), R.string.vote_submitted, 0).show();
    }

    @Override // cm.aptoide.pt.appview.InstallAppView
    public void showGenericErrorDialog() {
        showErrorDialog(HttpUrl.FRAGMENT_ENCODE_SET, getContext().getString(R.string.error_occured));
    }

    @Override // cm.aptoide.pt.appview.InstallAppView
    public void showInvalidAppInfoErrorDialog() {
        showErrorDialog(HttpUrl.FRAGMENT_ENCODE_SET, getContext().getString(R.string.appview_download_error_missing_splits));
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public void showLoading() {
        this.viewProgress.setVisibility(0);
        this.appview.setVisibility(8);
        this.errorView.setVisibility(8);
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public rx.e<Void> showOpenAndInstallApkFyDialog(String str, String str2, double d2, float f2, String str3, int i2) {
        return createCustomDialogForApkfy(str2, d2, f2, str3, i2).D(new rx.m.e() { // from class: cm.aptoide.pt.app.view.d1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((GenericDialogs.EResponse) obj).equals(GenericDialogs.EResponse.YES));
            }
        }).X(new rx.m.e() { // from class: cm.aptoide.pt.app.view.k0
            @Override // rx.m.e
            public final Object call(Object obj) {
                AppViewFragment.lambda$showOpenAndInstallApkFyDialog$19((GenericDialogs.EResponse) obj);
                return null;
            }
        });
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public rx.e<Void> showOpenAndInstallDialog(String str, String str2) {
        return GenericDialogs.createGenericOkCancelMessage(getContext(), str, getContext().getString(R.string.installapp_alrt, str2), this.themeManager.getAttributeForTheme(R.attr.dialogsTheme).resourceId).D(new rx.m.e() { // from class: cm.aptoide.pt.app.view.r
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((GenericDialogs.EResponse) obj).equals(GenericDialogs.EResponse.YES));
            }
        }).X(new rx.m.e() { // from class: cm.aptoide.pt.app.view.e1
            @Override // rx.m.e
            public final Object call(Object obj) {
                AppViewFragment.lambda$showOpenAndInstallDialog$17((GenericDialogs.EResponse) obj);
                return null;
            }
        });
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public rx.e<GenericDialogs.EResponse> showRateDialog(String str, String str2, String str3) {
        return this.dialogUtils.showRateDialog(getActivity(), str, str2, str3);
    }

    @Override // cm.aptoide.pt.appview.InstallAppView
    public rx.e<Boolean> showRootInstallWarningPopup() {
        return GenericDialogs.createGenericYesNoCancelMessage(getContext(), null, getResources().getString(R.string.root_access_dialog), this.themeManager.getAttributeForTheme(R.attr.dialogsTheme).resourceId).X(new rx.m.e() { // from class: cm.aptoide.pt.app.view.p0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((GenericDialogs.EResponse) obj).equals(GenericDialogs.EResponse.YES));
            }
        });
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public void showShareOnTvDialog(long j2) {
        if (AptoideUtils.SystemU.getConnectionType((ConnectivityManager) getContext().getSystemService("connectivity")).equals("mobile")) {
            GenericDialogs.createGenericOkMessage(getContext(), getContext().getString(R.string.remote_install_menu_title), getContext().getString(R.string.install_on_tv_mobile_error), this.themeManager.getAttributeForTheme(R.attr.dialogsTheme).resourceId).H0(new rx.m.b() { // from class: cm.aptoide.pt.app.view.k
                @Override // rx.m.b
                public final void call(Object obj) {
                    AppViewFragment.lambda$showShareOnTvDialog$12((GenericDialogs.EResponse) obj);
                }
            }, new rx.m.b() { // from class: cm.aptoide.pt.app.view.v
                @Override // rx.m.b
                public final void call(Object obj) {
                    CrashReport.getInstance().log((Throwable) obj);
                }
            });
        } else {
            RemoteInstallDialog.newInstance(j2).show(getActivity().getSupportFragmentManager(), RemoteInstallDialog.class.getSimpleName());
        }
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public void showTrustedDialog(AppModel appModel) {
        DialogBadgeV7.newInstance(this.marketName, appModel.getMalware(), appModel.getAppName(), appModel.getMalware().getRank()).show(getFragmentManager(), BADGE_DIALOG_TAG);
    }

    @Override // cm.aptoide.pt.app.view.AppViewView
    public rx.e<Boolean> similarAppsVisibilityFromInstallClick() {
        return this.similarAppsVisibilitySubject;
    }

    protected void showHideOptionsMenu(MenuItem menuItem, boolean z) {
        if (menuItem != null) {
            menuItem.setVisible(z);
        }
    }
}
