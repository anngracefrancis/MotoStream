package kotlin.reflect.y.internal;

import cm.aptoide.pt.database.room.RoomInstalled;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.full.IllegalCallableAccessException;
import kotlin.p002reflect.jvm.internal.impl.descriptors.t0;
import kotlin.reflect.KMutableProperty1;
import kotlin.u;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlin.f0.y.e.l, reason: from Kotlin metadata */
/* JADX INFO: compiled from: KProperty1Impl.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004:\u0001\u001cB)\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fB\u0017\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u001d\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001bR4\u0010\u0010\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001 \u0013*\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00120\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001d"}, d2 = {"Lkotlin/reflect/jvm/internal/KMutableProperty1Impl;", "T", "V", "Lkotlin/reflect/jvm/internal/KProperty1Impl;", "Lkotlin/reflect/KMutableProperty1;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", HttpUrl.FRAGMENT_ENCODE_SET, RoomInstalled.SIGNATURE, "boundReceiver", HttpUrl.FRAGMENT_ENCODE_SET, "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "_setter", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KMutableProperty1Impl$Setter;", "kotlin.jvm.PlatformType", "setter", "getSetter", "()Lkotlin/reflect/jvm/internal/KMutableProperty1Impl$Setter;", "set", HttpUrl.FRAGMENT_ENCODE_SET, "receiver", "value", "(Ljava/lang/Object;Ljava/lang/Object;)V", "Setter", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KMutableProperty1Impl<T, V> extends KProperty1Impl<T, V> implements KMutableProperty1<T, V> {
    private final a0.b<a<T, V>> t;

    /* JADX INFO: renamed from: kotlin.f0.y.e.l$a */
    /* JADX INFO: compiled from: KProperty1Impl.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\b\u0012\u0004\u0012\u0002H\u00020\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004B\u0019\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006¢\u0006\u0002\u0010\u0007J\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u00022\u0006\u0010\r\u001a\u00028\u0003H\u0096\u0002¢\u0006\u0002\u0010\u000eR \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lkotlin/reflect/jvm/internal/KMutableProperty1Impl$Setter;", "T", "V", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Setter;", "Lkotlin/reflect/KMutableProperty1$Setter;", "property", "Lkotlin/reflect/jvm/internal/KMutableProperty1Impl;", "(Lkotlin/reflect/jvm/internal/KMutableProperty1Impl;)V", "getProperty", "()Lkotlin/reflect/jvm/internal/KMutableProperty1Impl;", "invoke", HttpUrl.FRAGMENT_ENCODE_SET, "receiver", "value", "(Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a<T, V> extends KPropertyImpl.d<V> implements KMutableProperty1.a<T, V> {
        private final KMutableProperty1Impl<T, V> m;

        public a(KMutableProperty1Impl<T, V> kMutableProperty1Impl) {
            m.f(kMutableProperty1Impl, "property");
            this.m = kMutableProperty1Impl;
        }

        @Override // kotlin.reflect.KProperty.a
        /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
        public KMutableProperty1Impl<T, V> n() {
            return this.m;
        }

        public void J(T t, V v) throws IllegalCallableAccessException {
            n().s(t, v);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ u invoke(Object obj, Object obj2) throws IllegalCallableAccessException {
            J(obj, obj2);
            return u.a;
        }
    }

    /* JADX INFO: renamed from: kotlin.f0.y.e.l$b */
    /* JADX INFO: compiled from: KProperty1Impl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0000\u001a\"\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003 \u0004*\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u00010\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/KMutableProperty1Impl$Setter;", "T", "V", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    static final class b extends Lambda implements Function0<a<T, V>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ KMutableProperty1Impl<T, V> f24957f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(KMutableProperty1Impl<T, V> kMutableProperty1Impl) {
            super(0);
            this.f24957f = kMutableProperty1Impl;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final a<T, V> invoke() {
            return new a<>(this.f24957f);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KMutableProperty1Impl(KDeclarationContainerImpl kDeclarationContainerImpl, String str, String str2, Object obj) {
        super(kDeclarationContainerImpl, str, str2, obj);
        m.f(kDeclarationContainerImpl, "container");
        m.f(str, "name");
        m.f(str2, RoomInstalled.SIGNATURE);
        a0.b<a<T, V>> bVarB = a0.b(new b(this));
        m.e(bVarB, "lazy { Setter(this) }");
        this.t = bVarB;
    }

    @Override // kotlin.reflect.KMutableProperty1, kotlin.reflect.KMutableProperty
    /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
    public a<T, V> getSetter() {
        a<T, V> aVarInvoke = this.t.invoke();
        m.e(aVarInvoke, "_setter()");
        return aVarInvoke;
    }

    @Override // kotlin.reflect.KMutableProperty1
    public void s(T t, V v) throws IllegalCallableAccessException {
        getSetter().call(t, v);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KMutableProperty1Impl(KDeclarationContainerImpl kDeclarationContainerImpl, t0 t0Var) {
        super(kDeclarationContainerImpl, t0Var);
        m.f(kDeclarationContainerImpl, "container");
        m.f(t0Var, "descriptor");
        a0.b<a<T, V>> bVarB = a0.b(new b(this));
        m.e(bVarB, "lazy { Setter(this) }");
        this.t = bVarB;
    }
}
