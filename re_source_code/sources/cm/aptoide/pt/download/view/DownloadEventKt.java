package cm.aptoide.pt.download.view;

import cm.aptoide.aptoideviews.downloadprogressview.DownloadEventListener;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: DownloadEvent.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toDownloadEvent", "Lcm/aptoide/pt/download/view/DownloadEvent;", "Lcm/aptoide/aptoideviews/downloadprogressview/DownloadEventListener$Action;", "app_vanillaProdRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class DownloadEventKt {

    /* JADX INFO: compiled from: DownloadEvent.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DownloadEventListener.Action.Type.values().length];
            iArr[DownloadEventListener.Action.Type.CANCEL.ordinal()] = 1;
            iArr[DownloadEventListener.Action.Type.RESUME.ordinal()] = 2;
            iArr[DownloadEventListener.Action.Type.PAUSE.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final DownloadEvent toDownloadEvent(DownloadEventListener.Action action) {
        kotlin.jvm.internal.m.f(action, "<this>");
        int i2 = WhenMappings.$EnumSwitchMapping$0[action.getType().ordinal()];
        if (i2 == 1) {
            return DownloadEvent.CANCEL;
        }
        if (i2 == 2) {
            return DownloadEvent.RESUME;
        }
        if (i2 == 3) {
            return DownloadEvent.PAUSE;
        }
        throw new NoWhenBranchMatchedException();
    }
}
