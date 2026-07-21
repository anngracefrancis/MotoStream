package androidx.recyclerview.widget;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;

/* JADX INFO: compiled from: SnapHelper.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class r extends RecyclerView.r {
    static final float MILLISECONDS_PER_INCH = 100.0f;
    private Scroller mGravityScroller;
    RecyclerView mRecyclerView;
    private final RecyclerView.t mScrollListener = new a();

    /* JADX INFO: compiled from: SnapHelper.java */
    class a extends RecyclerView.t {
        boolean a = false;

        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            super.onScrollStateChanged(recyclerView, i2);
            if (i2 == 0 && this.a) {
                this.a = false;
                r.this.snapToTargetExistingView();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            if (i2 == 0 && i3 == 0) {
                return;
            }
            this.a = true;
        }
    }

    /* JADX INFO: compiled from: SnapHelper.java */
    class b extends j {
        b(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.j
        protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return r.MILLISECONDS_PER_INCH / displayMetrics.densityDpi;
        }

        @Override // androidx.recyclerview.widget.j, androidx.recyclerview.widget.RecyclerView.y
        protected void onTargetFound(View view, RecyclerView.z zVar, RecyclerView.y.a aVar) {
            r rVar = r.this;
            RecyclerView recyclerView = rVar.mRecyclerView;
            if (recyclerView == null) {
                return;
            }
            int[] iArrCalculateDistanceToFinalSnap = rVar.calculateDistanceToFinalSnap(recyclerView.getLayoutManager(), view);
            int i2 = iArrCalculateDistanceToFinalSnap[0];
            int i3 = iArrCalculateDistanceToFinalSnap[1];
            int iCalculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i2), Math.abs(i3)));
            if (iCalculateTimeForDeceleration > 0) {
                aVar.d(i2, i3, iCalculateTimeForDeceleration, this.mDecelerateInterpolator);
            }
        }
    }

    private void destroyCallbacks() {
        this.mRecyclerView.removeOnScrollListener(this.mScrollListener);
        this.mRecyclerView.setOnFlingListener(null);
    }

    private void setupCallbacks() throws IllegalStateException {
        if (this.mRecyclerView.getOnFlingListener() != null) {
            throw new IllegalStateException("An instance of OnFlingListener already set.");
        }
        this.mRecyclerView.addOnScrollListener(this.mScrollListener);
        this.mRecyclerView.setOnFlingListener(this);
    }

    private boolean snapFromFling(RecyclerView.o oVar, int i2, int i3) {
        RecyclerView.y yVarCreateScroller;
        int iFindTargetSnapPosition;
        if (!(oVar instanceof RecyclerView.y.b) || (yVarCreateScroller = createScroller(oVar)) == null || (iFindTargetSnapPosition = findTargetSnapPosition(oVar, i2, i3)) == -1) {
            return false;
        }
        yVarCreateScroller.setTargetPosition(iFindTargetSnapPosition);
        oVar.startSmoothScroll(yVarCreateScroller);
        return true;
    }

    public void attachToRecyclerView(RecyclerView recyclerView) throws IllegalStateException {
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            destroyCallbacks();
        }
        this.mRecyclerView = recyclerView;
        if (recyclerView != null) {
            setupCallbacks();
            this.mGravityScroller = new Scroller(this.mRecyclerView.getContext(), new DecelerateInterpolator());
            snapToTargetExistingView();
        }
    }

    public abstract int[] calculateDistanceToFinalSnap(RecyclerView.o oVar, View view);

    public int[] calculateScrollDistance(int i2, int i3) {
        this.mGravityScroller.fling(0, 0, i2, i3, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return new int[]{this.mGravityScroller.getFinalX(), this.mGravityScroller.getFinalY()};
    }

    protected RecyclerView.y createScroller(RecyclerView.o oVar) {
        return createSnapScroller(oVar);
    }

    @Deprecated
    protected j createSnapScroller(RecyclerView.o oVar) {
        if (oVar instanceof RecyclerView.y.b) {
            return new b(this.mRecyclerView.getContext());
        }
        return null;
    }

    public abstract View findSnapView(RecyclerView.o oVar);

    public abstract int findTargetSnapPosition(RecyclerView.o oVar, int i2, int i3);

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public boolean onFling(int i2, int i3) {
        RecyclerView.o layoutManager = this.mRecyclerView.getLayoutManager();
        if (layoutManager == null || this.mRecyclerView.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.mRecyclerView.getMinFlingVelocity();
        return (Math.abs(i3) > minFlingVelocity || Math.abs(i2) > minFlingVelocity) && snapFromFling(layoutManager, i2, i3);
    }

    void snapToTargetExistingView() {
        RecyclerView.o layoutManager;
        View viewFindSnapView;
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null || (viewFindSnapView = findSnapView(layoutManager)) == null) {
            return;
        }
        int[] iArrCalculateDistanceToFinalSnap = calculateDistanceToFinalSnap(layoutManager, viewFindSnapView);
        if (iArrCalculateDistanceToFinalSnap[0] == 0 && iArrCalculateDistanceToFinalSnap[1] == 0) {
            return;
        }
        this.mRecyclerView.smoothScrollBy(iArrCalculateDistanceToFinalSnap[0], iArrCalculateDistanceToFinalSnap[1]);
    }
}
