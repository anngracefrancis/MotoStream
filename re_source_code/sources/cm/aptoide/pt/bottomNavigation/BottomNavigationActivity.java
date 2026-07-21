package cm.aptoide.pt.bottomNavigation;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.fragment.app.Fragment;
import cm.aptoide.pt.R;
import cm.aptoide.pt.account.view.LoginBottomSheetActivity;
import cm.aptoide.pt.home.AptoideBottomNavigator;
import cm.aptoide.pt.view.DarkBottomNavigationView;
import cm.aptoide.pt.view.NotBottomNavigationView;
import cm.aptoide.pt.view.ThemedActivityView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import javax.inject.Inject;
import rx.e;

/* JADX INFO: loaded from: classes.dex */
public abstract class BottomNavigationActivity extends LoginBottomSheetActivity implements AptoideBottomNavigator {
    protected static final int LAYOUT = 2131493047;
    private final String ITEMS_LIST_KEY = "BN_ITEMS";
    private Animation animationdown;
    private Animation animationup;

    @Inject
    BottomNavigationMapper bottomNavigationMapper;

    @Inject
    BottomNavigationNavigator bottomNavigationNavigator;
    protected BottomNavigationView bottomNavigationView;
    private Boolean isThemeEnforced;
    private rx.s.b<Integer> navigationSubject;

