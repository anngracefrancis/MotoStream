package kotlinx.coroutines;

import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlinx.coroutines.s1, reason: from Kotlin metadata */
/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/InactiveNodeList;", "Lkotlinx/coroutines/Incomplete;", "list", "Lkotlinx/coroutines/NodeList;", "(Lkotlinx/coroutines/NodeList;)V", "isActive", HttpUrl.FRAGMENT_ENCODE_SET, "()Z", "getList", "()Lkotlinx/coroutines/NodeList;", "toString", HttpUrl.FRAGMENT_ENCODE_SET, "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class InactiveNodeList implements Incomplete {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final NodeList f25879f;

    public InactiveNodeList(NodeList nodeList) {
        this.f25879f = nodeList;
    }

    @Override // kotlinx.coroutines.Incomplete
    /* JADX INFO: renamed from: b */
    public boolean getF25782f() {
        return false;
    }

    @Override // kotlinx.coroutines.Incomplete
    /* JADX INFO: renamed from: e, reason: from getter */
    public NodeList getF25879f() {
        return this.f25879f;
    }

    public String toString() {
        return s0.c() ? getF25879f().G("New") : super.toString();
    }
}
