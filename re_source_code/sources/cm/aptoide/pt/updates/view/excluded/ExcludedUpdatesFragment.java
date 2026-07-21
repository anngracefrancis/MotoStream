package cm.aptoide.pt.updates.view.excluded;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import cm.aptoide.pt.R;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.database.room.RoomUpdate;
import cm.aptoide.pt.logger.Logger;
import cm.aptoide.pt.updates.UpdatePersistence;
import cm.aptoide.pt.utils.design.ShowMessage;
import cm.aptoide.pt.view.NotBottomNavigationView;
import cm.aptoide.pt.view.fragment.AptoideBaseFragment;
import cm.aptoide.pt.view.recycler.BaseAdapter;
import cm.aptoide.pt.view.recycler.displayable.Displayable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes.dex */
public class ExcludedUpdatesFragment extends AptoideBaseFragment<BaseAdapter> implements NotBottomNavigationView {
    private static final String TAG = ExcludedUpdatesFragment.class.getSimpleName();
    private TextView emptyData;

    @Inject
    UpdatePersistence updatesPersistence;

    private void fetchExcludedUpdates() {
        this.updatesPersistence.getAllSorted(true).j0(rx.l.c.a.b()).x(new rx.m.b() { // from class: cm.aptoide.pt.updates.view.excluded.g
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7830f.e((List) obj);
            }
        }).f(bindUntilEvent(com.trello.rxlifecycle.g.b.DESTROY_VIEW)).H0(new rx.m.b() { // from class: cm.aptoide.pt.updates.view.excluded.f
            @Override // rx.m.b
            public final void call(Object obj) {
                ExcludedUpdatesFragment.lambda$fetchExcludedUpdates$1((List) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.updates.view.excluded.d
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7827f.f((Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$fetchExcludedUpdates$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e(List list) {
        if (list == null || list.isEmpty()) {
            this.emptyData.setText(R.string.no_excluded_updates_msg);
            this.emptyData.setVisibility(0);
            clearDisplayables();
            finishLoading();
            return;
        }
        this.emptyData.setVisibility(8);
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new ExcludedUpdateDisplayable((RoomUpdate) it.next()));
        }
        clearDisplayables().addDisplayables((List<? extends Displayable>) arrayList, true);
    }

    static /* synthetic */ void lambda$fetchExcludedUpdates$1(List list) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$fetchExcludedUpdates$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(Throwable th) {
        CrashReport.getInstance().log(th);
        this.emptyData.setText(R.string.no_excluded_updates_msg);
        this.emptyData.setVisibility(0);
        clearDisplayables();
        finishLoading();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$onOptionsItemSelected$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b g(List list) {
        return this.updatesPersistence.saveAll(list);
    }

    static /* synthetic */ void lambda$onOptionsItemSelected$5(List list) {
    }

    public static ExcludedUpdatesFragment newInstance() {
        return new ExcludedUpdatesFragment();
    }

    @Override // cm.aptoide.pt.view.fragment.BaseRecyclerViewFragment, cm.aptoide.pt.view.fragment.BaseLoaderToolbarFragment, cm.aptoide.pt.view.fragment.BaseLoaderFragment, cm.aptoide.pt.view.fragment.UiComponent
    public void bindViews(View view) {
        super.bindViews(view);
        this.emptyData = (TextView) view.findViewById(R.id.empty_data);
    }

    @Override // cm.aptoide.pt.view.fragment.BaseLoaderToolbarFragment
    protected boolean displayHomeUpAsEnabled() {
        return true;
    }

    @Override // cm.aptoide.pt.view.fragment.BaseRecyclerViewFragment, cm.aptoide.pt.view.fragment.UiComponent
    public int getContentViewId() {
        return R.layout.fragment_with_toolbar_no_theme;
    }

    @Override // cm.aptoide.pt.view.fragment.NavigationTrackFragment
    public ScreenTagHistory getHistoryTracker() {
        return ScreenTagHistory.Builder.build(getClass().getSimpleName());
    }

    @Override // cm.aptoide.pt.view.fragment.BaseRecyclerViewFragment, cm.aptoide.pt.view.fragment.BaseLoaderFragment, cm.aptoide.pt.view.LoadInterface
    public void load(boolean z, boolean z2, Bundle bundle) {
        super.load(z, z2, bundle);
        Logger logger = Logger.getInstance();
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("refresh excluded updates? ");
        sb.append(z ? "yes" : "no");
        logger.d(str, sb.toString());
        fetchExcludedUpdates();
    }

    @Override // cm.aptoide.pt.view.fragment.AptoideBaseFragment, cm.aptoide.pt.view.fragment.UIComponentFragment, cm.aptoide.pt.view.fragment.NavigationTrackFragment, cm.aptoide.pt.view.fragment.FragmentView, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getFragmentComponent(bundle).inject(this);
        setHasOptionsMenu(true);
    }

    @Override // cm.aptoide.pt.view.fragment.FragmentView, androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(R.menu.menu_excluded_updates_fragment, menu);
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [cm.aptoide.pt.view.recycler.BaseAdapter] */
    /* JADX WARN: Type inference failed for: r6v2, types: [androidx.recyclerview.widget.RecyclerView$g, cm.aptoide.pt.view.recycler.BaseAdapter] */
    /* JADX WARN: Type inference failed for: r6v3, types: [androidx.recyclerview.widget.RecyclerView$g, cm.aptoide.pt.view.recycler.BaseAdapter] */
    @Override // cm.aptoide.pt.view.fragment.FragmentView, androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            getActivity().onBackPressed();
            return true;
        }
        int i2 = 0;
        if (itemId == R.id.menu_restore_updates) {
            LinkedList linkedList = new LinkedList();
            ?? adapter = getAdapter();
            while (i2 < adapter.getItemCount()) {
                ExcludedUpdateDisplayable excludedUpdateDisplayable = (ExcludedUpdateDisplayable) adapter.getDisplayable(i2);
                if (excludedUpdateDisplayable.isSelected()) {
                    linkedList.add(excludedUpdateDisplayable.getPojo());
                }
                i2++;
            }
            if (linkedList.size() == 0) {
                ShowMessage.asSnack(this.emptyData, R.string.no_excluded_updates_selected);
                return true;
            }
            rx.e.N(linkedList).x(new rx.m.b() { // from class: cm.aptoide.pt.updates.view.excluded.c
                @Override // rx.m.b
                public final void call(Object obj) {
                    ((RoomUpdate) obj).setExcluded(false);
                }
            }).Y0().H(new rx.m.e() { // from class: cm.aptoide.pt.updates.view.excluded.h
                @Override // rx.m.e
                public final Object call(Object obj) {
                    return this.f7831f.g((List) obj);
                }
            }).H0(new rx.m.b() { // from class: cm.aptoide.pt.updates.view.excluded.b
                @Override // rx.m.b
                public final void call(Object obj) {
                    ExcludedUpdatesFragment.lambda$onOptionsItemSelected$5((List) obj);
                }
            }, new rx.m.b() { // from class: cm.aptoide.pt.updates.view.excluded.e
                @Override // rx.m.b
                public final void call(Object obj) {
                    CrashReport.getInstance().log((Throwable) obj);
                }
            });
            return true;
        }
        if (itemId == R.id.menu_select_all) {
            ?? adapter2 = getAdapter();
            while (i2 < adapter2.getItemCount()) {
                ((ExcludedUpdateDisplayable) adapter2.getDisplayable(i2)).setSelected(true);
                adapter2.notifyDataSetChanged();
                i2++;
            }
            return true;
        }
        if (itemId != R.id.menu_select_none) {
            return super.onOptionsItemSelected(menuItem);
        }
        ?? adapter3 = getAdapter();
        for (int i3 = 0; i3 < adapter3.getItemCount(); i3++) {
            ((ExcludedUpdateDisplayable) adapter3.getDisplayable(i3)).setSelected(false);
            adapter3.notifyDataSetChanged();
        }
        return true;
    }

    @Override // cm.aptoide.pt.view.fragment.BaseLoaderToolbarFragment
    public void setupToolbarDetails(Toolbar toolbar) {
        toolbar.setTitle(R.string.excluded_updates);
    }
}
