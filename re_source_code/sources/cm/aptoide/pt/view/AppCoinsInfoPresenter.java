package cm.aptoide.pt.view;

import cm.aptoide.aptoideviews.socialmedia.SocialMediaView;
import cm.aptoide.pt.AppCoinsManager;
import cm.aptoide.pt.app.view.AppCoinsInfoView;
import cm.aptoide.pt.bonus.BonusAppcModel;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.editorial.ScrollEvent;
import cm.aptoide.pt.install.InstallManager;
import cm.aptoide.pt.presenter.Presenter;
import cm.aptoide.pt.presenter.View;
import cm.aptoide.pt.socialmedia.SocialMediaAnalytics;
import rx.Single;

/* JADX INFO: loaded from: classes.dex */
public class AppCoinsInfoPresenter implements Presenter {
    private final AppCoinsInfoNavigator appCoinsInfoNavigator;
    private final AppCoinsManager appCoinsManager;
    private final String appcWalletPackageName;
    private final CrashReport crashReport;
    private final InstallManager installManager;
    private final SocialMediaAnalytics socialMediaAnalytics;
    private final AppCoinsInfoView view;
    private final rx.h viewScheduler;

    public AppCoinsInfoPresenter(AppCoinsInfoView appCoinsInfoView, AppCoinsInfoNavigator appCoinsInfoNavigator, InstallManager installManager, CrashReport crashReport, String str, rx.h hVar, SocialMediaAnalytics socialMediaAnalytics, AppCoinsManager appCoinsManager) {
        this.view = appCoinsInfoView;
        this.appCoinsInfoNavigator = appCoinsInfoNavigator;
        this.installManager = installManager;
        this.crashReport = crashReport;
        this.appcWalletPackageName = str;
        this.viewScheduler = hVar;
        this.socialMediaAnalytics = socialMediaAnalytics;
        this.appCoinsManager = appCoinsManager;
    }

