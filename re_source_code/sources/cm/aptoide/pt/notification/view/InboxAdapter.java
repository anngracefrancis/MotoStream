package cm.aptoide.pt.notification.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cm.aptoide.pt.R;
import cm.aptoide.pt.notification.AptoideNotification;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class InboxAdapter extends RecyclerView.g<InboxViewHolder> {
    private rx.s.b<AptoideNotification> notificationSubject;
    private List<AptoideNotification> notifications;

    public InboxAdapter(List<AptoideNotification> list, rx.s.b<AptoideNotification> bVar) {
        this.notifications = list;
        this.notificationSubject = bVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return this.notifications.size();
    }

    public void updateNotifications(List<AptoideNotification> list) {
        this.notifications = list;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void onBindViewHolder(InboxViewHolder inboxViewHolder, int i2) {
        inboxViewHolder.setNotification(this.notifications.get(i2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public InboxViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new InboxViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_inbox_list_item, viewGroup, false), this.notificationSubject);
    }
}
