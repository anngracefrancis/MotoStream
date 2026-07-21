package kotlinx.coroutines.p005z2;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.c0;
import kotlin.o;
import kotlin.p003y.Continuation;
import kotlin.p003y.intrinsics.d;
import kotlin.p003y.j.p004a.ContinuationImpl;
import kotlin.p003y.j.p004a.DebugMetadata;
import kotlin.u;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: Limit.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aV\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000323\b\u0004\u0010\u0004\u001a-\b\u0001\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0005H\u0080Hø\u0001\u0000¢\u0006\u0002\u0010\f\u001a$\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f\u001aH\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\"\u0010\u0004\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0005ø\u0001\u0000¢\u0006\u0002\u0010\u0011\u001a+\u0010\u0012\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00132\u0006\u0010\b\u001a\u0002H\u0002H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a$\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f\u001aH\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\"\u0010\u0004\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0005ø\u0001\u0000¢\u0006\u0002\u0010\u0011\u001ap\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00190\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0019*\b\u0012\u0004\u0012\u0002H\u00020\u00032D\b\u0001\u0010\u001a\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00190\u0013\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u001b¢\u0006\u0002\b\u001cø\u0001\u0000¢\u0006\u0002\u0010\u001d\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"collectWhile", HttpUrl.FRAGMENT_ENCODE_SET, "T", "Lkotlinx/coroutines/flow/Flow;", "predicate", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "value", "Lkotlin/coroutines/Continuation;", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "drop", "count", HttpUrl.FRAGMENT_ENCODE_SET, "dropWhile", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "emitAbort", "Lkotlinx/coroutines/flow/FlowCollector;", "emitAbort$FlowKt__LimitKt", "(Lkotlinx/coroutines/flow/FlowCollector;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "take", "takeWhile", "transformWhile", "R", "transform", "Lkotlin/Function3;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 6, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
final /* synthetic */ class i {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: SafeCollector.common.kt */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", HttpUrl.FRAGMENT_ENCODE_SET, "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a<T> implements Flow<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Flow f25915f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Function2 f25916g;

        public a(Flow flow, Function2 function2) {
            this.f25915f = flow;
            this.f25916g = function2;
        }

        @Override // kotlinx.coroutines.p005z2.Flow
        public Object a(FlowCollector<? super T> flowCollector, Continuation<? super u> continuation) {
            Object objA = this.f25915f.a(new b(new c0(), flowCollector, this.f25916g), continuation);
            return objA == d.c() ? objA : u.a;
        }
    }

    /* JADX INFO: compiled from: Limit.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "T", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class b<T> implements FlowCollector {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ c0 f25917f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ FlowCollector<T> f25918g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ Function2<T, Continuation<? super Boolean>, Object> f25919h;

        /* JADX INFO: compiled from: Limit.kt */
        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1", f = "Limit.kt", l = {37, 38, 40}, m = "emit")
        static final class a extends ContinuationImpl {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            Object f25920f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            Object f25921g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            /* synthetic */ Object f25922h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            final /* synthetic */ b<T> f25923i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            int f25924j;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            a(b<? super T> bVar, Continuation<? super a> continuation) {
                super(continuation);
                this.f25923i = bVar;
            }

            @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.f25922h = obj;
                this.f25924j |= Integer.MIN_VALUE;
                return this.f25923i.c(null, this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        b(c0 c0Var, FlowCollector<? super T> flowCollector, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2) {
            this.f25917f = c0Var;
            this.f25918g = flowCollector;
            this.f25919h = function2;
        }

        /* JADX WARN: Code duplicated, block: B:31:0x0074  */
        /* JADX WARN: Code duplicated, block: B:33:0x0087 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:36:0x008b  */
        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // kotlinx.coroutines.p005z2.FlowCollector
        public final Object c(T t, Continuation<? super u> continuation) throws Throwable {
            a aVar;
            b<T> bVar;
            FlowCollector<T> flowCollector;
            if (continuation instanceof a) {
                aVar = (a) continuation;
                int i2 = aVar.f25924j;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    aVar.f25924j = i2 - Integer.MIN_VALUE;
                } else {
                    aVar = new a(this, continuation);
                }
            } else {
                aVar = new a(this, continuation);
            }
            Object objInvoke = aVar.f25922h;
            Object objC = d.c();
            int i3 = aVar.f25924j;
            if (i3 == 0) {
                o.b(objInvoke);
                if (this.f25917f.f22934f) {
                    FlowCollector<T> flowCollector2 = this.f25918g;
                    aVar.f25924j = 1;
                    if (flowCollector2.c(t, aVar) == objC) {
                        return objC;
                    }
                    return u.a;
                }
                Function2<T, Continuation<? super Boolean>, Object> function2 = this.f25919h;
                aVar.f25920f = this;
                aVar.f25921g = t;
                aVar.f25924j = 2;
                objInvoke = function2.invoke(t, aVar);
                if (objInvoke == objC) {
                    return objC;
                }
                bVar = this;
                if (!((Boolean) objInvoke).booleanValue()) {
                    return u.a;
                }
                bVar.f25917f.f22934f = true;
                flowCollector = bVar.f25918g;
                aVar.f25920f = null;
                aVar.f25921g = null;
                aVar.f25924j = 3;
                if (flowCollector.c(t, aVar) == objC) {
                    return objC;
                }
            } else {
                if (i3 == 1) {
                    o.b(objInvoke);
                    return u.a;
                }
                if (i3 == 2) {
                    t = (T) aVar.f25921g;
                    bVar = (b) aVar.f25920f;
                    o.b(objInvoke);
                    if (!((Boolean) objInvoke).booleanValue()) {
                        return u.a;
                    }
                    bVar.f25917f.f22934f = true;
                    flowCollector = bVar.f25918g;
                    aVar.f25920f = null;
                    aVar.f25921g = null;
                    aVar.f25924j = 3;
                    if (flowCollector.c(t, aVar) == objC) {
                        return objC;
                    }
                } else {
                    if (i3 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    o.b(objInvoke);
                }
            }
            return u.a;
        }
    }

    public static final <T> Flow<T> a(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return new a(flow, function2);
    }
}
