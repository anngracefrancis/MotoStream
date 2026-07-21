package kotlin.text;

import java.util.Iterator;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.collections.AbstractCollection;
import kotlin.collections.AbstractList;
import kotlin.collections.c0;
import kotlin.collections.u;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.ranges.IntRange;
import kotlin.sequences.n;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlin.h0.i, reason: from Kotlin metadata */
/* JADX INFO: compiled from: Regex.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\n\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u0016R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lkotlin/text/MatcherMatchResult;", "Lkotlin/text/MatchResult;", "matcher", "Ljava/util/regex/Matcher;", "input", HttpUrl.FRAGMENT_ENCODE_SET, "(Ljava/util/regex/Matcher;Ljava/lang/CharSequence;)V", "groupValues", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "getGroupValues", "()Ljava/util/List;", "groupValues_", "groups", "Lkotlin/text/MatchGroupCollection;", "getGroups", "()Lkotlin/text/MatchGroupCollection;", "matchResult", "Ljava/util/regex/MatchResult;", "getMatchResult", "()Ljava/util/regex/MatchResult;", "range", "Lkotlin/ranges/IntRange;", "getRange", "()Lkotlin/ranges/IntRange;", "value", "getValue", "()Ljava/lang/String;", "next", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class MatcherMatchResult implements MatchResult {
    private final Matcher a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CharSequence f25072b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MatchGroupCollection f25073c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<String> f25074d;

    /* JADX INFO: renamed from: kotlin.h0.i$a */
    /* JADX INFO: compiled from: Regex.kt */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0096\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"kotlin/text/MatcherMatchResult$groupValues$1", "Lkotlin/collections/AbstractList;", HttpUrl.FRAGMENT_ENCODE_SET, "size", HttpUrl.FRAGMENT_ENCODE_SET, "getSize", "()I", "get", "index", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a extends AbstractList<String> {
        a() {
        }

        @Override // kotlin.collections.AbstractCollection
        /* JADX INFO: renamed from: c */
        public int getF25541i() {
            return MatcherMatchResult.this.d().groupCount() + 1;
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof String) {
                return f((String) obj);
            }
            return false;
        }

        public /* bridge */ boolean f(String str) {
            return super.contains(str);
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public String get(int i2) {
            String strGroup = MatcherMatchResult.this.d().group(i2);
            return strGroup == null ? HttpUrl.FRAGMENT_ENCODE_SET : strGroup;
        }

        public /* bridge */ int i(String str) {
            return super.indexOf(str);
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof String) {
                return i((String) obj);
            }
            return -1;
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof String) {
                return n((String) obj);
            }
            return -1;
        }

        public /* bridge */ int n(String str) {
            return super.lastIndexOf(str);
        }
    }

    /* JADX INFO: renamed from: kotlin.h0.i$b */
    /* JADX INFO: compiled from: Regex.kt */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002J\u0013\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\u0005H\u0096\u0002J\u0013\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\u0011\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000fH\u0096\u0002R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"kotlin/text/MatcherMatchResult$groups$1", "Lkotlin/text/MatchNamedGroupCollection;", "Lkotlin/collections/AbstractCollection;", "Lkotlin/text/MatchGroup;", "size", HttpUrl.FRAGMENT_ENCODE_SET, "getSize", "()I", "get", "index", "name", HttpUrl.FRAGMENT_ENCODE_SET, "isEmpty", HttpUrl.FRAGMENT_ENCODE_SET, "iterator", HttpUrl.FRAGMENT_ENCODE_SET, "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b extends AbstractCollection<MatchGroup> implements MatchGroupCollection {

        /* JADX INFO: renamed from: kotlin.h0.i$b$a */
        /* JADX INFO: compiled from: Regex.kt */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lkotlin/text/MatchGroup;", "it", HttpUrl.FRAGMENT_ENCODE_SET, "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class a extends Lambda implements Function1<Integer, MatchGroup> {
            a() {
                super(1);
            }

            public final MatchGroup b(int i2) {
                return b.this.h(i2);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ MatchGroup invoke(Integer num) {
                return b(num.intValue());
            }
        }

        b() {
        }

        @Override // kotlin.collections.AbstractCollection
        /* JADX INFO: renamed from: c */
        public int getF25541i() {
            return MatcherMatchResult.this.d().groupCount() + 1;
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj == null ? true : obj instanceof MatchGroup) {
                return f((MatchGroup) obj);
            }
            return false;
        }

        public /* bridge */ boolean f(MatchGroup matchGroup) {
            return super.contains(matchGroup);
        }

        public MatchGroup h(int i2) {
            IntRange intRangeD = k.d(MatcherMatchResult.this.d(), i2);
            if (intRangeD.r().intValue() < 0) {
                return null;
            }
            String strGroup = MatcherMatchResult.this.d().group(i2);
            m.e(strGroup, "matchResult.group(index)");
            return new MatchGroup(strGroup, intRangeD);
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<MatchGroup> iterator() {
            return n.u(c0.J(u.k(this)), new a()).iterator();
        }
    }

    public MatcherMatchResult(Matcher matcher, CharSequence charSequence) {
        m.f(matcher, "matcher");
        m.f(charSequence, "input");
        this.a = matcher;
        this.f25072b = charSequence;
        this.f25073c = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MatchResult d() {
        return this.a;
    }

    @Override // kotlin.text.MatchResult
    public MatchResult.b a() {
        return MatchResult.a.a(this);
    }

    @Override // kotlin.text.MatchResult
    public List<String> b() {
        if (this.f25074d == null) {
            this.f25074d = new a();
        }
        List<String> list = this.f25074d;
        m.c(list);
        return list;
    }
}
