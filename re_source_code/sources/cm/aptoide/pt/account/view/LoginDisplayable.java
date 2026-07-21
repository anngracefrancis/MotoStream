package cm.aptoide.pt.account.view;

import cm.aptoide.pt.R;
import cm.aptoide.pt.view.recycler.displayable.Displayable;

/* JADX INFO: loaded from: classes.dex */
public class LoginDisplayable extends Displayable {
    @Override // cm.aptoide.pt.view.recycler.displayable.Displayable
    protected Displayable.Configs getConfig() {
        return new Displayable.Configs(1, true);
    }

    @Override // cm.aptoide.pt.view.recycler.displayable.Displayable
    public int getViewLayout() {
        return R.layout.login_store_displayable_layout;
    }
}
