package cm.aptoide.pt.view.recycler;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.n;

/* JADX INFO: loaded from: classes.dex */
public class RecyclerViewPositionHelper {
    final RecyclerView.o layoutManager;
    final RecyclerView recyclerView;

    RecyclerViewPositionHelper(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
        this.layoutManager = recyclerView.getLayoutManager();
    }

    public static RecyclerViewPositionHelper createHelper(RecyclerView recyclerView) {
        if (recyclerView != null) {
            return new RecyclerViewPositionHelper(recyclerView);
        }
        throw new NullPointerException("Recycler View is null");
    }

    public int findFirstCompletelyVisibleItemPosition() {
        View viewFindOneVisibleChild = findOneVisibleChild(0, this.layoutManager.getChildCount(), true, false);
        if (viewFindOneVisibleChild == null) {
            return -1;
        }
        return this.recyclerView.getChildAdapterPosition(viewFindOneVisibleChild);
    }

    public int findFirstVisibleItemPosition() {
        View viewFindOneVisibleChild = findOneVisibleChild(0, this.layoutManager.getChildCount(), false, true);
        if (viewFindOneVisibleChild == null) {
            return -1;
        }
        return this.recyclerView.getChildAdapterPosition(viewFindOneVisibleChild);
    }

    public int findLastCompletelyVisibleItemPosition() {
        View viewFindOneVisibleChild = findOneVisibleChild(this.layoutManager.getChildCount() - 1, -1, true, false);
        if (viewFindOneVisibleChild == null) {
            return -1;
        }
        return this.recyclerView.getChildAdapterPosition(viewFindOneVisibleChild);
    }

    public int findLastVisibleItemPosition() {
        View viewFindOneVisibleChild = findOneVisibleChild(this.layoutManager.getChildCount() - 1, -1, false, true);
        if (viewFindOneVisibleChild == null) {
            return -1;
        }
        return this.recyclerView.getChildAdapterPosition(viewFindOneVisibleChild);
    }

    View findOneVisibleChild(int i2, int i3, boolean z, boolean z2) {
        n nVarC = this.layoutManager.canScrollVertically() ? n.c(this.layoutManager) : n.a(this.layoutManager);
        int iM = nVarC.m();
        int i4 = nVarC.i();
        int i5 = i3 > i2 ? 1 : -1;
        View view = null;
        while (i2 != i3) {
            View childAt = this.layoutManager.getChildAt(i2);
            int iG = nVarC.g(childAt);
            int iD = nVarC.d(childAt);
            if (iG < i4 && iD > iM) {
                if (!z) {
                    return childAt;
                }
                if (iG >= iM && iD <= i4) {
                    return childAt;
                }
                if (z2 && view == null) {
                    view = childAt;
                }
            }
            i2 += i5;
        }
        return view;
    }

    public int getChildCount() {
        RecyclerView.o oVar = this.layoutManager;
        if (oVar == null) {
            return 0;
        }
        return oVar.getChildCount();
    }

    public int getItemCount() {
        RecyclerView.o oVar = this.layoutManager;
        if (oVar == null) {
            return 0;
        }
        return oVar.getItemCount();
    }
}
