package kotlinx.coroutines;

import cm.aptoide.pt.DeepLinkIntentReceiver;
import kotlin.Metadata;
import kotlin.p003y.AbstractCoroutineContextElement;
import kotlin.p003y.CoroutineContext;
import okhttp3.HttpUrl;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* JADX INFO: renamed from: kotlinx.coroutines.m0, reason: from Kotlin metadata and from toString */
/* JADX INFO: compiled from: CoroutineContext.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0081\b\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0018B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\t\u001a\u00020\u0005HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0019"}, d2 = {"Lkotlinx/coroutines/CoroutineId;", "Lkotlinx/coroutines/ThreadContextElement;", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlin/coroutines/AbstractCoroutineContextElement;", DeepLinkIntentReceiver.DeepLinksKeys.ID, HttpUrl.FRAGMENT_ENCODE_SET, "(J)V", "getId", "()J", "component1", "copy", "equals", HttpUrl.FRAGMENT_ENCODE_SET, "other", HttpUrl.FRAGMENT_ENCODE_SET, "hashCode", HttpUrl.FRAGMENT_ENCODE_SET, "restoreThreadContext", HttpUrl.FRAGMENT_ENCODE_SET, "context", "Lkotlin/coroutines/CoroutineContext;", "oldState", "toString", "updateThreadContext", "Key", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
@IgnoreJRERequirement
public final /* data */ class CoroutineId extends AbstractCoroutineContextElement implements ThreadContextElement<String> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f25853f = new a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f25854g;

    /* JADX INFO: renamed from: kotlinx.coroutines.m0$a */
    /* JADX INFO: compiled from: CoroutineContext.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkotlinx/coroutines/CoroutineId$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlinx/coroutines/CoroutineId;", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a implements CoroutineContext.c<CoroutineId> {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public CoroutineId(long j2) {
        super(f25853f);
        this.f25854g = j2;
    }

    /* JADX INFO: renamed from: K, reason: from getter */
    public final long getF25854g() {
        return this.f25854g;
    }

    @Override // kotlinx.coroutines.ThreadContextElement
    /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
    public void z(CoroutineContext coroutineContext, String str) {
        Thread.currentThread().setName(str);
    }

    @Override // kotlinx.coroutines.ThreadContextElement
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public String I(CoroutineContext coroutineContext) {
        String f25857g;
        CoroutineName coroutineName = (CoroutineName) coroutineContext.get(CoroutineName.f25856f);
        if (coroutineName == null || (f25857g = coroutineName.getF25857g()) == null) {
            f25857g = "coroutine";
        }
        Thread threadCurrentThread = Thread.currentThread();
        String name = threadCurrentThread.getName();
        int iB0 = kotlin.text.v.b0(name, " @", 0, false, 6, null);
        if (iB0 < 0) {
            iB0 = name.length();
        }
        StringBuilder sb = new StringBuilder(f25857g.length() + iB0 + 10);
        String strSubstring = name.substring(0, iB0);
        kotlin.jvm.internal.m.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        sb.append(strSubstring);
        sb.append(" @");
        sb.append(f25857g);
        sb.append('#');
        sb.append(this.f25854g);
        String string = sb.toString();
        kotlin.jvm.internal.m.e(string, "StringBuilder(capacity).…builderAction).toString()");
        threadCurrentThread.setName(string);
        return name;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof CoroutineId) && this.f25854g == ((CoroutineId) other).f25854g;
    }

    public int hashCode() {
        return cm.aptoide.pt.aab.a.a(this.f25854g);
    }

    public String toString() {
        return "CoroutineId(" + this.f25854g + ')';
    }
}
