package cm.aptoide.pt.comments.view;

import android.view.View;
import android.widget.TextView;
import cm.aptoide.pt.AptoideApplication;
import cm.aptoide.pt.R;
import cm.aptoide.pt.dataprovider.WebService;
import cm.aptoide.pt.dataprovider.model.v7.ListComments;
import cm.aptoide.pt.dataprovider.ws.v7.ListCommentsRequest;
import cm.aptoide.pt.view.recycler.widget.Widget;

/* JADX INFO: loaded from: classes.dex */
public class CommentsReadMoreWidget extends Widget<CommentsReadMoreDisplayable> {
    private TextView readMoreButton;

    public CommentsReadMoreWidget(View view) {
        super(view);
    }

    static /* synthetic */ rx.e lambda$bindView$0(rx.e eVar, Void r1) {
        return eVar;
    }

    @Override // cm.aptoide.pt.view.recycler.widget.Widget
    protected void assignViews(View view) {
        this.readMoreButton = (TextView) view.findViewById(R.id.read_more_button);
    }

    @Override // cm.aptoide.pt.view.recycler.widget.Widget
    public void bindView(final CommentsReadMoreDisplayable commentsReadMoreDisplayable, int i2) {
        final rx.e<ListComments> eVarObserve = ListCommentsRequest.of(commentsReadMoreDisplayable.getResourceId(), commentsReadMoreDisplayable.getNext(), 100, commentsReadMoreDisplayable.isReview(), ((AptoideApplication) getContext().getApplicationContext()).getAccountSettingsBodyInterceptorPoolV7(), ((AptoideApplication) getContext().getApplicationContext()).getDefaultClient(), WebService.getDefaultConverter(), ((AptoideApplication) getContext().getApplicationContext()).getTokenInvalidator(), ((AptoideApplication) getContext().getApplicationContext()).getDefaultSharedPreferences()).observe();
        this.compositeSubscription.a(e.g.a.c.a.a(this.readMoreButton).G(new rx.m.e() { // from class: cm.aptoide.pt.comments.view.c0
            @Override // rx.m.e
            public final Object call(Object obj) {
                rx.e eVar = eVarObserve;
                CommentsReadMoreWidget.lambda$bindView$0(eVar, (Void) obj);
                return eVar;
            }
        }).G0(new rx.m.b() { // from class: cm.aptoide.pt.comments.view.d0
            @Override // rx.m.b
            public final void call(Object obj) {
                commentsReadMoreDisplayable.getCommentAdder().addComment(((ListComments) obj).getDataList().getList());
            }
        }));
    }
}
