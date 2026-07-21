package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LinearLayoutManager extends RecyclerView.o implements RecyclerView.y.b {
    static final boolean DEBUG = false;
    public static final int HORIZONTAL = 0;
    public static final int INVALID_OFFSET = Integer.MIN_VALUE;
    private static final float MAX_SCROLL_FACTOR = 0.33333334f;
    private static final String TAG = "LinearLayoutManager";
    public static final int VERTICAL = 1;
    final a mAnchorInfo;
    private int mInitialPrefetchItemCount;
    private boolean mLastStackFromEnd;
    private final b mLayoutChunkResult;
    private c mLayoutState;
    int mOrientation;
    n mOrientationHelper;
    SavedState mPendingSavedState;
    int mPendingScrollPosition;
    int mPendingScrollPositionOffset;
    private boolean mRecycleChildrenOnDetach;
    private int[] mReusableIntPair;
    private boolean mReverseLayout;
    boolean mShouldReverseLayout;
    private boolean mSmoothScrollbarEnabled;
    private boolean mStackFromEnd;

    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f1898f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f1899g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        boolean f1900h;

        static class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        }

        public SavedState() {
        }

        boolean a() {
            return this.f1898f >= 0;
        }

        void b() {
            this.f1898f = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f1898f);
            parcel.writeInt(this.f1899g);
            parcel.writeInt(this.f1900h ? 1 : 0);
        }

        SavedState(Parcel parcel) {
            this.f1898f = parcel.readInt();
            this.f1899g = parcel.readInt();
            this.f1900h = parcel.readInt() == 1;
        }

        public SavedState(SavedState savedState) {
            this.f1898f = savedState.f1898f;
            this.f1899g = savedState.f1899g;
            this.f1900h = savedState.f1900h;
        }
    }

    static class a {
        n a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f1901b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f1902c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f1903d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f1904e;

        a() {
            e();
        }

        void a() {
            this.f1902c = this.f1903d ? this.a.i() : this.a.m();
        }

        public void b(View view, int i2) {
            if (this.f1903d) {
                this.f1902c = this.a.d(view) + this.a.o();
            } else {
                this.f1902c = this.a.g(view);
            }
            this.f1901b = i2;
        }

        public void c(View view, int i2) {
            int iO = this.a.o();
            if (iO >= 0) {
                b(view, i2);
                return;
            }
            this.f1901b = i2;
            if (this.f1903d) {
                int i3 = (this.a.i() - iO) - this.a.d(view);
                this.f1902c = this.a.i() - i3;
                if (i3 > 0) {
                    int iE = this.f1902c - this.a.e(view);
                    int iM = this.a.m();
                    int iMin = iE - (iM + Math.min(this.a.g(view) - iM, 0));
                    if (iMin < 0) {
                        this.f1902c += Math.min(i3, -iMin);
                        return;
                    }
                    return;
                }
                return;
            }
            int iG = this.a.g(view);
            int iM2 = iG - this.a.m();
            this.f1902c = iG;
            if (iM2 > 0) {
                int i4 = (this.a.i() - Math.min(0, (this.a.i() - iO) - this.a.d(view))) - (iG + this.a.e(view));
                if (i4 < 0) {
                    this.f1902c -= Math.min(iM2, -i4);
                }
            }
        }

        boolean d(View view, RecyclerView.z zVar) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return !pVar.c() && pVar.a() >= 0 && pVar.a() < zVar.b();
        }

        void e() {
            this.f1901b = -1;
            this.f1902c = Integer.MIN_VALUE;
            this.f1903d = false;
            this.f1904e = false;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f1901b + ", mCoordinate=" + this.f1902c + ", mLayoutFromEnd=" + this.f1903d + ", mValid=" + this.f1904e + '}';
        }
    }

    protected static class b {
        public int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f1905b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f1906c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f1907d;

        protected b() {
        }

        void a() {
            this.a = 0;
            this.f1905b = false;
            this.f1906c = false;
            this.f1907d = false;
        }
    }

    static class c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f1908b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f1909c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f1910d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f1911e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f1912f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f1913g;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        int f1917k;
        boolean m;
        boolean a = true;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f1914h = 0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f1915i = 0;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        boolean f1916j = false;
        List<RecyclerView.c0> l = null;

        c() {
        }

        private View e() {
            int size = this.l.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = this.l.get(i2).itemView;
                RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
                if (!pVar.c() && this.f1910d == pVar.a()) {
                    b(view);
                    return view;
                }
            }
            return null;
        }

        public void a() {
            b(null);
        }

        public void b(View view) {
            View viewF = f(view);
            if (viewF == null) {
                this.f1910d = -1;
            } else {
                this.f1910d = ((RecyclerView.p) viewF.getLayoutParams()).a();
            }
        }

        boolean c(RecyclerView.z zVar) {
            int i2 = this.f1910d;
            return i2 >= 0 && i2 < zVar.b();
        }

        View d(RecyclerView.v vVar) {
            if (this.l != null) {
                return e();
            }
            View viewO = vVar.o(this.f1910d);
            this.f1910d += this.f1911e;
            return viewO;
        }

        public View f(View view) {
            int iA;
            int size = this.l.size();
            View view2 = null;
            int i2 = Integer.MAX_VALUE;
            for (int i3 = 0; i3 < size; i3++) {
                View view3 = this.l.get(i3).itemView;
                RecyclerView.p pVar = (RecyclerView.p) view3.getLayoutParams();
                if (view3 != view && !pVar.c() && (iA = (pVar.a() - this.f1910d) * this.f1911e) >= 0 && iA < i2) {
                    view2 = view3;
                    if (iA == 0) {
                        break;
                    }
                    i2 = iA;
                }
            }
            return view2;
        }
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    private int computeScrollExtent(RecyclerView.z zVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return p.a(zVar, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    private int computeScrollOffset(RecyclerView.z zVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return p.b(zVar, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }

    private int computeScrollRange(RecyclerView.z zVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return p.c(zVar, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    private View findFirstPartiallyOrCompletelyInvisibleChild() {
        return findOnePartiallyOrCompletelyInvisibleChild(0, getChildCount());
    }

    private View findFirstReferenceChild(RecyclerView.v vVar, RecyclerView.z zVar) {
        return findReferenceChild(vVar, zVar, 0, getChildCount(), zVar.b());
    }

    private View findLastPartiallyOrCompletelyInvisibleChild() {
        return findOnePartiallyOrCompletelyInvisibleChild(getChildCount() - 1, -1);
    }

    private View findLastReferenceChild(RecyclerView.v vVar, RecyclerView.z zVar) {
        return findReferenceChild(vVar, zVar, getChildCount() - 1, -1, zVar.b());
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToEnd() {
        return this.mShouldReverseLayout ? findFirstPartiallyOrCompletelyInvisibleChild() : findLastPartiallyOrCompletelyInvisibleChild();
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToStart() {
        return this.mShouldReverseLayout ? findLastPartiallyOrCompletelyInvisibleChild() : findFirstPartiallyOrCompletelyInvisibleChild();
    }

    private View findReferenceChildClosestToEnd(RecyclerView.v vVar, RecyclerView.z zVar) {
        return this.mShouldReverseLayout ? findFirstReferenceChild(vVar, zVar) : findLastReferenceChild(vVar, zVar);
    }

    private View findReferenceChildClosestToStart(RecyclerView.v vVar, RecyclerView.z zVar) {
        return this.mShouldReverseLayout ? findLastReferenceChild(vVar, zVar) : findFirstReferenceChild(vVar, zVar);
    }

    private int fixLayoutEndGap(int i2, RecyclerView.v vVar, RecyclerView.z zVar, boolean z) {
        int i3;
        int i4 = this.mOrientationHelper.i() - i2;
        if (i4 <= 0) {
            return 0;
        }
        int i5 = -scrollBy(-i4, vVar, zVar);
        int i6 = i2 + i5;
        if (!z || (i3 = this.mOrientationHelper.i() - i6) <= 0) {
            return i5;
        }
        this.mOrientationHelper.r(i3);
        return i3 + i5;
    }

    private int fixLayoutStartGap(int i2, RecyclerView.v vVar, RecyclerView.z zVar, boolean z) {
        int iM;
        int iM2 = i2 - this.mOrientationHelper.m();
        if (iM2 <= 0) {
            return 0;
        }
        int i3 = -scrollBy(iM2, vVar, zVar);
        int i4 = i2 + i3;
        if (!z || (iM = i4 - this.mOrientationHelper.m()) <= 0) {
            return i3;
        }
        this.mOrientationHelper.r(-iM);
        return i3 - iM;
    }

    private View getChildClosestToEnd() {
        return getChildAt(this.mShouldReverseLayout ? 0 : getChildCount() - 1);
    }

    private View getChildClosestToStart() {
        return getChildAt(this.mShouldReverseLayout ? getChildCount() - 1 : 0);
    }

    private void layoutForPredictiveAnimations(RecyclerView.v vVar, RecyclerView.z zVar, int i2, int i3) {
        if (!zVar.g() || getChildCount() == 0 || zVar.e() || !supportsPredictiveItemAnimations()) {
            return;
        }
        List<RecyclerView.c0> listK = vVar.k();
        int size = listK.size();
        int position = getPosition(getChildAt(0));
        int iE = 0;
        int iE2 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            RecyclerView.c0 c0Var = listK.get(i4);
            if (!c0Var.isRemoved()) {
                if (((c0Var.getLayoutPosition() < position) != this.mShouldReverseLayout ? (byte) -1 : (byte) 1) == -1) {
                    iE += this.mOrientationHelper.e(c0Var.itemView);
                } else {
                    iE2 += this.mOrientationHelper.e(c0Var.itemView);
                }
            }
        }
        this.mLayoutState.l = listK;
        if (iE > 0) {
            updateLayoutStateToFillStart(getPosition(getChildClosestToStart()), i2);
            c cVar = this.mLayoutState;
            cVar.f1914h = iE;
            cVar.f1909c = 0;
            cVar.a();
            fill(vVar, this.mLayoutState, zVar, false);
        }
        if (iE2 > 0) {
            updateLayoutStateToFillEnd(getPosition(getChildClosestToEnd()), i3);
            c cVar2 = this.mLayoutState;
            cVar2.f1914h = iE2;
            cVar2.f1909c = 0;
            cVar2.a();
            fill(vVar, this.mLayoutState, zVar, false);
        }
        this.mLayoutState.l = null;
    }

    private void logChildren() {
        Log.d(TAG, "internal representation of views on the screen");
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            Log.d(TAG, "item " + getPosition(childAt) + ", coord:" + this.mOrientationHelper.g(childAt));
        }
        Log.d(TAG, "==============");
    }

    private void recycleByLayoutState(RecyclerView.v vVar, c cVar) {
        if (!cVar.a || cVar.m) {
            return;
        }
        int i2 = cVar.f1913g;
        int i3 = cVar.f1915i;
        if (cVar.f1912f == -1) {
            recycleViewsFromEnd(vVar, i2, i3);
        } else {
            recycleViewsFromStart(vVar, i2, i3);
        }
    }

    private void recycleChildren(RecyclerView.v vVar, int i2, int i3) {
        if (i2 == i3) {
            return;
        }
        if (i3 <= i2) {
            while (i2 > i3) {
                removeAndRecycleViewAt(i2, vVar);
                i2--;
            }
        } else {
            for (int i4 = i3 - 1; i4 >= i2; i4--) {
                removeAndRecycleViewAt(i4, vVar);
            }
        }
    }

    private void recycleViewsFromEnd(RecyclerView.v vVar, int i2, int i3) {
        int childCount = getChildCount();
        if (i2 < 0) {
            return;
        }
        int iH = (this.mOrientationHelper.h() - i2) + i3;
        if (this.mShouldReverseLayout) {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (this.mOrientationHelper.g(childAt) < iH || this.mOrientationHelper.q(childAt) < iH) {
                    recycleChildren(vVar, 0, i4);
                    return;
                }
            }
            return;
        }
        int i5 = childCount - 1;
        for (int i6 = i5; i6 >= 0; i6--) {
            View childAt2 = getChildAt(i6);
            if (this.mOrientationHelper.g(childAt2) < iH || this.mOrientationHelper.q(childAt2) < iH) {
                recycleChildren(vVar, i5, i6);
                return;
            }
        }
    }

    private void recycleViewsFromStart(RecyclerView.v vVar, int i2, int i3) {
        if (i2 < 0) {
            return;
        }
        int i4 = i2 - i3;
        int childCount = getChildCount();
        if (!this.mShouldReverseLayout) {
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                if (this.mOrientationHelper.d(childAt) > i4 || this.mOrientationHelper.p(childAt) > i4) {
                    recycleChildren(vVar, 0, i5);
                    return;
                }
            }
            return;
        }
        int i6 = childCount - 1;
        for (int i7 = i6; i7 >= 0; i7--) {
            View childAt2 = getChildAt(i7);
            if (this.mOrientationHelper.d(childAt2) > i4 || this.mOrientationHelper.p(childAt2) > i4) {
                recycleChildren(vVar, i6, i7);
                return;
            }
        }
    }

    private void resolveShouldLayoutReverse() {
        if (this.mOrientation == 1 || !isLayoutRTL()) {
            this.mShouldReverseLayout = this.mReverseLayout;
        } else {
            this.mShouldReverseLayout = !this.mReverseLayout;
        }
    }

    private boolean updateAnchorFromChildren(RecyclerView.v vVar, RecyclerView.z zVar, a aVar) {
        if (getChildCount() == 0) {
            return false;
        }
        View focusedChild = getFocusedChild();
        if (focusedChild != null && aVar.d(focusedChild, zVar)) {
            aVar.c(focusedChild, getPosition(focusedChild));
            return true;
        }
        if (this.mLastStackFromEnd != this.mStackFromEnd) {
            return false;
        }
        View viewFindReferenceChildClosestToEnd = aVar.f1903d ? findReferenceChildClosestToEnd(vVar, zVar) : findReferenceChildClosestToStart(vVar, zVar);
        if (viewFindReferenceChildClosestToEnd == null) {
            return false;
        }
        aVar.b(viewFindReferenceChildClosestToEnd, getPosition(viewFindReferenceChildClosestToEnd));
        if (!zVar.e() && supportsPredictiveItemAnimations()) {
            if (this.mOrientationHelper.g(viewFindReferenceChildClosestToEnd) >= this.mOrientationHelper.i() || this.mOrientationHelper.d(viewFindReferenceChildClosestToEnd) < this.mOrientationHelper.m()) {
                aVar.f1902c = aVar.f1903d ? this.mOrientationHelper.i() : this.mOrientationHelper.m();
            }
        }
        return true;
    }

    private boolean updateAnchorFromPendingData(RecyclerView.z zVar, a aVar) {
        int i2;
        if (!zVar.e() && (i2 = this.mPendingScrollPosition) != -1) {
            if (i2 >= 0 && i2 < zVar.b()) {
                aVar.f1901b = this.mPendingScrollPosition;
                SavedState savedState = this.mPendingSavedState;
                if (savedState != null && savedState.a()) {
                    boolean z = this.mPendingSavedState.f1900h;
                    aVar.f1903d = z;
                    if (z) {
                        aVar.f1902c = this.mOrientationHelper.i() - this.mPendingSavedState.f1899g;
                    } else {
                        aVar.f1902c = this.mOrientationHelper.m() + this.mPendingSavedState.f1899g;
                    }
                    return true;
                }
                if (this.mPendingScrollPositionOffset != Integer.MIN_VALUE) {
                    boolean z2 = this.mShouldReverseLayout;
                    aVar.f1903d = z2;
                    if (z2) {
                        aVar.f1902c = this.mOrientationHelper.i() - this.mPendingScrollPositionOffset;
                    } else {
                        aVar.f1902c = this.mOrientationHelper.m() + this.mPendingScrollPositionOffset;
                    }
                    return true;
                }
                View viewFindViewByPosition = findViewByPosition(this.mPendingScrollPosition);
                if (viewFindViewByPosition == null) {
                    if (getChildCount() > 0) {
                        aVar.f1903d = (this.mPendingScrollPosition < getPosition(getChildAt(0))) == this.mShouldReverseLayout;
                    }
                    aVar.a();
                } else {
                    if (this.mOrientationHelper.e(viewFindViewByPosition) > this.mOrientationHelper.n()) {
                        aVar.a();
                        return true;
                    }
                    if (this.mOrientationHelper.g(viewFindViewByPosition) - this.mOrientationHelper.m() < 0) {
                        aVar.f1902c = this.mOrientationHelper.m();
                        aVar.f1903d = false;
                        return true;
                    }
                    if (this.mOrientationHelper.i() - this.mOrientationHelper.d(viewFindViewByPosition) < 0) {
                        aVar.f1902c = this.mOrientationHelper.i();
                        aVar.f1903d = true;
                        return true;
                    }
                    aVar.f1902c = aVar.f1903d ? this.mOrientationHelper.d(viewFindViewByPosition) + this.mOrientationHelper.o() : this.mOrientationHelper.g(viewFindViewByPosition);
                }
                return true;
            }
            this.mPendingScrollPosition = -1;
            this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        }
        return false;
    }

    private void updateAnchorInfoForLayout(RecyclerView.v vVar, RecyclerView.z zVar, a aVar) {
        if (updateAnchorFromPendingData(zVar, aVar) || updateAnchorFromChildren(vVar, zVar, aVar)) {
            return;
        }
        aVar.a();
        aVar.f1901b = this.mStackFromEnd ? zVar.b() - 1 : 0;
    }

    private void updateLayoutState(int i2, int i3, boolean z, RecyclerView.z zVar) {
        int iM;
        this.mLayoutState.m = resolveIsInfinite();
        this.mLayoutState.f1912f = i2;
        int[] iArr = this.mReusableIntPair;
        iArr[0] = 0;
        iArr[1] = 0;
        calculateExtraLayoutSpace(zVar, iArr);
        int iMax = Math.max(0, this.mReusableIntPair[0]);
        int iMax2 = Math.max(0, this.mReusableIntPair[1]);
        boolean z2 = i2 == 1;
        c cVar = this.mLayoutState;
        int i4 = z2 ? iMax2 : iMax;
        cVar.f1914h = i4;
        if (!z2) {
            iMax = iMax2;
        }
        cVar.f1915i = iMax;
        if (z2) {
            cVar.f1914h = i4 + this.mOrientationHelper.j();
            View childClosestToEnd = getChildClosestToEnd();
            c cVar2 = this.mLayoutState;
            cVar2.f1911e = this.mShouldReverseLayout ? -1 : 1;
            int position = getPosition(childClosestToEnd);
            c cVar3 = this.mLayoutState;
            cVar2.f1910d = position + cVar3.f1911e;
            cVar3.f1908b = this.mOrientationHelper.d(childClosestToEnd);
            iM = this.mOrientationHelper.d(childClosestToEnd) - this.mOrientationHelper.i();
        } else {
            View childClosestToStart = getChildClosestToStart();
            this.mLayoutState.f1914h += this.mOrientationHelper.m();
            c cVar4 = this.mLayoutState;
            cVar4.f1911e = this.mShouldReverseLayout ? 1 : -1;
            int position2 = getPosition(childClosestToStart);
            c cVar5 = this.mLayoutState;
            cVar4.f1910d = position2 + cVar5.f1911e;
            cVar5.f1908b = this.mOrientationHelper.g(childClosestToStart);
            iM = (-this.mOrientationHelper.g(childClosestToStart)) + this.mOrientationHelper.m();
        }
        c cVar6 = this.mLayoutState;
        cVar6.f1909c = i3;
        if (z) {
            cVar6.f1909c = i3 - iM;
        }
        cVar6.f1913g = iM;
    }

    private void updateLayoutStateToFillEnd(a aVar) {
        updateLayoutStateToFillEnd(aVar.f1901b, aVar.f1902c);
    }

    private void updateLayoutStateToFillStart(a aVar) {
        updateLayoutStateToFillStart(aVar.f1901b, aVar.f1902c);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void assertNotInLayoutOrScroll(String str) {
        if (this.mPendingSavedState == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    protected void calculateExtraLayoutSpace(RecyclerView.z zVar, int[] iArr) {
        int i2;
        int extraLayoutSpace = getExtraLayoutSpace(zVar);
        if (this.mLayoutState.f1912f == -1) {
            i2 = 0;
        } else {
            i2 = extraLayoutSpace;
            extraLayoutSpace = 0;
        }
        iArr[0] = extraLayoutSpace;
        iArr[1] = i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean canScrollHorizontally() {
        return this.mOrientation == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean canScrollVertically() {
        return this.mOrientation == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void collectAdjacentPrefetchPositions(int i2, int i3, RecyclerView.z zVar, RecyclerView.o.c cVar) {
        if (this.mOrientation != 0) {
            i2 = i3;
        }
        if (getChildCount() == 0 || i2 == 0) {
            return;
        }
        ensureLayoutState();
        updateLayoutState(i2 > 0 ? 1 : -1, Math.abs(i2), true, zVar);
        collectPrefetchPositionsForLayoutState(zVar, this.mLayoutState, cVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void collectInitialPrefetchPositions(int i2, RecyclerView.o.c cVar) {
        boolean z;
        int i3;
        SavedState savedState = this.mPendingSavedState;
        if (savedState == null || !savedState.a()) {
            resolveShouldLayoutReverse();
            z = this.mShouldReverseLayout;
            i3 = this.mPendingScrollPosition;
            if (i3 == -1) {
                i3 = z ? i2 - 1 : 0;
            }
        } else {
            SavedState savedState2 = this.mPendingSavedState;
            z = savedState2.f1900h;
            i3 = savedState2.f1898f;
        }
        int i4 = z ? -1 : 1;
        for (int i5 = 0; i5 < this.mInitialPrefetchItemCount && i3 >= 0 && i3 < i2; i5++) {
            cVar.a(i3, 0);
            i3 += i4;
        }
    }

    void collectPrefetchPositionsForLayoutState(RecyclerView.z zVar, c cVar, RecyclerView.o.c cVar2) {
        int i2 = cVar.f1910d;
        if (i2 < 0 || i2 >= zVar.b()) {
            return;
        }
        cVar2.a(i2, Math.max(0, cVar.f1913g));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int computeHorizontalScrollExtent(RecyclerView.z zVar) {
        return computeScrollExtent(zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int computeHorizontalScrollOffset(RecyclerView.z zVar) {
        return computeScrollOffset(zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int computeHorizontalScrollRange(RecyclerView.z zVar) {
        return computeScrollRange(zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.y.b
    public PointF computeScrollVectorForPosition(int i2) {
        if (getChildCount() == 0) {
            return null;
        }
        int i3 = (i2 < getPosition(getChildAt(0))) != this.mShouldReverseLayout ? -1 : 1;
        return this.mOrientation == 0 ? new PointF(i3, 0.0f) : new PointF(0.0f, i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int computeVerticalScrollExtent(RecyclerView.z zVar) {
        return computeScrollExtent(zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int computeVerticalScrollOffset(RecyclerView.z zVar) {
        return computeScrollOffset(zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int computeVerticalScrollRange(RecyclerView.z zVar) {
        return computeScrollRange(zVar);
    }

    int convertFocusDirectionToLayoutDirection(int i2) {
        if (i2 == 1) {
            return (this.mOrientation != 1 && isLayoutRTL()) ? 1 : -1;
        }
        if (i2 == 2) {
            return (this.mOrientation != 1 && isLayoutRTL()) ? -1 : 1;
        }
        if (i2 == 17) {
            return this.mOrientation == 0 ? -1 : Integer.MIN_VALUE;
        }
        if (i2 == 33) {
            return this.mOrientation == 1 ? -1 : Integer.MIN_VALUE;
        }
        if (i2 != 66) {
            return (i2 == 130 && this.mOrientation == 1) ? 1 : Integer.MIN_VALUE;
        }
        return this.mOrientation == 0 ? 1 : Integer.MIN_VALUE;
    }

    c createLayoutState() {
        return new c();
    }

    void ensureLayoutState() {
        if (this.mLayoutState == null) {
            this.mLayoutState = createLayoutState();
        }
    }

    int fill(RecyclerView.v vVar, c cVar, RecyclerView.z zVar, boolean z) {
        int i2 = cVar.f1909c;
        int i3 = cVar.f1913g;
        if (i3 != Integer.MIN_VALUE) {
            if (i2 < 0) {
                cVar.f1913g = i3 + i2;
            }
            recycleByLayoutState(vVar, cVar);
        }
        int i4 = cVar.f1909c + cVar.f1914h;
        b bVar = this.mLayoutChunkResult;
        while (true) {
            if ((!cVar.m && i4 <= 0) || !cVar.c(zVar)) {
                break;
            }
            bVar.a();
            layoutChunk(vVar, zVar, cVar, bVar);
            if (!bVar.f1905b) {
                cVar.f1908b += bVar.a * cVar.f1912f;
                if (!bVar.f1906c || cVar.l != null || !zVar.e()) {
                    int i5 = cVar.f1909c;
                    int i6 = bVar.a;
                    cVar.f1909c = i5 - i6;
                    i4 -= i6;
                }
                int i7 = cVar.f1913g;
                if (i7 != Integer.MIN_VALUE) {
                    int i8 = i7 + bVar.a;
                    cVar.f1913g = i8;
                    int i9 = cVar.f1909c;
                    if (i9 < 0) {
                        cVar.f1913g = i8 + i9;
                    }
                    recycleByLayoutState(vVar, cVar);
                }
                if (z && bVar.f1907d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i2 - cVar.f1909c;
    }

    public int findFirstCompletelyVisibleItemPosition() {
        View viewFindOneVisibleChild = findOneVisibleChild(0, getChildCount(), true, false);
        if (viewFindOneVisibleChild == null) {
            return -1;
        }
        return getPosition(viewFindOneVisibleChild);
    }

    View findFirstVisibleChildClosestToEnd(boolean z, boolean z2) {
        return this.mShouldReverseLayout ? findOneVisibleChild(0, getChildCount(), z, z2) : findOneVisibleChild(getChildCount() - 1, -1, z, z2);
    }

    View findFirstVisibleChildClosestToStart(boolean z, boolean z2) {
        return this.mShouldReverseLayout ? findOneVisibleChild(getChildCount() - 1, -1, z, z2) : findOneVisibleChild(0, getChildCount(), z, z2);
    }

    public int findFirstVisibleItemPosition() {
        View viewFindOneVisibleChild = findOneVisibleChild(0, getChildCount(), false, true);
        if (viewFindOneVisibleChild == null) {
            return -1;
        }
        return getPosition(viewFindOneVisibleChild);
    }

    public int findLastCompletelyVisibleItemPosition() {
        View viewFindOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, true, false);
        if (viewFindOneVisibleChild == null) {
            return -1;
        }
        return getPosition(viewFindOneVisibleChild);
    }

    public int findLastVisibleItemPosition() {
        View viewFindOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, false, true);
        if (viewFindOneVisibleChild == null) {
            return -1;
        }
        return getPosition(viewFindOneVisibleChild);
    }

    View findOnePartiallyOrCompletelyInvisibleChild(int i2, int i3) {
        byte b2;
        int i4;
        int i5;
        ensureLayoutState();
        if (i3 > i2) {
            b2 = 1;
        } else {
            b2 = i3 < i2 ? (byte) -1 : (byte) 0;
        }
        if (b2 == 0) {
            return getChildAt(i2);
        }
        if (this.mOrientationHelper.g(getChildAt(i2)) < this.mOrientationHelper.m()) {
            i4 = 16644;
            i5 = 16388;
        } else {
            i4 = 4161;
            i5 = 4097;
        }
        return this.mOrientation == 0 ? this.mHorizontalBoundCheck.a(i2, i3, i4, i5) : this.mVerticalBoundCheck.a(i2, i3, i4, i5);
    }

    View findOneVisibleChild(int i2, int i3, boolean z, boolean z2) {
        ensureLayoutState();
        int i4 = z ? 24579 : 320;
        int i5 = z2 ? 320 : 0;
        return this.mOrientation == 0 ? this.mHorizontalBoundCheck.a(i2, i3, i4, i5) : this.mVerticalBoundCheck.a(i2, i3, i4, i5);
    }

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
            if (position >= 0 && position < i4) {
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

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View findViewByPosition(int i2) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return null;
        }
        int position = i2 - getPosition(getChildAt(0));
        if (position >= 0 && position < childCount) {
            View childAt = getChildAt(position);
            if (getPosition(childAt) == i2) {
                return childAt;
            }
        }
        return super.findViewByPosition(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p generateDefaultLayoutParams() {
        return new RecyclerView.p(-2, -2);
    }

    @Deprecated
    protected int getExtraLayoutSpace(RecyclerView.z zVar) {
        if (zVar.d()) {
            return this.mOrientationHelper.n();
        }
        return 0;
    }

    public int getInitialPrefetchItemCount() {
        return this.mInitialPrefetchItemCount;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.mRecycleChildrenOnDetach;
    }

    public boolean getReverseLayout() {
        return this.mReverseLayout;
    }

    public boolean getStackFromEnd() {
        return this.mStackFromEnd;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    protected boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    public boolean isSmoothScrollbarEnabled() {
        return this.mSmoothScrollbarEnabled;
    }

    void layoutChunk(RecyclerView.v vVar, RecyclerView.z zVar, c cVar, b bVar) {
        int i2;
        int i3;
        int i4;
        int paddingLeft;
        int iF;
        View viewD = cVar.d(vVar);
        if (viewD == null) {
            bVar.f1905b = true;
            return;
        }
        RecyclerView.p pVar = (RecyclerView.p) viewD.getLayoutParams();
        if (cVar.l == null) {
            if (this.mShouldReverseLayout == (cVar.f1912f == -1)) {
                addView(viewD);
            } else {
                addView(viewD, 0);
            }
        } else {
            if (this.mShouldReverseLayout == (cVar.f1912f == -1)) {
                addDisappearingView(viewD);
            } else {
                addDisappearingView(viewD, 0);
            }
        }
        measureChildWithMargins(viewD, 0, 0);
        bVar.a = this.mOrientationHelper.e(viewD);
        if (this.mOrientation == 1) {
            if (isLayoutRTL()) {
                iF = getWidth() - getPaddingRight();
                paddingLeft = iF - this.mOrientationHelper.f(viewD);
            } else {
                paddingLeft = getPaddingLeft();
                iF = this.mOrientationHelper.f(viewD) + paddingLeft;
            }
            if (cVar.f1912f == -1) {
                int i5 = cVar.f1908b;
                i4 = i5;
                i3 = iF;
                i2 = i5 - bVar.a;
            } else {
                int i6 = cVar.f1908b;
                i2 = i6;
                i3 = iF;
                i4 = bVar.a + i6;
            }
        } else {
            int paddingTop = getPaddingTop();
            int iF2 = this.mOrientationHelper.f(viewD) + paddingTop;
            if (cVar.f1912f == -1) {
                int i7 = cVar.f1908b;
                i3 = i7;
                i2 = paddingTop;
                i4 = iF2;
                paddingLeft = i7 - bVar.a;
            } else {
                int i8 = cVar.f1908b;
                i2 = paddingTop;
                i3 = bVar.a + i8;
                i4 = iF2;
                paddingLeft = i8;
            }
        }
        layoutDecoratedWithMargins(viewD, paddingLeft, i2, i3, i4);
        if (pVar.c() || pVar.b()) {
            bVar.f1906c = true;
        }
        bVar.f1907d = viewD.hasFocusable();
    }

    void onAnchorReady(RecyclerView.v vVar, RecyclerView.z zVar, a aVar, int i2) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.v vVar) {
        super.onDetachedFromWindow(recyclerView, vVar);
        if (this.mRecycleChildrenOnDetach) {
            removeAndRecycleAllViews(vVar);
            vVar.c();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View onFocusSearchFailed(View view, int i2, RecyclerView.v vVar, RecyclerView.z zVar) {
        int iConvertFocusDirectionToLayoutDirection;
        resolveShouldLayoutReverse();
        if (getChildCount() == 0 || (iConvertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i2)) == Integer.MIN_VALUE) {
            return null;
        }
        ensureLayoutState();
        updateLayoutState(iConvertFocusDirectionToLayoutDirection, (int) (this.mOrientationHelper.n() * MAX_SCROLL_FACTOR), false, zVar);
        c cVar = this.mLayoutState;
        cVar.f1913g = Integer.MIN_VALUE;
        cVar.a = false;
        fill(vVar, cVar, zVar, true);
        View viewFindPartiallyOrCompletelyInvisibleChildClosestToStart = iConvertFocusDirectionToLayoutDirection == -1 ? findPartiallyOrCompletelyInvisibleChildClosestToStart() : findPartiallyOrCompletelyInvisibleChildClosestToEnd();
        View childClosestToStart = iConvertFocusDirectionToLayoutDirection == -1 ? getChildClosestToStart() : getChildClosestToEnd();
        if (!childClosestToStart.hasFocusable()) {
            return viewFindPartiallyOrCompletelyInvisibleChildClosestToStart;
        }
        if (viewFindPartiallyOrCompletelyInvisibleChildClosestToStart == null) {
            return null;
        }
        return childClosestToStart;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            accessibilityEvent.setFromIndex(findFirstVisibleItemPosition());
            accessibilityEvent.setToIndex(findLastVisibleItemPosition());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onLayoutChildren(RecyclerView.v vVar, RecyclerView.z zVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        int iFixLayoutEndGap;
        int i6;
        View viewFindViewByPosition;
        int iG;
        int i7;
        int i8 = -1;
        if (!(this.mPendingSavedState == null && this.mPendingScrollPosition == -1) && zVar.b() == 0) {
            removeAndRecycleAllViews(vVar);
            return;
        }
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null && savedState.a()) {
            this.mPendingScrollPosition = this.mPendingSavedState.f1898f;
        }
        ensureLayoutState();
        this.mLayoutState.a = false;
        resolveShouldLayoutReverse();
        View focusedChild = getFocusedChild();
        a aVar = this.mAnchorInfo;
        if (!aVar.f1904e || this.mPendingScrollPosition != -1 || this.mPendingSavedState != null) {
            aVar.e();
            a aVar2 = this.mAnchorInfo;
            aVar2.f1903d = this.mShouldReverseLayout ^ this.mStackFromEnd;
            updateAnchorInfoForLayout(vVar, zVar, aVar2);
            this.mAnchorInfo.f1904e = true;
        } else if (focusedChild != null && (this.mOrientationHelper.g(focusedChild) >= this.mOrientationHelper.i() || this.mOrientationHelper.d(focusedChild) <= this.mOrientationHelper.m())) {
            this.mAnchorInfo.c(focusedChild, getPosition(focusedChild));
        }
        c cVar = this.mLayoutState;
        cVar.f1912f = cVar.f1917k >= 0 ? 1 : -1;
        int[] iArr = this.mReusableIntPair;
        iArr[0] = 0;
        iArr[1] = 0;
        calculateExtraLayoutSpace(zVar, iArr);
        int iMax = Math.max(0, this.mReusableIntPair[0]) + this.mOrientationHelper.m();
        int iMax2 = Math.max(0, this.mReusableIntPair[1]) + this.mOrientationHelper.j();
        if (zVar.e() && (i6 = this.mPendingScrollPosition) != -1 && this.mPendingScrollPositionOffset != Integer.MIN_VALUE && (viewFindViewByPosition = findViewByPosition(i6)) != null) {
            if (this.mShouldReverseLayout) {
                i7 = this.mOrientationHelper.i() - this.mOrientationHelper.d(viewFindViewByPosition);
                iG = this.mPendingScrollPositionOffset;
            } else {
                iG = this.mOrientationHelper.g(viewFindViewByPosition) - this.mOrientationHelper.m();
                i7 = this.mPendingScrollPositionOffset;
            }
            int i9 = i7 - iG;
            if (i9 > 0) {
                iMax += i9;
            } else {
                iMax2 -= i9;
            }
        }
        a aVar3 = this.mAnchorInfo;
        if (!aVar3.f1903d ? !this.mShouldReverseLayout : this.mShouldReverseLayout) {
            i8 = 1;
        }
        onAnchorReady(vVar, zVar, aVar3, i8);
        detachAndScrapAttachedViews(vVar);
        this.mLayoutState.m = resolveIsInfinite();
        this.mLayoutState.f1916j = zVar.e();
        this.mLayoutState.f1915i = 0;
        a aVar4 = this.mAnchorInfo;
        if (aVar4.f1903d) {
            updateLayoutStateToFillStart(aVar4);
            c cVar2 = this.mLayoutState;
            cVar2.f1914h = iMax;
            fill(vVar, cVar2, zVar, false);
            c cVar3 = this.mLayoutState;
            i3 = cVar3.f1908b;
            int i10 = cVar3.f1910d;
            int i11 = cVar3.f1909c;
            if (i11 > 0) {
                iMax2 += i11;
            }
            updateLayoutStateToFillEnd(this.mAnchorInfo);
            c cVar4 = this.mLayoutState;
            cVar4.f1914h = iMax2;
            cVar4.f1910d += cVar4.f1911e;
            fill(vVar, cVar4, zVar, false);
            c cVar5 = this.mLayoutState;
            i2 = cVar5.f1908b;
            int i12 = cVar5.f1909c;
            if (i12 > 0) {
                updateLayoutStateToFillStart(i10, i3);
                c cVar6 = this.mLayoutState;
                cVar6.f1914h = i12;
                fill(vVar, cVar6, zVar, false);
                i3 = this.mLayoutState.f1908b;
            }
        } else {
            updateLayoutStateToFillEnd(aVar4);
            c cVar7 = this.mLayoutState;
            cVar7.f1914h = iMax2;
            fill(vVar, cVar7, zVar, false);
            c cVar8 = this.mLayoutState;
            i2 = cVar8.f1908b;
            int i13 = cVar8.f1910d;
            int i14 = cVar8.f1909c;
            if (i14 > 0) {
                iMax += i14;
            }
            updateLayoutStateToFillStart(this.mAnchorInfo);
            c cVar9 = this.mLayoutState;
            cVar9.f1914h = iMax;
            cVar9.f1910d += cVar9.f1911e;
            fill(vVar, cVar9, zVar, false);
            c cVar10 = this.mLayoutState;
            i3 = cVar10.f1908b;
            int i15 = cVar10.f1909c;
            if (i15 > 0) {
                updateLayoutStateToFillEnd(i13, i2);
                c cVar11 = this.mLayoutState;
                cVar11.f1914h = i15;
                fill(vVar, cVar11, zVar, false);
                i2 = this.mLayoutState.f1908b;
            }
        }
        if (getChildCount() > 0) {
            if (this.mShouldReverseLayout ^ this.mStackFromEnd) {
                int iFixLayoutEndGap2 = fixLayoutEndGap(i2, vVar, zVar, true);
                i4 = i3 + iFixLayoutEndGap2;
                i5 = i2 + iFixLayoutEndGap2;
                iFixLayoutEndGap = fixLayoutStartGap(i4, vVar, zVar, false);
            } else {
                int iFixLayoutStartGap = fixLayoutStartGap(i3, vVar, zVar, true);
                i4 = i3 + iFixLayoutStartGap;
                i5 = i2 + iFixLayoutStartGap;
                iFixLayoutEndGap = fixLayoutEndGap(i5, vVar, zVar, false);
            }
            i3 = i4 + iFixLayoutEndGap;
            i2 = i5 + iFixLayoutEndGap;
        }
        layoutForPredictiveAnimations(vVar, zVar, i3, i2);
        if (zVar.e()) {
            this.mAnchorInfo.e();
        } else {
            this.mOrientationHelper.s();
        }
        this.mLastStackFromEnd = this.mStackFromEnd;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onLayoutCompleted(RecyclerView.z zVar) {
        super.onLayoutCompleted(zVar);
        this.mPendingSavedState = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mAnchorInfo.e();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.mPendingSavedState = (SavedState) parcelable;
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public Parcelable onSaveInstanceState() {
        if (this.mPendingSavedState != null) {
            return new SavedState(this.mPendingSavedState);
        }
        SavedState savedState = new SavedState();
        if (getChildCount() > 0) {
            ensureLayoutState();
            boolean z = this.mLastStackFromEnd ^ this.mShouldReverseLayout;
            savedState.f1900h = z;
            if (z) {
                View childClosestToEnd = getChildClosestToEnd();
                savedState.f1899g = this.mOrientationHelper.i() - this.mOrientationHelper.d(childClosestToEnd);
                savedState.f1898f = getPosition(childClosestToEnd);
            } else {
                View childClosestToStart = getChildClosestToStart();
                savedState.f1898f = getPosition(childClosestToStart);
                savedState.f1899g = this.mOrientationHelper.g(childClosestToStart) - this.mOrientationHelper.m();
            }
        } else {
            savedState.b();
        }
        return savedState;
    }

    public void prepareForDrop(View view, View view2, int i2, int i3) {
        assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
        ensureLayoutState();
        resolveShouldLayoutReverse();
        int position = getPosition(view);
        int position2 = getPosition(view2);
        byte b2 = position < position2 ? (byte) 1 : (byte) -1;
        if (this.mShouldReverseLayout) {
            if (b2 == 1) {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.i() - (this.mOrientationHelper.g(view2) + this.mOrientationHelper.e(view)));
                return;
            } else {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.i() - this.mOrientationHelper.d(view2));
                return;
            }
        }
        if (b2 == -1) {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.g(view2));
        } else {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.d(view2) - this.mOrientationHelper.e(view));
        }
    }

    boolean resolveIsInfinite() {
        return this.mOrientationHelper.k() == 0 && this.mOrientationHelper.h() == 0;
    }

    int scrollBy(int i2, RecyclerView.v vVar, RecyclerView.z zVar) {
        if (getChildCount() == 0 || i2 == 0) {
            return 0;
        }
        ensureLayoutState();
        this.mLayoutState.a = true;
        int i3 = i2 > 0 ? 1 : -1;
        int iAbs = Math.abs(i2);
        updateLayoutState(i3, iAbs, true, zVar);
        c cVar = this.mLayoutState;
        int iFill = cVar.f1913g + fill(vVar, cVar, zVar, false);
        if (iFill < 0) {
            return 0;
        }
        if (iAbs > iFill) {
            i2 = i3 * iFill;
        }
        this.mOrientationHelper.r(-i2);
        this.mLayoutState.f1917k = i2;
        return i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int scrollHorizontallyBy(int i2, RecyclerView.v vVar, RecyclerView.z zVar) {
        if (this.mOrientation == 1) {
            return 0;
        }
        return scrollBy(i2, vVar, zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void scrollToPosition(int i2) {
        this.mPendingScrollPosition = i2;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            savedState.b();
        }
        requestLayout();
    }

    public void scrollToPositionWithOffset(int i2, int i3) {
        this.mPendingScrollPosition = i2;
        this.mPendingScrollPositionOffset = i3;
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            savedState.b();
        }
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int scrollVerticallyBy(int i2, RecyclerView.v vVar, RecyclerView.z zVar) {
        if (this.mOrientation == 0) {
            return 0;
        }
        return scrollBy(i2, vVar, zVar);
    }

    public void setInitialPrefetchItemCount(int i2) {
        this.mInitialPrefetchItemCount = i2;
    }

    public void setOrientation(int i2) {
        if (i2 != 0 && i2 != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i2);
        }
        assertNotInLayoutOrScroll(null);
        if (i2 != this.mOrientation || this.mOrientationHelper == null) {
            n nVarB = n.b(this, i2);
            this.mOrientationHelper = nVarB;
            this.mAnchorInfo.a = nVarB;
            this.mOrientation = i2;
            requestLayout();
        }
    }

    public void setRecycleChildrenOnDetach(boolean z) {
        this.mRecycleChildrenOnDetach = z;
    }

    public void setReverseLayout(boolean z) {
        assertNotInLayoutOrScroll(null);
        if (z == this.mReverseLayout) {
            return;
        }
        this.mReverseLayout = z;
        requestLayout();
    }

    public void setSmoothScrollbarEnabled(boolean z) {
        this.mSmoothScrollbarEnabled = z;
    }

    public void setStackFromEnd(boolean z) {
        assertNotInLayoutOrScroll(null);
        if (this.mStackFromEnd == z) {
            return;
        }
        this.mStackFromEnd = z;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    boolean shouldMeasureTwice() {
        return (getHeightMode() == 1073741824 || getWidthMode() == 1073741824 || !hasFlexibleChildInBothOrientations()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.z zVar, int i2) {
        j jVar = new j(recyclerView.getContext());
        jVar.setTargetPosition(i2);
        startSmoothScroll(jVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && this.mLastStackFromEnd == this.mStackFromEnd;
    }

    void validateChildOrder() {
        Log.d(TAG, "validating child count " + getChildCount());
        if (getChildCount() < 1) {
            return;
        }
        int position = getPosition(getChildAt(0));
        int iG = this.mOrientationHelper.g(getChildAt(0));
        if (this.mShouldReverseLayout) {
            for (int i2 = 1; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                int position2 = getPosition(childAt);
                int iG2 = this.mOrientationHelper.g(childAt);
                if (position2 < position) {
                    logChildren();
                    StringBuilder sb = new StringBuilder();
                    sb.append("detected invalid position. loc invalid? ");
                    sb.append(iG2 < iG);
                    throw new RuntimeException(sb.toString());
                }
                if (iG2 > iG) {
                    logChildren();
                    throw new RuntimeException("detected invalid location");
                }
            }
            return;
        }
        for (int i3 = 1; i3 < getChildCount(); i3++) {
            View childAt2 = getChildAt(i3);
            int position3 = getPosition(childAt2);
            int iG3 = this.mOrientationHelper.g(childAt2);
            if (position3 < position) {
                logChildren();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("detected invalid position. loc invalid? ");
                sb2.append(iG3 < iG);
                throw new RuntimeException(sb2.toString());
            }
            if (iG3 < iG) {
                logChildren();
                throw new RuntimeException("detected invalid location");
            }
        }
    }

    public LinearLayoutManager(Context context, int i2, boolean z) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new a();
        this.mLayoutChunkResult = new b();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        setOrientation(i2);
        setReverseLayout(z);
    }

    private void updateLayoutStateToFillEnd(int i2, int i3) {
        this.mLayoutState.f1909c = this.mOrientationHelper.i() - i3;
        c cVar = this.mLayoutState;
        cVar.f1911e = this.mShouldReverseLayout ? -1 : 1;
        cVar.f1910d = i2;
        cVar.f1912f = 1;
        cVar.f1908b = i3;
        cVar.f1913g = Integer.MIN_VALUE;
    }

    private void updateLayoutStateToFillStart(int i2, int i3) {
        this.mLayoutState.f1909c = i3 - this.mOrientationHelper.m();
        c cVar = this.mLayoutState;
        cVar.f1910d = i2;
        cVar.f1911e = this.mShouldReverseLayout ? 1 : -1;
        cVar.f1912f = -1;
        cVar.f1908b = i3;
        cVar.f1913g = Integer.MIN_VALUE;
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new a();
        this.mLayoutChunkResult = new b();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        RecyclerView.o.d properties = RecyclerView.o.getProperties(context, attributeSet, i2, i3);
        setOrientation(properties.a);
        setReverseLayout(properties.f1931c);
        setStackFromEnd(properties.f1932d);
    }
}
