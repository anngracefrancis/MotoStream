package cm.aptoide.pt.store.view;

import android.view.View;
import cm.aptoide.pt.R;
import cm.aptoide.pt.account.AccountAnalytics;
import cm.aptoide.pt.account.view.AccountNavigator;
import cm.aptoide.pt.account.view.LoginDisplayable;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.navigator.ActivityResultNavigator;
import cm.aptoide.pt.view.recycler.widget.Widget;

/* JADX INFO: loaded from: classes.dex */
public class LoginWidget extends Widget<LoginDisplayable> {
    private View loginButton;

    public LoginWidget(View view) {
        super(view);
    }

    @Override // cm.aptoide.pt.view.recycler.widget.Widget
    protected void assignViews(View view) {
        this.loginButton = view.findViewById(R.id.login_button);
    }

    @Override // cm.aptoide.pt.view.recycler.widget.Widget
    public void bindView(LoginDisplayable loginDisplayable, int i2) {
        final AccountNavigator accountNavigator = ((ActivityResultNavigator) getContext()).getAccountNavigator();
        this.compositeSubscription.a(e.g.a.c.a.a(this.loginButton).H0(new rx.m.b() { // from class: cm.aptoide.pt.store.view.a1
            @Override // rx.m.b
            public final void call(Object obj) {
                accountNavigator.navigateToAccountView(AccountAnalytics.AccountOrigins.STORE);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.store.view.z0
            @Override // rx.m.b
            public final void call(Object obj) {
                CrashReport.getInstance().log((Throwable) obj);
            }
        }));
    }
}
