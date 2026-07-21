package androidx.datastore.core;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.f0;
import kotlin.o;
import kotlin.p003y.Continuation;
import kotlin.p003y.j.p004a.ContinuationImpl;
import kotlin.p003y.j.p004a.DebugMetadata;
import kotlin.p003y.j.p004a.SuspendLambda;
import kotlin.u;

/* JADX INFO: compiled from: DataMigrationInitializer.kt */
/* JADX INFO: loaded from: classes.dex */
public final class d<T> {
    public static final a a = new a(null);

    /* JADX INFO: compiled from: DataMigrationInitializer.kt */
    public static final class a {

        /* JADX INFO: renamed from: androidx.datastore.core.d$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: DataMigrationInitializer.kt */
        @DebugMetadata(c = "androidx.datastore.core.DataMigrationInitializer$Companion$getInitializer$1", f = "DataMigrationInitializer.kt", l = {33}, m = "invokeSuspend")
        static final class C0027a extends SuspendLambda implements Function2<h<T>, Continuation<? super u>, Object> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            int f1129f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            /* synthetic */ Object f1130g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ List<androidx.datastore.core.c<T>> f1131h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C0027a(List<? extends androidx.datastore.core.c<T>> list, Continuation<? super C0027a> continuation) {
                super(2, continuation);
                this.f1131h = list;
            }

            @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
            public final Continuation<u> create(Object obj, Continuation<?> continuation) {
                C0027a c0027a = new C0027a(this.f1131h, continuation);
                c0027a.f1130g = obj;
                return c0027a;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
            public final Object invoke(h<T> hVar, Continuation<? super u> continuation) {
                return ((C0027a) create(hVar, continuation)).invokeSuspend(u.a);
            }

            @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objC = kotlin.p003y.intrinsics.d.c();
                int i2 = this.f1129f;
                if (i2 == 0) {
                    o.b(obj);
                    h hVar = (h) this.f1130g;
                    a aVar = d.a;
                    List<androidx.datastore.core.c<T>> list = this.f1131h;
                    this.f1129f = 1;
                    if (aVar.c(list, hVar, this) == objC) {
                        return objC;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    o.b(obj);
                }
                return u.a;
            }
        }

        /* JADX INFO: compiled from: DataMigrationInitializer.kt */
        @DebugMetadata(c = "androidx.datastore.core.DataMigrationInitializer$Companion", f = "DataMigrationInitializer.kt", l = {42, 57}, m = "runMigrations")
        static final class b<T> extends ContinuationImpl {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            Object f1132f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            Object f1133g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            /* synthetic */ Object f1134h;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            int f1136j;

            b(Continuation<? super b> continuation) {
                super(continuation);
            }

            @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.f1134h = obj;
                this.f1136j |= Integer.MIN_VALUE;
                return a.this.c(null, null, this);
            }
        }

        /* JADX INFO: compiled from: DataMigrationInitializer.kt */
        @DebugMetadata(c = "androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2", f = "DataMigrationInitializer.kt", l = {44, 46}, m = "invokeSuspend")
        static final class c extends SuspendLambda implements Function2<T, Continuation<? super T>, Object> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            Object f1137f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            Object f1138g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            Object f1139h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            int f1140i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            /* synthetic */ Object f1141j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            final /* synthetic */ List<androidx.datastore.core.c<T>> f1142k;
            final /* synthetic */ List<Function1<Continuation<? super u>, Object>> l;

            /* JADX INFO: renamed from: androidx.datastore.core.d$a$c$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: DataMigrationInitializer.kt */
            @DebugMetadata(c = "androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2$1$1", f = "DataMigrationInitializer.kt", l = {45}, m = "invokeSuspend")
            static final class C0028a extends SuspendLambda implements Function1<Continuation<? super u>, Object> {

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                int f1143f;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                final /* synthetic */ androidx.datastore.core.c<T> f1144g;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0028a(androidx.datastore.core.c<T> cVar, Continuation<? super C0028a> continuation) {
                    super(1, continuation);
                    this.f1144g = cVar;
                }

                @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
                public final Continuation<u> create(Continuation<?> continuation) {
                    return new C0028a(this.f1144g, continuation);
                }

                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
                public final Object invoke(Continuation<? super u> continuation) {
                    return ((C0028a) create(continuation)).invokeSuspend(u.a);
                }

