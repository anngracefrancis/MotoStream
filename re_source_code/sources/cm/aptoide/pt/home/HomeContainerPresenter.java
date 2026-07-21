package cm.aptoide.pt.home;

import cm.aptoide.accountmanager.Account;
import cm.aptoide.accountmanager.AptoideAccountManager;
import cm.aptoide.pt.presenter.Presenter;
import cm.aptoide.pt.presenter.View;
import rx.Single;
import rx.exceptions.OnErrorNotImplementedException;

/* JADX INFO: loaded from: classes.dex */
public class HomeContainerPresenter implements Presenter {
    private final AptoideAccountManager accountManager;
    private final ChipManager chipManager;
    private final Home home;
    private final HomeAnalytics homeAnalytics;
    private final HomeContainerNavigator homeContainerNavigator;
    private final HomeNavigator homeNavigator;
    private final HomeContainerView view;
    private final rx.h viewScheduler;

    /* JADX INFO: renamed from: cm.aptoide.pt.home.HomeContainerPresenter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$home$HomeContainerFragment$ChipsEvents;

        static {
            int[] iArr = new int[HomeContainerFragment.ChipsEvents.values().length];
            $SwitchMap$cm$aptoide$pt$home$HomeContainerFragment$ChipsEvents = iArr;
            try {
                iArr[HomeContainerFragment.ChipsEvents.GAMES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$home$HomeContainerFragment$ChipsEvents[HomeContainerFragment.ChipsEvents.APPS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public HomeContainerPresenter(HomeContainerView homeContainerView, rx.h hVar, AptoideAccountManager aptoideAccountManager, HomeContainerNavigator homeContainerNavigator, HomeNavigator homeNavigator, HomeAnalytics homeAnalytics, Home home, ChipManager chipManager) {
        this.view = homeContainerView;
        this.viewScheduler = hVar;
        this.accountManager = aptoideAccountManager;
        this.homeContainerNavigator = homeContainerNavigator;
        this.homeNavigator = homeNavigator;
        this.homeAnalytics = homeAnalytics;
        this.home = home;
        this.chipManager = chipManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getUserAvatar, reason: merged with bridge method [inline-methods] */
    public rx.e<String> G(Account account) {
        return rx.e.S((account == null || !account.isLoggedIn()) ? null : account.getAvatar());
    }

