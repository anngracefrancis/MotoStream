package kotlinx.coroutines;

import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlinx.coroutines.a2, reason: from Kotlin metadata */
/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0000\b\u0011\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\f\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0003R\u0014\u0010\u0006\u001a\u00020\u0007X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\t¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/JobImpl;", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/CompletableJob;", "parent", "Lkotlinx/coroutines/Job;", "(Lkotlinx/coroutines/Job;)V", "handlesException", HttpUrl.FRAGMENT_ENCODE_SET, "getHandlesException$kotlinx_coroutines_core", "()Z", "onCancelComplete", "getOnCancelComplete$kotlinx_coroutines_core", "complete", "completeExceptionally", "exception", HttpUrl.FRAGMENT_ENCODE_SET, "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class JobImpl extends JobSupport implements CompletableJob {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f25637g;

    public JobImpl(Job job) {
        super(true);
        a0(job);
        this.f25637g = C0();
    }

    private final boolean C0() {
        JobSupport jobSupportF;
        ChildHandle childHandleW = W();
        ChildHandleNode childHandleNode = childHandleW instanceof ChildHandleNode ? (ChildHandleNode) childHandleW : null;
        if (childHandleNode != null && (jobSupportF = childHandleNode.F()) != null) {
            while (!jobSupportF.getF25637g()) {
                ChildHandle childHandleW2 = jobSupportF.W();
                ChildHandleNode childHandleNode2 = childHandleW2 instanceof ChildHandleNode ? (ChildHandleNode) childHandleW2 : null;
                if (childHandleNode2 == null || (jobSupportF = childHandleNode2.F()) == null) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.JobSupport
    /* JADX INFO: renamed from: T, reason: from getter */
    public boolean getF25637g() {
        return this.f25637g;
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean U() {
        return true;
    }
}
