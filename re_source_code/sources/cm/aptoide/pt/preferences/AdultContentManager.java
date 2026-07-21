package cm.aptoide.pt.preferences;

import cm.aptoide.accountmanager.AccountService;
import cm.aptoide.accountmanager.AdultContent;

/* JADX INFO: loaded from: classes.dex */
public class AdultContentManager implements AdultContent {
    private final AccountService accountService;
    private final LocalPersistenceAdultContent localContent;

    public AdultContentManager(LocalPersistenceAdultContent localPersistenceAdultContent, AccountService accountService) {
        this.localContent = localPersistenceAdultContent;
        this.accountService = accountService;
    }

    @Override // cm.aptoide.accountmanager.AdultContent
    public rx.b disable(boolean z) {
        return z ? this.accountService.updateAccount(false).a(this.localContent.disable()) : this.localContent.disable();
    }

    @Override // cm.aptoide.accountmanager.AdultContent
    public rx.b enable(boolean z) {
        return z ? this.accountService.updateAccount(true).a(this.localContent.enable()) : this.localContent.enable();
    }

    @Override // cm.aptoide.accountmanager.AdultContent
    public rx.e<Boolean> enabled() {
        return this.localContent.enabled();
    }

    @Override // cm.aptoide.accountmanager.AdultContent
    public rx.e<Boolean> pinRequired() {
        return this.localContent.pinRequired();
    }

    @Override // cm.aptoide.accountmanager.AdultContent
    public rx.b removePin(int i2) {
        return this.localContent.removePin(i2);
    }

    @Override // cm.aptoide.accountmanager.AdultContent
    public rx.b requirePin(int i2) {
        return this.localContent.requirePin(i2);
    }

    @Override // cm.aptoide.accountmanager.AdultContent
    public rx.b enable(int i2) {
        return this.localContent.enable(i2);
    }
}
