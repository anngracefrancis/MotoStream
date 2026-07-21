package cm.aptoide.pt.editorial;

import cm.aptoide.aptoideviews.socialmedia.SocialMediaView;
import cm.aptoide.pt.UserFeedbackAnalytics;
import cm.aptoide.pt.actions.PermissionManager;
import cm.aptoide.pt.actions.PermissionService;
import cm.aptoide.pt.ads.MoPubAdsManager;
import cm.aptoide.pt.ads.WalletAdsOfferManager;
import cm.aptoide.pt.app.DownloadModel;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.download.view.outofspace.OutOfSpaceNavigatorWrapper;
import cm.aptoide.pt.presenter.Presenter;
import cm.aptoide.pt.presenter.View;
import cm.aptoide.pt.reactions.ReactionEvent;
import cm.aptoide.pt.reactions.network.LoadReactionModel;
import cm.aptoide.pt.reactions.network.ReactionsResponse;
import cm.aptoide.pt.socialmedia.SocialMediaAnalytics;
import okhttp3.HttpUrl;
import rx.Single;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public class EditorialPresenter implements Presenter {
    private final CrashReport crashReporter;
    private final EditorialAnalytics editorialAnalytics;
    private final EditorialManager editorialManager;
    private final EditorialNavigator editorialNavigator;
    private final MoPubAdsManager moPubAdsManager;
    private final PermissionManager permissionManager;
    private final PermissionService permissionService;
    private final SocialMediaAnalytics socialMediaAnalytics;
    private final UserFeedbackAnalytics userFeedbackAnalytics;
    private final EditorialView view;
    private final rx.h viewScheduler;

    /* JADX INFO: renamed from: cm.aptoide.pt.editorial.EditorialPresenter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action;

        static {
            int[] iArr = new int[DownloadModel.Action.values().length];
            $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action = iArr;
            try {
                iArr[DownloadModel.Action.INSTALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action[DownloadModel.Action.UPDATE.ordinal()] = 2;
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
        }
    }

    public EditorialPresenter(EditorialView editorialView, EditorialManager editorialManager, rx.h hVar, CrashReport crashReport, PermissionManager permissionManager, PermissionService permissionService, EditorialAnalytics editorialAnalytics, EditorialNavigator editorialNavigator, UserFeedbackAnalytics userFeedbackAnalytics, MoPubAdsManager moPubAdsManager, SocialMediaAnalytics socialMediaAnalytics) {
        this.view = editorialView;
        this.editorialManager = editorialManager;
        this.viewScheduler = hVar;
        this.crashReporter = crashReport;
        this.permissionManager = permissionManager;
        this.permissionService = permissionService;
        this.editorialAnalytics = editorialAnalytics;
        this.editorialNavigator = editorialNavigator;
        this.userFeedbackAnalytics = userFeedbackAnalytics;
        this.moPubAdsManager = moPubAdsManager;
        this.socialMediaAnalytics = socialMediaAnalytics;
    }

    private void cancelDownload() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.editorial.j4
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj) == View.LifecycleEvent.CREATE);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.editorial.n5
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5416f.a((View.LifecycleEvent) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.editorial.r4
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5455f.d((EditorialViewModel) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.editorial.m0
            @Override // rx.m.b
            public final void call(Object obj) {
                EditorialPresenter.lambda$cancelDownload$52((EditorialDownloadEvent) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.editorial.p3
            @Override // rx.m.b
            public final void call(Object obj) {
                EditorialPresenter.lambda$cancelDownload$53((Throwable) obj);
            }
        });
    }

    private rx.b downgradeApp(final EditorialDownloadEvent editorialDownloadEvent, final EditorialViewModel editorialViewModel) {
        return this.view.showDowngradeMessage().D(new rx.m.e() { // from class: cm.aptoide.pt.editorial.s2
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean bool = (Boolean) obj;
                EditorialPresenter.lambda$downgradeApp$117(bool);
                return bool;
            }
        }).H(new rx.m.e() { // from class: cm.aptoide.pt.editorial.k5
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5386f.e(editorialDownloadEvent, editorialViewModel, (Boolean) obj);
            }
        }).X0();
    }

    private rx.b downloadApp(final EditorialDownloadEvent editorialDownloadEvent, final EditorialViewModel editorialViewModel) {
        return rx.e.p(new rx.m.d() { // from class: cm.aptoide.pt.editorial.u2
            @Override // rx.m.d, java.util.concurrent.Callable
            public final Object call() {
                return this.f5478f.f(editorialDownloadEvent);
            }
        }).j0(this.viewScheduler).G(new rx.m.e() { // from class: cm.aptoide.pt.editorial.h1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5348f.g((EditorialDownloadEvent) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.editorial.p1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5428f.i(editorialDownloadEvent, editorialViewModel, (Void) obj);
            }
        }).j0(Schedulers.io()).H(new rx.m.e() { // from class: cm.aptoide.pt.editorial.y2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5524f.j(editorialDownloadEvent, (Void) obj);
            }
        }).X0();
    }

    private void handleInstallClick() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.editorial.i3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.editorial.r2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5453f.q((View.LifecycleEvent) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.editorial.z2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5539f.y((EditorialViewModel) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.editorial.l4
            @Override // rx.m.b
            public final void call(Object obj) {
                EditorialPresenter.lambda$handleInstallClick$45((EditorialDownloadEvent) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.editorial.c3
            @Override // rx.m.b
            public final void call(Object obj) {
                EditorialPresenter.lambda$handleInstallClick$46((Throwable) obj);
                throw null;
            }
        });
    }

    private void handleOutOfSpaceDialogResult() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.editorial.j5
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.editorial.o2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5421f.H((View.LifecycleEvent) obj);
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.editorial.b5
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((OutOfSpaceNavigatorWrapper) obj).getClearedSuccessfully());
            }
        }).L(new rx.m.e() { // from class: cm.aptoide.pt.editorial.l5
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5397f.I((OutOfSpaceNavigatorWrapper) obj);
            }
        }).H(new rx.m.e() { // from class: cm.aptoide.pt.editorial.g5
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5344f.J((EditorialViewModel) obj);
            }
        }).s0().f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.editorial.h4
            @Override // rx.m.b
            public final void call(Object obj) {
                EditorialPresenter.lambda$handleOutOfSpaceDialogResult$5((EditorialViewModel) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.editorial.g3
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f5342f.K((Throwable) obj);
            }
        });
    }

    private void handleReactionsResponse(ReactionsResponse reactionsResponse, boolean z) {
        if (reactionsResponse.wasSuccess()) {
            if (z) {
                this.editorialAnalytics.sendDeletedEvent();
                return;
            } else {
                this.editorialAnalytics.sendReactedEvent();
                return;
            }
        }
        if (reactionsResponse.reactionsExceeded()) {
            this.view.showLoginDialog();
        } else if (reactionsResponse.wasNetworkError()) {
            this.view.showNetworkErrorToast();
        } else if (reactionsResponse.wasGeneralError()) {
            this.view.showGenericErrorToast();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleSinglePressReactionButton, reason: merged with bridge method [inline-methods] */
    public rx.e<LoadReactionModel> T(final EditorialViewModel editorialViewModel) {
        return this.editorialManager.isFirstReaction(editorialViewModel.getCardId(), editorialViewModel.getGroupId()).k(new rx.m.e() { // from class: cm.aptoide.pt.editorial.n3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5413f.a0(editorialViewModel, (Boolean) obj);
            }
        });
    }

    private void handleSocialMediaPromotionClick() {
        rx.e eVarF = this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.editorial.g2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.editorial.k2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5383f.d0((View.LifecycleEvent) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.editorial.d5
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f5313f.e0((SocialMediaView.SocialMediaType) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY));
        b3 b3Var = new rx.m.b() { // from class: cm.aptoide.pt.editorial.b3
            @Override // rx.m.b
            public final void call(Object obj) {
                EditorialPresenter.lambda$handleSocialMediaPromotionClick$10((SocialMediaView.SocialMediaType) obj);
            }
        };
        CrashReport crashReport = this.crashReporter;
        crashReport.getClass();
        eVarF.H0(b3Var, new b(crashReport));
    }

    private boolean isOnlyOneMediaVisible(int i2, int i3) {
        return i2 == i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$cancelDownload$48, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e a(View.LifecycleEvent lifecycleEvent) {
        return setUpViewModelOnViewReady();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$cancelDownload$49, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(EditorialDownloadEvent editorialDownloadEvent) {
        this.editorialAnalytics.sendDownloadCancelEvent(editorialDownloadEvent.getPackageName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$cancelDownload$50, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b c(EditorialDownloadEvent editorialDownloadEvent) {
        return this.editorialManager.cancelDownload(editorialDownloadEvent.getMd5(), editorialDownloadEvent.getPackageName(), editorialDownloadEvent.getVerCode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$cancelDownload$51, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e d(EditorialViewModel editorialViewModel) {
        return this.view.cancelDownload(editorialViewModel).x(new rx.m.b() { // from class: cm.aptoide.pt.editorial.p4
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f5433f.b((EditorialDownloadEvent) obj);
            }
        }).H(new rx.m.e() { // from class: cm.aptoide.pt.editorial.z5
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5542f.c((EditorialDownloadEvent) obj);
            }
        }).s0();
    }

    static /* synthetic */ void lambda$cancelDownload$52(EditorialDownloadEvent editorialDownloadEvent) {
    }

    static /* synthetic */ void lambda$cancelDownload$53(Throwable th) {
    }

    static /* synthetic */ Boolean lambda$downgradeApp$117(Boolean bool) {
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$downgradeApp$118, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b e(EditorialDownloadEvent editorialDownloadEvent, EditorialViewModel editorialViewModel, Boolean bool) {
        return downloadApp(editorialDownloadEvent, editorialViewModel);
    }

    static /* synthetic */ EditorialDownloadEvent lambda$downloadApp$70(EditorialDownloadEvent editorialDownloadEvent, Boolean bool) {
        return editorialDownloadEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$downloadApp$71, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e f(final EditorialDownloadEvent editorialDownloadEvent) {
        if (!this.editorialManager.shouldShowRootInstallWarningPopup()) {
            return rx.e.S(editorialDownloadEvent);
        }
        rx.e<Boolean> eVarShowRootInstallWarningPopup = this.view.showRootInstallWarningPopup();
        final EditorialManager editorialManager = this.editorialManager;
        editorialManager.getClass();
        return eVarShowRootInstallWarningPopup.x(new rx.m.b() { // from class: cm.aptoide.pt.editorial.r6
            @Override // rx.m.b
            public final void call(Object obj) {
                editorialManager.allowRootInstall((Boolean) obj);
            }
        }).X(new rx.m.e() { // from class: cm.aptoide.pt.editorial.w0
            @Override // rx.m.e
            public final Object call(Object obj) {
                EditorialDownloadEvent editorialDownloadEvent2 = editorialDownloadEvent;
                EditorialPresenter.lambda$downloadApp$70(editorialDownloadEvent2, (Boolean) obj);
                return editorialDownloadEvent2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$downloadApp$72, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e g(EditorialDownloadEvent editorialDownloadEvent) {
        return this.permissionManager.requestDownloadAccess(this.permissionService);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$downloadApp$73, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h(EditorialDownloadEvent editorialDownloadEvent, EditorialViewModel editorialViewModel, Throwable th) {
        th.printStackTrace();
        this.editorialAnalytics.sendDownloadAbortEvent(editorialDownloadEvent.getPackageName(), editorialDownloadEvent.getVerCode(), editorialDownloadEvent.getAction(), editorialDownloadEvent.getAction().equals(DownloadModel.Action.MIGRATE), !editorialDownloadEvent.getSplits().isEmpty(), editorialViewModel.hasAppc(), editorialDownloadEvent.getTrustedBadge(), editorialDownloadEvent.getStoreName(), false, editorialDownloadEvent.getObb() != null, editorialDownloadEvent.getBdsFlags().contains("STORE_BDS"), HttpUrl.FRAGMENT_ENCODE_SET, editorialDownloadEvent.getSize());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$downloadApp$74, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e i(final EditorialDownloadEvent editorialDownloadEvent, final EditorialViewModel editorialViewModel, Void r4) {
        return this.permissionManager.requestExternalStoragePermission(this.permissionService).w(new rx.m.b() { // from class: cm.aptoide.pt.editorial.d2
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f5308f.h(editorialDownloadEvent, editorialViewModel, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$downloadApp$75, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b j(EditorialDownloadEvent editorialDownloadEvent, Void r2) {
        return this.editorialManager.downloadApp(editorialDownloadEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleClickActionButtonCard$31, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e k(View.LifecycleEvent lifecycleEvent) {
        return this.view.actionButtonClicked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleClickActionButtonCard$32, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void l(EditorialEvent editorialEvent) {
        this.editorialNavigator.navigateToUri(editorialEvent.getUrl());
    }

    static /* synthetic */ void lambda$handleClickActionButtonCard$33(EditorialEvent editorialEvent) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleClickOnAppCard$27, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e m(View.LifecycleEvent lifecycleEvent) {
        return setUpViewModelOnViewReady();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleClickOnAppCard$28, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n(EditorialEvent editorialEvent) {
        this.editorialNavigator.navigateToAppView(editorialEvent.getId(), editorialEvent.getPackageName());
    }

    static /* synthetic */ void lambda$handleClickOnAppCard$29(EditorialEvent editorialEvent) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleClickOnMedia$23, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e o(View.LifecycleEvent lifecycleEvent) {
        return this.view.mediaContentClicked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleClickOnMedia$24, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void p(EditorialEvent editorialEvent) {
        this.editorialNavigator.navigateToUri(editorialEvent.getUrl());
    }

    static /* synthetic */ void lambda$handleClickOnMedia$25(EditorialEvent editorialEvent) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleInstallClick$35, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e q(View.LifecycleEvent lifecycleEvent) {
        return setUpViewModelOnViewReady();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleInstallClick$36, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void r(EditorialDownloadEvent editorialDownloadEvent, DownloadModel.Action action, EditorialViewModel editorialViewModel) {
        this.editorialAnalytics.clickOnInstallButton(editorialDownloadEvent.getPackageName(), action.toString(), editorialViewModel.hasSplits(), editorialViewModel.hasAppc(), false, editorialViewModel.getRank(), null, editorialViewModel.getStoreName(), editorialViewModel.getBottomCardObb() != null, editorialDownloadEvent.getBdsFlags(), editorialDownloadEvent.getSize());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleInstallClick$37, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b s(final EditorialDownloadEvent editorialDownloadEvent, final DownloadModel.Action action, final EditorialViewModel editorialViewModel) {
        return downloadApp(editorialDownloadEvent, editorialViewModel).a(this.editorialManager.convertCampaign(editorialDownloadEvent)).z(this.viewScheduler).m(new rx.m.a() { // from class: cm.aptoide.pt.editorial.p5
            @Override // rx.m.a
            public final void call() {
                this.f5434f.r(editorialDownloadEvent, action, editorialViewModel);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleInstallClick$38, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void t(EditorialDownloadEvent editorialDownloadEvent, DownloadModel.Action action, EditorialViewModel editorialViewModel) {
        this.editorialAnalytics.clickOnInstallButton(editorialDownloadEvent.getPackageName(), action.toString(), editorialViewModel.hasSplits(), editorialViewModel.hasAppc(), false, editorialViewModel.getRank(), null, editorialViewModel.getStoreName(), editorialViewModel.getBottomCardObb() != null, editorialDownloadEvent.getBdsFlags(), editorialDownloadEvent.getSize());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleInstallClick$39, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b u(final EditorialDownloadEvent editorialDownloadEvent, final DownloadModel.Action action, final EditorialViewModel editorialViewModel) {
        return openInstalledApp(editorialDownloadEvent.getPackageName()).m(new rx.m.a() { // from class: cm.aptoide.pt.editorial.w5
            @Override // rx.m.a
            public final void call() {
                this.f5503f.t(editorialDownloadEvent, action, editorialViewModel);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleInstallClick$40, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void v(EditorialDownloadEvent editorialDownloadEvent, DownloadModel.Action action, EditorialViewModel editorialViewModel) {
        this.editorialAnalytics.clickOnInstallButton(editorialDownloadEvent.getPackageName(), action.toString(), editorialViewModel.hasSplits(), editorialViewModel.hasAppc(), false, editorialViewModel.getRank(), null, editorialViewModel.getStoreName(), editorialViewModel.getBottomCardObb() != null, editorialDownloadEvent.getBdsFlags(), editorialDownloadEvent.getSize());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleInstallClick$41, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b w(final EditorialDownloadEvent editorialDownloadEvent, final DownloadModel.Action action, final EditorialViewModel editorialViewModel) {
        return downgradeApp(editorialDownloadEvent, editorialViewModel).a(this.editorialManager.convertCampaign(editorialDownloadEvent)).m(new rx.m.a() { // from class: cm.aptoide.pt.editorial.v3
            @Override // rx.m.a
            public final void call() {
                this.f5488f.v(editorialDownloadEvent, action, editorialViewModel);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleInstallClick$42, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b x(final EditorialDownloadEvent editorialDownloadEvent) {
        final DownloadModel.Action action = editorialDownloadEvent.getAction();
        int i2 = AnonymousClass1.$SwitchMap$cm$aptoide$pt$app$DownloadModel$Action[action.ordinal()];
        if (i2 == 1 || i2 == 2) {
            return this.editorialManager.loadEditorialViewModel().j(new rx.m.e() { // from class: cm.aptoide.pt.editorial.i2
                @Override // rx.m.e
                public final Object call(Object obj) {
                    return this.f5361f.s(editorialDownloadEvent, action, (EditorialViewModel) obj);
                }
            });
        }
        if (i2 == 3) {
            return this.editorialManager.loadEditorialViewModel().p(this.viewScheduler).j(new rx.m.e() { // from class: cm.aptoide.pt.editorial.i1
                @Override // rx.m.e
                public final Object call(Object obj) {
                    return this.f5358f.u(editorialDownloadEvent, action, (EditorialViewModel) obj);
                }
            });
        }
        if (i2 != 4) {
            return null;
        }
        return this.editorialManager.loadEditorialViewModel().p(this.viewScheduler).j(new rx.m.e() { // from class: cm.aptoide.pt.editorial.z1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5536f.w(editorialDownloadEvent, action, (EditorialViewModel) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleInstallClick$44, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e y(EditorialViewModel editorialViewModel) {
        return this.view.installButtonClick(editorialViewModel).H(new rx.m.e() { // from class: cm.aptoide.pt.editorial.t1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5468f.x((EditorialDownloadEvent) obj);
            }
        }).w(new rx.m.b() { // from class: cm.aptoide.pt.editorial.t3
            @Override // rx.m.b
            public final void call(Object obj) {
                ((Throwable) obj).printStackTrace();
            }
        }).s0();
    }

    static /* synthetic */ void lambda$handleInstallClick$45(EditorialDownloadEvent editorialDownloadEvent) {
    }

    static /* synthetic */ void lambda$handleInstallClick$46(Throwable th) {
        throw new IllegalStateException(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleLongPressReactionButton$134, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e z(View.LifecycleEvent lifecycleEvent) {
        return this.view.reactionsButtonLongPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleLongPressReactionButton$135, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e A(Void r1) {
        return this.editorialManager.loadEditorialViewModel().A();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleLongPressReactionButton$136, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void B(EditorialViewModel editorialViewModel) {
        this.editorialAnalytics.sendReactionButtonClickEvent();
        this.view.showReactionsPopup(editorialViewModel.getCardId(), editorialViewModel.getGroupId());
    }

    static /* synthetic */ void lambda$handleLongPressReactionButton$137(EditorialViewModel editorialViewModel) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleMediaListDescriptionVisibility$104, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e C(View.LifecycleEvent lifecycleEvent) {
        return this.view.mediaListDescriptionChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleMediaListDescriptionVisibility$106, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void D(EditorialEvent editorialEvent) {
        if (isOnlyOneMediaVisible(editorialEvent.getFirstVisiblePosition(), editorialEvent.getLastVisibleItemPosition())) {
            this.view.manageMediaListDescriptionAnimationVisibility(editorialEvent);
        } else {
            this.view.setMediaListDescriptionsVisible(editorialEvent);
        }
    }

    static /* synthetic */ void lambda$handleMediaListDescriptionVisibility$107(EditorialEvent editorialEvent) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleMovingCollapse$109, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e E(View.LifecycleEvent lifecycleEvent) {
        return this.view.handleMovingCollapse();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleMovingCollapse$110, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void F(Boolean bool) {
        if (bool.booleanValue()) {
            this.view.removeBottomCardAnimation();
        } else {
            this.view.addBottomCardAnimation();
        }
    }

    static /* synthetic */ void lambda$handleMovingCollapse$111(Boolean bool) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleMovingCollapse$112, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void G(Throwable th) {
        this.crashReporter.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleOutOfSpaceDialogResult$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e H(View.LifecycleEvent lifecycleEvent) {
        return this.editorialNavigator.outOfSpaceDialogResult();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleOutOfSpaceDialogResult$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single I(OutOfSpaceNavigatorWrapper outOfSpaceNavigatorWrapper) {
        return this.editorialManager.loadEditorialViewModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleOutOfSpaceDialogResult$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b J(EditorialViewModel editorialViewModel) {
        return this.editorialManager.resumeDownload(editorialViewModel.getBottomCardMd5(), editorialViewModel.getBottomCardPackageName(), editorialViewModel.getBottomCardAppId(), this.view.getAction(), editorialViewModel.getBdsFlags());
    }

    static /* synthetic */ void lambda$handleOutOfSpaceDialogResult$5(EditorialViewModel editorialViewModel) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleOutOfSpaceDialogResult$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void K(Throwable th) {
        this.crashReporter.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handlePlaceHolderVisibility$93, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e L(View.LifecycleEvent lifecycleEvent) {
        return this.view.isViewReady();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handlePlaceHolderVisibility$94, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void M(Void r1) {
        this.view.managePlaceHolderVisibity();
    }

    static /* synthetic */ void lambda$handlePlaceHolderVisibility$95(Void r0) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handlePlaceHolderVisibility$96, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void N(Throwable th) {
        this.crashReporter.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handlePlaceHolderVisibilityChange$100, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void O(ScrollEvent scrollEvent) {
        if (scrollEvent.getItemShown().booleanValue()) {
            this.view.removeBottomCardAnimation();
        } else {
            if (scrollEvent.getItemShown().booleanValue()) {
                return;
            }
            this.view.addBottomCardAnimation();
        }
    }

    static /* synthetic */ void lambda$handlePlaceHolderVisibilityChange$101(ScrollEvent scrollEvent) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handlePlaceHolderVisibilityChange$102, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void P(Throwable th) {
        this.crashReporter.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handlePlaceHolderVisibilityChange$99, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e Q(View.LifecycleEvent lifecycleEvent) {
        return this.view.placeHolderVisibilityChange();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleReactionButtonClick$121, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e R(View.LifecycleEvent lifecycleEvent) {
        return this.view.reactionsButtonClicked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleReactionButtonClick$122, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single S(Void r1) {
        return this.editorialManager.loadEditorialViewModel();
    }

    static /* synthetic */ void lambda$handleReactionButtonClick$124(LoadReactionModel loadReactionModel) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleReactionButtonClick$125, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void U(Throwable th) {
        this.crashReporter.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleRetryClick$18, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void V(Void r1) {
        this.view.showLoading();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleRetryClick$19, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single W(Void r1) {
        return loadEditorialViewModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleRetryClick$20, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e X(View.LifecycleEvent lifecycleEvent) {
        return this.view.retryClicked().j0(this.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.editorial.v1
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f5486f.V((Void) obj);
            }
        }).L(new rx.m.e() { // from class: cm.aptoide.pt.editorial.w4
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5502f.W((Void) obj);
            }
        });
    }

    static /* synthetic */ void lambda$handleRetryClick$21(EditorialViewModel editorialViewModel) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleSinglePressReactionButton$113, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Y(ReactionsResponse reactionsResponse) {
        handleReactionsResponse(reactionsResponse, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleSinglePressReactionButton$114, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single Z(EditorialViewModel editorialViewModel, ReactionsResponse reactionsResponse) {
        return loadReactionModel(editorialViewModel.getCardId(), editorialViewModel.getGroupId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleSinglePressReactionButton$115, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e a0(final EditorialViewModel editorialViewModel, Boolean bool) {
        if (!bool.booleanValue()) {
            return this.editorialManager.deleteReaction(editorialViewModel.getCardId(), editorialViewModel.getGroupId()).A().x(new rx.m.b() { // from class: cm.aptoide.pt.editorial.o0
                @Override // rx.m.b
                public final void call(Object obj) {
                    this.f5419f.Y((ReactionsResponse) obj);
                }
            }).D(t6.f5473f).L(new rx.m.e() { // from class: cm.aptoide.pt.editorial.a4
                @Override // rx.m.e
                public final Object call(Object obj) {
                    return this.f5274f.Z(editorialViewModel, (ReactionsResponse) obj);
                }
            });
        }
        this.editorialAnalytics.sendReactionButtonClickEvent();
        this.view.showReactionsPopup(editorialViewModel.getCardId(), editorialViewModel.getGroupId());
        return rx.e.S(new LoadReactionModel());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleSnackLogInClick$139, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e b0(View.LifecycleEvent lifecycleEvent) {
        return this.view.snackLoginClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleSnackLogInClick$140, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c0(Void r1) {
        this.editorialNavigator.navigateToLogIn();
    }

    static /* synthetic */ void lambda$handleSnackLogInClick$141(Void r0) {
    }

    static /* synthetic */ void lambda$handleSocialMediaPromotionClick$10(SocialMediaView.SocialMediaType socialMediaType) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleSocialMediaPromotionClick$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e d0(View.LifecycleEvent lifecycleEvent) {
        return this.view.socialMediaClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleSocialMediaPromotionClick$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e0(SocialMediaView.SocialMediaType socialMediaType) {
        this.editorialNavigator.navigateToSocialMedia(socialMediaType);
        this.socialMediaAnalytics.sendPromoteSocialMediaClickEvent(socialMediaType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleUserReaction$127, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e f0(View.LifecycleEvent lifecycleEvent) {
        return this.view.reactionClicked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleUserReaction$128, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g0(ReactionEvent reactionEvent) {
        this.userFeedbackAnalytics.sendReactionEvent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleUserReaction$129, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h0(ReactionsResponse reactionsResponse) {
        handleReactionsResponse(reactionsResponse, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleUserReaction$130, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single i0(ReactionEvent reactionEvent, ReactionsResponse reactionsResponse) {
        return loadReactionModel(reactionEvent.getCardId(), reactionEvent.getGroupId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleUserReaction$131, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e j0(final ReactionEvent reactionEvent) {
        return this.editorialManager.setReaction(reactionEvent.getCardId(), reactionEvent.getGroupId(), reactionEvent.getReactionType()).A().D(new rx.m.e() { // from class: cm.aptoide.pt.editorial.o6
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((ReactionsResponse) obj).differentReaction());
            }
        }).j0(this.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.editorial.f2
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f5329f.h0((ReactionsResponse) obj);
            }
        }).D(t6.f5473f).L(new rx.m.e() { // from class: cm.aptoide.pt.editorial.l2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5393f.i0(reactionEvent, (ReactionsResponse) obj);
            }
        });
    }

    static /* synthetic */ void lambda$handleUserReaction$132(LoadReactionModel loadReactionModel) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadDownloadApp$77, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e k0(View.LifecycleEvent lifecycleEvent) {
        return this.view.isViewReady();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadDownloadApp$78, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e l0(Void r1) {
        return this.editorialManager.loadEditorialViewModel().A();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadDownloadApp$80, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e m0(EditorialContent editorialContent) {
        rx.e<EditorialDownloadModel> eVarJ0 = this.editorialManager.loadDownloadModel(editorialContent.getMd5sum(), editorialContent.getPackageName(), editorialContent.getVerCode(), editorialContent.getPosition()).j0(this.viewScheduler);
        final EditorialView editorialView = this.view;
        editorialView.getClass();
        return eVarJ0.x(new rx.m.b() { // from class: cm.aptoide.pt.editorial.s6
            @Override // rx.m.b
            public final void call(Object obj) {
                editorialView.showDownloadModel((EditorialDownloadModel) obj);
            }
        });
    }

    static /* synthetic */ void lambda$loadDownloadApp$81(EditorialDownloadModel editorialDownloadModel) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadEditorialViewModel$15, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n0(EditorialViewModel editorialViewModel) {
        if (!editorialViewModel.isLoading()) {
            this.view.hideLoading();
        }
        if (editorialViewModel.hasError()) {
            this.view.showError(editorialViewModel.getError());
        } else {
            this.view.populateView(editorialViewModel);
        }
    }

    static /* synthetic */ EditorialViewModel lambda$loadEditorialViewModel$16(EditorialViewModel editorialViewModel) {
        return editorialViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadReactionModel$116, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void o0(LoadReactionModel loadReactionModel) {
        this.view.showTopReactions(loadReactionModel.getMyReaction(), loadReactionModel.getTopReactionList(), loadReactionModel.getTotal());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$observeDownloadErrors$83, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e p0(View.LifecycleEvent lifecycleEvent) {
        return setUpViewModelOnViewReady();
    }

    static /* synthetic */ EditorialViewModel lambda$observeDownloadErrors$84(EditorialViewModel editorialViewModel, EditorialDownloadEvent editorialDownloadEvent) {
        return editorialViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$observeDownloadErrors$85, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e q0(final EditorialViewModel editorialViewModel) {
        return rx.e.a0(this.view.installButtonClick(editorialViewModel), this.view.resumeDownload(editorialViewModel)).X(new rx.m.e() { // from class: cm.aptoide.pt.editorial.m2
            @Override // rx.m.e
            public final Object call(Object obj) {
                EditorialViewModel editorialViewModel2 = editorialViewModel;
                EditorialPresenter.lambda$observeDownloadErrors$84(editorialViewModel2, (EditorialDownloadEvent) obj);
                return editorialViewModel2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$observeDownloadErrors$87, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void s0(EditorialContent editorialContent, EditorialDownloadModel editorialDownloadModel) {
        if (editorialDownloadModel.getDownloadState().equals(DownloadModel.DownloadState.NOT_ENOUGH_STORAGE_ERROR)) {
            this.editorialNavigator.navigateToOutOfSpaceDialog(editorialContent.getSize(), editorialContent.getPackageName());
        } else {
            this.view.showDownloadError(editorialDownloadModel);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$observeDownloadErrors$88, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e t0(final EditorialContent editorialContent) {
        return this.editorialManager.loadDownloadModel(editorialContent.getMd5sum(), editorialContent.getPackageName(), editorialContent.getVerCode(), editorialContent.getPosition()).D(new rx.m.e() { // from class: cm.aptoide.pt.editorial.v6
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((EditorialDownloadModel) obj).hasError());
            }
        }).E().G(new rx.m.e() { // from class: cm.aptoide.pt.editorial.q1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5442f.r0(editorialContent, (EditorialDownloadModel) obj);
            }
        }).j0(this.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.editorial.m1
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f5401f.s0(editorialContent, (EditorialDownloadModel) obj);
            }
        });
    }

    static /* synthetic */ void lambda$observeDownloadErrors$89(EditorialDownloadModel editorialDownloadModel) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$onCreateLoadAppOfTheWeek$12, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void u0(View.LifecycleEvent lifecycleEvent) {
        this.view.showLoading();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$onCreateLoadAppOfTheWeek$13, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single v0(View.LifecycleEvent lifecycleEvent) {
        return loadEditorialViewModel();
    }

    static /* synthetic */ void lambda$onCreateLoadAppOfTheWeek$14(EditorialViewModel editorialViewModel) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$onCreateLoadReactionModel$143, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e w0(View.LifecycleEvent lifecycleEvent) {
        return setUpViewModelOnViewReady();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$onCreateLoadReactionModel$144, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single x0(EditorialViewModel editorialViewModel) {
        return loadReactionModel(editorialViewModel.getCardId(), editorialViewModel.getGroupId());
    }

    static /* synthetic */ void lambda$onCreateLoadReactionModel$145(LoadReactionModel loadReactionModel) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$openInstalledApp$97, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void y0(String str) {
        this.view.openApp(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$pauseDownload$64, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e z0(View.LifecycleEvent lifecycleEvent) {
        return setUpViewModelOnViewReady();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$pauseDownload$65, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void A0(EditorialDownloadEvent editorialDownloadEvent) {
        this.editorialAnalytics.sendDownloadPauseEvent(editorialDownloadEvent.getPackageName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$pauseDownload$66, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b B0(EditorialDownloadEvent editorialDownloadEvent) {
        return this.editorialManager.pauseDownload(editorialDownloadEvent.getMd5());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$pauseDownload$67, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e C0(EditorialViewModel editorialViewModel) {
        return this.view.pauseDownload(editorialViewModel).x(new rx.m.b() { // from class: cm.aptoide.pt.editorial.t5
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f5472f.A0((EditorialDownloadEvent) obj);
            }
        }).H(new rx.m.e() { // from class: cm.aptoide.pt.editorial.s5
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5464f.B0((EditorialDownloadEvent) obj);
            }
        }).s0();
    }

    static /* synthetic */ void lambda$pauseDownload$68(EditorialDownloadEvent editorialDownloadEvent) {
    }

    static /* synthetic */ void lambda$pauseDownload$69(Throwable th) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$resumeDownload$55, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e D0(View.LifecycleEvent lifecycleEvent) {
        return setUpViewModelOnViewReady();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$resumeDownload$56, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void E0(EditorialDownloadEvent editorialDownloadEvent, EditorialViewModel editorialViewModel, Throwable th) {
        this.editorialAnalytics.sendDownloadAbortEvent(editorialDownloadEvent.getPackageName(), editorialDownloadEvent.getVerCode(), editorialDownloadEvent.getAction(), editorialDownloadEvent.getAction().equals(DownloadModel.Action.MIGRATE), !editorialDownloadEvent.getSplits().isEmpty(), editorialViewModel.hasAppc(), editorialDownloadEvent.getTrustedBadge(), editorialDownloadEvent.getStoreName(), false, editorialDownloadEvent.getObb() != null, editorialDownloadEvent.getBdsFlags().contains("STORE_BDS"), HttpUrl.FRAGMENT_ENCODE_SET, editorialDownloadEvent.getSize());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$resumeDownload$57, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e F0(final EditorialDownloadEvent editorialDownloadEvent, final EditorialViewModel editorialViewModel, Void r4) {
        return this.permissionManager.requestExternalStoragePermission(this.permissionService).w(new rx.m.b() { // from class: cm.aptoide.pt.editorial.i4
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f5365f.E0(editorialDownloadEvent, editorialViewModel, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$resumeDownload$58, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b G0(EditorialDownloadEvent editorialDownloadEvent, Void r9) {
        return this.editorialManager.resumeDownload(editorialDownloadEvent.getMd5(), editorialDownloadEvent.getPackageName(), editorialDownloadEvent.getAppId(), editorialDownloadEvent.getAction().toString(), editorialDownloadEvent.getBdsFlags());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$resumeDownload$59, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e H0(final EditorialViewModel editorialViewModel, final EditorialDownloadEvent editorialDownloadEvent) {
        return this.permissionManager.requestDownloadAccess(this.permissionService).G(new rx.m.e() { // from class: cm.aptoide.pt.editorial.c2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5295f.F0(editorialDownloadEvent, editorialViewModel, (Void) obj);
            }
        }).H(new rx.m.e() { // from class: cm.aptoide.pt.editorial.c5
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5300f.G0(editorialDownloadEvent, (Void) obj);
            }
        }).s0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$resumeDownload$60, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e I0(final EditorialViewModel editorialViewModel) {
        return this.view.resumeDownload(editorialViewModel).G(new rx.m.e() { // from class: cm.aptoide.pt.editorial.r1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5451f.H0(editorialViewModel, (EditorialDownloadEvent) obj);
            }
        });
    }

    static /* synthetic */ void lambda$resumeDownload$61(Void r0) {
    }

    static /* synthetic */ void lambda$resumeDownload$62(Throwable th) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setUpViewModelOnViewReady$119, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e J0(Void r1) {
        return this.editorialManager.loadEditorialViewModel().A();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$verifyNotEnoughSpaceError$90, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void K0(EditorialContent editorialContent, WalletAdsOfferManager.OfferResponseStatus offerResponseStatus) {
        this.editorialAnalytics.sendNotEnoughSpaceErrorEvent(editorialContent.getMd5sum());
    }

    static /* synthetic */ EditorialDownloadModel lambda$verifyNotEnoughSpaceError$91(EditorialDownloadModel editorialDownloadModel, WalletAdsOfferManager.OfferResponseStatus offerResponseStatus) {
        return editorialDownloadModel;
    }

    private Single<EditorialViewModel> loadEditorialViewModel() {
        return this.editorialManager.loadEditorialViewModel().p(this.viewScheduler).g(new rx.m.b() { // from class: cm.aptoide.pt.editorial.a1
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f5271f.n0((EditorialViewModel) obj);
            }
        }).n(new rx.m.e() { // from class: cm.aptoide.pt.editorial.q5
            @Override // rx.m.e
            public final Object call(Object obj) {
                EditorialViewModel editorialViewModel = (EditorialViewModel) obj;
                EditorialPresenter.lambda$loadEditorialViewModel$16(editorialViewModel);
                return editorialViewModel;
            }
        });
    }

    private Single<LoadReactionModel> loadReactionModel(String str, String str2) {
        return this.editorialManager.loadReactionModel(str, str2).p(this.viewScheduler).g(new rx.m.b() { // from class: cm.aptoide.pt.editorial.r5
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f5456f.o0((LoadReactionModel) obj);
            }
        });
    }

    private rx.b openInstalledApp(final String str) {
        return rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.editorial.e1
            @Override // rx.m.a
            public final void call() {
                this.f5318f.y0(str);
            }
        });
    }

    private void pauseDownload() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.editorial.t4
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj) == View.LifecycleEvent.CREATE);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.editorial.k1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5382f.z0((View.LifecycleEvent) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.editorial.x1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5510f.C0((EditorialViewModel) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.editorial.b6
            @Override // rx.m.b
            public final void call(Object obj) {
                EditorialPresenter.lambda$pauseDownload$68((EditorialDownloadEvent) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.editorial.q0
            @Override // rx.m.b
            public final void call(Object obj) {
                EditorialPresenter.lambda$pauseDownload$69((Throwable) obj);
            }
        });
    }

    private void resumeDownload() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.editorial.d3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj) == View.LifecycleEvent.CREATE);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.editorial.q3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5445f.D0((View.LifecycleEvent) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.editorial.s1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5460f.I0((EditorialViewModel) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.editorial.f4
            @Override // rx.m.b
            public final void call(Object obj) {
                EditorialPresenter.lambda$resumeDownload$61((Void) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.editorial.c1
            @Override // rx.m.b
            public final void call(Object obj) {
                EditorialPresenter.lambda$resumeDownload$62((Throwable) obj);
            }
        });
    }

    private rx.e<EditorialViewModel> setUpViewModelOnViewReady() {
        return this.view.isViewReady().G(new rx.m.e() { // from class: cm.aptoide.pt.editorial.p0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5427f.J0((Void) obj);
            }
        }).j0(this.viewScheduler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: verifyNotEnoughSpaceError, reason: merged with bridge method [inline-methods] */
    public rx.e<EditorialDownloadModel> r0(final EditorialContent editorialContent, final EditorialDownloadModel editorialDownloadModel) {
        return editorialDownloadModel.getDownloadState() == DownloadModel.DownloadState.NOT_ENOUGH_STORAGE_ERROR ? this.moPubAdsManager.getAdsVisibilityStatus().g(new rx.m.b() { // from class: cm.aptoide.pt.editorial.u1
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f5476f.K0(editorialContent, (WalletAdsOfferManager.OfferResponseStatus) obj);
            }
        }).A().X(new rx.m.e() { // from class: cm.aptoide.pt.editorial.n0
            @Override // rx.m.e
            public final Object call(Object obj) {
                EditorialDownloadModel editorialDownloadModel2 = editorialDownloadModel;
                EditorialPresenter.lambda$verifyNotEnoughSpaceError$91(editorialDownloadModel2, (WalletAdsOfferManager.OfferResponseStatus) obj);
                return editorialDownloadModel2;
            }
        }) : rx.e.S(editorialDownloadModel);
    }

    public void handleClickActionButtonCard() {
        rx.e eVarF = this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.editorial.b2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.editorial.d4
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5312f.k((View.LifecycleEvent) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.editorial.k4
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f5385f.l((EditorialEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY));
        f1 f1Var = new rx.m.b() { // from class: cm.aptoide.pt.editorial.f1
            @Override // rx.m.b
            public final void call(Object obj) {
                EditorialPresenter.lambda$handleClickActionButtonCard$33((EditorialEvent) obj);
            }
        };
        CrashReport crashReport = this.crashReporter;
        crashReport.getClass();
        eVarF.H0(f1Var, new b(crashReport));
    }

    public void handleClickOnAppCard() {
        rx.e<R> eVarG = this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.editorial.s0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.editorial.x0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5509f.m((View.LifecycleEvent) obj);
            }
        });
        final EditorialView editorialView = this.view;
        editorialView.getClass();
        rx.e eVarF = eVarG.G(new rx.m.e() { // from class: cm.aptoide.pt.editorial.u6
            @Override // rx.m.e
            public final Object call(Object obj) {
                return editorialView.appCardClicked((EditorialViewModel) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.editorial.a5
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f5276f.n((EditorialEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY));
        z3 z3Var = new rx.m.b() { // from class: cm.aptoide.pt.editorial.z3
            @Override // rx.m.b
            public final void call(Object obj) {
                EditorialPresenter.lambda$handleClickOnAppCard$29((EditorialEvent) obj);
            }
        };
        CrashReport crashReport = this.crashReporter;
        crashReport.getClass();
        eVarF.H0(z3Var, new b(crashReport));
    }

    public void handleClickOnMedia() {
        rx.e eVarF = this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.editorial.f5
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.editorial.n4
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5415f.o((View.LifecycleEvent) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.editorial.y3
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f5526f.p((EditorialEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY));
        z0 z0Var = new rx.m.b() { // from class: cm.aptoide.pt.editorial.z0
            @Override // rx.m.b
            public final void call(Object obj) {
                EditorialPresenter.lambda$handleClickOnMedia$25((EditorialEvent) obj);
            }
        };
        CrashReport crashReport = this.crashReporter;
        crashReport.getClass();
        eVarF.H0(z0Var, new b(crashReport));
    }

    public void handleLongPressReactionButton() {
        rx.e eVarF = this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.editorial.u5
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.editorial.h2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5349f.z((View.LifecycleEvent) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.editorial.w2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5500f.A((Void) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.editorial.x2
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f5511f.B((EditorialViewModel) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY));
        l1 l1Var = new rx.m.b() { // from class: cm.aptoide.pt.editorial.l1
            @Override // rx.m.b
            public final void call(Object obj) {
                EditorialPresenter.lambda$handleLongPressReactionButton$137((EditorialViewModel) obj);
            }
        };
        CrashReport crashReport = this.crashReporter;
        crashReport.getClass();
        eVarF.H0(l1Var, new b(crashReport));
    }

    public void handleMediaListDescriptionVisibility() {
        rx.e eVarF = this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.editorial.r3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.editorial.a3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5273f.C((View.LifecycleEvent) obj);
            }
        }).j0(this.viewScheduler).D(new rx.m.e() { // from class: cm.aptoide.pt.editorial.v0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((EditorialEvent) obj).getFirstVisiblePosition() >= 0);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.editorial.x5
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f5514f.D((EditorialEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY));
        e4 e4Var = new rx.m.b() { // from class: cm.aptoide.pt.editorial.e4
            @Override // rx.m.b
            public final void call(Object obj) {
                EditorialPresenter.lambda$handleMediaListDescriptionVisibility$107((EditorialEvent) obj);
            }
        };
        CrashReport crashReport = this.crashReporter;
        crashReport.getClass();
        eVarF.H0(e4Var, new b(crashReport));
    }

    public void handleMovingCollapse() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.editorial.g1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.editorial.o4
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5423f.E((View.LifecycleEvent) obj);
            }
        }).j0(this.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.editorial.k3
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f5384f.F((Boolean) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.editorial.j2
            @Override // rx.m.b
            public final void call(Object obj) {
                EditorialPresenter.lambda$handleMovingCollapse$111((Boolean) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.editorial.q2
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f5444f.G((Throwable) obj);
            }
        });
    }

    public void handlePlaceHolderVisibility() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.editorial.r0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj) == View.LifecycleEvent.CREATE);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.editorial.v5
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5493f.L((View.LifecycleEvent) obj);
            }
        }).j0(this.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.editorial.i5
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f5368f.M((Void) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.editorial.d1
            @Override // rx.m.b
            public final void call(Object obj) {
                EditorialPresenter.lambda$handlePlaceHolderVisibility$95((Void) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.editorial.y5
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f5528f.N((Throwable) obj);
            }
        });
    }

    public void handlePlaceHolderVisibilityChange() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.editorial.t0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.editorial.c4
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5299f.Q((View.LifecycleEvent) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.editorial.f3
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f5330f.O((ScrollEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.editorial.n2
            @Override // rx.m.b
            public final void call(Object obj) {
                EditorialPresenter.lambda$handlePlaceHolderVisibilityChange$101((ScrollEvent) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.editorial.e3
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f5321f.P((Throwable) obj);
            }
        });
    }

    public void handleReactionButtonClick() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.editorial.y4
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.editorial.n1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5411f.R((View.LifecycleEvent) obj);
            }
        }).L(new rx.m.e() { // from class: cm.aptoide.pt.editorial.y0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5522f.S((Void) obj);
            }
        }).j0(this.viewScheduler).G(new rx.m.e() { // from class: cm.aptoide.pt.editorial.h3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5350f.T((EditorialViewModel) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.editorial.u4
            @Override // rx.m.b
            public final void call(Object obj) {
                EditorialPresenter.lambda$handleReactionButtonClick$124((LoadReactionModel) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.editorial.u3
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f5480f.U((Throwable) obj);
            }
        });
    }

    public void handleRetryClick() {
        rx.e eVarF = this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.editorial.u0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.editorial.o5
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5424f.X((View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY));
        q4 q4Var = new rx.m.b() { // from class: cm.aptoide.pt.editorial.q4
            @Override // rx.m.b
            public final void call(Object obj) {
                EditorialPresenter.lambda$handleRetryClick$21((EditorialViewModel) obj);
            }
        };
        CrashReport crashReport = this.crashReporter;
        crashReport.getClass();
        eVarF.H0(q4Var, new b(crashReport));
    }

    public void handleSnackLogInClick() {
        rx.e eVarF = this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.editorial.s3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.editorial.m3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5404f.b0((View.LifecycleEvent) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.editorial.w1
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f5499f.c0((Void) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY));
        m4 m4Var = new rx.m.b() { // from class: cm.aptoide.pt.editorial.m4
            @Override // rx.m.b
            public final void call(Object obj) {
                EditorialPresenter.lambda$handleSnackLogInClick$141((Void) obj);
            }
        };
        CrashReport crashReport = this.crashReporter;
        crashReport.getClass();
        eVarF.H0(m4Var, new b(crashReport));
    }

    public void handleUserReaction() {
        rx.e eVarF = this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.editorial.j3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.editorial.g4
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5343f.f0((View.LifecycleEvent) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.editorial.b4
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f5284f.g0((ReactionEvent) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.editorial.w3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5501f.j0((ReactionEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY));
        v4 v4Var = new rx.m.b() { // from class: cm.aptoide.pt.editorial.v4
            @Override // rx.m.b
            public final void call(Object obj) {
                EditorialPresenter.lambda$handleUserReaction$132((LoadReactionModel) obj);
            }
        };
        CrashReport crashReport = this.crashReporter;
        crashReport.getClass();
        eVarF.H0(v4Var, new b(crashReport));
    }

    public void loadDownloadApp() {
        rx.e eVarF = this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.editorial.b1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj) == View.LifecycleEvent.CREATE);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.editorial.z4
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5541f.k0((View.LifecycleEvent) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.editorial.v2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5487f.l0((Void) obj);
            }
        }).J(new rx.m.e() { // from class: cm.aptoide.pt.editorial.a2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return ((EditorialViewModel) obj).getPlaceHolderContent();
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.editorial.e5
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5323f.m0((EditorialContent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY));
        y1 y1Var = new rx.m.b() { // from class: cm.aptoide.pt.editorial.y1
            @Override // rx.m.b
            public final void call(Object obj) {
                EditorialPresenter.lambda$loadDownloadApp$81((EditorialDownloadModel) obj);
            }
        };
        CrashReport crashReport = this.crashReporter;
        crashReport.getClass();
        eVarF.H0(y1Var, new b(crashReport));
    }

    public void observeDownloadErrors() {
        rx.e eVarF = this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.editorial.x4
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj) == View.LifecycleEvent.CREATE);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.editorial.t2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5469f.p0((View.LifecycleEvent) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.editorial.h5
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5352f.q0((EditorialViewModel) obj);
            }
        }).J(new rx.m.e() { // from class: cm.aptoide.pt.editorial.w6
            @Override // rx.m.e
            public final Object call(Object obj) {
                return ((EditorialViewModel) obj).getPlaceHolderContent();
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.editorial.p2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5431f.t0((EditorialContent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY));
        a6 a6Var = new rx.m.b() { // from class: cm.aptoide.pt.editorial.a6
            @Override // rx.m.b
            public final void call(Object obj) {
                EditorialPresenter.lambda$observeDownloadErrors$89((EditorialDownloadModel) obj);
            }
        };
        CrashReport crashReport = this.crashReporter;
        crashReport.getClass();
        eVarF.H0(a6Var, new b(crashReport));
    }

    public void onCreateLoadAppOfTheWeek() {
        rx.e<R> eVarL = this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.editorial.o3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.editorial.j1
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f5373f.u0((View.LifecycleEvent) obj);
            }
        }).L(new rx.m.e() { // from class: cm.aptoide.pt.editorial.l3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5395f.v0((View.LifecycleEvent) obj);
            }
        });
        x3 x3Var = new rx.m.b() { // from class: cm.aptoide.pt.editorial.x3
            @Override // rx.m.b
            public final void call(Object obj) {
                EditorialPresenter.lambda$onCreateLoadAppOfTheWeek$14((EditorialViewModel) obj);
            }
        };
        CrashReport crashReport = this.crashReporter;
        crashReport.getClass();
        eVarL.H0(x3Var, new b(crashReport));
    }

    public void onCreateLoadReactionModel() {
        rx.e eVarF = this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.editorial.s4
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.editorial.o1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5420f.w0((View.LifecycleEvent) obj);
            }
        }).L(new rx.m.e() { // from class: cm.aptoide.pt.editorial.m5
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5406f.x0((EditorialViewModel) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY));
        e2 e2Var = new rx.m.b() { // from class: cm.aptoide.pt.editorial.e2
            @Override // rx.m.b
            public final void call(Object obj) {
                EditorialPresenter.lambda$onCreateLoadReactionModel$145((LoadReactionModel) obj);
            }
        };
        CrashReport crashReport = this.crashReporter;
        crashReport.getClass();
        eVarF.H0(e2Var, new b(crashReport));
    }

    @Override // cm.aptoide.pt.presenter.Presenter
    public void present() {
        onCreateLoadAppOfTheWeek();
        handleRetryClick();
        handleClickOnMedia();
        handleClickOnAppCard();
        handleInstallClick();
        observeDownloadErrors();
        pauseDownload();
        resumeDownload();
        cancelDownload();
        loadDownloadApp();
        handlePlaceHolderVisibilityChange();
        handlePlaceHolderVisibility();
        handleMediaListDescriptionVisibility();
        handleClickActionButtonCard();
        handleMovingCollapse();
        handleReactionButtonClick();
        handleUserReaction();
        handleLongPressReactionButton();
        handleSnackLogInClick();
        onCreateLoadReactionModel();
        handleSocialMediaPromotionClick();
        handleOutOfSpaceDialogResult();
    }
}
