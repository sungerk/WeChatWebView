package sunger.net.org.library;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.webkit.WebView;
import android.widget.FrameLayout;

import me.everything.android.ui.overscroll.VerticalOverScrollBounceEffectDecorator;

/**
 * Created by sunger on 15/12/21.
 */
public class WeChatWebView extends FrameLayout {
    private WebView webView;
    private float touchDragRatioFwd;
    private float touchDragRatioBck;
    private float decelerateFactor;


    public WeChatWebView(Context context) {
        this(context, null);
    }

    public WeChatWebView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WeChatWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    @TargetApi(21)
    public WeChatWebView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(attrs);
    }

    private void initView(AttributeSet attrs) {
        if (attrs == null)
            return;
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs,
                R.styleable.WeChatWebView);
        int underViewId = typedArray.getResourceId(R.styleable.WeChatWebView_underViewLayout, -1);
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        if (underViewId != -1) {
            LayoutInflater.from(getContext()).inflate(underViewId, this);
        }
        webView = new WebView(getContext());
        addView(webView, params);
        touchDragRatioFwd = typedArray.getFloat(R.styleable.WeChatWebView_touchDragRatioFwd, 2f);
        touchDragRatioBck = typedArray.getFloat(R.styleable.WeChatWebView_touchDragRatioBck, VerticalOverScrollBounceEffectDecorator.DEFAULT_TOUCH_DRAG_MOVE_RATIO_BCK);
        decelerateFactor = typedArray.getFloat(R.styleable.WeChatWebView_decelerateFactor, VerticalOverScrollBounceEffectDecorator.DEFAULT_DECELERATE_FACTOR);
        new VerticalOverScrollBounceEffectDecorator(new WebViewOverScrollDecorAdapter(webView),
                touchDragRatioFwd, touchDragRatioBck, decelerateFactor);
    }

    public WebView getWebView() {
        return webView;
    }

}
