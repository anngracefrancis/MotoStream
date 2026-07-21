package cm.aptoide.pt.account.view.store;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import cm.aptoide.pt.R;
import cm.aptoide.pt.themes.StoreTheme;
import cm.aptoide.pt.themes.ThemeManager;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ThemeSelectorViewAdapter extends RecyclerView.g<ViewHolder> {
    private StoreTheme selectedStoreTheme;
    private final e.g.b.c<StoreTheme> storeThemePublishRelay;
    private final ThemeManager themeManager;
    private final List<StoreTheme> themes;

    public static final class ViewHolder extends RecyclerView.c0 {
        private static final int LAYOUT = 2131493121;
        private StoreTheme storeTheme;
        private ImageView storeThemeCheckMark;
        private ImageView storeThemeImage;
        private final e.g.b.c<StoreTheme> storeThemePublishRelay;

        public ViewHolder(View view, e.g.b.c<StoreTheme> cVar) {
            super(view);
            this.storeThemePublishRelay = cVar;
            bind(view);
        }

        private void bind(View view) {
            this.storeThemeImage = (ImageView) view.findViewById(R.id.theme_color);
            this.storeThemeCheckMark = (ImageView) view.findViewById(R.id.theme_checked);
            e.g.a.c.a.a(view).x(new rx.m.b() { // from class: cm.aptoide.pt.account.view.store.d0
                @Override // rx.m.b
                public final void call(Object obj) {
                    this.f3916f.a((Void) obj);
                }
            }).D0();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: lambda$bind$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void a(Void r2) {
            this.storeThemePublishRelay.call(this.storeTheme);
        }

        public void update(StoreTheme storeTheme, StoreTheme storeTheme2, int i2) {
            this.storeTheme = storeTheme;
            this.storeThemeImage.setBackgroundResource(i2);
            if (storeTheme == storeTheme2) {
                this.storeThemeCheckMark.setVisibility(0);
            } else {
                this.storeThemeCheckMark.setVisibility(8);
            }
        }
    }

    public ThemeSelectorViewAdapter(e.g.b.c<StoreTheme> cVar, List<StoreTheme> list, ThemeManager themeManager) {
        this.storeThemePublishRelay = cVar;
        this.themes = list;
        this.themeManager = themeManager;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        List<StoreTheme> list = this.themes;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public StoreTheme getSelectedTheme() {
        return this.selectedStoreTheme;
    }

    /* JADX INFO: renamed from: selectTheme, reason: merged with bridge method [inline-methods] */
    public void g(StoreTheme storeTheme) {
        this.selectedStoreTheme = storeTheme;
        notifyDataSetChanged();
    }

    public rx.e<StoreTheme> storeThemeSelection() {
        return this.storeThemePublishRelay.x(new rx.m.b() { // from class: cm.aptoide.pt.account.view.store.e0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f3918f.g((StoreTheme) obj);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void onBindViewHolder(ViewHolder viewHolder, int i2) {
        viewHolder.update(this.themes.get(i2), this.selectedStoreTheme, this.themeManager.getAttributeForTheme(this.themes.get(i2).getThemeName(), R.attr.themeSelectorItemBackground).resourceId);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.partial_store_theme_round_item, viewGroup, false), this.storeThemePublishRelay);
    }
}
