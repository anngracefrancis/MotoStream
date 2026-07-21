package cm.aptoide.pt.home;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import cm.aptoide.pt.R;
import cm.aptoide.pt.bottomNavigation.BottomNavigationActivity;
import cm.aptoide.pt.bottomNavigation.BottomNavigationItem;
import cm.aptoide.pt.dataprovider.ws.v7.store.StoreContext;
import cm.aptoide.pt.networking.image.ImageLoader;
import cm.aptoide.pt.promotions.PromotionsHomeDialog;
import cm.aptoide.pt.themes.ThemeManager;
import cm.aptoide.pt.view.fragment.NavigationTrackFragment;
import com.google.android.material.appbar.AppBarLayout;
import javax.inject.Inject;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes.dex */
public class HomeContainerFragment extends NavigationTrackFragment implements HomeContainerView {
    private static final BottomNavigationItem BOTTOM_NAVIGATION_ITEM = BottomNavigationItem.HOME;
    private AppBarLayout appBarLayout;
    private CheckBox appsChip;
    private BottomNavigationActivity bottomNavigationActivity;
    private rx.s.b<ChipsEvents> chipCheckedEvent;
    private CheckBox gamesChip;
    private LoggedInTermsAndConditionsDialog gdprDialog;

    @Inject
    HomeContainerPresenter presenter;
    private PromotionsHomeDialog promotionsHomeDialog;
    private ImageView promotionsIcon;
    private TextView promotionsTicker;

    @Inject
    ThemeManager themeManager;
    private ImageView userAvatar;

    public enum ChipsEvents {
        GAMES,
        APPS,
        HOME
    }

    private void hideChipCancelButton(CheckBox checkBox) {
        if (Build.VERSION.SDK_INT >= 17) {
            checkBox.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            checkBox.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$appsChipClicked$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Boolean e(Void r1) {
        return Boolean.valueOf(this.appsChip.isChecked());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$appsChipClicked$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(Boolean bool) {
        if (this.gamesChip.isChecked()) {
            this.gamesChip.setChecked(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$gamesChipClicked$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Boolean g(Void r1) {
        return Boolean.valueOf(this.gamesChip.isChecked());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$gamesChipClicked$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h(Boolean bool) {
        if (this.appsChip.isChecked()) {
            this.appsChip.setChecked(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setupChipsListeners$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i(CompoundButton compoundButton, boolean z) {
        if (z) {
            showChipCancelButton(this.gamesChip);
        } else {
            hideChipCancelButton(this.gamesChip);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setupChipsListeners$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j(CompoundButton compoundButton, boolean z) {
        if (z) {
            showChipCancelButton(this.appsChip);
        } else {
            hideChipCancelButton(this.appsChip);
        }
    }

    private void setupChipsListeners() {
        this.gamesChip.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: cm.aptoide.pt.home.o
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.a.i(compoundButton, z);
            }
        });
        this.appsChip.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: cm.aptoide.pt.home.p
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.a.j(compoundButton, z);
            }
        });
    }

    private void showChipCancelButton(CheckBox checkBox) {
        Drawable drawable = getResources().getDrawable(this.themeManager.getAttributeForTheme(R.attr.cancelChipDrawable).resourceId);
        if (Build.VERSION.SDK_INT >= 17) {
            checkBox.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        } else {
            checkBox.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        }
    }

    @Override // cm.aptoide.pt.home.HomeContainerView
    public rx.e<Boolean> appsChipClicked() {
        return e.g.a.c.a.a(this.appsChip).X(new rx.m.e() { // from class: cm.aptoide.pt.home.s
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6303f.e((Void) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.home.r
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6292f.f((Boolean) obj);
            }
        });
    }

    @Override // cm.aptoide.pt.home.HomeContainerView
    public void dismissPromotionsDialog() {
        this.promotionsHomeDialog.dismissDialog();
    }

    @Override // cm.aptoide.pt.home.HomeContainerView
    public void expandChips() {
        this.appBarLayout.r(true, true);
    }

    @Override // cm.aptoide.pt.home.HomeContainerView
    public rx.e<Boolean> gamesChipClicked() {
        return e.g.a.c.a.a(this.gamesChip).X(new rx.m.e() { // from class: cm.aptoide.pt.home.q
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6280f.g((Void) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.home.n
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6249f.h((Boolean) obj);
            }
        });
    }

    @Override // cm.aptoide.pt.home.HomeContainerView
    public rx.e<String> gdprDialogClicked() {
        return this.gdprDialog.dialogClicked();
    }

    @Override // cm.aptoide.pt.view.fragment.NavigationTrackFragment
    public ScreenTagHistory getHistoryTracker() {
        return ScreenTagHistory.Builder.build(getClass().getSimpleName(), HttpUrl.FRAGMENT_ENCODE_SET, StoreContext.home.name());
    }

    @Override // cm.aptoide.pt.home.HomeContainerView
    public void hidePromotionsIcon() {
        this.promotionsIcon.setVisibility(8);
        this.promotionsTicker.setVisibility(8);
    }

    @Override // cm.aptoide.pt.home.HomeContainerView
    public rx.e<ChipsEvents> isChipChecked() {
        return this.chipCheckedEvent;
    }

    @Override // cm.aptoide.pt.view.fragment.FragmentView, cm.aptoide.pt.view.BaseFragment, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof BottomNavigationActivity) {
            this.bottomNavigationActivity = (BottomNavigationActivity) activity;
        }
    }

    @Override // cm.aptoide.pt.view.fragment.NavigationTrackFragment, cm.aptoide.pt.view.fragment.FragmentView, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getFragmentComponent(bundle).inject(this);
        this.chipCheckedEvent = rx.s.b.g1();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_home_container, viewGroup, false);
    }

    @Override // cm.aptoide.pt.view.fragment.FragmentView, cm.aptoide.pt.view.BaseFragment, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        PromotionsHomeDialog promotionsHomeDialog = this.promotionsHomeDialog;
        if (promotionsHomeDialog != null) {
            promotionsHomeDialog.destroyDialog();
            this.promotionsHomeDialog = null;
        }
        LoggedInTermsAndConditionsDialog loggedInTermsAndConditionsDialog = this.gdprDialog;
        if (loggedInTermsAndConditionsDialog != null) {
            loggedInTermsAndConditionsDialog.destroyDialog();
            this.gdprDialog = null;
        }
        this.promotionsIcon = null;
        this.promotionsTicker = null;
        this.userAvatar = null;
        this.gamesChip = null;
        this.appsChip = null;
    }

    @Override // cm.aptoide.pt.view.BaseFragment, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onDetach() {
        this.bottomNavigationActivity = null;
        super.onDetach();
    }

