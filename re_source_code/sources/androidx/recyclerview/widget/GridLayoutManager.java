package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {
    private static final boolean DEBUG = false;
    public static final int DEFAULT_SPAN_COUNT = -1;
    private static final String TAG = "GridLayoutManager";
    int[] mCachedBorders;
    final Rect mDecorInsets;
    boolean mPendingSpanCountChange;
    final SparseIntArray mPreLayoutSpanIndexCache;
    final SparseIntArray mPreLayoutSpanSizeCache;
    View[] mSet;
    int mSpanCount;
    c mSpanSizeLookup;
    private boolean mUsingSpansToEstimateScrollBarDimensions;

    public static final class a extends c {
        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int getSpanIndex(int i2, int i3) {
            return i2 % i3;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int getSpanSize(int i2) {
            return 1;
        }
    }

    public static abstract class c {
        final SparseIntArray mSpanIndexCache = new SparseIntArray();
        final SparseIntArray mSpanGroupIndexCache = new SparseIntArray();
        private boolean mCacheSpanIndices = false;
        private boolean mCacheSpanGroupIndices = false;

        static int findFirstKeyLessThan(SparseIntArray sparseIntArray, int i2) {
            int size = sparseIntArray.size() - 1;
            int i3 = 0;
            while (i3 <= size) {
                int i4 = (i3 + size) >>> 1;
                if (sparseIntArray.keyAt(i4) < i2) {
                    i3 = i4 + 1;
                } else {
                    size = i4 - 1;
                }
            }
            int i5 = i3 - 1;
            if (i5 < 0 || i5 >= sparseIntArray.size()) {
                return -1;
            }
            return sparseIntArray.keyAt(i5);
        }

        int getCachedSpanGroupIndex(int i2, int i3) {
            if (!this.mCacheSpanGroupIndices) {
                return getSpanGroupIndex(i2, i3);
            }
            int i4 = this.mSpanGroupIndexCache.get(i2, -1);
            if (i4 != -1) {
                return i4;
            }
            int spanGroupIndex = getSpanGroupIndex(i2, i3);
            this.mSpanGroupIndexCache.put(i2, spanGroupIndex);
            return spanGroupIndex;
        }

        int getCachedSpanIndex(int i2, int i3) {
            if (!this.mCacheSpanIndices) {
                return getSpanIndex(i2, i3);
            }
            int i4 = this.mSpanIndexCache.get(i2, -1);
            if (i4 != -1) {
                return i4;
            }
            int spanIndex = getSpanIndex(i2, i3);
            this.mSpanIndexCache.put(i2, spanIndex);
            return spanIndex;
        }

        /* JADX WARN: Code duplicated, block: B:13:0x002d  */
        /* JADX WARN: Code duplicated, block: B:15:0x0034  */
        /* JADX WARN: Code duplicated, block: B:16:0x0038 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:17:0x003a  */
        /* JADX WARN: Code duplicated, block: B:21:0x0043  */
        /* JADX WARN: Code duplicated, block: B:26:0x003d A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:27:? A[RETURN, SYNTHETIC] */
        public int getSpanGroupIndex(int i2, int i3) {
            int i4;
            int cachedSpanIndex;
            int i5;
            int spanSize;
            int spanSize2;
            int iFindFirstKeyLessThan;
            if (this.mCacheSpanGroupIndices && (iFindFirstKeyLessThan = findFirstKeyLessThan(this.mSpanGroupIndexCache, i2)) != -1) {
                i5 = this.mSpanGroupIndexCache.get(iFindFirstKeyLessThan);
                i4 = iFindFirstKeyLessThan + 1;
                cachedSpanIndex = getCachedSpanIndex(iFindFirstKeyLessThan, i3) + getSpanSize(iFindFirstKeyLessThan);
                i5 = cachedSpanIndex == i3 ? i5 + 1 : 0;
                spanSize = getSpanSize(i2);
                while (i4 < i2) {
                    spanSize2 = getSpanSize(i4);
                    cachedSpanIndex += spanSize2;
                    if (cachedSpanIndex == i3) {
                        i5++;
                        cachedSpanIndex = 0;
                    } else if (cachedSpanIndex > i3) {
                        i5++;
                        cachedSpanIndex = spanSize2;
                    }
                    i4++;
                }
                if (cachedSpanIndex + spanSize > i3) {
                    return i5 + 1;
                }
                return i5;
            }
            i4 = 0;
            cachedSpanIndex = 0;
            spanSize = getSpanSize(i2);
            while (i4 < i2) {
                spanSize2 = getSpanSize(i4);
                cachedSpanIndex += spanSize2;
                if (cachedSpanIndex == i3) {
                    i5++;
                    cachedSpanIndex = 0;
                } else if (cachedSpanIndex > i3) {
                    i5++;
                    cachedSpanIndex = spanSize2;
                }
                i4++;
            }
            if (cachedSpanIndex + spanSize > i3) {
                return i5 + 1;
            }
            return i5;
        }

        /* JADX WARN: Code duplicated, block: B:12:0x0024  */
        /* JADX WARN: Code duplicated, block: B:14:0x002b  */
        /* JADX WARN: Code duplicated, block: B:15:0x002d A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:16:0x002f  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x002b -> B:17:0x0030). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x002d -> B:17:0x0030). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x002f -> B:17:0x0030). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        public int getSpanIndex(int r6, int r7) {
            /*
                r5 = this;
                int r0 = r5.getSpanSize(r6)
                r1 = 0
                if (r0 != r7) goto L8
                return r1
            L8:
                boolean r2 = r5.mCacheSpanIndices
                if (r2 == 0) goto L20
                android.util.SparseIntArray r2 = r5.mSpanIndexCache
                int r2 = findFirstKeyLessThan(r2, r6)
                if (r2 < 0) goto L20
                android.util.SparseIntArray r3 = r5.mSpanIndexCache
                int r3 = r3.get(r2)
                int r4 = r5.getSpanSize(r2)
                int r3 = r3 + r4
                goto L30
            L20:
                r2 = 0
                r3 = 0
            L22:
                if (r2 >= r6) goto L33
                int r4 = r5.getSpanSize(r2)
                int r3 = r3 + r4
                if (r3 != r7) goto L2d
                r3 = 0
                goto L30
            L2d:
                if (r3 <= r7) goto L30
                r3 = r4
            L30:
                int r2 = r2 + 1
                goto L22
            L33:
                int r0 = r0 + r3
                if (r0 > r7) goto L37
                return r3
            L37:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.c.getSpanIndex(int, int):int");
        }

        public abstract int getSpanSize(int i2);

        public void invalidateSpanGroupIndexCache() {
            this.mSpanGroupIndexCache.clear();
        }

        public void invalidateSpanIndexCache() {
            this.mSpanIndexCache.clear();
        }

        public boolean isSpanGroupIndexCacheEnabled() {
            return this.mCacheSpanGroupIndices;
        }

        public boolean isSpanIndexCacheEnabled() {
            return this.mCacheSpanIndices;
        }

        public void setSpanGroupIndexCacheEnabled(boolean z) {
            if (!z) {
                this.mSpanGroupIndexCache.clear();
            }
            this.mCacheSpanGroupIndices = z;
        }

        public void setSpanIndexCacheEnabled(boolean z) {
            if (!z) {
                this.mSpanGroupIndexCache.clear();
            }
            this.mCacheSpanIndices = z;
        }
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.mPendingSpanCountChange = false;
        this.mSpanCount = -1;
        this.mPreLayoutSpanSizeCache = new SparseIntArray();
        this.mPreLayoutSpanIndexCache = new SparseIntArray();
        this.mSpanSizeLookup = new a();
        this.mDecorInsets = new Rect();
        setSpanCount(RecyclerView.o.getProperties(context, attributeSet, i2, i3).f1930b);
    }

    private void assignSpans(RecyclerView.v vVar, RecyclerView.z zVar, int i2, boolean z) {
        int i3;
        int i4;
        int i5 = 0;
        int i6 = -1;
        if (z) {
            i6 = i2;
            i3 = 0;
            i4 = 1;
        } else {
            i3 = i2 - 1;
            i4 = -1;
        }
        while (i3 != i6) {
            View view = this.mSet[i3];
            b bVar = (b) view.getLayoutParams();
            int spanSize = getSpanSize(vVar, zVar, getPosition(view));
            bVar.f1897f = spanSize;
            bVar.f1896e = i5;
            i5 += spanSize;
            i3 += i4;
        }
    }

    private void cachePreLayoutSpanMapping() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            b bVar = (b) getChildAt(i2).getLayoutParams();
            int iA = bVar.a();
            this.mPreLayoutSpanSizeCache.put(iA, bVar.f());
            this.mPreLayoutSpanIndexCache.put(iA, bVar.e());
        }
    }

    private void calculateItemBorders(int i2) {
        this.mCachedBorders = calculateItemBorders(this.mCachedBorders, this.mSpanCount, i2);
    }

    private void clearPreLayoutSpanMappingCache() {
        this.mPreLayoutSpanSizeCache.clear();
        this.mPreLayoutSpanIndexCache.clear();
    }

    private int computeScrollOffsetWithSpanInfo(RecyclerView.z zVar) {
        if (getChildCount() != 0 && zVar.b() != 0) {
            ensureLayoutState();
            boolean zIsSmoothScrollbarEnabled = isSmoothScrollbarEnabled();
            View viewFindFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!zIsSmoothScrollbarEnabled, true);
            View viewFindFirstVisibleChildClosestToEnd = findFirstVisibleChildClosestToEnd(!zIsSmoothScrollbarEnabled, true);
            if (viewFindFirstVisibleChildClosestToStart != null && viewFindFirstVisibleChildClosestToEnd != null) {
                int cachedSpanGroupIndex = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(viewFindFirstVisibleChildClosestToStart), this.mSpanCount);
                int cachedSpanGroupIndex2 = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(viewFindFirstVisibleChildClosestToEnd), this.mSpanCount);
                int iMax = this.mShouldReverseLayout ? Math.max(0, ((this.mSpanSizeLookup.getCachedSpanGroupIndex(zVar.b() - 1, this.mSpanCount) + 1) - Math.max(cachedSpanGroupIndex, cachedSpanGroupIndex2)) - 1) : Math.max(0, Math.min(cachedSpanGroupIndex, cachedSpanGroupIndex2));
                if (zIsSmoothScrollbarEnabled) {
                    return Math.round((iMax * (Math.abs(this.mOrientationHelper.d(viewFindFirstVisibleChildClosestToEnd) - this.mOrientationHelper.g(viewFindFirstVisibleChildClosestToStart)) / ((this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(viewFindFirstVisibleChildClosestToEnd), this.mSpanCount) - this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(viewFindFirstVisibleChildClosestToStart), this.mSpanCount)) + 1))) + (this.mOrientationHelper.m() - this.mOrientationHelper.g(viewFindFirstVisibleChildClosestToStart)));
                }
                return iMax;
            }
        }
        return 0;
    }

    private int computeScrollRangeWithSpanInfo(RecyclerView.z zVar) {
        if (getChildCount() != 0 && zVar.b() != 0) {
            ensureLayoutState();
            View viewFindFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!isSmoothScrollbarEnabled(), true);
            View viewFindFirstVisibleChildClosestToEnd = findFirstVisibleChildClosestToEnd(!isSmoothScrollbarEnabled(), true);
            if (viewFindFirstVisibleChildClosestToStart != null && viewFindFirstVisibleChildClosestToEnd != null) {
                if (!isSmoothScrollbarEnabled()) {
                    return this.mSpanSizeLookup.getCachedSpanGroupIndex(zVar.b() - 1, this.mSpanCount) + 1;
                }
                return (int) (((this.mOrientationHelper.d(viewFindFirstVisibleChildClosestToEnd) - this.mOrientationHelper.g(viewFindFirstVisibleChildClosestToStart)) / ((this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(viewFindFirstVisibleChildClosestToEnd), this.mSpanCount) - this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(viewFindFirstVisibleChildClosestToStart), this.mSpanCount)) + 1)) * (this.mSpanSizeLookup.getCachedSpanGroupIndex(zVar.b() - 1, this.mSpanCount) + 1));
            }
        }
        return 0;
    }

    private void ensureAnchorIsInCorrectSpan(RecyclerView.v vVar, RecyclerView.z zVar, LinearLayoutManager.a aVar, int i2) {
        boolean z = i2 == 1;
        int spanIndex = getSpanIndex(vVar, zVar, aVar.f1901b);
        if (z) {
            while (spanIndex > 0) {
                int i3 = aVar.f1901b;
                if (i3 <= 0) {
                    return;
                }
                int i4 = i3 - 1;
                aVar.f1901b = i4;
                spanIndex = getSpanIndex(vVar, zVar, i4);
            }
            return;
        }
        int iB = zVar.b() - 1;
        int i5 = aVar.f1901b;
        while (i5 < iB) {
            int i6 = i5 + 1;
            int spanIndex2 = getSpanIndex(vVar, zVar, i6);
            if (spanIndex2 <= spanIndex) {
                break;
            }
            i5 = i6;
            spanIndex = spanIndex2;
        }
        aVar.f1901b = i5;
    }

    private void ensureViewSet() {
        View[] viewArr = this.mSet;
        if (viewArr == null || viewArr.length != this.mSpanCount) {
            this.mSet = new View[this.mSpanCount];
        }
    }

    private int getSpanGroupIndex(RecyclerView.v vVar, RecyclerView.z zVar, int i2) {
        if (!zVar.e()) {
            return this.mSpanSizeLookup.getCachedSpanGroupIndex(i2, this.mSpanCount);
        }
        int iF = vVar.f(i2);
        if (iF != -1) {
            return this.mSpanSizeLookup.getCachedSpanGroupIndex(iF, this.mSpanCount);
        }
        Log.w(TAG, "Cannot find span size for pre layout position. " + i2);
        return 0;
    }

    private int getSpanIndex(RecyclerView.v vVar, RecyclerView.z zVar, int i2) {
        if (!zVar.e()) {
            return this.mSpanSizeLookup.getCachedSpanIndex(i2, this.mSpanCount);
        }
        int i3 = this.mPreLayoutSpanIndexCache.get(i2, -1);
        if (i3 != -1) {
            return i3;
        }
        int iF = vVar.f(i2);
        if (iF != -1) {
            return this.mSpanSizeLookup.getCachedSpanIndex(iF, this.mSpanCount);
        }
        Log.w(TAG, "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i2);
        return 0;
    }

    private int getSpanSize(RecyclerView.v vVar, RecyclerView.z zVar, int i2) {
        if (!zVar.e()) {
            return this.mSpanSizeLookup.getSpanSize(i2);
        }
        int i3 = this.mPreLayoutSpanSizeCache.get(i2, -1);
        if (i3 != -1) {
            return i3;
        }
        int iF = vVar.f(i2);
        if (iF != -1) {
            return this.mSpanSizeLookup.getSpanSize(iF);
        }
        Log.w(TAG, "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i2);
        return 1;
    }

    private void guessMeasurement(float f2, int i2) {
        calculateItemBorders(Math.max(Math.round(f2 * this.mSpanCount), i2));
    }

    private void measureChild(View view, int i2, boolean z) {
        int childMeasureSpec;
        int childMeasureSpec2;
        b bVar = (b) view.getLayoutParams();
        Rect rect = bVar.f1933b;
        int i3 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) bVar).topMargin + ((ViewGroup.MarginLayoutParams) bVar).bottomMargin;
        int i4 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) bVar).leftMargin + ((ViewGroup.MarginLayoutParams) bVar).rightMargin;
        int spaceForSpanRange = getSpaceForSpanRange(bVar.f1896e, bVar.f1897f);
        if (this.mOrientation == 1) {
            childMeasureSpec2 = RecyclerView.o.getChildMeasureSpec(spaceForSpanRange, i2, i4, ((ViewGroup.MarginLayoutParams) bVar).width, false);
            childMeasureSpec = RecyclerView.o.getChildMeasureSpec(this.mOrientationHelper.n(), getHeightMode(), i3, ((ViewGroup.MarginLayoutParams) bVar).height, true);
        } else {
            int childMeasureSpec3 = RecyclerView.o.getChildMeasureSpec(spaceForSpanRange, i2, i3, ((ViewGroup.MarginLayoutParams) bVar).height, false);
            int childMeasureSpec4 = RecyclerView.o.getChildMeasureSpec(this.mOrientationHelper.n(), getWidthMode(), i4, ((ViewGroup.MarginLayoutParams) bVar).width, true);
            childMeasureSpec = childMeasureSpec3;
            childMeasureSpec2 = childMeasureSpec4;
        }
        measureChildWithDecorationsAndMargin(view, childMeasureSpec2, childMeasureSpec, z);
    }

    private void measureChildWithDecorationsAndMargin(View view, int i2, int i3, boolean z) {
        RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
        if (z ? shouldReMeasureChild(view, i2, i3, pVar) : shouldMeasureChild(view, i2, i3, pVar)) {
            view.measure(i2, i3);
        }
    }

    private void updateMeasurements() {
        int height;
        int paddingTop;
        if (getOrientation() == 1) {
            height = getWidth() - getPaddingRight();
            paddingTop = getPaddingLeft();
        } else {
            height = getHeight() - getPaddingBottom();
            paddingTop = getPaddingTop();
        }
        calculateItemBorders(height - paddingTop);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean checkLayoutParams(RecyclerView.p pVar) {
        return pVar instanceof b;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void collectPrefetchPositionsForLayoutState(RecyclerView.z zVar, LinearLayoutManager.c cVar, RecyclerView.o.c cVar2) {
        int spanSize = this.mSpanCount;
        for (int i2 = 0; i2 < this.mSpanCount && cVar.c(zVar) && spanSize > 0; i2++) {
            int i3 = cVar.f1910d;
            cVar2.a(i3, Math.max(0, cVar.f1913g));
            spanSize -= this.mSpanSizeLookup.getSpanSize(i3);
            cVar.f1910d += cVar.f1911e;
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int computeHorizontalScrollOffset(RecyclerView.z zVar) {
        return this.mUsingSpansToEstimateScrollBarDimensions ? computeScrollOffsetWithSpanInfo(zVar) : super.computeHorizontalScrollOffset(zVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int computeHorizontalScrollRange(RecyclerView.z zVar) {
        return this.mUsingSpansToEstimateScrollBarDimensions ? computeScrollRangeWithSpanInfo(zVar) : super.computeHorizontalScrollRange(zVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int computeVerticalScrollOffset(RecyclerView.z zVar) {
        return this.mUsingSpansToEstimateScrollBarDimensions ? computeScrollOffsetWithSpanInfo(zVar) : super.computeVerticalScrollOffset(zVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int computeVerticalScrollRange(RecyclerView.z zVar) {
        return this.mUsingSpansToEstimateScrollBarDimensions ? computeScrollRangeWithSpanInfo(zVar) : super.computeVerticalScrollRange(zVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    View findReferenceChild(RecyclerView.v vVar, RecyclerView.z zVar, int i2, int i3, int i4) {
        ensureLayoutState();
        int iM = this.mOrientationHelper.m();
        int i5 = this.mOrientationHelper.i();
        int i6 = i3 > i2 ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i2 != i3) {
            View childAt = getChildAt(i2);
            int position = getPosition(childAt);
            if (position >= 0 && position < i4 && getSpanIndex(vVar, zVar, position) == 0) {
                if (((RecyclerView.p) childAt.getLayoutParams()).c()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else {
                    if (this.mOrientationHelper.g(childAt) < i5 && this.mOrientationHelper.d(childAt) >= iM) {
                        return childAt;
                    }
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            i2 += i6;
        }
        return view != null ? view : view2;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p generateDefaultLayoutParams() {
        return this.mOrientation == 0 ? new b(-2, -1) : new b(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new b(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int getColumnCountForAccessibility(RecyclerView.v vVar, RecyclerView.z zVar) {
        if (this.mOrientation == 1) {
            return this.mSpanCount;
        }
        if (zVar.b() < 1) {
            return 0;
        }
        return getSpanGroupIndex(vVar, zVar, zVar.b() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int getRowCountForAccessibility(RecyclerView.v vVar, RecyclerView.z zVar) {
        if (this.mOrientation == 0) {
            return this.mSpanCount;
        }
        if (zVar.b() < 1) {
            return 0;
        }
        return getSpanGroupIndex(vVar, zVar, zVar.b() - 1) + 1;
    }

    int getSpaceForSpanRange(int i2, int i3) {
        if (this.mOrientation != 1 || !isLayoutRTL()) {
            int[] iArr = this.mCachedBorders;
            return iArr[i3 + i2] - iArr[i2];
        }
        int[] iArr2 = this.mCachedBorders;
        int i4 = this.mSpanCount;
        return iArr2[i4 - i2] - iArr2[(i4 - i2) - i3];
    }

    public int getSpanCount() {
        return this.mSpanCount;
    }

    public c getSpanSizeLookup() {
        return this.mSpanSizeLookup;
    }

    public boolean isUsingSpansToEstimateScrollbarDimensions() {
        return this.mUsingSpansToEstimateScrollBarDimensions;
    }

    /* JADX WARN: Code duplicated, block: B:98:0x0219  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v19 */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void layoutChunk(RecyclerView.v vVar, RecyclerView.z zVar, LinearLayoutManager.c cVar, LinearLayoutManager.b bVar) {
        int i2;
        int iF;
        int i3;
        int i4;
        int i5;
        int iF2;
        int iF3;
        int i6;
        int childMeasureSpec;
        int childMeasureSpec2;
        View viewD;
        int iL = this.mOrientationHelper.l();
        ?? r5 = 0;
        boolean z = iL != 1073741824;
        int i7 = getChildCount() > 0 ? this.mCachedBorders[this.mSpanCount] : 0;
        if (z) {
            updateMeasurements();
        }
        boolean z2 = cVar.f1911e == 1;
        int spanIndex = this.mSpanCount;
        if (!z2) {
            spanIndex = getSpanIndex(vVar, zVar, cVar.f1910d) + getSpanSize(vVar, zVar, cVar.f1910d);
        }
        int i8 = 0;
        while (i8 < this.mSpanCount && cVar.c(zVar) && spanIndex > 0) {
            int i9 = cVar.f1910d;
            int spanSize = getSpanSize(vVar, zVar, i9);
            if (spanSize > this.mSpanCount) {
                throw new IllegalArgumentException("Item at position " + i9 + " requires " + spanSize + " spans but GridLayoutManager has only " + this.mSpanCount + " spans.");
            }
            spanIndex -= spanSize;
            if (spanIndex < 0 || (viewD = cVar.d(vVar)) == null) {
                break;
            }
            this.mSet[i8] = viewD;
            i8++;
        }
        if (i8 == 0) {
            bVar.f1905b = true;
            return;
        }
        float f2 = 0.0f;
        assignSpans(vVar, zVar, i8, z2);
        int i10 = 0;
        int i11 = 0;
        while (i10 < i8) {
            View view = this.mSet[i10];
            if (cVar.l == null) {
                if (z2) {
                    addView(view);
                } else {
                    addView(view, r5);
                }
            } else if (z2) {
                addDisappearingView(view);
            } else {
                addDisappearingView(view, r5);
            }
            calculateItemDecorationsForChild(view, this.mDecorInsets);
            measureChild(view, iL, (boolean) r5);
            int iE = this.mOrientationHelper.e(view);
            if (iE > i11) {
                i11 = iE;
            }
            float f3 = (this.mOrientationHelper.f(view) * 1.0f) / ((b) view.getLayoutParams()).f1897f;
            if (f3 > f2) {
                f2 = f3;
            }
            i10++;
            r5 = 0;
        }
        if (z) {
            guessMeasurement(f2, i7);
            i11 = 0;
            for (int i12 = 0; i12 < i8; i12++) {
                View view2 = this.mSet[i12];
                measureChild(view2, 1073741824, true);
                int iE2 = this.mOrientationHelper.e(view2);
                if (iE2 > i11) {
                    i11 = iE2;
                }
            }
        }
        for (int i13 = 0; i13 < i8; i13++) {
            View view3 = this.mSet[i13];
            if (this.mOrientationHelper.e(view3) != i11) {
                b bVar2 = (b) view3.getLayoutParams();
                Rect rect = bVar2.f1933b;
                int i14 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) bVar2).topMargin + ((ViewGroup.MarginLayoutParams) bVar2).bottomMargin;
                int i15 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) bVar2).leftMargin + ((ViewGroup.MarginLayoutParams) bVar2).rightMargin;
                int spaceForSpanRange = getSpaceForSpanRange(bVar2.f1896e, bVar2.f1897f);
                if (this.mOrientation == 1) {
                    childMeasureSpec2 = RecyclerView.o.getChildMeasureSpec(spaceForSpanRange, 1073741824, i15, ((ViewGroup.MarginLayoutParams) bVar2).width, false);
                    childMeasureSpec = View.MeasureSpec.makeMeasureSpec(i11 - i14, 1073741824);
                } else {
                    int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i11 - i15, 1073741824);
                    childMeasureSpec = RecyclerView.o.getChildMeasureSpec(spaceForSpanRange, 1073741824, i14, ((ViewGroup.MarginLayoutParams) bVar2).height, false);
                    childMeasureSpec2 = iMakeMeasureSpec;
                }
                measureChildWithDecorationsAndMargin(view3, childMeasureSpec2, childMeasureSpec, true);
            }
        }
        int i16 = 0;
        bVar.a = i11;
        if (this.mOrientation == 1) {
            if (cVar.f1912f == -1) {
                i3 = cVar.f1908b;
                i4 = i3 - i11;
            } else {
                int i17 = cVar.f1908b;
                i4 = i17;
                i3 = i11 + i17;
            }
            i2 = 0;
            iF = 0;
        } else if (cVar.f1912f == -1) {
            int i18 = cVar.f1908b;
            iF = i18 - i11;
            i4 = 0;
            i2 = i18;
            i3 = 0;
        } else {
            int i19 = cVar.f1908b;
            i2 = i11 + i19;
            iF = i19;
            i3 = 0;
            i4 = 0;
        }
        while (i16 < i8) {
            View view4 = this.mSet[i16];
            b bVar3 = (b) view4.getLayoutParams();
            if (this.mOrientation == 1) {
                if (isLayoutRTL()) {
                    int paddingLeft = getPaddingLeft() + this.mCachedBorders[this.mSpanCount - bVar3.f1896e];
                    iF = paddingLeft - this.mOrientationHelper.f(view4);
                    iF3 = i3;
                    iF2 = paddingLeft;
                    i5 = i4;
                } else {
                    int paddingLeft2 = getPaddingLeft() + this.mCachedBorders[bVar3.f1896e];
                    iF3 = i3;
                    i6 = paddingLeft2;
                    i5 = i4;
                    iF2 = this.mOrientationHelper.f(view4) + paddingLeft2;
                }
                layoutDecoratedWithMargins(view4, i6, i5, iF2, iF3);
                if (bVar3.c() || bVar3.b()) {
                    bVar.f1906c = true;
                }
                bVar.f1907d |= view4.hasFocusable();
                i16++;
                i3 = iF3;
                i2 = iF2;
                i4 = i5;
                iF = i6;
            } else {
                int paddingTop = getPaddingTop() + this.mCachedBorders[bVar3.f1896e];
                i5 = paddingTop;
                iF2 = i2;
                iF3 = this.mOrientationHelper.f(view4) + paddingTop;
            }
            i6 = iF;
            layoutDecoratedWithMargins(view4, i6, i5, iF2, iF3);
            if (bVar3.c()) {
                bVar.f1906c = true;
            } else {
                bVar.f1906c = true;
            }
            bVar.f1907d |= view4.hasFocusable();
            i16++;
            i3 = iF3;
            i2 = iF2;
            i4 = i5;
            iF = i6;
        }
        Arrays.fill(this.mSet, (Object) null);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void onAnchorReady(RecyclerView.v vVar, RecyclerView.z zVar, LinearLayoutManager.a aVar, int i2) {
        super.onAnchorReady(vVar, zVar, aVar, i2);
        updateMeasurements();
        if (zVar.b() > 0 && !zVar.e()) {
            ensureAnchorIsInCorrectSpan(vVar, zVar, aVar, i2);
        }
        ensureViewSet();
    }

    /* JADX WARN: Code duplicated, block: B:79:0x0107  */
    /* JADX WARN: Code duplicated, block: B:81:0x010d  */
    /* JADX WARN: Code duplicated, block: B:82:0x0123  */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00d6, code lost:
    
        if (r13 == (r2 > r15)) goto L49;
     */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View onFocusSearchFailed(android.view.View r24, int r25, androidx.recyclerview.widget.RecyclerView.v r26, androidx.recyclerview.widget.RecyclerView.z r27) {
        /*
            Method dump skipped, instruction units count: 337
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.onFocusSearchFailed(android.view.View, int, androidx.recyclerview.widget.RecyclerView$v, androidx.recyclerview.widget.RecyclerView$z):android.view.View");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.v vVar, RecyclerView.z zVar, View view, androidx.core.view.d0.c cVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof b)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, cVar);
            return;
        }
        b bVar = (b) layoutParams;
        int spanGroupIndex = getSpanGroupIndex(vVar, zVar, bVar.a());
        if (this.mOrientation == 0) {
            cVar.b0(androidx.core.view.d0.c.C0025c.f(bVar.e(), bVar.f(), spanGroupIndex, 1, false, false));
        } else {
            cVar.b0(androidx.core.view.d0.c.C0025c.f(spanGroupIndex, 1, bVar.e(), bVar.f(), false, false));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onItemsAdded(RecyclerView recyclerView, int i2, int i3) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onItemsChanged(RecyclerView recyclerView) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onItemsMoved(RecyclerView recyclerView, int i2, int i3, int i4) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onItemsRemoved(RecyclerView recyclerView, int i2, int i3) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onItemsUpdated(RecyclerView recyclerView, int i2, int i3, Object obj) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public void onLayoutChildren(RecyclerView.v vVar, RecyclerView.z zVar) {
        if (zVar.e()) {
            cachePreLayoutSpanMapping();
        }
        super.onLayoutChildren(vVar, zVar);
        clearPreLayoutSpanMappingCache();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public void onLayoutCompleted(RecyclerView.z zVar) {
        super.onLayoutCompleted(zVar);
        this.mPendingSpanCountChange = false;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int scrollHorizontallyBy(int i2, RecyclerView.v vVar, RecyclerView.z zVar) {
        updateMeasurements();
        ensureViewSet();
        return super.scrollHorizontallyBy(i2, vVar, zVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int scrollVerticallyBy(int i2, RecyclerView.v vVar, RecyclerView.z zVar) {
        updateMeasurements();
        ensureViewSet();
        return super.scrollVerticallyBy(i2, vVar, zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void setMeasuredDimension(Rect rect, int i2, int i3) {
        int iChooseSize;
        int iChooseSize2;
        if (this.mCachedBorders == null) {
            super.setMeasuredDimension(rect, i2, i3);
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.mOrientation == 1) {
            iChooseSize2 = RecyclerView.o.chooseSize(i3, rect.height() + paddingTop, getMinimumHeight());
            int[] iArr = this.mCachedBorders;
            iChooseSize = RecyclerView.o.chooseSize(i2, iArr[iArr.length - 1] + paddingLeft, getMinimumWidth());
        } else {
            iChooseSize = RecyclerView.o.chooseSize(i2, rect.width() + paddingLeft, getMinimumWidth());
            int[] iArr2 = this.mCachedBorders;
            iChooseSize2 = RecyclerView.o.chooseSize(i3, iArr2[iArr2.length - 1] + paddingTop, getMinimumHeight());
        }
        setMeasuredDimension(iChooseSize, iChooseSize2);
    }

    public void setSpanCount(int i2) {
        if (i2 == this.mSpanCount) {
            return;
        }
        this.mPendingSpanCountChange = true;
        if (i2 >= 1) {
            this.mSpanCount = i2;
            this.mSpanSizeLookup.invalidateSpanIndexCache();
            requestLayout();
        } else {
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + i2);
        }
    }

    public void setSpanSizeLookup(c cVar) {
        this.mSpanSizeLookup = cVar;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void setStackFromEnd(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.setStackFromEnd(false);
    }

    public void setUsingSpansToEstimateScrollbarDimensions(boolean z) {
        this.mUsingSpansToEstimateScrollBarDimensions = z;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && !this.mPendingSpanCountChange;
    }

    static int[] calculateItemBorders(int[] iArr, int i2, int i3) {
        int i4;
        if (iArr == null || iArr.length != i2 + 1 || iArr[iArr.length - 1] != i3) {
            iArr = new int[i2 + 1];
        }
        int i5 = 0;
        iArr[0] = 0;
        int i6 = i3 / i2;
        int i7 = i3 % i2;
        int i8 = 0;
        for (int i9 = 1; i9 <= i2; i9++) {
            i5 += i7;
            if (i5 <= 0 || i2 - i5 >= i7) {
                i4 = i6;
            } else {
                i4 = i6 + 1;
                i5 -= i2;
            }
            i8 += i4;
            iArr[i9] = i8;
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new b((ViewGroup.MarginLayoutParams) layoutParams) : new b(layoutParams);
    }

    public static class b extends RecyclerView.p {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f1896e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f1897f;

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1896e = -1;
            this.f1897f = 0;
        }

        public int e() {
            return this.f1896e;
        }

        public int f() {
            return this.f1897f;
        }

        public b(int i2, int i3) {
            super(i2, i3);
            this.f1896e = -1;
            this.f1897f = 0;
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f1896e = -1;
            this.f1897f = 0;
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1896e = -1;
            this.f1897f = 0;
        }
    }

    public GridLayoutManager(Context context, int i2) {
        super(context);
        this.mPendingSpanCountChange = false;
        this.mSpanCount = -1;
        this.mPreLayoutSpanSizeCache = new SparseIntArray();
        this.mPreLayoutSpanIndexCache = new SparseIntArray();
        this.mSpanSizeLookup = new a();
        this.mDecorInsets = new Rect();
        setSpanCount(i2);
    }

    public GridLayoutManager(Context context, int i2, int i3, boolean z) {
        super(context, i3, z);
        this.mPendingSpanCountChange = false;
        this.mSpanCount = -1;
        this.mPreLayoutSpanSizeCache = new SparseIntArray();
        this.mPreLayoutSpanIndexCache = new SparseIntArray();
        this.mSpanSizeLookup = new a();
        this.mDecorInsets = new Rect();
        setSpanCount(i2);
    }
}
