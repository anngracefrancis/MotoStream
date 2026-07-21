package cm.aptoide.pt.view.fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import cm.aptoide.pt.R;
import cm.aptoide.pt.view.Translator;
import javax.inject.Inject;
import javax.inject.Named;

/* JADX INFO: loaded from: classes.dex */
public abstract class GridRecyclerSwipeWithToolbarFragment extends GridRecyclerSwipeFragment {
    public static final String TITLE_KEY = "TITLE_KEY";

    @Inject
    @Named
    String marketName;
    private String title;

    @Override // cm.aptoide.pt.view.fragment.BaseLoaderToolbarFragment
    protected boolean displayHomeUpAsEnabled() {
        return true;
    }

    @Override // cm.aptoide.pt.view.fragment.GridRecyclerSwipeFragment, cm.aptoide.pt.view.fragment.BaseRecyclerViewFragment, cm.aptoide.pt.view.fragment.UiComponent
    public int getContentViewId() {
        return R.layout.recycler_swipe_fragment_with_toolbar;
    }

    @Override // cm.aptoide.pt.view.fragment.BaseRecyclerViewFragment, cm.aptoide.pt.view.fragment.UIComponentFragment, cm.aptoide.pt.view.fragment.UiComponent
    public void loadExtras(Bundle bundle) {
        super.loadExtras(bundle);
        this.title = bundle.getString(TITLE_KEY);
    }

    @Override // cm.aptoide.pt.view.fragment.AptoideBaseFragment, cm.aptoide.pt.view.fragment.UIComponentFragment, cm.aptoide.pt.view.fragment.NavigationTrackFragment, cm.aptoide.pt.view.fragment.FragmentView, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getFragmentComponent(bundle).inject(this);
    }

    @Override // cm.aptoide.pt.view.fragment.FragmentView, androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(R.menu.menu_empty, menu);
    }

    @Override // cm.aptoide.pt.view.fragment.FragmentView, androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        getActivity().onBackPressed();
        return true;
    }

    @Override // cm.aptoide.pt.view.fragment.BaseRecyclerViewFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(TITLE_KEY, this.title);
    }

    @Override // cm.aptoide.pt.view.fragment.BaseLoaderToolbarFragment
    public void setupToolbarDetails(Toolbar toolbar) {
        toolbar.setTitle(Translator.translate(this.title, getContext().getApplicationContext(), this.marketName));
        toolbar.setLogo(R.drawable.logo_toolbar);
    }
}
