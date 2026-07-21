package cm.aptoide.pt.account.view.magiclink;

import cm.aptoide.accountmanager.AptoideAccountManager;
import cm.aptoide.pt.account.AgentPersistence;
import cm.aptoide.pt.presenter.Presenter;
import cm.aptoide.pt.presenter.View;
import com.aptoide.authentication.model.CodeAuth;
import kotlin.Metadata;
import okhttp3.HttpUrl;
import rx.Single;

/* JADX INFO: compiled from: SendMagicLinkPresenter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0010\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcm/aptoide/pt/account/view/magiclink/SendMagicLinkPresenter;", "Lcm/aptoide/pt/presenter/Presenter;", "view", "Lcm/aptoide/pt/account/view/magiclink/MagicLinkView;", "accountManager", "Lcm/aptoide/accountmanager/AptoideAccountManager;", "navigator", "Lcm/aptoide/pt/account/view/magiclink/SendMagicLinkNavigator;", "viewScheduler", "Lrx/Scheduler;", "agentPersistence", "Lcm/aptoide/pt/account/AgentPersistence;", "(Lcm/aptoide/pt/account/view/magiclink/MagicLinkView;Lcm/aptoide/accountmanager/AptoideAccountManager;Lcm/aptoide/pt/account/view/magiclink/SendMagicLinkNavigator;Lrx/Scheduler;Lcm/aptoide/pt/account/AgentPersistence;)V", "handleEmailChangeEvents", HttpUrl.FRAGMENT_ENCODE_SET, "handleSecureLoginTextClick", "handleSendMagicLinkClick", "present", "validateEmail", "Lrx/Observable;", HttpUrl.FRAGMENT_ENCODE_SET, "email", HttpUrl.FRAGMENT_ENCODE_SET, "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SendMagicLinkPresenter implements Presenter {
    private final AptoideAccountManager accountManager;
    private final AgentPersistence agentPersistence;
    private final SendMagicLinkNavigator navigator;
    private final MagicLinkView view;
    private final rx.h viewScheduler;

    public SendMagicLinkPresenter(MagicLinkView magicLinkView, AptoideAccountManager aptoideAccountManager, SendMagicLinkNavigator sendMagicLinkNavigator, rx.h hVar, AgentPersistence agentPersistence) {
        kotlin.jvm.internal.m.f(magicLinkView, "view");
        kotlin.jvm.internal.m.f(aptoideAccountManager, "accountManager");
        kotlin.jvm.internal.m.f(sendMagicLinkNavigator, "navigator");
        kotlin.jvm.internal.m.f(hVar, "viewScheduler");
        kotlin.jvm.internal.m.f(agentPersistence, "agentPersistence");
        this.view = magicLinkView;
        this.accountManager = aptoideAccountManager;
        this.navigator = sendMagicLinkNavigator;
        this.viewScheduler = hVar;
        this.agentPersistence = agentPersistence;
    }

    private final void handleEmailChangeEvents() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.account.view.magiclink.v
            @Override // rx.m.e
            public final Object call(Object obj) {
                return SendMagicLinkPresenter.m28handleEmailChangeEvents$lambda5((View.LifecycleEvent) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.account.view.magiclink.w
            @Override // rx.m.e
            public final Object call(Object obj) {
                return SendMagicLinkPresenter.m29handleEmailChangeEvents$lambda7(this.f3887f, (View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.account.view.magiclink.u
            @Override // rx.m.b
            public final void call(Object obj) {
                SendMagicLinkPresenter.m31handleEmailChangeEvents$lambda8((String) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.account.view.magiclink.n
            @Override // rx.m.b
            public final void call(Object obj) {
                ((Throwable) obj).printStackTrace();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleEmailChangeEvents$lambda-5, reason: not valid java name */
    public static final Boolean m28handleEmailChangeEvents$lambda5(View.LifecycleEvent lifecycleEvent) {
        return Boolean.valueOf(View.LifecycleEvent.CREATE == lifecycleEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleEmailChangeEvents$lambda-7, reason: not valid java name */
    public static final rx.e m29handleEmailChangeEvents$lambda7(final SendMagicLinkPresenter sendMagicLinkPresenter, View.LifecycleEvent lifecycleEvent) {
        kotlin.jvm.internal.m.f(sendMagicLinkPresenter, "this$0");
        return sendMagicLinkPresenter.view.getEmailTextChangeEvent().x(new rx.m.b() { // from class: cm.aptoide.pt.account.view.magiclink.t
            @Override // rx.m.b
            public final void call(Object obj) {
                SendMagicLinkPresenter.m30handleEmailChangeEvents$lambda7$lambda6(this.f3884f, (String) obj);
            }
        }).s0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleEmailChangeEvents$lambda-7$lambda-6, reason: not valid java name */
    public static final void m30handleEmailChangeEvents$lambda7$lambda6(SendMagicLinkPresenter sendMagicLinkPresenter, String str) {
        kotlin.jvm.internal.m.f(sendMagicLinkPresenter, "this$0");
        sendMagicLinkPresenter.view.removeTextFieldError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleEmailChangeEvents$lambda-8, reason: not valid java name */
    public static final void m31handleEmailChangeEvents$lambda8(String str) {
    }

    private final void handleSecureLoginTextClick() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.account.view.magiclink.j
            @Override // rx.m.e
            public final Object call(Object obj) {
                return SendMagicLinkPresenter.m33handleSecureLoginTextClick$lambda0((View.LifecycleEvent) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.account.view.magiclink.m
            @Override // rx.m.e
            public final Object call(Object obj) {
                return SendMagicLinkPresenter.m34handleSecureLoginTextClick$lambda2(this.f3875f, (View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.account.view.magiclink.s
            @Override // rx.m.b
            public final void call(Object obj) {
                SendMagicLinkPresenter.m36handleSecureLoginTextClick$lambda3((Void) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.account.view.magiclink.h
            @Override // rx.m.b
            public final void call(Object obj) {
                ((Throwable) obj).printStackTrace();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleSecureLoginTextClick$lambda-0, reason: not valid java name */
    public static final Boolean m33handleSecureLoginTextClick$lambda0(View.LifecycleEvent lifecycleEvent) {
        return Boolean.valueOf(View.LifecycleEvent.CREATE == lifecycleEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleSecureLoginTextClick$lambda-2, reason: not valid java name */
    public static final rx.e m34handleSecureLoginTextClick$lambda2(final SendMagicLinkPresenter sendMagicLinkPresenter, View.LifecycleEvent lifecycleEvent) {
        kotlin.jvm.internal.m.f(sendMagicLinkPresenter, "this$0");
        return sendMagicLinkPresenter.view.getSecureLoginTextClick().x(new rx.m.b() { // from class: cm.aptoide.pt.account.view.magiclink.f
            @Override // rx.m.b
            public final void call(Object obj) {
                SendMagicLinkPresenter.m35handleSecureLoginTextClick$lambda2$lambda1(this.f3868f, (Void) obj);
            }
        }).s0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleSecureLoginTextClick$lambda-2$lambda-1, reason: not valid java name */
    public static final void m35handleSecureLoginTextClick$lambda2$lambda1(SendMagicLinkPresenter sendMagicLinkPresenter, Void r1) {
        kotlin.jvm.internal.m.f(sendMagicLinkPresenter, "this$0");
        sendMagicLinkPresenter.navigator.navigateToBlog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleSecureLoginTextClick$lambda-3, reason: not valid java name */
    public static final void m36handleSecureLoginTextClick$lambda3(Void r0) {
    }

    private final void handleSendMagicLinkClick() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.account.view.magiclink.g
            @Override // rx.m.e
            public final Object call(Object obj) {
                return SendMagicLinkPresenter.m38handleSendMagicLinkClick$lambda10((View.LifecycleEvent) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.account.view.magiclink.l
            @Override // rx.m.e
            public final Object call(Object obj) {
                return SendMagicLinkPresenter.m39handleSendMagicLinkClick$lambda17(this.f3874f, (View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.account.view.magiclink.x
            @Override // rx.m.b
            public final void call(Object obj) {
                SendMagicLinkPresenter.m46handleSendMagicLinkClick$lambda18((CodeAuth) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.account.view.magiclink.z
            @Override // rx.m.b
            public final void call(Object obj) {
                ((Throwable) obj).printStackTrace();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleSendMagicLinkClick$lambda-10, reason: not valid java name */
    public static final Boolean m38handleSendMagicLinkClick$lambda10(View.LifecycleEvent lifecycleEvent) {
        return Boolean.valueOf(View.LifecycleEvent.CREATE == lifecycleEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleSendMagicLinkClick$lambda-17, reason: not valid java name */
    public static final rx.e m39handleSendMagicLinkClick$lambda17(final SendMagicLinkPresenter sendMagicLinkPresenter, View.LifecycleEvent lifecycleEvent) {
        kotlin.jvm.internal.m.f(sendMagicLinkPresenter, "this$0");
        return sendMagicLinkPresenter.view.getMagicLinkClick().G(new rx.m.e() { // from class: cm.aptoide.pt.account.view.magiclink.p
            @Override // rx.m.e
            public final Object call(Object obj) {
                return SendMagicLinkPresenter.m40handleSendMagicLinkClick$lambda17$lambda16(this.f3878f, (String) obj);
            }
        }).s0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleSendMagicLinkClick$lambda-17$lambda-16, reason: not valid java name */
    public static final rx.e m40handleSendMagicLinkClick$lambda17$lambda16(final SendMagicLinkPresenter sendMagicLinkPresenter, final String str) {
        kotlin.jvm.internal.m.f(sendMagicLinkPresenter, "this$0");
        kotlin.jvm.internal.m.e(str, "email");
        return sendMagicLinkPresenter.validateEmail(str).D(new rx.m.e() { // from class: cm.aptoide.pt.account.view.magiclink.y
            @Override // rx.m.e
            public final Object call(Object obj) {
                return SendMagicLinkPresenter.m41handleSendMagicLinkClick$lambda17$lambda16$lambda11((Boolean) obj);
            }
        }).j0(sendMagicLinkPresenter.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.account.view.magiclink.i
            @Override // rx.m.b
            public final void call(Object obj) {
                SendMagicLinkPresenter.m42handleSendMagicLinkClick$lambda17$lambda16$lambda12(this.f3871f, (Boolean) obj);
            }
        }).L(new rx.m.e() { // from class: cm.aptoide.pt.account.view.magiclink.r
            @Override // rx.m.e
            public final Object call(Object obj) {
                return SendMagicLinkPresenter.m43handleSendMagicLinkClick$lambda17$lambda16$lambda14(this.f3881f, str, (Boolean) obj);
            }
        }).j0(sendMagicLinkPresenter.viewScheduler).w(new rx.m.b() { // from class: cm.aptoide.pt.account.view.magiclink.k
            @Override // rx.m.b
            public final void call(Object obj) {
                SendMagicLinkPresenter.m45handleSendMagicLinkClick$lambda17$lambda16$lambda15(this.f3873f, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleSendMagicLinkClick$lambda-17$lambda-16$lambda-11, reason: not valid java name */
    public static final Boolean m41handleSendMagicLinkClick$lambda17$lambda16$lambda11(Boolean bool) {
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleSendMagicLinkClick$lambda-17$lambda-16$lambda-12, reason: not valid java name */
    public static final void m42handleSendMagicLinkClick$lambda17$lambda16$lambda12(SendMagicLinkPresenter sendMagicLinkPresenter, Boolean bool) {
        kotlin.jvm.internal.m.f(sendMagicLinkPresenter, "this$0");
        sendMagicLinkPresenter.view.setLoadingScreen();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleSendMagicLinkClick$lambda-17$lambda-16$lambda-14, reason: not valid java name */
    public static final Single m43handleSendMagicLinkClick$lambda17$lambda16$lambda14(final SendMagicLinkPresenter sendMagicLinkPresenter, final String str, Boolean bool) {
        kotlin.jvm.internal.m.f(sendMagicLinkPresenter, "this$0");
        return sendMagicLinkPresenter.accountManager.sendMagicLink(str).p(sendMagicLinkPresenter.viewScheduler).g(new rx.m.b() { // from class: cm.aptoide.pt.account.view.magiclink.q
            @Override // rx.m.b
            public final void call(Object obj) {
                SendMagicLinkPresenter.m44handleSendMagicLinkClick$lambda17$lambda16$lambda14$lambda13(this.f3879f, str, (CodeAuth) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleSendMagicLinkClick$lambda-17$lambda-16$lambda-14$lambda-13, reason: not valid java name */
    public static final void m44handleSendMagicLinkClick$lambda17$lambda16$lambda14$lambda13(SendMagicLinkPresenter sendMagicLinkPresenter, String str, CodeAuth codeAuth) {
        kotlin.jvm.internal.m.f(sendMagicLinkPresenter, "this$0");
        sendMagicLinkPresenter.agentPersistence.persistAgent(codeAuth.getAgent(), codeAuth.getState(), codeAuth.getEmail());
        sendMagicLinkPresenter.view.removeLoadingScreen();
        SendMagicLinkNavigator sendMagicLinkNavigator = sendMagicLinkPresenter.navigator;
        kotlin.jvm.internal.m.e(str, "email");
        sendMagicLinkNavigator.navigateToCheckYourEmail(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleSendMagicLinkClick$lambda-17$lambda-16$lambda-15, reason: not valid java name */
    public static final void m45handleSendMagicLinkClick$lambda17$lambda16$lambda15(SendMagicLinkPresenter sendMagicLinkPresenter, Throwable th) {
        kotlin.jvm.internal.m.f(sendMagicLinkPresenter, "this$0");
        sendMagicLinkPresenter.view.removeLoadingScreen();
        sendMagicLinkPresenter.view.showUnknownError();
        th.printStackTrace();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleSendMagicLinkClick$lambda-18, reason: not valid java name */
    public static final void m46handleSendMagicLinkClick$lambda18(CodeAuth codeAuth) {
    }

    private final rx.e<Boolean> validateEmail(String str) {
        rx.e<Boolean> eVarX = this.accountManager.isEmailValid(str).A().j0(this.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.account.view.magiclink.o
            @Override // rx.m.b
            public final void call(Object obj) {
                SendMagicLinkPresenter.m48validateEmail$lambda20(this.f3877f, (Boolean) obj);
            }
        });
        kotlin.jvm.internal.m.e(eVarX, "accountManager.isEmailVa…r()\n          }\n        }");
        return eVarX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: validateEmail$lambda-20, reason: not valid java name */
    public static final void m48validateEmail$lambda20(SendMagicLinkPresenter sendMagicLinkPresenter, Boolean bool) {
        kotlin.jvm.internal.m.f(sendMagicLinkPresenter, "this$0");
        if (bool.booleanValue()) {
            return;
        }
        sendMagicLinkPresenter.view.setEmailInvalidError();
    }

    @Override // cm.aptoide.pt.presenter.Presenter
    public void present() {
        handleSendMagicLinkClick();
        handleEmailChangeEvents();
        handleSecureLoginTextClick();
    }
}
