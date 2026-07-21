package cm.aptoide.pt.store.view;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import cm.aptoide.pt.AptoideApplication;
import cm.aptoide.pt.R;
import cm.aptoide.pt.dataprovider.model.v7.Event;
import cm.aptoide.pt.dataprovider.model.v7.GetStoreWidgets;
import cm.aptoide.pt.dataprovider.util.CommentType;
import cm.aptoide.pt.dataprovider.ws.v7.V7;
import cm.aptoide.pt.dataprovider.ws.v7.store.StoreContext;
import cm.aptoide.pt.view.Translator;
import cm.aptoide.pt.view.recycler.widget.Widget;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes.dex */
public class StoreGridHeaderWidget extends Widget<StoreGridHeaderDisplayable> {
    private Button more;
    private TextView title;

    public StoreGridHeaderWidget(View view) {
        super(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$bindView$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a(GetStoreWidgets.WSWidget wSWidget, StoreGridHeaderDisplayable.Model model, SharedPreferences sharedPreferences, StoreGridHeaderDisplayable storeGridHeaderDisplayable, Void r12) {
        Event event = wSWidget.getActions().get(0).getEvent();
        String storeTheme = model.getStoreTheme();
        String tag = model.getTag();
        StoreContext storeContext = model.getStoreContext();
        String title = wSWidget.getTitle();
        if (event.getName() != Event.Name.listComments) {
            storeGridHeaderDisplayable.getStoreTabNavigator().navigateToStoreTabGridRecyclerView(event, title, storeTheme, tag, storeContext, true);
        } else {
            String action = event.getAction();
            storeGridHeaderDisplayable.getStoreTabNavigator().navigateToCommentGridRecyclerView(CommentType.STORE, action != null ? replaceActionUrl(action, sharedPreferences) : null, "View Comments", storeContext);
        }
    }

    private String replaceActionUrl(String str, SharedPreferences sharedPreferences) {
        return V7.isUrlBaseCache(str) ? str.replace(V7.getCacheHost(sharedPreferences), HttpUrl.FRAGMENT_ENCODE_SET) : str.replace(V7.getHost(sharedPreferences), HttpUrl.FRAGMENT_ENCODE_SET);
    }

    @Override // cm.aptoide.pt.view.recycler.widget.Widget
    protected void assignViews(View view) {
        this.title = (TextView) view.findViewById(R.id.title);
        this.more = (Button) view.findViewById(R.id.more);
    }

    @Override // cm.aptoide.pt.view.recycler.widget.Widget
    public void bindView(final StoreGridHeaderDisplayable storeGridHeaderDisplayable, int i2) {
        final GetStoreWidgets.WSWidget wsWidget = storeGridHeaderDisplayable.getWsWidget();
        boolean zHasActions = wsWidget.hasActions();
        AptoideApplication aptoideApplication = (AptoideApplication) getContext().getApplicationContext();
        String marketName = storeGridHeaderDisplayable.getMarketName();
        final SharedPreferences defaultSharedPreferences = aptoideApplication.getDefaultSharedPreferences();
        this.title.setText(Translator.translate(wsWidget.getTitle(), getContext().getApplicationContext(), marketName));
        final StoreGridHeaderDisplayable.Model model = storeGridHeaderDisplayable.getModel();
        this.more.setTextColor(storeGridHeaderDisplayable.getTextColor());
        this.more.setVisibility((zHasActions && model.isMoreVisible()) ? 0 : 8);
        if (zHasActions) {
            this.compositeSubscription.a(e.g.a.c.a.a(this.more).G0(new rx.m.b() { // from class: cm.aptoide.pt.store.view.q1
                @Override // rx.m.b
                public final void call(Object obj) {
                    this.f7689f.a(wsWidget, model, defaultSharedPreferences, storeGridHeaderDisplayable, (Void) obj);
                }
            }));
        }
    }
}