    private void handleBottomNavigationEvents() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.u0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.y0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6371f.e((View.LifecycleEvent) obj);
            }
        }).j0(this.viewScheduler).G(new rx.m.e() { // from class: cm.aptoide.pt.home.l0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6125f.f((Integer) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.home.a1
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f5679f.g((Boolean) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.home.m2
            @Override // rx.m.b
            public final void call(Object obj) {
                HomeContainerPresenter.lambda$handleBottomNavigationEvents$9((Boolean) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.home.u2
            @Override // rx.m.b
            public final void call(Object obj) {
                HomeContainerPresenter.lambda$handleBottomNavigationEvents$10((Throwable) obj);
                throw null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$checkForPromotionApps$28, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single a(View.LifecycleEvent lifecycleEvent) {
        return this.home.hasPromotionApps();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$checkForPromotionApps$29, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(HomePromotionsWrapper homePromotionsWrapper) {
        this.view.showPromotionsHomeIcon(homePromotionsWrapper);
        this.homeAnalytics.sendPromotionsImpressionEvent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$checkForPromotionApps$30, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c(HomePromotionsWrapper homePromotionsWrapper) {
        this.homeAnalytics.sendPromotionsDialogImpressionEvent();
        this.home.setPromotionsDialogShown();
        this.view.showPromotionsHomeDialog(homePromotionsWrapper);
    }

    static /* synthetic */ void lambda$checkForPromotionApps$31(HomePromotionsWrapper homePromotionsWrapper) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$checkForPromotionApps$32, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d(Throwable th) {
        this.view.hidePromotionsIcon();
    }

    static /* synthetic */ void lambda$handleBottomNavigationEvents$10(Throwable th) {
        throw new OnErrorNotImplementedException(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleBottomNavigationEvents$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e e(View.LifecycleEvent lifecycleEvent) {
        return this.homeNavigator.bottomNavigation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleBottomNavigationEvents$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e f(Integer num) {
        return this.homeContainerNavigator.navigateHome();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleBottomNavigationEvents$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g(Boolean bool) {
        this.view.expandChips();
        if (bool.booleanValue()) {
            this.homeContainerNavigator.loadMainHomeContent();
            this.chipManager.setCurrentChip(null);
            this.view.uncheckChips();
        }
    }

    static /* synthetic */ void lambda$handleBottomNavigationEvents$9(Boolean bool) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleClickOnAppsChip$81, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e h(View.LifecycleEvent lifecycleEvent) {
        return this.view.appsChipClicked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleClickOnAppsChip$82, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i(Boolean bool) {
        if (bool.booleanValue()) {
            this.homeContainerNavigator.loadAppsHomeContent();
            this.chipManager.setCurrentChip(ChipManager.Chip.APPS);
        } else {
            this.homeContainerNavigator.loadMainHomeContent();
            this.chipManager.setCurrentChip(null);
        }
        HomeAnalytics homeAnalytics = this.homeAnalytics;
        ChipManager.Chip chip = ChipManager.Chip.APPS;
        homeAnalytics.sendChipInteractEvent(chip.getName());
        this.homeAnalytics.sendChipHomeInteractEvent(chip.getName());
    }

    static /* synthetic */ void lambda$handleClickOnAppsChip$83(Boolean bool) {
    }

    static /* synthetic */ void lambda$handleClickOnAppsChip$84(Throwable th) {
        throw new OnErrorNotImplementedException(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleClickOnGamesChip$76, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e j(View.LifecycleEvent lifecycleEvent) {
        return this.view.gamesChipClicked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleClickOnGamesChip$77, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k(Boolean bool) {
        if (bool.booleanValue()) {
            this.homeContainerNavigator.loadGamesHomeContent();
            this.chipManager.setCurrentChip(ChipManager.Chip.GAMES);
        } else {
            this.homeContainerNavigator.loadMainHomeContent();
            this.chipManager.setCurrentChip(null);
        }
        HomeAnalytics homeAnalytics = this.homeAnalytics;
        ChipManager.Chip chip = ChipManager.Chip.GAMES;
        homeAnalytics.sendChipInteractEvent(chip.getName());
        this.homeAnalytics.sendChipHomeInteractEvent(chip.getName());
    }

    static /* synthetic */ void lambda$handleClickOnGamesChip$78(Boolean bool) {
    }

    static /* synthetic */ void lambda$handleClickOnGamesChip$79(Throwable th) {
        throw new OnErrorNotImplementedException(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleClickOnPrivacyPolicy$70, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e l(View.LifecycleEvent lifecycleEvent) {
        return this.view.gdprDialogClicked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleClickOnPrivacyPolicy$72, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void m(String str) {
        this.homeNavigator.navigateToPrivacyPolicy();
    }

    static /* synthetic */ void lambda$handleClickOnPrivacyPolicy$73(String str) {
    }

    static /* synthetic */ void lambda$handleClickOnPrivacyPolicy$74(Throwable th) {
        throw new OnErrorNotImplementedException(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleClickOnPromotionsDialogCancel$40, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e n(View.LifecycleEvent lifecycleEvent) {
        return this.view.promotionsHomeDialogClicked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleClickOnPromotionsDialogCancel$42, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void o(String str) {
        this.homeAnalytics.sendPromotionsDialogDismissEvent();
        this.view.dismissPromotionsDialog();
    }

    static /* synthetic */ void lambda$handleClickOnPromotionsDialogCancel$43(String str) {
    }

    static /* synthetic */ void lambda$handleClickOnPromotionsDialogCancel$44(Throwable th) {
        throw new OnErrorNotImplementedException(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleClickOnPromotionsDialogContinue$34, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e p(View.LifecycleEvent lifecycleEvent) {
        return this.view.promotionsHomeDialogClicked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleClickOnPromotionsDialogContinue$36, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void q(String str) {
        this.homeAnalytics.sendPromotionsDialogNavigateEvent();
        this.view.dismissPromotionsDialog();
        this.homeNavigator.navigateToPromotions();
    }

    static /* synthetic */ void lambda$handleClickOnPromotionsDialogContinue$37(String str) {
    }

    static /* synthetic */ void lambda$handleClickOnPromotionsDialogContinue$38(Throwable th) {
        throw new OnErrorNotImplementedException(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleClickOnTermsAndConditions$64, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e r(View.LifecycleEvent lifecycleEvent) {
        return this.view.gdprDialogClicked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleClickOnTermsAndConditions$66, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void s(String str) {
        this.homeNavigator.navigateToTermsAndConditions();
    }

    static /* synthetic */ void lambda$handleClickOnTermsAndConditions$67(String str) {
    }

    static /* synthetic */ void lambda$handleClickOnTermsAndConditions$68(Throwable th) {
        throw new OnErrorNotImplementedException(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleLoggedInAcceptTermsAndConditions$46, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e t(View.LifecycleEvent lifecycleEvent) {
        return this.accountManager.accountStatus().E();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleLoggedInAcceptTermsAndConditions$48, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void u(Account account) {
        this.view.showTermsAndConditionsDialog();
    }

    static /* synthetic */ void lambda$handleLoggedInAcceptTermsAndConditions$49(Account account) {
    }

    static /* synthetic */ void lambda$handleLoggedInAcceptTermsAndConditions$50(Throwable th) {
        throw new OnErrorNotImplementedException(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handlePromotionsClick$23, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void v(Void r1) {
        this.homeAnalytics.sendPromotionsIconClickEvent();
        this.homeNavigator.navigateToPromotions();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handlePromotionsClick$24, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e w(View.LifecycleEvent lifecycleEvent) {
        return this.view.toolbarPromotionsClick().j0(this.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.home.r2
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6295f.v((Void) obj);
            }
        }).s0();
    }

    static /* synthetic */ void lambda$handlePromotionsClick$25(Void r0) {
    }

    static /* synthetic */ void lambda$handlePromotionsClick$26(Throwable th) {
        throw new OnErrorNotImplementedException(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleTermsAndConditionsContinueClicked$52, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e x(View.LifecycleEvent lifecycleEvent) {
        return this.view.gdprDialogClicked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleTermsAndConditionsContinueClicked$54, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b y(String str) {
        return this.accountManager.updateTermsAndConditions();
    }

    static /* synthetic */ void lambda$handleTermsAndConditionsContinueClicked$55(String str) {
    }

    static /* synthetic */ void lambda$handleTermsAndConditionsContinueClicked$56(Throwable th) {
        throw new OnErrorNotImplementedException(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleTermsAndConditionsLogOutClicked$58, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e z(View.LifecycleEvent lifecycleEvent) {
        return this.view.gdprDialogClicked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleTermsAndConditionsLogOutClicked$60, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b A(String str) {
        return this.accountManager.logout();
    }

    static /* synthetic */ void lambda$handleTermsAndConditionsLogOutClicked$61(String str) {
    }

    static /* synthetic */ void lambda$handleTermsAndConditionsLogOutClicked$62(Throwable th) {
        throw new OnErrorNotImplementedException(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleUserImageClick$18, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void B(Void r1) {
        this.homeNavigator.navigateToMyAccount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleUserImageClick$19, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e C(View.LifecycleEvent lifecycleEvent) {
        return this.view.toolbarUserClick().j0(this.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.home.m1
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6138f.B((Void) obj);
            }
        }).s0();
    }

    static /* synthetic */ void lambda$handleUserImageClick$20(Void r0) {
    }

    static /* synthetic */ void lambda$handleUserImageClick$21(Throwable th) {
        throw new OnErrorNotImplementedException(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadMainHomeContent$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e D(View.LifecycleEvent lifecycleEvent) {
        return this.view.isChipChecked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadMainHomeContent$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void E(HomeContainerFragment.ChipsEvents chipsEvents) {
        int i2 = AnonymousClass1.$SwitchMap$cm$aptoide$pt$home$HomeContainerFragment$ChipsEvents[chipsEvents.ordinal()];
        if (i2 == 1) {
            this.homeContainerNavigator.loadGamesHomeContent();
        } else if (i2 != 2) {
            this.homeContainerNavigator.loadMainHomeContent();
        } else {
            this.homeContainerNavigator.loadAppsHomeContent();
        }
    }

    static /* synthetic */ void lambda$loadMainHomeContent$3(HomeContainerFragment.ChipsEvents chipsEvents) {
    }

    static /* synthetic */ void lambda$loadMainHomeContent$4(Throwable th) {
        throw new OnErrorNotImplementedException(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadUserImage$12, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e F(View.LifecycleEvent lifecycleEvent) {
        return this.accountManager.accountStatus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadUserImage$14, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void H(String str) {
        if (str != null) {
            this.view.setUserImage(str);
        } else {
            this.view.setDefaultUserImage();
        }
        this.view.showAvatar();
    }

    static /* synthetic */ void lambda$loadUserImage$15(String str) {
    }

    static /* synthetic */ void lambda$loadUserImage$16(Throwable th) {
        throw new OnErrorNotImplementedException(th);
    }

    public void checkForPromotionApps() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.x1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).L(new rx.m.e() { // from class: cm.aptoide.pt.home.e0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6033f.a((View.LifecycleEvent) obj);
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.home.la
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((HomePromotionsWrapper) obj).hasPromotions());
            }
        }).j0(this.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.home.h1
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6072f.b((HomePromotionsWrapper) obj);
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.home.e
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((HomePromotionsWrapper) obj).shouldShowDialog());
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.home.q2
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6283f.c((HomePromotionsWrapper) obj);
            }
        }).w(ia.f6095f).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.home.g0
            @Override // rx.m.b
            public final void call(Object obj) {
                HomeContainerPresenter.lambda$checkForPromotionApps$31((HomePromotionsWrapper) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.home.j0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6098f.d((Throwable) obj);
            }
        });
    }

    public void handleClickOnAppsChip() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.t1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.c1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6010f.h((View.LifecycleEvent) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.home.y1
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6372f.i((Boolean) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.home.l2
            @Override // rx.m.b
            public final void call(Object obj) {
                HomeContainerPresenter.lambda$handleClickOnAppsChip$83((Boolean) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.home.x2
            @Override // rx.m.b
            public final void call(Object obj) {
                HomeContainerPresenter.lambda$handleClickOnAppsChip$84((Throwable) obj);
                throw null;
            }
        });
    }

    public void handleClickOnGamesChip() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.k2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.r1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6294f.j((View.LifecycleEvent) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.home.k0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6112f.k((Boolean) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.home.f2
            @Override // rx.m.b
            public final void call(Object obj) {
                HomeContainerPresenter.lambda$handleClickOnGamesChip$78((Boolean) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.home.d2
            @Override // rx.m.b
            public final void call(Object obj) {
                HomeContainerPresenter.lambda$handleClickOnGamesChip$79((Throwable) obj);
                throw null;
            }
        });
    }

    public void handleClickOnPrivacyPolicy() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.d0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.f1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6048f.l((View.LifecycleEvent) obj);
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.home.s2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((String) obj).equals("privacy"));
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.home.h0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6071f.m((String) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.home.q0
            @Override // rx.m.b
            public final void call(Object obj) {
                HomeContainerPresenter.lambda$handleClickOnPrivacyPolicy$73((String) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.home.z1
            @Override // rx.m.b
            public final void call(Object obj) {
                HomeContainerPresenter.lambda$handleClickOnPrivacyPolicy$74((Throwable) obj);
                throw null;
            }
        });
    }

    public void handleClickOnPromotionsDialogCancel() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.v1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.g1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6060f.n((View.LifecycleEvent) obj);
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.home.r0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((String) obj).equals("cancel"));
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.home.o0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6260f.o((String) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.home.f0
            @Override // rx.m.b
            public final void call(Object obj) {
                HomeContainerPresenter.lambda$handleClickOnPromotionsDialogCancel$43((String) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.home.w0
            @Override // rx.m.b
            public final void call(Object obj) {
                HomeContainerPresenter.lambda$handleClickOnPromotionsDialogCancel$44((Throwable) obj);
                throw null;
            }
        });
    }

    public void handleClickOnPromotionsDialogContinue() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.k1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.x
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6359f.p((View.LifecycleEvent) obj);
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.home.b2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((String) obj).equals("navigate"));
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.home.a2
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f5680f.q((String) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.home.o1
            @Override // rx.m.b
            public final void call(Object obj) {
                HomeContainerPresenter.lambda$handleClickOnPromotionsDialogContinue$37((String) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.home.i0
            @Override // rx.m.b
            public final void call(Object obj) {
                HomeContainerPresenter.lambda$handleClickOnPromotionsDialogContinue$38((Throwable) obj);
                throw null;
            }
        });
    }

    public void handleClickOnTermsAndConditions() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.p0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.h2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6073f.r((View.LifecycleEvent) obj);
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.home.w2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((String) obj).equals("terms"));
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.home.v2
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6339f.s((String) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.home.n2
            @Override // rx.m.b
            public final void call(Object obj) {
                HomeContainerPresenter.lambda$handleClickOnTermsAndConditions$67((String) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.home.z
            @Override // rx.m.b
            public final void call(Object obj) {
                HomeContainerPresenter.lambda$handleClickOnTermsAndConditions$68((Throwable) obj);
                throw null;
            }
        });
    }

    public void handleLoggedInAcceptTermsAndConditions() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.u
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.j2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6100f.t((View.LifecycleEvent) obj);
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.home.ma
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((Account) obj).isLoggedIn());
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.home.o2
            @Override // rx.m.e
            public final Object call(Object obj) {
                Account account = (Account) obj;
                return Boolean.valueOf((account.acceptedPrivacyPolicy() && account.acceptedTermsAndConditions()) ? false : true);
            }
        }).j0(this.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.home.z2
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6384f.u((Account) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.home.a0
            @Override // rx.m.b
            public final void call(Object obj) {
                HomeContainerPresenter.lambda$handleLoggedInAcceptTermsAndConditions$49((Account) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.home.v0
            @Override // rx.m.b
            public final void call(Object obj) {
                HomeContainerPresenter.lambda$handleLoggedInAcceptTermsAndConditions$50((Throwable) obj);
                throw null;
            }
        });
    }

    public void handlePromotionsClick() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.g2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.i2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6087f.w((View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.home.s1
            @Override // rx.m.b
            public final void call(Object obj) {
                HomeContainerPresenter.lambda$handlePromotionsClick$25((Void) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.home.t
            @Override // rx.m.b
            public final void call(Object obj) {
                HomeContainerPresenter.lambda$handlePromotionsClick$26((Throwable) obj);
                throw null;
            }
        });
    }

    public void handleTermsAndConditionsContinueClicked() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.p2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.u1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6327f.x((View.LifecycleEvent) obj);
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.home.e1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((String) obj).equals("continue"));
            }
        }).H(new rx.m.e() { // from class: cm.aptoide.pt.home.q1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6282f.y((String) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.home.z0
            @Override // rx.m.b
            public final void call(Object obj) {
                HomeContainerPresenter.lambda$handleTermsAndConditionsContinueClicked$55((String) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.home.w
            @Override // rx.m.b
            public final void call(Object obj) {
                HomeContainerPresenter.lambda$handleTermsAndConditionsContinueClicked$56((Throwable) obj);
                throw null;
            }
        });
    }

    public void handleTermsAndConditionsLogOutClicked() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.b0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.n0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6250f.z((View.LifecycleEvent) obj);
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.home.d1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((String) obj).equals("logout"));
            }
        }).H(new rx.m.e() { // from class: cm.aptoide.pt.home.c0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6009f.A((String) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.home.y2
            @Override // rx.m.b
            public final void call(Object obj) {
                HomeContainerPresenter.lambda$handleTermsAndConditionsLogOutClicked$61((String) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.home.n1
            @Override // rx.m.b
            public final void call(Object obj) {
                HomeContainerPresenter.lambda$handleTermsAndConditionsLogOutClicked$62((Throwable) obj);
                throw null;
            }
        });
    }

    public void handleUserImageClick() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.l1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.w1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6349f.C((View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.home.m0
            @Override // rx.m.b
            public final void call(Object obj) {
                HomeContainerPresenter.lambda$handleUserImageClick$20((Void) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.home.x0
            @Override // rx.m.b
            public final void call(Object obj) {
                HomeContainerPresenter.lambda$handleUserImageClick$21((Throwable) obj);
                throw null;
            }
        });
    }

    public void loadMainHomeContent() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.j1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.c2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6011f.D((View.LifecycleEvent) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.home.s0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6304f.E((HomeContainerFragment.ChipsEvents) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.home.y
            @Override // rx.m.b
            public final void call(Object obj) {
                HomeContainerPresenter.lambda$loadMainHomeContent$3((HomeContainerFragment.ChipsEvents) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.home.p1
            @Override // rx.m.b
            public final void call(Object obj) {
                HomeContainerPresenter.lambda$loadMainHomeContent$4((Throwable) obj);
                throw null;
            }
        });
    }

    public void loadUserImage() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.t2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.e2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6035f.F((View.LifecycleEvent) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.t0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6315f.G((Account) obj);
            }
        }).j0(this.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.home.i1
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6086f.H((String) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.home.v
            @Override // rx.m.b
            public final void call(Object obj) {
                HomeContainerPresenter.lambda$loadUserImage$15((String) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.home.b1
            @Override // rx.m.b
            public final void call(Object obj) {
                HomeContainerPresenter.lambda$loadUserImage$16((Throwable) obj);
                throw null;
            }
        });
    }

    @Override // cm.aptoide.pt.presenter.Presenter
    public void present() {
        loadMainHomeContent();
        loadUserImage();
        handleUserImageClick();
        handlePromotionsClick();
        checkForPromotionApps();
        handleClickOnPromotionsDialogContinue();
        handleClickOnPromotionsDialogCancel();
        handleLoggedInAcceptTermsAndConditions();
        handleTermsAndConditionsContinueClicked();
        handleTermsAndConditionsLogOutClicked();
        handleClickOnTermsAndConditions();
        handleClickOnPrivacyPolicy();
        handleClickOnGamesChip();
        handleClickOnAppsChip();
        handleBottomNavigationEvents();
    }
}
