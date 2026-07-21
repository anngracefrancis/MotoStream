package cm.aptoide.pt.view.fragment;

import android.view.View;
import cm.aptoide.pt.R;
import cm.aptoide.pt.view.custom.AptoideViewPager;

/* JADX INFO: loaded from: classes.dex */
public abstract class BasePagerToolbarFragment extends BaseLoaderToolbarFragment {
    protected AptoideViewPager viewPager;

    @Override // cm.aptoide.pt.view.fragment.BaseLoaderToolbarFragment, cm.aptoide.pt.view.fragment.BaseLoaderFragment, cm.aptoide.pt.view.fragment.UiComponent
    public void bindViews(View view) {
        super.bindViews(view);
        this.viewPager = (AptoideViewPager) view.findViewById(R.id.pager);
    }

    protected abstract androidx.viewpager.widget.a createPagerAdapter();

    @Override // cm.aptoide.pt.view.fragment.BaseLoaderToolbarFragment, cm.aptoide.pt.view.fragment.BaseLoaderFragment, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.viewPager.clearOnPageChangeListeners();
        this.viewPager = null;
        super.onDestroyView();
    }

    protected void setupViewPager() {
        this.viewPager.setAdapter(createPagerAdapter());
    }
}
