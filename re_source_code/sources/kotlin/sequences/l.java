package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.n;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import okhttp3.HttpUrl;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u001c\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\u001a.\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0014\b\u0004\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004H\u0087\bø\u0001\u0000\u001a\u0012\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002\u001ab\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\b0\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\t\"\u0004\b\u0002\u0010\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\t0\f2\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u0002H\t\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00050\u000eH\u0000\u001a&\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00102\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0004\u001a<\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00102\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u00042\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u000e\u001a=\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u0001H\u00022\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u000eH\u0007¢\u0006\u0002\u0010\u0014\u001a+\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0017\"\u0002H\u0002¢\u0006\u0002\u0010\u0018\u001a\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0005\u001a\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001\u001aC\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\b0\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\b*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00050\u000eH\u0002¢\u0006\u0002\b\u001c\u001a)\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u001d0\u0001H\u0007¢\u0006\u0002\b\u001e\u001a\"\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0001\u001a2\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0004H\u0007\u001a!\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001H\u0087\b\u001a\u001e\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0007\u001a&\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010#\u001a\u00020$H\u0007\u001a@\u0010%\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0'0&\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\b*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\b0&0\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006("}, d2 = {"Sequence", "Lkotlin/sequences/Sequence;", "T", "iterator", "Lkotlin/Function0;", HttpUrl.FRAGMENT_ENCODE_SET, "emptySequence", "flatMapIndexed", "R", "C", "source", "transform", "Lkotlin/Function2;", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlin/Function1;", "generateSequence", HttpUrl.FRAGMENT_ENCODE_SET, "nextFunction", "seedFunction", "seed", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;", "sequenceOf", "elements", HttpUrl.FRAGMENT_ENCODE_SET, "([Ljava/lang/Object;)Lkotlin/sequences/Sequence;", "asSequence", "constrainOnce", "flatten", "flatten$SequencesKt__SequencesKt", HttpUrl.FRAGMENT_ENCODE_SET, "flattenSequenceOfIterable", "ifEmpty", "defaultValue", "orEmpty", "shuffled", "random", "Lkotlin/random/Random;", "unzip", "Lkotlin/Pair;", HttpUrl.FRAGMENT_ENCODE_SET, "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/sequences/SequencesKt")
public class l extends k {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: Sequences.kt */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096\u0002¨\u0006\u0004¸\u0006\u0000"}, d2 = {"kotlin/sequences/SequencesKt__SequencesKt$Sequence$1", "Lkotlin/sequences/Sequence;", "iterator", HttpUrl.FRAGMENT_ENCODE_SET, "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a<T> implements Sequence<T> {
        final /* synthetic */ Iterator a;

        public a(Iterator it) {
            this.a = it;
        }

        @Override // kotlin.sequences.Sequence
        public Iterator<T> iterator() {
            return this.a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: Sequences.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "T", "it", "Lkotlin/sequences/Sequence;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    static final class b<T> extends Lambda implements Function1<Sequence<? extends T>, Iterator<? extends T>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f25039f = new b();

        b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Iterator<T> invoke(Sequence<? extends T> sequence) {
            m.f(sequence, "it");
            return sequence.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: Sequences.kt */
    @Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0006\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "T", "R", "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    static final class c<T> extends Lambda implements Function1<T, T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final c f25040f = new c();

        c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final T invoke(T t) {
            return t;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: Sequences.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u0002H\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "T", HttpUrl.FRAGMENT_ENCODE_SET, "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    static final class d<T> extends Lambda implements Function1<T, T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Function0<T> f25041f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        d(Function0<? extends T> function0) {
            super(1);
            this.f25041f = function0;
        }

        @Override // kotlin.jvm.functions.Function1
        public final T invoke(T t) {
            m.f(t, "it");
            return this.f25041f.invoke();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: Sequences.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "T", HttpUrl.FRAGMENT_ENCODE_SET, "invoke", "()Ljava/lang/Object;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    static final class e<T> extends Lambda implements Function0<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ T f25042f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(T t) {
            super(0);
            this.f25042f = t;
        }

        @Override // kotlin.jvm.functions.Function0
        public final T invoke() {
            return this.f25042f;
        }
    }

    public static <T> Sequence<T> a(Iterator<? extends T> it) {
        m.f(it, "<this>");
        return b(new a(it));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Sequence<T> b(Sequence<? extends T> sequence) {
        m.f(sequence, "<this>");
        return sequence instanceof ConstrainedOnceSequence ? sequence : new ConstrainedOnceSequence(sequence);
    }

    public static <T> Sequence<T> c() {
        return EmptySequence.a;
    }

    public static final <T> Sequence<T> d(Sequence<? extends Sequence<? extends T>> sequence) {
        m.f(sequence, "<this>");
        return e(sequence, b.f25039f);
    }

    private static final <T, R> Sequence<R> e(Sequence<? extends T> sequence, Function1<? super T, ? extends Iterator<? extends R>> function1) {
        return sequence instanceof TransformingSequence ? ((TransformingSequence) sequence).d(function1) : new FlatteningSequence(sequence, c.f25040f, function1);
    }

    public static <T> Sequence<T> f(T t, Function1<? super T, ? extends T> function1) {
        m.f(function1, "nextFunction");
        return t == null ? EmptySequence.a : new GeneratorSequence(new e(t), function1);
    }

    public static <T> Sequence<T> g(Function0<? extends T> function0) {
        m.f(function0, "nextFunction");
        return b(new GeneratorSequence(function0, new d(function0)));
    }

    public static final <T> Sequence<T> h(T... tArr) {
        m.f(tArr, "elements");
        return tArr.length == 0 ? c() : n.r(tArr);
    }
}
