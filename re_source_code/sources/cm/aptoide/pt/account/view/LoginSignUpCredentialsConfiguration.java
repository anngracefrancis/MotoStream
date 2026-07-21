package cm.aptoide.pt.account.view;

import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: LoginSignUpCredentialsConfiguration.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcm/aptoide/pt/account/view/LoginSignUpCredentialsConfiguration;", HttpUrl.FRAGMENT_ENCODE_SET, "dismissToNavigateToMainView", HttpUrl.FRAGMENT_ENCODE_SET, "cleanBackStack", "hasMagicLinkError", "magicLinkErrorMessage", HttpUrl.FRAGMENT_ENCODE_SET, "(ZZZLjava/lang/String;)V", "getCleanBackStack", "()Z", "getDismissToNavigateToMainView", "getHasMagicLinkError", "getMagicLinkErrorMessage", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", HttpUrl.FRAGMENT_ENCODE_SET, "toString", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final /* data */ class LoginSignUpCredentialsConfiguration {
    private final boolean cleanBackStack;
    private final boolean dismissToNavigateToMainView;
    private final boolean hasMagicLinkError;
    private final String magicLinkErrorMessage;

    public LoginSignUpCredentialsConfiguration(boolean z, boolean z2, boolean z3, String str) {
        kotlin.jvm.internal.m.f(str, "magicLinkErrorMessage");
        this.dismissToNavigateToMainView = z;
        this.cleanBackStack = z2;
        this.hasMagicLinkError = z3;
        this.magicLinkErrorMessage = str;
    }

    public static /* synthetic */ LoginSignUpCredentialsConfiguration copy$default(LoginSignUpCredentialsConfiguration loginSignUpCredentialsConfiguration, boolean z, boolean z2, boolean z3, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = loginSignUpCredentialsConfiguration.dismissToNavigateToMainView;
        }
        if ((i2 & 2) != 0) {
            z2 = loginSignUpCredentialsConfiguration.cleanBackStack;
        }
        if ((i2 & 4) != 0) {
            z3 = loginSignUpCredentialsConfiguration.hasMagicLinkError;
        }
        if ((i2 & 8) != 0) {
            str = loginSignUpCredentialsConfiguration.magicLinkErrorMessage;
        }
        return loginSignUpCredentialsConfiguration.copy(z, z2, z3, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getDismissToNavigateToMainView() {
        return this.dismissToNavigateToMainView;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getCleanBackStack() {
        return this.cleanBackStack;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getHasMagicLinkError() {
        return this.hasMagicLinkError;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getMagicLinkErrorMessage() {
        return this.magicLinkErrorMessage;
    }

    public final LoginSignUpCredentialsConfiguration copy(boolean dismissToNavigateToMainView, boolean cleanBackStack, boolean hasMagicLinkError, String magicLinkErrorMessage) {
        kotlin.jvm.internal.m.f(magicLinkErrorMessage, "magicLinkErrorMessage");
        return new LoginSignUpCredentialsConfiguration(dismissToNavigateToMainView, cleanBackStack, hasMagicLinkError, magicLinkErrorMessage);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LoginSignUpCredentialsConfiguration)) {
            return false;
        }
        LoginSignUpCredentialsConfiguration loginSignUpCredentialsConfiguration = (LoginSignUpCredentialsConfiguration) other;
        return this.dismissToNavigateToMainView == loginSignUpCredentialsConfiguration.dismissToNavigateToMainView && this.cleanBackStack == loginSignUpCredentialsConfiguration.cleanBackStack && this.hasMagicLinkError == loginSignUpCredentialsConfiguration.hasMagicLinkError && kotlin.jvm.internal.m.a(this.magicLinkErrorMessage, loginSignUpCredentialsConfiguration.magicLinkErrorMessage);
    }

    public final boolean getCleanBackStack() {
        return this.cleanBackStack;
    }

    public final boolean getDismissToNavigateToMainView() {
        return this.dismissToNavigateToMainView;
    }

    public final boolean getHasMagicLinkError() {
        return this.hasMagicLinkError;
    }

    public final String getMagicLinkErrorMessage() {
        return this.magicLinkErrorMessage;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        boolean z = this.dismissToNavigateToMainView;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i2 = r0 * 31;
        boolean z2 = this.cleanBackStack;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i3 = (i2 + r2) * 31;
        boolean z3 = this.hasMagicLinkError;
        return ((i3 + (z3 ? 1 : z3)) * 31) + this.magicLinkErrorMessage.hashCode();
    }

    public String toString() {
        return "LoginSignUpCredentialsConfiguration(dismissToNavigateToMainView=" + this.dismissToNavigateToMainView + ", cleanBackStack=" + this.cleanBackStack + ", hasMagicLinkError=" + this.hasMagicLinkError + ", magicLinkErrorMessage=" + this.magicLinkErrorMessage + ')';
    }
}
