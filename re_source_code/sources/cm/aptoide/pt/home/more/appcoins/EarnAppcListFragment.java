package cm.aptoide.pt.home.more.appcoins;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import cm.aptoide.aptoideviews.recyclerview.GridRecyclerView;
import cm.aptoide.pt.R;
import cm.aptoide.pt.app.DownloadModel;
import cm.aptoide.pt.home.bundles.apps.RewardApp;
import cm.aptoide.pt.home.more.base.ListAppsFragment;
import cm.aptoide.pt.promotions.WalletApp;
import cm.aptoide.pt.store.view.StoreTabGridRecyclerFragment;
import cm.aptoide.pt.themes.ThemeManager;
import cm.aptoide.pt.utils.GenericDialogs;
import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import okhttp3.HttpUrl;
import rx.exceptions.OnErrorNotImplementedException;

/* JADX INFO: compiled from: EarnAppcListFragment.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 C2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001CB\u0005¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016J\u001a\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00030\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020 H\u0014J\b\u0010!\u001a\u00020\u001cH\u0016J\b\u0010\"\u001a\u00020\u001cH\u0016J\u0012\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0002J\b\u0010'\u001a\u00020$H\u0016J\u0012\u0010(\u001a\u00020$2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J&\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u001b2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u00100\u001a\u00020$H\u0016J\u001a\u00101\u001a\u00020$2\u0006\u00102\u001a\u00020,2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u000e\u00103\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016J\u000e\u00104\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016J\u000e\u00105\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016J\u001a\u00106\u001a\u00020$2\u0006\u00107\u001a\u00020\u001c2\b\u0010%\u001a\u0004\u0018\u00010&H\u0002J\u0010\u00108\u001a\u00020$2\u0006\u00109\u001a\u00020:H\u0016J\u0010\u0010;\u001a\u00020$2\u0006\u00109\u001a\u00020:H\u0016J\u0018\u0010<\u001a\u00020$2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020>H\u0002J\u000e\u0010@\u001a\b\u0012\u0004\u0012\u00020A0\u0017H\u0016J\u0010\u0010B\u001a\u00020$2\u0006\u00109\u001a\u00020:H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006D"}, d2 = {"Lcm/aptoide/pt/home/more/appcoins/EarnAppcListFragment;", "Lcm/aptoide/pt/home/more/base/ListAppsFragment;", "Lcm/aptoide/pt/home/bundles/apps/RewardApp;", "Lcm/aptoide/pt/home/more/appcoins/EarnAppcListViewHolder;", "Lcm/aptoide/pt/home/more/appcoins/EarnAppcListView;", "()V", "errorMessageSubscription", "Lrx/Subscription;", "oneDecimalFormatter", "Ljava/text/DecimalFormat;", "presenter", "Lcm/aptoide/pt/home/more/appcoins/EarnAppcListPresenter;", "getPresenter", "()Lcm/aptoide/pt/home/more/appcoins/EarnAppcListPresenter;", "setPresenter", "(Lcm/aptoide/pt/home/more/appcoins/EarnAppcListPresenter;)V", "themeManager", "Lcm/aptoide/pt/themes/ThemeManager;", "getThemeManager", "()Lcm/aptoide/pt/themes/ThemeManager;", "setThemeManager", "(Lcm/aptoide/pt/themes/ThemeManager;)V", "cancelDownload", "Lrx/Observable;", "Ljava/lang/Void;", "createViewHolder", "Lkotlin/Function2;", "Landroid/view/ViewGroup;", HttpUrl.FRAGMENT_ENCODE_SET, "getAdapterStrategy", "Lcm/aptoide/aptoideviews/recyclerview/GridRecyclerView$AdaptStrategy;", "getContainerPaddingDp", "Landroid/graphics/Rect;", "getItemSizeHeight", "getItemSizeWidth", "handleDownloadError", HttpUrl.FRAGMENT_ENCODE_SET, "downloadState", "Lcm/aptoide/pt/app/DownloadModel$DownloadState;", "hideWalletArea", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "onDestroy", "onViewCreated", "view", "onWalletInstallClick", "pauseDownload", "resumeDownload", "setDownloadState", "progress", "setupWallet", "walletApp", "Lcm/aptoide/pt/promotions/WalletApp;", "showDownloadError", "showErrorDialog", "title", HttpUrl.FRAGMENT_ENCODE_SET, "message", "showRootInstallWarningPopup", HttpUrl.FRAGMENT_ENCODE_SET, "updateState", "Companion", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class EarnAppcListFragment extends ListAppsFragment<RewardApp, EarnAppcListViewHolder> implements EarnAppcListView {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private rx.k errorMessageSubscription;

    @Inject
    public EarnAppcListPresenter presenter;

    @Inject
    public ThemeManager themeManager;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final DecimalFormat oneDecimalFormatter = new DecimalFormat("0.0");

    /* JADX INFO: compiled from: EarnAppcListFragment.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\b"}, d2 = {"Lcm/aptoide/pt/home/more/appcoins/EarnAppcListFragment$Companion;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "newInstance", "Lcm/aptoide/pt/home/more/appcoins/EarnAppcListFragment;", "title", HttpUrl.FRAGMENT_ENCODE_SET, StoreTabGridRecyclerFragment.BundleCons.TAG, "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final EarnAppcListFragment newInstance(String title, String tag) {
            kotlin.jvm.internal.m.f(title, "title");
            kotlin.jvm.internal.m.f(tag, StoreTabGridRecyclerFragment.BundleCons.TAG);
            EarnAppcListFragment earnAppcListFragment = new EarnAppcListFragment();
            Bundle bundle = new Bundle();
            bundle.putString("title", title);
            bundle.putString(StoreTabGridRecyclerFragment.BundleCons.TAG, tag);
            earnAppcListFragment.setArguments(bundle);
            return earnAppcListFragment;
        }
    }

    /* JADX INFO: compiled from: EarnAppcListFragment.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DownloadModel.DownloadState.values().length];
            iArr[DownloadModel.DownloadState.ACTIVE.ordinal()] = 1;
            iArr[DownloadModel.DownloadState.INDETERMINATE.ordinal()] = 2;
            iArr[DownloadModel.DownloadState.PAUSE.ordinal()] = 3;
            iArr[DownloadModel.DownloadState.COMPLETE.ordinal()] = 4;
            iArr[DownloadModel.DownloadState.INSTALLING.ordinal()] = 5;
            iArr[DownloadModel.DownloadState.ERROR.ordinal()] = 6;
            iArr[DownloadModel.DownloadState.NOT_ENOUGH_STORAGE_ERROR.ordinal()] = 7;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: cm.aptoide.pt.home.more.appcoins.EarnAppcListFragment$createViewHolder$1, reason: invalid class name */
    /* JADX INFO: compiled from: EarnAppcListFragment.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lcm/aptoide/pt/home/more/appcoins/EarnAppcListViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", HttpUrl.FRAGMENT_ENCODE_SET, "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class AnonymousClass1 extends Lambda implements Function2<ViewGroup, Integer, EarnAppcListViewHolder> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ EarnAppcListViewHolder invoke(ViewGroup viewGroup, Integer num) {
            return invoke(viewGroup, num.intValue());
        }

        public final EarnAppcListViewHolder invoke(ViewGroup viewGroup, int i2) {
            kotlin.jvm.internal.m.f(viewGroup, "parent");
            View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.earn_appcoins_item_more, viewGroup, false);
            kotlin.jvm.internal.m.e(viewInflate, "from(parent.context).inf…ent,\n              false)");
            return new EarnAppcListViewHolder(viewInflate, new DecimalFormat("0.00"));
        }
    }

    private final void handleDownloadError(DownloadModel.DownloadState downloadState) {
        if (downloadState == DownloadModel.DownloadState.ERROR) {
            String string = requireContext().getString(R.string.error_occured);
            kotlin.jvm.internal.m.e(string, "requireContext().getString(R.string.error_occured)");
            showErrorDialog(HttpUrl.FRAGMENT_ENCODE_SET, string);
        }
    }

    private final void setDownloadState(int progress, DownloadModel.DownloadState downloadState) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1, 4.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1, 2.0f);
        switch (downloadState != null ? WhenMappings.$EnumSwitchMapping$0[downloadState.ordinal()] : -1) {
            case 1:
                int i2 = R.id.appview_download_progress_bar;
                ((ProgressBar) _$_findCachedViewById(i2)).setIndeterminate(false);
                ((ProgressBar) _$_findCachedViewById(i2)).setProgress(progress);
                TextView textView = (TextView) _$_findCachedViewById(R.id.appview_download_progress_number);
                StringBuilder sb = new StringBuilder();
                sb.append(progress);
                sb.append('%');
                textView.setText(sb.toString());
                ((ImageView) _$_findCachedViewById(R.id.appview_download_pause_download)).setVisibility(0);
                ((ImageView) _$_findCachedViewById(R.id.appview_download_cancel_button)).setVisibility(8);
                ((ImageView) _$_findCachedViewById(R.id.appview_download_resume_download)).setVisibility(8);
                ((LinearLayout) _$_findCachedViewById(R.id.install_controls_layout)).setLayoutParams(layoutParams);
                ((TextView) _$_findCachedViewById(R.id.appview_download_download_state)).setText(getString(R.string.appview_short_downloading));
                break;
            case 2:
                ((ProgressBar) _$_findCachedViewById(R.id.appview_download_progress_bar)).setIndeterminate(true);
                ((ImageView) _$_findCachedViewById(R.id.appview_download_pause_download)).setVisibility(0);
                ((ImageView) _$_findCachedViewById(R.id.appview_download_cancel_button)).setVisibility(8);
                ((ImageView) _$_findCachedViewById(R.id.appview_download_resume_download)).setVisibility(8);
                ((LinearLayout) _$_findCachedViewById(R.id.install_controls_layout)).setLayoutParams(layoutParams);
                ((TextView) _$_findCachedViewById(R.id.appview_download_download_state)).setText(getString(R.string.appview_short_downloading));
                break;
            case 3:
                int i3 = R.id.appview_download_progress_bar;
                ((ProgressBar) _$_findCachedViewById(i3)).setIndeterminate(false);
                ((ProgressBar) _$_findCachedViewById(i3)).setProgress(progress);
                TextView textView2 = (TextView) _$_findCachedViewById(R.id.appview_download_progress_number);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(progress);
                sb2.append('%');
                textView2.setText(sb2.toString());
                ((ImageView) _$_findCachedViewById(R.id.appview_download_pause_download)).setVisibility(8);
                ((ImageView) _$_findCachedViewById(R.id.appview_download_cancel_button)).setVisibility(0);
                ((ImageView) _$_findCachedViewById(R.id.appview_download_resume_download)).setVisibility(0);
                ((LinearLayout) _$_findCachedViewById(R.id.install_controls_layout)).setLayoutParams(layoutParams2);
                ((TextView) _$_findCachedViewById(R.id.appview_download_download_state)).setText(getString(R.string.appview_short_downloading));
                break;
            case 4:
                ((ProgressBar) _$_findCachedViewById(R.id.appview_download_progress_bar)).setIndeterminate(true);
                ((ImageView) _$_findCachedViewById(R.id.appview_download_pause_download)).setVisibility(0);
                ((ImageView) _$_findCachedViewById(R.id.appview_download_cancel_button)).setVisibility(8);
                ((ImageView) _$_findCachedViewById(R.id.appview_download_resume_download)).setVisibility(8);
                ((LinearLayout) _$_findCachedViewById(R.id.install_controls_layout)).setLayoutParams(layoutParams);
                ((TextView) _$_findCachedViewById(R.id.appview_download_download_state)).setText(getString(R.string.appview_short_downloading));
                break;
            case 5:
                ((ProgressBar) _$_findCachedViewById(R.id.appview_download_progress_bar)).setIndeterminate(true);
                ((ImageView) _$_findCachedViewById(R.id.appview_download_pause_download)).setVisibility(8);
                ((ImageView) _$_findCachedViewById(R.id.appview_download_cancel_button)).setVisibility(8);
                ((ImageView) _$_findCachedViewById(R.id.appview_download_resume_download)).setVisibility(8);
                ((LinearLayout) _$_findCachedViewById(R.id.install_controls_layout)).setLayoutParams(layoutParams2);
                ((TextView) _$_findCachedViewById(R.id.appview_download_download_state)).setText(getString(R.string.appview_short_installing));
                break;
            case 6:
                String string = requireContext().getString(R.string.error_occured);
                kotlin.jvm.internal.m.e(string, "requireContext().getString(R.string.error_occured)");
                showErrorDialog(HttpUrl.FRAGMENT_ENCODE_SET, string);
                break;
            case 7:
                String string2 = requireContext().getString(R.string.out_of_space_dialog_title);
                kotlin.jvm.internal.m.e(string2, "requireContext().getStri…ut_of_space_dialog_title)");
                String string3 = requireContext().getString(R.string.out_of_space_dialog_message);
                kotlin.jvm.internal.m.e(string3, "requireContext().getStri…_of_space_dialog_message)");
                showErrorDialog(string2, string3);
                break;
        }
    }

    private final void showErrorDialog(String title, String message) {
        this.errorMessageSubscription = GenericDialogs.createGenericOkMessage(getContext(), title, message, getThemeManager().getAttributeForTheme(R.attr.dialogsTheme).resourceId).I0(rx.l.c.a.b()).H0(new rx.m.b() { // from class: cm.aptoide.pt.home.more.appcoins.c
            @Override // rx.m.b
            public final void call(Object obj) {
                EarnAppcListFragment.m179showErrorDialog$lambda3((GenericDialogs.EResponse) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.home.more.appcoins.b
            @Override // rx.m.b
            public final void call(Object obj) {
                EarnAppcListFragment.m180showErrorDialog$lambda4((Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: showErrorDialog$lambda-3, reason: not valid java name */
    public static final void m179showErrorDialog$lambda3(GenericDialogs.EResponse eResponse) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: showErrorDialog$lambda-4, reason: not valid java name */
    public static final void m180showErrorDialog$lambda4(Throwable th) {
        new OnErrorNotImplementedException(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: showRootInstallWarningPopup$lambda-5, reason: not valid java name */
    public static final Boolean m181showRootInstallWarningPopup$lambda5(GenericDialogs.EResponse eResponse) {
        return Boolean.valueOf(eResponse.equals(GenericDialogs.EResponse.YES));
    }

    @Override // cm.aptoide.pt.home.more.base.ListAppsFragment
    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // cm.aptoide.pt.home.more.base.ListAppsFragment
    public View _$_findCachedViewById(int i2) {
        View viewFindViewById;
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null || (viewFindViewById = view2.findViewById(i2)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), viewFindViewById);
        return viewFindViewById;
    }

    @Override // cm.aptoide.pt.home.more.appcoins.EarnAppcListView
    public rx.e<Void> cancelDownload() {
        rx.e<Void> eVarA = e.g.a.c.a.a((ImageView) _$_findCachedViewById(R.id.appview_download_cancel_button));
        kotlin.jvm.internal.m.e(eVarA, "clicks(appview_download_cancel_button)");
        return eVarA;
    }

    @Override // cm.aptoide.pt.home.more.base.ListAppsFragment
    public Function2<ViewGroup, Integer, EarnAppcListViewHolder> createViewHolder() {
        return AnonymousClass1.INSTANCE;
    }

    @Override // cm.aptoide.pt.home.more.base.ListAppsFragment
    public GridRecyclerView.AdaptStrategy getAdapterStrategy() {
        return GridRecyclerView.AdaptStrategy.SCALE_KEEP_ASPECT_RATIO;
    }

    @Override // cm.aptoide.pt.home.more.base.ListAppsFragment
    protected Rect getContainerPaddingDp() {
        return new Rect(8, 8, 8, 118);
    }

    @Override // cm.aptoide.pt.home.more.base.ListAppsFragment
    public int getItemSizeHeight() {
        return 158;
    }

    @Override // cm.aptoide.pt.home.more.base.ListAppsFragment
    public int getItemSizeWidth() {
        return 168;
    }

    public final EarnAppcListPresenter getPresenter() {
        EarnAppcListPresenter earnAppcListPresenter = this.presenter;
        if (earnAppcListPresenter != null) {
            return earnAppcListPresenter;
        }
        kotlin.jvm.internal.m.w("presenter");
        return null;
    }

    public final ThemeManager getThemeManager() {
        ThemeManager themeManager = this.themeManager;
        if (themeManager != null) {
            return themeManager;
        }
        kotlin.jvm.internal.m.w("themeManager");
        return null;
    }

    @Override // cm.aptoide.pt.home.more.appcoins.EarnAppcListView
    public void hideWalletArea() {
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.slide_down);
        animationLoadAnimation.setFillAfter(true);
        ((RelativeLayout) _$_findCachedViewById(R.id.app_cardview_layout)).startAnimation(animationLoadAnimation);
    }

    @Override // cm.aptoide.pt.home.more.base.ListAppsFragment, cm.aptoide.pt.view.fragment.NavigationTrackFragment, cm.aptoide.pt.view.fragment.FragmentView, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentComponent(savedInstanceState).inject(this);
    }

    @Override // cm.aptoide.pt.home.more.base.ListAppsFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        kotlin.jvm.internal.m.f(inflater, "inflater");
        View viewOnCreateView = super.onCreateView(inflater, container, savedInstanceState);
        if (viewOnCreateView == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        }
        ViewGroup viewGroup = (ViewGroup) viewOnCreateView;
        inflater.inflate(R.layout.earn_appcoins_wallet_install_layout, viewGroup);
        return viewGroup;
    }

    @Override // cm.aptoide.pt.view.fragment.FragmentView, cm.aptoide.pt.view.BaseFragment, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onDestroy() {
        rx.k kVar = this.errorMessageSubscription;
        if (kVar != null && !kVar.isUnsubscribed()) {
            kVar.unsubscribe();
        }
        super.onDestroy();
    }

    @Override // cm.aptoide.pt.home.more.base.ListAppsFragment, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // cm.aptoide.pt.home.more.base.ListAppsFragment, cm.aptoide.pt.view.fragment.NavigationTrackFragment, cm.aptoide.pt.view.BaseFragment, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        kotlin.jvm.internal.m.f(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getPresenter().present();
    }

    @Override // cm.aptoide.pt.home.more.appcoins.EarnAppcListView
    public rx.e<Void> onWalletInstallClick() {
        rx.e<Void> eVarA = e.g.a.c.a.a((Button) _$_findCachedViewById(R.id.wallet_install_button));
        kotlin.jvm.internal.m.e(eVarA, "clicks(wallet_install_button)");
        return eVarA;
    }

    @Override // cm.aptoide.pt.home.more.appcoins.EarnAppcListView
    public rx.e<Void> pauseDownload() {
        rx.e<Void> eVarA = e.g.a.c.a.a((ImageView) _$_findCachedViewById(R.id.appview_download_pause_download));
        kotlin.jvm.internal.m.e(eVarA, "clicks(appview_download_pause_download)");
        return eVarA;
    }

    @Override // cm.aptoide.pt.home.more.appcoins.EarnAppcListView
    public rx.e<Void> resumeDownload() {
        rx.e<Void> eVarA = e.g.a.c.a.a((ImageView) _$_findCachedViewById(R.id.appview_download_resume_download));
        kotlin.jvm.internal.m.e(eVarA, "clicks(appview_download_resume_download)");
        return eVarA;
    }

    public final void setPresenter(EarnAppcListPresenter earnAppcListPresenter) {
        kotlin.jvm.internal.m.f(earnAppcListPresenter, "<set-?>");
        this.presenter = earnAppcListPresenter;
    }

    public final void setThemeManager(ThemeManager themeManager) {
        kotlin.jvm.internal.m.f(themeManager, "<set-?>");
        this.themeManager = themeManager;
    }

    @Override // cm.aptoide.pt.home.more.appcoins.EarnAppcListView
    public void setupWallet(WalletApp walletApp) {
        kotlin.jvm.internal.m.f(walletApp, "walletApp");
        if (walletApp.isInstalled()) {
            return;
        }
        int i2 = R.id.app_cardview_layout;
        ((RelativeLayout) _$_findCachedViewById(i2)).startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.slide_up));
        ((RelativeLayout) _$_findCachedViewById(i2)).setVisibility(0);
        ((TextView) _$_findCachedViewById(R.id.wallet_app_title_textview)).setText(walletApp.getAppName());
        ((TextView) _$_findCachedViewById(R.id.rating_label)).setText(this.oneDecimalFormatter.format(Float.valueOf(walletApp.getRating())));
    }

    @Override // cm.aptoide.pt.home.more.appcoins.EarnAppcListView
    public void showDownloadError(WalletApp walletApp) {
        kotlin.jvm.internal.m.f(walletApp, "walletApp");
        DownloadModel downloadModel = walletApp.getDownloadModel();
        if (downloadModel == null || !downloadModel.hasError()) {
            return;
        }
        handleDownloadError(downloadModel.getDownloadState());
    }

    @Override // cm.aptoide.pt.home.more.appcoins.EarnAppcListView
    public rx.e<Boolean> showRootInstallWarningPopup() {
        rx.e eVarX = GenericDialogs.createGenericYesNoCancelMessage(requireContext(), null, getResources().getString(R.string.root_access_dialog), getThemeManager().getAttributeForTheme(R.attr.dialogsTheme).resourceId).X(new rx.m.e() { // from class: cm.aptoide.pt.home.more.appcoins.a
            @Override // rx.m.e
            public final Object call(Object obj) {
                return EarnAppcListFragment.m181showRootInstallWarningPopup$lambda5((GenericDialogs.EResponse) obj);
            }
        });
        kotlin.jvm.internal.m.e(eVarX, "createGenericYesNoCancel…cDialogs.EResponse.YES) }");
        return eVarX;
    }

    @Override // cm.aptoide.pt.home.more.appcoins.EarnAppcListView
    public void updateState(WalletApp walletApp) {
        kotlin.jvm.internal.m.f(walletApp, "walletApp");
        DownloadModel downloadModel = walletApp.getDownloadModel();
        if (downloadModel != null) {
            if (downloadModel.isDownloadingOrInstalling()) {
                ((LinearLayout) _$_findCachedViewById(R.id.appview_transfer_info)).setVisibility(0);
                ((Group) _$_findCachedViewById(R.id.install_group)).setVisibility(8);
                setDownloadState(downloadModel.getProgress(), downloadModel.getDownloadState());
            } else {
                if (walletApp.isInstalled()) {
                    return;
                }
                ((LinearLayout) _$_findCachedViewById(R.id.appview_transfer_info)).setVisibility(8);
                ((Group) _$_findCachedViewById(R.id.install_group)).setVisibility(0);
            }
        }
    }
}
