package sunger.net.org.library;

import android.view.View;
import android.webkit.WebView;

import me.everything.android.ui.overscroll.adapters.IOverScrollDecoratorAdapter;

/**
 * Created by sunger on 15/12/21.
 */
public class WebViewOverScrollDecorAdapter implements IOverScrollDecoratorAdapter {
    protected  WebView mView;

    public WebViewOverScrollDecorAdapter(WebView view) {
        mView = view;
    }

    @Override
    public View getView() {
        return mView;
    }

    @Override
    public boolean isInAbsoluteStart() {
         return mView.getScrollY()==0;
    }

    @Override
    public boolean isInAbsoluteEnd() {
        return false;
    }

}
