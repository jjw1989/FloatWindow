package com.sundy.floatutil;

import android.content.Context;
import android.util.SparseArray;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by sundy on 17-9-19.
 */

public class WindowCache {
    public Map<Class<? extends Context>,SparseArray<Window>> sWindows;
    public WindowCache(){
        sWindows=new HashMap<Class<? extends Context>,SparseArray<Window>>();
    }

    /**
     *
     返回与类和id相对应的窗口是否存在于高速缓存。
     * @param id 表示窗口的id
     * @param cls 与窗口相对应的类
     * @return 如果相应的class和id的窗口存在 缓存，如果不存在，则为false
     */
    public boolean isCached(int id,Class<? extends  Context> cls){
        return getCache(id,cls)!=null;
    }

    /**
     *从该缓存中返回的ID对应的窗口。
     * @param id 表示窗口的id
     * @param cls 窗口的实现类。
     * @return 窗口对应的ID是否存在于缓存中，或如果没有，则为null。
     */
    public Window getCache(int id,Class<? extends  Context>cls){
        SparseArray<Window> l2=sWindows.get(cls);
        if (l2==null){
            return null;
        }
        return l2.get(id);
    }

    /**
     * 添加相应的缓存中的ID窗口。
     * @param id 表示窗口的id
     * @param cls 窗口的实现类。
     * @param window  要放在缓存中的窗口
     */
    public void putCache(int id,Class<? extends Context>cls,Window window){
        SparseArray<Window> l2=sWindows.get(cls);
        if (l2==null){
            l2=new SparseArray<>();
            sWindows.put(cls,l2);
        }
        l2.put(id,window);
    }

    /**
     *
     * @param id 从缓存中删除对应的ID窗口。
     * @param cls 窗口的实现类。
     */
    public void removeCache(int id,Class<? extends Context> cls){
        SparseArray<Window> l2=sWindows.get(cls);
        if (l2!=null){
            l2.remove(id);
            if (l2.size()==0){
                sWindows.remove(cls);
            }
        }
    }

    /**
     *
     * @param cls 窗口的实现类。
     * @return 返回的缓存的大小
     */
    public int getCacheSize(Class<? extends Context> cls){
        SparseArray<Window> l2=sWindows.get(cls);
        if (l2==null){
            return 0;
        }
        return l2.size();
    }

    /**
     *
     * @param cls 窗口的实现类。
     * @return 表示缓存窗口的IDS
     */
    public Set<Integer> getCacheIds(Class<? extends Context> cls){
        SparseArray<Window> l2=sWindows.get(cls);
        if (l2==null){
           return new HashSet<>();
        }
        Set<Integer> keys=new HashSet<>();
        for (int i = 0; i <l2.size() ; i++) {
            keys.add(l2.keyAt(i));
        }
        return keys;
    }

    public void clear(Class<? extends Context> cls){
        SparseArray<Window> l2=sWindows.remove(cls);
        if (l2!=null && l2.size()>0){
            l2.clear();
        }
    }

    public int size(){
        return sWindows.size();
    }
}
