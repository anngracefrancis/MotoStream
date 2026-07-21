package com.airbnb.epoxy;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.ref.WeakReference;
import kotlin.Metadata;

/* JADX INFO: compiled from: ActivityRecyclerPool.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0011\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0004R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u00078F@\u0006¢\u0006\u0006\u001a\u0004\b\f\u0010\u000fR\u0019\u0010\u0015\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/airbnb/epoxy/PoolReference;", "Landroidx/lifecycle/j;", "Lkotlin/u;", "b", "()V", "onContextDestroyed", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "a", "Ljava/lang/ref/WeakReference;", "contextReference", "Lcom/airbnb/epoxy/a;", "c", "Lcom/airbnb/epoxy/a;", "parent", "()Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/RecyclerView$u;", "Landroidx/recyclerview/widget/RecyclerView$u;", "d", "()Landroidx/recyclerview/widget/RecyclerView$u;", "viewPool", "<init>", "(Landroid/content/Context;Landroidx/recyclerview/widget/RecyclerView$u;Lcom/airbnb/epoxy/a;)V", "epoxy-adapter_release"}, k = 1, mv = {1, 4, 0})
public final class PoolReference implements androidx.lifecycle.j {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final WeakReference<Context> contextReference;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final RecyclerView.u viewPool;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final a parent;

    public PoolReference(Context context, RecyclerView.u uVar, a aVar) {
        kotlin.jvm.internal.m.g(context, "context");
        kotlin.jvm.internal.m.g(uVar, "viewPool");
        kotlin.jvm.internal.m.g(aVar, "parent");
        this.viewPool = uVar;
        this.parent = aVar;
        this.contextReference = new WeakReference<>(context);
    }

    public final void b() {
        this.parent.a(this);
    }

    public final Context c() {
        return this.contextReference.get();
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final RecyclerView.u getViewPool() {
        return this.viewPool;
    }

    @androidx.lifecycle.s(androidx.lifecycle.g.b.ON_DESTROY)
    public final void onContextDestroyed() {
        b();
    }
}
