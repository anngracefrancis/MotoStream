package cm.aptoide.pt.editorialList;

import cm.aptoide.accountmanager.Account;
import cm.aptoide.accountmanager.AptoideAccountManager;
import cm.aptoide.pt.UserFeedbackAnalytics;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.home.bundles.editorial.EditorialHomeEvent;
import cm.aptoide.pt.presenter.Presenter;
import cm.aptoide.pt.presenter.View;
import cm.aptoide.pt.reactions.ReactionsHomeEvent;
import cm.aptoide.pt.reactions.network.ReactionsResponse;
import rx.Single;

/* JADX INFO: loaded from: classes.dex */
public class EditorialListPresenter implements Presenter {
    private final AptoideAccountManager accountManager;
    private final CrashReport crashReporter;
    private final EditorialListAnalytics editorialListAnalytics;
    private final EditorialListManager editorialListManager;
    private final EditorialListNavigator editorialListNavigator;
    private final UserFeedbackAnalytics userFeedbackAnalytics;
    private final EditorialListView view;
    private final rx.h viewScheduler;

    public EditorialListPresenter(EditorialListView editorialListView, EditorialListManager editorialListManager, AptoideAccountManager aptoideAccountManager, EditorialListNavigator editorialListNavigator, EditorialListAnalytics editorialListAnalytics, CrashReport crashReport, rx.h hVar, UserFeedbackAnalytics userFeedbackAnalytics) {
        this.view = editorialListView;
        this.editorialListManager = editorialListManager;
        this.accountManager = aptoideAccountManager;
        this.editorialListNavigator = editorialListNavigator;
        this.editorialListAnalytics = editorialListAnalytics;
        this.crashReporter = crashReport;
        this.viewScheduler = hVar;
        this.userFeedbackAnalytics = userFeedbackAnalytics;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getUserAvatar, reason: merged with bridge method [inline-methods] */
    public rx.e<String> M(Account account) {
        return rx.e.S((account == null || !account.isLoggedIn()) ? null : account.getAvatar());
    }

    private void handleReactionsResponse(ReactionsResponse reactionsResponse, boolean z) {
        if (reactionsResponse.wasSuccess()) {
            if (z) {
                this.editorialListAnalytics.sendDeleteEvent();
                return;
            } else {
                this.editorialListAnalytics.sendReactedEvent();
                return;
            }
        }
        if (reactionsResponse.reactionsExceeded()) {
            this.view.showLogInDialog();
        } else if (reactionsResponse.wasNetworkError()) {
            this.view.showNetworkErrorToast();
        } else if (reactionsResponse.wasGeneralError()) {
            this.view.showGenericErrorToast();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public rx.e<CurationCard> handleSinglePressReactionButton(final EditorialHomeEvent editorialHomeEvent) {
        return this.editorialListManager.isFirstReaction(editorialHomeEvent.getCardId(), editorialHomeEvent.getGroupId()).k(new rx.m.e() { // from class: cm.aptoide.pt.editorialList.j2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5584f.x(editorialHomeEvent, (Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleBottomReached$31, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Boolean b(Object obj) {
        return Boolean.valueOf(this.editorialListManager.hasMore());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleBottomReached$32, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c(Object obj) {
        this.view.showLoadMore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleBottomReached$33, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e d(Object obj) {
        return loadEditorialAndReactions(true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleBottomReached$34, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e e(View.LifecycleEvent lifecycleEvent) {
        return this.view.reachesBottom().D(new rx.m.e() { // from class: cm.aptoide.pt.editorialList.m2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5597f.b(obj);
            }
        }).j0(this.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.editorialList.c1
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f5554f.c(obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.editorialList.g2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5571f.d(obj);
            }
        }).s0();
    }

    static /* synthetic */ void lambda$handleBottomReached$35(CurationCard curationCard) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleBottomReached$36, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(Throwable th) {
        this.crashReporter.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleEditorialCardClick$13, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g(EditorialHomeEvent editorialHomeEvent) {
        this.editorialListAnalytics.sendEditorialInteractEvent(editorialHomeEvent.getCardId(), editorialHomeEvent.getBundlePosition());
        this.editorialListNavigator.navigateToEditorial(editorialHomeEvent.getCardId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleEditorialCardClick$14, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e h(View.LifecycleEvent lifecycleEvent) {
        return this.view.editorialCardClicked().j0(this.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.editorialList.n1
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f5600f.g((EditorialHomeEvent) obj);
            }
        }).s0();
    }

    static /* synthetic */ void lambda$handleEditorialCardClick$15(EditorialHomeEvent editorialHomeEvent) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleEditorialCardClick$16, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i(Throwable th) {
        this.crashReporter.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleImpressions$27, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j(EditorialListEvent editorialListEvent) {
        this.editorialListAnalytics.sendEditorialImpressionEvent(editorialListEvent.getCardId(), editorialListEvent.getPosition());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleImpressions$28, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e k(View.LifecycleEvent lifecycleEvent) {
        return this.view.visibleCards().j0(this.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.editorialList.d2
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f5559f.j((EditorialListEvent) obj);
            }
        });
    }

    static /* synthetic */ void lambda$handleImpressions$29(EditorialListEvent editorialListEvent) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleLongPressReactionButton$48, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e l(View.LifecycleEvent lifecycleEvent) {
        return this.view.reactionButtonLongPress();
    }

    static /* synthetic */ void lambda$handleLongPressReactionButton$50(EditorialHomeEvent editorialHomeEvent) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleOnDismissPopup$52, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e n(View.LifecycleEvent lifecycleEvent) {
        return this.view.onPopupDismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleOnDismissPopup$53, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void o(EditorialHomeEvent editorialHomeEvent) {
        this.view.setScrollEnabled(Boolean.TRUE);
    }

    static /* synthetic */ void lambda$handleOnDismissPopup$54(EditorialHomeEvent editorialHomeEvent) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handlePullToRefresh$18, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e p(Void r2) {
        return loadEditorialAndReactions(false, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handlePullToRefresh$19, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e q(View.LifecycleEvent lifecycleEvent) {
        return this.view.refreshes().G(new rx.m.e() { // from class: cm.aptoide.pt.editorialList.t1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5624f.p((Void) obj);
            }
        }).s0();
    }

    static /* synthetic */ void lambda$handlePullToRefresh$20(CurationCard curationCard) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleReactionButtonClick$45, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e r(View.LifecycleEvent lifecycleEvent) {
        return this.view.reactionsButtonClicked();
    }

    static /* synthetic */ void lambda$handleReactionButtonClick$46(CurationCard curationCard) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleRetryClick$22, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void s(Void r1) {
        this.view.showLoading();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleRetryClick$23, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e t(Void r2) {
        return loadEditorialAndReactions(false, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleRetryClick$24, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e u(View.LifecycleEvent lifecycleEvent) {
        return this.view.retryClicked().j0(this.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.editorialList.u1
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f5627f.s((Void) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.editorialList.w0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5635f.t((Void) obj);
            }
        });
    }

    static /* synthetic */ void lambda$handleRetryClick$25(CurationCard curationCard) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleSinglePressReactionButton$66, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void v(ReactionsResponse reactionsResponse) {
        handleReactionsResponse(reactionsResponse, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleSinglePressReactionButton$67, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single w(EditorialHomeEvent editorialHomeEvent, ReactionsResponse reactionsResponse) {
        return loadReactionModel(editorialHomeEvent.getCardId(), editorialHomeEvent.getGroupId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleSinglePressReactionButton$68, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e x(final EditorialHomeEvent editorialHomeEvent, Boolean bool) {
        if (!bool.booleanValue()) {
            return this.editorialListManager.deleteReaction(editorialHomeEvent.getCardId(), editorialHomeEvent.getGroupId()).A().x(new rx.m.b() { // from class: cm.aptoide.pt.editorialList.z0
                @Override // rx.m.b
                public final void call(Object obj) {
                    this.f5645f.v((ReactionsResponse) obj);
                }
            }).D(r2.f5617f).L(new rx.m.e() { // from class: cm.aptoide.pt.editorialList.y0
                @Override // rx.m.e
                public final Object call(Object obj) {
                    return this.f5641f.w(editorialHomeEvent, (ReactionsResponse) obj);
                }
            });
        }
        lambda$handleLongPressReactionButton$49(editorialHomeEvent);
        return rx.e.S(new CurationCard());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleSnackLogInClick$63, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e y(View.LifecycleEvent lifecycleEvent) {
        return this.view.snackLogInClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleSnackLogInClick$64, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void z(Void r1) {
        this.editorialListNavigator.navigateToLogIn();
    }

    static /* synthetic */ void lambda$handleSnackLogInClick$65(Void r0) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleUserImageClick$40, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void A(Void r1) {
        this.editorialListNavigator.navigateToMyAccount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleUserImageClick$41, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e B(View.LifecycleEvent lifecycleEvent) {
        return this.view.imageClick().j0(this.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.editorialList.k0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f5587f.A((Void) obj);
            }
        }).s0();
    }

    static /* synthetic */ void lambda$handleUserImageClick$42(Void r0) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleUserImageClick$43, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void C(Throwable th) {
        this.crashReporter.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleUserReaction$56, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e D(View.LifecycleEvent lifecycleEvent) {
        return this.view.reactionClicked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleUserReaction$57, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void E(ReactionsHomeEvent reactionsHomeEvent) {
        this.userFeedbackAnalytics.sendReactionEvent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleUserReaction$58, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void F(ReactionsResponse reactionsResponse) {
        handleReactionsResponse(reactionsResponse, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleUserReaction$59, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single G(ReactionsHomeEvent reactionsHomeEvent, ReactionsResponse reactionsResponse) {
        return loadReactionModel(reactionsHomeEvent.getCardId(), reactionsHomeEvent.getGroupId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleUserReaction$60, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e H(final ReactionsHomeEvent reactionsHomeEvent) {
        return this.editorialListManager.setReaction(reactionsHomeEvent.getCardId(), reactionsHomeEvent.getGroupId(), reactionsHomeEvent.getReaction()).A().D(new rx.m.e() { // from class: cm.aptoide.pt.editorialList.p2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((ReactionsResponse) obj).differentReaction());
            }
        }).j0(this.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.editorialList.d1
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f5558f.F((ReactionsResponse) obj);
            }
        }).D(r2.f5617f).L(new rx.m.e() { // from class: cm.aptoide.pt.editorialList.t0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5622f.G(reactionsHomeEvent, (ReactionsResponse) obj);
            }
        });
    }

    static /* synthetic */ void lambda$handleUserReaction$61(CurationCard curationCard) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadEditorialAndReactions$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single I(CurationCard curationCard) {
        return loadReactionModel(curationCard.getId(), curationCard.getType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadEditorialListModel$37, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void J(boolean z, EditorialListModel editorialListModel) {
        if (!editorialListModel.getEditorialCardListModel().isLoading()) {
            this.view.hideLoading();
        }
        if (editorialListModel.getEditorialCardListModel().hasError()) {
            if (editorialListModel.getEditorialCardListModel().getError() == EditorialCardListModel.Error.NETWORK) {
                this.view.showNetworkError();
            } else {
                this.view.showGenericError();
            }
        } else if (z) {
            this.view.hideRefresh();
            this.view.update(editorialListModel.getEditorialCardListModel().getCurationCards());
        } else {
            this.view.populateView(editorialListModel.getEditorialCardListModel().getCurationCards(), editorialListModel.getBonusAppcModel());
        }
        this.view.hideLoadMore();
    }

    static /* synthetic */ EditorialListModel lambda$loadEditorialListModel$38(EditorialListModel editorialListModel) {
        return editorialListModel;
    }

    static /* synthetic */ void lambda$loadUserImage$10(String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadUserImage$11, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void K(Throwable th) {
        this.crashReporter.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadUserImage$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e L(View.LifecycleEvent lifecycleEvent) {
        return this.accountManager.accountStatus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadUserImage$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void N(String str) {
        if (str != null) {
            this.view.setUserImage(str);
        } else {
            this.view.setDefaultUserImage();
        }
        this.view.showAvatar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$onCreateLoadViewModel$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void O(View.LifecycleEvent lifecycleEvent) {
        this.view.showLoading();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$onCreateLoadViewModel$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e P(View.LifecycleEvent lifecycleEvent) {
        return loadEditorialAndReactions(false, false);
    }

    static /* synthetic */ void lambda$onCreateLoadViewModel$3(CurationCard curationCard) {
    }

    private rx.e<CurationCard> loadEditorialAndReactions(boolean z, boolean z2) {
        return loadEditorialListModel(z, z2).A().J(new rx.m.e() { // from class: cm.aptoide.pt.editorialList.i0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return ((EditorialListModel) obj).getEditorialCardListModel().getCurationCards();
            }
        }).L(new rx.m.e() { // from class: cm.aptoide.pt.editorialList.h0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5573f.I((CurationCard) obj);
            }
        });
    }

    private Single<EditorialListModel> loadEditorialListModel(boolean z, final boolean z2) {
        return this.editorialListManager.loadEditorialListModel(z, z2).p(this.viewScheduler).g(new rx.m.b() { // from class: cm.aptoide.pt.editorialList.h1
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f5574f.J(z2, (EditorialListModel) obj);
            }
        }).n(new rx.m.e() { // from class: cm.aptoide.pt.editorialList.k2
            @Override // rx.m.e
            public final Object call(Object obj) {
                EditorialListModel editorialListModel = (EditorialListModel) obj;
                EditorialListPresenter.lambda$loadEditorialListModel$38(editorialListModel);
                return editorialListModel;
            }
        });
    }

    private Single<CurationCard> loadReactionModel(String str, String str2) {
        Single<CurationCard> singleP = this.editorialListManager.loadReactionModel(str, str2).p(this.viewScheduler);
        final EditorialListView editorialListView = this.view;
        editorialListView.getClass();
        return singleP.g(new rx.m.b() { // from class: cm.aptoide.pt.editorialList.q2
            @Override // rx.m.b
            public final void call(Object obj) {
                editorialListView.updateEditorialCard((CurationCard) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: showReactions, reason: merged with bridge method [inline-methods] */
    public void m(EditorialHomeEvent editorialHomeEvent) {
        this.editorialListAnalytics.sendReactionButtonClickEvent();
        this.view.showReactionsPopup(editorialHomeEvent.getCardId(), editorialHomeEvent.getGroupId(), editorialHomeEvent.getBundlePosition());
    }

    public void handleBottomReached() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.editorialList.h2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.editorialList.q1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5612f.e((View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.editorialList.x0
            @Override // rx.m.b
            public final void call(Object obj) {
                EditorialListPresenter.lambda$handleBottomReached$35((CurationCard) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.editorialList.y
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f5640f.f((Throwable) obj);
            }
        });
    }

    public void handleEditorialCardClick() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.editorialList.e1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.editorialList.x1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5639f.h((View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.editorialList.b2
            @Override // rx.m.b
            public final void call(Object obj) {
                EditorialListPresenter.lambda$handleEditorialCardClick$15((EditorialHomeEvent) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.editorialList.v0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f5631f.i((Throwable) obj);
            }
        });
    }

    public void handleImpressions() {
        rx.e eVarF = this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.editorialList.f1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.editorialList.i1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5579f.k((View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY));
        p0 p0Var = new rx.m.b() { // from class: cm.aptoide.pt.editorialList.p0
            @Override // rx.m.b
            public final void call(Object obj) {
                EditorialListPresenter.lambda$handleImpressions$29((EditorialListEvent) obj);
            }
        };
        CrashReport crashReport = this.crashReporter;
        crashReport.getClass();
        eVarF.H0(p0Var, new a(crashReport));
    }

    void handleLongPressReactionButton() {
        rx.e eVarF = this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.editorialList.j1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.editorialList.j0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5582f.l((View.LifecycleEvent) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.editorialList.s1
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f5620f.m((EditorialHomeEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY));
        r1 r1Var = new rx.m.b() { // from class: cm.aptoide.pt.editorialList.r1
            @Override // rx.m.b
            public final void call(Object obj) {
                EditorialListPresenter.lambda$handleLongPressReactionButton$50((EditorialHomeEvent) obj);
            }
        };
        CrashReport crashReport = this.crashReporter;
        crashReport.getClass();
        eVarF.H0(r1Var, new a(crashReport));
    }

    void handleOnDismissPopup() {
        rx.e eVarF = this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.editorialList.w1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.editorialList.g0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5569f.n((View.LifecycleEvent) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.editorialList.s0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f5619f.o((EditorialHomeEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY));
        l2 l2Var = new rx.m.b() { // from class: cm.aptoide.pt.editorialList.l2
            @Override // rx.m.b
            public final void call(Object obj) {
                EditorialListPresenter.lambda$handleOnDismissPopup$54((EditorialHomeEvent) obj);
            }
        };
        CrashReport crashReport = this.crashReporter;
        crashReport.getClass();
        eVarF.H0(l2Var, new a(crashReport));
    }

    public void handlePullToRefresh() {
        rx.e eVarF = this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.editorialList.q0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.editorialList.x
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5637f.q((View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY));
        e2 e2Var = new rx.m.b() { // from class: cm.aptoide.pt.editorialList.e2
            @Override // rx.m.b
            public final void call(Object obj) {
                EditorialListPresenter.lambda$handlePullToRefresh$20((CurationCard) obj);
            }
        };
        CrashReport crashReport = this.crashReporter;
        crashReport.getClass();
        eVarF.H0(e2Var, new a(crashReport));
    }

    public void handleReactionButtonClick() {
        rx.e eVarF = this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.editorialList.i2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.editorialList.v1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5632f.r((View.LifecycleEvent) obj);
            }
        }).j0(this.viewScheduler).G(new rx.m.e() { // from class: cm.aptoide.pt.editorialList.o0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5603f.handleSinglePressReactionButton((EditorialHomeEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY));
        n2 n2Var = new rx.m.b() { // from class: cm.aptoide.pt.editorialList.n2
            @Override // rx.m.b
            public final void call(Object obj) {
                EditorialListPresenter.lambda$handleReactionButtonClick$46((CurationCard) obj);
            }
        };
        CrashReport crashReport = this.crashReporter;
        crashReport.getClass();
        eVarF.H0(n2Var, new a(crashReport));
    }

    public void handleRetryClick() {
        rx.e eVarF = this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.editorialList.z1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.editorialList.d0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5557f.u((View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY));
        m0 m0Var = new rx.m.b() { // from class: cm.aptoide.pt.editorialList.m0
            @Override // rx.m.b
            public final void call(Object obj) {
                EditorialListPresenter.lambda$handleRetryClick$25((CurationCard) obj);
            }
        };
        CrashReport crashReport = this.crashReporter;
        crashReport.getClass();
        eVarF.H0(m0Var, new a(crashReport));
    }

    public void handleSnackLogInClick() {
        rx.e eVarF = this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.editorialList.o1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.editorialList.a0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5544f.y((View.LifecycleEvent) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.editorialList.l0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f5591f.z((Void) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY));
        o2 o2Var = new rx.m.b() { // from class: cm.aptoide.pt.editorialList.o2
            @Override // rx.m.b
            public final void call(Object obj) {
                EditorialListPresenter.lambda$handleSnackLogInClick$65((Void) obj);
            }
        };
        CrashReport crashReport = this.crashReporter;
        crashReport.getClass();
        eVarF.H0(o2Var, new a(crashReport));
    }

    public void handleUserImageClick() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.editorialList.z
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.editorialList.f2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5567f.B((View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.editorialList.b1
            @Override // rx.m.b
            public final void call(Object obj) {
                EditorialListPresenter.lambda$handleUserImageClick$42((Void) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.editorialList.c0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f5553f.C((Throwable) obj);
            }
        });
    }

    public void handleUserReaction() {
        rx.e eVarF = this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.editorialList.e0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.editorialList.y1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5643f.D((View.LifecycleEvent) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.editorialList.l1
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f5592f.E((ReactionsHomeEvent) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.editorialList.m1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5596f.H((ReactionsHomeEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY));
        r0 r0Var = new rx.m.b() { // from class: cm.aptoide.pt.editorialList.r0
            @Override // rx.m.b
            public final void call(Object obj) {
                EditorialListPresenter.lambda$handleUserReaction$61((CurationCard) obj);
            }
        };
        CrashReport crashReport = this.crashReporter;
        crashReport.getClass();
        eVarF.H0(r0Var, new a(crashReport));
    }

    public void loadUserImage() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.editorialList.b0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.editorialList.k1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5588f.L((View.LifecycleEvent) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.editorialList.u0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5626f.M((Account) obj);
            }
        }).j0(this.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.editorialList.a1
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f5545f.N((String) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.editorialList.g1
            @Override // rx.m.b
            public final void call(Object obj) {
                EditorialListPresenter.lambda$loadUserImage$10((String) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.editorialList.f0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f5565f.K((Throwable) obj);
            }
        });
    }

    public void onCreateLoadViewModel() {
        rx.e eVarF = this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.editorialList.a2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.editorialList.c2
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f5555f.O((View.LifecycleEvent) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.editorialList.p1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5608f.P((View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY));
        n0 n0Var = new rx.m.b() { // from class: cm.aptoide.pt.editorialList.n0
            @Override // rx.m.b
            public final void call(Object obj) {
                EditorialListPresenter.lambda$onCreateLoadViewModel$3((CurationCard) obj);
            }
        };
        CrashReport crashReport = this.crashReporter;
        crashReport.getClass();
        eVarF.H0(n0Var, new a(crashReport));
    }

    @Override // cm.aptoide.pt.presenter.Presenter
    public void present() {
        onCreateLoadViewModel();
        handleImpressions();
        handleEditorialCardClick();
        handlePullToRefresh();
        handleRetryClick();
        handleBottomReached();
        handleUserImageClick();
        loadUserImage();
        handleReactionButtonClick();
        handleLongPressReactionButton();
        handleUserReaction();
        handleSnackLogInClick();
        handleOnDismissPopup();
    }
}