    @SuppressLint({"ResourceType"})
    private void forceDarkTheme() {
        if (this.isThemeEnforced.booleanValue()) {
            return;
        }
        this.bottomNavigationView.animate().alpha(0.0f).setDuration(200L).withEndAction(new Runnable() { // from class: cm.aptoide.pt.bottomNavigation.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f4765f.c();
            }
        });
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getActivity().getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(androidx.core.content.a.d(getBaseContext(), R.color.grey_900));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$forceDarkTheme$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c() {
        this.bottomNavigationView.setBackgroundColor(getResources().getColor(R.color.grey_900));
        this.bottomNavigationView.setItemIconTintList(androidx.core.content.a.e(this, R.drawable.default_nav_item_color_state_dark));
        this.bottomNavigationView.setItemTextColor(androidx.core.content.a.e(this, R.drawable.default_nav_item_color_state_dark));
        this.isThemeEnforced = Boolean.TRUE;
        this.bottomNavigationView.animate().alpha(1.0f).setDuration(200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$onCreate$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean d(MenuItem menuItem) {
        this.navigationSubject.onNext(Integer.valueOf(menuItem.getItemId()));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setDefaultTheme$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e() {
        this.bottomNavigationView.setItemIconTintList(androidx.core.content.a.e(this, R.drawable.default_nav_item_color_state));
        this.bottomNavigationView.setItemTextColor(androidx.core.content.a.e(this, R.drawable.default_nav_item_color_state));
        this.bottomNavigationView.setBackgroundColor(0);
        this.isThemeEnforced = Boolean.FALSE;
        this.bottomNavigationView.animate().alpha(1.0f).setDuration(200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$toggleBottomNavigation$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean f(MenuItem menuItem) {
        this.navigationSubject.onNext(Integer.valueOf(menuItem.getItemId()));
        return true;
    }

    @SuppressLint({"ResourceType"})
    private void setDefaultTheme() {
        this.bottomNavigationView.animate().alpha(0.0f).setDuration(200L).withEndAction(new Runnable() { // from class: cm.aptoide.pt.bottomNavigation.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f4766f.e();
            }
        });
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getActivity().getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(androidx.core.content.a.d(getBaseContext(), R.color.status_bar_color));
        }
    }

    @Override // cm.aptoide.pt.home.AptoideBottomNavigator
    public void hideBottomNavigation() {
        if (this.bottomNavigationView.getVisibility() != 8) {
            this.bottomNavigationView.setVisibility(8);
        }
    }

    @Override // cm.aptoide.pt.home.AptoideBottomNavigator
    public e<Integer> navigationEvent() {
        return this.navigationSubject;
    }

    @Override // cm.aptoide.pt.view.BackButtonActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (getFragmentNavigator().peekLast() == null && this.bottomNavigationNavigator.canNavigateBack()) {
            this.bottomNavigationNavigator.navigateBack();
        } else {
            super.onBackPressed();
        }
    }

    @Override // cm.aptoide.pt.account.view.LoginBottomSheetActivity, cm.aptoide.pt.view.BackButtonActivity, cm.aptoide.pt.view.ThemedActivityView, cm.aptoide.pt.analytics.view.AnalyticsActivity, cm.aptoide.pt.permission.PermissionProviderActivity, cm.aptoide.pt.permission.PermissionServiceActivity, cm.aptoide.pt.navigator.ActivityResultNavigator, cm.aptoide.pt.view.BaseActivity, com.trello.rxlifecycle.h.a.a, androidx.appcompat.app.d, androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.frame_layout);
        this.navigationSubject = rx.s.b.g1();
        this.bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        getActivityComponent().inject(this);
        if (bundle != null) {
            this.bottomNavigationNavigator.setBottomNavigationItems(bundle.getIntegerArrayList("BN_ITEMS"));
        }
        this.bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.d() { // from class: cm.aptoide.pt.bottomNavigation.d
            @Override // com.google.android.material.bottomnavigation.BottomNavigationView.d
            public final boolean a(MenuItem menuItem) {
                return this.a.d(menuItem);
            }
        });
        this.animationup = AnimationUtils.loadAnimation(this, R.anim.slide_up);
        this.animationdown = AnimationUtils.loadAnimation(this, R.anim.slide_down);
        this.isThemeEnforced = Boolean.FALSE;
        toggleBottomNavigation();
    }

    @Override // cm.aptoide.pt.view.BaseActivity, com.trello.rxlifecycle.h.a.a, androidx.appcompat.app.d, androidx.fragment.app.d, android.app.Activity
    protected void onDestroy() {
        this.bottomNavigationMapper = null;
        this.bottomNavigationNavigator = null;
        this.navigationSubject = null;
        this.bottomNavigationView = null;
        this.animationdown = null;
        this.animationup = null;
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.d, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putIntegerArrayList("BN_ITEMS", this.bottomNavigationNavigator.getBottomNavigationItems());
    }

    @Override // cm.aptoide.pt.home.AptoideBottomNavigator
    public void requestFocus(BottomNavigationItem bottomNavigationItem) {
        this.bottomNavigationView.getMenu().getItem(this.bottomNavigationMapper.mapToBottomNavigationPosition(bottomNavigationItem)).setChecked(true);
    }

    @Override // cm.aptoide.pt.home.AptoideBottomNavigator
    public void showFragment(Integer num) {
        this.bottomNavigationNavigator.navigateToBottomNavigationItem(this.bottomNavigationMapper.mapToBottomNavigationPosition(num));
    }

    @Override // cm.aptoide.pt.home.AptoideBottomNavigator
    public void toggleBottomNavigation() {
        Fragment fragment = getFragmentNavigator().getFragment();
        if (fragment instanceof NotBottomNavigationView) {
            if (this.bottomNavigationView.getVisibility() != 8) {
                this.bottomNavigationView.startAnimation(this.animationdown);
                this.bottomNavigationView.setVisibility(8);
                return;
            }
            return;
        }
        if ((fragment instanceof DarkBottomNavigationView) && !((ThemedActivityView) this).themeManager.isThemeDark()) {
            forceDarkTheme();
            return;
        }
        if (this.isThemeEnforced.booleanValue() && !((ThemedActivityView) this).themeManager.isThemeDark()) {
            setDefaultTheme();
        }
        if (this.bottomNavigationView.getVisibility() != 0) {
            this.bottomNavigationView.startAnimation(this.animationup);
            this.bottomNavigationView.setVisibility(0);
        }
        getActivityComponent().inject(this);
        this.bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.d() { // from class: cm.aptoide.pt.bottomNavigation.c
            @Override // com.google.android.material.bottomnavigation.BottomNavigationView.d
            public final boolean a(MenuItem menuItem) {
                return this.a.f(menuItem);
            }
        });
    }
}
