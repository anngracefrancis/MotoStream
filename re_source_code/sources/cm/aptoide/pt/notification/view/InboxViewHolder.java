package cm.aptoide.pt.notification.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cm.aptoide.pt.R;
import cm.aptoide.pt.networking.image.ImageLoader;
import cm.aptoide.pt.notification.AptoideNotification;

/* JADX INFO: loaded from: classes.dex */
class InboxViewHolder extends RecyclerView.c0 {
    private TextView body;
    private rx.s.b<AptoideNotification> notificationSubject;
    private final TextView title;
    private ImageView userAvatar;

    protected InboxViewHolder(View view, rx.s.b<AptoideNotification> bVar) {
        super(view);
        this.notificationSubject = bVar;
        this.title = (TextView) view.findViewById(R.id.fragment_inbox_list_title);
        this.body = (TextView) view.findViewById(R.id.fragment_inbox_list_body);
        this.userAvatar = (ImageView) view.findViewById(R.id.fragment_inbox_list_item_image);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setNotification$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a(AptoideNotification aptoideNotification, View view) {
        this.notificationSubject.onNext(aptoideNotification);
    }

    public void setNotification(final AptoideNotification aptoideNotification) {
        this.title.setText(aptoideNotification.getTitle());
        this.body.setText(aptoideNotification.getBody());
        ImageLoader.with(this.itemView.getContext()).loadWithShadowCircleTransform(aptoideNotification.getImg(), this.userAvatar);
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.pt.notification.view.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f6809f.a(aptoideNotification, view);
            }
        });
    }
}
