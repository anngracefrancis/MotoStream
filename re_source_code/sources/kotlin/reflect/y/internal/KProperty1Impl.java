package kotlin.reflect.y.internal;

import cm.aptoide.pt.database.room.RoomInstalled;
import java.lang.reflect.Member;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.i;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.t0;
import kotlin.reflect.KProperty1;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlin.f0.y.e.r, reason: from Kotlin metadata */
/* JADX INFO: compiled from: KProperty1Impl.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0006\b\u0001\u0010\u0002 \u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00020\u0004:\u0001\u001fB)\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fB\u0017\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u0015\u0010\u001a\u001a\u00028\u00012\u0006\u0010\u001b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001cJ\u0017\u0010\u001d\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001cJ\u0016\u0010\u001e\u001a\u00028\u00012\u0006\u0010\u001b\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u001cR4\u0010\u0010\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001 \u0013*\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00120\u00120\u0011X\u0088\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006 "}, d2 = {"Lkotlin/reflect/jvm/internal/KProperty1Impl;", "T", "V", "Lkotlin/reflect/KProperty1;", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", HttpUrl.FRAGMENT_ENCODE_SET, RoomInstalled.SIGNATURE, "boundReceiver", HttpUrl.FRAGMENT_ENCODE_SET, "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "_getter", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KProperty1Impl$Getter;", "kotlin.jvm.PlatformType", "delegateSource", "Lkotlin/Lazy;", "Ljava/lang/reflect/Member;", "getter", "getGetter", "()Lkotlin/reflect/jvm/internal/KProperty1Impl$Getter;", "get", "receiver", "(Ljava/lang/Object;)Ljava/lang/Object;", "getDelegate", "invoke", "Getter", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class KProperty1Impl<T, V> extends KPropertyImpl<V> implements KProperty1<T, V> {
    private final a0.b<a<T, V>> r;
    private final Lazy<Member> s;

    /* JADX INFO: renamed from: kotlin.f0.y.e.r$a */
    /* JADX INFO: compiled from: KProperty1Impl.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0006\b\u0003\u0010\u0002 \u00012\b\u0012\u0004\u0012\u0002H\u00020\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004B\u0019\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\n\u001a\u00028\u00032\u0006\u0010\u000b\u001a\u00028\u0002H\u0096\u0002¢\u0006\u0002\u0010\fR \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lkotlin/reflect/jvm/internal/KProperty1Impl$Getter;", "T", "V", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "Lkotlin/reflect/KProperty1$Getter;", "property", "Lkotlin/reflect/jvm/internal/KProperty1Impl;", "(Lkotlin/reflect/jvm/internal/KProperty1Impl;)V", "getProperty", "()Lkotlin/reflect/jvm/internal/KProperty1Impl;", "invoke", "receiver", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a<T, V> extends KPropertyImpl.c<V> implements KProperty1.a<T, V> {
        private final KProperty1Impl<T, V> m;

        /* JADX WARN: Multi-variable type inference failed */
        public a(KProperty1Impl<T, ? extends V> kProperty1Impl) {
            m.f(kProperty1Impl, "property");
            this.m = kProperty1Impl;
        }

        @Override // kotlin.reflect.KProperty.a
        /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
        public KProperty1Impl<T, V> n() {
            return this.m;
        }

        @Override // kotlin.jvm.functions.Function1
        public V invoke(T receiver) {
            return n().get(receiver);
        }
    }

    /* JADX INFO: renamed from: kotlin.f0.y.e.r$b */
    /* JADX INFO: compiled from: KProperty1Impl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0000\u001a\"\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003 \u0004*\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u00010\u0001\"\u0004\b\u0000\u0010\u0002\"\u0006\b\u0001\u0010\u0003 \u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/KProperty1Impl$Getter;", "T", "V", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    static final class b extends Lambda implements Function0<a<T, ? extends V>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ KProperty1Impl<T, V> f24988f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(KProperty1Impl<T, ? extends V> kProperty1Impl) {
            super(0);
            this.f24988f = kProperty1Impl;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final a<T, V> invoke() {
            return new a<>(this.f24988f);
        }
    }

    /* JADX INFO: renamed from: kotlin.f0.y.e.r$c */
    /* JADX INFO: compiled from: KProperty1Impl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002\"\u0006\b\u0001\u0010\u0003 \u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Ljava/lang/reflect/Member;", "T", "V", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    static final class c extends Lambda implements Function0<Member> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ KProperty1Impl<T, V> f24989f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        c(KProperty1Impl<T, ? extends V> kProperty1Impl) {
            super(0);
            this.f24989f = kProperty1Impl;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Member invoke() {
            return this.f24989f.F();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KProperty1Impl(KDeclarationContainerImpl kDeclarationContainerImpl, String str, String str2, Object obj) {
        super(kDeclarationContainerImpl, str, str2, obj);
        m.f(kDeclarationContainerImpl, "container");
        m.f(str, "name");
        m.f(str2, RoomInstalled.SIGNATURE);
        a0.b<a<T, V>> bVarB = a0.b(new b(this));
        m.e(bVarB, "lazy { Getter(this) }");
        this.r = bVarB;
        this.s = i.a(LazyThreadSafetyMode.PUBLICATION, new c(this));
    }

    @Override // kotlin.reflect.KProperty
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public a<T, V> getGetter() {
        a<T, V> aVarInvoke = this.r.invoke();
        m.e(aVarInvoke, "_getter()");
        return aVarInvoke;
    }

    @Override // kotlin.reflect.KProperty1
    public V get(T receiver) {
        return getGetter().call(receiver);
    }

    @Override // kotlin.jvm.functions.Function1
    public V invoke(T receiver) {
        return get(receiver);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KProperty1Impl(KDeclarationContainerImpl kDeclarationContainerImpl, t0 t0Var) {
        super(kDeclarationContainerImpl, t0Var);
        m.f(kDeclarationContainerImpl, "container");
        m.f(t0Var, "descriptor");
        a0.b<a<T, V>> bVarB = a0.b(new b(this));
        m.e(bVarB, "lazy { Getter(this) }");
        this.r = bVarB;
        this.s = i.a(LazyThreadSafetyMode.PUBLICATION, new c(this));
    }
}
