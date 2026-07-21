package cm.aptoide.pt.notification.view;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import cm.aptoide.pt.AptoideApplication;
import cm.aptoide.pt.R;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.notification.AptoideNotification;
import cm.aptoide.pt.view.NotBottomNavigationView;
import cm.aptoide.pt.view.fragment.BaseToolbarFragment;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class InboxFragment extends BaseToolbarFragment implements InboxView, NotBottomNavigationView {
    private InboxAdapter adapter;
    private LinearLayout emptyState;
    private RecyclerView list;
    private rx.s.b<AptoideNotification> notificationSubject;

    @Override // cm.aptoide.pt.view.fragment.BaseToolbarFragment
    protected boolean displayHomeUpAsEnabled() {
        return true;
    }

    @Override // cm.aptoide.pt.view.fragment.UiComponent
    public int getContentViewId() {
        return R.layout.fragment_inbox;
    }

    @Override // cm.aptoide.pt.view.fragment.NavigationTrackFragment
    public ScreenTagHistory getHistoryTracker() {
        return ScreenTagHistory.Builder.build(getClass().getSimpleName());
    }

    @Override // cm.aptoide.pt.notification.view.InboxView
    public rx.e<AptoideNotification> notificationSelection() {
        return this.notificationSubject;
    }

    @Override // cm.aptoide.pt.view.fragment.UIComponentFragment, cm.aptoide.pt.view.fragment.NavigationTrackFragment, cm.aptoide.pt.view.fragment.FragmentView, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getFragmentComponent(bundle).inject(this);
        this.notificationSubject = rx.s.b.g1();
        this.adapter = new InboxAdapter(Collections.emptyList(), this.notificationSubject);
        setHasOptionsMenu(true);
    }

    @Override // cm.aptoide.pt.view.fragment.FragmentView, androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        getActivity().onBackPressed();
        return true;
    }

    @Override // cm.aptoide.pt.view.fragment.UIComponentFragment, cm.aptoide.pt.view.fragment.NavigationTrackFragment, cm.aptoide.pt.view.BaseFragment, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.fragment_inbox_list);
        this.list = recyclerView;
        recyclerView.setAdapter(this.adapter);
        this.list.setLayoutManager(new LinearLayoutManager(getContext()));
        this.emptyState = (LinearLayout) view.findViewById(R.id.empty_state);
        attachPresenter(new InboxPresenter(this, ((AptoideApplication) getContext().getApplicationContext()).getNotificationCenter(), CrashReport.getInstance(), ((AptoideApplication) getContext().getApplicationContext()).getNavigationTracker(), ((AptoideApplication) getContext().getApplicationContext()).getNotificationAnalytics(), rx.l.c.a.b()));
    }

    @Override // cm.aptoide.pt.view.fragment.BaseToolbarFragment
    protected void setupToolbarDetails(Toolbar toolbar) {
        super.setupToolbarDetails(toolbar);
        toolbar.setTitle(getString(R.string.myaccount_header_title));
    }

    @Override // cm.aptoide.pt.notification.view.InboxView
    public void showEmptyState() {
        this.emptyState.setVisibility(0);
    }

    @Override // cm.aptoide.pt.notification.view.InboxView
    public void showNotifications(List<AptoideNotification> list) {
        this.adapter.updateNotifications(list);
    }
}
