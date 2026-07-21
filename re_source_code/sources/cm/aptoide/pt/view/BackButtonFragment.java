package cm.aptoide.pt.view;

import android.content.Context;
import cm.aptoide.pt.view.fragment.NavigationTrackFragment;

/* JADX INFO: loaded from: classes.dex */
public abstract class BackButtonFragment extends NavigationTrackFragment implements BackButton {
    private BackButton backButton;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BackButton) {
            this.backButton = (BackButton) context;
            return;
        }
        throw new IllegalStateException("Context must implement " + BackButton.class.getSimpleName());
    }

    @Override // cm.aptoide.pt.view.BackButton
    public void registerClickHandler(BackButton.ClickHandler clickHandler) {
        this.backButton.registerClickHandler(clickHandler);
    }

    @Override // cm.aptoide.pt.view.BackButton
    public void unregisterClickHandler(BackButton.ClickHandler clickHandler) {
        this.backButton.unregisterClickHandler(clickHandler);
    }
}
