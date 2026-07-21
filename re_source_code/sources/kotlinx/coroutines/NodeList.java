package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlinx.coroutines.j2, reason: from Kotlin metadata */
/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bJ\b\u0010\r\u001a\u00020\u000bH\u0016R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/NodeList;", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "Lkotlinx/coroutines/Incomplete;", "()V", "isActive", HttpUrl.FRAGMENT_ENCODE_SET, "()Z", "list", "getList", "()Lkotlinx/coroutines/NodeList;", "getString", HttpUrl.FRAGMENT_ENCODE_SET, "state", "toString", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NodeList extends LockFreeLinkedListHead implements Incomplete {
    public final String G(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("List{");
        sb.append(str);
        sb.append("}[");
        boolean z = true;
        for (LockFreeLinkedListNode lockFreeLinkedListNodeR = (LockFreeLinkedListNode) q(); !kotlin.jvm.internal.m.a(lockFreeLinkedListNodeR, this); lockFreeLinkedListNodeR = lockFreeLinkedListNodeR.r()) {
            if (lockFreeLinkedListNodeR instanceof JobNode) {
                JobNode jobNode = (JobNode) lockFreeLinkedListNodeR;
                if (z) {
                    z = false;
                } else {
                    sb.append(", ");
                }
                sb.append(jobNode);
            }
        }
        sb.append("]");
        String string = sb.toString();
        kotlin.jvm.internal.m.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @Override // kotlinx.coroutines.Incomplete
    public boolean b() {
        return true;
    }

    @Override // kotlinx.coroutines.Incomplete
    public NodeList e() {
        return this;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public String toString() {
        return s0.c() ? G("Active") : super.toString();
    }
}
