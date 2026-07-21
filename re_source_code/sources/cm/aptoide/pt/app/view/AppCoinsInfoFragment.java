package cm.aptoide.pt.app.view;

import android.animation.Animator;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import cm.aptoide.aptoideviews.socialmedia.SocialMediaView;
import cm.aptoide.aptoideviews.video.YoutubePlayer;
import cm.aptoide.pt.R;
import cm.aptoide.pt.editorial.ScrollEvent;
import cm.aptoide.pt.utils.AptoideUtils;
import cm.aptoide.pt.view.AppCoinsInfoPresenter;
import cm.aptoide.pt.view.BackButtonFragment;
import cm.aptoide.pt.view.NotBottomNavigationView;
import com.google.android.material.appbar.AppBarLayout;
import javax.inject.Inject;
import javax.inject.Named;

/* JADX INFO: loaded from: classes.dex */
public class AppCoinsInfoFragment extends BackButtonFragment implements AppCoinsInfoView, NotBottomNavigationView {
    private AppBarLayout appBarLayout;
    private View appCardView;
    private View appCardViewLayout;

    @Inject
    AppCoinsInfoPresenter appCoinsInfoPresenter;
    private TextView appcMessageAppCoinsSection1;
    private TextView appcMessageAppcoinsSection2a;
    private TextView appcMessageAppcoinsSection3;
    private View bottomAppCardView;
    private View bottomAppCardViewLayout;
    private Button bottomInstallButton;
    private Button catappultDevButton;
    private Button installButton;

    @Inject
    @Named
    float screenHeight;

    @Inject
    @Named
    float screenWidth;
    private NestedScrollView scrollView;
    private SocialMediaView socialMediaView;
    private Toolbar toolbar;
    private YoutubePlayer youtubePlayer;

