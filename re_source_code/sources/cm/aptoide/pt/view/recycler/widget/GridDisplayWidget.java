package cm.aptoide.pt.view.recycler.widget;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import cm.aptoide.pt.R;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.dataprovider.model.v7.Event;
import cm.aptoide.pt.dataprovider.model.v7.store.GetStoreDisplays;
import cm.aptoide.pt.networking.image.ImageLoader;
import cm.aptoide.pt.store.view.GridDisplayDisplayable;
import cm.aptoide.pt.store.view.StoreTabFragmentChooser;
import cm.aptoide.pt.store.view.StoreTabGridRecyclerFragment;

/* JADX INFO: loaded from: classes.dex */
public class GridDisplayWidget extends Widget<GridDisplayDisplayable> {
    private ImageView imageView;

    /* JADX INFO: renamed from: cm.aptoide.pt.view.recycler.widget.GridDisplayWidget$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Event$Name;

        static {
            int[] iArr = new int[Event.Name.values().length];
            $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Event$Name = iArr;
            try {
                iArr[Event.Name.facebook.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Event$Name[Event.Name.twitch.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Event$Name[Event.Name.youtube.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public GridDisplayWidget(View view) {
        super(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$bindView$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a(GetStoreDisplays.EventImage eventImage, GridDisplayDisplayable gridDisplayDisplayable, Void r9) {
        Event event = eventImage.getEvent();
        Event.Name name = event.getName();
        if (StoreTabFragmentChooser.validateAcceptedName(name)) {
            getFragmentNavigator().navigateTo(StoreTabGridRecyclerFragment.newInstance(event, eventImage.getLabel(), gridDisplayDisplayable.getStoreTheme(), gridDisplayDisplayable.getTag(), gridDisplayDisplayable.getStoreContext(), false), true);
        } else {
            int i2 = AnonymousClass1.$SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Event$Name[name.ordinal()];
            sendActionEvent(event.getAction());
        }
    }

    private void sendActionEvent(String str) {
        if (str != null) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            this.itemView.getContext().startActivity(intent);
        }
    }

    @Override // cm.aptoide.pt.view.recycler.widget.Widget
    protected void assignViews(View view) {
        this.imageView = (ImageView) view.findViewById(R.id.image_category);
    }

    @Override // cm.aptoide.pt.view.recycler.widget.Widget
    public void bindView(final GridDisplayDisplayable gridDisplayDisplayable, int i2) {
        final GetStoreDisplays.EventImage pojo = gridDisplayDisplayable.getPojo();
        ImageLoader.with(getContext()).load(pojo.getGraphic(), this.imageView);
        this.compositeSubscription.a(e.g.a.c.a.a(this.imageView).H0(new rx.m.b() { // from class: cm.aptoide.pt.view.recycler.widget.d
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f8121f.a(pojo, gridDisplayDisplayable, (Void) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.view.recycler.widget.c
            @Override // rx.m.b
            public final void call(Object obj) {
                CrashReport.getInstance().log((Throwable) obj);
            }
        }));
    }
}
