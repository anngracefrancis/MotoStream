package cm.aptoide.pt.view.custom;

import android.content.Context;
import android.graphics.Canvas;
import androidx.core.content.a;
import androidx.recyclerview.widget.RecyclerView;
import cm.aptoide.pt.R;
import cm.aptoide.pt.themes.ThemeManager;

/* JADX INFO: loaded from: classes.dex */
public class HorizontalDividerItemDecoration extends DrawableItemDecoration {
    public HorizontalDividerItemDecoration(Context context, ThemeManager themeManager) {
        this(context, 0, themeManager);
    }

    @Override // cm.aptoide.pt.view.custom.DrawableItemDecoration, androidx.recyclerview.widget.RecyclerView.n
    public /* bridge */ /* synthetic */ void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.z zVar) {
        super.onDrawOver(canvas, recyclerView, zVar);
    }

    public HorizontalDividerItemDecoration(Context context, int i2, ThemeManager themeManager) {
        super(a.f(context, themeManager.getAttributeForTheme(R.attr.backgroundSecondary).resourceId), i2);
    }
}
