package kotlin.reflect.y.internal;

import cm.aptoide.pt.database.room.RoomInstalled;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.full.IllegalCallableAccessException;
import kotlin.p002reflect.jvm.internal.impl.descriptors.t0;
import kotlin.reflect.KMutableProperty0;
import kotlin.u;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlin.f0.y.e.k, reason: from Kotlin metadata */
/* JADX INFO: compiled from: KProperty0Impl.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u001aB\u0017\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB)\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u0015\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0019R(\u0010\u000f\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00028\u0000 \u0012*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00110\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001b"}, d2 = {"Lkotlin/reflect/jvm/internal/KMutableProperty0Impl;", "V", "Lkotlin/reflect/jvm/internal/KProperty0Impl;", "Lkotlin/reflect/KMutableProperty0;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "name", HttpUrl.FRAGMENT_ENCODE_SET, RoomInstalled.SIGNATURE, "boundReceiver", HttpUrl.FRAGMENT_ENCODE_SET, "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "_setter", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KMutableProperty0Impl$Setter;", "kotlin.jvm.PlatformType", "setter", "getSetter", "()Lkotlin/reflect/jvm/internal/KMutableProperty0Impl$Setter;", "set", HttpUrl.FRAGMENT_ENCODE_SET, "value", "(Ljava/lang/Object;)V", "Setter", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KMutableProperty0Impl<V> extends KProperty0Impl<V> implements KMutableProperty0<V> {
    private final a0.b<a<V>> t;

    /* JADX INFO: renamed from: kotlin.f0.y.e.k$a */
    /* JADX INFO: compiled from: KProperty0Impl.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010\fR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lkotlin/reflect/jvm/internal/KMutableProperty0Impl$Setter;", "R", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Setter;", "Lkotlin/reflect/KMutableProperty0$Setter;", "property", "Lkotlin/reflect/jvm/internal/KMutableProperty0Impl;", "(Lkotlin/reflect/jvm/internal/KMutableProperty0Impl;)V", "getProperty", "()Lkotlin/reflect/jvm/internal/KMutableProperty0Impl;", "invoke", HttpUrl.FRAGMENT_ENCODE_SET, "value", "(Ljava/lang/Object;)V", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a<R> extends KPropertyImpl.d<R> implements KMutableProperty0.a<R> {
        private final KMutableProperty0Impl<R> m;

        public a(KMutableProperty0Impl<R> kMutableProperty0Impl) {
            m.f(kMutableProperty0Impl, "property");
            this.m = kMutableProperty0Impl;
        }

        @Override // kotlin.reflect.KProperty.a
        /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
        public KMutableProperty0Impl<R> n() {
            return this.m;
        }

        public void J(R r) throws IllegalCallableAccessException {
            n().O(r);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ u invoke(Object obj) throws IllegalCallableAccessException {
            J(obj);
            return u.a;
        }
    }

    /* JADX INFO: renamed from: kotlin.f0.y.e.k$b */
    /* JADX INFO: compiled from: KProperty0Impl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u0002H\u0002 \u0003*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u00010\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/KMutableProperty0Impl$Setter;", "V", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    static final class b extends Lambda implements Function0<a<V>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ KMutableProperty0Impl<V> f24941f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(KMutableProperty0Impl<V> kMutableProperty0Impl) {
            super(0);
            this.f24941f = kMutableProperty0Impl;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final a<V> invoke() {
            return new a<>(this.f24941f);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KMutableProperty0Impl(KDeclarationContainerImpl kDeclarationContainerImpl, t0 t0Var) {
        super(kDeclarationContainerImpl, t0Var);
        m.f(kDeclarationContainerImpl, "container");
        m.f(t0Var, "descriptor");
        a0.b<a<V>> bVarB = a0.b(new b(this));
        m.e(bVarB, "lazy { Setter(this) }");
        this.t = bVarB;
    }

    @Override // kotlin.reflect.KMutableProperty0, kotlin.reflect.KMutableProperty
    /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
    public a<V> getSetter() {
        a<V> aVarInvoke = this.t.invoke();
        m.e(aVarInvoke, "_setter()");
        return aVarInvoke;
    }

    public void O(V v) throws IllegalCallableAccessException {
        getSetter().call(v);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KMutableProperty0Impl(KDeclarationContainerImpl kDeclarationContainerImpl, String str, String str2, Object obj) {
        super(kDeclarationContainerImpl, str, str2, obj);
        m.f(kDeclarationContainerImpl, "container");
        m.f(str, "name");
        m.f(str2, RoomInstalled.SIGNATURE);
        a0.b<a<V>> bVarB = a0.b(new b(this));
        m.e(bVarB, "lazy { Setter(this) }");
        this.t = bVarB;
    }
}
