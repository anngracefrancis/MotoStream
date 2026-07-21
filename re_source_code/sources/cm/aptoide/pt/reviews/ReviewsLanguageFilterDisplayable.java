package cm.aptoide.pt.reviews;

import android.widget.Spinner;
import cm.aptoide.pt.R;
import cm.aptoide.pt.view.recycler.displayable.Displayable;

/* JADX INFO: loaded from: classes.dex */
public class ReviewsLanguageFilterDisplayable extends Displayable {
    private LanguageFilterSpinnerHelper languageFilterSpinnerHelper;
    private LanguageFilterSpinnerHelper.OnItemSelected onItemSelected;

    public ReviewsLanguageFilterDisplayable() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setup$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a(LanguageFilterHelper.LanguageFilter languageFilter) {
        this.onItemSelected.onItemSelected(languageFilter);
    }

    @Override // cm.aptoide.pt.view.recycler.displayable.Displayable
    protected Displayable.Configs getConfig() {
        return new Displayable.Configs(1, true);
    }

    public LanguageFilterSpinnerHelper.OnItemSelected getOnItemSelected() {
        return this.onItemSelected;
    }

    @Override // cm.aptoide.pt.view.recycler.displayable.Displayable
    public int getViewLayout() {
        return R.layout.reviews_language_filter;
    }

    public void setup(Spinner spinner) {
        if (this.languageFilterSpinnerHelper == null) {
            LanguageFilterSpinnerHelper languageFilterSpinnerHelper = new LanguageFilterSpinnerHelper(spinner);
            this.languageFilterSpinnerHelper = languageFilterSpinnerHelper;
            languageFilterSpinnerHelper.setup(new LanguageFilterSpinnerHelper.OnItemSelected() { // from class: cm.aptoide.pt.reviews.n
                @Override // cm.aptoide.pt.reviews.LanguageFilterSpinnerHelper.OnItemSelected
                public final void onItemSelected(LanguageFilterHelper.LanguageFilter languageFilter) {
                    this.a.a(languageFilter);
                }
            });
        }
    }

    public ReviewsLanguageFilterDisplayable(LanguageFilterSpinnerHelper.OnItemSelected onItemSelected) {
        this.onItemSelected = onItemSelected;
    }
}
