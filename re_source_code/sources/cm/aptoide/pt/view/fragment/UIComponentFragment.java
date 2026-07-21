package cm.aptoide.pt.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cm.aptoide.pt.permission.PermissionServiceFragment;

/* JADX INFO: loaded from: classes.dex */
public abstract class UIComponentFragment extends PermissionServiceFragment implements UiComponent {
    public void loadExtras(Bundle bundle) {
    }

    @Override // cm.aptoide.pt.view.fragment.NavigationTrackFragment, cm.aptoide.pt.view.fragment.FragmentView, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            loadExtras(getArguments());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        return layoutInflater.inflate(getContentViewId(), viewGroup, false);
    }

    @Override // cm.aptoide.pt.view.fragment.NavigationTrackFragment, cm.aptoide.pt.view.BaseFragment, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        bindViews(view);
        setupViews();
    }

    public void setupToolbar() {
    }

    public abstract void setupViews();
}
