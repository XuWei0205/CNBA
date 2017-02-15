package com.hanyu.cnba.managers;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.hanyu.cnba.commons.GsonRequest;
import com.hanyu.cnba.commons.VolleyManager;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by hehuajia on 16/10/20.
 */

public class NetManager {

    public interface ResponseListener<T> {
        void onResponse(T response);

        void onErrorResponse(VolleyError error);

        void onAsyncResponse(T response);
    }

    public static <T> Request<T> doHttpGet(Context context, Map<String, String> headers, String url,
                                           Map<String, String> params,Class clazz,final ResponseListener<T> listener, final int timeout) {

            StringBuffer paramStr = new StringBuffer();
            if (params != null && params.size() > 0) {
                // param += “?”;
                Iterator ite = params.entrySet().iterator();
                while (ite.hasNext()) {
                    Map.Entry<String,String> entry = (Map.Entry) ite.next();
                    String key = entry.getKey();
                    String value = entry.getValue();
                    paramStr.append( key + "=" + value + "&");
                }
                paramStr.deleteCharAt(paramStr.length()-1);
                url += paramStr;
            }

        GsonRequest<T> request = new GsonRequest<T>(Request.Method.GET, url, clazz, headers, params, new Response.Listener<T>() {
            @Override
            public void onResponse(T response) {
                if (listener != null) {
                    listener.onResponse(response);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (listener != null) {
                    listener.onErrorResponse(error);
                }
            }
        }, new GsonRequest.AsyncCacheListener<T>() {
            @Override
            public void onAsyncCache(T response) {
                if (listener != null) {
                    listener.onAsyncResponse(response);
                }
            }
        }, timeout);

        VolleyManager.getInstance(context).getRequestQueue().add(request);
        return request;
    }

    public static <T> Request<T> doHttpGet(Context context, Map<String,String> headers, String url,
                                           Map<String, String> params,Class clazz,
                                           final ResponseListener<T> listener) {
        return doHttpGet(context, headers, url, params, clazz, listener, 0);
    }

    public static <T> Request<T> doHttpPost(Context context, Map<String, String> headers, String url,
                                           Map<String, String> params,Class clazz,final ResponseListener<T> listener, final int timeout) {
        GsonRequest<T> request = new GsonRequest<T>(Request.Method.POST, url, clazz, headers, params, new Response.Listener<T>() {
            @Override
            public void onResponse(T response) {
                if (listener != null) {
                    listener.onResponse(response);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (listener != null) {
                    listener.onErrorResponse(error);
                }
            }
        }, new GsonRequest.AsyncCacheListener<T>() {
            @Override
            public void onAsyncCache(T response) {
                if (listener != null) {
                    listener.onAsyncResponse(response);
                }
            }
        }, timeout);

        VolleyManager.getInstance(context).getRequestQueue().add(request);
        return request;
    }

    public static <T> Request<T> doHttpPost(Context context, Map<String, String> headers, String url,
                                           Map<String, String> params,Class clazz,final ResponseListener<T> listener) {
        return doHttpPost(context, headers, url, params, clazz, listener, 0);
    }
}