    private void configureAppCardAnimation(final View view, final View view2, float f2, final int i2, final boolean z) {
        view.animate().scaleY(f2).scaleX(f2).alpha(0.0f).setDuration(i2).setListener(new Animator.AnimatorListener() { // from class: cm.aptoide.pt.app.view.AppCoinsInfoFragment.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (z) {
                    view.setVisibility(4);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                view2.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(i2).setListener(new Animator.AnimatorListener() { // from class: cm.aptoide.pt.app.view.AppCoinsInfoFragment.2.1
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator2) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator2) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator2) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator2) {
                        view2.setVisibility(0);
                    }
                }).start();
            }
        }).start();
    }

    private String getAppCoinsLogoString() {
        return String.format("<img width='45px' height='45px' style='vertical-align: text-bottom; ' src=\"%1$s\" />", Integer.valueOf(R.drawable.ic_aptoide_balance));
    }

    private Html.ImageGetter getImageGetter() {
        return new Html.ImageGetter() { // from class: cm.aptoide.pt.app.view.f
            @Override // android.text.Html.ImageGetter
            public final Drawable getDrawable(String str) {
                return this.a.f(str);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$appItemVisibilityChanged$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Boolean e(Object obj) {
        return Boolean.valueOf(isAppItemShown());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getImageGetter$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Drawable f(String str) {
        Drawable drawable = null;
        try {
            drawable = getResources().getDrawable(Integer.parseInt(str));
            drawable.setBounds(0, 0, 45, 45);
            return drawable;
        } catch (Resources.NotFoundException e2) {
            Log.e("log_tag", "Image not found. Check the ID.", e2);
            return drawable;
        } catch (NumberFormatException e3) {
            Log.e("log_tag", "Source string not a valid resource ID.", e3);
            return drawable;
        }
    }

    static /* synthetic */ void lambda$onViewCreated$0(View view, AppBarLayout appBarLayout, int i2) {
        float fAbs = 1.0f - (Math.abs(i2) / appBarLayout.getTotalScrollRange());
        view.findViewById(R.id.appc_header_text).setAlpha(fAbs);
        view.findViewById(R.id.app_graphic_guy).setAlpha(fAbs);
    }

    public static AppCoinsInfoFragment newInstance() {
        Bundle bundle = new Bundle();
        AppCoinsInfoFragment appCoinsInfoFragment = new AppCoinsInfoFragment();
        appCoinsInfoFragment.setArguments(bundle);
        return appCoinsInfoFragment;
    }

    private void setTextWithImage() {
        String strReplaceFirst = getString(R.string.appc_info_view_title_5_variable).replaceFirst("%s%", String.valueOf(25));
        int iLastIndexOf = strReplaceFirst.lastIndexOf("%s");
        if (iLastIndexOf != -1) {
            SpannableString spannableString = new SpannableString(strReplaceFirst);
            Drawable drawableF = androidx.core.content.a.f(getActivity().getApplicationContext(), R.drawable.ic_aptoide_balance);
            drawableF.setBounds(0, 0, 45, 45);
            spannableString.setSpan(new ImageSpan(drawableF, 1), iLastIndexOf, iLastIndexOf + 2, 33);
            this.appcMessageAppcoinsSection3.setText(spannableString);
        }
    }

    private void setupBottomAppBar() {
        this.bottomAppCardView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: cm.aptoide.pt.app.view.AppCoinsInfoFragment.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (!AppCoinsInfoFragment.this.isAppItemShown()) {
                    AppCoinsInfoFragment.this.addBottomCardAnimation();
                }
                AppCoinsInfoFragment.this.bottomAppCardView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
    }

    private void setupTextView(String str, TextView textView, Object... objArr) {
        textView.setText(Html.fromHtml(String.format(str, objArr), getImageGetter(), null));
    }

    private void setupToolbar() {
        this.toolbar.setTitle(R.string.appc_title_about_appcoins);
        this.toolbar.setTitleTextColor(-1);
        this.toolbar.setSubtitleTextColor(-1);
        androidx.appcompat.app.d dVar = (androidx.appcompat.app.d) getActivity();
        dVar.setSupportActionBar(this.toolbar);
        androidx.appcompat.app.a supportActionBar = dVar.getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.r(true);
        }
    }

    @Override // cm.aptoide.pt.app.view.AppCoinsInfoView
    public void addBottomCardAnimation() {
        configureAppCardAnimation(this.appCardViewLayout, this.bottomAppCardViewLayout, 0.1f, 300, false);
    }

    @Override // cm.aptoide.pt.app.view.AppCoinsInfoView
    public rx.e<Void> appCoinsWalletLinkClick() {
        return e.g.a.c.a.a(this.appcMessageAppcoinsSection2a);
    }

    @Override // cm.aptoide.pt.app.view.AppCoinsInfoView
    public rx.e<ScrollEvent> appItemVisibilityChanged() {
        return rx.e.f0(e.g.a.b.b.a.b.a(this.scrollView), e.g.a.b.a.a.b.a(this.appBarLayout)).X(new rx.m.e() { // from class: cm.aptoide.pt.app.view.g
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4307f.e(obj);
            }
        }).X(new rx.m.e() { // from class: cm.aptoide.pt.app.view.b
            @Override // rx.m.e
            public final Object call(Object obj) {
                return new ScrollEvent((Boolean) obj);
            }
        }).u(new rx.m.e() { // from class: cm.aptoide.pt.app.view.dg
            @Override // rx.m.e
            public final Object call(Object obj) {
                return ((ScrollEvent) obj).getItemShown();
            }
        });
    }

    @Override // cm.aptoide.pt.app.view.AppCoinsInfoView
    public rx.e<Void> cardViewClick() {
        return e.g.a.c.a.a(this.appCardView);
    }

    @Override // cm.aptoide.pt.app.view.AppCoinsInfoView
    public rx.e<Void> catappultButtonClick() {
        return e.g.a.c.a.a(this.catappultDevButton);
    }

    @Override // cm.aptoide.pt.view.fragment.NavigationTrackFragment
    public ScreenTagHistory getHistoryTracker() {
        return ScreenTagHistory.Builder.build(getClass().getSimpleName());
    }

    @Override // cm.aptoide.pt.app.view.AppCoinsInfoView
    public rx.e<Void> installButtonClick() {
        return rx.e.a0(e.g.a.c.a.a(this.installButton), e.g.a.c.a.a(this.bottomInstallButton));
    }

    public boolean isAppItemShown() {
        Rect rect = new Rect();
        this.appCardView.getLocalVisibleRect(rect);
        return rect.intersect(new Rect(0, 0, (int) this.screenWidth, ((int) this.screenHeight) - (this.appCardView.getHeight() * 2)));
    }

    @Override // cm.aptoide.pt.view.fragment.NavigationTrackFragment, cm.aptoide.pt.view.fragment.FragmentView, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getFragmentComponent(bundle).inject(this);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_appcoins_info, viewGroup, false);
    }

    @Override // cm.aptoide.pt.view.fragment.FragmentView, cm.aptoide.pt.view.BaseFragment, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.toolbar = null;
        this.appCardView = null;
        this.installButton = null;
        this.bottomInstallButton = null;
        this.catappultDevButton = null;
        this.appcMessageAppCoinsSection1 = null;
        this.appcMessageAppcoinsSection2a = null;
        this.appcMessageAppcoinsSection3 = null;
        this.youtubePlayer = null;
        this.scrollView = null;
        this.socialMediaView = null;
        super.onDestroyView();
    }

    @Override // cm.aptoide.pt.view.fragment.NavigationTrackFragment, cm.aptoide.pt.view.BaseFragment, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onViewCreated(final View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        this.catappultDevButton = (Button) view.findViewById(R.id.catappult_dev_button);
        this.scrollView = (NestedScrollView) view.findViewById(R.id.about_appcoins_scroll);
        this.appcMessageAppcoinsSection2a = (TextView) view.findViewById(R.id.appc_message_appcoins_section_2a);
        this.appcMessageAppcoinsSection3 = (TextView) view.findViewById(R.id.appc_message_appcoins_section_3);
        this.youtubePlayer = (YoutubePlayer) view.findViewById(R.id.youtube_player);
        this.appcMessageAppCoinsSection1 = (TextView) view.findViewById(R.id.appc_message_appcoins_section_1);
        View viewFindViewById = view.findViewById(R.id.app_card_layout);
        this.appCardViewLayout = viewFindViewById;
        this.appCardView = viewFindViewById.findViewById(R.id.app_cardview);
        this.installButton = (Button) this.appCardViewLayout.findViewById(R.id.appview_install_button);
        ((TextView) this.appCardView.findViewById(R.id.app_title_textview)).setText(getString(R.string.appc_title_settings_appcoins_wallet));
        ((ImageView) this.appCardView.findViewById(R.id.app_icon_imageview)).setImageDrawable(androidx.core.content.a.f(getContext(), R.drawable.appcoins_wallet_icon));
        View viewFindViewById2 = view.findViewById(R.id.app_cardview_layout);
        this.bottomAppCardViewLayout = viewFindViewById2;
        this.bottomAppCardView = viewFindViewById2.findViewById(R.id.app_cardview);
        this.bottomInstallButton = (Button) this.bottomAppCardViewLayout.findViewById(R.id.appview_install_button);
        ((TextView) this.bottomAppCardView.findViewById(R.id.app_title_textview)).setText(getString(R.string.appc_title_settings_appcoins_wallet));
        ((ImageView) this.bottomAppCardView.findViewById(R.id.app_icon_imageview)).setImageDrawable(androidx.core.content.a.f(getContext(), R.drawable.appcoins_wallet_icon));
        AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(R.id.app_bar_layout);
        this.appBarLayout = appBarLayout;
        appBarLayout.b(new AppBarLayout.e() { // from class: cm.aptoide.pt.app.view.e
            @Override // com.google.android.material.appbar.AppBarLayout.c
            public final void onOffsetChanged(AppBarLayout appBarLayout2, int i2) {
                AppCoinsInfoFragment.lambda$onViewCreated$0(view, appBarLayout2, i2);
            }
        });
        this.socialMediaView = (SocialMediaView) view.findViewById(R.id.social_media_view);
        setHasOptionsMenu(true);
        setupToolbar();
        setupBottomAppBar();
        this.youtubePlayer.loadVideo("y8YEczs9DJ0", false);
        attachPresenter(this.appCoinsInfoPresenter);
    }

    @Override // cm.aptoide.pt.app.view.AppCoinsInfoView
    public void openApp(String str) {
        AptoideUtils.SystemU.openApp(str, getContext().getPackageManager(), getContext());
    }

    @Override // cm.aptoide.pt.app.view.AppCoinsInfoView
    public void removeBottomCardAnimation() {
        configureAppCardAnimation(this.bottomAppCardViewLayout, this.appCardViewLayout, 0.0f, 300, true);
    }

    @Override // cm.aptoide.pt.app.view.AppCoinsInfoView
    public void setBonusAppc(int i2) {
        this.appcMessageAppCoinsSection1.setText(String.format(getString(R.string.appc_info_view_body_1_variable), Integer.valueOf(i2)));
        setTextWithImage();
    }

    @Override // cm.aptoide.pt.app.view.AppCoinsInfoView
    public void setButtonText(boolean z) {
        String string = getResources().getString(R.string.appview_button_install);
        if (z) {
            this.installButton.setText(getResources().getString(R.string.appview_button_open));
            this.bottomInstallButton.setText(getResources().getString(R.string.appview_button_open));
        } else {
            this.installButton.setText(string);
            this.bottomInstallButton.setText(string);
        }
    }

    @Override // cm.aptoide.pt.app.view.AppCoinsInfoView
    public void setNoBonusAppcView() {
        this.appcMessageAppCoinsSection1.setText(getString(R.string.appc_info_view_body_1_variable_no_data));
        setupTextView(getString(R.string.appc_info_view_title_5_variable_no_data), this.appcMessageAppcoinsSection3, getAppCoinsLogoString());
    }

    @Override // cm.aptoide.pt.app.view.AppCoinsInfoView
    public rx.e<SocialMediaView.SocialMediaType> socialMediaClick() {
        return this.socialMediaView.onSocialMediaClick();
    }
}