    @Override // cm.aptoide.pt.view.fragment.NavigationTrackFragment, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ChipsEvents chipsEvents = ChipsEvents.HOME;
        if (this.gamesChip.isChecked()) {
            chipsEvents = ChipsEvents.GAMES;
        } else if (this.appsChip.isChecked()) {
            chipsEvents = ChipsEvents.APPS;
        }
        this.chipCheckedEvent.onNext(chipsEvents);
    }

    @Override // cm.aptoide.pt.view.fragment.NavigationTrackFragment, cm.aptoide.pt.view.BaseFragment, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.userAvatar = (ImageView) view.findViewById(R.id.user_actionbar_icon);
        this.promotionsIcon = (ImageView) view.findViewById(R.id.promotions_icon);
        this.promotionsTicker = (TextView) view.findViewById(R.id.promotions_ticker);
        this.promotionsHomeDialog = new PromotionsHomeDialog(getContext());
        this.gdprDialog = new LoggedInTermsAndConditionsDialog(getContext());
        BottomNavigationActivity bottomNavigationActivity = this.bottomNavigationActivity;
        if (bottomNavigationActivity != null) {
            bottomNavigationActivity.requestFocus(BOTTOM_NAVIGATION_ITEM);
        }
        this.gamesChip = (CheckBox) view.findViewById(R.id.games_chip);
        this.appsChip = (CheckBox) view.findViewById(R.id.apps_chip);
        this.appBarLayout = (AppBarLayout) view.findViewById(R.id.app_bar_layout);
        setupChipsListeners();
        attachPresenter(this.presenter);
    }

    @Override // cm.aptoide.pt.home.HomeContainerView
    public rx.e<String> promotionsHomeDialogClicked() {
        return this.promotionsHomeDialog.dialogClicked();
    }

    @Override // cm.aptoide.pt.home.HomeContainerView
    public void setDefaultUserImage() {
        ImageLoader.with(getContext()).loadUsingCircleTransform(R.drawable.ic_account_circle, this.userAvatar);
    }

    @Override // cm.aptoide.pt.home.HomeContainerView
    public void setUserImage(String str) {
        ImageLoader.with(getContext()).loadWithShadowCircleTransformWithPlaceholder(str, this.userAvatar, R.drawable.ic_account_circle);
    }

    @Override // cm.aptoide.pt.home.HomeContainerView
    public void showAvatar() {
        this.userAvatar.setVisibility(0);
    }

    @Override // cm.aptoide.pt.home.HomeContainerView
    public void showPromotionsHomeDialog(HomePromotionsWrapper homePromotionsWrapper) {
        this.promotionsHomeDialog.showDialog(homePromotionsWrapper);
    }

    @Override // cm.aptoide.pt.home.HomeContainerView
    public void showPromotionsHomeIcon(HomePromotionsWrapper homePromotionsWrapper) {
        this.promotionsIcon.setVisibility(0);
        if (homePromotionsWrapper.getPromotions() > 0) {
            if (homePromotionsWrapper.getPromotions() >= 10 || homePromotionsWrapper.getTotalUnclaimedAppcValue() <= 0.0f) {
                this.promotionsTicker.setText("9+");
            } else {
                this.promotionsTicker.setText(Integer.toString(homePromotionsWrapper.getPromotions()));
            }
            this.promotionsTicker.setVisibility(0);
        }
    }

    @Override // cm.aptoide.pt.home.HomeContainerView
    public void showTermsAndConditionsDialog() {
        this.gdprDialog.showDialog();
    }

    @Override // cm.aptoide.pt.home.HomeContainerView
    public rx.e<Void> toolbarPromotionsClick() {
        return e.g.a.c.a.a(this.promotionsIcon);
    }

    @Override // cm.aptoide.pt.home.HomeContainerView
    public rx.e<Void> toolbarUserClick() {
        return e.g.a.c.a.a(this.userAvatar);
    }

    @Override // cm.aptoide.pt.home.HomeContainerView
    public void uncheckChips() {
        this.gamesChip.setChecked(false);
        this.appsChip.setChecked(false);
    }
}
