package cm.aptoide.pt.presenter;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class CompositePresenter implements Presenter {
    private final List<Presenter> presenters;

    public CompositePresenter(List<Presenter> list) {
        this.presenters = list;
    }

    @Override // cm.aptoide.pt.presenter.Presenter
    public void present() {
        Iterator<Presenter> it = this.presenters.iterator();
        while (it.hasNext()) {
            it.next().present();
        }
    }
}
