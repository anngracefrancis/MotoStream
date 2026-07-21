package cm.aptoide.pt.view.recycler;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import rx.k;

/* JADX INFO: loaded from: classes.dex */
public abstract class RecyclerViewHolder<T> extends RecyclerView.c0 {
    private rx.t.b compositeSubscription;
    private Context context;
    private T viewModel;

    protected RecyclerViewHolder(View view) {
        super(view);
        this.compositeSubscription = new rx.t.b();
        this.context = view.getContext();
    }

    protected void addSubscription(k kVar) {
        this.compositeSubscription.a(kVar);
    }

    protected T getViewModel() {
        return this.viewModel;
    }

    public abstract int getViewResource();

    public final void releaseSubscriptions() {
        if (!this.compositeSubscription.c() || this.compositeSubscription.isUnsubscribed()) {
            return;
        }
        this.compositeSubscription.unsubscribe();
    }

    protected abstract void update(Context context, T t);

    public final void updateViewModel(T t) {
        this.viewModel = t;
        update(this.context, t);
    }
}
