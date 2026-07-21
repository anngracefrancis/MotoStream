package cm.aptoide.aptoideviews.downloadprogressview;

import kotlin.Metadata;
import kotlin.jvm.internal.g;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: States.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0006\u0003\u0004\u0005\u0006\u0007\bB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0006\t\n\u000b\f\r\u000e¨\u0006\u000f"}, d2 = {"Lcm/aptoide/aptoideviews/downloadprogressview/State;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "Canceled", "InProgress", "InitialPaused", "Installing", "Paused", "Queue", "Lcm/aptoide/aptoideviews/downloadprogressview/State$Queue;", "Lcm/aptoide/aptoideviews/downloadprogressview/State$InProgress;", "Lcm/aptoide/aptoideviews/downloadprogressview/State$Paused;", "Lcm/aptoide/aptoideviews/downloadprogressview/State$InitialPaused;", "Lcm/aptoide/aptoideviews/downloadprogressview/State$Installing;", "Lcm/aptoide/aptoideviews/downloadprogressview/State$Canceled;", "aptoide-views_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class State {

    /* JADX INFO: compiled from: States.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcm/aptoide/aptoideviews/downloadprogressview/State$Canceled;", "Lcm/aptoide/aptoideviews/downloadprogressview/State;", "()V", "aptoide-views_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Canceled extends State {
        public static final Canceled INSTANCE = new Canceled();

        private Canceled() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: States.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcm/aptoide/aptoideviews/downloadprogressview/State$InProgress;", "Lcm/aptoide/aptoideviews/downloadprogressview/State;", "()V", "aptoide-views_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class InProgress extends State {
        public static final InProgress INSTANCE = new InProgress();

        private InProgress() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: States.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcm/aptoide/aptoideviews/downloadprogressview/State$InitialPaused;", "Lcm/aptoide/aptoideviews/downloadprogressview/State;", "()V", "aptoide-views_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class InitialPaused extends State {
        public static final InitialPaused INSTANCE = new InitialPaused();

        private InitialPaused() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: States.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcm/aptoide/aptoideviews/downloadprogressview/State$Installing;", "Lcm/aptoide/aptoideviews/downloadprogressview/State;", "()V", "aptoide-views_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Installing extends State {
        public static final Installing INSTANCE = new Installing();

        private Installing() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: States.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcm/aptoide/aptoideviews/downloadprogressview/State$Paused;", "Lcm/aptoide/aptoideviews/downloadprogressview/State;", "()V", "aptoide-views_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Paused extends State {
        public static final Paused INSTANCE = new Paused();

        private Paused() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: States.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcm/aptoide/aptoideviews/downloadprogressview/State$Queue;", "Lcm/aptoide/aptoideviews/downloadprogressview/State;", "()V", "aptoide-views_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Queue extends State {
        public static final Queue INSTANCE = new Queue();

        private Queue() {
            super(null);
        }
    }

    private State() {
    }

    public /* synthetic */ State(g gVar) {
        this();
    }
}
