package cm.aptoide.pt;

import cm.aptoide.accountmanager.AptoideAccountManager;
import cm.aptoide.pt.networking.RefreshTokenInvalidator;

/* JADX INFO: loaded from: classes.dex */
public class InvalidRefreshTokenLogoutManager {
    private AptoideAccountManager aptoideAccountManager;
    private RefreshTokenInvalidator refreshTokenInvalidator;

    public InvalidRefreshTokenLogoutManager(AptoideAccountManager aptoideAccountManager, RefreshTokenInvalidator refreshTokenInvalidator) {
        this.aptoideAccountManager = aptoideAccountManager;
        this.refreshTokenInvalidator = refreshTokenInvalidator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$start$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b a(Void r1) {
        return this.aptoideAccountManager.logout();
    }

    public void start() {
        this.refreshTokenInvalidator.getLogoutSubject().H(new rx.m.e() { // from class: cm.aptoide.pt.k0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6615f.a((Void) obj);
            }
        }).D0();
    }
}
