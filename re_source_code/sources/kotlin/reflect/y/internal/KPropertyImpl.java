package kotlin.reflect.y.internal;

import cm.aptoide.pt.database.room.RoomInstalled;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.y;
import kotlin.p002reflect.full.IllegalPropertyDelegateAccessException;
import kotlin.p002reflect.jvm.internal.impl.descriptors.s0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.t0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.u0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty;
import kotlin.reflect.KProperty;
import kotlin.reflect.y.internal.calls.Caller;
import kotlin.reflect.y.internal.calls.h;
import kotlin.reflect.y.internal.j0.d.a.k;
import kotlin.reflect.y.internal.j0.e.a0.b.i;
import kotlin.u;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlin.f0.y.e.t, reason: from Kotlin metadata */
/* JADX INFO: compiled from: KPropertyImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\b \u0018\u0000 @*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0004?@ABB)\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB\u0017\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eB3\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u0011J\n\u00104\u001a\u0004\u0018\u000105H\u0004J\u0013\u00106\u001a\u00020)2\b\u00107\u001a\u0004\u0018\u00010\nH\u0096\u0002J(\u00108\u001a\u0004\u0018\u00010\n2\b\u00109\u001a\u0004\u0018\u0001052\b\u0010:\u001a\u0004\u0018\u00010\n2\b\u0010;\u001a\u0004\u0018\u00010\nH\u0004J\b\u0010<\u001a\u00020=H\u0016J\b\u0010>\u001a\u00020\u0007H\u0016R\u001c\u0010\u0012\u001a\u0010\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\r0\r0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\t\u001a\u0004\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u001dR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0018\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000%X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010*R\u0014\u0010+\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010*R\u0014\u0010,\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010*R\u0014\u0010-\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010*R\u0013\u0010.\u001a\u0004\u0018\u00010\u00178F¢\u0006\u0006\u001a\u0004\b/\u00100R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b3\u00102¨\u0006C"}, d2 = {"Lkotlin/reflect/jvm/internal/KPropertyImpl;", "V", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "Lkotlin/reflect/KProperty;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", HttpUrl.FRAGMENT_ENCODE_SET, RoomInstalled.SIGNATURE, "boundReceiver", HttpUrl.FRAGMENT_ENCODE_SET, "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "descriptorInitialValue", "rawBoundReceiver", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;Ljava/lang/Object;)V", "_descriptor", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "kotlin.jvm.PlatformType", "_javaField", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Ljava/lang/reflect/Field;", "getBoundReceiver", "()Ljava/lang/Object;", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "getDefaultCaller", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "getter", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "getGetter", "()Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "isBound", HttpUrl.FRAGMENT_ENCODE_SET, "()Z", "isConst", "isLateinit", "isSuspend", "javaField", "getJavaField", "()Ljava/lang/reflect/Field;", "getName", "()Ljava/lang/String;", "getSignature", "computeDelegateSource", "Ljava/lang/reflect/Member;", "equals", "other", "getDelegateImpl", "fieldOrMethod", "receiver1", "receiver2", "hashCode", HttpUrl.FRAGMENT_ENCODE_SET, "toString", "Accessor", "Companion", "Getter", "Setter", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class KPropertyImpl<V> extends KCallableImpl<V> implements KProperty<V> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final b f24992j = new b(null);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Object f24993k = new Object();
    private final KDeclarationContainerImpl l;
    private final String m;
    private final String n;
    private final Object o;
    private final a0.b<Field> p;
    private final a0.a<t0> q;

    /* JADX INFO: renamed from: kotlin.f0.y.e.t$a */
    /* JADX INFO: compiled from: KPropertyImpl.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u0001*\u0006\b\u0002\u0010\u0002 \u00012\b\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u00042\b\u0012\u0004\u0012\u0002H\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0015R\u0018\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00010\u001cX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "PropertyType", "ReturnType", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "Lkotlin/reflect/KProperty$Accessor;", "Lkotlin/reflect/KFunction;", "()V", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getDefaultCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyAccessorDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyAccessorDescriptor;", "isBound", HttpUrl.FRAGMENT_ENCODE_SET, "()Z", "isExternal", "isInfix", "isInline", "isOperator", "isSuspend", "property", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "getProperty", "()Lkotlin/reflect/jvm/internal/KPropertyImpl;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static abstract class a<PropertyType, ReturnType> extends KCallableImpl<ReturnType> implements KFunction<ReturnType>, KProperty.a<PropertyType> {
        @Override // kotlin.reflect.y.internal.KCallableImpl
        /* JADX INFO: renamed from: A */
        public KDeclarationContainerImpl getF23147k() {
            return n().getF23147k();
        }

        @Override // kotlin.reflect.y.internal.KCallableImpl
        public Caller<?> B() {
            return null;
        }

        @Override // kotlin.reflect.y.internal.KCallableImpl
        public boolean E() {
            return n().E();
        }

        public abstract s0 F();

        /* JADX INFO: renamed from: G */
        public abstract KPropertyImpl<PropertyType> n();

        @Override // kotlin.reflect.KCallable
        public boolean isSuspend() {
            return F().isSuspend();
        }
    }

    /* JADX INFO: renamed from: kotlin.f0.y.e.t$b */
    /* JADX INFO: compiled from: KPropertyImpl.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lkotlin/reflect/jvm/internal/KPropertyImpl$Companion;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "EXTENSION_PROPERTY_DELEGATE", "getEXTENSION_PROPERTY_DELEGATE", "()Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(g gVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: kotlin.f0.y.e.t$c */
    /* JADX INFO: compiled from: KPropertyImpl.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b&\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0012H\u0016R\u001f\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00068VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001c"}, d2 = {"Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "V", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "Lkotlin/reflect/KProperty$Getter;", "()V", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyGetterDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyGetterDescriptor;", "descriptor$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "name", HttpUrl.FRAGMENT_ENCODE_SET, "getName", "()Ljava/lang/String;", "equals", HttpUrl.FRAGMENT_ENCODE_SET, "other", HttpUrl.FRAGMENT_ENCODE_SET, "hashCode", HttpUrl.FRAGMENT_ENCODE_SET, "toString", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static abstract class c<V> extends a<V, V> implements KProperty.b<V> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        static final /* synthetic */ KProperty<Object>[] f24994j = {g0.h(new y(g0.b(c.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertyGetterDescriptor;")), g0.h(new y(g0.b(c.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;"))};

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final a0.a f24995k = a0.d(new b(this));
        private final a0.b l = a0.b(new a(this));

        /* JADX INFO: renamed from: kotlin.f0.y.e.t$c$a */
        /* JADX INFO: compiled from: KPropertyImpl.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0012\u0012\u0002\b\u0003 \u0002*\b\u0012\u0002\b\u0003\u0018\u00010\u00010\u0001\"\u0006\b\u0000\u0010\u0003 \u0001\"\u0006\b\u0001\u0010\u0003 \u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/calls/Caller;", "kotlin.jvm.PlatformType", "V", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class a extends Lambda implements Function0<Caller<?>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ c<V> f24996f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            a(c<? extends V> cVar) {
                super(0);
                this.f24996f = cVar;
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Caller<?> invoke() {
                return u.b(this.f24996f, true);
            }
        }

        /* JADX INFO: renamed from: kotlin.f0.y.e.t$c$b */
        /* JADX INFO: compiled from: KPropertyImpl.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001\"\u0006\b\u0000\u0010\u0003 \u0001\"\u0006\b\u0001\u0010\u0003 \u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyGetterDescriptor;", "kotlin.jvm.PlatformType", "V", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class b extends Lambda implements Function0<u0> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ c<V> f24997f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            b(c<? extends V> cVar) {
                super(0);
                this.f24997f = cVar;
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final u0 invoke() {
                u0 getter = this.f24997f.n().F().getGetter();
                return getter == null ? kotlin.reflect.y.internal.j0.i.c.d(this.f24997f.n().F(), kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g.f25179c.b()) : getter;
            }
        }

        @Override // kotlin.reflect.y.internal.KPropertyImpl.a
        /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public u0 F() {
            T tC = this.f24995k.c(this, f24994j[0]);
            m.e(tC, "<get-descriptor>(...)");
            return (u0) tC;
        }

        public boolean equals(Object other) {
            return (other instanceof c) && m.a(n(), ((c) other).n());
        }

        @Override // kotlin.reflect.KCallable
        /* JADX INFO: renamed from: getName */
        public String getM() {
            return "<get-" + n().getM() + '>';
        }

        public int hashCode() {
            return n().hashCode();
        }

        public String toString() {
            return "getter of " + n();
        }

        @Override // kotlin.reflect.y.internal.KCallableImpl
        public Caller<?> z() {
            T tC = this.l.c(this, f24994j[1]);
            m.e(tC, "<get-caller>(...)");
            return (Caller) tC;
        }
    }

    /* JADX INFO: renamed from: kotlin.f0.y.e.t$d */
    /* JADX INFO: compiled from: KPropertyImpl.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b&\u0018\u0000*\u0004\b\u0001\u0010\u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0096\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0013H\u0016R\u001f\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00078VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001d"}, d2 = {"Lkotlin/reflect/jvm/internal/KPropertyImpl$Setter;", "V", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlin/reflect/KMutableProperty$Setter;", "()V", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertySetterDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;", "descriptor$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "name", HttpUrl.FRAGMENT_ENCODE_SET, "getName", "()Ljava/lang/String;", "equals", HttpUrl.FRAGMENT_ENCODE_SET, "other", HttpUrl.FRAGMENT_ENCODE_SET, "hashCode", HttpUrl.FRAGMENT_ENCODE_SET, "toString", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static abstract class d<V> extends a<V, u> implements KMutableProperty.a<V> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        static final /* synthetic */ KProperty<Object>[] f24998j = {g0.h(new y(g0.b(d.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;")), g0.h(new y(g0.b(d.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;"))};

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final a0.a f24999k = a0.d(new b(this));
        private final a0.b l = a0.b(new a(this));

        /* JADX INFO: renamed from: kotlin.f0.y.e.t$d$a */
        /* JADX INFO: compiled from: KPropertyImpl.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0012\u0012\u0002\b\u0003 \u0002*\b\u0012\u0002\b\u0003\u0018\u00010\u00010\u0001\"\u0004\b\u0000\u0010\u0003\"\u0006\b\u0001\u0010\u0003 \u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/calls/Caller;", "kotlin.jvm.PlatformType", "V", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class a extends Lambda implements Function0<Caller<?>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ d<V> f25000f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(d<V> dVar) {
                super(0);
                this.f25000f = dVar;
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Caller<?> invoke() {
                return u.b(this.f25000f, false);
            }
        }

        /* JADX INFO: renamed from: kotlin.f0.y.e.t$d$b */
        /* JADX INFO: compiled from: KPropertyImpl.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001\"\u0004\b\u0000\u0010\u0003\"\u0006\b\u0001\u0010\u0003 \u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertySetterDescriptor;", "kotlin.jvm.PlatformType", "V", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class b extends Lambda implements Function0<v0> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ d<V> f25001f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(d<V> dVar) {
                super(0);
                this.f25001f = dVar;
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final v0 invoke() {
                v0 setter = this.f25001f.n().F().getSetter();
                if (setter != null) {
                    return setter;
                }
                t0 t0VarF = this.f25001f.n().F();
                kotlin.reflect.jvm.internal.impl.descriptors.n1.g.a aVar = kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g.f25179c;
                return kotlin.reflect.y.internal.j0.i.c.e(t0VarF, aVar.b(), aVar.b());
            }
        }

        @Override // kotlin.reflect.y.internal.KPropertyImpl.a
        /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
        public v0 F() {
            T tC = this.f24999k.c(this, f24998j[0]);
            m.e(tC, "<get-descriptor>(...)");
            return (v0) tC;
        }

        public boolean equals(Object other) {
            return (other instanceof d) && m.a(n(), ((d) other).n());
        }

        @Override // kotlin.reflect.KCallable
        /* JADX INFO: renamed from: getName */
        public String getM() {
            return "<set-" + n().getM() + '>';
        }

        public int hashCode() {
            return n().hashCode();
        }

        public String toString() {
            return "setter of " + n();
        }

        @Override // kotlin.reflect.y.internal.KCallableImpl
        public Caller<?> z() {
            T tC = this.l.c(this, f24998j[1]);
            m.e(tC, "<get-caller>(...)");
            return (Caller) tC;
        }
    }

    /* JADX INFO: renamed from: kotlin.f0.y.e.t$e */
    /* JADX INFO: compiled from: KPropertyImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001\"\u0006\b\u0000\u0010\u0003 \u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "kotlin.jvm.PlatformType", "V", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    static final class e extends Lambda implements Function0<t0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ KPropertyImpl<V> f25002f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        e(KPropertyImpl<? extends V> kPropertyImpl) {
            super(0);
            this.f25002f = kPropertyImpl;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final t0 invoke() {
            return this.f25002f.getF23147k().z(this.f25002f.getM(), this.f25002f.getN());
        }
    }

    /* JADX INFO: renamed from: kotlin.f0.y.e.t$f */
    /* JADX INFO: compiled from: KPropertyImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0006\b\u0000\u0010\u0002 \u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Ljava/lang/reflect/Field;", "V", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    static final class f extends Lambda implements Function0<Field> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ KPropertyImpl<V> f25003f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        f(KPropertyImpl<? extends V> kPropertyImpl) {
            super(0);
            this.f25003f = kPropertyImpl;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Field invoke() {
            Class<?> enclosingClass;
            JvmPropertySignature jvmPropertySignatureF = RuntimeTypeMapper.a.f(this.f25003f.F());
            if (!(jvmPropertySignatureF instanceof JvmPropertySignature.c)) {
                if (jvmPropertySignatureF instanceof JvmPropertySignature.a) {
                    return ((JvmPropertySignature.a) jvmPropertySignatureF).getA();
                }
                if ((jvmPropertySignatureF instanceof JvmPropertySignature.b) || (jvmPropertySignatureF instanceof JvmPropertySignature.d)) {
                    return null;
                }
                throw new NoWhenBranchMatchedException();
            }
            JvmPropertySignature.c cVar = (JvmPropertySignature.c) jvmPropertySignatureF;
            t0 t0VarB = cVar.getA();
            kotlin.f0.y.e.j0.e.a0.b.d.a aVarD = i.d(i.a, cVar.getF23035b(), cVar.getF23037d(), cVar.getF23038e(), false, 8, null);
            if (aVarD == null) {
                return null;
            }
            KPropertyImpl<V> kPropertyImpl = this.f25003f;
            if (k.e(t0VarB) || i.f(cVar.getF23035b())) {
                enclosingClass = kPropertyImpl.getF23147k().a().getEnclosingClass();
            } else {
                kotlin.p002reflect.jvm.internal.impl.descriptors.m mVarB = t0VarB.b();
                enclosingClass = mVarB instanceof kotlin.p002reflect.jvm.internal.impl.descriptors.e ? g0.p((kotlin.p002reflect.jvm.internal.impl.descriptors.e) mVarB) : kPropertyImpl.getF23147k().a();
            }
            if (enclosingClass == null) {
                return null;
            }
            try {
                return enclosingClass.getDeclaredField(aVarD.c());
            } catch (NoSuchFieldException unused) {
                return null;
            }
        }
    }

    private KPropertyImpl(KDeclarationContainerImpl kDeclarationContainerImpl, String str, String str2, t0 t0Var, Object obj) {
        this.l = kDeclarationContainerImpl;
        this.m = str;
        this.n = str2;
        this.o = obj;
        a0.b<Field> bVarB = a0.b(new f(this));
        m.e(bVarB, "lazy {\n        when (val…y -> null\n        }\n    }");
        this.p = bVarB;
        a0.a<t0> aVarC = a0.c(t0Var, new e(this));
        m.e(aVarC, "lazySoft(descriptorIniti…or(name, signature)\n    }");
        this.q = aVarC;
    }

    @Override // kotlin.reflect.y.internal.KCallableImpl
    /* JADX INFO: renamed from: A, reason: from getter */
    public KDeclarationContainerImpl getF23147k() {
        return this.l;
    }

    @Override // kotlin.reflect.y.internal.KCallableImpl
    public Caller<?> B() {
        return getGetter().B();
    }

    @Override // kotlin.reflect.y.internal.KCallableImpl
    public boolean E() {
        return !m.a(this.o, kotlin.jvm.internal.c.NO_RECEIVER);
    }

    protected final Member F() {
        if (!F().O()) {
            return null;
        }
        JvmPropertySignature jvmPropertySignatureF = RuntimeTypeMapper.a.f(F());
        if (jvmPropertySignatureF instanceof JvmPropertySignature.c) {
            JvmPropertySignature.c cVar = (JvmPropertySignature.c) jvmPropertySignatureF;
            if (cVar.getF23036c().E()) {
                kotlin.f0.y.e.j0.e.a0.a.c cVarZ = cVar.getF23036c().z();
                if (!cVarZ.z() || !cVarZ.y()) {
                    return null;
                }
                return getF23147k().y(cVar.getF23037d().getString(cVarZ.x()), cVar.getF23037d().getString(cVarZ.w()));
            }
        }
        return K();
    }

    public final Object G() {
        return h.a(this.o, F());
    }

    protected final Object H(Member member, Object obj, Object obj2) throws IllegalPropertyDelegateAccessException {
        try {
            Object obj3 = f24993k;
            if ((obj == obj3 || obj2 == obj3) && F().m0() == null) {
                throw new RuntimeException('\'' + this + "' is not an extension property and thus getExtensionDelegate() is not going to work, use getDelegate() instead");
            }
            Object objG = E() ? G() : obj;
            if (!(objG != obj3)) {
                objG = null;
            }
            if (!E()) {
                obj = obj2;
            }
            if (!(obj != obj3)) {
                obj = null;
            }
            if (member == null) {
                return null;
            }
            if (member instanceof Field) {
                return ((Field) member).get(objG);
            }
            if (!(member instanceof Method)) {
                throw new AssertionError("delegate field/method " + member + " neither field nor method");
            }
            int length = ((Method) member).getParameterTypes().length;
            if (length == 0) {
                return ((Method) member).invoke(null, new Object[0]);
            }
            if (length == 1) {
                Method method = (Method) member;
                Object[] objArr = new Object[1];
                if (objG == null) {
                    Class<?> cls = ((Method) member).getParameterTypes()[0];
                    m.e(cls, "fieldOrMethod.parameterTypes[0]");
                    objG = g0.g(cls);
                }
                objArr[0] = objG;
                return method.invoke(null, objArr);
            }
            if (length != 2) {
                throw new AssertionError("delegate method " + member + " should take 0, 1, or 2 parameters");
            }
            Method method2 = (Method) member;
            Object[] objArr2 = new Object[2];
            objArr2[0] = objG;
            if (obj == null) {
                Class<?> cls2 = ((Method) member).getParameterTypes()[1];
                m.e(cls2, "fieldOrMethod.parameterTypes[1]");
                obj = g0.g(cls2);
            }
            objArr2[1] = obj;
            return method2.invoke(null, objArr2);
        } catch (IllegalAccessException e2) {
            throw new IllegalPropertyDelegateAccessException(e2);
        }
    }

    @Override // kotlin.reflect.y.internal.KCallableImpl
    /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
    public t0 F() {
        t0 t0VarInvoke = this.q.invoke();
        m.e(t0VarInvoke, "_descriptor()");
        return t0VarInvoke;
    }

    /* JADX INFO: renamed from: J */
    public abstract c<V> getGetter();

    public final Field K() {
        return this.p.invoke();
    }

    /* JADX INFO: renamed from: L, reason: from getter */
    public final String getN() {
        return this.n;
    }

    public boolean equals(Object other) {
        KPropertyImpl<?> kPropertyImplD = g0.d(other);
        return kPropertyImplD != null && m.a(getF23147k(), kPropertyImplD.getF23147k()) && m.a(getM(), kPropertyImplD.getM()) && m.a(this.n, kPropertyImplD.n) && m.a(this.o, kPropertyImplD.o);
    }

    @Override // kotlin.reflect.KCallable
    /* JADX INFO: renamed from: getName, reason: from getter */
    public String getM() {
        return this.m;
    }

    public int hashCode() {
        return (((getF23147k().hashCode() * 31) + getM().hashCode()) * 31) + this.n.hashCode();
    }

    @Override // kotlin.reflect.KProperty
    public boolean isConst() {
        return F().isConst();
    }

    @Override // kotlin.reflect.KProperty
    public boolean isLateinit() {
        return F().s0();
    }

    @Override // kotlin.reflect.KCallable
    public boolean isSuspend() {
        return false;
    }

    public String toString() {
        return ReflectionObjectRenderer.a.g(F());
    }

    @Override // kotlin.reflect.y.internal.KCallableImpl
    public Caller<?> z() {
        return getGetter().z();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KPropertyImpl(KDeclarationContainerImpl kDeclarationContainerImpl, String str, String str2, Object obj) {
        this(kDeclarationContainerImpl, str, str2, null, obj);
        m.f(kDeclarationContainerImpl, "container");
        m.f(str, "name");
        m.f(str2, RoomInstalled.SIGNATURE);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public KPropertyImpl(KDeclarationContainerImpl kDeclarationContainerImpl, t0 t0Var) {
        m.f(kDeclarationContainerImpl, "container");
        m.f(t0Var, "descriptor");
        String strK = t0Var.getName().k();
        m.e(strK, "descriptor.name.asString()");
        this(kDeclarationContainerImpl, strK, RuntimeTypeMapper.a.f(t0Var).getF23039f(), t0Var, kotlin.jvm.internal.c.NO_RECEIVER);
    }
}
