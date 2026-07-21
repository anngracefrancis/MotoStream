package e.c.a.a.a.base;

import android.view.View;
import cm.aptoide.pt.DeepLinkIntentReceiver;
import com.airbnb.epoxy.q;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: e.c.a.a.a.a.a, reason: from Kotlin metadata */
/* JADX INFO: compiled from: BaseViewHolder.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u0002H\u000b0\n\"\b\b\u0000\u0010\u000b*\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0004J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0004H\u0014R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/fa/epoxysample/bundles/models/base/BaseViewHolder;", "Lcom/airbnb/epoxy/EpoxyHolder;", "()V", "itemView", "Landroid/view/View;", "getItemView", "()Landroid/view/View;", "setItemView", "(Landroid/view/View;)V", "bind", "Lkotlin/properties/ReadOnlyProperty;", "V", DeepLinkIntentReceiver.DeepLinksKeys.ID, HttpUrl.FRAGMENT_ENCODE_SET, "bindView", HttpUrl.FRAGMENT_ENCODE_SET, "Lazy", "aptoide-views_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class BaseViewHolder extends q {
    public View itemView;

    /* JADX INFO: renamed from: e.c.a.a.a.a.a$a */
    /* JADX INFO: compiled from: BaseViewHolder.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\u000eB#\u0012\u001c\u0010\u0004\u001a\u0018\u0012\u0004\u0012\u00020\u0003\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\u0010\u0007J\"\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\u00032\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0096\u0002¢\u0006\u0002\u0010\rR$\u0010\u0004\u001a\u0018\u0012\u0004\u0012\u00020\u0003\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/fa/epoxysample/bundles/models/base/BaseViewHolder$Lazy;", "V", "Lkotlin/properties/ReadOnlyProperty;", "Lcom/fa/epoxysample/bundles/models/base/BaseViewHolder;", "initializer", "Lkotlin/Function2;", "Lkotlin/reflect/KProperty;", "(Lkotlin/jvm/functions/Function2;)V", "value", HttpUrl.FRAGMENT_ENCODE_SET, "getValue", "thisRef", "property", "(Lcom/fa/epoxysample/bundles/models/base/BaseViewHolder;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "EMPTY", "aptoide-views_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class a<V> implements ReadOnlyProperty<BaseViewHolder, V> {
        private final Function2<BaseViewHolder, KProperty<?>, V> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Object f20686b;

        /* JADX INFO: renamed from: e.c.a.a.a.a.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: BaseViewHolder.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/fa/epoxysample/bundles/models/base/BaseViewHolder$Lazy$EMPTY;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "aptoide-views_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        private static final class C0254a {
            public static final C0254a a = new C0254a();

            private C0254a() {
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function2<? super BaseViewHolder, ? super KProperty<?>, ? extends V> function2) {
            m.f(function2, "initializer");
            this.a = function2;
            this.f20686b = C0254a.a;
        }

        @Override // kotlin.properties.ReadOnlyProperty
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public V a(BaseViewHolder baseViewHolder, KProperty<?> kProperty) {
            m.f(baseViewHolder, "thisRef");
            m.f(kProperty, "property");
            if (m.a(this.f20686b, C0254a.a)) {
                this.f20686b = this.a.invoke(baseViewHolder, kProperty);
            }
            return (V) this.f20686b;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V] */
    /* JADX INFO: renamed from: e.c.a.a.a.a.a$b */
    /* JADX INFO: compiled from: BaseViewHolder.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "V", "Landroid/view/View;", "holder", "Lcom/fa/epoxysample/bundles/models/base/BaseViewHolder;", "prop", "Lkotlin/reflect/KProperty;", "invoke", "(Lcom/fa/epoxysample/bundles/models/base/BaseViewHolder;Lkotlin/reflect/KProperty;)Landroid/view/View;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class b<V> extends Lambda implements Function2<BaseViewHolder, KProperty<?>, V> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f20687f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(int i2) {
            super(2);
            this.f20687f = i2;
        }

        /* JADX WARN: Incorrect return type in method signature: (Le/c/a/a/a/a/a;Lkotlin/f0/l<*>;)TV; */
        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final View invoke(BaseViewHolder baseViewHolder, KProperty kProperty) {
            m.f(baseViewHolder, "holder");
            m.f(kProperty, "prop");
            View viewFindViewById = baseViewHolder.getItemView().findViewById(this.f20687f);
            if (viewFindViewById != null) {
                return viewFindViewById;
            }
            throw new IllegalStateException("View ID " + this.f20687f + " for '" + kProperty.getM() + "' not found.");
        }
    }

    protected final <V extends View> ReadOnlyProperty<BaseViewHolder, V> bind(int i2) {
        return new a(new b(i2));
    }

    @Override // com.airbnb.epoxy.q
    protected void bindView(View itemView) {
        m.f(itemView, "itemView");
        setItemView(itemView);
    }

    public final View getItemView() {
        View view = this.itemView;
        if (view != null) {
            return view;
        }
        m.w("itemView");
        return null;
    }

    public final void setItemView(View view) {
        m.f(view, "<set-?>");
        this.itemView = view;
    }
}
