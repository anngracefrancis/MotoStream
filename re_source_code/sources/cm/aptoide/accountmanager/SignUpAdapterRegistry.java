package cm.aptoide.accountmanager;

import java.util.Map;
import rx.Single;

/* JADX INFO: loaded from: classes.dex */
public class SignUpAdapterRegistry {
    private final AccountService accountService;
    private final Map<String, SignUpAdapter> adapters;

    public SignUpAdapterRegistry(Map<String, SignUpAdapter> map, AccountService accountService) {
        this.adapters = map;
        this.accountService = accountService;
    }

    static /* synthetic */ rx.b lambda$logoutAll$2(rx.b bVar) {
        return bVar;
    }

    public boolean isEnabled(String str) {
        return this.adapters.get(str).isEnabled();
    }

    public rx.b logoutAll() {
        return rx.e.N(this.adapters.values()).D(new rx.m.e() { // from class: cm.aptoide.accountmanager.z
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((SignUpAdapter) obj).isEnabled());
            }
        }).X(new rx.m.e() { // from class: cm.aptoide.accountmanager.y
            @Override // rx.m.e
            public final Object call(Object obj) {
                return ((SignUpAdapter) obj).logout();
            }
        }).H(new rx.m.e() { // from class: cm.aptoide.accountmanager.x
            @Override // rx.m.e
            public final Object call(Object obj) {
                rx.b bVar = (rx.b) obj;
                SignUpAdapterRegistry.lambda$logoutAll$2(bVar);
                return bVar;
            }
        }).X0();
    }

    public void register(String str, SignUpAdapter signUpAdapter) {
        this.adapters.put(str, signUpAdapter);
    }

    public <T> Single<Account> signUp(String str, T t) {
        return this.adapters.get(str).signUp(t, this.accountService);
    }
}
