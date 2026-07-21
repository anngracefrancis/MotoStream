package androidx.preference;

import android.R;
import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: PreferenceViewHolder.java */
/* JADX INFO: loaded from: classes.dex */
public class l extends RecyclerView.c0 {
    private final SparseArray<View> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f1862b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f1863c;

    l(View view) {
        super(view);
        SparseArray<View> sparseArray = new SparseArray<>(4);
        this.a = sparseArray;
        sparseArray.put(R.id.title, view.findViewById(R.id.title));
        sparseArray.put(R.id.summary, view.findViewById(R.id.summary));
        sparseArray.put(R.id.icon, view.findViewById(R.id.icon));
        int i2 = p.a;
        sparseArray.put(i2, view.findViewById(i2));
        sparseArray.put(R.id.icon_frame, view.findViewById(R.id.icon_frame));
    }

    public View a(int i2) {
        View view = this.a.get(i2);
        if (view != null) {
            return view;
        }
        View viewFindViewById = this.itemView.findViewById(i2);
        if (viewFindViewById != null) {
            this.a.put(i2, viewFindViewById);
        }
        return viewFindViewById;
    }

    public boolean b() {
        return this.f1862b;
    }

    public boolean c() {
        return this.f1863c;
    }

    public void d(boolean z) {
        this.f1862b = z;
    }

    public void e(boolean z) {
        this.f1863c = z;
    }
}
