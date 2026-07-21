package androidx.recyclerview.widget;

import android.graphics.PointF;
import android.view.View;

/* JADX INFO: compiled from: LinearSnapHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class k extends r {
    private static final float INVALID_DISTANCE = 1.0f;
    private n mHorizontalHelper;
    private n mVerticalHelper;

    private float computeDistancePerChild(RecyclerView.o oVar, n nVar) {
        int childCount = oVar.getChildCount();
        if (childCount == 0) {
            return INVALID_DISTANCE;
        }
        View view = null;
        View view2 = null;
        int i2 = Integer.MAX_VALUE;
        int i3 = Integer.MIN_VALUE;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = oVar.getChildAt(i4);
            int position = oVar.getPosition(childAt);
            if (position != -1) {
                if (position < i2) {
                    view = childAt;
                    i2 = position;
                }
                if (position > i3) {
                    view2 = childAt;
                    i3 = position;
                }
            }
        }
        if (view == null || view2 == null) {
            return INVALID_DISTANCE;
        }
        int iMax = Math.max(nVar.d(view), nVar.d(view2)) - Math.min(nVar.g(view), nVar.g(view2));
        return iMax == 0 ? INVALID_DISTANCE : (iMax * INVALID_DISTANCE) / ((i3 - i2) + 1);
    }

    private int distanceToCenter(RecyclerView.o oVar, View view, n nVar) {
        return (nVar.g(view) + (nVar.e(view) / 2)) - (nVar.m() + (nVar.n() / 2));
    }

    private int estimateNextPositionDiffForFling(RecyclerView.o oVar, n nVar, int i2, int i3) {
        int[] iArrCalculateScrollDistance = calculateScrollDistance(i2, i3);
        float fComputeDistancePerChild = computeDistancePerChild(oVar, nVar);
        if (fComputeDistancePerChild <= 0.0f) {
            return 0;
        }
        return Math.round((Math.abs(iArrCalculateScrollDistance[0]) > Math.abs(iArrCalculateScrollDistance[1]) ? iArrCalculateScrollDistance[0] : iArrCalculateScrollDistance[1]) / fComputeDistancePerChild);
    }

    private View findCenterView(RecyclerView.o oVar, n nVar) {
        int childCount = oVar.getChildCount();
        View view = null;
        if (childCount == 0) {
            return null;
        }
        int iM = nVar.m() + (nVar.n() / 2);
        int i2 = Integer.MAX_VALUE;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = oVar.getChildAt(i3);
            int iAbs = Math.abs((nVar.g(childAt) + (nVar.e(childAt) / 2)) - iM);
            if (iAbs < i2) {
                view = childAt;
                i2 = iAbs;
            }
        }
        return view;
    }

    private n getHorizontalHelper(RecyclerView.o oVar) {
        n nVar = this.mHorizontalHelper;
        if (nVar == null || nVar.a != oVar) {
            this.mHorizontalHelper = n.a(oVar);
        }
        return this.mHorizontalHelper;
    }

    private n getVerticalHelper(RecyclerView.o oVar) {
        n nVar = this.mVerticalHelper;
        if (nVar == null || nVar.a != oVar) {
            this.mVerticalHelper = n.c(oVar);
        }
        return this.mVerticalHelper;
    }

    @Override // androidx.recyclerview.widget.r
    public int[] calculateDistanceToFinalSnap(RecyclerView.o oVar, View view) {
        int[] iArr = new int[2];
        if (oVar.canScrollHorizontally()) {
            iArr[0] = distanceToCenter(oVar, view, getHorizontalHelper(oVar));
        } else {
            iArr[0] = 0;
        }
        if (oVar.canScrollVertically()) {
            iArr[1] = distanceToCenter(oVar, view, getVerticalHelper(oVar));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.r
    public View findSnapView(RecyclerView.o oVar) {
        if (oVar.canScrollVertically()) {
            return findCenterView(oVar, getVerticalHelper(oVar));
        }
        if (oVar.canScrollHorizontally()) {
            return findCenterView(oVar, getHorizontalHelper(oVar));
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.r
    public int findTargetSnapPosition(RecyclerView.o oVar, int i2, int i3) {
        int itemCount;
        View viewFindSnapView;
        int position;
        int i4;
        PointF pointFComputeScrollVectorForPosition;
        int iEstimateNextPositionDiffForFling;
        int iEstimateNextPositionDiffForFling2;
        if (!(oVar instanceof RecyclerView.y.b) || (itemCount = oVar.getItemCount()) == 0 || (viewFindSnapView = findSnapView(oVar)) == null || (position = oVar.getPosition(viewFindSnapView)) == -1 || (pointFComputeScrollVectorForPosition = ((RecyclerView.y.b) oVar).computeScrollVectorForPosition((i4 = itemCount - 1))) == null) {
            return -1;
        }
        if (oVar.canScrollHorizontally()) {
            iEstimateNextPositionDiffForFling = estimateNextPositionDiffForFling(oVar, getHorizontalHelper(oVar), i2, 0);
            if (pointFComputeScrollVectorForPosition.x < 0.0f) {
                iEstimateNextPositionDiffForFling = -iEstimateNextPositionDiffForFling;
            }
        } else {
            iEstimateNextPositionDiffForFling = 0;
        }
        if (oVar.canScrollVertically()) {
            iEstimateNextPositionDiffForFling2 = estimateNextPositionDiffForFling(oVar, getVerticalHelper(oVar), 0, i3);
            if (pointFComputeScrollVectorForPosition.y < 0.0f) {
                iEstimateNextPositionDiffForFling2 = -iEstimateNextPositionDiffForFling2;
            }
        } else {
            iEstimateNextPositionDiffForFling2 = 0;
        }
        if (oVar.canScrollVertically()) {
            iEstimateNextPositionDiffForFling = iEstimateNextPositionDiffForFling2;
        }
        if (iEstimateNextPositionDiffForFling == 0) {
            return -1;
        }
        int i5 = position + iEstimateNextPositionDiffForFling;
        int i6 = i5 >= 0 ? i5 : 0;
        return i6 >= itemCount ? i4 : i6;
    }
}
