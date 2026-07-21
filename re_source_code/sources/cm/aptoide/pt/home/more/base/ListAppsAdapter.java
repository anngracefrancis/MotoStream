package cm.aptoide.pt.home.more.base;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cm.aptoide.pt.DeepLinkIntentReceiver;
import cm.aptoide.pt.home.more.base.ListAppsViewHolder;
import cm.aptoide.pt.view.app.Application;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: ListAppsAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\r\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00010\u00042\b\u0012\u0004\u0012\u0002H\u00030\u0005B\u001f\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00028\u00010\u0007¢\u0006\u0002\u0010\nJ\u0014\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017J\u0012\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00100\u000fJ\b\u0010\u0019\u001a\u00020\tH\u0016J\u001d\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00028\u00012\u0006\u0010\u001c\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\u001dJ\u001d\u0010\u001e\u001a\u00028\u00012\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020\tH\u0016¢\u0006\u0002\u0010!J\u0014\u0010\"\u001a\u00020\u00152\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017R\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00028\u00000\fj\b\u0012\u0004\u0012\u00028\u0000`\rX\u0082\u000e¢\u0006\u0002\n\u0000RJ\u0010\u000e\u001a>\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00028\u0000 \u0011*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00100\u0010 \u0011*\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00028\u0000 \u0011*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00100\u0010\u0018\u00010\u000f0\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00028\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006$"}, d2 = {"Lcm/aptoide/pt/home/more/base/ListAppsAdapter;", "T", "Lcm/aptoide/pt/view/app/Application;", "V", "Lcm/aptoide/pt/home/more/base/ListAppsViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "viewHolderBuilder", "Lkotlin/Function2;", "Landroid/view/ViewGroup;", HttpUrl.FRAGMENT_ENCODE_SET, "(Lkotlin/jvm/functions/Function2;)V", "appList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "clickListener", "Lrx/subjects/PublishSubject;", "Lcm/aptoide/pt/home/more/base/ListAppsClickEvent;", "kotlin.jvm.PlatformType", "getViewHolderBuilder", "()Lkotlin/jvm/functions/Function2;", "addData", HttpUrl.FRAGMENT_ENCODE_SET, DeepLinkIntentReceiver.DeepLinksTargets.APPS, HttpUrl.FRAGMENT_ENCODE_SET, "getClickListener", "getItemCount", "onBindViewHolder", "holder", "position", "(Lcm/aptoide/pt/home/more/base/ListAppsViewHolder;I)V", "onCreateViewHolder", "parent", "viewType", "(Landroid/view/ViewGroup;I)Lcm/aptoide/pt/home/more/base/ListAppsViewHolder;", "setData", "objs", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ListAppsAdapter<T extends Application, V extends ListAppsViewHolder<? super T>> extends RecyclerView.g<V> {
    private ArrayList<T> appList;
    private rx.s.b<ListAppsClickEvent<T>> clickListener;
    private final Function2<ViewGroup, Integer, V> viewHolderBuilder;

    /* JADX WARN: Multi-variable type inference failed */
    public ListAppsAdapter(Function2<? super ViewGroup, ? super Integer, ? extends V> function2) {
        kotlin.jvm.internal.m.f(function2, "viewHolderBuilder");
        this.viewHolderBuilder = function2;
        this.clickListener = rx.s.b.g1();
        this.appList = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onCreateViewHolder$lambda-0, reason: not valid java name */
    public static final void m239onCreateViewHolder$lambda0(ListAppsAdapter listAppsAdapter, ListAppsViewHolder listAppsViewHolder, View view) {
        kotlin.jvm.internal.m.f(listAppsAdapter, "this$0");
        kotlin.jvm.internal.m.f(listAppsViewHolder, "$vh");
        rx.s.b<ListAppsClickEvent<T>> bVar = listAppsAdapter.clickListener;
        T t = listAppsAdapter.appList.get(listAppsViewHolder.getAdapterPosition());
        kotlin.jvm.internal.m.e(t, "appList[vh.adapterPosition]");
        bVar.onNext(new ListAppsClickEvent<>(t, listAppsViewHolder.getAdapterPosition()));
    }

    public final void addData(List<? extends T> apps) {
        kotlin.jvm.internal.m.f(apps, DeepLinkIntentReceiver.DeepLinksTargets.APPS);
        int size = this.appList.size();
        this.appList.addAll(apps);
        notifyItemRangeInserted(size, apps.size());
    }

    public final rx.s.b<ListAppsClickEvent<T>> getClickListener() {
        rx.s.b<ListAppsClickEvent<T>> bVar = this.clickListener;
        kotlin.jvm.internal.m.e(bVar, "clickListener");
        return bVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return this.appList.size();
    }

    public final Function2<ViewGroup, Integer, V> getViewHolderBuilder() {
        return this.viewHolderBuilder;
    }

    public final void setData(List<? extends T> objs) {
        kotlin.jvm.internal.m.f(objs, "objs");
        this.appList = new ArrayList<>(objs);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void onBindViewHolder(V holder, int position) {
        kotlin.jvm.internal.m.f(holder, "holder");
        T t = this.appList.get(position);
        kotlin.jvm.internal.m.e(t, "appList[position]");
        holder.bindApp(t);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public V onCreateViewHolder(ViewGroup parent, int viewType) {
        kotlin.jvm.internal.m.f(parent, "parent");
        final V vInvoke = this.viewHolderBuilder.invoke(parent, Integer.valueOf(viewType));
        vInvoke.itemView.setOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.pt.home.more.base.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ListAppsAdapter.m239onCreateViewHolder$lambda0(this.f6211f, vInvoke, view);
            }
        });
        return vInvoke;
    }
}