                @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object objC = kotlin.p003y.intrinsics.d.c();
                    int i2 = this.f1143f;
                    if (i2 == 0) {
                        o.b(obj);
                        androidx.datastore.core.c<T> cVar = this.f1144g;
                        this.f1143f = 1;
                        if (cVar.a(this) == objC) {
                            return objC;
                        }
                    } else {
                        if (i2 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        o.b(obj);
                    }
                    return u.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            c(List<? extends androidx.datastore.core.c<T>> list, List<Function1<Continuation<? super u>, Object>> list2, Continuation<? super c> continuation) {
                super(2, continuation);
                this.f1142k = list;
                this.l = list2;
            }

            @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
            public final Continuation<u> create(Object obj, Continuation<?> continuation) {
                c cVar = new c(this.f1142k, this.l, continuation);
                cVar.f1141j = obj;
                return cVar;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
            public final Object invoke(T t, Continuation<? super T> continuation) {
                return ((c) create(t, continuation)).invokeSuspend(u.a);
            }

            /* JADX WARN: Code duplicated, block: B:13:0x004e  */
            /* JADX WARN: Code duplicated, block: B:15:0x0064 A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:16:0x0065  */
            /* JADX WARN: Code duplicated, block: B:19:0x0072  */
            /* JADX WARN: Code duplicated, block: B:21:0x008b A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:23:0x008e  */
            /* JADX WARN: Code duplicated, block: B:24:0x008f  */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
            public final java.lang.Object invokeSuspend(java.lang.Object r11) {
                /*
                    r10 = this;
                    java.lang.Object r0 = kotlin.p003y.intrinsics.b.c()
                    int r1 = r10.f1140i
                    r2 = 2
                    r3 = 1
                    if (r1 == 0) goto L3a
                    if (r1 == r3) goto L24
                    if (r1 != r2) goto L1c
                    java.lang.Object r1 = r10.f1137f
                    java.util.Iterator r1 = (java.util.Iterator) r1
                    java.lang.Object r4 = r10.f1141j
                    java.util.List r4 = (java.util.List) r4
                    kotlin.o.b(r11)
                    r7 = r10
                    goto L8c
                L1c:
                    java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r11.<init>(r0)
                    throw r11
                L24:
                    java.lang.Object r1 = r10.f1139h
                    java.lang.Object r4 = r10.f1138g
                    androidx.datastore.core.c r4 = (androidx.datastore.core.c) r4
                    java.lang.Object r5 = r10.f1137f
                    java.util.Iterator r5 = (java.util.Iterator) r5
                    java.lang.Object r6 = r10.f1141j
                    java.util.List r6 = (java.util.List) r6
                    kotlin.o.b(r11)
                    r7 = r10
                    r9 = r6
                    r6 = r4
                    r4 = r9
                    goto L6a
                L3a:
                    kotlin.o.b(r11)
                    java.lang.Object r11 = r10.f1141j
                    java.util.List<androidx.datastore.core.c<T>> r1 = r10.f1142k
                    java.util.List<kotlin.a0.c.l<kotlin.y.d<? super kotlin.u>, java.lang.Object>> r4 = r10.l
                    java.util.Iterator r1 = r1.iterator()
                    r5 = r10
                L48:
                    boolean r6 = r1.hasNext()
                    if (r6 == 0) goto L91
                    java.lang.Object r6 = r1.next()
                    androidx.datastore.core.c r6 = (androidx.datastore.core.c) r6
                    r5.f1141j = r4
                    r5.f1137f = r1
                    r5.f1138g = r6
                    r5.f1139h = r11
                    r5.f1140i = r3
                    java.lang.Object r7 = r6.b(r11, r5)
                    if (r7 != r0) goto L65
                    return r0
                L65:
                    r9 = r1
                    r1 = r11
                    r11 = r7
                    r7 = r5
                    r5 = r9
                L6a:
                    java.lang.Boolean r11 = (java.lang.Boolean) r11
                    boolean r11 = r11.booleanValue()
                    if (r11 == 0) goto L8e
                    androidx.datastore.core.d$a$c$a r11 = new androidx.datastore.core.d$a$c$a
                    r8 = 0
                    r11.<init>(r6, r8)
                    r4.add(r11)
                    r7.f1141j = r4
                    r7.f1137f = r5
                    r7.f1138g = r8
                    r7.f1139h = r8
                    r7.f1140i = r2
                    java.lang.Object r11 = r6.c(r1, r7)
                    if (r11 != r0) goto L8f
                    return r0
                L8c:
                    r5 = r7
                    goto L48
                L8e:
                    r11 = r1
                L8f:
                    r1 = r5
                    goto L8c
                L91:
                    return r11
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.d.a.c.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code duplicated, block: B:27:0x006f  */
        /* JADX WARN: Code duplicated, block: B:37:0x009a  */
        /* JADX WARN: Code duplicated, block: B:40:0x009e  */
        /* JADX WARN: Code duplicated, block: B:45:0x0081 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:47:? A[LOOP:0: B:25:0x0069->B:47:?, LOOP_END, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        /* JADX WARN: Type inference failed for: r9v3, types: [T, java.lang.Throwable] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0086 -> B:25:0x0069). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0089 -> B:25:0x0069). Please report as a decompilation issue!!! */
        public final <T> Object c(List<? extends androidx.datastore.core.c<T>> list, h<T> hVar, Continuation<? super u> continuation) throws Throwable {
            b bVar;
            List list2;
            f0 f0Var;
            Iterator<T> it;
            Throwable th;
            Function1 function1;
            if (continuation instanceof b) {
                bVar = (b) continuation;
                int i2 = bVar.f1136j;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    bVar.f1136j = i2 - Integer.MIN_VALUE;
                } else {
                    bVar = new b(continuation);
                }
            } else {
                bVar = new b(continuation);
            }
            Object obj = bVar.f1134h;
            Object objC = kotlin.p003y.intrinsics.d.c();
            int i3 = bVar.f1136j;
            if (i3 != 0) {
                if (i3 == 1) {
                    list2 = (List) bVar.f1132f;
                    o.b(obj);
                } else {
                    if (i3 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    it = (Iterator) bVar.f1133g;
                    f0Var = (f0) bVar.f1132f;
                    try {
                        o.b(obj);
                    } catch (Throwable 
                    /*  JADX ERROR: Method code generation error
                        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getCodeVar()" because "ssaVar" is null
                        	at jadx.core.codegen.RegionGen.makeCatchBlock(RegionGen.java:372)
                        	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:335)
                        	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:140)
                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:299)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                        	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                        	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:297)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                        	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
                        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                        	at jadx.core.ProcessClass.process(ProcessClass.java:89)
                        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
                        	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
                        	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
                        */
                    /*
                        this = this;
                        boolean r0 = r9 instanceof androidx.datastore.core.d.a.b
                        if (r0 == 0) goto L13
                        r0 = r9
                        androidx.datastore.core.d$a$b r0 = (androidx.datastore.core.d.a.b) r0
                        int r1 = r0.f1136j
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f1136j = r1
                        goto L18
                    L13:
                        androidx.datastore.core.d$a$b r0 = new androidx.datastore.core.d$a$b
                        r0.<init>(r9)
                    L18:
                        java.lang.Object r9 = r0.f1134h
                        java.lang.Object r1 = kotlin.p003y.intrinsics.b.c()
                        int r2 = r0.f1136j
                        r3 = 2
                        r4 = 1
                        if (r2 == 0) goto L46
                        if (r2 == r4) goto L3e
                        if (r2 != r3) goto L36
                        java.lang.Object r7 = r0.f1133g
                        java.util.Iterator r7 = (java.util.Iterator) r7
                        java.lang.Object r8 = r0.f1132f
                        kotlin.a0.d.f0 r8 = (kotlin.jvm.internal.f0) r8
                        kotlin.o.b(r9)     // Catch: java.lang.Throwable -> L34
                        goto L69
                    L34:
                        r9 = move-exception
                        goto L82
                    L36:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r8)
                        throw r7
                    L3e:
                        java.lang.Object r7 = r0.f1132f
                        java.util.List r7 = (java.util.List) r7
                        kotlin.o.b(r9)
                        goto L60
                    L46:
                        kotlin.o.b(r9)
                        java.util.ArrayList r9 = new java.util.ArrayList
                        r9.<init>()
                        androidx.datastore.core.d$a$c r2 = new androidx.datastore.core.d$a$c
                        r5 = 0
                        r2.<init>(r7, r9, r5)
                        r0.f1132f = r9
                        r0.f1136j = r4
                        java.lang.Object r7 = r8.a(r2, r0)
                        if (r7 != r1) goto L5f
                        return r1
                    L5f:
                        r7 = r9
                    L60:
                        kotlin.a0.d.f0 r8 = new kotlin.a0.d.f0
                        r8.<init>()
                        java.util.Iterator r7 = r7.iterator()
                    L69:
                        boolean r9 = r7.hasNext()
                        if (r9 == 0) goto L94
                        java.lang.Object r9 = r7.next()
                        kotlin.a0.c.l r9 = (kotlin.jvm.functions.Function1) r9
                        r0.f1132f = r8     // Catch: java.lang.Throwable -> L34
                        r0.f1133g = r7     // Catch: java.lang.Throwable -> L34
                        r0.f1136j = r3     // Catch: java.lang.Throwable -> L34
                        java.lang.Object r9 = r9.invoke(r0)     // Catch: java.lang.Throwable -> L34
                        if (r9 != r1) goto L69
                        return r1
                    L82:
                        T r2 = r8.f22943f
                        if (r2 != 0) goto L89
                        r8.f22943f = r9
                        goto L69
                    L89:
                        kotlin.jvm.internal.m.c(r2)
                        T r2 = r8.f22943f
                        java.lang.Throwable r2 = (java.lang.Throwable) r2
                        kotlin.a.a(r2, r9)
                        goto L69
                    L94:
                        T r7 = r8.f22943f
                        java.lang.Throwable r7 = (java.lang.Throwable) r7
                        if (r7 != 0) goto L9d
                        kotlin.u r7 = kotlin.u.a
                        return r7
                    L9d:
                        goto L9f
                    L9e:
                        throw r7
                    L9f:
                        goto L9e
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.d.a.c(java.util.List, androidx.datastore.core.h, kotlin.y.d):java.lang.Object");
                }

                public final <T> Function2<h<T>, Continuation<? super u>, Object> b(List<? extends androidx.datastore.core.c<T>> list) {
                    kotlin.jvm.internal.m.f(list, "migrations");
                    return new C0027a(list, null);
                }
            }
        }
