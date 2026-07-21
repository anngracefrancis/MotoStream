package cm.aptoide.pt.view.fragment;

import android.view.View;
import androidx.appcompat.widget.Toolbar;
import cm.aptoide.pt.R;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseLoaderToolbarFragment extends BaseLoaderFragment {
    private Toolbar toolbar;

    @Override // cm.aptoide.pt.view.fragment.BaseLoaderFragment, cm.aptoide.pt.view.fragment.UiComponent
    public void bindViews(View view) {
        super.bindViews(view);
        this.toolbar = (Toolbar) view.findViewById(R.id.toolbar);
    }

    protected boolean displayHomeUpAsEnabled() {
        return false;
    }

    protected Toolbar getToolbar() {
        return this.toolbar;
    }

    protected boolean hasToolbar() {
        return this.toolbar != null;
    }

    @Override // cm.aptoide.pt.view.fragment.BaseLoaderFragment, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.toolbar = null;
        super.onDestroyView();
    }

    @Override // cm.aptoide.pt.view.fragment.UIComponentFragment, cm.aptoide.pt.view.fragment.UiComponent
    public void setupToolbar() {
        if (hasToolbar()) {
            ((androidx.appcompat.app.d) getActivity()).setSupportActionBar(this.toolbar);
            boolean zDisplayHomeUpAsEnabled = displayHomeUpAsEnabled();
            androidx.appcompat.app.a supportActionBar = ((androidx.appcompat.app.d) getActivity()).getSupportActionBar();
            supportActionBar.r(zDisplayHomeUpAsEnabled);
            supportActionBar.v(this.toolbar.getTitle());
            setupToolbarDetails(this.toolbar);
        }
    }

    protected void setupToolbarDetails(Toolbar toolbar) {
    }

    @Override // cm.aptoide.pt.view.fragment.UIComponentFragment, cm.aptoide.pt.view.fragment.UiComponent
    public void setupViews() {
        setupToolbar();
    }
}