    private void handleBonusPercentage() {
        rx.e eVarF = this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.view.f
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).L(new rx.m.e() { // from class: cm.aptoide.pt.view.a0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7917f.a((View.LifecycleEvent) obj);
            }
        }).j0(this.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.view.d
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f8009f.b((BonusAppcModel) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY));
        p pVar = new rx.m.b() { // from class: cm.aptoide.pt.view.p
            @Override // rx.m.b
            public final void call(Object obj) {
                AppCoinsInfoPresenter.lambda$handleBonusPercentage$3((BonusAppcModel) obj);
            }
        };
        CrashReport crashReport = this.crashReport;
        crashReport.getClass();
        eVarF.H0(pVar, new a(crashReport));
    }

    private void handleClickOnCatappultDevButton() {
        rx.e eVarF = this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.view.v
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.view.b0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f8006f.f((View.LifecycleEvent) obj);
            }
        }).j0(this.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.view.o
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f8079f.g((Void) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY));
        r rVar = new rx.m.b() { // from class: cm.aptoide.pt.view.r
            @Override // rx.m.b
            public final void call(Object obj) {
                AppCoinsInfoPresenter.lambda$handleClickOnCatappultDevButton$16((Void) obj);
            }
        };
        CrashReport crashReport = this.crashReport;
        crashReport.getClass();
        eVarF.H0(rVar, new a(crashReport));
    }

    private void handleSocialMediaPromotionClick() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.view.c0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.view.f0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f8048f.m((View.LifecycleEvent) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.view.w
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f8299f.n((SocialMediaView.SocialMediaType) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.view.s
            @Override // rx.m.b
            public final void call(Object obj) {
                AppCoinsInfoPresenter.lambda$handleSocialMediaPromotionClick$7((SocialMediaView.SocialMediaType) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.view.e0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f8046f.o((Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleBonusPercentage$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single a(View.LifecycleEvent lifecycleEvent) {
        return g.a.a.a.d.d(this.appCoinsManager.getBonusAppc());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleBonusPercentage$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(BonusAppcModel bonusAppcModel) {
        if (bonusAppcModel.getHasBonusAppc()) {
            this.view.setBonusAppc(bonusAppcModel.getBonusPercentage());
        } else {
            this.view.setNoBonusAppcView();
        }
    }

    static /* synthetic */ void lambda$handleBonusPercentage$3(BonusAppcModel bonusAppcModel) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleButtonText$27, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e c(View.LifecycleEvent lifecycleEvent) {
        return this.installManager.isInstalled(this.appcWalletPackageName);
    }

    static /* synthetic */ void lambda$handleButtonText$28(Boolean bool) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleClickOnAppcWalletLink$23, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e d(View.LifecycleEvent lifecycleEvent) {
        return this.view.appCoinsWalletLinkClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleClickOnAppcWalletLink$24, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e(Void r1) {
        this.appCoinsInfoNavigator.navigateToAppCoinsWallet();
    }

    static /* synthetic */ void lambda$handleClickOnAppcWalletLink$25(Void r0) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleClickOnCatappultDevButton$14, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e f(View.LifecycleEvent lifecycleEvent) {
        return this.view.catappultButtonClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleClickOnCatappultDevButton$15, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g(Void r1) {
        this.appCoinsInfoNavigator.navigateToCatappultWebsite();
    }

    static /* synthetic */ void lambda$handleClickOnCatappultDevButton$16(Void r0) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleClickOnInstallButton$18, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e h(View.LifecycleEvent lifecycleEvent) {
        return rx.e.a0(this.view.installButtonClick(), this.view.cardViewClick());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleClickOnInstallButton$19, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e i(Void r2) {
        return this.installManager.isInstalled(this.appcWalletPackageName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleClickOnInstallButton$20, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j(Boolean bool) {
        if (bool.booleanValue()) {
            this.view.openApp(this.appcWalletPackageName);
        } else {
            this.appCoinsInfoNavigator.navigateToAppCoinsWallet();
        }
    }

    static /* synthetic */ void lambda$handleClickOnInstallButton$21(Boolean bool) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handlePlaceHolderVisibilityChange$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e k(View.LifecycleEvent lifecycleEvent) {
        return this.view.appItemVisibilityChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handlePlaceHolderVisibilityChange$11, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void l(ScrollEvent scrollEvent) {
        if (scrollEvent.getItemShown().booleanValue()) {
            this.view.removeBottomCardAnimation();
        } else {
            if (scrollEvent.getItemShown().booleanValue()) {
                return;
            }
            this.view.addBottomCardAnimation();
        }
    }

    static /* synthetic */ void lambda$handlePlaceHolderVisibilityChange$12(ScrollEvent scrollEvent) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleSocialMediaPromotionClick$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e m(View.LifecycleEvent lifecycleEvent) {
        return this.view.socialMediaClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleSocialMediaPromotionClick$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n(SocialMediaView.SocialMediaType socialMediaType) {
        this.appCoinsInfoNavigator.navigateToSocialMedia(socialMediaType);
        this.socialMediaAnalytics.sendPromoteSocialMediaClickEvent(socialMediaType);
    }

    static /* synthetic */ void lambda$handleSocialMediaPromotionClick$7(SocialMediaView.SocialMediaType socialMediaType) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleSocialMediaPromotionClick$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void o(Throwable th) {
        this.crashReport.log(th);
    }

    public void handleButtonText() {
        rx.e<R> eVarG = this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.view.d0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.view.l
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f8071f.c((View.LifecycleEvent) obj);
            }
        });
        final AppCoinsInfoView appCoinsInfoView = this.view;
        appCoinsInfoView.getClass();
        rx.e eVarF = eVarG.x(new rx.m.b() { // from class: cm.aptoide.pt.view.b
            @Override // rx.m.b
            public final void call(Object obj) {
                appCoinsInfoView.setButtonText(((Boolean) obj).booleanValue());
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY));
        x xVar = new rx.m.b() { // from class: cm.aptoide.pt.view.x
            @Override // rx.m.b
            public final void call(Object obj) {
                AppCoinsInfoPresenter.lambda$handleButtonText$28((Boolean) obj);
            }
        };
        CrashReport crashReport = this.crashReport;
        crashReport.getClass();
        eVarF.H0(xVar, new a(crashReport));
    }

    public void handleClickOnAppcWalletLink() {
        rx.e eVarF = this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.view.e
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.view.n
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f8076f.d((View.LifecycleEvent) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.view.u
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f8293f.e((Void) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY));
        g gVar = new rx.m.b() { // from class: cm.aptoide.pt.view.g
            @Override // rx.m.b
            public final void call(Object obj) {
                AppCoinsInfoPresenter.lambda$handleClickOnAppcWalletLink$25((Void) obj);
            }
        };
        CrashReport crashReport = this.crashReport;
        crashReport.getClass();
        eVarF.H0(gVar, new a(crashReport));
    }

    public void handleClickOnInstallButton() {
        rx.e eVarF = this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.view.q
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.view.y
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f8313f.h((View.LifecycleEvent) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.view.h
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f8061f.i((Void) obj);
            }
        }).j0(this.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.view.k
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f8069f.j((Boolean) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY));
        t tVar = new rx.m.b() { // from class: cm.aptoide.pt.view.t
            @Override // rx.m.b
            public final void call(Object obj) {
                AppCoinsInfoPresenter.lambda$handleClickOnInstallButton$21((Boolean) obj);
            }
        };
        CrashReport crashReport = this.crashReport;
        crashReport.getClass();
        eVarF.H0(tVar, new a(crashReport));
    }

    public void handlePlaceHolderVisibilityChange() {
        rx.e eVarF = this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.view.m
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.view.z
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f8314f.k((View.LifecycleEvent) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.view.j
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f8066f.l((ScrollEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY));
        i iVar = new rx.m.b() { // from class: cm.aptoide.pt.view.i
            @Override // rx.m.b
            public final void call(Object obj) {
                AppCoinsInfoPresenter.lambda$handlePlaceHolderVisibilityChange$12((ScrollEvent) obj);
            }
        };
        CrashReport crashReport = this.crashReport;
        crashReport.getClass();
        eVarF.H0(iVar, new a(crashReport));
    }

    @Override // cm.aptoide.pt.presenter.Presenter
    public void present() {
        handleClickOnAppcWalletLink();
        handleClickOnCatappultDevButton();
        handleClickOnInstallButton();
        handleButtonText();
        handlePlaceHolderVisibilityChange();
        handleSocialMediaPromotionClick();
        handleBonusPercentage();
    }
}
