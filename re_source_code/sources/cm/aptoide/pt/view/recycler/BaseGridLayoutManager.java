package cm.aptoide.pt.view.recycler;

import android.content.Context;
import android.content.res.Resources;
import android.view.WindowManager;
import androidx.recyclerview.widget.GridLayoutManager;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.view.recycler.displayable.Displayable;
import cm.aptoide.pt.view.recycler.widget.WidgetFactory;

/* JADX INFO: loaded from: classes.dex */
public class BaseGridLayoutManager extends GridLayoutManager {
    private final Resources resources;
    private final WindowManager windowManager;

    private class SpanSizeLookup extends GridLayoutManager.c {
        private final BaseAdapter baseAdapter;

        public SpanSizeLookup(BaseAdapter baseAdapter) {
            this.baseAdapter = baseAdapter;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int getSpanSize(int i2) {
            Displayable displayable = this.baseAdapter.getDisplayable(i2);
            if (displayable == null) {
                return 1;
            }
            if (displayable.getSpanSize(BaseGridLayoutManager.this.windowManager, BaseGridLayoutManager.this.resources) <= BaseGridLayoutManager.this.getSpanCount()) {
                return displayable.getSpanSize(BaseGridLayoutManager.this.windowManager, BaseGridLayoutManager.this.resources);
            }
            CrashReport.getInstance().log(new IllegalArgumentException("Displayable " + displayable.getClass().getSimpleName() + " at position " + i2 + " spanSize > getSpanCount()! "));
            return BaseGridLayoutManager.this.getSpanCount();
        }
    }

    public BaseGridLayoutManager(Context context, BaseAdapter baseAdapter, Resources resources, WindowManager windowManager) {
        super(context, WidgetFactory.getColumnSize(resources, windowManager));
        this.resources = resources;
        this.windowManager = windowManager;
        setSpanSizeLookup(new SpanSizeLookup(baseAdapter));
    }
}
