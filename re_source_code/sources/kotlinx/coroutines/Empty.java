package kotlinx.coroutines;

import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlinx.coroutines.h1, reason: from Kotlin metadata */
/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/Empty;", "Lkotlinx/coroutines/Incomplete;", "isActive", HttpUrl.FRAGMENT_ENCODE_SET, "(Z)V", "()Z", "list", "Lkotlinx/coroutines/NodeList;", "getList", "()Lkotlinx/coroutines/NodeList;", "toString", HttpUrl.FRAGMENT_ENCODE_SET, "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class Empty implements Incomplete {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f25782f;

    public Empty(boolean z) {
        this.f25782f = z;
    }

    @Override // kotlinx.coroutines.Incomplete
    /* JADX INFO: renamed from: b, reason: from getter */
    public boolean getF25782f() {
        return this.f25782f;
    }

    @Override // kotlinx.coroutines.Incomplete
    public NodeList e() {
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empty{");
        sb.append(getF25782f() ? "Active" : "New");
        sb.append('}');
        return sb.toString();
    }
}
