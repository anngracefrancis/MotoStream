package cm.aptoide.pt.view.recycler.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.navigator.ActivityNavigator;
import cm.aptoide.pt.navigator.ActivityResultNavigator;
import cm.aptoide.pt.navigator.FragmentNavigator;
import cm.aptoide.pt.view.recycler.displayable.Displayable;

/* JADX INFO: loaded from: classes.dex */
public abstract class Widget<T extends Displayable> extends RecyclerView.c0 {
    private ActivityNavigator activityNavigator;
    protected rx.t.b compositeSubscription;
    private final FragmentNavigator fragmentNavigator;

    public Widget(View view) {
        super(view);
        this.fragmentNavigator = ((ActivityResultNavigator) getContext()).getFragmentNavigator();
        this.activityNavigator = ((ActivityResultNavigator) getContext()).getActivityNavigator();
        try {
            assignViews(view);
        } catch (Exception e2) {
            CrashReport.getInstance().log(e2);
        }
    }

    protected abstract void assignViews(View view);

    public abstract void bindView(T t, int i2);

    protected ActivityNavigator getActivityNavigator() {
        return this.activityNavigator;
    }

    public androidx.fragment.app.d getContext() {
        return (androidx.fragment.app.d) this.itemView.getContext();
    }

    protected FragmentNavigator getFragmentNavigator() {
        return this.fragmentNavigator;
    }

    public View getRootView() {
        return getFragmentNavigator().peekLast().getView();
    }

    public void internalBindView(T t, int i2) {
        if (this.compositeSubscription == null) {
            this.compositeSubscription = new rx.t.b();
        }
        t.setVisible(true);
        bindView(t, i2);
    }

    public void unbindView() {
        rx.t.b bVar = this.compositeSubscription;
        if (bVar == null || bVar.isUnsubscribed()) {
            return;
        }
        this.compositeSubscription.b();
    }
}
