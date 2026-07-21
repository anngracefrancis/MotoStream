package cm.aptoide.pt.view.recycler.displayable;

import cm.aptoide.pt.R;

/* JADX INFO: loaded from: classes.dex */
public class MessageWhiteBgDisplayable extends Displayable {
    private String message;

    public MessageWhiteBgDisplayable() {
    }

    @Override // cm.aptoide.pt.view.recycler.displayable.Displayable
    protected Displayable.Configs getConfig() {
        return new Displayable.Configs(1, true);
    }

    public String getMessage() {
        return this.message;
    }

    @Override // cm.aptoide.pt.view.recycler.displayable.Displayable
    public int getViewLayout() {
        return R.layout.white_message_displayable;
    }

    public MessageWhiteBgDisplayable(String str) {
        this.message = str;
    }
}
