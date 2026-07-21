package cm.aptoide.pt.account.view;

/* JADX INFO: loaded from: classes.dex */
public interface LoginBottomSheet {

    public enum State {
        EXPANDED,
        COLLAPSED
    }

    void collapse();

    void expand();

    rx.e<State> state();
}
