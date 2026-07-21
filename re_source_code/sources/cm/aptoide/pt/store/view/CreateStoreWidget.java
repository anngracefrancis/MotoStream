package cm.aptoide.pt.store.view;

import android.text.ParcelableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import cm.aptoide.pt.R;
import cm.aptoide.pt.account.view.store.ManageStoreFragment;
import cm.aptoide.pt.account.view.store.ManageStoreViewModel;
import cm.aptoide.pt.account.view.user.CreateStoreDisplayable;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.view.recycler.widget.Widget;
import cm.aptoide.pt.view.spannable.SpannableFactory;

/* JADX INFO: loaded from: classes.dex */
public class CreateStoreWidget extends Widget<CreateStoreDisplayable> {
    private Button button;
    private final CrashReport crashReport;
    private TextView followers;
    private TextView following;

    public CreateStoreWidget(View view) {
        super(view);
        this.crashReport = CrashReport.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$bindView$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a(Void r3) {
        getFragmentNavigator().navigateTo(ManageStoreFragment.newInstance(new ManageStoreViewModel(), false), true);
    }

    static /* synthetic */ void lambda$bindView$2(Void r0) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$bindView$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(Throwable th) {
        this.crashReport.log(th);
    }

    @Override // cm.aptoide.pt.view.recycler.widget.Widget
    protected void assignViews(View view) {
        this.button = (Button) view.findViewById(R.id.create_store_action);
        this.followers = (TextView) view.findViewById(R.id.followers);
        this.following = (TextView) view.findViewById(R.id.following);
    }

    @Override // cm.aptoide.pt.view.recycler.widget.Widget
    public void bindView(final CreateStoreDisplayable createStoreDisplayable, int i2) {
        SpannableFactory spannableFactory = new SpannableFactory();
        String str = String.format(getContext().getString(R.string.storetab_short_followers), String.valueOf(createStoreDisplayable.getFollowers()));
        ParcelableSpan[] parcelableSpanArr = {new StyleSpan(1), new ForegroundColorSpan(createStoreDisplayable.getTextAccentColor())};
        this.followers.setText(spannableFactory.createMultiSpan(str, parcelableSpanArr, String.valueOf(createStoreDisplayable.getFollowers())));
        this.following.setText(spannableFactory.createMultiSpan(String.format(getContext().getString(R.string.storetab_short_followings), String.valueOf(createStoreDisplayable.getFollowings())), parcelableSpanArr, String.valueOf(createStoreDisplayable.getFollowings())));
        this.compositeSubscription.a(e.g.a.c.a.a(this.button).j0(rx.l.c.a.b()).x(new rx.m.b() { // from class: cm.aptoide.pt.store.view.z
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7773f.a((Void) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.store.view.y
            @Override // rx.m.b
            public final void call(Object obj) {
                createStoreDisplayable.getStoreAnalytics().sendStoreTabInteractEvent("Login", false);
            }
        }).H0(new rx.m.b() { // from class: cm.aptoide.pt.store.view.a0
            @Override // rx.m.b
            public final void call(Object obj) {
                CreateStoreWidget.lambda$bindView$2((Void) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.store.view.x
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7764f.b((Throwable) obj);
            }
        }));
    }
}
